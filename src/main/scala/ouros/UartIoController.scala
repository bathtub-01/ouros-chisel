package ouros

import axilib._
import chisel3._
import chisel3.util._

/**
 * AXI4-Lite slave register bank -> Zynq UltraScale+ PS UART1 AXI4-Lite master.
 * Independent of the Ouros core. Both bus sides are 32 bits.
 *
 * Core-visible register offsets (identical to the simulator):
 *   0x00 RX_DATA (read, BLOCKS until a byte is available)
 *   0x04 TX_DATA (write low byte, completes after UART FIFO write BRESP)
 *   0x08 STATUS  (read: bit 0 RX_READY, bit 1 TX_READY)
 *   0x0c CONTROL (local read/write scratch register for future expansion)
 *
 * Hardware-facing PS UART uses the Cadence XUartPs register map, NOT UART Lite.
 * The PS firmware/FSBL must configure UART1 MIO pins/reference clock and the
 * PL-to-PS AXI path before this controller can access the registers.
 * One core-side transaction is accepted at a time; read RX_DATA deliberately
 * backpressures until a byte arrives. No interrupts in this milestone.
 */
class UartIoController(
    uartBaseAddr: BigInt = BigInt("ff010000", 16),
    baudGenerator: Int = 62,
    baudDivider: Int = 13,
) extends Module {
  require(uartBaseAddr >= 0 && uartBaseAddr <= BigInt("ffffffbb", 16))
  require(baudGenerator >= 1 && baudGenerator <= 65535)
  require(baudDivider >= 4 && baudDivider <= 255)
  private val p = Axi4LiteParams(32, 32)
  val io = IO(new Bundle {
    val S_AXI = Axi4LiteSlave(p)
    val M_AXI = Axi4LiteMaster(p)
  })

  private val crAddr      = (uartBaseAddr + 0x00).U(32.W)
  private val mrAddr      = (uartBaseAddr + 0x04).U(32.W)
  private val baudGenAddr = (uartBaseAddr + 0x18).U(32.W)
  private val statusAddr  = (uartBaseAddr + 0x2c).U(32.W)
  private val fifoAddr    = (uartBaseAddr + 0x30).U(32.W)
  private val baudDivAddr = (uartBaseAddr + 0x34).U(32.W)

  private val initAddr = VecInit(Seq(crAddr, mrAddr, baudGenAddr, baudDivAddr, crAddr))
  private val initData = VecInit(Seq(
    0x2b.U(32.W), // reset and disable RX/TX
    0x20.U(32.W), // normal 8N1, ref clock
    baudGenerator.U(32.W),
    baudDivider.U(32.W),
    0x14.U(32.W), // TX_EN | RX_EN (previous dump-only design disabled RX)
  ))

  object State extends ChiselEnum {
    val Idle, CollectWrite, DecodeWrite, DecodeRead,
        InitWrite, InitB, StatusAR, StatusR, RxAR, RxR, TxWrite, TxB,
        ReplyB, ReplyR = Value
  }
  object Service extends ChiselEnum { val Tx, Rx, Status = Value }
  import State._

  val state = RegInit(Idle)
  val service = RegInit(Service.Status)
  val configured = RegInit(false.B)
  val initIndex = RegInit(0.U(3.W))
  val awHeld = RegInit(false.B)
  val wHeld = RegInit(false.B)
  val awAddr = RegInit(0.U(32.W))
  val wData = RegInit(0.U(32.W))
  val wStrb = RegInit(0.U(4.W))
  val rAddr = RegInit(0.U(32.W))
  val rData = RegInit(0.U(32.W))
  val bResp = RegInit(AxiResp.OKAY)
  val rResp = RegInit(AxiResp.OKAY)
  val control = RegInit(0.U(32.W))
  val masterAwSent = RegInit(false.B)
  val masterWSent = RegInit(false.B)

  // Accept AW and W independently. Give writes priority over AR on collisions.
  io.S_AXI.AWREADY := (state === Idle || state === CollectWrite) && !awHeld
  io.S_AXI.WREADY := (state === Idle || state === CollectWrite) && !wHeld
  io.S_AXI.ARREADY := state === Idle && !io.S_AXI.AWVALID && !io.S_AXI.WVALID
  io.S_AXI.BVALID := state === ReplyB
  io.S_AXI.BRESP := bResp
  io.S_AXI.RVALID := state === ReplyR
  io.S_AXI.RDATA := rData
  io.S_AXI.RRESP := rResp

  when(io.S_AXI.awFire) { awAddr := io.S_AXI.AWADDR; awHeld := true.B }
  when(io.S_AXI.wFire) {
    wData := io.S_AXI.WDATA
    wStrb := io.S_AXI.WSTRB
    wHeld := true.B
  }
  when(io.S_AXI.arFire) { rAddr := io.S_AXI.ARADDR }

  io.M_AXI.AWADDR := Mux(state === InitWrite || state === InitB,
    initAddr(initIndex), fifoAddr)
  io.M_AXI.AWPROT := 0.U
  io.M_AXI.AWVALID := (state === InitWrite || state === TxWrite) && !masterAwSent
  io.M_AXI.WDATA := Mux(state === InitWrite || state === InitB,
    initData(initIndex), Cat(0.U(24.W), wData(7, 0)))
  io.M_AXI.WSTRB := "hf".U
  io.M_AXI.WVALID := (state === InitWrite || state === TxWrite) && !masterWSent
  io.M_AXI.BREADY := state === InitB || state === TxB
  io.M_AXI.ARADDR := Mux(state === RxAR || state === RxR, fifoAddr, statusAddr)
  io.M_AXI.ARPROT := 0.U
  io.M_AXI.ARVALID := state === StatusAR || state === RxAR
  io.M_AXI.RREADY := state === StatusR || state === RxR

  def statusOrInit(): Unit = {
    masterAwSent := false.B
    masterWSent := false.B
    state := Mux(configured, StatusAR, InitWrite)
  }
  def startMasterWrite(): Unit = {
    when(io.M_AXI.awFire) { masterAwSent := true.B }
    when(io.M_AXI.wFire) { masterWSent := true.B }
    when((masterAwSent || io.M_AXI.awFire) &&
         (masterWSent || io.M_AXI.wFire)) {
      state := Mux(state === InitWrite, InitB, TxB)
    }
  }

  switch(state) {
    is(Idle) {
      when(io.S_AXI.awFire || io.S_AXI.wFire) {
        state := CollectWrite
      }.elsewhen(io.S_AXI.arFire) {
        state := DecodeRead
      }
    }
    is(CollectWrite) {
      when(awHeld && wHeld) { state := DecodeWrite }
    }
    is(DecodeWrite) {
      awHeld := false.B
      wHeld := false.B
      bResp := AxiResp.OKAY
      when(awAddr(31, 2) === 1.U && wStrb(0)) { // TX_DATA
        service := Service.Tx
        statusOrInit()
      }.otherwise {
        when(awAddr(31, 2) === 3.U) { // CONTROL: byte strobes
          val mask = Cat((3 to 0 by -1).map(i => Fill(8, wStrb(i))))
          control := (control & ~mask) | (wData & mask)
        }
        state := ReplyB
      }
    }
    is(DecodeRead) {
      rResp := AxiResp.OKAY
      when(rAddr(31, 2) === 0.U) {
        service := Service.Rx; statusOrInit()
      }.elsewhen(rAddr(31, 2) === 2.U) {
        service := Service.Status; statusOrInit()
      }.elsewhen(rAddr(31, 2) === 3.U) {
        rData := control; state := ReplyR
      }.otherwise {
        rData := 0.U; state := ReplyR
      }
    }
    is(InitWrite) { startMasterWrite() }
    is(InitB) {
      when(io.M_AXI.bFire) {
        masterAwSent := false.B
        masterWSent := false.B
        when(io.M_AXI.BRESP =/= AxiResp.OKAY) {
          state := InitWrite // retry initialization
        }.elsewhen(initIndex === 4.U) {
          configured := true.B
          state := StatusAR
        }.otherwise {
          initIndex := initIndex + 1.U
          state := InitWrite
        }
      }
    }
    is(StatusAR) {
      when(io.M_AXI.arFire) { state := StatusR }
    }
    is(StatusR) {
      when(io.M_AXI.rFire) {
        when(io.M_AXI.RRESP =/= AxiResp.OKAY) {
          state := StatusAR
        }.otherwise {
          switch(service) {
            is(Service.Status) {
              rData := Cat(0.U(30.W), !io.M_AXI.RDATA(4), !io.M_AXI.RDATA(1))
              state := ReplyR
            }
            is(Service.Tx) {
              when(io.M_AXI.RDATA(4)) { state := StatusAR }
                .otherwise {
                  masterAwSent := false.B
                  masterWSent := false.B
                  state := TxWrite
                }
            }
            is(Service.Rx) {
              when(io.M_AXI.RDATA(1)) { state := StatusAR }
                .otherwise { state := RxAR }
            }
          }
        }
      }
    }
    is(RxAR) { when(io.M_AXI.arFire) { state := RxR } }
    is(RxR) {
      when(io.M_AXI.rFire) {
        when(io.M_AXI.RRESP === AxiResp.OKAY) {
          rData := Cat(0.U(24.W), io.M_AXI.RDATA(7, 0))
          state := ReplyR
        }.otherwise { state := StatusAR }
      }
    }
    is(TxWrite) { startMasterWrite() }
    is(TxB) {
      when(io.M_AXI.bFire) {
        when(io.M_AXI.BRESP === AxiResp.OKAY) {
          state := ReplyB
        }.otherwise { state := StatusAR } // retain byte for retry
      }
    }
    is(ReplyB) { when(io.S_AXI.bFire) { state := Idle } }
    is(ReplyR) { when(io.S_AXI.rFire) { state := Idle } }
  }
}

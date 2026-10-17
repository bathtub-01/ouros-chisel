package ouros

import axilib._
import chisel3._
import chisel3.util._

/**
 * Drives the Zynq UltraScale+ *PS UART1* (Cadence/XUartPs) through a
 * PL-to-PS AXI4-Lite path, normally S_AXI_LPD via AXI SmartConnect.
 *
 * This is NOT the PL AXI UART Lite IP; it has a different register map.
 *
 * The FSBL/PS initialization must enable UART1's MIO routing, clock and reset,
 * and the PL-to-PS AXI path.  This module then programs the UART registers
 * itself, so an Arm UART driver is not needed at runtime.
 *
 * IMPORTANT: with the defaults below, configure the PS UART1 *reference*
 * clock (not pl_clk0 or the AXI clock) to 100 MHz in Vivado, so the serial
 * output is approximately 115200 baud.  Output is 8 data bits, no parity,
 * one stop bit.  No hardware flow control is used.
 *
 * Initialization is deferred until the first output byte arrives, avoiding
 * interference with any remaining FSBL UART console activity during boot.
 *
 * One AXI transaction is outstanding at a time.  AW and W can handshake
 * independently.  An AXI error retries the current initialization write or
 * UART byte; there is no timeout/error output in this first prototype.
 */
class PsUartAxiController(
    uartBaseAddr: BigInt = BigInt("ff010000", 16),
    baudGenerator: Int = 62,
    baudDivider: Int = 13,
) extends Module {
  require(uartBaseAddr >= 0 && uartBaseAddr <= BigInt("ffffffbb", 16),
    "PS UART base must fit in 32 bits with register offsets")
  require(baudGenerator >= 1 && baudGenerator <= 65535,
    "PS UART baud generator must be 1..65535")
  require(baudDivider >= 4 && baudDivider <= 255,
    "PS UART baud divider must be 4..255")

  private val axiParams = Axi4LiteParams(addrWidth = 32, dataWidth = 32)

  val io = IO(new Bundle {
    val tx  = Flipped(Decoupled(UInt(8.W)))
    val axi = Axi4LiteMaster(axiParams)
  })

  // ZynqMP PS UART registers (XUartPs), *not* AXI UART Lite offsets.
  private val crAddr      = uartBaseAddr + 0x00
  private val mrAddr      = uartBaseAddr + 0x04
  private val baudGenAddr = uartBaseAddr + 0x18
  private val statusAddr  = (uartBaseAddr + 0x2c).U(32.W)
  private val fifoAddr    = (uartBaseAddr + 0x30).U(32.W)
  private val baudDivAddr = uartBaseAddr + 0x34

  // Initialize UART: disable/reset TX/RX, select normal 8N1,
  // program the baud-rate divisors, enable TX (leave RX disabled).
  // For a 100 MHz UART reference clock, 100e6 / (62 * (13+1))
  // = 115207.37 baud (about +0.0064% relative to 115200).
  private val initAddrs = VecInit(Seq(
    crAddr, mrAddr, baudGenAddr, baudDivAddr, crAddr,
  ).map(_.U(32.W)))
  private val initValues = VecInit(Seq(
    0x2b, // CR: TX_DIS | RX_DIS | TXRST | RXRST
    0x20, // MR: normal, 8 bits, no parity, 1 stop, uart_ref_clk
    baudGenerator,
    baudDivider,
    0x18, // CR: TX_EN | RX_DIS
  ).map(_.U(32.W)))

  private object State extends ChiselEnum {
    val InitWrite, InitResponse, Idle,
        ReadStatusAddr, ReadStatusData, WriteByte, WriteResponse = Value
  }
  import State._

  private val state       = RegInit(Idle)
  private val configured  = RegInit(false.B)
  private val initIndex   = RegInit(0.U(3.W))
  private val byteReg    = RegInit(0.U(8.W))
  private val awSent     = RegInit(false.B)
  private val wSent      = RegInit(false.B)

  // Accept the first byte and hold it while configuring the UART.
  // Subsequent bytes use the ordinary status-poll/write sequence.
  io.tx.ready := state === Idle
  when(io.tx.fire) {
    byteReg := io.tx.bits
    state   := Mux(configured, ReadStatusAddr, InitWrite)
  }

  // Safe AXI defaults; request signals are held until a handshake.
  io.axi.AWADDR  := Mux(state === InitWrite || state === InitResponse,
                         initAddrs(initIndex), fifoAddr)
  io.axi.AWPROT  := 0.U
  io.axi.AWVALID := false.B
  io.axi.WDATA   := Mux(state === InitWrite || state === InitResponse,
                         initValues(initIndex), Cat(0.U(24.W), byteReg))
  io.axi.WSTRB   := "hf".U
  io.axi.WVALID  := false.B
  io.axi.BREADY  := false.B

  io.axi.ARADDR  := statusAddr
  io.axi.ARPROT  := 0.U
  io.axi.ARVALID := false.B
  io.axi.RREADY  := false.B

  switch(state) {
    is(InitWrite) {
      io.axi.AWVALID := !awSent
      io.axi.WVALID  := !wSent
      val awFire = io.axi.awFire
      val wFire  = io.axi.wFire
      when(awFire) { awSent := true.B }
      when(wFire)  { wSent  := true.B }
      when((awSent || awFire) && (wSent || wFire)) {
        state := InitResponse
      }
    }

    is(InitResponse) {
      io.axi.BREADY := true.B
      when(io.axi.bFire) {
        awSent := false.B
        wSent  := false.B
        when(io.axi.BRESP === AxiResp.OKAY) {
          when(initIndex === 4.U) {
            configured := true.B
            state := ReadStatusAddr
          }.otherwise {
            initIndex := initIndex + 1.U
            state := InitWrite
          }
        }.otherwise {
          // Reissue the same initialization register write.
          state := InitWrite
        }
      }
    }

    is(Idle) {
      // A formatter byte enters through io.tx.fire, handled above.
    }

    is(ReadStatusAddr) {
      io.axi.ARVALID := true.B
      when(io.axi.arFire) { state := ReadStatusData }
    }

    is(ReadStatusData) {
      io.axi.RREADY := true.B
      when(io.axi.rFire) {
        when(io.axi.RRESP =/= AxiResp.OKAY || io.axi.RDATA(4)) {
          // XUARTPS_SR_TXFULL = 0x10 (bit 4); retry failed/full reads.
          state := ReadStatusAddr
        }.otherwise {
          awSent := false.B
          wSent  := false.B
          state  := WriteByte
        }
      }
    }

    is(WriteByte) {
      io.axi.AWVALID := !awSent
      io.axi.WVALID  := !wSent
      val awFire = io.axi.awFire
      val wFire  = io.axi.wFire
      when(awFire) { awSent := true.B }
      when(wFire)  { wSent  := true.B }
      when((awSent || awFire) && (wSent || wFire)) {
        state := WriteResponse
      }
    }

    is(WriteResponse) {
      io.axi.BREADY := true.B
      when(io.axi.bFire) {
        awSent := false.B
        wSent  := false.B
        when(io.axi.BRESP === AxiResp.OKAY) {
          state := Idle
        }.otherwise {
          // Retain byteReg; poll again before retrying the FIFO write.
          state := ReadStatusAddr
        }
      }
    }
  }
}

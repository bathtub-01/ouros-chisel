package ouros

import axilib._
import chisel3._
import chisel3.util._

/**
 * Consumes the byte stream produced by UartDumpController and writes it into
 * an AMD/Xilinx AXI UART Lite instance.
 *
 * For every byte:
 *   1. Read STAT_REG (base + 0x08).
 *   2. Wait until Tx FIFO Full (bit 3) is clear.
 *   3. Write the byte to Tx FIFO (base + 0x04).
 *   4. Wait for the AXI write response, then accept the next byte.
 *
 * Only one AXI transaction is outstanding at a time. This is deliberately
 * conservative: the result message is tiny and UART throughput dominates by
 * many orders of magnitude.
 *
 * A failed read or write response is retried. In particular, a write SLVERR
 * can be caused by the UART Lite TX FIFO being full; the controller retains
 * the byte and goes back to polling the status register.
 */
class UartLiteAxiController(uartBaseAddr: BigInt = 0) extends Module {
  require(
    uartBaseAddr >= 0 && uartBaseAddr <= BigInt("fffffff7", 16),
    s"UART Lite base address 0x${uartBaseAddr.toString(16)} leaves no room for the UART register offsets",
  )

  private val axiParams = Axi4LiteParams(addrWidth = 32, dataWidth = 32)

  val io = IO(new Bundle {
    val tx  = Flipped(Decoupled(UInt(8.W)))
    val axi = Axi4LiteMaster(axiParams)
  })

  private val txFifoAddr = (uartBaseAddr + 0x04).U(32.W)
  private val statusAddr = (uartBaseAddr + 0x08).U(32.W)

  object State extends ChiselEnum {
    val Idle, ReadStatusAddr, ReadStatusData, WriteByte, WriteResponse = Value
  }
  import State._

  val state   = RegInit(Idle)
  val byteReg = RegInit(0.U(8.W))

  // AXI write address and write data are independent channels. Track each
  // handshake so either channel may apply back-pressure independently.
  val awSent = RegInit(false.B)
  val wSent  = RegInit(false.B)

  // Consume exactly one formatter byte into a local register. The formatter
  // may then advance while this controller polls/writes the retained byte.
  io.tx.ready := state === Idle

  when(io.tx.fire) {
    byteReg := io.tx.bits
    state   := ReadStatusAddr
  }

  // Safe defaults for all AXI channels.
  io.axi.AWADDR  := txFifoAddr
  io.axi.AWPROT  := 0.U
  io.axi.AWVALID := false.B

  io.axi.WDATA  := Cat(0.U(24.W), byteReg)
  io.axi.WSTRB  := "hf".U
  io.axi.WVALID := false.B

  io.axi.BREADY := false.B

  io.axi.ARADDR  := statusAddr
  io.axi.ARPROT  := 0.U
  io.axi.ARVALID := false.B

  io.axi.RREADY := false.B

  switch(state) {
    is(Idle) {
      // All work is initiated by io.tx.fire above.
    }

    is(ReadStatusAddr) {
      io.axi.ARVALID := true.B
      when(io.axi.ARREADY) {
        state := ReadStatusData
      }
    }

    is(ReadStatusData) {
      io.axi.RREADY := true.B
      when(io.axi.RVALID) {
        when(io.axi.RRESP =/= AxiResp.OKAY) {
          // Retry a failed status read.
          state := ReadStatusAddr
        }.elsewhen(io.axi.RDATA(3)) {
          // Tx FIFO Full: poll again.
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

      // Include same-cycle handshakes rather than waiting an extra cycle for
      // awSent/wSent registers to update.
      when((awSent || awFire) && (wSent || wFire)) {
        state := WriteResponse
      }
    }

    is(WriteResponse) {
      io.axi.BREADY := true.B
      when(io.axi.BVALID) {
        when(io.axi.BRESP === AxiResp.OKAY) {
          state := Idle
        }.otherwise {
          // Retain byteReg and retry after polling the FIFO again.
          state := ReadStatusAddr
        }
      }
    }
  }
}

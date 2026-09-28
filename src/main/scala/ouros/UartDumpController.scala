package ouros

import chisel3._
import chisel3.util._

/**
 * Formats one 32-bit Ouros result as an ASCII hexadecimal line.
 *
 * The emitted byte stream is:
 *
 *   0xXXXXXXXX\r\n
 *
 * `result.valid` is allowed to remain high after completion.  The controller
 * accepts it only once after reset and then holds each output byte until the
 * downstream UART interface raises `tx.ready`.
 */
class UartDumpController extends Module {
  val io = IO(new Bundle {
    val result = Flipped(Valid(UInt(32.W)))
    val tx     = Decoupled(UInt(8.W))
    val busy   = Output(Bool())
  })

  private val lastChar = 11.U(4.W)

  val seenResult = RegInit(false.B)
  val active     = RegInit(false.B)
  val resultReg  = RegInit(0.U(32.W))
  val charIdx    = RegInit(0.U(4.W))

  // The Ouros result interface is sticky, so consume it only once.
  when(io.result.valid && !seenResult) {
    seenResult := true.B
    active     := true.B
    resultReg  := io.result.bits
    charIdx    := 0.U
  }

  def hexAscii(nibble: UInt): UInt =
    Mux(nibble < 10.U, "h30".U(8.W) + nibble, "h37".U(8.W) + nibble)

  val nextByte = WireDefault(0.U(8.W))
  switch(charIdx) {
    is(0.U)  { nextByte := "h30".U } // '0'
    is(1.U)  { nextByte := "h78".U } // 'x'
    is(2.U)  { nextByte := hexAscii(resultReg(31, 28)) }
    is(3.U)  { nextByte := hexAscii(resultReg(27, 24)) }
    is(4.U)  { nextByte := hexAscii(resultReg(23, 20)) }
    is(5.U)  { nextByte := hexAscii(resultReg(19, 16)) }
    is(6.U)  { nextByte := hexAscii(resultReg(15, 12)) }
    is(7.U)  { nextByte := hexAscii(resultReg(11, 8)) }
    is(8.U)  { nextByte := hexAscii(resultReg(7, 4)) }
    is(9.U)  { nextByte := hexAscii(resultReg(3, 0)) }
    is(10.U) { nextByte := "h0d".U } // '\r'
    is(11.U) { nextByte := "h0a".U } // '\n'
  }

  io.tx.valid := active
  io.tx.bits  := nextByte
  io.busy     := active

  when(io.tx.fire) {
    when(charIdx === lastChar) {
      active := false.B
    }.otherwise {
      charIdx := charIdx + 1.U
    }
  }
}

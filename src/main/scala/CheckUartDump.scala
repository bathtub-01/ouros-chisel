import chisel3._
import chisel3.simulator.ChiselSim

import ouros.UartDumpController

/**
 * Unit check for the step-4 UART formatter.
 *
 * Usage:
 *   sbt "runMain CheckUartDump"
 */
object CheckUartDump extends App with ChiselSim {
  simulate(
    new UartDumpController,
    firtoolOpts = Array("-disable-all-randomization"),
    chiselOpts = Array("--warn-conf", "any:s"),
    subdirectory = Some("uart-dump-check"),
  ) { dut =>
    dut.io.result.valid.poke(false.B)
    dut.io.result.bits.poke(0.U)
    dut.io.tx.ready.poke(false.B)
    dut.clock.step(2)

    dut.io.result.bits.poke("h89abcdef".U)
    dut.io.result.valid.poke(true.B)
    dut.clock.step()
    dut.io.result.valid.poke(false.B)

    val expected = "0x89ABCDEF\r\n".map(_.toInt)

    // Exercise back-pressure once: the first byte must remain stable until
    // ready is asserted.
    dut.io.tx.valid.expect(true.B)
    dut.io.tx.bits.expect('0'.toInt.U)
    dut.clock.step(2)
    dut.io.tx.valid.expect(true.B)
    dut.io.tx.bits.expect('0'.toInt.U)

    dut.io.tx.ready.poke(true.B)
    expected.foreach { byte =>
      dut.io.tx.valid.expect(true.B)
      dut.io.tx.bits.expect(byte.U)
      dut.clock.step()
    }

    dut.io.tx.valid.expect(false.B)
    dut.io.busy.expect(false.B)

    println()
    println("==============================================")
    println("UART dump controller check passed")
    println("  input            : 0x89ABCDEF")
    println("  emitted          : 0x89ABCDEF\\r\\n")
    println("==============================================")
  }
}

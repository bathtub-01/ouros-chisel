import chisel3._
import chisel3.simulator.ChiselSim

import java.nio.file.Paths

import benchmarks.Fib
import ouros._

/**
 * End-to-end check for the final-result interface added to the FPGA-style core.
 *
 * Runs the existing Fib benchmark (fib 17), waits for Ouros to finish, then
 * checks that the latched first Atom of the final App is exposed as the signed
 * 32-bit integer 2584.
 *
 * Usage:
 *   sbt "runMain CheckResult"
 */
object CheckResult extends App with ChiselSim {
  private val benchmark = Fib
  private val imageDir  = Paths.get("simu-out", "final-result-check")

  // Reuse the FPGA program-image path.  Force absolute .mem filenames so the
  // Verilator workspace can always find them regardless of its subdirectory.
  private val writtenProgram = ProgramImageWriter.write(benchmark, imageDir)
  private val program = writtenProgram.copy(
    heapFile = imageDir.resolve("heap.mem").toAbsolutePath.normalize.toString,
    combFile = imageDir.resolve("comb.mem").toAbsolutePath.normalize.toString,
  )

  var cycles = -2 // keep the same convention as the existing benchmark runner

  simulate(
    new Ouros(program),
    firtoolOpts = Array("-disable-all-randomization"),
    chiselOpts = Array("--warn-conf", "any:s"),
    subdirectory = Some("final-result-check"),
  ) { dut =>
    dut.clock.step(3)

    dut.io.result_valid.expect(false.B)

    dut.io.start.poke(true.B)
    dut.clock.step()
    dut.io.start.poke(false.B)

    while (!dut.io.done.peekBoolean() && cycles <= 1_000_000) {
      dut.clock.step()
      cycles += 1
    }

    require(dut.io.done.peekBoolean(), "Ouros did not finish within 1,000,000 cycles")
    dut.io.result_valid.expect(true.B)
    dut.io.result.expect(2584.U)

    println()
    println("==============================================")
    println("Ouros final-result check passed")
    println(s"  benchmark        : fib")
    println(s"  elapsed cycles   : $cycles")
    println(s"  final result     : ${dut.io.result.peek().litValue}")
    println("==============================================")
  }
}

import chisel3._
import chisel3.simulator.ChiselSim

import java.nio.file.{Path, Paths}

import benchmarks._
import ouros._

/**
 * Keep `sbt run` useful as the FPGA artifact generator.
 *
 * Preferred explicit commands:
 *
 *   sbt "runMain Generate fib"
 *   sbt "runMain Run fib"
 */
object Main {
  def main(args: Array[String]): Unit =
    Generate.main(args)
}

/**
 * Run the pre-initialised FPGA version of Ouros through ChiselSim/Verilator.
 *
 * This deliberately exercises the same path as the FPGA build:
 *
 *   Scala benchmark image
 *       -> heap.mem / comb.mem
 *       -> OurosFpga
 *       -> internal GC bootstrap
 *       -> start/done
 *
 * Therefore it is useful for distinguishing an FPGA/Vivado problem from a
 * problem in the new pre-initialised-memory / startup path itself.
 *
 * Usage:
 *
 *   sbt "runMain Run fib"
 *
 * The reported cycle count is measured from the clock edge on which `start`
 * is sampled high to the first cycle in which `done` is observed high.
 */
object Run extends App with ChiselSim {

  private val benchmarks: Map[String, Benchmark] = Map(
    "adjoxo"    -> Adjoxo,
    "braun"     -> Braun,
    "clausify"  -> Clausify,
    "countdown" -> Countdown,
    "fib"       -> Fib,
    "mss"       -> Mss,
    "queens"    -> Queens,
    "queens2"   -> Queens2,
    "sumeuler"  -> SumEuler,
    "while"     -> Whilex,
  )

  private val TimeoutCycles = 5_000_000L

  private def usage(): Nothing = {
    val names = benchmarks.keys.toSeq.sorted.mkString(", ")
    System.err.println(
      s"""Usage: sbt "runMain Run <benchmark>"
         |Benchmarks: $names
         |""".stripMargin
    )
    sys.exit(1)
  }

  if (args.length != 1) usage()

  private val name = args(0).toLowerCase
  private val benchmark =
    benchmarks.getOrElse(
      name, {
        System.err.println(s"Unknown benchmark: ${args(0)}")
        usage()
      }
    )

  /*
   * Generate exactly the same memory images used by the FPGA flow.
   *
   * ProgramImageWriter intentionally returns relative file names for movable
   * Vivado artifact directories.  ChiselSim runs Verilator from its own
   * workspace, however, so use absolute paths here to make $readmemh resolve
   * unambiguously.
   */
  private val imageDir: Path =
    Paths.get("fpga-sim", name).toAbsolutePath.normalize

  private val generatedProgram =
    ProgramImageWriter.write(benchmark, imageDir)

  private val simulationProgram =
    generatedProgram.copy(
      heapFile = imageDir.resolve("heap.mem").toString,
      combFile = imageDir.resolve("comb.mem").toString,
    )

  println(s"Running FPGA-style Chisel simulation for '$name'")
  println(s"  heap image : ${simulationProgram.heapFile}")
  println(s"  comb image : ${simulationProgram.combFile}")
  println(s"  heap cells : ${simulationProgram.heapWords}")

  var elapsedCycles = 0L

  // OurosFpga is a RawModule because it deliberately exposes its clock and
  // has no external reset. ChiselSim's `simulate` API only accepts Module;
  // use `simulateRaw` here so the internal FPGA-style PowerOnReset is what
  // initializes the core.
  simulateRaw(
    new OurosFpga(simulationProgram),
    firtoolOpts = Array("-disable-all-randomization"),
    chiselOpts = Array("--warn-conf", "any:s"),
    subdirectory = Some(s"fpga-$name"),
  ) { dut =>
    /*
     * OurosFpga has an internal FPGA-style power-on reset generator rather
     * than an external reset pin.  Give it several clocks to finish before
     * presenting start.
     */
    dut.start.poke(false.B)
    dut.clock.step(5)

    /*
     * Present start across one rising edge.  This edge is the reference point
     * for the reported latency.
     */
    dut.start.poke(true.B)
    dut.clock.step()
    dut.start.poke(false.B)

    while (!dut.done.peekBoolean() && elapsedCycles < TimeoutCycles) {
      dut.clock.step()
      elapsedCycles += 1
    }

    if (!dut.done.peekBoolean()) {
      throw new RuntimeException(
        s"Ouros did not finish within $TimeoutCycles cycles"
      )
    }

    /*
     * done is latched by Ouros, so stepping once more is safe and also checks
     * the intended FPGA-visible behaviour.
     */
    dut.clock.step()
    require(
      dut.done.peekBoolean(),
      "done did not remain high after completion"
    )
  }

  println()
  println("==============================================")
  println("Ouros FPGA-style Chisel simulation finished")
  println(s"  benchmark        : $name")
  println(s"  elapsed cycles   : $elapsedCycles")
  println(f"  elapsed time     : ${elapsedCycles / 100.0}%.3f us @ 100 MHz")
  println("==============================================")
}

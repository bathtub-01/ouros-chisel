import _root_.circt.stage.ChiselStage

import java.nio.file.{Path, Paths}

import benchmarks._
import ouros._
/**
 * FPGA artifact generator.
 *
 * Usage:
 *   sbt "runMain Generate fib"
 *   sbt "runMain Generate queens2 fpga-gen/queens2"
 */
object Generate {
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
    "uart"      -> Uart,
  )
  private def usage(): Nothing = {
    val names = benchmarks.keys.toSeq.sorted.mkString(", ")
    System.err.println(
      s"""Usage: sbt "runMain Generate <benchmark> [output-dir]"
         |Benchmarks: $names
         |""".stripMargin
    )
    sys.exit(1)
  }

  def main(args: Array[String]): Unit = {
    if (args.length < 1 || args.length > 2) usage()
    val name = args(0).toLowerCase
    val benchmark =
      benchmarks.getOrElse(
        name, {
          System.err.println(s"Unknown benchmark: ${args(0)}")
          usage()
        }
      )

    val outDir: Path =
      if (args.length == 2) Paths.get(args(1))
      else Paths.get("fpga-gen", name)

    val program = ProgramImageWriter.write(benchmark, outDir)
    ChiselStage.emitSystemVerilogFile(
      new OurosFpga(program),
      Array("--target-dir", outDir.toString),
      firtoolOpts = Array(
        "-disable-all-randomization",
        "-strip-debug-info",
      ),
    )
    // Generate the independent controller into the same directory. Its module
    // remains a separate top and can be packaged as a standalone Vivado IP.
    ChiselStage.emitSystemVerilogFile(
      new UartIoControllerFpga(),
      Array("--target-dir", outDir.toString),
      firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info"),
    )
    println()
    println(s"Generated Ouros FPGA artifacts for '$name':")
    println(s"  directory : ${outDir.toAbsolutePath.normalize}")
    println(s"  core top  : OurosFpga")
    println(s"  UART top  : UartIoControllerFpga")
    println(s"  heap image: ${outDir.resolve("heap.mem")}")
    println(s"  comb image: ${outDir.resolve("comb.mem")}")
    println(s"  heap cells: ${program.heapWords}")
    println()
    println("Add every generated *.sv plus heap.mem and comb.mem to Vivado.")
    println("Connect OurosFpga.M_AXI to UartIoControllerFpga.S_AXI in BD.")
    println("Connect controller M_AXI through SmartConnect to PS S_AXI_LPD (UART1).")
  }
}

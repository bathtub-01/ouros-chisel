import chisel3._
import chisel3.simulator.ChiselSim

import scala.jdk.CollectionConverters._
import me.tongfei.progressbar.ProgressBar

import benchmarks._
import ouros._

object Main extends App with ChiselSim {
  def runBenchmark(benchmark: Benchmark, dut: Ouros): Int = {
    var cycles: Int = -1 // one cycle for loading `main`
    cycles += 7 // compensate for the simulator
    dut.clock.step(3)
    // ====== program injection =======
    dut.io.inject.valid.poke(true.B)
    dut.io.inject_to.poke(InjectTo.Heap)
    for (app <- benchmark.heap_img) {
      dut.io.inject.bits.zip(app).foreach { case (p, a) => p.poke(a) }
      dut.clock.step()
    }
    dut.io.inject_to.poke(InjectTo.Comb)
    for (app <- benchmark.comb_img) {
      dut.io.inject.bits.zip(app).foreach { case (p, a) => p.poke(a) }
      dut.clock.step()
    }
    dut.io.inject.valid.poke(false.B)
    // =========== startup ============
    dut.io.start.poke(true.B)
    dut.clock.step()
    dut.io.start.poke(false.B)
    // ============ run ===============
    while (!dut.io.done.peekBoolean() && cycles <= 1_000_000) {
      dut.clock.step()
      cycles = cycles + 1
    }
    cycles
  }

  def runBench(bs: List[Benchmark]) = ProgressBar
    .wrap(bs.asJava, "Processing")
    .asScala
    .map { b =>
      var cycles: Int = 0
      simulate(
        new Ouros,
        firtoolOpts = Array("-disable-all-randomization"),
        chiselOpts = Array("--warn-conf", "any:s"),
      ) { dut =>
        cycles = runBenchmark(b, dut)
      }
      (b.toString, cycles)
    }
    .foreach { case (name, cycles) => println(s"${name}: ${cycles} consumed") }

  runBench(
    List(
      Adjoxo,
      Braun,
      Clausify,
      Countdown,
      Fib,
      Mss,
      Ordlist,
      Permsort,
      Queens,
      Queens2,
      Sumpuz,
      Taut,
      Whilex,
      SumEuler,
      TreeSum,
    )
  )
}

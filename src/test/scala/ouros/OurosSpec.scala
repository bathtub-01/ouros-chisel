package ouros

import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

import benchmarks._
import ouros._

class OurosSpec extends AnyFreeSpec with ChiselSim {
  def runBenchmark(benchmark: Benchmark, dut: Ouros): Int = {
    var cycles: Int = -2 // allign with the simulator
    dut.clock.step(3)
    // ====== program injection =======
    dut.io.inject.valid.poke(true.B)
    dut.io.inject_to.poke(InjectTo.Heap)
    for ((app, i) <- benchmark.heap_img.zipWithIndex) {
      dut.io.inject.bits.zip(app).foreach { case (p, a) => p.poke(a) }
      dut.io.inject_addr.poke(i)
      dut.clock.step()
    }
    dut.io.inject_to.poke(InjectTo.Comb)
    for ((app, i) <- benchmark.comb_img.zipWithIndex) {
      dut.io.inject.bits.zip(app).foreach { case (p, a) => p.poke(a) }
      dut.io.inject_addr.poke(i)
      dut.clock.step()
    }
    dut.io.inject.valid.poke(false.B)
    // =========== startup ============
    dut.io.start.poke(true.B)
    dut.clock.step()
    dut.io.start.poke(false.B)
    // ============ run ===============
    while (!dut.io.done.peekBoolean() && cycles <= 5_000_00) {
      dut.clock.step()
      cycles = cycles + 1
    }
    println(s"${benchmark.toString()}: ${cycles} cycles")
    cycles
  }

  def inspect(p: Benchmark) = "Playground" in {
    simulate(new Ouros) { dut => runBenchmark(p, dut) }
  }

  def runBench(bs: List[Benchmark]) = bs
    .map { b =>
      var cycles: Int = 0
      simulate(new Ouros) { dut => cycles = runBenchmark(b, dut) }
      (b.toString, cycles)
    }
    .foreach { case (name, cycles) => println(s"${name}: ${cycles} consumed") }

  // def quickBenchmarks() = "Quick Benchmarks" in {
  //   runBench(List(BoolAnd, BoolNest, AluOp, MapY))
  // }

  def fullBenchmarks() = "Benchmarks" in {
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
        TreeSum
      )
    )
  }

  inspect(Whilex)
  // quickBenchmarks()
  // fullBenchmarks()
}

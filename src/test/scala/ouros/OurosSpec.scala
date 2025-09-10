package ouros

import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

import benchmarks._
import ouros._

class OurosSpec extends AnyFreeSpec with ChiselSim {
  def runBenchmark(benchmark: Benchmark, dut: Ouros): Unit = {
    var cycles: Int = 0
    dut.clock.step(3)
    // ====== program injection =======
    dut.io.inject.valid.poke(true.B)
    for (app <- benchmark.prog) {
      dut.io.inject.bits.zip(app).foreach { case (p, a) => p.poke(a) }
      dut.clock.step()
    }
    dut.io.inject.valid.poke(false.B)
    // =========== startup ============
    dut.io.start.poke(true.B)
    dut.clock.step()
    dut.io.start.poke(false.B)
    // ============ run ===============
    while (!dut.io.done.peekBoolean() && cycles <= 10000) {
      dut.clock.step()
      cycles = cycles + 1
    }
    println(s"Cycles consumes: ${cycles}")
  }

  "Playground" in {
    simulate(new Ouros) { dut =>
      runBenchmark(MapY, dut)
    }
  }

  // for (i <- 0 until 3) {
  //   s"x${i}" in {}
  // }
}

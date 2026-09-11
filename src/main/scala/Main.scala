import chisel3._
import chisel3.simulator.ChiselSim

import java.util.concurrent.{Executors, ThreadFactory}
import java.util.concurrent.atomic.AtomicInteger
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

import benchmarks._
import ouros._

object Main extends App with ChiselSim {

  def runBenchmark(benchmark: Benchmark, dut: Ouros): Int = {
    var cycles: Int = -2 // align with the simulator

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
    while (!dut.io.done.peekBoolean() && cycles <= 1_000_000) {
      dut.clock.step()
      cycles = cycles + 1
    }

    cycles
  }

  private def simulationDirectory(index: Int, benchmark: Benchmark): String = {
    val safeName = benchmark.toString.replaceAll("[^A-Za-z0-9._-]", "_")
    s"benchmark-${"%02d".format(index)}-$safeName"
  }

  private def runOneBenchmark(benchmark: Benchmark, index: Int): (String, Int) = {
    var cycles: Int = 0

    // Each benchmark gets its own ChiselSim workspace.  This is important
    // when the simulations run concurrently because each invocation builds
    // and runs a separate Verilator simulation.
    simulate(
      new Ouros,
      firtoolOpts = Array("-disable-all-randomization"),
      chiselOpts = Array("--warn-conf", "any:s"),
      subdirectory = Some(simulationDirectory(index, benchmark)),
    ) { dut =>
      cycles = runBenchmark(benchmark, dut)
    }

    (benchmark.toString, cycles)
  }

  def runBench(bs: List[Benchmark]): Unit = {
    if (bs.isEmpty) return

    val total = bs.size
    val finished = new AtomicInteger(0)
    val threadNumber = new AtomicInteger(0)
    val executor = Executors.newFixedThreadPool(
      bs.size,
      new ThreadFactory {
        override def newThread(r: Runnable): Thread = {
          val t = new Thread(r)
          t.setName(s"benchmark-${threadNumber.getAndIncrement()}")
          t
        }
      },
    )

    implicit val executionContext: ExecutionContext =
      ExecutionContext.fromExecutorService(executor)

    try {
      println(s"[0/$total] benchmarks finished")

      // One Future / worker thread per benchmark. Future.sequence preserves
      // the original benchmark order when collecting the results.
      val runs = bs.zipWithIndex.map { case (benchmark, index) =>
        Future {
          runOneBenchmark(benchmark, index)
        }.andThen {
          case Success((name, cycles)) =>
            val count = finished.incrementAndGet()
            println(s"[$count/$total] finished $name ($cycles cycles)")

          case Failure(error) =>
            val count = finished.incrementAndGet()
            println(s"[$count/$total] FAILED $benchmark: ${error.getMessage}")
        }
      }

      val results = Await.result(Future.sequence(runs), Duration.Inf)
      results.foreach { case (name, cycles) =>
        println(s"$name: $cycles consumed")
      }
    } finally {
      executor.shutdown()
    }
  }

  runBench(
    List(
      Adjoxo,
      Braun,
      Clausify,
      Countdown,
      Fib,
      Mss,
      Queens,
      Queens2,
      SumEuler,
      Whilex,
    )
  )
}

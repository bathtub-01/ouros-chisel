import ouros._

import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec
import java.nio.file.Paths
import benchmarks.Fib

/** Tests the FPGA-style memory boot and pure execution with the new bus idle. */
class OurosSpec extends AnyFreeSpec with ChiselSim {
  "fib still completes without I/O" in {
    val dir = Paths.get("simu-out", "test-fib").toAbsolutePath.normalize
    val metadata = ProgramImageWriter.write(Fib, dir)
    val image = metadata.copy(
      heapFile = dir.resolve("heap.mem").toString,
      combFile = dir.resolve("comb.mem").toString,
    )
    simulate(new Ouros(image), firtoolOpts = Array("-disable-all-randomization")) { dut =>
      // AXI responses are unused for pure workloads.
      dut.io.M_AXI.AWREADY.poke(false.B)
      dut.io.M_AXI.WREADY.poke(false.B)
      dut.io.M_AXI.BVALID.poke(false.B)
      dut.io.M_AXI.BRESP.poke(0.U)
      dut.io.M_AXI.ARREADY.poke(false.B)
      dut.io.M_AXI.RDATA.poke(0.U)
      dut.io.M_AXI.RRESP.poke(0.U)
      dut.io.M_AXI.RVALID.poke(false.B)
      dut.io.start.poke(false.B)
      dut.clock.step(3)
      dut.io.start.poke(true.B)
      dut.clock.step()
      dut.io.start.poke(false.B)
      var cycles = 0
      while (!dut.io.done.peekBoolean() && cycles < 200000) {
        dut.clock.step()
        cycles += 1
      }
      assert(dut.io.done.peekBoolean(), s"fib did not finish after $cycles cycles")
    }
  }
}

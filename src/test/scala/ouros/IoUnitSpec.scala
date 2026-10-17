package ouros

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec
import common._
import common.Helper._

/** Handshake and Pair-construction regressions against simulator semantics. */
class IoUnitSpec extends AnyFreeSpec with ChiselSim {
  def input(write: Boolean): ActiveApp =
    (new ActiveApp).Lit(
      _.stack_idx -> 2.U,
      _.app -> (if (write)
        appBuilder(ioBuilder(true), intBuilder(4), intBuilder(-1), intBuilder(99))
      else
        appBuilder(ioBuilder(false), intBuilder(8), intBuilder(77), intBuilder(123)))
    )

  "read waits for R and retains World, data and stack identity" in {
    simulate(new IoUnit) { dut =>
      dut.io.request.valid.poke(false.B)
      dut.io.response.ready.poke(false.B)
      dut.io.axi.AWREADY.poke(false.B)
      dut.io.axi.WREADY.poke(false.B)
      dut.io.axi.BVALID.poke(false.B)
      dut.io.axi.BRESP.poke(0.U)
      dut.io.axi.ARREADY.poke(false.B)
      dut.io.axi.RVALID.poke(false.B)
      dut.io.axi.RDATA.poke(0.U)
      dut.io.axi.RRESP.poke(0.U)
      dut.clock.step(2)
      dut.io.request.bits.poke(input(false))
      dut.io.request.valid.poke(true.B)
      dut.io.request.ready.expect(true.B)
      dut.clock.step()
      dut.io.request.valid.poke(false.B)
      dut.io.pending.valid.expect(true.B)
      dut.io.axi.ARVALID.expect(true.B)
      dut.io.axi.ARADDR.expect(8.U)
      dut.clock.step(2)
      dut.io.axi.ARREADY.poke(true.B)
      dut.clock.step()
      dut.io.axi.ARREADY.poke(false.B)
      dut.io.axi.RREADY.expect(true.B)
      dut.io.response.valid.expect(false.B)
      dut.io.axi.RDATA.poke("hffffffff".U)
      dut.io.axi.RVALID.poke(true.B)
      dut.clock.step()
      dut.io.axi.RVALID.poke(false.B)
      dut.io.response.valid.expect(true.B)
      dut.io.response.bits.stack_idx.expect(2.U)
      dut.io.response.bits.app(0).expect(comBuilder(3, 2))
      dut.io.response.bits.app(1).expect(intBuilder(-1))
      dut.io.response.bits.app(2).expect(intBuilder(77))
      dut.io.response.bits.app(3).expect(intBuilder(123)) // over-applied tail
      dut.clock.step(2) // outgoing response must persist under backpressure
      dut.io.response.valid.expect(true.B)
      dut.io.request.ready.expect(false.B)
      dut.io.response.ready.poke(true.B)
      dut.clock.step()
      dut.io.request.ready.expect(true.B)
    }
  }

  "write independently handshakes AW and W and waits for B" in {
    simulate(new IoUnit) { dut =>
      dut.io.request.valid.poke(false.B)
      dut.io.response.ready.poke(true.B)
      dut.io.axi.AWREADY.poke(false.B)
      dut.io.axi.WREADY.poke(false.B)
      dut.io.axi.BVALID.poke(false.B)
      dut.io.axi.BRESP.poke(0.U)
      dut.io.axi.ARREADY.poke(false.B)
      dut.io.axi.RVALID.poke(false.B)
      dut.io.axi.RDATA.poke(0.U)
      dut.io.axi.RRESP.poke(0.U)
      dut.clock.step(2)
      dut.io.request.bits.poke(input(true))
      dut.io.request.valid.poke(true.B)
      dut.clock.step()
      dut.io.request.valid.poke(false.B)
      dut.io.axi.AWADDR.expect(4.U)
      dut.io.axi.WDATA.expect("hffffffff".U)
      dut.io.axi.WSTRB.expect("hf".U)
      dut.io.axi.AWVALID.expect(true.B)
      dut.io.axi.WVALID.expect(true.B)
      dut.io.axi.AWREADY.poke(true.B)
      dut.clock.step()
      dut.io.axi.AWREADY.poke(false.B)
      dut.io.axi.AWVALID.expect(false.B)
      dut.io.axi.WVALID.expect(true.B)
      dut.clock.step(2)
      dut.io.axi.WREADY.poke(true.B)
      dut.clock.step()
      dut.io.axi.WREADY.poke(false.B)
      dut.io.response.valid.expect(false.B)
      dut.io.axi.BREADY.expect(true.B)
      dut.io.axi.BVALID.poke(true.B)
      dut.clock.step()
      dut.io.axi.BVALID.poke(false.B)
      dut.io.response.valid.expect(true.B)
      dut.io.response.bits.app(0).expect(comBuilder(3, 2))
      dut.io.response.bits.app(1).expect(comBuilder(1, 0))
      dut.io.response.bits.app(2).expect(intBuilder(99))
    }
  }
}

package ouros

import chisel3._
import chisel3.experimental.BundleLiterals._
import chisel3.simulator.EphemeralSimulator._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec
import common._
import common.Helper._
import common.SystemConfig._

/* It's annoying to write yet another simulator for this, thus just ad-hoc
 * test-by-cases here.. */

class ReducerSpec extends AnyFreeSpec with ChiselSim {

  /**
   * free_addr = 42
   *
   * {COM(5, X(X(X(XX)))X, [2,3,0,2,1,4]), 0, 1, 2, 3, 4, 5}
   *
   * -> spine: {2, PTR(42), 4, 5}
   *
   * -> app1: {3, PTR(43)}
   *
   * -> app2: {0, PTR(44)}
   *
   * -> app3:{2, 1}
   */
  object Case1 {
    val in: ActiveApp = (new ActiveApp).Lit(
      _.stack_idx -> 5.U,
      _.app       -> appBuilder(
        maxAppLen,
        comBuilder(5, 36, List(2, 3, 0, 2, 1, 4)),
        intBuilder(0),
        intBuilder(1),
        intBuilder(2),
        intBuilder(3),
        intBuilder(4),
        intBuilder(5)
      )
    )
    val free_addr = 42.U
    val out_spine = (new ActiveApp).Lit(
      _.stack_idx -> 5.U,
      _.app       -> appBuilder(
        maxAppLen,
        intBuilder(2),
        ptrBuilder(true, 42),
        intBuilder(4),
        intBuilder(5)
      )
    )
    val out_app1 = (new FrozenApp(comIdxs - 1)).Lit(
      _.heap_addr -> 42.U,
      _.app       -> appBuilder(
        comIdxs - 1,
        intBuilder(3),
        ptrBuilder(true, 43)
      )
    )
    val out_app2 = (new FrozenApp(comIdxs - 2)).Lit(
      _.heap_addr -> 43.U,
      _.app       -> appBuilder(
        comIdxs - 2,
        intBuilder(0),
        ptrBuilder(true, 44)
      )
    )
    val out_app3 = (new FrozenApp(comIdxs - 3)).Lit(
      _.heap_addr -> 44.U,
      _.app       -> appBuilder(
        comIdxs - 3,
        intBuilder(2),
        intBuilder(1)
      )
    )
    val addr_consumed = 3.U
  }

  /**
   * free_addr = 45
   *
   * {Y, 0, 1, 2, 3, 4, 5}
   *
   * -> spine: {0, PTR(45), 1, 2, 3, 4, 5}
   *
   * -> app1: {0, PTR(45)}
   *
   * -> app2: {}
   *
   * -> app3:{}
   */
  object Case2 {
    val in: ActiveApp = (new ActiveApp).Lit(
      _.stack_idx -> 5.U,
      _.app       -> appBuilder(
        maxAppLen,
        yBuilder(),
        intBuilder(0),
        intBuilder(1),
        intBuilder(2),
        intBuilder(3),
        intBuilder(4),
        intBuilder(5)
      )
    )
    val free_addr = 45.U
    val out_spine = (new ActiveApp).Lit(
      _.stack_idx -> 5.U,
      _.app       -> appBuilder(
        maxAppLen,
        intBuilder(0),
        ptrBuilder(false, 45),
        intBuilder(1),
        intBuilder(2),
        intBuilder(3),
        intBuilder(4),
        intBuilder(5)
      )
    )
    val out_app1 = (new FrozenApp(comIdxs - 1)).Lit(
      _.heap_addr -> 45.U,
      _.app       -> appBuilder(
        comIdxs - 1,
        intBuilder(0),
        ptrBuilder(false, 45)
      )
    )
    val addr_consumed = 1.U
  }

  "non-pipelined Reducer" in {
    simulate(new Reducer(false)) { dut =>
      dut.clock.step(3)

      // test case 1
      dut.io.free_addr.poke(Case1.free_addr)
      dut.io.in.valid.poke(true.B)
      dut.io.in.bits.poke(Case1.in)
      dut.io.out_spine.ready.poke(true.B)
      dut.io.out_app1.ready.poke(true.B)
      dut.io.out_app2.ready.poke(true.B)
      dut.io.out_app3.ready.poke(true.B)

      dut.io.out_spine.valid.expect(true.B)
      dut.io.out_spine.bits.expect(Case1.out_spine)
      dut.io.out_app1.bits.expect(Case1.out_app1)
      dut.io.out_app2.bits.expect(Case1.out_app2)
      dut.io.out_app3.bits.expect(Case1.out_app3)
      dut.io.addr_consumed.expect(Case1.addr_consumed)

      dut.clock.step()

      // test case 2
      dut.io.free_addr.poke(Case2.free_addr)
      dut.io.in.valid.poke(true.B)
      dut.io.in.bits.poke(Case2.in)
      dut.io.out_spine.ready.poke(true.B)
      dut.io.out_app1.ready.poke(true.B)
      dut.io.out_app2.ready.poke(true.B)
      dut.io.out_app3.ready.poke(true.B)

      dut.io.out_spine.valid.expect(true.B)
      dut.io.out_spine.bits.expect(Case2.out_spine)
      dut.io.out_app1.valid.expect(true.B)
      dut.io.out_app1.bits.expect(Case2.out_app1)
      dut.io.out_app2.valid.expect(false.B)
      dut.io.out_app2.valid.expect(false.B)
      dut.io.addr_consumed.expect(Case2.addr_consumed)
    }
  }

  "pipelined Reducer" in {
    simulate(new Reducer(true)) { dut =>
      dut.clock.step(3)

      // test case 1
      dut.io.free_addr.poke(Case1.free_addr)
      dut.io.in.valid.poke(true.B)
      dut.io.in.bits.poke(Case1.in)
      dut.io.out_spine.ready.poke(true.B)
      dut.io.out_app1.ready.poke(true.B)
      dut.io.out_app2.ready.poke(true.B)
      dut.io.out_app3.ready.poke(true.B)
      dut.io.addr_consumed.expect(Case1.addr_consumed)

      dut.clock.step()
      dut.io.in.valid.poke(false.B)

      dut.io.out_spine.valid.expect(true.B)
      dut.io.out_spine.bits.expect(Case1.out_spine)
      dut.io.out_app1.bits.expect(Case1.out_app1)
      dut.io.out_app2.bits.expect(Case1.out_app2)
      dut.io.out_app3.bits.expect(Case1.out_app3)
      dut.io.addr_consumed.expect(0)

      // test case 2
      dut.io.free_addr.poke(Case2.free_addr)
      dut.io.in.valid.poke(true.B)
      dut.io.in.bits.poke(Case2.in)
      dut.io.out_spine.ready.poke(true.B)
      dut.io.out_app1.ready.poke(true.B)
      dut.io.out_app2.ready.poke(true.B)
      dut.io.out_app3.ready.poke(true.B)
      dut.io.addr_consumed.expect(Case2.addr_consumed)

      dut.clock.step()
      dut.io.in.valid.poke(false.B)

      dut.io.out_spine.valid.expect(true.B)
      dut.io.out_spine.bits.expect(Case2.out_spine)
      dut.io.out_app1.valid.expect(true.B)
      dut.io.out_app1.bits.expect(Case2.out_app1)
      dut.io.out_app2.valid.expect(false.B)
      dut.io.out_app2.valid.expect(false.B)
      dut.io.addr_consumed.expect(0)
    }
  }
}

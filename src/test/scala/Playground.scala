import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec
import _root_.circt.stage.ChiselStage

import common._
import common.Helper._

class Deref extends Module {
  val io = IO(new Bundle {
    val app    = Input(Vec(8, new Atom))
    val tgt    = Input(Vec(8, new Atom))
    val arg_id = Input(UInt(3.W))
    val res1   = Output(Vec(8, new Atom))
    val res2   = Output(Vec(8, new Atom))
  })
  val (res1, res2) = Helper.deref(io.app, io.arg_id, io.tgt, 42.U)
  io.res1 := res1
  io.res2 := res2
}

object Deref extends App {
  ChiselStage.emitSystemVerilogFile(
    new Deref,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

class PlaySpec extends AnyFreeSpec with ChiselSim {
  "deref" in {
    simulate(new Deref) { dut =>
      class Case(
          val app: Vec[Atom],
          val tgt: Vec[Atom],
          val arg_id: UInt,
          val res1: Vec[Atom],
          val res2: Vec[Atom]
      )
      val case1 = new Case(
        app = appBuilder(
          8,
          ptrBuilder(true, 11),
          intBuilder(0),
          yBuilder()
        ),
        tgt = appBuilder(
          8,
          intBuilder(1),
          intBuilder(2)
        ),
        arg_id = 0.U,
        res1 = appBuilder(
          8,
          intBuilder(1),
          intBuilder(2),
          intBuilder(0),
          yBuilder()
        ),
        res2 = appBuilder(8)
      )

      val case2 = new Case(
        app = appBuilder(
          8,
          yBuilder(),
          ptrBuilder(true, 11),
          intBuilder(0),
          yBuilder()
        ),
        tgt = appBuilder(
          8,
          intBuilder(1)
        ),
        arg_id = 1.U,
        res1 = appBuilder(
          8,
          yBuilder(),
          intBuilder(1),
          intBuilder(0),
          yBuilder()
        ),
        res2 = appBuilder(8)
      )

      val case3 = new Case(
        app = appBuilder(
          8,
          ptrBuilder(true, 11),
          intBuilder(0),
          intBuilder(1),
          intBuilder(2),
          intBuilder(3),
          intBuilder(4),
          intBuilder(5)
        ),
        tgt = appBuilder(
          8,
          intBuilder(11),
          intBuilder(22),
          intBuilder(33),
          intBuilder(44)
        ),
        arg_id = 0.U,
        res1 = appBuilder(
          8,
          intBuilder(11),
          intBuilder(22),
          intBuilder(33),
          intBuilder(44),
          intBuilder(0),
          intBuilder(1),
          intBuilder(2),
          intBuilder(3)
        ),
        res2 = appBuilder(
          8,
          ptrBuilder(true, 42),
          intBuilder(4),
          intBuilder(5)
        )
      )

      dut.clock.step(3)
      for (c <- Seq(case1, case2, case3)) {
        dut.io.app.poke(c.app)
        dut.io.tgt.poke(c.tgt)
        dut.io.arg_id.poke(c.arg_id)
        dut.io.res1.expect(c.res1)
        dut.io.res2.expect(c.res2)
      }

    }
  }

}

import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec

import common._
import common.Helper._

class Playground extends Module {
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

class PlaySpec extends AnyFreeSpec with ChiselSim {
  "play" in {
    simulate(new Playground) { dut =>
      val app = appBuilder(
        8,
        ptrBuilder(true, 11),
        intBuilder(42),
        yBuilder()
      )
      val tgt = appBuilder(
        8,
        intBuilder(1),
        intBuilder(2)
      )
      dut.io.app.poke(app)
      dut.io.tgt.poke(tgt)
      dut.io.arg_id.poke(0)
      println(s"res1: ${dut.io.res1.peek()}")
      println(s"res2: ${dut.io.res2.peek()}")
    }
  }

}

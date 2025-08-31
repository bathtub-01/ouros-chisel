import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec

import common._
import common.Helper._

class Playground extends Module {
  val io = IO(new Bundle {
    val app = Input(Vec(8, new Atom))
    val len = Output(UInt(4.W))
  })
  io.len := Helper.appLen(io.app)
}

class PlaySpec extends AnyFreeSpec with ChiselSim {
  "play" in {
    simulate(new Playground) { dut =>
      val app = appBuilder(
        8,
        yBuilder(),
        intBuilder(42),
        yBuilder(),
        yBuilder(),
        yBuilder(),
        yBuilder(),
        yBuilder(),
        yBuilder()
      )
      dut.io.app.poke(app)
      println(s"appLen: ${dut.io.len.peekValue()}")
    }
  }

}

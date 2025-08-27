package ouros

import chisel3._
import chisel3.simulator.EphemeralSimulator._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec

import scala.util.Random
import common._
import common.Helper._

class AluSimulator {
  def step(op: String, in1: Int, in2: Int): Atom = op match {
    case "+"  => intBuilder(in1 + in2)
    case "-"  => intBuilder(in1 - in2)
    case "*"  => intBuilder(in1 * in2)
    case "==" => boolean2Comb(in1 == in2)
    case "/=" => boolean2Comb(in1 != in2)
    case "<"  => boolean2Comb(in1 < in2)
    case "<=" => boolean2Comb(in1 <= in2)
    case ">"  => boolean2Comb(in1 > in2)
    case ">=" => boolean2Comb(in1 >= in2)
    case _    => throw new IllegalArgumentException(s"Unknown operation: $op")
  }

  def opGen(): String =
    Seq("+", "-", "*", "==", "/=", "<", "<=", ">", ">=")(Random.nextInt(9))
}

class AluSpec extends AnyFreeSpec with ChiselSim {
  val simulator = new AluSimulator

  def getStimu(): (Application, Application) = {
    val op     = simulator.opGen()
    val in1    = Random.nextInt(1024)
    val in2    = Random.nextInt(1024)
    val res    = simulator.step(op, in1, in2)
    val app_in =
      appBuilder(prmBuilder(op), intBuilder(in1), intBuilder(in2))
    val app_out = appBuilder(res)
    (app_in, app_out)
  }

  "non-pipelined Alu" in {
    simulate(new Alu(false)) { dut =>
      def run(n: Int): Unit = {
        val (app_in, app_out) = getStimu()
        dut.io.in.valid.poke(true)
        dut.io.in.bits.poke(app_in)
        dut.io.out.ready.poke(true)

        dut.io.out.valid.expect(true)
        dut.io.out.bits.expect(app_out)

        dut.clock.step()

        if (n > 1) { run(n - 1) }
      }

      dut.clock.step(3)
      run(1000)
    }
  }

  "pipelined Alu" in {
    simulate(new Alu(true)) { dut =>
      def run(n: Int): Unit = {
        val (app_in, app_out) = getStimu()
        dut.io.in.valid.poke(true)
        dut.io.in.bits.poke(app_in)
        dut.io.out.ready.poke(true)

        dut.clock.step()

        dut.io.out.valid.expect(true)
        dut.io.out.bits.expect(app_out)

        if (n > 1) { run(n - 1) }
      }

      dut.clock.step(3)
      run(1000)
    }
  }
}

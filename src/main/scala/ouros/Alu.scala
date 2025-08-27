package ouros

import chisel3._
import chisel3.util._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

/**
 * This implementation is highly inspired by the rocket-chip project:
 * https://github.com/chipsalliance/rocket-chip/blob/master/src/main/scala/rocket/ALU.scala
 */
class AluCore(width: Int) extends Module {
  val io = IO(new Bundle {
    val in1 = Input(Bits(width.W))
    val in2 = Input(Bits(width.W))
    val fn  = Input(new AluFunction)
    val out = Output(Bits(width.W))
  })
  // add/sub
  val in2_inv   = Mux(io.fn.is_sub, ~io.in2, io.in2)
  val adder_out = io.in1 + in2_inv + io.fn.is_sub

  // conditions
  val eq = io.in1 === io.in2
  val lt = Mux(
    io.in1(width - 1) === io.in2(width - 1),
    adder_out(width - 1),
    io.in1(width - 1)
  )
  val cond_out_default = Mux(io.fn.opcode <= AluOpCode.le, eq, 0.U) |
    Mux(io.fn.opcode === AluOpCode.le || io.fn.opcode === AluOpCode.lt, lt, 0.U)
  val cond_out = io.fn.is_cond_inv ^ cond_out_default

  io.out := Mux(
    io.fn.opcode === AluOpCode.add_sub,
    adder_out,
    cond_out
  )
  when(io.fn.opcode === AluOpCode.mult) {
    io.out := (io.in1.asSInt * io.in2.asSInt).asUInt(width - 1, 0)
  }
}

/**
 * ALU block
 *
 * @param pipelined
 *   optionally insert an output register
 */
class Alu(pipelined: Boolean) extends Module {
  val io = IO(new Bundle {
    val in  = Flipped(Decoupled(new Application))
    val out = Decoupled(new Application)
  })
  val aluCore = Module(new AluCore(atomPayloadSize))
  val outReg  = RegInit(0.U.asTypeOf(new BitsWithValid(new Application)))

  aluCore.io.fn  := io.in.bits.app(0).toPrm().fun
  aluCore.io.in1 := io.in.bits.app(1).payload
  aluCore.io.in2 := io.in.bits.app(2).payload

  val aluOut: Atom = Wire(new Atom)
  when(aluCore.io.fn.opcode <= AluOpCode.lt) {
    // True - A, False - K
    when(aluCore.io.out === 0.U) {
      aluOut := Combinators.K
    }.otherwise {
      aluOut := Combinators.A
    }
  }.otherwise {
    aluOut.atomType := AtomType.INT
    aluOut.payload  := aluCore.io.out
  }

  val resSeq: Seq[Atom] = aluOut +: io.in.bits.app.drop(3)

  outReg.valid := io.in.valid
  outReg.bits  := extendToApp(resSeq)
  io.in.ready  := io.out.fire

  if (pipelined) {
    io.out.valid := outReg.valid
    io.out.bits  := outReg.bits
  } else {
    io.out.valid := io.in.valid
    io.out.bits  := extendToApp(resSeq)
  }
}

object Alu extends App {
  ChiselStage.emitSystemVerilogFile(
    new Alu(false),
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

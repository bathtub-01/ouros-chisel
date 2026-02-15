package ouros

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

object ReducerStm extends ChiselEnum {
  val IDLE    = Value
  val SPINE   = Value
  val APP     = Value
  val SPECIAL = Value
}

/**
 * Combinator reduction block
 */
class Reducer extends Module {
  val io = IO(new Bundle {
    val free_addr     = Input(Addr)
    val in            = Flipped(Decoupled(new ActiveApp))
    val out_spine     = Decoupled(new ActiveApp)
    val out_app       = Decoupled(new FrozenApp)
    val addr_consumed = Output(UInt(3.W))
  })

  val combTable  = Module(new BlockMem(progSize, Vec(maxAppLen, new Atom)))
  val regIn      = RegInit(0.U.asTypeOf(new ActiveApp))
  val regSpine   = RegInit(0.U.asTypeOf(Vec(maxAppLen, new Atom)))
  val regAddr    = RegInit(0.U.asTypeOf(Addr))
  val regArity   = RegInit(0.U(log2Ceil(comArity + 1).W))
  val regStm     = RegInit(ReducerStm.IDLE)
  val regIdx     = RegInit(0.U(3.W))
  val regAppMask = RegInit(false.B)

  def stepNext(): Unit = { ??? }

  def moreApp(app: Vec[Atom]): Bool = { ??? }

  def findApp(app: Vec[Atom]): UInt = { ??? }

  // give default connection
  combTable.init()
  io.out_app.bits  := DontCare
  io.out_app.valid := false.B

  switch(regStm) {
    is(ReducerStm.IDLE) { stepNext() }
    is(ReducerStm.SPINE) {
      val template = combTable.readOut
      when(moreApp(template)) {
        val founded = findApp(template)
        regSpine := template
        regStm   := ReducerStm.APP
        regIdx   := founded
        regAddr  := io.free_addr
        combTable.read(
          regIn.app(0).getCombAddr() + template(founded).getPtr() + 1.U
        )
      }.otherwise {
        stepNext()
      }
    }
    is(ReducerStm.APP) {
      when(io.out_app.ready) {
        when(moreApp(regSpine)) {
          val founded = findApp(regSpine)
          regIdx := founded
          combTable.read(
            regIn.app(0).getCombAddr() + regSpine(founded).getPtr() + 1.U
          )
          io.out_app.valid := true.B
        }.otherwise {
          stepNext()
        }
      }
    }
    is(ReducerStm.SPECIAL) {}
  }
}

object Reducer extends App {
  ChiselStage.emitSystemVerilogFile(
    new Reducer,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

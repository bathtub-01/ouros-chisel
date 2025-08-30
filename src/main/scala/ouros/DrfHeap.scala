package ouros

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

/**
 * States of the main state-machine
 */
object Stm extends ChiselEnum {
  val IDLE   = Value
  val WHNF   = Value
  val IA     = Value
  val RESUME = Value
}

/**
 * States of the sub state-machine
 */
object StmSub extends ChiselEnum {
  val IDLE = Value
  val WORK = Value
}

/**
 * Conditions for consuming next input
 */
object CONSUMEs extends ChiselEnum {
  val NoInput                  = Value
  val InputIA                  = Value
  val InputWHNFWithDmder       = Value
  val InputWHNFNoDmderNewFrame = Value
  val InputWHNFNoDmderNoFrame  = Value
}

/**
 * Conditions when main state-machine is in WHNF
 */
object WHNFs extends ChiselEnum {
  val MoreDmders = Value
  val NewFrame   = Value
  val NoNewFrame = Value
}

/**
 * Conditions when main state-machine is in IA (part 1)
 */
object IAs1 extends ChiselEnum {
  val NoExist                = Value
  val ExistWHNF              = Value
  val ExistIAWorkingNormal   = Value
  val ExistIAWorkingNewFrame = Value
  val ExistIAFresh           = Value
}

/**
 * Conditions when main state-machine is in IA (part 2)
 */
object IAs2 extends ChiselEnum {
  val NextStrictArgLocal  = Value
  val NextStrictArgNewStk = Value
  val NoMoreArgsCanEmit   = Value
  val NoMoreArgsNoEmit    = Value
}

/**
 * Conditions when main state-machine is in RESUME
 */
object RESUMEs extends ChiselEnum {
  val TopInWHNF = Value
  val TopInIA   = Value
}

/**
 * Conditions when sub state-machine is in WORK
 */
object WORKs extends ChiselEnum {
  val NotDemanded   = Value
  val DmderFound    = Value
  val DmderNotFound = Value
}

/**
 * Dereference heap block
 */
class DrfHeap extends Module {
  val io = IO(new Bundle {
    val in_main       = Flipped(Decoupled(new ActiveApp))
    val in_sub        = Flipped(Decoupled(new FrozenApp(comIdxs - 1)))
    val out_main      = Decoupled(new ActiveApp)
    val out_sub       = Decoupled(new ActiveApp)
    val free_addr     = Output(UInt(log2Ceil(heapSize).W))
    val addr_consumed = Input(UInt(2.W))
  })

  val stmMain = RegInit(Stm.IDLE)
  val stmSub  = RegInit(StmSub.IDLE)

  val consumes = Wire(CONSUMEs())
  val whnfs    = Wire(WHNFs())
  val ias1     = Wire(IAs1())
  val ias2     = Wire(IAs2())
  val resumes  = Wire(RESUMEs())
  val works    = Wire(WORKs())
}

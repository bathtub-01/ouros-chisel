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

class HeapCell extends Bundle {
  val exist = Bool()
  val app   = Vec(maxAppLen, new Atom)
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
    val free_addr     = Output(Addr)
    val addr_consumed = Input(UInt(2.W))
  })

  val stmMain       = RegInit(Stm.IDLE)
  val stmSub        = RegInit(StmSub.IDLE)
  val regInMain     = RegInit(0.U.asTypeOf(new ActiveApp))
  val regInSub      = RegInit(0.U.asTypeOf(new FrozenApp(comIdxs - 1)))
  val regAddr       = RegInit(0.U.asTypeOf(Addr))
  val regIAddr      = RegInit(0.U.asTypeOf(Addr))
  val regFather     = RegInit(0.U(log2Ceil(maxThreads).W))
  val threadStacks  = Vec(maxThreads, new StackPort(threadStkDepth, Addr))
  val _threadStacks =
    Seq.fill(maxThreads)(Module(new RegStack(threadStkDepth, Addr)))
  val frameStacks =
    Vec(maxThreads, new StackPort(frameStkDepth, Vec(maxThreads, Addr)))
  val _frameStacks =
    Seq.fill(maxThreads)(
      Module(new RegStack(threadStkDepth, Vec(maxThreads, Addr)))
    )
  val mainHeap      = Module(new MultiPortBlockMem(2, heapSize, new HeapCell))
  val demandHeap    = Module(new MultiPortBlockMem(2, heapSize, Bool()))
  val workingHeap   = Module(new MultiPortBlockMem(2, heapSize, Bool()))
  val regOutMain    = RegInit(0.U.asTypeOf(new BitsWithValid(new ActiveApp)))
  val regOutSub     = RegInit(0.U.asTypeOf(new BitsWithValid(new ActiveApp)))
  val regBusy       = RegInit(false.B)
  val regAddrBumper = RegInit(0.U.asTypeOf(Addr))
  val regArgId      = RegInit(0.U(3.W)) // hardcode this should be fine

  // connect Vec of ports to underlying moduels
  threadStacks.zip(_threadStacks).foreach { case (p, m) => p :<>= m.io }
  frameStacks.zip(_frameStacks).foreach { case (p, m) => p :<>= m.io }

  // generate the CONSUMEs signal under current state
  def genCONSUMEs: CONSUMEs.Type = {
    val wire = Wire(CONSUMEs())
    when(!io.in_main.fire) {
      wire := CONSUMEs.NoInput
    }.otherwise {}
    wire
  }

  switch(stmMain) {
    is(Stm.IDLE) {}
    is(Stm.WHNF) {}
    is(Stm.IA) {}
    is(Stm.RESUME) {}
  }

  switch(stmSub) {
    is(StmSub.IDLE) {}
    is(StmSub.WORK) {}
  }
}

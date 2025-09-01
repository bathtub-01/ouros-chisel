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

class StkCell extends Bundle {
  val frame = Bool()
  val addr  = Addr
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

  val stmMain      = RegInit(Stm.IDLE)
  val stmSub       = RegInit(StmSub.IDLE)
  val regInMain    = RegInit(0.U.asTypeOf(new ActiveApp))
  val regInSub     = RegInit(0.U.asTypeOf(new FrozenApp(comIdxs - 1)))
  val regAddr      = RegInit(0.U.asTypeOf(Addr))
  val regIAddr     = RegInit(0.U.asTypeOf(Addr))
  val regFather    = RegInit(0.U(log2Ceil(maxThreads).W))
  val threadStacks = Vec(maxThreads, new StackPort(threadStkDepth, new StkCell))
  val _threadStacks =
    Seq.fill(maxThreads)(Module(new RegStack(threadStkDepth, new StkCell)))
  val frameStacks =
    Vec(maxThreads, new StackPort(frameStkDepth, Vec(maxThreads, Addr)))
  val _frameStacks =
    Seq.fill(maxThreads)(
      Module(new RegStack(threadStkDepth, Vec(maxThreads, Addr)))
    )
  val mainHeap      = Module(new DualPortBlockMem(heapSize, new HeapCell))
  val demandHeap    = Module(new DualPortBlockMem(heapSize, Bool()))
  val workingHeap   = Module(new DualPortBlockMem(heapSize, Bool()))
  val regOutMain    = RegInit(0.U.asTypeOf(new BitsWithValid(new ActiveApp)))
  val regOutSub     = RegInit(0.U.asTypeOf(new BitsWithValid(new ActiveApp)))
  val regBusy       = RegInit(false.B)
  val regAddrBumper = RegInit(0.U.asTypeOf(Addr))
  val regArgId      = RegInit(0.U(3.W)) // hardcode this should be fine

  // some shorthands
  val currentStk    = threadStacks(regInMain.stack_idx)
  val currentFrmStk = frameStacks(regInMain.stack_idx)

  // connect Vec of ports to underlying moduels
  threadStacks.zip(_threadStacks).foreach { case (p, m) => p :<>= m.io }
  frameStacks.zip(_frameStacks).foreach { case (p, m) => p :<>= m.io }

  def findMoreDmder(addr: UInt, stk: StackPort[StkCell]): Bool =
    stk.elms > 1.U && stk.top.addr === addr && !stk.snd.frame

  def findNewFrame(addr: UInt, stk: StackPort[StkCell]): Bool =
    stk.elms > 1.U && stk.top.addr === addr && stk.snd.frame

  def findFreeStk(addr: UInt, stk: StackPort[StkCell]): Bool =
    stk.elms === 0.U || (stk.top.frame && stk.top.addr === addr)

  // generate the CONSUMEs signal under current state
  def genCONSUMEs: CONSUMEs.Type = {
    val wire = Wire(CONSUMEs())
    when(!io.in_main.fire) {
      wire := CONSUMEs.NoInput
    }.otherwise {
      when(isWHNF(io.in_main.bits.app)) {
        when(
          threadStacks.exists(stk =>
            findMoreDmder(threadStacks(io.in_main.bits.stack_idx).top.addr, stk)
          )
        ) {
          wire := CONSUMEs.InputWHNFWithDmder
        }.otherwise {
          when(currentStk.elms > 1.U) {
            wire := CONSUMEs.InputWHNFNoDmderNewFrame
          }.otherwise {
            wire := CONSUMEs.InputWHNFNoDmderNoFrame
          }
        }
      }.otherwise {
        wire := CONSUMEs.InputIA
      }
    }
    wire
  }

  // generate the WHNFs signal under current state
  def genWHNFs: WHNFs.Type = {
    val wire = Wire(WHNFs())
    when(threadStacks.exists(stk => findMoreDmder(currentStk.top.addr, stk))) {
      wire := WHNFs.MoreDmders
    }.otherwise {
      when(threadStacks.exists(stk => findNewFrame(currentStk.top.addr, stk))) {
        wire := WHNFs.NewFrame
      }.otherwise {
        wire := WHNFs.NoNewFrame
      }
    }
    wire
  }

  // generate the RESUMEs signal under current state
  def genRESUMEs: RESUMEs.Type = {
    val wire = Wire(RESUMEs())
    when(isWHNF(mainHeap.readOutA.app)) {
      wire := RESUMEs.TopInWHNF
    }.otherwise {
      wire := RESUMEs.TopInIA
    }
    wire
  }

  // generate the IAs1 signal under current state
  def genIAs1: IAs1.Type = {
    val wire = Wire(IAs1())
    when(!mainHeap.readOutA.exist) {
      wire := IAs1.NoExist
    }.otherwise {
      when(isWHNF(mainHeap.readOutA.app)) {
        wire := IAs1.ExistWHNF
      }.otherwise {
        when(!workingHeap.readOutA) {
          wire := IAs1.ExistIAFresh
        }.otherwise {
          when(currentStk.elms >= 1.U && !currentStk.top.frame) {
            wire := IAs1.ExistIAWorkingNormal
          }.otherwise {
            wire := IAs1.ExistIAWorkingNewFrame
          }
        }
      }
    }
    wire
  }

  // generate the IAs2 signal under current state
  def genIAs2: IAs2.Type = {
    val target_in_whnf: Bool =
      mainHeap.readOutA.exist && isWHNF(mainHeap.readOutA.app)
    val idle_stk: Bool = threadStacks
      .zip(currentFrmStk.top)
      .map { case (ts, fr) => findFreeStk(fr, ts) }
      .reduce(_ || _)
    val local_stk: Bool =
      genIAs1 === IAs1.ExistWHNF || genIAs1 === IAs1.ExistIAWorkingNewFrame
    val more_strict_args: Bool = !regInMain.app(0).isPtr() ||
      (regInMain.app(0).isPrm() && regArgId === 1.U && regInMain.app(2).isPtr())

    val wire = Wire(IAs2())
    when(more_strict_args && local_stk) {
      wire := IAs2.NextStrictArgLocal
    }.elsewhen(more_strict_args && idle_stk) {
      wire := IAs2.NextStrictArgNewStk
    }.otherwise {
      when(
        (regInMain.app(0).isPtr() ||
          (regInMain.app(0).isPrm() &&
            (regInMain.app(1).isInt() || regInMain.app(2).isInt())))
          && target_in_whnf
      ) {
        wire := IAs2.NoMoreArgsCanEmit
      }.otherwise {
        wire := IAs2.NoMoreArgsNoEmit
      }
    }
    wire
  }

  // generate the WORKs signal under current state
  def genWORKs: WORKs.Type = {
    val wire = Wire(WORKs())
    when(demandHeap.readOutB) {
      when(
        threadStacks.exists(stk =>
          stk.elms >= 1.U && stk.top.addr === regInSub.heap_addr
        )
      ) {
        wire := WORKs.DmderFound
      }.otherwise {
        wire := WORKs.DmderNotFound
      }
    }.otherwise {
      wire := WORKs.NotDemanded
    }
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

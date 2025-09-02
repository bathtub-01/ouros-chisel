package ouros

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._
import ouros.RESUMEs.{TopInWHNF => TopInWHNF}
import firtoolresolver.shaded.org.apache.commons.io.build.AbstractOrigin.WriterOrigin
import ouros.Stm.{IDLE => IDLE}

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
// class DrfHeap extends Module {
//   val io = IO(new Bundle {
//     val in_main       = Flipped(Decoupled(new ActiveApp))
//     val in_sub        = Flipped(Decoupled(new FrozenApp(comIdxs - 1)))
//     val out_main      = Decoupled(new ActiveApp)
//     val out_sub       = Decoupled(new ActiveApp)
//     val free_addr     = Output(Addr)
//     val addr_consumed = Input(UInt(2.W))
//   })

//   val stmMain      = RegInit(Stm.IDLE)
//   val stmSub       = RegInit(StmSub.IDLE)
//   val regInMain    = RegInit(0.U.asTypeOf(new ActiveApp))
//   val regInSub     = RegInit(0.U.asTypeOf(new FrozenApp(comIdxs - 1)))
//   val regAddr      = RegInit(0.U.asTypeOf(Addr))
//   val regIAddr     = RegInit(0.U.asTypeOf(Addr))
//   val regFather    = RegInit(0.U(log2Ceil(maxThreads).W))
//   val threadStacks = Vec(maxThreads, new StackPort(threadStkDepth, new StkCell))
//   val _threadStacks =
//     Seq.fill(maxThreads)(Module(new RegStack(threadStkDepth, new StkCell)))
//   val frameStacks =
//     Vec(maxThreads, new StackPort(frameStkDepth, Vec(maxThreads, Addr)))
//   val _frameStacks =
//     Seq.fill(maxThreads)(
//       Module(new RegStack(threadStkDepth, Vec(maxThreads, Addr)))
//     )
//   val mainHeap      = Module(new DualPortBlockMem(heapSize, new HeapCell))
//   val demandHeap    = Module(new DualPortBlockMem(heapSize, Bool()))
//   val workingHeap   = Module(new DualPortBlockMem(heapSize, Bool()))
//   val regOutMain    = RegInit(0.U.asTypeOf(new BitsWithValid(new ActiveApp)))
//   val regOutSub     = RegInit(0.U.asTypeOf(new BitsWithValid(new ActiveApp)))
//   val regBusy       = RegInit(false.B)
//   val regAddrBumper = RegInit(0.U.asTypeOf(Addr))
//   val regArgId      = RegInit(0.U(3.W)) // hardcode this should be fine

//   // some shorthands
//   val currentStk     = threadStacks(regInMain.stack_idx)
//   val currentFrmStk  = frameStacks(regInMain.stack_idx)
//   val incomingStk    = threadStacks(io.in_main.bits.stack_idx)
//   val incomingFrmStk = frameStacks(io.in_main.bits.stack_idx)

//   // connect Vec of ports to underlying moduels
//   threadStacks.zip(_threadStacks).foreach { case (p, m) => p :<>= m.io }
//   frameStacks.zip(_frameStacks).foreach { case (p, m) => p :<>= m.io }

//   def mkHeapCell(exist: Bool, app: Vec[Atom]): HeapCell = {
//     val wire = Wire(new HeapCell)
//     wire.exist := exist
//     wire.app   := app
//     wire
//   }

//   def findMoreDmder(addr: UInt, stk: StackPort[StkCell]): Bool =
//     stk.elms > 1.U && stk.top.addr === addr && !stk.snd.frame

//   def findNewFrame(addr: UInt, stk: StackPort[StkCell]): Bool =
//     stk.elms > 1.U && stk.top.addr === addr && stk.snd.frame

//   def findFreeStk(addr: UInt, stk: StackPort[StkCell]): Bool =
//     stk.elms === 0.U || (stk.top.frame && stk.top.addr === addr)

//   def select1stArg(app: Vec[Atom]): (UInt, UInt) = {
//     val (pos, ptr) = (Wire(UInt(2.W)), Wire(Addr))
//     when(app(0).isPtr()) {
//       pos := 0.U
//       ptr := app(0).toPtr().pointer
//     }.elsewhen(app(0).isPrm()) {
//       when(app(1).isPtr()) {
//         pos := 1.U
//         ptr := app(1).toPtr().pointer
//       }.otherwise {
//         pos := 2.U
//         ptr := app(2).toPtr().pointer
//       }
//     }
//     (pos, ptr)
//   }

//   def writeIncoming(): Unit = {
//     incomingStk.pop
//     mainHeap.writeA(
//       mkHeapCell(true.B, io.in_main.bits.app),
//       incomingStk.top.addr
//     )
//   }

//   def readTarget(p: UInt): Unit = {
//     mainHeap.readA(p)
//     workingHeap.readA(p)
//     demandHeap.writeA(true.B, p)
//     regAddr := p
//   }

//   def select1stArgRead(app: Vec[Atom]): Unit = {
//     val (arg_id, ptr) = select1stArg(app)
//     readTarget(ptr)
//     regArgId := arg_id
//   }

//   def findPopRead(pr: (StackPort[StkCell]) => Bool, pop_frm: Boolean): Unit = {
//     val stkId = threadStacks.indexWhere(pr)
//     threadStacks(stkId).pop
//     if (pop_frm) {
//       frameStacks(stkId).pop
//     }
//     mainHeap.readA(threadStacks(stkId).snd.addr)
//     regInMain.stack_idx := stkId
//   }

//   // generate the CONSUMEs signal under current state
//   def genCONSUMEs: CONSUMEs.Type = {
//     val wire = Wire(CONSUMEs())
//     when(!io.in_main.fire) {
//       wire := CONSUMEs.NoInput
//     }.otherwise {
//       when(isWHNF(io.in_main.bits.app)) {
//         when(
//           threadStacks.exists(stk =>
//             findMoreDmder(threadStacks(io.in_main.bits.stack_idx).top.addr, stk)
//           )
//         ) {
//           wire := CONSUMEs.InputWHNFWithDmder
//         }.otherwise {
//           when(currentStk.elms > 1.U) {
//             wire := CONSUMEs.InputWHNFNoDmderNewFrame
//           }.otherwise {
//             wire := CONSUMEs.InputWHNFNoDmderNoFrame
//           }
//         }
//       }.otherwise {
//         wire := CONSUMEs.InputIA
//       }
//     }
//     wire
//   }

//   // generate the WHNFs signal under current state
//   def genWHNFs: WHNFs.Type = {
//     val wire = Wire(WHNFs())
//     when(threadStacks.exists(stk => findMoreDmder(currentStk.top.addr, stk))) {
//       wire := WHNFs.MoreDmders
//     }.otherwise {
//       when(threadStacks.exists(stk => findNewFrame(currentStk.top.addr, stk))) {
//         wire := WHNFs.NewFrame
//       }.otherwise {
//         wire := WHNFs.NoNewFrame
//       }
//     }
//     wire
//   }

//   // generate the RESUMEs signal under current state
//   def genRESUMEs: RESUMEs.Type = {
//     val wire = Wire(RESUMEs())
//     when(isWHNF(mainHeap.readOutA.app)) {
//       wire := RESUMEs.TopInWHNF
//     }.otherwise {
//       wire := RESUMEs.TopInIA
//     }
//     wire
//   }

//   // generate the IAs1 signal under current state
//   def genIAs1: IAs1.Type = {
//     val wire = Wire(IAs1())
//     when(!mainHeap.readOutA.exist) {
//       wire := IAs1.NoExist
//     }.otherwise {
//       when(isWHNF(mainHeap.readOutA.app)) {
//         wire := IAs1.ExistWHNF
//       }.otherwise {
//         when(!workingHeap.readOutA) {
//           wire := IAs1.ExistIAFresh
//         }.otherwise {
//           when(currentStk.elms >= 1.U && !currentStk.top.frame) {
//             wire := IAs1.ExistIAWorkingNormal
//           }.otherwise {
//             wire := IAs1.ExistIAWorkingNewFrame
//           }
//         }
//       }
//     }
//     wire
//   }

//   // generate the IAs2 signal under current state
//   def genIAs2: IAs2.Type = {
//     val target_in_whnf: Bool =
//       mainHeap.readOutA.exist && isWHNF(mainHeap.readOutA.app)
//     val idle_stk: Bool = threadStacks
//       .zip(currentFrmStk.top)
//       .map { case (ts, fr) => findFreeStk(fr, ts) }
//       .reduce(_ || _)
//     val local_stk: Bool =
//       genIAs1 === IAs1.ExistWHNF || genIAs1 === IAs1.ExistIAWorkingNewFrame
//     val more_strict_args: Bool = !regInMain.app(0).isPtr() ||
//       (regInMain.app(0).isPrm() && regArgId === 1.U && regInMain.app(2).isPtr())

//     val wire = Wire(IAs2())
//     when(more_strict_args && local_stk) {
//       wire := IAs2.NextStrictArgLocal
//     }.elsewhen(more_strict_args && idle_stk) {
//       wire := IAs2.NextStrictArgNewStk
//     }.otherwise {
//       when(
//         (regInMain.app(0).isPtr() ||
//           (regInMain.app(0).isPrm() &&
//             (regInMain.app(1).isInt() || regInMain.app(2).isInt())))
//           && target_in_whnf
//       ) {
//         wire := IAs2.NoMoreArgsCanEmit
//       }.otherwise {
//         wire := IAs2.NoMoreArgsNoEmit
//       }
//     }
//     wire
//   }

//   // generate the WORKs signal under current state
//   def genWORKs: WORKs.Type = {
//     val wire = Wire(WORKs())
//     when(demandHeap.readOutB) {
//       when(
//         threadStacks.exists(stk =>
//           stk.elms >= 1.U && stk.top.addr === regInSub.heap_addr
//         )
//       ) {
//         wire := WORKs.DmderFound
//       }.otherwise {
//         wire := WORKs.DmderNotFound
//       }
//     }.otherwise {
//       wire := WORKs.NotDemanded
//     }
//     wire
//   }

//   // consume the next input
//   def nextMain(): Unit = {
//     regInMain := io.in_main.bits
//     switch(genCONSUMEs) {
//       is(CONSUMEs.NoInput) {
//         stmMain := Stm.IDLE
//       }
//       is(CONSUMEs.InputIA) {
//         select1stArgRead(io.in_main.bits.app)
//         regIAddr  := incomingStk.top.addr
//         regFather := io.in_main.bits.stack_idx
//         stmMain   := Stm.IA
//       }
//       is(CONSUMEs.InputWHNFWithDmder) {
//         findPopRead(findMoreDmder(incomingStk.top.addr, _), false)
//         regAddr := incomingStk.top.addr
//         stmMain := Stm.WHNF
//       }
//       is(CONSUMEs.InputWHNFNoDmderNewFrame) {
//         incomingStk.pop
//         mainHeap.readA(incomingStk.snd.addr)
//         regAddr := incomingStk.top.addr
//         incomingFrmStk.pop
//         stmMain := Stm.RESUME
//       }
//       is(CONSUMEs.InputWHNFNoDmderNoFrame) {
//         incomingFrmStk.pop
//         writeIncoming()
//         stmMain := Stm.IDLE
//       }
//     }
//   }

//   // consume the next input
//   def nextSub(): Unit = {
//     val addr = io.in_sub.bits.heap_addr
//     when(io.in_sub.fire) {
//       mainHeap.writeB(
//         mkHeapCell(true.B, extendToApp(io.in_sub.bits.app)),
//         addr
//       )
//       regInSub := io.in_sub.bits
//       when(
//         demandHeap.io.readwritePorts(0).address === addr &&
//           // threadStacks.exists(s => s.elms >= 1.U && s.top.addr === addr)
//           demandHeap.io.readwritePorts(0).enable
//       ) {
//         demandHeap.readB(0.U)
//       }.otherwise {
//         demandHeap.readB(addr)
//       }
//       stmSub := StmSub.WORK
//     }.otherwise {
//       stmSub := StmSub.IDLE
//     }
//   }

//   def stepWHNF(): Unit = {
//     switch(genWHNFs) {
//       is(WHNFs.MoreDmders) {}
//       is(WHNFs.NewFrame) {}
//       is(WHNFs.NoNewFrame) {}
//     }
//   }

//   def stepIA(): Unit = {
//     switch(genIAs1) {
//       is(IAs1.NoExist) {}
//       is(IAs1.ExistWHNF) {}
//       is(IAs1.ExistIAWorkingNormal) {}
//       is(IAs1.ExistIAWorkingNewFrame) {}
//       is(IAs1.ExistIAFresh) {}
//     }

//     switch(genIAs2) {
//       is(IAs2.NextStrictArgNewStk) {}
//       is(IAs2.NextStrictArgLocal) {}
//       is(IAs2.NoMoreArgsNoEmit) {}
//       is(IAs2.NoMoreArgsCanEmit) {}
//     }
//   }

//   def stepRESUME(): Unit = {
//     switch(genRESUMEs) {
//       is(RESUMEs.TopInWHNF) {}
//       is(RESUMEs.TopInIA) {}
//     }
//   }

//   def stepWORK(): Unit = {
//     switch(genWORKs) {
//       is(WORKs.NotDemanded) {}
//       is(WORKs.DmderFound) {}
//       is(WORKs.DmderNotFound) {}
//     }
//   }

//   // TODO: add default inputs for sub-modules

//   switch(stmMain) {
//     is(Stm.IDLE) {}
//     is(Stm.WHNF) {
//       stepWHNF()
//     }
//     is(Stm.IA) {
//       stepIA()
//     }
//     is(Stm.RESUME) {
//       stepRESUME()
//     }
//   }

//   switch(stmSub) {
//     is(StmSub.IDLE) {}
//     is(StmSub.WORK) {
//       stepWORK()
//     }
//   }
// }

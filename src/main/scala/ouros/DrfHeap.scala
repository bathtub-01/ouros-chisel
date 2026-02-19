package ouros

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._
import chisel3.util.experimental.loadMemoryFromFileInline
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
    val in_sub        = Flipped(Decoupled(new FrozenApp))
    val out_main      = Decoupled(new ActiveApp)
    val out_sub       = Decoupled(new ActiveApp)
    val out_big_drf   = Decoupled(new FrozenApp)
    val free_addr     = Output(Addr)
    val addr_consumed = Input(UInt(3.W))
    val search        = Output(Addr)
    val found         = Input(Bool())
    // ============ non-essential ports ===================
    val inject = Flipped(Valid(Vec(maxAppLen, new Atom)))
    val start  = Input(Bool())
    val done   = Output(Bool())
  })

  val busy         = RegInit(false.B)
  val stmMain      = RegInit(Stm.IDLE)
  val stmSub       = RegInit(StmSub.IDLE)
  val regInMain    = RegInit(0.U.asTypeOf(new ActiveApp))
  val regInSub     = RegInit(0.U.asTypeOf(new FrozenApp))
  val regAddr      = RegInit(0.U.asTypeOf(Addr))
  val regIAddr     = RegInit(0.U.asTypeOf(Addr))
  val threadStacks = Wire(
    Vec(maxThreads, new StackPort(threadStkDepth, new StkCell))
  )
  val _threadStacks =
    Seq.fill(maxThreads)(Module(new RegStack(threadStkDepth, new StkCell)))
  val frameStacks =
    Wire(Vec(maxThreads, new StackPort(frameStkDepth, Vec(maxThreads, Addr))))
  val _frameStacks =
    Seq.fill(maxThreads)(
      Module(new RegStack(frameStkDepth, Vec(maxThreads, Addr)))
    )
  val mainHeap      = Module(new DualPortBlockMem(heapSize, new HeapCell))
  val demandHeap    = Module(new DualPortBlockMem(heapSize, Bool()))
  val workingHeap   = Module(new DualPortBlockMem(heapSize, Bool()))
  val regBusy       = RegInit(false.B)
  val regAddrBumper = RegInit(0.U.asTypeOf(Addr))
  val regArgId      = RegInit(0.U(3.W)) // hardcode this should be fine
  val regSubMask    = RegInit(false.B)
  val needSplit     = WireInit(false.B)
  val bBorrowed     = WireInit(false.B)

  // some shorthands
  def currentStk     = threadStacks(regInMain.stack_idx)
  def currentFrmStk  = frameStacks(regInMain.stack_idx)
  def incomingStk    = threadStacks(io.in_main.bits.stack_idx)
  def incomingFrmStk = frameStacks(io.in_main.bits.stack_idx)

  // connect Vec of ports to underlying moduels
  threadStacks.zip(_threadStacks).foreach { case (p, m) => p :<>= m.io }
  frameStacks.zip(_frameStacks).foreach { case (p, m) => p :<>= m.io }

  def mkHeapCell(exist: Bool, app: Vec[Atom]): HeapCell = {
    val wire = Wire(new HeapCell)
    wire.exist := exist
    wire.app   := app
    wire
  }

  def mkStkCell(frame: Bool, addr: UInt): StkCell = {
    val wire = Wire(new StkCell)
    wire.frame := frame
    wire.addr  := addr
    wire
  }

  def findMoreDmder(addr: UInt, stk: StackPort[StkCell]): Bool =
    stk.elms > 1.U && stk.top.addr === addr && !stk.snd.frame

  def findNewFrame(addr: UInt, stk: StackPort[StkCell]): Bool =
    stk.elms > 1.U && stk.top.addr === addr && stk.snd.frame

  def findFreeStk(addr: UInt, stk: StackPort[StkCell]): Bool =
    stk.elms === 0.U || (stk.top.frame && stk.top.addr === addr)

  def select1stArg(app: Vec[Atom]): (UInt, UInt) = {
    val (pos, ptr) = (Wire(UInt(2.W)), Wire(Addr))
    when(app(0).isPtr()) {
      pos := 0.U
      ptr := app(0).toPtr().pointer
    }.elsewhen(app(0).isPrm()) {
      when(app(1).isPtr()) {
        pos := 1.U
        ptr := app(1).toPtr().pointer
      }.otherwise {
        pos := 2.U
        ptr := app(2).toPtr().pointer
      }
    }.otherwise { // save this for seq
      pos := 0.U
      ptr := app(0).toPtr().pointer
    }
    (pos, ptr)
  }

  def selectNextArg(app: Vec[Atom]): (UInt, UInt) =
    (2.U, app(2).toPtr().pointer)

  def freeAddrLocal: UInt = regAddrBumper + io.addr_consumed

  def findDmdStk(): UInt =
    threadStacks.indexWhere(s =>
      s.elms >= 1.U && s.top.addr === regInSub.heap_addr
    )

  def genFrameRecord(): Vec[UInt] = {
    val wire = WireInit(currentFrmStk.top)
    wire(regInMain.stack_idx) := mainHeap.io.readwritePorts(0).address
    wire
  }

  def isSensitive(): Bool = {
    val sensitive1 = genIAs1 === IAs1.ExistIAWorkingNormal
    val sensitive2 = genIAs1 === IAs1.ExistIAFresh ||
      genIAs1 === IAs1.NoExist
    val same1 = incomingStk.top.addr === regAddr
    val same2 = currentStk.top.addr === incomingStk.top.addr
    (sensitive1 && same1) || (sensitive2 && same2)
  }

  def writeIncoming(): Unit = {
    incomingStk.pop()
    mainHeap.writeA(
      mkHeapCell(true.B, io.in_main.bits.app),
      incomingStk.top.addr
    )
  }

  def readTarget(p: UInt): Unit = {
    mainHeap.readA(p)
    workingHeap.readA(p)
    demandHeap.writeA(true.B, p)
    regAddr := p
  }

  def select1stArgRead(app: Vec[Atom]): Unit = {
    val (arg_id, ptr) = select1stArg(app)
    io.search := ptr
    readTarget(ptr)
    regArgId := arg_id
  }

  def selectNextArgRead(app: Vec[Atom]): Unit = {
    val (arg_id, ptr) = selectNextArg(app)
    io.search := ptr
    readTarget(ptr)
    regArgId := arg_id
  }

  def findPopRead(pr: (StackPort[StkCell]) => Bool, pop_frm: Boolean): Unit = {
    val stkId = threadStacks.indexWhere(pr)
    threadStacks(stkId).pop()
    if (pop_frm) {
      frameStacks(stkId).pop()
    }
    mainHeap.readA(threadStacks(stkId).snd.addr)
    regInMain.stack_idx := stkId
  }

  def putOutputMain(stk_idx: UInt, app: Vec[Atom]): Unit = {
    io.out_main.valid := true.B
    io.out_main.bits  := Helper.mkActiveApp(stk_idx, app)
  }

  def putOutputSub(): Unit = {
    val dmd = findDmdStk()
    val app = extendToApp(regInSub.app)
    io.out_sub.valid := true.B
    io.out_sub.bits  := Helper.mkActiveApp(dmd, app)
  }

  def writeBack(useB: Boolean): Unit = {
    if (!useB) {
      mainHeap.writeA(mkHeapCell(true.B, regInMain.app), regAddr)
    } else {
      mainHeap.writeB(mkHeapCell(true.B, regInMain.app), regAddr)
    }
  }

  def writeBackBigDrf(app: Vec[Atom], port: Bool): Unit = {
    when(!port) {
      mainHeap.writeA(mkHeapCell(true.B, app), currentStk.top.addr)
    }.otherwise {
      mainHeap.writeB(mkHeapCell(true.B, app), currentStk.top.addr)
    }
  }

  def pushTarget(new_frame: Bool): Unit = {
    workingHeap.writeB(true.B, regAddr)
    currentStk.push(mkStkCell(new_frame, regAddr))
  }

  def cancelNewFrame(): Unit = {
    when(
      genIAs1 === IAs1.ExistWHNF ||
        genIAs1 === IAs1.ExistIAWorkingNewFrame
    ) {
      when(currentStk.elms >= 1.U && currentStk.top.frame) {
        currentFrmStk.pop()
      }
    }
  }

  def stepToNext(): Unit = {
    when(isSensitive()) {
      stmMain := Stm.IDLE
    }.otherwise {
      nextMain()
    }
  }

  // generate the CONSUMEs signal under current state
  def genCONSUMEs: CONSUMEs.Type = {
    val wire = Wire(CONSUMEs())
    when(!io.in_main.fire) {
      wire := CONSUMEs.NoInput
    }.otherwise {
      when(isWHNF(io.in_main.bits.app)) {
        when(threadStacks.exists(findMoreDmder(incomingStk.top.addr, _))) {
          wire := CONSUMEs.InputWHNFWithDmder
        }.otherwise {
          when(incomingStk.elms > 1.U) {
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
    when(threadStacks.exists(findMoreDmder(regAddr, _))) {
      wire := WHNFs.MoreDmders
    }.otherwise {
      when(threadStacks.exists(findNewFrame(regAddr, _))) {
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
    val more_strict_args: Bool =
      regInMain.app(0).isPrm() && regArgId === 1.U && regInMain.app(2).isPtr()

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
    when(demandHeap.readOutB && !regSubMask) {
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

  // consume the next input
  def nextMain(): Unit = {
    io.in_main.ready := true.B
    regInMain        := io.in_main.bits
    switch(genCONSUMEs) {
      is(CONSUMEs.NoInput) {
        stmMain := Stm.IDLE
      }
      is(CONSUMEs.InputIA) {
        select1stArgRead(io.in_main.bits.app)
        regIAddr := incomingStk.top.addr
        stmMain  := Stm.IA
      }
      is(CONSUMEs.InputWHNFWithDmder) {
        findPopRead(findMoreDmder(incomingStk.top.addr, _), false)
        regAddr := incomingStk.top.addr
        stmMain := Stm.WHNF
      }
      is(CONSUMEs.InputWHNFNoDmderNewFrame) {
        incomingStk.pop()
        mainHeap.readA(incomingStk.snd.addr)
        regAddr := incomingStk.top.addr
        incomingFrmStk.pop()
        stmMain := Stm.RESUME
      }
      is(CONSUMEs.InputWHNFNoDmderNoFrame) {
        incomingFrmStk.pop()
        writeIncoming()
        stmMain := Stm.IDLE
      }
    }
  }

  // consume the next input
  def nextSub(): Unit = {
    io.in_sub.ready := io.out_sub.ready && !bBorrowed
    val addr = io.in_sub.bits.heap_addr
    when(io.in_sub.fire) {
      mainHeap.writeB(
        mkHeapCell(true.B, extendToApp(io.in_sub.bits.app)),
        addr
      )
      regInSub := io.in_sub.bits
      when(
        demandHeap.io.readwritePorts(0).address === addr &&
          demandHeap.io.readwritePorts(0).enable
      ) {
        regSubMask := true.B
      }
      demandHeap.readB(addr)
      stmSub := StmSub.WORK
    }.otherwise {
      stmSub := StmSub.IDLE
    }
  }

  def stepWHNF(): Unit = {
    val dmder  = mainHeap.readOutA.app
    val target = regInMain.app

    val (dres1, dres2, is_big) =
      deref(dmder, select1stArg(dmder)._1, target, freeAddrLocal)

    putOutputMain(regInMain.stack_idx, dres1)

    switch(genWHNFs) {
      is(WHNFs.MoreDmders) {
        findPopRead(findMoreDmder(regAddr, _), false)
      }
      is(WHNFs.NewFrame) {
        findPopRead(findNewFrame(regAddr, _), true)
        stmMain := Stm.RESUME
      }
      is(WHNFs.NoNewFrame) {
        bBorrowed := true.B
        val stkId: UInt =
          firstWhereC(threadStacks) { s =>
            s.elms >= 1.U && s.top.addr === regAddr
          }
        when(stkId =/= maxThreads.U) {
          threadStacks(stkId).pop()
          frameStacks(stkId).pop()
        }
        writeBack(true) // TODO avoid update here
        nextMain()
      }
    }

    when(is_big) {
      needSplit                     := true.B
      io.out_big_drf.bits.heap_addr := freeAddrLocal
      io.out_big_drf.bits.app       := dres2
    }
  }

  def stepIA(): Unit = {
    val dmder         = regInMain.app
    val updated_dmder = WireInit(dmder)
    val target        = mainHeap.readOutA.app

    switch(genIAs1) {
      is(IAs1.NoExist) {
        pushTarget(false.B)
      }
      is(IAs1.ExistWHNF) {
        val (dres1, dres2, is_big) =
          deref(dmder, regArgId, target, freeAddrLocal)
        updated_dmder := dres1
        regInMain.app := updated_dmder
        when(is_big) {
          needSplit                     := true.B
          io.out_big_drf.bits.heap_addr := freeAddrLocal
          io.out_big_drf.bits.app       := dres2
        }
      }
      is(IAs1.ExistIAWorkingNormal) {
        pushTarget(true.B) // change this to false.B will disable stk riding
      }
      is(IAs1.ExistIAWorkingNewFrame) { /* do nothing here */ }
      is(IAs1.ExistIAFresh) {
        putOutputMain(regInMain.stack_idx, target)
        pushTarget(false.B)
      }
    }

    switch(genIAs2) {
      is(IAs2.NextStrictArgNewStk) {
        selectNextArgRead(updated_dmder)
        val frame_record = currentFrmStk.top
        val stk_idx      = WireInit(0.U(log2Ceil(maxThreads).W))
        for (i <- maxThreads - 1 to 0 by -1) { // TODO IMPROVE ME
          when(findFreeStk(frame_record(i), threadStacks(i))) {
            stk_idx := i.U
          }
        }
        regInMain.stack_idx := stk_idx
        frameStacks(stk_idx).push(genFrameRecord())
      }
      is(IAs2.NextStrictArgLocal) { selectNextArgRead(updated_dmder) }
      is(IAs2.NoMoreArgsNoEmit) {
        bBorrowed := true.B
        cancelNewFrame()
        mainHeap.writeB(mkHeapCell(true.B, updated_dmder), regIAddr)
        stepToNext()
      }
      is(IAs2.NoMoreArgsCanEmit) {
        cancelNewFrame()
        putOutputMain(regInMain.stack_idx, updated_dmder)
        stepToNext()
      }
    }
  }

  def stepRESUME(): Unit = {
    bBorrowed := true.B
    writeBack(true)
    switch(genRESUMEs) {
      is(RESUMEs.TopInWHNF) {
        regInMain.app := mainHeap.readOutA.app
        currentStk.pop()
        mainHeap.readA(currentStk.snd.addr)
        regAddr := currentStk.top.addr
        stmMain := Stm.WHNF
      }
      is(RESUMEs.TopInIA) {
        nextMain()
      }
    }
  }

  def stepWORK(): Unit = {
    switch(genWORKs) {
      is(WORKs.NotDemanded) {
        nextSub()
      }
      is(WORKs.DmderFound) {
        putOutputSub()
        nextSub()
      }
      is(WORKs.DmderNotFound) {
        demandHeap.readB(regInSub.heap_addr)
      }
    }
  }

  // give default connection
  threadStacks.foreach(s => s.init())
  frameStacks.foreach(s => s.init())
  mainHeap.init()
  demandHeap.init()
  workingHeap.init()
  io.in_main.ready     := false.B
  io.in_sub.ready      := false.B
  io.out_main.valid    := false.B
  io.out_main.bits     := DontCare
  io.out_sub.valid     := false.B
  io.out_sub.bits      := DontCare
  io.out_big_drf.valid := needSplit
  io.out_big_drf.bits  := DontCare
  io.free_addr         := regAddrBumper
  io.search            := DontCare
  regAddrBumper        := regAddrBumper + io.addr_consumed + needSplit.asUInt
  regSubMask           := false.B

  // program injection & start/end control
  when(!busy && io.inject.valid) {
    mainHeap.writeB(mkHeapCell(true.B, io.inject.bits), regAddrBumper)
    regAddrBumper := regAddrBumper + 1.U
  }

  io.done := !busy

  when(io.start && !busy) {
    busy := true.B
    frameStacks(0).push(0.U.asTypeOf(Vec(maxThreads, Addr)))
    putOutputMain(0.U, appBuilder(8, ptrBuilder(0, false)))
  }

  when(io.in_main.fire) {
    when(
      threadStacks(0).elms === 1.U &&
        io.in_main.bits.stack_idx === 0.U &&
        isWHNF(io.in_main.bits.app)
    ) {
      busy := false.B
    }
  }

  // NOTE assume the output of DrfHeap is never blocked.
  //   This is possible as long as the length of its output buffer
  //   is not smaller than maxThreads.
  when(busy) {
    switch(stmMain) {
      is(Stm.IDLE) { nextMain() }
      is(Stm.WHNF) { stepWHNF() }
      is(Stm.IA) { stepIA() }
      is(Stm.RESUME) { stepRESUME() }
    }

    switch(stmSub) {
      is(StmSub.IDLE) { nextSub() }
      is(StmSub.WORK) { stepWORK() }
    }
  }
}

object DrfHeap extends App {
  ChiselStage.emitSystemVerilogFile(
    new DrfHeap,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

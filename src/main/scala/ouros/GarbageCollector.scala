package ouros

import chisel3._
import chisel3.util._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

object CollectorState extends ChiselEnum {
  val IDLE  = Value
  val ROOT  = Value
  val MARK  = Value
  val SWEEP = Value
}

object CellState extends ChiselEnum {
  val FreeList = Value
  val WorkList = Value
  val Unmarked = Value
  val Marked   = Value
}

object MarkMoves extends ChiselEnum {
  val POP_WORKLIST   = Value
  val WAIT_HEAP_READ = Value
  val HANDLE_APP     = Value
}

class GCCell extends Bundle {
  val state = CellState()
  val ptr   = Addr
}

class GarbageCollector extends Module {
  val io = IO(new Bundle {
    val feedback       = Flipped(Decoupled(Addr))
    val deallocate     = Flipped(Decoupled(Addr))
    val free_addr      = Decoupled(Addr)
    val heap_read_addr = Valid(Addr)
    val heap_read      = Flipped(Valid(AppV))
    val monitor        = Flipped(Valid(new ActiveApp))
    // ============ non-essential ports ===================
    val inject      = Input(Bool())
    val inject_addr = Input(Addr)
  })
  val regStm = RegInit(CollectorState.IDLE)
  val gcMem  = Module(new DualPortBlkBoxMem(heapSize, new GCCell, true, true))
  val regFreeHead   = RegInit(0.U.asTypeOf(Addr))
  val regWorkHead   = RegInit(0.U.asTypeOf(Addr))
  val regFreeDrawed = RegInit(false.B)
  val regWorkDrawed = RegInit(false.B)
  val regFreeLen    = RegInit(heapSize.U(log2Ceil(heapSize + 1).W))
  val regWorkLen    = RegInit(0.U(log2Ceil(heapSize + 1).W))
  val regSweeper    = RegInit(0.U.asTypeOf(Addr))
  val regMove       = Reg(MarkMoves())
  val regPreGC      = RegInit(false.B)
  val regHpReader   = RegInit(0.U.asTypeOf(AppV))
  val regBkReader   = RegInit(0.U.asTypeOf(new GCCell))
  val regWorkOn     = RegInit(0.U.asTypeOf(Addr))
  val regAppIdx     = RegInit(0.U(3.W))
  val regMonitors   = RegInit(
    0.U.asTypeOf(Vec(maxThreads, new BitsWithValid(AppV)))
  )
  val constSweepFrom = Reg(Addr)
  val realFreeHead   = Wire(Addr)
  val realWorkHead   = Wire(Addr)
  val bkReadOut      = {
    val wire = Wire(new GCCell)
    when(regPreGC) {
      wire := gcMem.readOutA
    }.otherwise {
      wire := regBkReader
    }
    wire
  }
  // ============ non-essential regs =============

  def mkGCCell(st: CellState.Type, ptr: Option[UInt] = None): GCCell = {
    val wire = Wire(new GCCell)
    wire.state := st
    ptr match {
      case Some(value) => wire.ptr := value
      case None        => wire.ptr := DontCare
    }
    wire
  }

  def pushToFreeList(addr: UInt, oldHead: UInt, usePortA: Boolean): Unit = {
    regFreeHead := addr
    if (usePortA) {
      gcMem.writeA(mkGCCell(CellState.FreeList, Some(oldHead)), addr)
    } else {
      gcMem.writeB(mkGCCell(CellState.FreeList, Some(oldHead)), addr)
    }
  }

  def pushToWorkList(addr: UInt, oldHead: UInt): Unit = {
    regWorkHead := addr
    gcMem.writeB(mkGCCell(CellState.WorkList, Some(oldHead)), addr)
  }

  // TODO gc cache
  def morePtr(app: Vec[Atom]): Bool =
    zipWithIndex(app).exists(p => p.idx > regAppIdx && p.bits.isPtr())

  // TODO gc cache
  def findPtr(app: Vec[Atom]): UInt =
    zipWithIndex(app).indexWhere(p => p.idx > regAppIdx && p.bits.isPtr())

  def markRead(addr: UInt): Unit = {
    gcMem.readA(addr)
    // TODO gc cache
  }

  def consumeWorklist(): Unit = {
    when(regWorkLen === 0.U) {
      regSweeper := 0.U
      regPreGC   := true.B
      regStm     := CollectorState.SWEEP
      gcMem.readA(0.U)
    }.otherwise {
      gcMem.writeA(mkGCCell(CellState.Marked), realWorkHead)
      // TODO gc cache
      regWorkDrawed := true.B
      regWorkLen    := regWorkLen - 1.U
      regWorkOn     := realWorkHead
      regMove       := MarkMoves.WAIT_HEAP_READ
      regAppIdx     := 0.U
    }
  }

  /** Whether there is a mutator request in this cycle. */
  def mutatorRequest(): Bool = {
    val wire = Wire(Bool())
    when(regStm === CollectorState.MARK) {
      wire := io.free_addr.fire || io.feedback.fire
    }.otherwise {
      wire := io.free_addr.fire || io.deallocate.fire || io.feedback.fire
    }
    wire
  }

  def canDealloc: Bool =
    regStm =/= CollectorState.MARK && io.deallocate.bits =/= regSweeper

  def stepIdle(): Unit = {
    when(!mutatorRequest() && regFreeLen <= GcThreshold.U) {
      regStm      := CollectorState.ROOT
      regWorkHead := 0.U
      regWorkLen  := 1.U
      regSweeper  := 0.U
      gcMem.writeB(mkGCCell(CellState.WorkList, Some(0.U)), 0.U)
    }
  }

  def stepRoot(): Unit = {
    when(!mutatorRequest()) {
      when(regSweeper < constSweepFrom - 1.U) {
        val next = regSweeper + 1.U
        regSweeper := next
        pushToWorkList(next, regWorkHead)
        regWorkLen := regWorkLen + 1.U
      }.otherwise {
        regStm   := CollectorState.MARK
        regMove  := MarkMoves.POP_WORKLIST
        regPreGC := false.B
        // TODO gc cache
      }
    }
  }

  def stepMark(): Unit = {
    // defaults
    io.heap_read_addr.valid := true.B
    io.heap_read_addr.bits  := regWorkOn
    regPreGC                := false.B
    when(regPreGC) {
      regBkReader := gcMem.readOutA
    }

    when(regMove === MarkMoves.POP_WORKLIST) {
      io.heap_read_addr.bits := regWorkHead
      when(!mutatorRequest()) { consumeWorklist() }
    }

    when(
      regMove === MarkMoves.WAIT_HEAP_READ && io.heap_read.valid && !mutatorRequest()
    ) {
      when(io.heap_read.bits.exists(_.isPtr())) {
        regHpReader := io.heap_read.bits
        regMove     := MarkMoves.HANDLE_APP
        val found = io.heap_read.bits.indexWhere(_.isPtr())
        markRead(contentsWhere(io.heap_read.bits)(_.isPtr()).getPtr())
        regAppIdx := found
        regPreGC  := true.B
      }.otherwise {
        io.heap_read_addr.bits := realWorkHead
        consumeWorklist()
      }
    }

    when(regMove === MarkMoves.HANDLE_APP && !mutatorRequest()) {
      val markThis = bkReadOut.state === CellState.Unmarked

      when(markThis) {
        pushToWorkList(regHpReader(regAppIdx).getPtr(), regWorkHead)
        regWorkLen := regWorkLen + 1.U
      }

      when(morePtr(regHpReader)) {
        val found = findPtr(regHpReader)
        markRead(regHpReader(found).getPtr())
        regAppIdx := found
        regPreGC  := true.B
      }.elsewhen(regMonitors.exists(_.valid)) {
        val pick = regMonitors.indexWhere(_.valid)
        regMonitors(pick).valid := false.B
        regPreGC                := false.B
        regBkReader             := mkGCCell(CellState.Marked)
        regHpReader             := regMonitors(pick).bits
        regAppIdx               := 0.U
        regMove                 := MarkMoves.HANDLE_APP
      }.otherwise {
        when(markThis) {
          val wHead = regHpReader(regAppIdx).getPtr()
          gcMem.writeA(mkGCCell(CellState.Marked), wHead)
          // take a shortcut, not pushing current one to worklist
          gcMem.io.readwritePorts(1).isWrite := false.B
          // TODO gc cache
          regWorkHead            := regWorkHead
          regWorkLen             := regWorkLen
          regWorkOn              := wHead
          regMove                := MarkMoves.WAIT_HEAP_READ
          regAppIdx              := 0.U
          io.heap_read_addr.bits := wHead
        }.elsewhen(regWorkLen === 0.U) {
          regSweeper := 0.U
          gcMem.readA(0.U)
          regPreGC := true.B
          regStm   := CollectorState.SWEEP
        }.otherwise {
          val wHead = regWorkHead
          gcMem.writeA(mkGCCell(CellState.Marked), wHead)
          // TODO gc cache
          regWorkDrawed          := true.B
          regWorkLen             := regWorkLen - 1.U
          regWorkOn              := wHead
          regMove                := MarkMoves.WAIT_HEAP_READ
          regAppIdx              := 0.U
          io.heap_read_addr.bits := wHead
        }
      }
    }
  }

  def stepSweep(): Unit = {
    // defaults
    regPreGC := false.B
    when(regPreGC) {
      regBkReader := gcMem.readOutA
    }

    when(!mutatorRequest()) {
      when(bkReadOut.state === CellState.Marked) {
        gcMem.writeB(mkGCCell(CellState.Unmarked), regSweeper)
      }.elsewhen(
        bkReadOut.state === CellState.Unmarked
      ) {
        pushToFreeList(regSweeper, realFreeHead, false)
        regFreeLen := regFreeLen + 1.U
      }

      when(regSweeper < (heapSize - 1).U) {
        val next = regSweeper + 1.U
        regSweeper := next
        gcMem.readA(next)
        regPreGC := true.B
      }.otherwise {
        regStm := CollectorState.IDLE
      }
    }

  }

  // default connections
  gcMem.init()
  realFreeHead            := Mux(regFreeDrawed, gcMem.readOutA.ptr, regFreeHead)
  realWorkHead            := Mux(regWorkDrawed, gcMem.readOutA.ptr, regWorkHead)
  regFreeDrawed           := false.B
  regWorkDrawed           := false.B
  regFreeHead             := realFreeHead
  regWorkHead             := realWorkHead
  io.free_addr.valid      := regFreeLen > 0.U
  io.free_addr.bits       := DontCare
  io.deallocate.ready     := true.B
  io.feedback.ready       := true.B
  io.heap_read_addr.valid := false.B
  io.heap_read_addr.bits  := DontCare
  when(regStm =/= CollectorState.MARK && io.monitor.valid) {
    regMonitors(io.monitor.bits.stack_idx).valid := true.B
    regMonitors(io.monitor.bits.stack_idx).bits  := io.monitor.bits.app
  }

  // initialise the free-list
  // assume free_addr.ready === false.B during injection
  when(io.inject) {
    regFreeHead := io.inject_addr + 1.U
    gcMem.writeB(mkGCCell(CellState.Unmarked), io.inject_addr)
    regFreeLen     := regFreeLen - 1.U
    constSweepFrom := io.inject_addr + 1.U
  }

  // handle mutator requests
  when(io.deallocate.fire && canDealloc) {
    io.free_addr.bits := io.deallocate.bits
    when(io.free_addr.fire) {
      // take the free addr from dealloc port directly
      gcMem.writeA(mkGCCell(CellState.FreeList), io.deallocate.bits)
    }.otherwise {
      pushToFreeList(io.deallocate.bits, realFreeHead, true)
      regFreeLen := regFreeLen + 1.U
    }
  }.otherwise {
    io.free_addr.bits := realFreeHead
    when(io.free_addr.fire) {
      regFreeDrawed := true.B
      gcMem.readA(realFreeHead)
      regFreeLen := regFreeLen - 1.U
    }.otherwise {
      /* nothing to do here */
    }
  }

  val feedbackCellState = {
    val wire = WireInit(CellState.Unmarked)
    switch(regStm) {
      is(CollectorState.IDLE) { wire := CellState.Unmarked }
      is(CollectorState.ROOT) { wire := CellState.Unmarked }
      is(CollectorState.MARK) { wire := CellState.WorkList }
      is(CollectorState.SWEEP) {
        when(io.feedback.bits <= regSweeper) { wire := CellState.Unmarked }
          .otherwise { wire := CellState.Marked }
      }
    }
    wire
  }
  when(io.feedback.fire) {
    when(feedbackCellState === CellState.WorkList) {
      regWorkHead := io.feedback.bits
      regWorkLen  := regWorkLen + 1.U
    }
    gcMem.writeB(
      mkGCCell(feedbackCellState, Some(realWorkHead)),
      io.feedback.bits
    )
  }

  // background GC work
  switch(regStm) {
    is(CollectorState.IDLE) { stepIdle() }
    is(CollectorState.ROOT) { stepRoot() }
    is(CollectorState.MARK) { stepMark() }
    is(CollectorState.SWEEP) { stepSweep() }
  }
}

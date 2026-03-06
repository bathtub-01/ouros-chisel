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

class GCCell extends Bundle {
  val state = CellState()
  val ptr   = Addr
}

class GarbageCollector extends Module {
  val io = IO(new Bundle {
    val feedback   = Flipped(Decoupled(Addr))
    val deallocate = Flipped(Decoupled(Addr))
    val free_addr  = Decoupled(Addr)
    // ============ non-essential ports ===================
    val inject      = Input(Bool())
    val inject_addr = Input(Addr)
  })
  val regStm = RegInit(CollectorState.IDLE)
  val gcMem  = Module(new DualPortBlkBoxMem(heapSize, new GCCell, true, true))
  val regFreeHead    = RegInit(0.U.asTypeOf(Addr))
  val regWorkHead    = RegInit(0.U.asTypeOf(Addr))
  val regFreeDrawed  = RegInit(false.B)
  val regWorkDrawed  = RegInit(false.B)
  val regFreeLen     = RegInit(heapSize.U(log2Ceil(heapSize + 1).W))
  val regWorkLen     = RegInit(0.U(log2Ceil(heapSize + 1).W))
  val regSweeper     = RegInit(0.U.asTypeOf(Addr))
  val regMove        = RegInit(0.U(3.W))
  val regPreGC       = RegInit(false.B)
  val constSweepFrom = Reg(Addr)
  val realFreeHead   = Wire(Addr)
  val realWorkHead   = Wire(Addr)
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
        regMove  := 3.U
        regPreGC := false.B
        // TODO gc cache
      }
    }
  }

  def stepMark(): Unit = ???

  def stepSweep(): Unit = ???

  // default connections
  gcMem.init()
  realFreeHead        := Mux(regFreeDrawed, gcMem.readOutA.ptr, regFreeHead)
  realWorkHead        := Mux(regWorkDrawed, gcMem.readOutA.ptr, regWorkHead)
  regFreeDrawed       := false.B
  regWorkDrawed       := false.B
  regFreeHead         := realFreeHead
  regWorkHead         := realWorkHead
  io.free_addr.valid  := regFreeLen > 0.U
  io.free_addr.bits   := DontCare
  io.deallocate.ready := true.B
  io.feedback.ready   := true.B

  // initialise the free-list
  // assume free_addr.ready === false.B during injection
  when(io.inject) {
    regFreeHead := io.inject_addr + 1.U
    gcMem.writeB(mkGCCell(CellState.Unmarked), io.inject_addr)
    regFreeLen     := regFreeLen - 1.U
    constSweepFrom := io.inject_addr + 1.U
  }

  // handle mutator requests FIXME -- more logic for mark-and-sweep
  when(io.deallocate.fire) {
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

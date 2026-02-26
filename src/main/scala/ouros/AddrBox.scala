package ouros

import chisel3._
import chisel3.util._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

class AddrBox extends Module {
  val io = IO(new Bundle {
    val addr_consumers = Vec(consumers, Decoupled(Addr))
    val addr_acquire   = Flipped(Decoupled(Addr))
    val dheap_feedback = Flipped(Valid(Addr))
    val feedback_to_gc = Valid(Addr)
  })
  val addrRegs = RegInit(
    VecInit(Seq.fill(consumers)(0.U.asTypeOf(new BitsWithValid(Addr))))
  )
  val feedbackRegs = RegInit(
    VecInit(Seq.fill(consumers_reducer)(0.U.asTypeOf(new BitsWithValid(Addr))))
  )
  val can_consume = Wire(Vec(consumers, Bool()))

  def anyAddrFire: Bool = io.addr_consumers.exists(_.fire)

  def feedbackChosen: (Bool, UInt) = {
    val wireB = Wire(Bool())
    val wireU = Wire(UInt(log2Ceil(consumers).W))
    when(io.dheap_feedback.valid) {
      wireB := true.B
      wireU := (consumers - 1).U
    }.elsewhen(io.addr_consumers(0).fire) {
      wireB := true.B
      wireU := 0.U
    }.otherwise {
      wireB := feedbackRegs.exists(_.valid)
      wireU := feedbackRegs.indexWhere(_.valid)
    }
    (wireB, wireU)
  }

  can_consume.zipWithIndex.foreach { case (b, idx) =>
    val wantConsume = io.addr_consumers(idx).fire || !addrRegs(idx).valid
    if (idx == 0) {
      b := wantConsume
    } else {
      b := wantConsume || can_consume(idx - 1)
    }
  }

  addrRegs.zipWithIndex.foreach { case (reg, idx) =>
    when(can_consume(idx)) {
      if (idx == consumers - 1) {
        reg.valid := io.addr_acquire.valid
        reg.bits  := io.addr_acquire.bits
      } else {
        reg.valid := addrRegs(idx + 1).valid && !io.addr_consumers(idx + 1).fire
        reg.bits  := addrRegs(idx + 1).bits
      }
    }
  }

  feedbackRegs.zipWithIndex.foreach { case (reg, idx) =>
    when(io.addr_consumers(idx).fire) {
      feedbackRegs(idx) := addrRegs(idx)
    }
  }

  when(feedbackChosen._1 && feedbackChosen._2 < consumers_reducer.U) {
    feedbackRegs(feedbackChosen._2).valid := false.B
  }

  io.addr_acquire.ready := can_consume.last
  io.addr_consumers.zip(addrRegs).foreach { case (port, reg) =>
    port.valid := reg.valid
    port.bits  := reg.bits
  }
  io.feedback_to_gc.valid := feedbackRegs.exists(_.valid) ||
    anyAddrFire || io.dheap_feedback.valid
  when(io.dheap_feedback.valid) {
    io.feedback_to_gc.bits := io.dheap_feedback.bits
  }.elsewhen(io.addr_consumers(0).fire) {
    io.feedback_to_gc.bits := addrRegs(0).bits
  }.otherwise {
    io.feedback_to_gc.bits := feedbackRegs.indexWhere(_.valid)
  }
}

object AddrBox extends App {
  ChiselStage.emitSystemVerilogFile(
    new AddrBox,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

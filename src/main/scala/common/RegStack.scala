package common

import chisel3._
import chisel3.util._
import _root_.circt.stage.ChiselStage

/* This is a basic stack implementation, with registers holding the top two
 * element of the stack, allowing asynchronous-read for its top two elements. */

/**
 * Op code for the stack. Each operation takes one clock cycle to conduct.
 */
object StackOpCode extends ChiselEnum {
  val idle   = Value
  val push   = Value
  val pop    = Value
  val modify = Value
}
import StackOpCode._

class StackPort[T <: Data](depth: Int, t: T) extends Bundle {
  val opcode = Input(StackOpCode())
  val din    = Input(t)
  val top    = Output(t)
  val snd    = Output(t)
  val elms   = Output(UInt(log2Ceil(depth + 1).W))

  def init(): Unit = {
    this   := DontCare
    opcode := StackOpCode.idle
  }

  def push(data: T) = {
    opcode := StackOpCode.push
    din    := data
  }

  def pop() = {
    opcode := StackOpCode.pop
  }

  def modify(data: T) = {
    opcode := StackOpCode.modify
    din    := data
  }
}

class RegStack[T <: Data](depth: Int, t: T) extends Module {
  val io         = IO(new StackPort(depth, t))
  val stkPtr     = RegInit(0.U(log2Ceil(depth).W))
  val stkMem     = Module(new BlockMem(depth, t))
  val topElm     = RegInit(0.U.asTypeOf(t))
  val sndElm     = RegInit(0.U.asTypeOf(t))
  val elmCount   = RegInit(0.U(log2Ceil(depth + 1).W))
  val lastPushed = RegInit(0.U.asTypeOf(t)) // handle pop-after-push
  val justPushed = RegInit(false.B)

  stkMem.init(stkPtr - 1.U)

  switch(io.opcode) {
    is(StackOpCode.idle) {
      justPushed := false.B
    }

    is(StackOpCode.push) {
      topElm := io.din
      sndElm := topElm
      when(elmCount > 1.U) {
        stkMem.write(sndElm, stkPtr)
        stkPtr     := stkPtr + 1.U
        lastPushed := sndElm
        justPushed := true.B
      }
      elmCount := elmCount + 1.U
    }

    is(StackOpCode.pop) {
      topElm := sndElm
      when(justPushed) {
        sndElm := lastPushed
      }.otherwise {
        sndElm := stkMem.readOut
      }
      when(elmCount > 2.U) {
        stkPtr := stkPtr - 1.U
      }
      stkMem.read(stkPtr - 2.U)
      elmCount   := elmCount - 1.U
      justPushed := false.B
    }

    is(StackOpCode.modify) {
      topElm     := io.din
      justPushed := false.B
    }
  }

  io.top  := topElm
  io.snd  := sndElm
  io.elms := elmCount

  def init: Unit = {
    io        := DontCare
    io.opcode := StackOpCode.idle
  }

  def idle = init

  def push(data: T) = {
    io.opcode := StackOpCode.push
    io.din    := data
  }

  def pop = {
    io.opcode := StackOpCode.pop
  }

  def modify(data: T) = {
    io.opcode := StackOpCode.modify
    io.din    := data
  }

  def elms: UInt = io.elms
}

object RegStack extends App {
  ChiselStage.emitSystemVerilogFile(
    new RegStack(32, UInt(16.W)),
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

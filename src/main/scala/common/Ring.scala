package common

import chisel3._
import chisel3.util._
import _root_.circt.stage.ChiselStage

/**
 * A FIFO-styled ring for combinatonal searching of elements inside
 *
 * @param size
 *   size of the ring
 * @param t
 *   element type
 */
class Ring[T <: Data](size: Int, t: T) extends Module {
  val io = IO(new Bundle {
    val in_fire  = Input(Bool())
    val out_fire = Input(Bool())
    val din      = Input(t)
    val search   = Input(t)
    val found    = Output(Bool())
  })
  require(isPow2(size))

  val reg_bank = RegInit(
    VecInit(Seq.fill(size)(0.U.asTypeOf(new BitsWithValid(t))))
  )
  val head = RegInit(0.U((log2Ceil(size).W)))
  val tail = RegInit(0.U((log2Ceil(size).W)))

  def put(v: T): Unit = {
    io.in_fire := true.B
    io.din     := v
  }

  // NOTE is this a bit silly?
  io.found := !(io.out_fire && reg_bank(head).bits === io.search) &&
    reg_bank.exists(p => p.valid && p.bits === io.search)

  when(io.out_fire) {
    reg_bank(head).valid := false.B
    head                 := head + 1.U
  }

  when(io.in_fire) {
    reg_bank(tail).valid := true.B
    reg_bank(tail).bits  := io.din
    tail                 := tail + 1.U
  }
}

object Ring extends App {
  ChiselStage.emitSystemVerilogFile(
    new Ring(4, UInt(16.W)),
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

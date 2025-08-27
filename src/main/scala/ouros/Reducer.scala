package ouros

import chisel3._
import chisel3.util._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

/**
 * Combinator reduction block
 *
 * @param pipelined
 *   optionally insert an output register
 */
class Reducer(pipelined: Boolean) extends Module {
  val io = IO(new Bundle {
    val free_addr     = Input(UInt(log2Ceil(heapSize).W))
    val in            = Flipped(Decoupled(new Application))
    val out           = Decoupled(new Application)
    val addr_consumed = Output(UInt(2.W))
  })
  val outReg = RegInit(0.U.asTypeOf(new BitsWithValid(new Application)))
}

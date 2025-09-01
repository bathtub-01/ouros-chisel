package common

import chisel3._
import chisel3.util._

import SystemConfig._
import Helper._

/**
 *   - NOP: non-op
 *   - PTR: pointer to the heap
 *   - COM: combinator
 *   - INT: integer
 *   - PRM: primitive op
 *   - Y: Y combinator
 *   - ERR: error code
 */
object AtomType extends ChiselEnum {
  val NOP = Value
  val PTR = Value
  val COM = Value
  val INT = Value
  val PRM = Value
  val Y   = Value
  val ERR = Value
}

abstract class AtomPayload extends Bundle

/**
 * Payload for FUN and PTR, which only contains a pointer
 */
class PtrPayload extends AtomPayload {
  val unique  = Bool()
  val pointer = UInt(atomPayloadSize.W)
}

/**
 * Payload for COM, with arity, pattern and an index vector
 */
class ComPayload extends AtomPayload {
  val arity   = UInt(log2Ceil(comArity + 1).W)
  val pattern = UInt(log2Ceil(comPattern).W)
  val idxs    = Vec(comIdxs, UInt(log2Ceil(comArity).W))
}

/**
 * Payload for INT, which only contains the value
 */
class IntPayload extends AtomPayload {
  val value = SInt(atomPayloadSize.W)
}

object AluOpCode extends ChiselEnum {
  val eq      = Value
  val le      = Value
  val lt      = Value
  val add_sub = Value
  val mult    = Value
}

/**
 *   - is_sub: specify add/sub for adder. Must assert for both substraction and
 *     comparison.
 *   - is_cond_inv: inverse the result of conditional test (eq -> neq, le -> gt,
 *     lt -> ge). Must be cleared for non-comparison instr
 */
class AluFunction extends Bundle {
  val opcode      = AluOpCode()
  val is_sub      = Bool()
  val is_cond_inv = Bool()
}

/**
 * Payload for PRM, contains the control information to ALU
 */
class PrmPayload extends AtomPayload {
  val fun = new AluFunction
}

class Atom extends Bundle {
  val atomType = AtomType()
  val payload  = Bits(atomPayloadSize.W)

  def toPrm(): PrmPayload = this.payload.asTypeOf(new PrmPayload)
  def toInt(): IntPayload = this.payload.asTypeOf(new IntPayload)
  def toCom(): ComPayload = this.payload.asTypeOf(new ComPayload)
  def toPtr(): PtrPayload = this.payload.asTypeOf(new PtrPayload)

  def isPtr(): Bool = this.atomType === AtomType.PTR
  def isCom(): Bool = this.atomType === AtomType.COM
  def isInt(): Bool = this.atomType === AtomType.INT
  def isPrm(): Bool = this.atomType === AtomType.PRM
}

class ActiveApp extends Bundle {
  val stack_idx = UInt(log2Ceil(maxThreads).W)
  val app       = Vec(maxAppLen, new Atom)
}

class FrozenApp(appLen: Int) extends Bundle {
  val heap_addr = Addr
  val app       = Vec(appLen, new Atom)
}

package common

import chisel3._
import chisel3.util._

import SystemConfig._

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

/**
 * Payload for PRM, contains the control information to ALU
 */
// class PrmPayload extends AtomPayload {
//   import mutator.ALUFunction
//   val fun  = new ALUFunction
//   val swap = Bool()
// }

class Atom extends Bundle {
  val atomType = AtomType()
  val payload  = Bits(atomPayloadSize.W)
}

class Application extends Bundle {
  val app = Vec(maxAppLen, new Atom)
}

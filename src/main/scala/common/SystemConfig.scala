package common

import chisel3._
import chisel3.util._

object SystemConfig {

  /** size of an Atom
    */
  val atomSize = 32

  /** maximum arity of a structured combinator
    */
  val comArity = 7

  /** patterns supported by structured combinator
    */
  val comPattern = 64

  /** maximum number of holes in a structured combinator
    */
  val comIdxs = 6

  /** maximum length of an application
    */
  val maxAppLen = 8

  /** cells in the heap
    */
  val heapSize = 512 * 1024

  def atomPayloadSize = atomSize - AtomType.getWidth
}

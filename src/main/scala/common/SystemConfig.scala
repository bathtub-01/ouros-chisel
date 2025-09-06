package common

import chisel3._
import chisel3.util._

object SystemConfig {

  /**
   * size of an Atom
   */
  val atomSize = 32

  /**
   * maximum arity of a structured combinator
   */
  val comArity = 7

  /**
   * patterns supported by structured combinator
   */
  val comPattern = 64

  /**
   * maximum number of holes in a structured combinator
   */
  val comIdxs = 6

  /**
   * maximum length of an application, require:
   *
   * maxApplen >= comArity + 1
   *
   * maxApplen >= comIdxs
   */
  val maxAppLen = 8

  /**
   * cells in the heap
   */
  val heapSize = 64 * 1024

  /**
   * thread resource in a core (number of stacks)
   */
  val maxThreads = 8

  /**
   * depth of the thread stack in DrfHeap
   */
  val threadStkDepth = 256

  /**
   * depth of the frame stack in DrfHeap
   */
  val frameStkDepth = 64

  object BufferConfig {
    val depth: Int       = maxThreads
    val pipe: Boolean    = false
    val flow: Boolean    = false
    val syncMem: Boolean = false
  }

  val atomPayloadSize = atomSize - AtomType.getWidth
}

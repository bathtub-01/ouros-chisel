package common

import chisel3._
import chisel3.util._

object SystemConfig {

  /** size of an Atom */
  val atomSize = 32

  /** maximum arity of a structured combinator */
  val comArity = 7

  /**
   * maximum length of an application, require:
   *
   * maxApplen >= comArity + 1
   *
   * maxApplen >= comIdxs
   */
  val maxAppLen = 8

  val consumers_reducer = maxAppLen - 1
  val consumers_dheap   = 1
  val consumers: Int    = consumers_reducer + consumers_dheap

  /** cells in the heap */
  val heapSize = 2 * 1024 // 2 * 1024

  /** thread resource in a core (number of stacks) */
  val maxThreads = 4

  val bufferSize = maxThreads

  /** depth of the thread stack in DrfHeap */
  val threadStkDepth = 512 // 256

  /** depth of the frame stack in DrfHeap */
  val frameStkDepth = 64

  /** size of the combinator table */
  val progSize = 1024

  /** whether the ALU block is pipelined */
  val AluPipe: Boolean = false

  val atomPayloadSize = atomSize - AtomType.getWidth

  /**
   * When the free cells are lesser than (GCAt * heapSize), a GC round is
   * triggered
   */
  val GcAt: Double     = 0.2
  val GcThreshold: Int = (heapSize.toDouble * GcAt).toInt
}

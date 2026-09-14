package ouros

import common.ProgramMemoryFiles
import common.SystemConfig._

/**
 * Program image metadata that is fixed at Chisel elaboration time.
 *
 * The .mem files themselves are emitted next to the generated SystemVerilog.
 * heapWords records only the statically occupied prefix of heap.mem; the file
 * is padded to the full BRAM depth for deterministic FPGA initialization.
 */
case class ProgramImage(
    heapFile: String,
    combFile: String,
    heapWords: Int,
) {
  require(heapFile.trim.nonEmpty, "heapFile must not be empty")
  require(combFile.trim.nonEmpty, "combFile must not be empty")
  require(heapWords > 0, "a program must contain at least one heap cell")
  require(
    heapWords <= heapSize,
    s"program heap image has $heapWords cells, but heapSize is $heapSize"
  )

  def memoryFiles: ProgramMemoryFiles =
    ProgramMemoryFiles(heapFile, combFile)
}

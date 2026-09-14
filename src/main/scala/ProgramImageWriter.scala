import chisel3._
import chisel3.util._

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}

import benchmarks.Benchmark
import common._
import common.SystemConfig._
import ouros.ProgramImage

/**
 * Converts the readable Scala benchmark images into the two files consumed by
 * the FPGA memories.
 *
 * heap.mem: 4096 x 260-bit words (65 hex digits per line)
 * comb.mem: 1024 x 256-bit words (64 hex digits per line)
 *
 * Both files are padded to the full configured memory depth.  ProgramImage's
 * heapWords records only the occupied heap prefix used to bootstrap the GC.
 */
object ProgramImageWriter {
  private val appBits     = maxAppLen * atomSize
  private val appHexChars = (appBits + 3) / 4
  private val lenBits     = log2Ceil(maxAppLen + 1)
  private val heapBits    = appBits + lenBits
  private val heapHexChars = (heapBits + 3) / 4

  private def fixedHex(value: BigInt, bits: Int, chars: Int): String = {
    require(value >= 0, s"negative memory word: $value")
    require(
      value.bitLength <= bits,
      s"value 0x${value.toString(16)} does not fit in $bits bits"
    )
    val raw = value.toString(16)
    ("0" * (chars - raw.length)) + raw
  }

  /**
   * Chisel Vec packing places element 0 in the least-significant position.
   * Packing explicitly here makes the file format independent of Scala
   * collection formatting.
   */
  private def packApp(app: Vec[Atom]): BigInt = {
    require(app.length == maxAppLen)
    app.zipWithIndex.foldLeft(BigInt(0)) { case (acc, (atom, idx)) =>
      val word = atom.litValue
      require(
        word.bitLength <= atomSize,
        s"atom $idx does not fit in $atomSize bits"
      )
      acc | (word << (idx * atomSize))
    }
  }

  /**
   * NOP is the all-zero Atom in the generated Scala images.  appBuilder pads
   * unused tail positions with NOP, so the logical length is the last non-zero
   * Atom plus one.
   */
  private def appLength(app: Vec[Atom]): Int = {
    val words    = app.map(_.litValue)
    val firstNop = words.indexWhere(_ == 0)
    val len      = if (firstNop < 0) maxAppLen else firstNop
    require(len > 0, "heap image contains an empty App")
    require(
      words.drop(len).forall(_ == 0),
      "App contains a non-NOP Atom after NOP padding"
    )
    len
  }

  /**
   * HeapCell is declared as { appLen, app }; Chisel Bundle serialization puts
   * the earlier field in the more-significant position.
   */
  private def packHeapCell(app: Vec[Atom]): BigInt =
    (BigInt(appLength(app)) << appBits) | packApp(app)

  private def writeWords(
      path: Path,
      words: Seq[BigInt],
      depth: Int,
      bits: Int,
      chars: Int,
  ): Unit = {
    require(
      words.length <= depth,
      s"${path.getFileName}: ${words.length} words exceed depth $depth"
    )

    val writer = Files.newBufferedWriter(path, StandardCharsets.US_ASCII)
    try {
      for (i <- 0 until depth) {
        val value = if (i < words.length) words(i) else BigInt(0)
        writer.write(fixedHex(value, bits, chars))
        writer.newLine()
      }
    } finally {
      writer.close()
    }
  }

  def write(benchmark: Benchmark, outDir: Path): ProgramImage = {
    Files.createDirectories(outDir)

    require(
      benchmark.heap_img.length <= heapSize,
      s"heap image has ${benchmark.heap_img.length} cells; heapSize=$heapSize"
    )
    require(
      benchmark.comb_img.length <= progSize,
      s"combinator image has ${benchmark.comb_img.length} cells; progSize=$progSize"
    )

    val heapPath = outDir.resolve("heap.mem")
    val combPath = outDir.resolve("comb.mem")

    writeWords(
      heapPath,
      benchmark.heap_img.map(packHeapCell),
      heapSize,
      heapBits,
      heapHexChars,
    )
    writeWords(
      combPath,
      benchmark.comb_img.map(packApp),
      progSize,
      appBits,
      appHexChars,
    )

    // Keep file names relative in the generated RTL so the whole output
    // directory can be moved into a Vivado project as one artifact bundle.
    ProgramImage(
      heapFile = "heap.mem",
      combFile = "comb.mem",
      heapWords = benchmark.heap_img.length,
    )
  }
}

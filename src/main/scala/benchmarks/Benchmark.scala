package benchmarks

import chisel3._
import chisel3.util._

import common._

trait Benchmark {
  val heap_img: Seq[Vec[Atom]]
  val comb_img: Seq[Vec[Atom]]
  val combinatorCount: Int
}

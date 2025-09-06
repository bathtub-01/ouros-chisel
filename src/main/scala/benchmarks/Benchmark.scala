package benchmarks

import chisel3._
import chisel3.util._

import common._

trait Benchmark {
  val prog: Seq[Vec[Atom]]
  val combinatorCount: Int
}

package benchmarks
import common.Helper._
import chisel3.Vec
import common.Atom

object BoolAnd extends Benchmark {
  val combinatorCount: Int = 0
  val prog: Seq[Vec[Atom]] = Seq(
    appBuilder(
      ptrBuilder(1),
      comBuilder(2, 0, List(0)),
      comBuilder(2, 0, List(1))
    ),
    appBuilder(
      comBuilder(3, 2, List(1, 2)),
      comBuilder(2, 0, List(1))
    )
  )
}

object BoolNest extends Benchmark {
  val combinatorCount: Int = 0
  val prog: Seq[Vec[Atom]] = Seq(
    appBuilder(
      ptrBuilder(4),
      ptrBuilder(2),
      ptrBuilder(2)
    ),
    appBuilder(
      comBuilder(3, 2, List(1, 2)),
      comBuilder(2, 0, List(1))
    ),
    appBuilder(
      comBuilder(4, 15, List(0, 1, 2, 1, 3)),
      ptrBuilder(1),
      ptrBuilder(3),
      comBuilder(2, 0, List(0)),
      comBuilder(2, 0, List(1))
    ),
    appBuilder(
      ptrBuilder(1),
      comBuilder(2, 0, List(0))
    ),
    appBuilder(
      comBuilder(2, 1, List(1)),
      comBuilder(2, 0, List(0))
    )
  )
}

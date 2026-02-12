package benchmarks
import common.Helper._
import chisel3.Vec
import common.Atom

object BoolAnd extends Benchmark {
  val combinatorCount: Int = 0
  override def toString(): String = "BoolAnd"
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
  override def toString(): String = "BoolNest"
  val prog: Seq[Vec[Atom]] = Seq(
    appBuilder(
      ptrBuilder(4),
      ptrBuilder(2),
      ptrBuilder(2)
    ),
    appBuilder(
      comBuilder(3, 2, List(1, 2, 0)),
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
      comBuilder(2, 1, List(1, 0)),
      comBuilder(2, 0, List(0))
    )
  )
}

object AluOp extends Benchmark {
  val combinatorCount: Int = 0
  override def toString(): String = "AluOp"
  val prog: Seq[Vec[Atom]] = Seq(
    appBuilder(
      prmBuilder("=="),
      intBuilder(42),
      intBuilder(42),
      ptrBuilder(2),
      ptrBuilder(1)
    ),
    appBuilder(
      prmBuilder("*"),
      ptrBuilder(3),
      ptrBuilder(4)
    ),
    appBuilder(
      prmBuilder("-"),
      ptrBuilder(3),
      ptrBuilder(4)
    ),
    appBuilder(
      prmBuilder("+"),
      intBuilder(4),
      intBuilder(5)
    ),
    appBuilder(
      prmBuilder("*"),
      ptrBuilder(3),
      intBuilder(2)
    )
  )
}

object MapY extends Benchmark {
override def toString() = "Map" 
val combinatorCount = 20
val prog = Seq(
 // FUN0Map.main
appBuilder( // 0
ptrBuilder(4),
prmBuilder("+"),
intBuilder(0),
ptrBuilder(3),
),
appBuilder( // 1
ptrBuilder(9),
intBuilder(0),
intBuilder(49),
),
appBuilder( // 2
comBuilder(3,2,List(0, 2, 1)), // XXX
prmBuilder("+"),
intBuilder(1),
),
appBuilder( // 3
ptrBuilder(6),
ptrBuilder(2),
ptrBuilder(1),
),
 // FUN1NanoPrelude.foldr'
appBuilder( // 4
comBuilder(4,7,List(0, 1, 2, 3)), // X(XXX)
yBuilder(),
ptrBuilder(5),
),
appBuilder( // 5
comBuilder(5,16,List(4, 2, 0, 1, 3)), // XX(XXX)
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
),
 // FUN2NanoPrelude.map
appBuilder( // 6
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(8),
),
appBuilder( // 7
comBuilder(5,15,List(0, 1, 3, 2, 4)), // X(XX)(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 8
comBuilder(5,16,List(4, 0, 1, 2, 3)), // XX(XXX)
comBuilder(2,0,List(0)), // X
ptrBuilder(7),
),
 // FUN3NanoPrelude.enumFromTo
appBuilder( // 9
comBuilder(5,15,List(0, 1, 4, 2, 3)), // X(XX)(XX)
ptrBuilder(11),
ptrBuilder(10),
ptrBuilder(15),
),
appBuilder( // 10
comBuilder(3,2,List(0, 2, 1)), // XXX
prmBuilder("<="),
),
 // FUN4NanoPrelude.takeWhile
appBuilder( // 11
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(14),
),
appBuilder( // 12
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 13
comBuilder(5,42,List(1, 3, 0, 2, 3, 4)), // XXX(XXX)
comBuilder(2,0,List(0)), // X
),
appBuilder( // 14
comBuilder(6,48,List(5, 0, 1, 3, 2, 4)), // XX(XX(XX))
comBuilder(2,0,List(0)), // X
ptrBuilder(13),
ptrBuilder(12),
),
 // FUN5NanoPrelude.enumFrom
appBuilder( // 15
comBuilder(5,49,List(0, 4, 1, 2, 4, 3)), // XX(X(XXX))
comBuilder(4,2,List(3, 0, 1)), // XXX
ptrBuilder(15),
prmBuilder("+"),
intBuilder(1),
),
)
}

package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
// Functions in this file: 14
// Apps in this file: 43
// Combinators in this file: 64
object Braun extends Benchmark {
override def toString() = "Braun" 
val combinatorCount = 64
val prog = Seq(
 // FUN0Braun.main
appBuilder( // 0
ptrBuilder(4),
ptrBuilder(3),
),
appBuilder( // 1
ptrBuilder(36),
intBuilder(0),
intBuilder(255),
),
appBuilder( // 2
ptrBuilder(32),
intBuilder(2),
ptrBuilder(1),
),
appBuilder( // 3
ptrBuilder(5),
ptrBuilder(9),
ptrBuilder(2),
),
 // FUN1Braun.int
appBuilder( // 4
comBuilder(3,2,List(2, 0, 1)), // XXX
intBuilder(0),
intBuilder(1),
),
 // FUN2NanoPrelude.all
appBuilder( // 5
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(7),
),
appBuilder( // 6
comBuilder(5,15,List(0, 1, 3, 2, 4)), // X(XX)(XX)
ptrBuilder(8),
),
appBuilder( // 7
comBuilder(5,16,List(4, 0, 1, 2, 3)), // XX(XXX)
comBuilder(2,0,List(1)), // X
ptrBuilder(6),
),
 // FUN3Data.Bool.&&
appBuilder( // 8
comBuilder(2,1,List(1, 0)), // XX
comBuilder(2,0,List(0)), // X
),
 // FUN4Braun.prop
appBuilder( // 9
comBuilder(4,17,List(0, 3, 1, 2, 3)), // XX(X(XX))
ptrBuilder(10),
ptrBuilder(14),
ptrBuilder(22),
),
 // FUN5Braun.equal
appBuilder( // 10
comBuilder(5,40,List(3, 4, 0, 1, 2, 4)), // X(XXX)(XX)
comBuilder(2,0,List(1)), // X
ptrBuilder(13),
ptrBuilder(12),
),
appBuilder( // 11
comBuilder(6,37,List(0, 2, 4, 1, 3, 5)), // XXXX(XX)
prmBuilder("=="),
comBuilder(2,0,List(0)), // X
),
appBuilder( // 12
comBuilder(6,48,List(3, 0, 1, 4, 2, 5)), // XX(XX(XX))
comBuilder(2,0,List(0)), // X
ptrBuilder(11),
ptrBuilder(10),
),
appBuilder( // 13
comBuilder(3,0,List(0)), // X
comBuilder(2,0,List(0)), // X
),
 // FUN6Braun.toList
appBuilder( // 14
comBuilder(3,2,List(2, 0, 1)), // XXX
ptrBuilder(16),
comBuilder(2,0,List(0)), // X
),
appBuilder( // 15
comBuilder(4,15,List(0, 1, 2, 1, 3)), // X(XX)(XX)
ptrBuilder(17),
ptrBuilder(14),
),
appBuilder( // 16
comBuilder(5,16,List(0, 2, 1, 3, 4)), // XX(XXX)
comBuilder(4,2,List(3, 0, 1)), // XXX
ptrBuilder(15),
),
 // FUN7Braun.ilv
appBuilder( // 17
comBuilder(3,6,List(1, 2, 0, 2)), // XX(XX)
ptrBuilder(21),
),
appBuilder( // 18
comBuilder(5,16,List(0, 3, 1, 2, 4)), // XX(XXX)
comBuilder(4,2,List(3, 0, 1)), // XXX
ptrBuilder(17),
),
appBuilder( // 19
comBuilder(6,46,List(0, 2, 1, 3, 4, 5)), // XX(XXXX)
comBuilder(4,2,List(3, 0, 1)), // XXX
ptrBuilder(18),
),
appBuilder( // 20
comBuilder(5,40,List(1, 0, 3, 4, 2, 4)), // X(XXX)(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 21
comBuilder(4,11,List(0, 2, 1, 3, 3)), // XX(XX)X
ptrBuilder(20),
ptrBuilder(19),
),
 // FUN8Braun.fromList'
appBuilder( // 22
comBuilder(3,2,List(2, 0, 1)), // XXX
comBuilder(2,0,List(1)), // X
ptrBuilder(25),
),
appBuilder( // 23
comBuilder(5,17,List(0, 3, 1, 4, 2)), // XX(X(XX))
comBuilder(5,4,List(3, 0, 1, 2)), // XXXX
ptrBuilder(22),
comBuilder(2,0,List(0)), // X
),
appBuilder( // 24
comBuilder(5,43,List(0, 3, 4, 1, 4, 2)), // XXX(X(XX))
ptrBuilder(23),
ptrBuilder(22),
comBuilder(2,0,List(1)), // X
),
appBuilder( // 25
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
ptrBuilder(24),
ptrBuilder(26),
),
 // FUN9Braun.unravel
appBuilder( // 26
comBuilder(3,2,List(2, 0, 1)), // XXX
ptrBuilder(31),
ptrBuilder(30),
),
appBuilder( // 27
comBuilder(2,1,List(1, 0)), // XX
comBuilder(2,0,List(0)), // X
),
appBuilder( // 28
comBuilder(6,34,List(5, 0, 2, 4, 1, 3)), // X(XX(XX))X
comBuilder(4,2,List(3, 0, 1)), // XXX
comBuilder(2,0,List(1)), // X
),
appBuilder( // 29
comBuilder(4,11,List(0, 2, 1, 3, 3)), // XX(XX)X
ptrBuilder(28),
ptrBuilder(27),
),
appBuilder( // 30
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
ptrBuilder(29),
ptrBuilder(26),
),
appBuilder( // 31
comBuilder(2,2,List(1, 0, 0)), // XXX
comBuilder(2,0,List(0)), // X
),
 // FUN10NanoPrelude.replicate
appBuilder( // 32
comBuilder(4,10,List(0, 1, 3, 2, 3)), // X(XX)XX
ptrBuilder(35),
ptrBuilder(34),
comBuilder(2,0,List(0)), // X
),
appBuilder( // 33
comBuilder(4,7,List(0, 1, 3, 2)), // X(XXX)
ptrBuilder(32),
prmBuilder("-"),
intBuilder(1),
),
appBuilder( // 34
comBuilder(4,16,List(0, 3, 1, 2, 3)), // XX(XXX)
comBuilder(4,2,List(3, 0, 1)), // XXX
ptrBuilder(33),
),
appBuilder( // 35
comBuilder(6,28,List(0, 4, 1, 2, 5, 3)), // XXX(XX)X
prmBuilder("<="),
intBuilder(0),
),
 // FUN11NanoPrelude.enumFromTo
appBuilder( // 36
comBuilder(5,15,List(0, 1, 4, 2, 3)), // X(XX)(XX)
ptrBuilder(38),
ptrBuilder(37),
ptrBuilder(42),
),
appBuilder( // 37
comBuilder(3,2,List(0, 2, 1)), // XXX
prmBuilder("<="),
),
 // FUN12NanoPrelude.takeWhile
appBuilder( // 38
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(41),
),
appBuilder( // 39
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 40
comBuilder(5,42,List(1, 3, 0, 2, 3, 4)), // XXX(XXX)
comBuilder(2,0,List(0)), // X
),
appBuilder( // 41
comBuilder(6,48,List(5, 0, 1, 3, 2, 4)), // XX(XX(XX))
comBuilder(2,0,List(0)), // X
ptrBuilder(40),
ptrBuilder(39),
),
 // FUN13NanoPrelude.enumFrom
appBuilder( // 42
comBuilder(5,49,List(0, 4, 1, 2, 4, 3)), // XX(X(XXX))
comBuilder(4,2,List(3, 0, 1)), // XXX
ptrBuilder(42),
prmBuilder("+"),
intBuilder(1),
),
)
}
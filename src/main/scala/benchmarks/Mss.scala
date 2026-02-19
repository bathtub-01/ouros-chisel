package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Mss extends Benchmark {
override def toString() = "Mss" 
val combinatorCount = 31
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,4),
ptrBuilder(2, false, false),
),
appBuilder( // 1
prmBuilder("-"),
intBuilder(0),
intBuilder(20),
),
appBuilder( // 2
comBuilder(2,58),
ptrBuilder(1, false, false),
intBuilder(20),
),
// AExp1
appBuilder( // 3
comBuilder(2,13),
prmBuilder("+"),
intBuilder(0),
),
)
val comb_img = Seq(
// AExp0
appBuilder( // 0
argBuilder(0, true),
),
// AExp1
appBuilder( // 1
argBuilder(1, true),
),
// AExp2
appBuilder( // 2
comBuilder(1,20),
ptrBuilder(3, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,23),
argBuilder(0, true),
),
// AExp3
appBuilder( // 4
comBuilder(1,7),
ptrBuilder(0, true, true),
),
appBuilder( // 5
comBuilder(1,2),
argBuilder(0, true),
),
// AExp4
appBuilder( // 6
prmBuilder(">"),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(1, false),
argBuilder(0, false),
),
// AExp5
appBuilder( // 7
argBuilder(0, true),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 8
comBuilder(2,13),
comBuilder(2,6),
),
// AExp6
appBuilder( // 9
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
argBuilder(1, true),
argBuilder(3, true),
),
// AExp7
appBuilder( // 11
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(4,9),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp8
appBuilder( // 13
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(4,11),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 15
comBuilder(4,22),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 16
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 17
argBuilder(0, true),
argBuilder(2, true),
),
// AExp10
appBuilder( // 18
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 19
comBuilder(4,15),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 20
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 21
comBuilder(3,18),
argBuilder(0, true),
),
// AExp12
appBuilder( // 22
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp13
appBuilder( // 23
comBuilder(1,30),
comBuilder(1,41),
ptrBuilder(0, true, true),
),
appBuilder( // 24
comBuilder(1,46),
argBuilder(0, true),
),
// AExp14
appBuilder( // 25
comBuilder(2,36),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 26
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 27
argBuilder(0, true),
argBuilder(2, true),
),
// AExp15
appBuilder( // 28
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(4,25),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp16
appBuilder( // 30
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(3,28),
argBuilder(0, true),
),
// AExp17
appBuilder( // 32
comBuilder(4,22),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 33
argBuilder(0, true),
argBuilder(2, true),
),
// AExp18
appBuilder( // 34
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 35
comBuilder(3,32),
argBuilder(1, true),
),
// AExp19
appBuilder( // 36
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 37
comBuilder(3,34),
argBuilder(1, true),
),
// AExp20
appBuilder( // 38
comBuilder(4,22),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 39
comBuilder(1,41),
argBuilder(1, false),
),
appBuilder( // 40
comBuilder(4,22),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp21
appBuilder( // 41
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,38),
),
// AExp22
appBuilder( // 42
comBuilder(1,46),
ptrBuilder(0, true, true),
),
appBuilder( // 43
comBuilder(1,53),
argBuilder(0, true),
),
// AExp23
appBuilder( // 44
comBuilder(4,22),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 45
comBuilder(1,42),
argBuilder(0, false),
),
// AExp24
appBuilder( // 46
argBuilder(0, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 47
comBuilder(3,44),
argBuilder(0, false),
),
appBuilder( // 48
comBuilder(4,22),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp25
appBuilder( // 49
comBuilder(4,22),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(1,53),
argBuilder(1, true),
),
// AExp26
appBuilder( // 51
argBuilder(1, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(4,49),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp27
appBuilder( // 53
argBuilder(0, true),
errorBuilder(1),
comBuilder(2,51),
),
// AExp28
appBuilder( // 54
comBuilder(2,58),
ptrBuilder(0, true, true),
),
appBuilder( // 55
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp29
appBuilder( // 56
comBuilder(4,22),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(1,54),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp30
appBuilder( // 58
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 59
comBuilder(2,56),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
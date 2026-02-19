package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Queens extends Benchmark {
override def toString() = "Queens" 
val combinatorCount = 31
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,2),
intBuilder(6),
),
// AExp1
appBuilder( // 1
yBuilder(),
comBuilder(3,6),
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
ptrBuilder(1, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,17),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp3
appBuilder( // 4
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 5
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp4
appBuilder( // 6
argBuilder(2, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 7
comBuilder(3,4),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp5
appBuilder( // 8
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 9
prmBuilder("-"),
argBuilder(1, true),
intBuilder(1),
),
// AExp6
appBuilder( // 10
comBuilder(1,24),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 11
comBuilder(2,8),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 12
comBuilder(2,32),
argBuilder(0, true),
),
// AExp7
appBuilder( // 13
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 14
prmBuilder("=="),
argBuilder(2, false),
intBuilder(0),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 15
comBuilder(4,13),
comBuilder(2,0),
comBuilder(2,0),
),
appBuilder( // 16
comBuilder(3,10),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp9
appBuilder( // 17
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 18
comBuilder(3,14),
argBuilder(0, true),
),
// AExp10
appBuilder( // 19
comBuilder(2,30),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 20
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 21
argBuilder(0, true),
argBuilder(2, true),
),
// AExp11
appBuilder( // 22
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 23
comBuilder(4,19),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp12
appBuilder( // 24
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 25
comBuilder(3,22),
argBuilder(0, true),
),
// AExp13
appBuilder( // 26
comBuilder(4,13),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 27
argBuilder(0, true),
argBuilder(2, true),
),
// AExp14
appBuilder( // 28
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(3,26),
argBuilder(1, true),
),
// AExp15
appBuilder( // 30
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 31
comBuilder(3,28),
argBuilder(1, true),
),
// AExp16
appBuilder( // 32
comBuilder(1,24),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(1,63),
argBuilder(0, true),
),
appBuilder( // 34
comBuilder(2,37),
argBuilder(1, true),
),
// AExp17
appBuilder( // 35
comBuilder(4,13),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 36
comBuilder(4,13),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp18
appBuilder( // 37
comBuilder(1,56),
argBuilder(1, false),
intBuilder(1),
argBuilder(0, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 38
comBuilder(2,35),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp19
appBuilder( // 39
prmBuilder("/="),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 40
prmBuilder("+"),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp20
appBuilder( // 41
prmBuilder("/="),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 42
prmBuilder("-"),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp21
appBuilder( // 43
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 44
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp22
appBuilder( // 45
comBuilder(1,58),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 46
comBuilder(2,43),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(4, true),
),
appBuilder( // 47
comBuilder(3,41),
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp23
appBuilder( // 48
comBuilder(1,58),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 49
comBuilder(5,45),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
argBuilder(4, true),
),
appBuilder( // 50
comBuilder(3,39),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp24
appBuilder( // 51
comBuilder(1,58),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(5,48),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, false),
argBuilder(4, true),
),
appBuilder( // 53
prmBuilder("/="),
argBuilder(0, false),
argBuilder(3, false),
),
// AExp25
appBuilder( // 54
argBuilder(3, true),
comBuilder(2,1),
ptrBuilder(0, true, true),
),
appBuilder( // 55
comBuilder(5,51),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp26
appBuilder( // 56
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(4,54),
argBuilder(0, true),
),
// AExp27
appBuilder( // 58
argBuilder(0, true),
comBuilder(2,0),
),
// AExp28
appBuilder( // 59
comBuilder(1,63),
ptrBuilder(0, true, true),
),
appBuilder( // 60
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp29
appBuilder( // 61
comBuilder(4,13),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 62
comBuilder(1,59),
argBuilder(0, false),
),
// AExp30
appBuilder( // 63
prmBuilder("=="),
argBuilder(0, false),
intBuilder(1),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 64
comBuilder(4,13),
intBuilder(1),
comBuilder(2,0),
),
appBuilder( // 65
comBuilder(1,61),
argBuilder(0, false),
),
)
}
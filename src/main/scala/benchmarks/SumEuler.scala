package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object SumEuler extends Benchmark {
override def toString() = "SumEuler" 
val combinatorCount = 39
val heap_img = Seq(
// AExp0
appBuilder( // 0
ptrBuilder(2, false, false),
ptrBuilder(1, false, false),
),
appBuilder( // 1
comBuilder(2,12),
intBuilder(1),
intBuilder(30),
),
// AExp1
appBuilder( // 2
comBuilder(2,6),
prmBuilder("+"),
intBuilder(0),
),
// AExp2
appBuilder( // 3
yBuilder(),
comBuilder(3,31),
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
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 3
argBuilder(1, true),
argBuilder(3, true),
),
// AExp3
appBuilder( // 4
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 5
comBuilder(4,2),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp4
appBuilder( // 6
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 7
comBuilder(4,4),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp5
appBuilder( // 8
comBuilder(2,78),
ptrBuilder(0, true, true),
),
appBuilder( // 9
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp6
appBuilder( // 10
comBuilder(4,21),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 11
comBuilder(1,8),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp7
appBuilder( // 12
comBuilder(1,19),
comBuilder(1,27),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(2,10),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 14
comBuilder(4,21),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 15
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 16
argBuilder(0, true),
argBuilder(2, true),
),
// AExp9
appBuilder( // 17
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 18
comBuilder(4,14),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp10
appBuilder( // 19
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 20
comBuilder(3,17),
argBuilder(0, true),
),
// AExp11
appBuilder( // 21
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp12
appBuilder( // 22
comBuilder(2,78),
intBuilder(1),
ptrBuilder(0, true, true),
),
appBuilder( // 23
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp13
appBuilder( // 24
comBuilder(1,40),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 25
comBuilder(1,22),
argBuilder(0, false),
),
appBuilder( // 26
comBuilder(2,42),
argBuilder(0, false),
),
// AExp14
appBuilder( // 27
ptrBuilder(3, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 28
comBuilder(1,24),
argBuilder(0, true),
),
// AExp15
appBuilder( // 29
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 30
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp16
appBuilder( // 31
argBuilder(2, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(3,29),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp17
appBuilder( // 33
comBuilder(4,21),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 34
argBuilder(0, true),
argBuilder(2, true),
),
// AExp18
appBuilder( // 35
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 36
comBuilder(3,33),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 37
argBuilder(1, false),
argBuilder(3, false),
),
// AExp19
appBuilder( // 38
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 39
comBuilder(4,35),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp20
appBuilder( // 40
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 41
comBuilder(3,38),
argBuilder(0, true),
),
// AExp21
appBuilder( // 42
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 43
comBuilder(2,46),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp22
appBuilder( // 44
comBuilder(2,46),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 45
comBuilder(2,48),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp23
appBuilder( // 46
prmBuilder("=="),
intBuilder(0),
argBuilder(1, false),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 47
comBuilder(2,44),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp24
appBuilder( // 48
comBuilder(1,72),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp25
appBuilder( // 49
prmBuilder("<="),
argBuilder(5, false),
argBuilder(1, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 50
argBuilder(3, true),
argBuilder(5, false),
),
appBuilder( // 51
prmBuilder("<="),
argBuilder(4, true),
argBuilder(1, false),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp26
appBuilder( // 52
argBuilder(1, true),
intBuilder(0),
argBuilder(0, true),
),
// AExp27
appBuilder( // 53
argBuilder(2, true),
intBuilder(1),
ptrBuilder(0, true, true),
),
appBuilder( // 54
prmBuilder("-"),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp28
appBuilder( // 55
argBuilder(2, true),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp29
appBuilder( // 56
argBuilder(3, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 57
prmBuilder("-"),
argBuilder(1, true),
argBuilder(0, true),
),
appBuilder( // 58
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp30
appBuilder( // 59
prmBuilder("<="),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 60
comBuilder(4,56),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(1, false),
),
appBuilder( // 61
comBuilder(3,55),
argBuilder(2, false),
argBuilder(1, false),
),
// AExp31
appBuilder( // 62
prmBuilder("+"),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp32
appBuilder( // 63
comBuilder(3,59),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 64
comBuilder(1,62),
argBuilder(1, true),
),
// AExp33
appBuilder( // 65
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 66
comBuilder(2,63),
argBuilder(1, true),
),
// AExp34
appBuilder( // 67
comBuilder(6,49),
ptrBuilder(3, true, true),
argBuilder(0, false),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 68
prmBuilder("+"),
argBuilder(2, false),
argBuilder(2, false),
),
appBuilder( // 69
comBuilder(3,65),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 70
comBuilder(3,53),
argBuilder(0, false),
argBuilder(2, false),
),
appBuilder( // 71
comBuilder(2,52),
argBuilder(0, false),
),
// AExp35
appBuilder( // 72
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 73
comBuilder(3,67),
argBuilder(0, true),
),
// AExp36
appBuilder( // 74
comBuilder(2,78),
ptrBuilder(0, true, true),
),
appBuilder( // 75
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp37
appBuilder( // 76
comBuilder(4,21),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 77
comBuilder(1,74),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp38
appBuilder( // 78
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 79
comBuilder(2,76),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
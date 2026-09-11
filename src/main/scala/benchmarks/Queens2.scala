package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Queens2 extends Benchmark {
override def toString() = "Queens2" 
val combinatorCount = 49
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,4),
intBuilder(5),
),
// AExp1
appBuilder( // 1
comBuilder(2,37),
ptrBuilder(5, false, false),
),
appBuilder( // 2
comBuilder(4,14),
intBuilder(2),
comBuilder(2,0),
),
appBuilder( // 3
comBuilder(4,14),
intBuilder(1),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(1,40),
ptrBuilder(3, false, false),
),
appBuilder( // 5
comBuilder(2,38),
ptrBuilder(4, false, false),
),
// AExp2
appBuilder( // 6
comBuilder(1,47),
ptrBuilder(8, false, false),
),
appBuilder( // 7
prmBuilder("=="),
intBuilder(2),
),
appBuilder( // 8
comBuilder(2,72),
ptrBuilder(7, false, false),
),
// AExp3
appBuilder( // 9
comBuilder(2,73),
ptrBuilder(11, false, false),
),
appBuilder( // 10
prmBuilder("=="),
intBuilder(0),
),
appBuilder( // 11
comBuilder(2,72),
ptrBuilder(10, false, false),
),
// AExp4
appBuilder( // 12
comBuilder(2,66),
ptrBuilder(14, false, false),
),
appBuilder( // 13
prmBuilder("=="),
intBuilder(1),
),
appBuilder( // 14
comBuilder(2,72),
ptrBuilder(13, false, false),
),
// AExp5
appBuilder( // 15
yBuilder(),
comBuilder(3,8),
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
comBuilder(1,16),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(2,81),
argBuilder(0, false),
comBuilder(2,0),
),
// AExp3
appBuilder( // 4
ptrBuilder(15, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 5
comBuilder(1,2),
argBuilder(0, true),
),
// AExp4
appBuilder( // 6
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 7
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp5
appBuilder( // 8
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,6),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp6
appBuilder( // 9
comBuilder(2,51),
ptrBuilder(0, true, true),
),
appBuilder( // 10
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp7
appBuilder( // 11
comBuilder(1,22),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(1,35),
argBuilder(1, true),
),
appBuilder( // 13
comBuilder(1,9),
argBuilder(0, true),
),
// AExp8
appBuilder( // 14
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 15
comBuilder(4,14),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp10
appBuilder( // 16
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
comBuilder(2,11),
comBuilder(2,15),
argBuilder(0, false),
),
// AExp11
appBuilder( // 17
comBuilder(2,0),
),
// AExp12
appBuilder( // 18
comBuilder(2,27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 19
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 20
argBuilder(2, true),
argBuilder(0, true),
),
// AExp13
appBuilder( // 21
argBuilder(2, true),
comBuilder(2,17),
comBuilder(4,18),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp14
appBuilder( // 22
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 23
comBuilder(3,21),
argBuilder(0, true),
),
// AExp15
appBuilder( // 24
comBuilder(4,14),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 25
argBuilder(3, true),
argBuilder(1, true),
),
// AExp16
appBuilder( // 26
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,24),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp17
appBuilder( // 27
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 28
comBuilder(3,26),
argBuilder(1, true),
),
// AExp18
appBuilder( // 29
comBuilder(1,47),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 30
comBuilder(1,35),
argBuilder(1, true),
),
appBuilder( // 31
comBuilder(4,14),
argBuilder(0, true),
),
// AExp19
appBuilder( // 32
comBuilder(2,27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(2,29),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 34
ptrBuilder(1, false, false),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp20
appBuilder( // 35
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,32),
),
// AExp21
appBuilder( // 36
comBuilder(2,0),
),
// AExp22
appBuilder( // 37
argBuilder(1, true),
argBuilder(0, true),
comBuilder(3,36),
),
// AExp23
appBuilder( // 38
comBuilder(4,14),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 39
argBuilder(0, true),
argBuilder(1, true),
),
// AExp24
appBuilder( // 40
comBuilder(4,14),
ptrBuilder(0, true, true),
),
appBuilder( // 41
comBuilder(4,14),
intBuilder(0),
argBuilder(0, true),
),
// AExp25
appBuilder( // 42
comBuilder(2,0),
),
// AExp26
appBuilder( // 43
comBuilder(4,14),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 44
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 45
argBuilder(2, true),
argBuilder(0, true),
),
// AExp27
appBuilder( // 46
argBuilder(2, true),
comBuilder(2,42),
comBuilder(4,43),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp28
appBuilder( // 47
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(3,46),
argBuilder(0, true),
),
// AExp29
appBuilder( // 49
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(1,57),
argBuilder(1, true),
),
// AExp30
appBuilder( // 51
comBuilder(1,47),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(2,49),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 53
comBuilder(4,14),
argBuilder(1, false),
),
// AExp31
appBuilder( // 54
comBuilder(1,65),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 55
ptrBuilder(9, false, false),
argBuilder(0, false),
),
appBuilder( // 56
ptrBuilder(6, false, false),
argBuilder(0, false),
),
// AExp32
appBuilder( // 57
comBuilder(1,65),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 58
ptrBuilder(12, false, false),
argBuilder(0, false),
),
appBuilder( // 59
comBuilder(1,54),
argBuilder(0, false),
),
// AExp33
appBuilder( // 60
comBuilder(2,0),
),
// AExp34
appBuilder( // 61
comBuilder(4,14),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 62
comBuilder(1,65),
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 63
comBuilder(2,27),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp35
appBuilder( // 64
argBuilder(2, true),
comBuilder(4,14),
comBuilder(4,61),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp36
appBuilder( // 65
argBuilder(0, true),
comBuilder(1,60),
comBuilder(3,64),
),
// AExp37
appBuilder( // 66
comBuilder(4,14),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 67
comBuilder(1,47),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp38
appBuilder( // 68
comBuilder(2,0),
),
// AExp39
appBuilder( // 69
comBuilder(2,72),
),
// AExp40
appBuilder( // 70
comBuilder(4,14),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp41
appBuilder( // 71
argBuilder(2, false),
argBuilder(0, false),
comBuilder(1,69),
comBuilder(3,70),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(1, true),
),
// AExp42
appBuilder( // 72
argBuilder(1, true),
comBuilder(1,68),
comBuilder(3,71),
argBuilder(0, true),
),
// AExp43
appBuilder( // 73
comBuilder(1,47),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 74
comBuilder(1,75),
argBuilder(1, true),
),
// AExp44
appBuilder( // 75
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,1),
),
// AExp45
appBuilder( // 76
comBuilder(2,0),
),
// AExp46
appBuilder( // 77
comBuilder(2,81),
ptrBuilder(0, true, true),
),
appBuilder( // 78
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp47
appBuilder( // 79
comBuilder(4,14),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 80
comBuilder(1,77),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp48
appBuilder( // 81
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,0),
comBuilder(1,76),
ptrBuilder(0, true, true),
),
appBuilder( // 82
comBuilder(2,79),
argBuilder(0, false),
argBuilder(1, true),
),
)
}
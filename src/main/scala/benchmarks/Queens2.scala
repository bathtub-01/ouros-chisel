package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Queens2 extends Benchmark {
override def toString() = "Queens2" 
val combinatorCount = 42
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,4),
intBuilder(5),
),
// AExp1
appBuilder( // 1
comBuilder(3,40),
ptrBuilder(5, false, false),
),
appBuilder( // 2
comBuilder(4,15),
intBuilder(2),
comBuilder(2,0),
),
appBuilder( // 3
comBuilder(4,15),
intBuilder(1),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(1,44),
ptrBuilder(3, false, false),
),
appBuilder( // 5
comBuilder(2,42),
ptrBuilder(4, false, false),
),
// AExp2
appBuilder( // 6
comBuilder(1,51),
ptrBuilder(8, false, false),
),
appBuilder( // 7
prmBuilder("=="),
intBuilder(2),
),
appBuilder( // 8
comBuilder(1,79),
ptrBuilder(7, false, false),
),
// AExp3
appBuilder( // 9
comBuilder(2,81),
ptrBuilder(11, false, false),
),
appBuilder( // 10
prmBuilder("=="),
intBuilder(0),
),
appBuilder( // 11
comBuilder(1,79),
ptrBuilder(10, false, false),
),
// AExp4
appBuilder( // 12
comBuilder(2,72),
ptrBuilder(14, false, false),
),
appBuilder( // 13
prmBuilder("=="),
intBuilder(1),
),
appBuilder( // 14
comBuilder(1,79),
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
comBuilder(2,16),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(2,88),
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
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 7
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp5
appBuilder( // 8
argBuilder(2, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 9
comBuilder(3,6),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp6
appBuilder( // 10
comBuilder(2,55),
ptrBuilder(0, true, true),
),
appBuilder( // 11
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp7
appBuilder( // 12
comBuilder(1,24),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(1,38),
argBuilder(1, true),
),
appBuilder( // 14
comBuilder(1,10),
argBuilder(0, true),
),
// AExp8
appBuilder( // 15
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 16
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 17
comBuilder(4,15),
comBuilder(2,0),
comBuilder(2,0),
),
appBuilder( // 18
comBuilder(2,12),
argBuilder(0, false),
argBuilder(1, true),
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
comBuilder(4,15),
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
comBuilder(1,51),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(1,38),
argBuilder(1, true),
),
appBuilder( // 34
comBuilder(4,15),
argBuilder(0, true),
),
// AExp17
appBuilder( // 35
comBuilder(2,30),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 36
comBuilder(2,32),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 37
ptrBuilder(1, false, false),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp18
appBuilder( // 38
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,35),
),
// AExp19
appBuilder( // 39
comBuilder(2,0),
),
// AExp20
appBuilder( // 40
argBuilder(1, true),
ptrBuilder(0, true, true),
comBuilder(2,39),
),
appBuilder( // 41
argBuilder(0, true),
argBuilder(2, true),
),
// AExp21
appBuilder( // 42
comBuilder(4,15),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 43
argBuilder(0, true),
argBuilder(1, true),
),
// AExp22
appBuilder( // 44
comBuilder(4,15),
ptrBuilder(0, true, true),
),
appBuilder( // 45
comBuilder(4,15),
intBuilder(0),
argBuilder(0, true),
),
// AExp23
appBuilder( // 46
comBuilder(4,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 47
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 48
argBuilder(0, true),
argBuilder(2, true),
),
// AExp24
appBuilder( // 49
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(4,46),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp25
appBuilder( // 51
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(3,49),
argBuilder(0, true),
),
// AExp26
appBuilder( // 53
comBuilder(2,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 54
comBuilder(1,61),
argBuilder(1, true),
),
// AExp27
appBuilder( // 55
comBuilder(1,51),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 56
comBuilder(2,53),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 57
comBuilder(4,15),
argBuilder(1, false),
),
// AExp28
appBuilder( // 58
comBuilder(2,70),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 59
ptrBuilder(9, false, false),
argBuilder(0, false),
),
appBuilder( // 60
ptrBuilder(6, false, false),
argBuilder(0, false),
),
// AExp29
appBuilder( // 61
comBuilder(2,70),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 62
ptrBuilder(12, false, false),
argBuilder(0, false),
),
appBuilder( // 63
comBuilder(1,58),
argBuilder(0, false),
),
// AExp30
appBuilder( // 64
comBuilder(4,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 65
comBuilder(2,70),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 66
comBuilder(2,30),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp31
appBuilder( // 67
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 68
comBuilder(4,64),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 69
comBuilder(4,15),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp32
appBuilder( // 70
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 71
comBuilder(3,67),
argBuilder(1, true),
),
// AExp33
appBuilder( // 72
comBuilder(4,15),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 73
comBuilder(1,51),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp34
appBuilder( // 74
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 75
comBuilder(4,15),
argBuilder(2, false),
comBuilder(2,0),
),
appBuilder( // 76
argBuilder(1, true),
argBuilder(3, true),
),
// AExp35
appBuilder( // 77
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 78
comBuilder(4,74),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp36
appBuilder( // 79
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 80
comBuilder(3,77),
argBuilder(0, true),
),
// AExp37
appBuilder( // 81
comBuilder(1,51),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 82
comBuilder(1,83),
argBuilder(1, true),
),
// AExp38
appBuilder( // 83
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,1),
),
// AExp39
appBuilder( // 84
comBuilder(2,88),
ptrBuilder(0, true, true),
),
appBuilder( // 85
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp40
appBuilder( // 86
comBuilder(4,15),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 87
comBuilder(1,84),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp41
appBuilder( // 88
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 89
comBuilder(2,86),
argBuilder(0, false),
argBuilder(1, true),
),
)
}
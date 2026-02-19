package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object TribeLie extends Benchmark {
override def toString() = "TribeLie" 
val combinatorCount = 42
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,5),
comBuilder(1,28),
ptrBuilder(1, false, false),
),
// AExp1
appBuilder( // 1
yBuilder(),
ptrBuilder(26, false, false),
ptrBuilder(3, false, false),
),
appBuilder( // 2
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 3
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 5
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 7
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(6, false, false),
),
appBuilder( // 8
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 9
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(8, false, false),
),
appBuilder( // 10
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 11
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(10, false, false),
),
appBuilder( // 12
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 13
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(12, false, false),
),
appBuilder( // 14
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 15
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(14, false, false),
),
appBuilder( // 16
comBuilder(4,20),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 17
comBuilder(4,20),
comBuilder(2,0),
ptrBuilder(16, false, false),
),
appBuilder( // 18
comBuilder(2,76),
ptrBuilder(17, false, false),
),
appBuilder( // 19
comBuilder(6,65),
ptrBuilder(18, false, false),
ptrBuilder(15, false, false),
),
appBuilder( // 20
comBuilder(5,61),
ptrBuilder(19, false, false),
ptrBuilder(13, false, false),
),
appBuilder( // 21
comBuilder(4,57),
ptrBuilder(20, false, false),
ptrBuilder(11, false, false),
),
appBuilder( // 22
comBuilder(3,53),
ptrBuilder(21, false, false),
ptrBuilder(9, false, false),
),
appBuilder( // 23
comBuilder(6,49),
ptrBuilder(22, false, false),
ptrBuilder(7, false, false),
),
appBuilder( // 24
comBuilder(6,43),
ptrBuilder(23, false, false),
),
appBuilder( // 25
comBuilder(5,41),
ptrBuilder(24, false, false),
ptrBuilder(5, false, false),
),
appBuilder( // 26
comBuilder(3,39),
ptrBuilder(25, false, false),
),
// AExp2
appBuilder( // 27
comBuilder(2,11),
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
comBuilder(1,0),
ptrBuilder(27, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,18),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp3
appBuilder( // 4
argBuilder(0, true),
argBuilder(1, true),
intBuilder(0),
intBuilder(1),
),
// AExp4
appBuilder( // 5
comBuilder(2,2),
ptrBuilder(0, true, true),
),
appBuilder( // 6
comBuilder(2,4),
argBuilder(0, true),
),
// AExp5
appBuilder( // 7
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 8
argBuilder(1, true),
argBuilder(3, true),
),
// AExp6
appBuilder( // 9
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(4,7),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp7
appBuilder( // 11
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(4,9),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 13
comBuilder(4,20),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 14
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 15
argBuilder(0, true),
argBuilder(2, true),
),
// AExp9
appBuilder( // 16
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 17
comBuilder(4,13),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp10
appBuilder( // 18
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 19
comBuilder(3,16),
argBuilder(0, true),
),
// AExp11
appBuilder( // 20
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp12
appBuilder( // 21
comBuilder(1,29),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 22
comBuilder(2,30),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp13
appBuilder( // 23
comBuilder(1,29),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
comBuilder(3,36),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 25
comBuilder(2,32),
argBuilder(0, true),
argBuilder(3, false),
),
// AExp14
appBuilder( // 26
comBuilder(7,21),
argBuilder(2, false),
ptrBuilder(0, true, true),
argBuilder(3, false),
),
appBuilder( // 27
comBuilder(4,23),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp15
appBuilder( // 28
argBuilder(0, true),
comBuilder(4,26),
),
// AExp16
appBuilder( // 29
argBuilder(0, true),
comBuilder(2,0),
),
// AExp17
appBuilder( // 30
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 31
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp18
appBuilder( // 32
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 33
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp19
appBuilder( // 34
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 35
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp20
appBuilder( // 36
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 37
argBuilder(2, false),
comBuilder(2,0),
comBuilder(2,1),
),
appBuilder( // 38
comBuilder(2,34),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp21
appBuilder( // 39
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 40
argBuilder(0, true),
argBuilder(1, true),
),
// AExp22
appBuilder( // 41
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 42
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp23
appBuilder( // 43
argBuilder(5, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 44
argBuilder(0, true),
argBuilder(2, true),
argBuilder(4, true),
),
appBuilder( // 45
argBuilder(1, true),
argBuilder(3, true),
),
// AExp24
appBuilder( // 46
argBuilder(6, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 47
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(5, true),
),
appBuilder( // 48
argBuilder(2, true),
argBuilder(4, true),
),
// AExp25
appBuilder( // 49
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 50
comBuilder(7,46),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp26
appBuilder( // 51
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 52
comBuilder(7,46),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp27
appBuilder( // 53
comBuilder(6,51),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 54
argBuilder(0, true),
argBuilder(2, true),
),
// AExp28
appBuilder( // 55
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 56
comBuilder(7,46),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp29
appBuilder( // 57
comBuilder(6,55),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 58
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp30
appBuilder( // 59
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 60
comBuilder(7,46),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp31
appBuilder( // 61
comBuilder(6,59),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 62
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp32
appBuilder( // 63
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 64
comBuilder(7,46),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp33
appBuilder( // 65
comBuilder(6,63),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 66
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp34
appBuilder( // 67
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 68
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp35
appBuilder( // 69
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 70
comBuilder(7,46),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp36
appBuilder( // 71
comBuilder(4,20),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 72
argBuilder(4, true),
argBuilder(6, true),
),
appBuilder( // 73
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(5, true),
),
// AExp37
appBuilder( // 74
comBuilder(7,71),
ptrBuilder(0, true, true),
),
appBuilder( // 75
comBuilder(3,80),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp38
appBuilder( // 76
comBuilder(7,67),
comBuilder(6,69),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 77
comBuilder(4,74),
argBuilder(1, true),
),
// AExp39
appBuilder( // 78
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp40
appBuilder( // 79
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp41
appBuilder( // 80
comBuilder(7,78),
ptrBuilder(0, true, true),
),
appBuilder( // 81
comBuilder(7,79),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
)
}
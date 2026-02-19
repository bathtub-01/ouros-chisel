package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Taut extends Benchmark {
override def toString() = "Taut" 
val combinatorCount = 64
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,5),
ptrBuilder(1, false, false),
intBuilder(0),
intBuilder(1),
),
// AExp1
appBuilder( // 1
comBuilder(7,113),
ptrBuilder(7, false, false),
ptrBuilder(5, false, false),
),
appBuilder( // 2
comBuilder(1,15),
comBuilder(6,125),
ptrBuilder(8, false, false),
),
appBuilder( // 3
comBuilder(1,120),
comBuilder(7,55),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(6,125),
intBuilder(42),
),
appBuilder( // 5
comBuilder(7,113),
ptrBuilder(4, false, false),
ptrBuilder(3, false, false),
),
appBuilder( // 6
comBuilder(1,15),
comBuilder(1,122),
ptrBuilder(8, false, false),
),
appBuilder( // 7
comBuilder(1,120),
comBuilder(7,55),
ptrBuilder(6, false, false),
),
// AExp2
appBuilder( // 8
comBuilder(4,17),
intBuilder(0),
ptrBuilder(13, false, false),
),
appBuilder( // 9
comBuilder(4,17),
intBuilder(5),
comBuilder(2,0),
),
appBuilder( // 10
comBuilder(4,17),
intBuilder(4),
ptrBuilder(9, false, false),
),
appBuilder( // 11
comBuilder(4,17),
intBuilder(3),
ptrBuilder(10, false, false),
),
appBuilder( // 12
comBuilder(4,17),
intBuilder(2),
ptrBuilder(11, false, false),
),
appBuilder( // 13
comBuilder(4,17),
intBuilder(1),
ptrBuilder(12, false, false),
),
// AExp3
appBuilder( // 14
yBuilder(),
comBuilder(3,86),
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
comBuilder(1,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,53),
argBuilder(0, false),
),
appBuilder( // 4
comBuilder(3,18),
comBuilder(1,31),
argBuilder(0, false),
),
// AExp3
appBuilder( // 5
comBuilder(1,9),
ptrBuilder(0, true, true),
),
appBuilder( // 6
comBuilder(1,2),
argBuilder(0, true),
),
// AExp4
appBuilder( // 7
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 8
comBuilder(1,9),
argBuilder(1, true),
),
// AExp5
appBuilder( // 9
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,7),
),
// AExp6
appBuilder( // 10
comBuilder(4,17),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 11
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 12
argBuilder(0, true),
argBuilder(2, true),
),
// AExp7
appBuilder( // 13
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(4,10),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 15
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 16
comBuilder(3,13),
argBuilder(0, true),
),
// AExp9
appBuilder( // 17
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp10
appBuilder( // 18
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 19
argBuilder(6, true),
ptrBuilder(2, true, true),
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
),
appBuilder( // 20
argBuilder(3, true),
argBuilder(5, false),
),
appBuilder( // 21
argBuilder(2, true),
argBuilder(5, false),
),
appBuilder( // 22
argBuilder(0, true),
argBuilder(5, false),
),
// AExp12
appBuilder( // 23
argBuilder(0, false),
argBuilder(1, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 24
argBuilder(0, false),
argBuilder(2, true),
),
// AExp13
appBuilder( // 25
argBuilder(0, false),
argBuilder(1, true),
comBuilder(2,1),
ptrBuilder(0, true, true),
),
appBuilder( // 26
argBuilder(0, false),
argBuilder(2, true),
),
// AExp14
appBuilder( // 27
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp15
appBuilder( // 28
comBuilder(2,33),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp16
appBuilder( // 29
comBuilder(7,19),
comBuilder(3,23),
comBuilder(1,0),
comBuilder(3,25),
comBuilder(2,27),
ptrBuilder(0, true, true),
),
appBuilder( // 30
comBuilder(2,28),
argBuilder(0, true),
),
// AExp17
appBuilder( // 31
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(1,29),
argBuilder(0, true),
),
// AExp18
appBuilder( // 33
comBuilder(1,0),
comBuilder(1,35),
ptrBuilder(0, true, true),
),
appBuilder( // 34
comBuilder(1,43),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp19
appBuilder( // 35
argBuilder(0, true),
errorBuilder(4),
comBuilder(1,0),
),
// AExp20
appBuilder( // 36
prmBuilder("=="),
argBuilder(0, true),
argBuilder(3, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(3,45),
argBuilder(4, true),
),
appBuilder( // 38
argBuilder(1, true),
argBuilder(2, true),
),
// AExp21
appBuilder( // 39
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 40
comBuilder(5,36),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp22
appBuilder( // 41
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 42
comBuilder(4,39),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp23
appBuilder( // 43
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 44
comBuilder(3,41),
argBuilder(0, true),
),
// AExp24
appBuilder( // 45
argBuilder(2, true),
argBuilder(0, true),
),
// AExp25
appBuilder( // 46
comBuilder(1,75),
ptrBuilder(0, true, true),
),
appBuilder( // 47
ptrBuilder(14, false, false),
argBuilder(0, true),
),
// AExp26
appBuilder( // 48
comBuilder(1,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 49
comBuilder(1,46),
argBuilder(0, false),
),
appBuilder( // 50
comBuilder(2,61),
argBuilder(0, false),
),
// AExp27
appBuilder( // 51
comBuilder(1,94),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(1,112),
argBuilder(0, true),
),
// AExp28
appBuilder( // 53
comBuilder(1,48),
ptrBuilder(0, true, true),
),
appBuilder( // 54
comBuilder(1,51),
argBuilder(0, true),
),
// AExp29
appBuilder( // 55
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp30
appBuilder( // 56
comBuilder(4,17),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(2,61),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 58
comBuilder(3,55),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp31
appBuilder( // 59
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 60
comBuilder(4,56),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp32
appBuilder( // 61
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 62
comBuilder(3,59),
argBuilder(1, true),
),
// AExp33
appBuilder( // 63
comBuilder(1,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 64
comBuilder(1,75),
argBuilder(0, true),
),
appBuilder( // 65
comBuilder(4,17),
comBuilder(2,0),
),
// AExp34
appBuilder( // 66
comBuilder(1,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 67
comBuilder(1,75),
argBuilder(0, true),
),
appBuilder( // 68
comBuilder(4,17),
comBuilder(2,1),
),
// AExp35
appBuilder( // 69
comBuilder(2,82),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 70
comBuilder(1,66),
argBuilder(0, false),
),
appBuilder( // 71
comBuilder(1,63),
argBuilder(0, false),
),
// AExp36
appBuilder( // 72
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp37
appBuilder( // 73
comBuilder(1,69),
ptrBuilder(0, true, true),
),
appBuilder( // 74
comBuilder(1,72),
argBuilder(0, true),
),
// AExp38
appBuilder( // 75
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 76
comBuilder(4,17),
comBuilder(2,0),
comBuilder(2,0),
),
appBuilder( // 77
comBuilder(1,73),
argBuilder(0, false),
),
// AExp39
appBuilder( // 78
comBuilder(4,17),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 79
argBuilder(0, true),
argBuilder(2, true),
),
// AExp40
appBuilder( // 80
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 81
comBuilder(3,78),
argBuilder(1, true),
),
// AExp41
appBuilder( // 82
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 83
comBuilder(3,80),
argBuilder(1, true),
),
// AExp42
appBuilder( // 84
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 85
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp43
appBuilder( // 86
argBuilder(2, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 87
comBuilder(3,84),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp44
appBuilder( // 88
comBuilder(1,102),
ptrBuilder(0, true, true),
),
appBuilder( // 89
prmBuilder("/="),
argBuilder(0, true),
),
// AExp45
appBuilder( // 90
comBuilder(1,94),
ptrBuilder(0, true, true),
),
appBuilder( // 91
comBuilder(1,88),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp46
appBuilder( // 92
comBuilder(4,17),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 93
comBuilder(2,90),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp47
appBuilder( // 94
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,92),
),
// AExp48
appBuilder( // 95
comBuilder(4,17),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 96
argBuilder(0, true),
argBuilder(2, true),
),
// AExp49
appBuilder( // 97
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 98
comBuilder(3,95),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 99
argBuilder(1, false),
argBuilder(3, false),
),
// AExp50
appBuilder( // 100
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 101
comBuilder(4,97),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp51
appBuilder( // 102
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 103
comBuilder(3,100),
argBuilder(0, true),
),
// AExp52
appBuilder( // 104
comBuilder(2,82),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 105
comBuilder(1,112),
argBuilder(1, true),
),
appBuilder( // 106
comBuilder(1,112),
argBuilder(0, true),
),
// AExp53
appBuilder( // 107
comBuilder(2,0),
),
// AExp54
appBuilder( // 108
comBuilder(2,82),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 109
comBuilder(1,112),
argBuilder(1, true),
),
appBuilder( // 110
comBuilder(1,112),
argBuilder(0, true),
),
// AExp55
appBuilder( // 111
comBuilder(4,17),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp56
appBuilder( // 112
argBuilder(0, true),
comBuilder(2,104),
comBuilder(1,107),
comBuilder(2,108),
comBuilder(1,112),
comBuilder(1,111),
),
// AExp57
appBuilder( // 113
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp58
appBuilder( // 114
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 115
argBuilder(1, true),
argBuilder(3, true),
),
// AExp59
appBuilder( // 116
argBuilder(3, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 117
comBuilder(6,114),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp60
appBuilder( // 118
argBuilder(2, true),
errorBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 119
comBuilder(4,116),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp61
appBuilder( // 120
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 121
comBuilder(3,118),
argBuilder(0, true),
),
// AExp62
appBuilder( // 122
comBuilder(7,113),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 123
comBuilder(6,125),
argBuilder(0, true),
),
appBuilder( // 124
comBuilder(6,125),
intBuilder(42),
),
// AExp63
appBuilder( // 125
argBuilder(5, true),
argBuilder(0, true),
),
)
}
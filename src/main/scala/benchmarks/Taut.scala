package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Taut extends Benchmark {
override def toString() = "Taut" 
val combinatorCount = 75
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
comBuilder(7,106),
ptrBuilder(7, false, false),
ptrBuilder(5, false, false),
),
appBuilder( // 2
comBuilder(1,15),
comBuilder(6,120),
ptrBuilder(8, false, false),
),
appBuilder( // 3
comBuilder(1,114),
comBuilder(7,116),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(6,120),
intBuilder(42),
),
appBuilder( // 5
comBuilder(7,106),
ptrBuilder(4, false, false),
ptrBuilder(3, false, false),
),
appBuilder( // 6
comBuilder(1,15),
comBuilder(1,117),
ptrBuilder(8, false, false),
),
appBuilder( // 7
comBuilder(1,114),
comBuilder(7,116),
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
comBuilder(3,79),
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
comBuilder(1,48),
argBuilder(0, false),
),
appBuilder( // 4
comBuilder(3,18),
comBuilder(1,28),
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
comBuilder(2,0),
),
// AExp5
appBuilder( // 8
argBuilder(0, true),
comBuilder(1,7),
comBuilder(1,9),
),
// AExp6
appBuilder( // 9
argBuilder(0, true),
comBuilder(2,1),
comBuilder(1,8),
),
// AExp7
appBuilder( // 10
comBuilder(2,0),
),
// AExp8
appBuilder( // 11
comBuilder(4,17),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 12
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 13
argBuilder(2, true),
argBuilder(0, true),
),
// AExp9
appBuilder( // 14
argBuilder(2, true),
comBuilder(2,10),
comBuilder(4,11),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp10
appBuilder( // 15
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 16
comBuilder(3,14),
argBuilder(0, true),
),
// AExp11
appBuilder( // 17
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp12
appBuilder( // 18
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp13
appBuilder( // 19
argBuilder(6, true),
ptrBuilder(2, true, true),
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(2,30),
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
// AExp14
appBuilder( // 23
comBuilder(2,0),
),
// AExp15
appBuilder( // 24
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,23),
comBuilder(1,28),
argBuilder(3, true),
argBuilder(2, true),
),
// AExp16
appBuilder( // 25
comBuilder(2,1),
),
// AExp17
appBuilder( // 26
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,25),
comBuilder(1,28),
argBuilder(3, true),
argBuilder(2, true),
),
// AExp18
appBuilder( // 27
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp19
appBuilder( // 28
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(7,19),
comBuilder(4,24),
comBuilder(2,0),
comBuilder(4,26),
comBuilder(3,27),
argBuilder(0, true),
),
// AExp20
appBuilder( // 30
comBuilder(1,0),
comBuilder(1,32),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(2,39),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp21
appBuilder( // 32
argBuilder(0, true),
errorBuilder(4),
comBuilder(1,0),
),
// AExp22
appBuilder( // 33
comBuilder(2,0),
),
// AExp23
appBuilder( // 34
comBuilder(2,39),
),
// AExp24
appBuilder( // 35
comBuilder(3,40),
argBuilder(0, true),
),
// AExp25
appBuilder( // 36
prmBuilder("=="),
argBuilder(1, false),
argBuilder(2, true),
comBuilder(1,34),
comBuilder(3,35),
argBuilder(3, true),
argBuilder(1, false),
argBuilder(0, true),
),
// AExp26
appBuilder( // 37
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 38
comBuilder(4,36),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp27
appBuilder( // 39
argBuilder(1, true),
comBuilder(1,33),
comBuilder(3,37),
argBuilder(0, true),
),
// AExp28
appBuilder( // 40
argBuilder(2, true),
argBuilder(0, true),
),
// AExp29
appBuilder( // 41
comBuilder(1,71),
ptrBuilder(0, true, true),
),
appBuilder( // 42
ptrBuilder(14, false, false),
argBuilder(0, true),
),
// AExp30
appBuilder( // 43
comBuilder(1,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 44
comBuilder(1,41),
argBuilder(0, false),
),
appBuilder( // 45
comBuilder(1,57),
argBuilder(0, false),
),
// AExp31
appBuilder( // 46
comBuilder(1,86),
ptrBuilder(0, true, true),
),
appBuilder( // 47
comBuilder(1,105),
argBuilder(0, true),
),
// AExp32
appBuilder( // 48
comBuilder(1,43),
ptrBuilder(0, true, true),
),
appBuilder( // 49
comBuilder(1,46),
argBuilder(0, true),
),
// AExp33
appBuilder( // 50
comBuilder(2,0),
),
// AExp34
appBuilder( // 51
comBuilder(2,0),
),
// AExp35
appBuilder( // 52
argBuilder(2, true),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp36
appBuilder( // 53
comBuilder(4,17),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 54
comBuilder(1,57),
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 55
comBuilder(3,52),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp37
appBuilder( // 56
argBuilder(2, true),
comBuilder(2,51),
comBuilder(4,53),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp38
appBuilder( // 57
argBuilder(0, true),
comBuilder(1,50),
comBuilder(3,56),
),
// AExp39
appBuilder( // 58
comBuilder(1,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 59
comBuilder(1,71),
argBuilder(0, true),
),
appBuilder( // 60
comBuilder(4,17),
comBuilder(2,0),
),
// AExp40
appBuilder( // 61
comBuilder(1,15),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 62
comBuilder(1,71),
argBuilder(0, true),
),
appBuilder( // 63
comBuilder(4,17),
comBuilder(2,1),
),
// AExp41
appBuilder( // 64
comBuilder(2,75),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 65
comBuilder(1,61),
argBuilder(0, false),
),
appBuilder( // 66
comBuilder(1,58),
argBuilder(0, false),
),
// AExp42
appBuilder( // 67
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp43
appBuilder( // 68
comBuilder(1,64),
ptrBuilder(0, true, true),
),
appBuilder( // 69
comBuilder(1,67),
argBuilder(0, true),
),
// AExp44
appBuilder( // 70
comBuilder(4,17),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp45
appBuilder( // 71
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,68),
comBuilder(1,70),
argBuilder(0, false),
),
// AExp46
appBuilder( // 72
comBuilder(4,17),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 73
argBuilder(3, true),
argBuilder(1, true),
),
// AExp47
appBuilder( // 74
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,72),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp48
appBuilder( // 75
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 76
comBuilder(3,74),
argBuilder(1, true),
),
// AExp49
appBuilder( // 77
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 78
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp50
appBuilder( // 79
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,77),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp51
appBuilder( // 80
comBuilder(1,95),
ptrBuilder(0, true, true),
),
appBuilder( // 81
prmBuilder("/="),
argBuilder(0, true),
),
// AExp52
appBuilder( // 82
comBuilder(1,86),
ptrBuilder(0, true, true),
),
appBuilder( // 83
comBuilder(1,80),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp53
appBuilder( // 84
comBuilder(4,17),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 85
comBuilder(2,82),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp54
appBuilder( // 86
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,84),
),
// AExp55
appBuilder( // 87
comBuilder(2,0),
),
// AExp56
appBuilder( // 88
argBuilder(3, true),
),
// AExp57
appBuilder( // 89
comBuilder(4,17),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 90
comBuilder(1,95),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp58
appBuilder( // 91
argBuilder(3, false),
argBuilder(1, false),
comBuilder(4,88),
comBuilder(4,89),
argBuilder(1, false),
argBuilder(3, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 92
argBuilder(0, true),
argBuilder(2, false),
),
// AExp59
appBuilder( // 93
argBuilder(2, true),
comBuilder(1,87),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 94
comBuilder(4,91),
argBuilder(1, true),
),
// AExp60
appBuilder( // 95
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 96
comBuilder(3,93),
argBuilder(0, true),
),
// AExp61
appBuilder( // 97
comBuilder(2,75),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 98
comBuilder(1,105),
argBuilder(1, true),
),
appBuilder( // 99
comBuilder(1,105),
argBuilder(0, true),
),
// AExp62
appBuilder( // 100
comBuilder(2,0),
),
// AExp63
appBuilder( // 101
comBuilder(2,75),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 102
comBuilder(1,105),
argBuilder(1, true),
),
appBuilder( // 103
comBuilder(1,105),
argBuilder(0, true),
),
// AExp64
appBuilder( // 104
comBuilder(4,17),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp65
appBuilder( // 105
argBuilder(0, true),
comBuilder(2,97),
comBuilder(1,100),
comBuilder(2,101),
comBuilder(1,105),
comBuilder(1,104),
),
// AExp66
appBuilder( // 106
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp67
appBuilder( // 107
errorBuilder(0),
),
// AExp68
appBuilder( // 108
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 109
argBuilder(0, true),
argBuilder(2, true),
),
// AExp69
appBuilder( // 110
argBuilder(2, false),
comBuilder(2,0),
comBuilder(4,88),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 111
comBuilder(4,108),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp70
appBuilder( // 112
argBuilder(2, true),
comBuilder(1,107),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 113
comBuilder(4,110),
argBuilder(1, true),
),
// AExp71
appBuilder( // 114
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 115
comBuilder(3,112),
argBuilder(0, true),
),
// AExp72
appBuilder( // 116
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp73
appBuilder( // 117
comBuilder(7,106),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 118
comBuilder(6,120),
argBuilder(0, true),
),
appBuilder( // 119
comBuilder(6,120),
intBuilder(42),
),
// AExp74
appBuilder( // 120
argBuilder(5, true),
argBuilder(0, true),
),
)
}
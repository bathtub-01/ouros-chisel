package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Adjoxo extends Benchmark {
override def toString() = "Adjoxo" 
val combinatorCount = 86
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(2,13),
ptrBuilder(4, false, false),
ptrBuilder(2, false, false),
),
appBuilder( // 1
comBuilder(4,2),
intBuilder(5),
comBuilder(2,0),
),
appBuilder( // 2
comBuilder(4,2),
intBuilder(2),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(4,2),
intBuilder(4),
comBuilder(2,0),
),
appBuilder( // 4
comBuilder(4,2),
intBuilder(1),
ptrBuilder(3, false, false),
),
// AExp1
appBuilder( // 5
yBuilder(),
comBuilder(3,22),
intBuilder(0),
),
// AExp2
appBuilder( // 6
comBuilder(3,23),
ptrBuilder(36, false, false),
ptrBuilder(33, false, false),
),
appBuilder( // 7
comBuilder(4,2),
intBuilder(7),
comBuilder(2,0),
),
appBuilder( // 8
comBuilder(4,2),
intBuilder(5),
ptrBuilder(7, false, false),
),
appBuilder( // 9
comBuilder(1,58),
ptrBuilder(8, false, false),
),
appBuilder( // 10
comBuilder(4,2),
intBuilder(9),
comBuilder(2,0),
),
appBuilder( // 11
comBuilder(4,2),
intBuilder(5),
ptrBuilder(10, false, false),
),
appBuilder( // 12
comBuilder(1,56),
ptrBuilder(11, false, false),
),
appBuilder( // 13
comBuilder(3,53),
ptrBuilder(12, false, false),
ptrBuilder(9, false, false),
),
appBuilder( // 14
comBuilder(4,2),
intBuilder(9),
comBuilder(2,0),
),
appBuilder( // 15
comBuilder(4,2),
intBuilder(6),
ptrBuilder(14, false, false),
),
appBuilder( // 16
comBuilder(1,51),
ptrBuilder(15, false, false),
),
appBuilder( // 17
comBuilder(3,48),
ptrBuilder(16, false, false),
ptrBuilder(13, false, false),
),
appBuilder( // 18
comBuilder(4,2),
intBuilder(8),
comBuilder(2,0),
),
appBuilder( // 19
comBuilder(4,2),
intBuilder(5),
ptrBuilder(18, false, false),
),
appBuilder( // 20
comBuilder(1,46),
ptrBuilder(19, false, false),
),
appBuilder( // 21
comBuilder(3,43),
ptrBuilder(20, false, false),
ptrBuilder(17, false, false),
),
appBuilder( // 22
comBuilder(4,2),
intBuilder(7),
comBuilder(2,0),
),
appBuilder( // 23
comBuilder(4,2),
intBuilder(4),
ptrBuilder(22, false, false),
),
appBuilder( // 24
comBuilder(1,41),
ptrBuilder(23, false, false),
),
appBuilder( // 25
comBuilder(3,38),
ptrBuilder(24, false, false),
ptrBuilder(21, false, false),
),
appBuilder( // 26
comBuilder(4,2),
intBuilder(9),
comBuilder(2,0),
),
appBuilder( // 27
comBuilder(4,2),
intBuilder(8),
ptrBuilder(26, false, false),
),
appBuilder( // 28
comBuilder(1,36),
ptrBuilder(27, false, false),
),
appBuilder( // 29
comBuilder(3,33),
ptrBuilder(28, false, false),
ptrBuilder(25, false, false),
),
appBuilder( // 30
comBuilder(4,2),
intBuilder(6),
comBuilder(2,0),
),
appBuilder( // 31
comBuilder(4,2),
intBuilder(5),
ptrBuilder(30, false, false),
),
appBuilder( // 32
comBuilder(1,31),
ptrBuilder(31, false, false),
),
appBuilder( // 33
comBuilder(3,28),
ptrBuilder(32, false, false),
ptrBuilder(29, false, false),
),
appBuilder( // 34
comBuilder(4,2),
intBuilder(3),
comBuilder(2,0),
),
appBuilder( // 35
comBuilder(4,2),
intBuilder(2),
ptrBuilder(34, false, false),
),
appBuilder( // 36
comBuilder(1,26),
ptrBuilder(35, false, false),
),
// AExp3
appBuilder( // 37
comBuilder(3,87),
ptrBuilder(42, false, false),
),
appBuilder( // 38
comBuilder(2,139),
intBuilder(1),
intBuilder(9),
),
appBuilder( // 39
comBuilder(1,79),
ptrBuilder(38, false, false),
),
appBuilder( // 40
comBuilder(2,95),
ptrBuilder(39, false, false),
),
appBuilder( // 41
comBuilder(3,90),
ptrBuilder(40, false, false),
),
appBuilder( // 42
comBuilder(3,89),
ptrBuilder(41, false, false),
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
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp3
appBuilder( // 3
comBuilder(1,83),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 4
ptrBuilder(37, false, false),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp4
appBuilder( // 5
comBuilder(1,83),
comBuilder(3,19),
comBuilder(2,0),
),
// AExp5
appBuilder( // 6
ptrBuilder(6, false, false),
argBuilder(0, false),
comBuilder(2,3),
comBuilder(2,5),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp6
appBuilder( // 7
comBuilder(1,83),
comBuilder(3,19),
comBuilder(2,1),
),
// AExp7
appBuilder( // 8
ptrBuilder(6, false, false),
argBuilder(0, false),
comBuilder(2,6),
comBuilder(2,7),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp8
appBuilder( // 9
comBuilder(1,83),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 10
ptrBuilder(37, false, false),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp9
appBuilder( // 11
comBuilder(1,83),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 12
ptrBuilder(37, false, false),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp10
appBuilder( // 13
comBuilder(2,18),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(2,8),
comBuilder(2,9),
comBuilder(2,11),
argBuilder(1, false),
argBuilder(0, false),
),
appBuilder( // 14
ptrBuilder(5, false, false),
argBuilder(1, false),
),
appBuilder( // 15
ptrBuilder(5, false, false),
argBuilder(0, false),
),
// AExp11
appBuilder( // 16
prmBuilder("<="),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(3,19),
comBuilder(3,1),
),
// AExp12
appBuilder( // 17
comBuilder(3,0),
),
// AExp13
appBuilder( // 18
prmBuilder("=="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,16),
comBuilder(2,17),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp14
appBuilder( // 19
argBuilder(2, true),
),
// AExp15
appBuilder( // 20
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 21
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp16
appBuilder( // 22
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,20),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp17
appBuilder( // 23
comBuilder(1,61),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 25
argBuilder(0, true),
argBuilder(2, false),
),
// AExp18
appBuilder( // 26
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 27
comBuilder(4,2),
intBuilder(1),
argBuilder(0, true),
),
// AExp19
appBuilder( // 28
comBuilder(1,61),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 29
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 30
argBuilder(0, true),
argBuilder(2, false),
),
// AExp20
appBuilder( // 31
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(4,2),
intBuilder(4),
argBuilder(0, true),
),
// AExp21
appBuilder( // 33
comBuilder(1,61),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 34
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 35
argBuilder(0, true),
argBuilder(2, false),
),
// AExp22
appBuilder( // 36
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(4,2),
intBuilder(7),
argBuilder(0, true),
),
// AExp23
appBuilder( // 38
comBuilder(1,61),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 39
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 40
argBuilder(0, true),
argBuilder(2, false),
),
// AExp24
appBuilder( // 41
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 42
comBuilder(4,2),
intBuilder(1),
argBuilder(0, true),
),
// AExp25
appBuilder( // 43
comBuilder(1,61),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 44
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 45
argBuilder(0, true),
argBuilder(2, false),
),
// AExp26
appBuilder( // 46
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 47
comBuilder(4,2),
intBuilder(2),
argBuilder(0, true),
),
// AExp27
appBuilder( // 48
comBuilder(1,61),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 49
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 50
argBuilder(0, true),
argBuilder(2, false),
),
// AExp28
appBuilder( // 51
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(4,2),
intBuilder(3),
argBuilder(0, true),
),
// AExp29
appBuilder( // 53
comBuilder(1,61),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 54
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 55
argBuilder(0, true),
argBuilder(2, false),
),
// AExp30
appBuilder( // 56
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(4,2),
intBuilder(1),
argBuilder(0, true),
),
// AExp31
appBuilder( // 58
comBuilder(2,62),
ptrBuilder(0, true, true),
),
appBuilder( // 59
comBuilder(4,2),
intBuilder(3),
argBuilder(0, true),
),
// AExp32
appBuilder( // 60
comBuilder(2,1),
),
// AExp33
appBuilder( // 61
argBuilder(0, true),
comBuilder(1,0),
comBuilder(1,60),
),
// AExp34
appBuilder( // 62
comBuilder(1,65),
ptrBuilder(0, true, true),
),
appBuilder( // 63
comBuilder(1,79),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp35
appBuilder( // 64
comBuilder(2,0),
),
// AExp36
appBuilder( // 65
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,64),
),
// AExp37
appBuilder( // 66
comBuilder(2,0),
),
// AExp38
appBuilder( // 67
argBuilder(0, true),
argBuilder(3, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp39
appBuilder( // 68
comBuilder(1,79),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp40
appBuilder( // 69
comBuilder(1,79),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 70
comBuilder(4,2),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp41
appBuilder( // 71
comBuilder(4,2),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 72
comBuilder(3,69),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp42
appBuilder( // 73
comBuilder(1,79),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 74
comBuilder(4,2),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp43
appBuilder( // 75
comBuilder(2,18),
argBuilder(2, true),
argBuilder(0, true),
comBuilder(4,68),
comBuilder(4,71),
comBuilder(4,73),
argBuilder(3, true),
argBuilder(1, true),
),
// AExp44
appBuilder( // 76
comBuilder(4,67),
ptrBuilder(0, true, true),
argBuilder(0, false),
argBuilder(2, false),
),
appBuilder( // 77
comBuilder(4,75),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp45
appBuilder( // 78
argBuilder(2, true),
comBuilder(4,2),
comBuilder(3,76),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp46
appBuilder( // 79
argBuilder(0, true),
comBuilder(1,66),
comBuilder(3,78),
),
// AExp47
appBuilder( // 80
intBuilder(3),
),
// AExp48
appBuilder( // 81
comBuilder(1,84),
ptrBuilder(0, true, true),
),
appBuilder( // 82
comBuilder(1,85),
argBuilder(0, true),
),
// AExp49
appBuilder( // 83
argBuilder(0, true),
comBuilder(1,80),
comBuilder(1,81),
comBuilder(1,84),
),
// AExp50
appBuilder( // 84
argBuilder(0, true),
intBuilder(0),
intBuilder(88),
),
// AExp51
appBuilder( // 85
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp52
appBuilder( // 86
comBuilder(3,1),
),
// AExp53
appBuilder( // 87
ptrBuilder(6, false, false),
argBuilder(2, false),
argBuilder(0, true),
comBuilder(2,86),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp54
appBuilder( // 88
comBuilder(3,0),
),
// AExp55
appBuilder( // 89
comBuilder(2,100),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(0, true),
comBuilder(2,88),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp56
appBuilder( // 90
comBuilder(1,110),
comBuilder(1,114),
ptrBuilder(0, true, true),
),
appBuilder( // 91
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp57
appBuilder( // 92
comBuilder(1,120),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 93
comBuilder(1,79),
argBuilder(0, true),
argBuilder(2, false),
),
appBuilder( // 94
comBuilder(3,124),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp58
appBuilder( // 95
comBuilder(3,92),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 96
argBuilder(0, true),
argBuilder(1, false),
),
// AExp59
appBuilder( // 97
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 98
ptrBuilder(5, false, false),
argBuilder(1, true),
),
appBuilder( // 99
ptrBuilder(5, false, false),
argBuilder(0, true),
),
// AExp60
appBuilder( // 100
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(9),
),
appBuilder( // 101
comBuilder(2,97),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp61
appBuilder( // 102
errorBuilder(0),
),
// AExp62
appBuilder( // 103
argBuilder(3, true),
),
// AExp63
appBuilder( // 104
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 105
argBuilder(0, true),
argBuilder(2, true),
),
// AExp64
appBuilder( // 106
argBuilder(2, false),
comBuilder(2,0),
comBuilder(4,103),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 107
comBuilder(4,104),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp65
appBuilder( // 108
argBuilder(2, true),
comBuilder(1,102),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 109
comBuilder(4,106),
argBuilder(1, true),
),
// AExp66
appBuilder( // 110
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 111
comBuilder(3,108),
argBuilder(0, true),
),
// AExp67
appBuilder( // 112
argBuilder(0, true),
comBuilder(3,0),
comBuilder(3,0),
comBuilder(3,19),
),
// AExp68
appBuilder( // 113
comBuilder(3,19),
),
// AExp69
appBuilder( // 114
argBuilder(0, true),
comBuilder(1,112),
comBuilder(1,0),
comBuilder(1,113),
),
// AExp70
appBuilder( // 115
comBuilder(2,0),
),
// AExp71
appBuilder( // 116
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 117
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 118
argBuilder(2, true),
argBuilder(0, true),
),
// AExp72
appBuilder( // 119
argBuilder(2, true),
comBuilder(2,115),
comBuilder(4,116),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp73
appBuilder( // 120
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 121
comBuilder(3,119),
argBuilder(0, true),
),
// AExp74
appBuilder( // 122
ptrBuilder(37, false, false),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 123
comBuilder(2,133),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp75
appBuilder( // 124
comBuilder(1,126),
ptrBuilder(0, true, true),
),
appBuilder( // 125
comBuilder(3,122),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp76
appBuilder( // 126
argBuilder(0, true),
comBuilder(3,0),
comBuilder(3,19),
comBuilder(3,1),
),
// AExp77
appBuilder( // 127
comBuilder(4,2),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp78
appBuilder( // 128
comBuilder(4,2),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 129
comBuilder(2,133),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp79
appBuilder( // 130
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 131
comBuilder(4,2),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp80
appBuilder( // 132
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,128),
comBuilder(3,130),
argBuilder(2, false),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp81
appBuilder( // 133
argBuilder(1, true),
comBuilder(1,127),
comBuilder(3,132),
argBuilder(0, true),
),
// AExp82
appBuilder( // 134
comBuilder(2,0),
),
// AExp83
appBuilder( // 135
comBuilder(2,139),
ptrBuilder(0, true, true),
),
appBuilder( // 136
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp84
appBuilder( // 137
comBuilder(4,2),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 138
comBuilder(1,135),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp85
appBuilder( // 139
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,134),
comBuilder(2,137),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
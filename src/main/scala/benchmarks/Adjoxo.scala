package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Adjoxo extends Benchmark {
override def toString() = "Adjoxo" 
val combinatorCount = 68
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(2,15),
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
comBuilder(3,26),
intBuilder(0),
),
// AExp2
appBuilder( // 6
comBuilder(3,28),
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
comBuilder(1,63),
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
comBuilder(1,61),
ptrBuilder(11, false, false),
),
appBuilder( // 13
comBuilder(3,58),
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
comBuilder(1,56),
ptrBuilder(15, false, false),
),
appBuilder( // 17
comBuilder(3,53),
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
comBuilder(1,51),
ptrBuilder(19, false, false),
),
appBuilder( // 21
comBuilder(3,48),
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
comBuilder(1,46),
ptrBuilder(23, false, false),
),
appBuilder( // 25
comBuilder(3,43),
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
comBuilder(1,41),
ptrBuilder(27, false, false),
),
appBuilder( // 29
comBuilder(3,38),
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
comBuilder(1,36),
ptrBuilder(31, false, false),
),
appBuilder( // 33
comBuilder(3,33),
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
comBuilder(1,31),
ptrBuilder(35, false, false),
),
// AExp3
appBuilder( // 37
comBuilder(3,92),
ptrBuilder(42, false, false),
),
appBuilder( // 38
comBuilder(2,146),
intBuilder(1),
intBuilder(9),
),
appBuilder( // 39
comBuilder(2,83),
ptrBuilder(38, false, false),
),
appBuilder( // 40
comBuilder(2,101),
ptrBuilder(39, false, false),
),
appBuilder( // 41
comBuilder(3,96),
ptrBuilder(40, false, false),
),
appBuilder( // 42
comBuilder(3,94),
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
comBuilder(2,87),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 4
ptrBuilder(37, false, false),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp4
appBuilder( // 5
ptrBuilder(6, false, false),
argBuilder(0, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 6
comBuilder(2,87),
comBuilder(3,23),
comBuilder(2,0),
),
appBuilder( // 7
comBuilder(2,3),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp5
appBuilder( // 8
ptrBuilder(6, false, false),
argBuilder(1, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 9
comBuilder(2,87),
comBuilder(3,23),
comBuilder(2,1),
),
appBuilder( // 10
comBuilder(2,5),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp6
appBuilder( // 11
comBuilder(2,87),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 12
ptrBuilder(37, false, false),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp7
appBuilder( // 13
comBuilder(2,87),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 14
ptrBuilder(37, false, false),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp8
appBuilder( // 15
comBuilder(2,21),
ptrBuilder(4, true, true),
ptrBuilder(3, true, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 16
comBuilder(2,13),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 17
comBuilder(2,11),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 18
comBuilder(2,8),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 19
ptrBuilder(5, false, false),
argBuilder(1, false),
),
appBuilder( // 20
ptrBuilder(5, false, false),
argBuilder(0, false),
),
// AExp9
appBuilder( // 21
prmBuilder("=="),
argBuilder(0, false),
argBuilder(1, false),
ptrBuilder(0, true, true),
comBuilder(3,0),
),
appBuilder( // 22
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(3,23),
comBuilder(3,1),
),
// AExp10
appBuilder( // 23
argBuilder(2, true),
),
// AExp11
appBuilder( // 24
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 25
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp12
appBuilder( // 26
argBuilder(2, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 27
comBuilder(3,24),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp13
appBuilder( // 28
comBuilder(2,65),
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
// AExp14
appBuilder( // 31
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(4,2),
intBuilder(1),
argBuilder(0, true),
),
// AExp15
appBuilder( // 33
comBuilder(2,65),
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
// AExp16
appBuilder( // 36
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(4,2),
intBuilder(4),
argBuilder(0, true),
),
// AExp17
appBuilder( // 38
comBuilder(2,65),
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
// AExp18
appBuilder( // 41
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 42
comBuilder(4,2),
intBuilder(7),
argBuilder(0, true),
),
// AExp19
appBuilder( // 43
comBuilder(2,65),
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
// AExp20
appBuilder( // 46
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 47
comBuilder(4,2),
intBuilder(1),
argBuilder(0, true),
),
// AExp21
appBuilder( // 48
comBuilder(2,65),
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
// AExp22
appBuilder( // 51
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(4,2),
intBuilder(2),
argBuilder(0, true),
),
// AExp23
appBuilder( // 53
comBuilder(2,65),
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
// AExp24
appBuilder( // 56
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(4,2),
intBuilder(3),
argBuilder(0, true),
),
// AExp25
appBuilder( // 58
comBuilder(2,65),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 59
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 60
argBuilder(0, true),
argBuilder(2, false),
),
// AExp26
appBuilder( // 61
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 62
comBuilder(4,2),
intBuilder(1),
argBuilder(0, true),
),
// AExp27
appBuilder( // 63
comBuilder(2,66),
ptrBuilder(0, true, true),
),
appBuilder( // 64
comBuilder(4,2),
intBuilder(3),
argBuilder(0, true),
),
// AExp28
appBuilder( // 65
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp29
appBuilder( // 66
comBuilder(1,69),
ptrBuilder(0, true, true),
),
appBuilder( // 67
comBuilder(2,83),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp30
appBuilder( // 68
comBuilder(2,0),
),
// AExp31
appBuilder( // 69
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,68),
),
// AExp32
appBuilder( // 70
comBuilder(2,83),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 71
comBuilder(4,2),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp33
appBuilder( // 72
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 73
comBuilder(3,70),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp34
appBuilder( // 74
comBuilder(2,83),
ptrBuilder(0, true, true),
),
appBuilder( // 75
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp35
appBuilder( // 76
comBuilder(2,21),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 77
comBuilder(2,74),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(3, false),
),
appBuilder( // 78
comBuilder(4,72),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 79
comBuilder(2,83),
argBuilder(1, false),
argBuilder(3, false),
),
// AExp36
appBuilder( // 80
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 81
comBuilder(4,76),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 82
comBuilder(4,2),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp37
appBuilder( // 83
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 84
comBuilder(3,80),
argBuilder(1, true),
),
// AExp38
appBuilder( // 85
comBuilder(1,90),
ptrBuilder(0, true, true),
),
appBuilder( // 86
comBuilder(1,91),
argBuilder(0, true),
),
// AExp39
appBuilder( // 87
argBuilder(0, true),
intBuilder(3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 88
comBuilder(1,90),
argBuilder(1, false),
),
appBuilder( // 89
comBuilder(1,85),
argBuilder(1, false),
),
// AExp40
appBuilder( // 90
argBuilder(0, true),
intBuilder(0),
intBuilder(88),
),
// AExp41
appBuilder( // 91
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp42
appBuilder( // 92
ptrBuilder(6, false, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
comBuilder(3,1),
),
appBuilder( // 93
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp43
appBuilder( // 94
comBuilder(2,106),
argBuilder(1, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
comBuilder(3,0),
),
appBuilder( // 95
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp44
appBuilder( // 96
comBuilder(1,114),
comBuilder(2,116),
ptrBuilder(0, true, true),
),
appBuilder( // 97
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp45
appBuilder( // 98
comBuilder(1,123),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 99
comBuilder(2,83),
argBuilder(0, true),
argBuilder(2, false),
),
appBuilder( // 100
comBuilder(3,127),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp46
appBuilder( // 101
comBuilder(3,98),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 102
argBuilder(0, true),
argBuilder(1, false),
),
// AExp47
appBuilder( // 103
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 104
ptrBuilder(5, false, false),
argBuilder(1, true),
),
appBuilder( // 105
ptrBuilder(5, false, false),
argBuilder(0, true),
),
// AExp48
appBuilder( // 106
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(9),
),
appBuilder( // 107
comBuilder(2,103),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp49
appBuilder( // 108
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 109
argBuilder(1, true),
argBuilder(3, true),
),
// AExp50
appBuilder( // 110
argBuilder(3, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 111
comBuilder(6,108),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp51
appBuilder( // 112
argBuilder(2, true),
errorBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 113
comBuilder(4,110),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp52
appBuilder( // 114
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 115
comBuilder(3,112),
argBuilder(0, true),
),
// AExp53
appBuilder( // 116
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, false),
comBuilder(3,23),
),
appBuilder( // 117
argBuilder(1, false),
comBuilder(3,0),
comBuilder(3,0),
comBuilder(3,23),
),
// AExp54
appBuilder( // 118
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 119
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 120
argBuilder(0, true),
argBuilder(2, true),
),
// AExp55
appBuilder( // 121
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 122
comBuilder(4,118),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp56
appBuilder( // 123
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 124
comBuilder(3,121),
argBuilder(0, true),
),
// AExp57
appBuilder( // 125
ptrBuilder(37, false, false),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 126
comBuilder(1,140),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp58
appBuilder( // 127
comBuilder(1,129),
ptrBuilder(0, true, true),
),
appBuilder( // 128
comBuilder(3,125),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp59
appBuilder( // 129
argBuilder(0, true),
comBuilder(3,0),
comBuilder(3,23),
comBuilder(3,1),
),
// AExp60
appBuilder( // 130
comBuilder(4,2),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 131
argBuilder(0, true),
argBuilder(2, true),
),
// AExp61
appBuilder( // 132
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 133
comBuilder(4,2),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp62
appBuilder( // 134
prmBuilder("<="),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 135
comBuilder(3,132),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 136
comBuilder(3,130),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp63
appBuilder( // 137
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 138
comBuilder(4,134),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 139
comBuilder(4,2),
argBuilder(0, false),
comBuilder(2,0),
),
// AExp64
appBuilder( // 140
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 141
comBuilder(3,137),
argBuilder(0, true),
),
// AExp65
appBuilder( // 142
comBuilder(2,146),
ptrBuilder(0, true, true),
),
appBuilder( // 143
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp66
appBuilder( // 144
comBuilder(4,2),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 145
comBuilder(1,142),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp67
appBuilder( // 146
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 147
comBuilder(2,144),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
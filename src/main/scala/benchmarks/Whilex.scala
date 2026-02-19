package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Whilex extends Benchmark {
override def toString() = "Whilex" 
val combinatorCount = 76
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(3,14),
ptrBuilder(52, false, false),
intBuilder(5),
comBuilder(1,0),
),
appBuilder( // 1
comBuilder(4,2),
comBuilder(1,8),
comBuilder(2,0),
),
appBuilder( // 2
comBuilder(4,2),
comBuilder(1,7),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(4,2),
comBuilder(1,6),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(4,2),
comBuilder(1,5),
ptrBuilder(3, false, false),
),
appBuilder( // 5
comBuilder(4,2),
comBuilder(1,4),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(4,2),
comBuilder(1,3),
ptrBuilder(5, false, false),
),
appBuilder( // 7
comBuilder(5,155),
intBuilder(1),
),
appBuilder( // 8
comBuilder(5,150),
intBuilder(4),
),
appBuilder( // 9
comBuilder(6,158),
ptrBuilder(8, false, false),
ptrBuilder(7, false, false),
),
appBuilder( // 10
comBuilder(7,84),
intBuilder(4),
ptrBuilder(9, false, false),
),
appBuilder( // 11
comBuilder(5,155),
intBuilder(1),
),
appBuilder( // 12
comBuilder(5,150),
intBuilder(5),
),
appBuilder( // 13
comBuilder(6,84),
ptrBuilder(12, false, false),
ptrBuilder(11, false, false),
),
appBuilder( // 14
comBuilder(7,84),
intBuilder(5),
ptrBuilder(13, false, false),
),
appBuilder( // 15
comBuilder(5,155),
intBuilder(0),
),
appBuilder( // 16
comBuilder(5,150),
intBuilder(0),
),
appBuilder( // 17
comBuilder(3,153),
ptrBuilder(16, false, false),
ptrBuilder(15, false, false),
),
appBuilder( // 18
comBuilder(4,147),
ptrBuilder(17, false, false),
ptrBuilder(14, false, false),
comBuilder(5,148),
),
appBuilder( // 19
comBuilder(5,155),
intBuilder(1),
),
appBuilder( // 20
comBuilder(5,150),
intBuilder(2),
),
appBuilder( // 21
comBuilder(6,84),
ptrBuilder(20, false, false),
ptrBuilder(19, false, false),
),
appBuilder( // 22
comBuilder(7,84),
intBuilder(2),
ptrBuilder(21, false, false),
),
appBuilder( // 23
comBuilder(5,150),
intBuilder(1),
),
appBuilder( // 24
comBuilder(5,150),
intBuilder(0),
),
appBuilder( // 25
comBuilder(6,158),
ptrBuilder(24, false, false),
ptrBuilder(23, false, false),
),
appBuilder( // 26
comBuilder(7,84),
intBuilder(0),
ptrBuilder(25, false, false),
),
appBuilder( // 27
comBuilder(7,2),
ptrBuilder(26, false, false),
ptrBuilder(22, false, false),
),
appBuilder( // 28
comBuilder(5,150),
intBuilder(0),
),
appBuilder( // 29
comBuilder(5,150),
intBuilder(1),
),
appBuilder( // 30
comBuilder(3,156),
ptrBuilder(29, false, false),
ptrBuilder(28, false, false),
),
appBuilder( // 31
comBuilder(7,149),
ptrBuilder(30, false, false),
),
appBuilder( // 32
comBuilder(1,0),
ptrBuilder(31, false, false),
ptrBuilder(27, false, false),
),
appBuilder( // 33
comBuilder(5,150),
intBuilder(4),
),
appBuilder( // 34
comBuilder(7,84),
intBuilder(1),
ptrBuilder(33, false, false),
),
appBuilder( // 35
comBuilder(5,150),
intBuilder(3),
),
appBuilder( // 36
comBuilder(7,84),
intBuilder(0),
ptrBuilder(35, false, false),
),
appBuilder( // 37
comBuilder(7,2),
ptrBuilder(36, false, false),
ptrBuilder(34, false, false),
),
appBuilder( // 38
comBuilder(7,2),
ptrBuilder(37, false, false),
ptrBuilder(32, false, false),
),
appBuilder( // 39
comBuilder(7,2),
ptrBuilder(38, false, false),
),
appBuilder( // 40
comBuilder(1,0),
ptrBuilder(39, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 41
comBuilder(7,2),
ptrBuilder(40, false, false),
ptrBuilder(10, false, false),
),
appBuilder( // 42
comBuilder(5,155),
intBuilder(0),
),
appBuilder( // 43
comBuilder(5,150),
intBuilder(4),
),
appBuilder( // 44
comBuilder(3,153),
ptrBuilder(43, false, false),
ptrBuilder(42, false, false),
),
appBuilder( // 45
comBuilder(2,151),
ptrBuilder(44, false, false),
),
appBuilder( // 46
comBuilder(7,149),
ptrBuilder(45, false, false),
),
appBuilder( // 47
comBuilder(1,0),
ptrBuilder(46, false, false),
ptrBuilder(41, false, false),
),
appBuilder( // 48
comBuilder(5,150),
intBuilder(3),
),
appBuilder( // 49
comBuilder(7,84),
intBuilder(4),
ptrBuilder(48, false, false),
),
appBuilder( // 50
comBuilder(7,2),
ptrBuilder(49, false, false),
),
appBuilder( // 51
comBuilder(1,0),
ptrBuilder(50, false, false),
ptrBuilder(47, false, false),
),
appBuilder( // 52
comBuilder(2,16),
ptrBuilder(51, false, false),
ptrBuilder(6, false, false),
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
argBuilder(0, true),
intBuilder(0),
intBuilder(0),
),
// AExp4
appBuilder( // 4
argBuilder(0, true),
intBuilder(1),
intBuilder(0),
),
// AExp5
appBuilder( // 5
argBuilder(0, true),
intBuilder(2),
intBuilder(0),
),
// AExp6
appBuilder( // 6
argBuilder(0, true),
intBuilder(3),
intBuilder(17),
),
// AExp7
appBuilder( // 7
argBuilder(0, true),
intBuilder(4),
intBuilder(0),
),
// AExp8
appBuilder( // 8
argBuilder(0, true),
intBuilder(5),
intBuilder(0),
),
// AExp9
appBuilder( // 9
prmBuilder("=="),
argBuilder(3, true),
argBuilder(0, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
argBuilder(1, false),
argBuilder(4, true),
),
appBuilder( // 11
comBuilder(3,14),
argBuilder(2, true),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp10
appBuilder( // 12
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(5,9),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp11
appBuilder( // 14
argBuilder(0, true),
errorBuilder(42),
ptrBuilder(0, true, true),
),
appBuilder( // 15
comBuilder(4,12),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp12
appBuilder( // 16
comBuilder(1,20),
ptrBuilder(0, true, true),
),
appBuilder( // 17
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp13
appBuilder( // 18
comBuilder(1,20),
ptrBuilder(0, true, true),
),
appBuilder( // 19
comBuilder(2,36),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp14
appBuilder( // 20
argBuilder(0, true),
comBuilder(1,0),
comBuilder(2,18),
),
// AExp15
appBuilder( // 21
comBuilder(3,52),
argBuilder(2, true),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 22
comBuilder(4,79),
argBuilder(0, false),
argBuilder(1, true),
comBuilder(3,42),
),
// AExp16
appBuilder( // 23
comBuilder(4,2),
ptrBuilder(0, true, true),
),
appBuilder( // 24
comBuilder(7,2),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp17
appBuilder( // 25
comBuilder(2,36),
argBuilder(1, true),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 26
comBuilder(2,23),
argBuilder(2, false),
),
appBuilder( // 27
comBuilder(4,2),
argBuilder(2, false),
),
// AExp18
appBuilder( // 28
comBuilder(3,128),
argBuilder(1, true),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(4,143),
argBuilder(0, false),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp19
appBuilder( // 30
comBuilder(7,2),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(7,149),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp20
appBuilder( // 32
comBuilder(4,147),
argBuilder(0, false),
ptrBuilder(0, true, true),
comBuilder(5,148),
),
appBuilder( // 33
comBuilder(2,30),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp21
appBuilder( // 34
comBuilder(4,2),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 35
comBuilder(2,32),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp22
appBuilder( // 36
argBuilder(0, true),
ptrBuilder(4, true, true),
ptrBuilder(3, true, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(3,34),
argBuilder(1, false),
),
appBuilder( // 38
comBuilder(3,42),
argBuilder(1, false),
),
appBuilder( // 39
comBuilder(4,28),
argBuilder(1, false),
),
appBuilder( // 40
comBuilder(3,25),
argBuilder(1, false),
),
appBuilder( // 41
comBuilder(3,21),
argBuilder(1, false),
),
// AExp23
appBuilder( // 42
argBuilder(1, true),
argBuilder(0, true),
),
// AExp24
appBuilder( // 43
comBuilder(3,56),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 44
comBuilder(3,60),
argBuilder(1, true),
),
appBuilder( // 45
comBuilder(3,52),
argBuilder(3, true),
argBuilder(0, false),
),
appBuilder( // 46
comBuilder(3,52),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp25
appBuilder( // 47
comBuilder(3,56),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(3,65),
argBuilder(1, true),
),
appBuilder( // 49
comBuilder(3,52),
argBuilder(3, true),
argBuilder(0, false),
),
appBuilder( // 50
comBuilder(3,52),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp26
appBuilder( // 51
comBuilder(3,14),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp27
appBuilder( // 52
argBuilder(0, true),
ptrBuilder(2, true, true),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 53
comBuilder(3,51),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 54
comBuilder(4,47),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 55
comBuilder(4,43),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp28
appBuilder( // 56
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(3,58),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp29
appBuilder( // 58
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 59
argBuilder(1, true),
argBuilder(2, true),
),
// AExp30
appBuilder( // 60
comBuilder(2,62),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 61
prmBuilder("+"),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp31
appBuilder( // 62
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 63
argBuilder(1, false),
intBuilder(0),
),
appBuilder( // 64
argBuilder(1, false),
argBuilder(0, false),
),
// AExp32
appBuilder( // 65
comBuilder(2,62),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 66
prmBuilder("-"),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp33
appBuilder( // 67
prmBuilder("=="),
argBuilder(5, false),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 68
argBuilder(2, true),
argBuilder(3, false),
argBuilder(4, false),
),
appBuilder( // 69
argBuilder(1, true),
argBuilder(3, false),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, true),
),
// AExp34
appBuilder( // 70
comBuilder(4,79),
argBuilder(3, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 71
comBuilder(3,85),
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp35
appBuilder( // 72
comBuilder(4,79),
argBuilder(3, true),
argBuilder(0, false),
ptrBuilder(0, true, true),
argBuilder(2, false),
),
appBuilder( // 73
comBuilder(3,85),
argBuilder(1, true),
argBuilder(0, false),
argBuilder(2, false),
),
// AExp36
appBuilder( // 74
comBuilder(7,67),
argBuilder(0, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 75
comBuilder(4,72),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 76
comBuilder(6,70),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp37
appBuilder( // 77
argBuilder(3, true),
ptrBuilder(0, true, true),
),
appBuilder( // 78
comBuilder(2,74),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
),
// AExp38
appBuilder( // 79
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 80
comBuilder(5,77),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, true),
),
appBuilder( // 81
argBuilder(2, false),
comBuilder(2,0),
),
// AExp39
appBuilder( // 82
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 83
comBuilder(4,2),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp40
appBuilder( // 84
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp41
appBuilder( // 85
comBuilder(3,82),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 86
comBuilder(3,84),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp42
appBuilder( // 87
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 88
argBuilder(0, true),
comBuilder(2,1),
),
// AExp43
appBuilder( // 89
prmBuilder("<"),
argBuilder(2, true),
intBuilder(5),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 90
argBuilder(3, false),
argBuilder(1, true),
),
appBuilder( // 91
comBuilder(2,87),
argBuilder(0, true),
argBuilder(3, false),
),
// AExp44
appBuilder( // 92
comBuilder(3,128),
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 93
comBuilder(2,130),
argBuilder(1, true),
),
// AExp45
appBuilder( // 94
comBuilder(4,89),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 95
comBuilder(3,92),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp46
appBuilder( // 96
prmBuilder("<"),
argBuilder(3, false),
intBuilder(4),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 97
argBuilder(4, false),
argBuilder(2, true),
),
appBuilder( // 98
comBuilder(2,94),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, false),
argBuilder(4, false),
),
// AExp47
appBuilder( // 99
comBuilder(3,56),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 100
comBuilder(3,136),
argBuilder(1, true),
),
appBuilder( // 101
comBuilder(3,52),
argBuilder(3, true),
argBuilder(0, false),
),
appBuilder( // 102
comBuilder(3,52),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp48
appBuilder( // 103
comBuilder(5,96),
argBuilder(0, false),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 104
comBuilder(4,99),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp49
appBuilder( // 105
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 106
argBuilder(0, true),
comBuilder(2,0),
),
// AExp50
appBuilder( // 107
prmBuilder("<"),
argBuilder(2, true),
intBuilder(2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 108
argBuilder(3, false),
argBuilder(1, true),
),
appBuilder( // 109
comBuilder(2,105),
argBuilder(0, true),
argBuilder(3, false),
),
// AExp51
appBuilder( // 110
comBuilder(3,56),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 111
comBuilder(3,138),
argBuilder(1, true),
),
appBuilder( // 112
comBuilder(3,52),
argBuilder(3, true),
argBuilder(0, false),
),
appBuilder( // 113
comBuilder(3,52),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp52
appBuilder( // 114
comBuilder(4,107),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 115
comBuilder(4,110),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp53
appBuilder( // 116
prmBuilder("<"),
argBuilder(3, false),
intBuilder(1),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 117
argBuilder(4, false),
argBuilder(2, true),
),
appBuilder( // 118
comBuilder(2,114),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, false),
argBuilder(4, false),
),
// AExp54
appBuilder( // 119
comBuilder(3,56),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 120
comBuilder(3,140),
argBuilder(1, true),
),
appBuilder( // 121
comBuilder(3,128),
argBuilder(3, true),
argBuilder(0, false),
),
appBuilder( // 122
comBuilder(3,128),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp55
appBuilder( // 123
comBuilder(5,116),
argBuilder(0, false),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 124
comBuilder(4,119),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp56
appBuilder( // 125
prmBuilder("<"),
argBuilder(2, false),
intBuilder(3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 126
comBuilder(2,123),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 127
comBuilder(2,103),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp57
appBuilder( // 128
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 129
comBuilder(4,125),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp58
appBuilder( // 130
comBuilder(2,132),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 131
comBuilder(1,135),
argBuilder(1, true),
),
// AExp59
appBuilder( // 132
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 133
argBuilder(1, false),
comBuilder(2,1),
),
appBuilder( // 134
argBuilder(1, false),
comBuilder(2,0),
),
// AExp60
appBuilder( // 135
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp61
appBuilder( // 136
comBuilder(2,132),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 137
prmBuilder("<="),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp62
appBuilder( // 138
comBuilder(2,132),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 139
prmBuilder("=="),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp63
appBuilder( // 140
comBuilder(2,132),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 141
comBuilder(1,142),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp64
appBuilder( // 142
argBuilder(0, true),
comBuilder(2,0),
),
// AExp65
appBuilder( // 143
argBuilder(3, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 144
comBuilder(4,2),
argBuilder(1, true),
argBuilder(0, false),
),
appBuilder( // 145
comBuilder(4,2),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp66
appBuilder( // 146
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp67
appBuilder( // 147
comBuilder(7,146),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp68
appBuilder( // 148
argBuilder(3, true),
),
// AExp69
appBuilder( // 149
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp70
appBuilder( // 150
argBuilder(4, true),
argBuilder(0, true),
),
// AExp71
appBuilder( // 151
argBuilder(1, true),
intBuilder(4),
ptrBuilder(0, true, true),
),
appBuilder( // 152
comBuilder(2,42),
argBuilder(0, true),
),
// AExp72
appBuilder( // 153
argBuilder(2, true),
intBuilder(1),
ptrBuilder(0, true, true),
),
appBuilder( // 154
comBuilder(3,84),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp73
appBuilder( // 155
argBuilder(2, true),
argBuilder(0, true),
),
// AExp74
appBuilder( // 156
argBuilder(2, true),
intBuilder(3),
ptrBuilder(0, true, true),
),
appBuilder( // 157
comBuilder(3,84),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp75
appBuilder( // 158
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
),
)
}
package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Countdown extends Benchmark {
override def toString() = "Countdown" 
val combinatorCount = 108
val heap_img = Seq(
// AExp0
appBuilder( // 0
ptrBuilder(5, false, false),
ptrBuilder(4, false, false),
),
appBuilder( // 1
comBuilder(4,2),
intBuilder(10),
comBuilder(2,0),
),
appBuilder( // 2
comBuilder(4,2),
intBuilder(4),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(4,2),
intBuilder(3),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(2,6),
ptrBuilder(3, false, false),
intBuilder(70),
),
// AExp1
appBuilder( // 5
yBuilder(),
comBuilder(3,5),
intBuilder(0),
),
// AExp2
appBuilder( // 6
comBuilder(3,57),
ptrBuilder(11, false, false),
),
appBuilder( // 7
comBuilder(4,2),
comBuilder(6,1),
comBuilder(2,0),
),
appBuilder( // 8
comBuilder(4,2),
comBuilder(6,124),
ptrBuilder(7, false, false),
),
appBuilder( // 9
comBuilder(1,63),
ptrBuilder(8, false, false),
),
appBuilder( // 10
comBuilder(5,61),
ptrBuilder(9, false, false),
),
appBuilder( // 11
comBuilder(4,59),
ptrBuilder(10, false, false),
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
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 4
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp4
appBuilder( // 5
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,3),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp5
appBuilder( // 6
comBuilder(1,14),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 7
comBuilder(1,155),
argBuilder(0, true),
),
appBuilder( // 8
comBuilder(2,21),
argBuilder(1, true),
),
// AExp6
appBuilder( // 9
comBuilder(2,0),
),
// AExp7
appBuilder( // 10
comBuilder(2,19),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 11
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 12
argBuilder(2, true),
argBuilder(0, true),
),
// AExp8
appBuilder( // 13
argBuilder(2, true),
comBuilder(2,9),
comBuilder(4,10),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 14
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 15
comBuilder(3,13),
argBuilder(0, true),
),
// AExp10
appBuilder( // 16
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 17
argBuilder(3, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 18
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,16),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp12
appBuilder( // 19
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 20
comBuilder(3,18),
argBuilder(1, true),
),
// AExp13
appBuilder( // 21
comBuilder(2,30),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 22
comBuilder(1,40),
argBuilder(1, true),
),
// AExp14
appBuilder( // 23
comBuilder(2,0),
),
// AExp15
appBuilder( // 24
comBuilder(2,30),
),
// AExp16
appBuilder( // 25
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 26
comBuilder(2,30),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp17
appBuilder( // 27
prmBuilder("=="),
argBuilder(3, true),
argBuilder(1, false),
comBuilder(1,24),
comBuilder(3,25),
argBuilder(2, true),
argBuilder(1, false),
argBuilder(0, true),
),
// AExp18
appBuilder( // 28
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(4,27),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp19
appBuilder( // 30
argBuilder(1, true),
comBuilder(1,23),
comBuilder(3,28),
argBuilder(0, true),
),
// AExp20
appBuilder( // 31
comBuilder(1,139),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp21
appBuilder( // 33
comBuilder(1,14),
comBuilder(1,46),
ptrBuilder(0, true, true),
),
appBuilder( // 34
comBuilder(2,31),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp22
appBuilder( // 35
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 36
comBuilder(7,154),
argBuilder(0, false),
),
// AExp23
appBuilder( // 37
comBuilder(4,2),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 38
comBuilder(2,35),
argBuilder(0, true),
),
// AExp24
appBuilder( // 39
comBuilder(1,42),
argBuilder(1, false),
comBuilder(2,33),
comBuilder(2,37),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp25
appBuilder( // 40
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,39),
),
// AExp26
appBuilder( // 41
comBuilder(2,0),
),
// AExp27
appBuilder( // 42
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,41),
),
// AExp28
appBuilder( // 43
comBuilder(1,55),
ptrBuilder(6, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 44
comBuilder(1,40),
argBuilder(1, true),
),
appBuilder( // 45
comBuilder(1,40),
argBuilder(0, true),
),
// AExp29
appBuilder( // 46
argBuilder(0, true),
comBuilder(2,43),
),
// AExp30
appBuilder( // 47
comBuilder(2,0),
),
// AExp31
appBuilder( // 48
comBuilder(1,14),
ptrBuilder(0, true, true),
),
appBuilder( // 49
argBuilder(1, true),
argBuilder(0, true),
),
// AExp32
appBuilder( // 50
comBuilder(2,19),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 51
argBuilder(0, true),
argBuilder(2, true),
argBuilder(4, false),
),
appBuilder( // 52
comBuilder(2,48),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, false),
),
// AExp33
appBuilder( // 53
argBuilder(2, true),
comBuilder(2,47),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 54
comBuilder(5,50),
argBuilder(1, true),
),
// AExp34
appBuilder( // 55
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 56
comBuilder(3,53),
argBuilder(0, true),
),
// AExp35
appBuilder( // 57
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 58
argBuilder(0, true),
argBuilder(2, true),
),
// AExp36
appBuilder( // 59
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 60
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp37
appBuilder( // 61
comBuilder(1,14),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 62
comBuilder(2,75),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp38
appBuilder( // 63
comBuilder(4,2),
comBuilder(6,0),
ptrBuilder(0, true, true),
),
appBuilder( // 64
comBuilder(4,2),
comBuilder(6,123),
argBuilder(0, true),
),
// AExp39
appBuilder( // 65
argBuilder(0, true),
argBuilder(4, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp40
appBuilder( // 66
comBuilder(5,65),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(1, true),
argBuilder(3, false),
),
appBuilder( // 67
argBuilder(0, true),
argBuilder(3, false),
),
// AExp41
appBuilder( // 68
comBuilder(2,0),
),
// AExp42
appBuilder( // 69
argBuilder(5, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 70
comBuilder(2,111),
argBuilder(0, false),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 71
comBuilder(5,106),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp43
appBuilder( // 72
comBuilder(4,2),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 73
comBuilder(6,69),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp44
appBuilder( // 74
comBuilder(1,85),
argBuilder(3, false),
argBuilder(1, true),
argBuilder(2, true),
comBuilder(5,68),
comBuilder(5,72),
argBuilder(3, false),
argBuilder(0, true),
),
// AExp45
appBuilder( // 75
comBuilder(4,66),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 76
comBuilder(4,74),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp46
appBuilder( // 77
comBuilder(2,1),
),
// AExp47
appBuilder( // 78
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(0),
),
appBuilder( // 79
comBuilder(2,86),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp48
appBuilder( // 80
comBuilder(2,1),
),
// AExp49
appBuilder( // 81
comBuilder(1,104),
ptrBuilder(0, true, true),
),
appBuilder( // 82
prmBuilder("<="),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp50
appBuilder( // 83
comBuilder(2,0),
),
// AExp51
appBuilder( // 84
comBuilder(2,0),
),
// AExp52
appBuilder( // 85
argBuilder(0, true),
comBuilder(2,77),
comBuilder(2,78),
comBuilder(2,80),
comBuilder(2,81),
comBuilder(3,83),
comBuilder(5,84),
),
// AExp53
appBuilder( // 86
comBuilder(1,102),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp54
appBuilder( // 87
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 88
argBuilder(1, true),
argBuilder(2, false),
),
// AExp55
appBuilder( // 89
argBuilder(2, true),
intBuilder(0),
argBuilder(0, true),
),
// AExp56
appBuilder( // 90
argBuilder(2, true),
intBuilder(1),
ptrBuilder(0, true, true),
),
appBuilder( // 91
prmBuilder("-"),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp57
appBuilder( // 92
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,89),
comBuilder(3,90),
argBuilder(0, false),
argBuilder(2, false),
),
// AExp58
appBuilder( // 93
argBuilder(3, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 94
prmBuilder("-"),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 95
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp59
appBuilder( // 96
prmBuilder("<="),
argBuilder(0, false),
argBuilder(2, false),
comBuilder(4,2),
comBuilder(4,93),
ptrBuilder(0, true, true),
argBuilder(2, false),
argBuilder(0, false),
),
appBuilder( // 97
prmBuilder("+"),
argBuilder(1, false),
argBuilder(1, false),
),
// AExp60
appBuilder( // 98
comBuilder(1,102),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 99
comBuilder(3,96),
argBuilder(2, true),
),
// AExp61
appBuilder( // 100
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,92),
comBuilder(3,98),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(1, true),
),
// AExp62
appBuilder( // 101
prmBuilder("+"),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp63
appBuilder( // 102
comBuilder(3,87),
ptrBuilder(0, true, true),
comBuilder(1,101),
),
appBuilder( // 103
comBuilder(3,100),
argBuilder(0, true),
),
// AExp64
appBuilder( // 104
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp65
appBuilder( // 105
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp66
appBuilder( // 106
comBuilder(7,105),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp67
appBuilder( // 107
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 108
argBuilder(1, true),
argBuilder(2, true),
),
// AExp68
appBuilder( // 109
intBuilder(0),
),
// AExp69
appBuilder( // 110
intBuilder(0),
),
// AExp70
appBuilder( // 111
comBuilder(3,107),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 112
argBuilder(0, true),
prmBuilder("+"),
comBuilder(2,113),
comBuilder(2,122),
prmBuilder("-"),
comBuilder(3,109),
comBuilder(5,110),
argBuilder(1, true),
),
// AExp71
appBuilder( // 113
comBuilder(1,102),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp72
appBuilder( // 114
comBuilder(2,122),
ptrBuilder(0, true, true),
),
appBuilder( // 115
prmBuilder("+"),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp73
appBuilder( // 116
intBuilder(0),
),
// AExp74
appBuilder( // 117
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 118
prmBuilder("=="),
argBuilder(2, true),
intBuilder(0),
comBuilder(1,0),
comBuilder(1,116),
argBuilder(0, false),
),
appBuilder( // 119
comBuilder(1,114),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp75
appBuilder( // 120
comBuilder(1,102),
argBuilder(1, true),
intBuilder(2),
ptrBuilder(0, true, true),
),
appBuilder( // 121
comBuilder(3,117),
argBuilder(0, true),
),
// AExp76
appBuilder( // 122
prmBuilder("=="),
argBuilder(1, false),
intBuilder(1),
comBuilder(2,120),
comBuilder(2,0),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp77
appBuilder( // 123
argBuilder(3, true),
),
// AExp78
appBuilder( // 124
argBuilder(2, true),
),
// AExp79
appBuilder( // 125
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 126
comBuilder(4,2),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp80
appBuilder( // 127
comBuilder(1,145),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 128
comBuilder(1,139),
argBuilder(1, true),
),
appBuilder( // 129
comBuilder(2,152),
argBuilder(0, true),
),
// AExp81
appBuilder( // 130
argBuilder(1, true),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 131
comBuilder(4,2),
argBuilder(0, true),
),
// AExp82
appBuilder( // 132
comBuilder(2,127),
ptrBuilder(0, true, true),
),
appBuilder( // 133
comBuilder(2,130),
argBuilder(0, true),
),
// AExp83
appBuilder( // 134
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 135
comBuilder(1,132),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 136
comBuilder(3,125),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp84
appBuilder( // 137
comBuilder(2,0),
),
// AExp85
appBuilder( // 138
comBuilder(1,42),
argBuilder(1, false),
comBuilder(2,134),
comBuilder(2,137),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp86
appBuilder( // 139
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,138),
),
// AExp87
appBuilder( // 140
comBuilder(2,0),
),
// AExp88
appBuilder( // 141
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 142
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 143
argBuilder(2, true),
argBuilder(0, true),
),
// AExp89
appBuilder( // 144
argBuilder(2, true),
comBuilder(2,140),
comBuilder(4,141),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp90
appBuilder( // 145
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 146
comBuilder(3,144),
argBuilder(0, true),
),
// AExp91
appBuilder( // 147
argBuilder(4, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 148
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 149
argBuilder(0, true),
argBuilder(2, true),
),
// AExp92
appBuilder( // 150
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 151
comBuilder(5,147),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp93
appBuilder( // 152
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 153
comBuilder(3,150),
argBuilder(1, true),
),
// AExp94
appBuilder( // 154
argBuilder(5, true),
argBuilder(0, true),
),
// AExp95
appBuilder( // 155
comBuilder(1,14),
comBuilder(1,160),
ptrBuilder(0, true, true),
),
appBuilder( // 156
comBuilder(1,182),
argBuilder(0, true),
),
// AExp96
appBuilder( // 157
comBuilder(1,14),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 158
comBuilder(1,160),
argBuilder(1, true),
),
appBuilder( // 159
comBuilder(1,174),
argBuilder(0, true),
),
// AExp97
appBuilder( // 160
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,157),
),
appBuilder( // 161
comBuilder(4,2),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp98
appBuilder( // 162
comBuilder(4,2),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 163
comBuilder(4,2),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp99
appBuilder( // 164
comBuilder(4,2),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 165
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp100
appBuilder( // 166
comBuilder(1,145),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 167
argBuilder(0, true),
argBuilder(2, true),
),
appBuilder( // 168
comBuilder(4,2),
argBuilder(1, true),
),
// AExp101
appBuilder( // 169
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 170
comBuilder(3,166),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 171
comBuilder(3,164),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp102
appBuilder( // 172
argBuilder(2, true),
comBuilder(1,162),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 173
comBuilder(4,169),
argBuilder(1, true),
),
// AExp103
appBuilder( // 174
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 175
comBuilder(3,172),
argBuilder(0, true),
),
// AExp104
appBuilder( // 176
comBuilder(1,145),
ptrBuilder(0, true, true),
),
appBuilder( // 177
comBuilder(4,2),
argBuilder(0, true),
),
// AExp105
appBuilder( // 178
comBuilder(2,19),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 179
comBuilder(1,176),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp106
appBuilder( // 180
comBuilder(2,178),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 181
comBuilder(1,182),
argBuilder(1, true),
),
// AExp107
appBuilder( // 182
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,180),
),
appBuilder( // 183
comBuilder(4,2),
comBuilder(2,0),
comBuilder(2,0),
),
)
}
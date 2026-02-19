package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Sumpuz extends Benchmark {
override def toString() = "Sumpuz" 
val combinatorCount = 104
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,2),
ptrBuilder(9, false, false),
),
appBuilder( // 1
comBuilder(4,3),
intBuilder(2),
comBuilder(2,0),
),
appBuilder( // 2
comBuilder(4,3),
intBuilder(1),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(4,3),
intBuilder(2),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(4,3),
ptrBuilder(3, false, false),
comBuilder(2,0),
),
appBuilder( // 5
comBuilder(4,3),
intBuilder(1),
comBuilder(2,0),
),
appBuilder( // 6
comBuilder(4,3),
intBuilder(2),
ptrBuilder(5, false, false),
),
appBuilder( // 7
comBuilder(4,3),
intBuilder(1),
ptrBuilder(6, false, false),
),
appBuilder( // 8
comBuilder(4,3),
intBuilder(0),
ptrBuilder(7, false, false),
),
appBuilder( // 9
comBuilder(4,3),
ptrBuilder(8, false, false),
ptrBuilder(4, false, false),
),
// AExp1
appBuilder( // 10
comBuilder(1,141),
ptrBuilder(11, false, false),
),
appBuilder( // 11
comBuilder(3,126),
comBuilder(1,149),
),
// AExp2
appBuilder( // 12
comBuilder(1,124),
comBuilder(1,95),
),
// AExp3
appBuilder( // 13
yBuilder(),
comBuilder(3,38),
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
comBuilder(3,4),
argBuilder(0, false),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp3
appBuilder( // 3
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp4
appBuilder( // 4
comBuilder(2,6),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 5
comBuilder(3,15),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp5
appBuilder( // 6
comBuilder(1,13),
argBuilder(0, true),
argBuilder(1, true),
intBuilder(0),
),
// AExp6
appBuilder( // 7
prmBuilder("+"),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 8
argBuilder(0, true),
argBuilder(2, true),
),
// AExp7
appBuilder( // 9
argBuilder(1, true),
argBuilder(4, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(3,7),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp8
appBuilder( // 11
argBuilder(2, true),
argBuilder(3, false),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(5,9),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, false),
),
// AExp9
appBuilder( // 13
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(4,11),
argBuilder(0, true),
),
// AExp10
appBuilder( // 15
comBuilder(2,6),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 16
comBuilder(3,17),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 17
comBuilder(2,6),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 18
comBuilder(3,19),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp12
appBuilder( // 19
comBuilder(3,32),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
intBuilder(0),
intBuilder(1),
),
// AExp13
appBuilder( // 20
prmBuilder("=="),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 21
ptrBuilder(13, false, false),
argBuilder(1, true),
),
appBuilder( // 22
ptrBuilder(13, false, false),
argBuilder(0, true),
),
// AExp14
appBuilder( // 23
prmBuilder("=="),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
ptrBuilder(13, false, false),
argBuilder(1, true),
),
appBuilder( // 25
ptrBuilder(13, false, false),
argBuilder(0, true),
),
// AExp15
appBuilder( // 26
argBuilder(0, true),
intBuilder(0),
comBuilder(2,0),
),
// AExp16
appBuilder( // 27
comBuilder(1,0),
comBuilder(1,42),
ptrBuilder(0, true, true),
),
appBuilder( // 28
comBuilder(4,91),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
comBuilder(1,26),
),
// AExp17
appBuilder( // 29
comBuilder(1,35),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 30
comBuilder(3,27),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 31
comBuilder(2,23),
argBuilder(0, false),
argBuilder(2, false),
),
// AExp18
appBuilder( // 32
comBuilder(1,35),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(3,29),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(2, true),
),
appBuilder( // 34
comBuilder(2,20),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp19
appBuilder( // 35
argBuilder(0, true),
comBuilder(2,0),
),
// AExp20
appBuilder( // 36
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 37
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp21
appBuilder( // 38
argBuilder(2, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 39
comBuilder(3,36),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp22
appBuilder( // 40
comBuilder(2,0),
),
// AExp23
appBuilder( // 41
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,40),
),
// AExp24
appBuilder( // 42
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,41),
),
// AExp25
appBuilder( // 43
comBuilder(4,3),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 44
comBuilder(1,95),
argBuilder(0, true),
),
// AExp26
appBuilder( // 45
prmBuilder("=="),
ptrBuilder(1, true, true),
intBuilder(0),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 46
comBuilder(1,43),
argBuilder(0, false),
),
appBuilder( // 47
comBuilder(1,94),
argBuilder(0, false),
),
// AExp27
appBuilder( // 48
comBuilder(3,106),
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 49
comBuilder(1,95),
argBuilder(0, true),
),
appBuilder( // 50
comBuilder(4,3),
intBuilder(1),
comBuilder(2,0),
),
// AExp28
appBuilder( // 51
prmBuilder("=="),
ptrBuilder(1, true, true),
intBuilder(1),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(2,48),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 53
comBuilder(1,94),
argBuilder(0, false),
),
// AExp29
appBuilder( // 54
comBuilder(2,0),
),
// AExp30
appBuilder( // 55
argBuilder(2, true),
ptrBuilder(0, true, true),
comBuilder(2,54),
),
appBuilder( // 56
comBuilder(2,51),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp31
appBuilder( // 57
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 58
comBuilder(3,55),
argBuilder(1, false),
),
appBuilder( // 59
comBuilder(1,45),
argBuilder(1, false),
),
// AExp32
appBuilder( // 60
comBuilder(1,0),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 61
comBuilder(1,162),
argBuilder(1, true),
argBuilder(4, true),
),
appBuilder( // 62
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp33
appBuilder( // 63
comBuilder(1,188),
ptrBuilder(2, true, true),
argBuilder(3, true),
ptrBuilder(1, true, true),
argBuilder(5, true),
ptrBuilder(0, true, true),
),
appBuilder( // 64
argBuilder(2, true),
argBuilder(4, true),
argBuilder(6, true),
),
appBuilder( // 65
comBuilder(1,203),
argBuilder(1, true),
),
appBuilder( // 66
comBuilder(1,94),
argBuilder(0, true),
),
// AExp34
appBuilder( // 67
comBuilder(1,162),
ptrBuilder(0, true, true),
),
appBuilder( // 68
comBuilder(7,63),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp35
appBuilder( // 69
comBuilder(7,60),
ptrBuilder(1, true, true),
argBuilder(1, true),
argBuilder(5, false),
argBuilder(6, false),
ptrBuilder(0, true, true),
),
appBuilder( // 70
argBuilder(2, true),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 71
comBuilder(7,67),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(4, false),
),
// AExp36
appBuilder( // 72
comBuilder(4,91),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 73
comBuilder(1,204),
argBuilder(0, true),
),
// AExp37
appBuilder( // 74
comBuilder(3,106),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 75
comBuilder(2,209),
argBuilder(0, true),
intBuilder(9),
),
appBuilder( // 76
comBuilder(1,203),
argBuilder(1, true),
),
// AExp38
appBuilder( // 77
comBuilder(3,211),
ptrBuilder(0, true, true),
intBuilder(1),
intBuilder(0),
),
appBuilder( // 78
comBuilder(1,204),
argBuilder(0, true),
),
// AExp39
appBuilder( // 79
comBuilder(2,74),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 80
comBuilder(1,77),
argBuilder(0, false),
),
// AExp40
appBuilder( // 81
comBuilder(2,209),
ptrBuilder(0, true, true),
intBuilder(9),
),
appBuilder( // 82
comBuilder(3,211),
argBuilder(0, true),
intBuilder(1),
intBuilder(0),
),
// AExp41
appBuilder( // 83
comBuilder(3,106),
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 84
comBuilder(1,95),
argBuilder(0, true),
),
appBuilder( // 85
comBuilder(1,81),
argBuilder(2, true),
),
// AExp42
appBuilder( // 86
comBuilder(7,69),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(3,83),
argBuilder(0, false),
),
appBuilder( // 87
comBuilder(1,79),
argBuilder(0, false),
),
appBuilder( // 88
comBuilder(2,72),
argBuilder(0, false),
),
// AExp43
appBuilder( // 89
argBuilder(1, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 90
comBuilder(1,86),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp44
appBuilder( // 91
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 92
comBuilder(5,89),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 93
comBuilder(2,57),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp45
appBuilder( // 94
argBuilder(0, true),
comBuilder(2,0),
),
// AExp46
appBuilder( // 95
argBuilder(0, true),
comBuilder(2,1),
),
// AExp47
appBuilder( // 96
ptrBuilder(10, false, false),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 97
ptrBuilder(12, false, false),
argBuilder(1, true),
),
// AExp48
appBuilder( // 98
comBuilder(2,133),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 99
comBuilder(2,96),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 100
comBuilder(1,135),
argBuilder(0, true),
),
// AExp49
appBuilder( // 101
comBuilder(1,124),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 102
comBuilder(3,98),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 103
comBuilder(3,126),
comBuilder(4,3),
argBuilder(2, false),
),
// AExp50
appBuilder( // 104
comBuilder(1,155),
argBuilder(2, true),
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 105
comBuilder(4,3),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp51
appBuilder( // 106
comBuilder(1,116),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 107
comBuilder(3,104),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 108
comBuilder(3,101),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp52
appBuilder( // 109
prmBuilder("=="),
argBuilder(0, true),
argBuilder(3, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 110
comBuilder(3,118),
argBuilder(4, true),
),
appBuilder( // 111
argBuilder(1, true),
argBuilder(2, true),
),
// AExp53
appBuilder( // 112
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 113
comBuilder(5,109),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp54
appBuilder( // 114
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 115
comBuilder(4,112),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp55
appBuilder( // 116
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 117
comBuilder(3,114),
argBuilder(0, true),
),
// AExp56
appBuilder( // 118
argBuilder(2, true),
argBuilder(0, true),
),
// AExp57
appBuilder( // 119
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 120
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 121
argBuilder(0, true),
argBuilder(2, true),
),
// AExp58
appBuilder( // 122
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 123
comBuilder(4,119),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp59
appBuilder( // 124
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 125
comBuilder(3,122),
argBuilder(0, true),
),
// AExp60
appBuilder( // 126
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp61
appBuilder( // 127
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp62
appBuilder( // 128
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 129
comBuilder(2,133),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 130
comBuilder(3,127),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp63
appBuilder( // 131
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 132
comBuilder(4,128),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp64
appBuilder( // 133
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 134
comBuilder(3,131),
argBuilder(1, true),
),
// AExp65
appBuilder( // 135
comBuilder(4,3),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 136
comBuilder(1,135),
argBuilder(0, false),
),
// AExp66
appBuilder( // 137
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 138
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp67
appBuilder( // 139
argBuilder(3, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 140
comBuilder(4,137),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp68
appBuilder( // 141
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 142
comBuilder(4,139),
argBuilder(0, true),
),
// AExp69
appBuilder( // 143
comBuilder(4,3),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 144
argBuilder(0, true),
argBuilder(2, true),
),
// AExp70
appBuilder( // 145
prmBuilder("=="),
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
argBuilder(3, false),
),
appBuilder( // 146
comBuilder(3,143),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp71
appBuilder( // 147
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 148
comBuilder(4,145),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp72
appBuilder( // 149
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 150
comBuilder(3,147),
argBuilder(0, true),
),
// AExp73
appBuilder( // 151
prmBuilder("=="),
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 152
argBuilder(1, true),
argBuilder(3, true),
),
// AExp74
appBuilder( // 153
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 154
comBuilder(4,151),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp75
appBuilder( // 155
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 156
comBuilder(3,153),
argBuilder(0, true),
),
// AExp76
appBuilder( // 157
comBuilder(2,168),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 158
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 159
argBuilder(0, true),
argBuilder(2, true),
),
// AExp77
appBuilder( // 160
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 161
comBuilder(4,157),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp78
appBuilder( // 162
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 163
comBuilder(3,160),
argBuilder(0, true),
),
// AExp79
appBuilder( // 164
comBuilder(4,3),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 165
argBuilder(0, true),
argBuilder(2, true),
),
// AExp80
appBuilder( // 166
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 167
comBuilder(3,164),
argBuilder(1, true),
),
// AExp81
appBuilder( // 168
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 169
comBuilder(3,166),
argBuilder(1, true),
),
// AExp82
appBuilder( // 170
argBuilder(0, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
ptrBuilder(0, true, true),
),
appBuilder( // 171
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(6, false),
),
// AExp83
appBuilder( // 172
comBuilder(3,190),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 173
comBuilder(1,94),
argBuilder(1, true),
),
// AExp84
appBuilder( // 174
comBuilder(4,3),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 175
comBuilder(1,95),
argBuilder(0, true),
),
// AExp85
appBuilder( // 176
comBuilder(3,106),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 177
comBuilder(1,174),
argBuilder(2, true),
),
// AExp86
appBuilder( // 178
comBuilder(1,162),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 179
comBuilder(3,176),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 180
comBuilder(2,172),
argBuilder(1, true),
argBuilder(3, false),
),
// AExp87
appBuilder( // 181
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 182
comBuilder(2,200),
argBuilder(2, false),
argBuilder(1, true),
),
appBuilder( // 183
comBuilder(2,200),
argBuilder(2, false),
argBuilder(0, true),
),
// AExp88
appBuilder( // 184
prmBuilder("+"),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 185
comBuilder(3,181),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp89
appBuilder( // 186
comBuilder(1,197),
ptrBuilder(0, true, true),
),
appBuilder( // 187
comBuilder(4,184),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp90
appBuilder( // 188
comBuilder(7,170),
comBuilder(4,178),
ptrBuilder(0, true, true),
),
appBuilder( // 189
comBuilder(4,186),
argBuilder(0, true),
),
// AExp91
appBuilder( // 190
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 191
comBuilder(3,127),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp92
appBuilder( // 192
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 193
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp93
appBuilder( // 194
comBuilder(1,197),
ptrBuilder(0, true, true),
comBuilder(3,192),
),
appBuilder( // 195
prmBuilder("-"),
argBuilder(0, true),
intBuilder(10),
),
// AExp94
appBuilder( // 196
argBuilder(1, true),
intBuilder(0),
argBuilder(0, true),
),
// AExp95
appBuilder( // 197
prmBuilder("<="),
argBuilder(0, false),
intBuilder(9),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 198
comBuilder(2,196),
argBuilder(0, false),
),
appBuilder( // 199
comBuilder(1,194),
argBuilder(0, false),
),
// AExp96
appBuilder( // 200
comBuilder(1,202),
ptrBuilder(0, true, true),
),
appBuilder( // 201
comBuilder(1,116),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp97
appBuilder( // 202
argBuilder(0, true),
errorBuilder(4),
comBuilder(1,0),
),
// AExp98
appBuilder( // 203
argBuilder(0, true),
errorBuilder(3),
comBuilder(2,0),
),
// AExp99
appBuilder( // 204
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,1),
),
// AExp100
appBuilder( // 205
comBuilder(2,209),
ptrBuilder(0, true, true),
),
appBuilder( // 206
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp101
appBuilder( // 207
comBuilder(4,3),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 208
comBuilder(1,205),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp102
appBuilder( // 209
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 210
comBuilder(2,207),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp103
appBuilder( // 211
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 212
comBuilder(3,0),
argBuilder(2, true),
),
)
}
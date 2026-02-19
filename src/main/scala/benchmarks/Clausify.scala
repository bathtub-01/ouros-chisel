package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Clausify extends Benchmark {
override def toString() = "Clausify" 
val combinatorCount = 105
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,0),
comBuilder(1,5),
ptrBuilder(18, false, false),
),
appBuilder( // 1
comBuilder(5,147),
intBuilder(0),
),
appBuilder( // 2
comBuilder(5,147),
intBuilder(0),
),
appBuilder( // 3
comBuilder(2,217),
ptrBuilder(2, false, false),
ptrBuilder(1, false, false),
),
appBuilder( // 4
comBuilder(5,147),
intBuilder(0),
),
appBuilder( // 5
comBuilder(2,217),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(1,0),
ptrBuilder(5, false, false),
ptrBuilder(3, false, false),
),
appBuilder( // 7
comBuilder(5,147),
intBuilder(0),
),
appBuilder( // 8
comBuilder(5,147),
intBuilder(0),
),
appBuilder( // 9
comBuilder(2,217),
ptrBuilder(8, false, false),
ptrBuilder(7, false, false),
),
appBuilder( // 10
comBuilder(5,147),
intBuilder(0),
),
appBuilder( // 11
comBuilder(2,217),
ptrBuilder(10, false, false),
),
appBuilder( // 12
comBuilder(1,0),
ptrBuilder(11, false, false),
ptrBuilder(9, false, false),
),
appBuilder( // 13
comBuilder(2,217),
ptrBuilder(12, false, false),
ptrBuilder(6, false, false),
),
appBuilder( // 14
comBuilder(2,211),
intBuilder(2),
ptrBuilder(13, false, false),
),
appBuilder( // 15
comBuilder(5,147),
intBuilder(0),
),
appBuilder( // 16
comBuilder(2,14),
comBuilder(6,101),
ptrBuilder(15, false, false),
),
appBuilder( // 17
comBuilder(1,0),
ptrBuilder(16, false, false),
ptrBuilder(14, false, false),
),
appBuilder( // 18
comBuilder(1,0),
comBuilder(1,24),
ptrBuilder(17, false, false),
),
// AExp1
appBuilder( // 19
comBuilder(1,26),
ptrBuilder(21, false, false),
),
appBuilder( // 20
comBuilder(2,33),
comBuilder(2,65),
),
appBuilder( // 21
comBuilder(3,27),
ptrBuilder(20, false, false),
comBuilder(1,79),
),
// AExp2
appBuilder( // 22
comBuilder(1,49),
comBuilder(1,82),
),
// AExp3
appBuilder( // 23
comBuilder(1,93),
ptrBuilder(24, false, false),
),
appBuilder( // 24
comBuilder(2,117),
comBuilder(1,87),
),
// AExp4
appBuilder( // 25
comBuilder(1,144),
comBuilder(2,0),
),
// AExp5
appBuilder( // 26
comBuilder(2,14),
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
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,5),
argBuilder(1, true),
),
appBuilder( // 4
comBuilder(1,9),
argBuilder(0, true),
),
// AExp3
appBuilder( // 5
argBuilder(0, true),
intBuilder(0),
comBuilder(2,2),
),
// AExp4
appBuilder( // 6
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 7
ptrBuilder(26, false, false),
argBuilder(1, true),
),
appBuilder( // 8
ptrBuilder(26, false, false),
argBuilder(0, true),
),
// AExp5
appBuilder( // 9
argBuilder(0, true),
comBuilder(2,6),
),
// AExp6
appBuilder( // 10
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 11
argBuilder(1, true),
argBuilder(3, true),
),
// AExp7
appBuilder( // 12
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(4,10),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp8
appBuilder( // 14
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 15
comBuilder(4,12),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 16
comBuilder(1,0),
comBuilder(1,154),
ptrBuilder(0, true, true),
),
appBuilder( // 17
comBuilder(1,206),
argBuilder(0, true),
),
// AExp10
appBuilder( // 18
comBuilder(1,0),
ptrBuilder(25, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 19
comBuilder(1,16),
argBuilder(0, true),
),
// AExp11
appBuilder( // 20
comBuilder(1,0),
ptrBuilder(23, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 21
comBuilder(1,18),
argBuilder(0, true),
),
// AExp12
appBuilder( // 22
comBuilder(1,0),
ptrBuilder(22, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 23
comBuilder(1,20),
argBuilder(0, true),
),
// AExp13
appBuilder( // 24
comBuilder(1,0),
ptrBuilder(19, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 25
comBuilder(1,22),
argBuilder(0, true),
),
// AExp14
appBuilder( // 26
comBuilder(2,14),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp15
appBuilder( // 27
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 28
argBuilder(1, true),
argBuilder(2, true),
),
// AExp16
appBuilder( // 29
comBuilder(2,39),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 30
comBuilder(1,49),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp17
appBuilder( // 31
comBuilder(3,27),
comBuilder(1,51),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(1,57),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp18
appBuilder( // 33
comBuilder(3,29),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 34
comBuilder(2,31),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp19
appBuilder( // 35
comBuilder(4,41),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 36
argBuilder(0, true),
argBuilder(2, true),
),
// AExp20
appBuilder( // 37
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 38
comBuilder(3,35),
argBuilder(1, true),
),
// AExp21
appBuilder( // 39
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 40
comBuilder(3,37),
argBuilder(1, true),
),
// AExp22
appBuilder( // 41
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp23
appBuilder( // 42
comBuilder(4,41),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 43
argBuilder(0, true),
argBuilder(2, true),
),
// AExp24
appBuilder( // 44
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 45
comBuilder(3,42),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 46
argBuilder(1, false),
argBuilder(3, false),
),
// AExp25
appBuilder( // 47
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(4,44),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp26
appBuilder( // 49
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(3,47),
argBuilder(0, true),
),
// AExp27
appBuilder( // 51
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp28
appBuilder( // 52
comBuilder(2,59),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 53
argBuilder(1, true),
argBuilder(4, true),
argBuilder(2, false),
),
appBuilder( // 54
argBuilder(0, true),
argBuilder(3, true),
argBuilder(2, false),
),
// AExp29
appBuilder( // 55
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 56
comBuilder(5,52),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp30
appBuilder( // 57
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 58
comBuilder(4,55),
argBuilder(0, true),
),
// AExp31
appBuilder( // 59
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp32
appBuilder( // 60
comBuilder(1,67),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 61
comBuilder(1,77),
prmBuilder("=="),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 62
comBuilder(1,77),
prmBuilder("=="),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp33
appBuilder( // 63
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 64
comBuilder(4,60),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp34
appBuilder( // 65
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 66
comBuilder(3,63),
argBuilder(1, true),
),
// AExp35
appBuilder( // 67
argBuilder(0, true),
comBuilder(2,0),
),
// AExp36
appBuilder( // 68
comBuilder(2,0),
),
// AExp37
appBuilder( // 69
comBuilder(1,67),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 70
argBuilder(1, true),
argBuilder(3, true),
argBuilder(5, true),
),
appBuilder( // 71
argBuilder(0, true),
argBuilder(2, true),
argBuilder(4, true),
),
// AExp38
appBuilder( // 72
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 73
comBuilder(6,69),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp39
appBuilder( // 74
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 75
comBuilder(5,72),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, false),
),
appBuilder( // 76
argBuilder(3, false),
comBuilder(2,1),
comBuilder(2,68),
),
// AExp40
appBuilder( // 77
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 78
comBuilder(4,74),
argBuilder(0, true),
),
// AExp41
appBuilder( // 79
comBuilder(4,41),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp42
appBuilder( // 80
comBuilder(1,84),
ptrBuilder(0, true, true),
),
appBuilder( // 81
comBuilder(2,85),
prmBuilder("=="),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp43
appBuilder( // 82
argBuilder(0, true),
comBuilder(2,80),
),
// AExp44
appBuilder( // 83
comBuilder(2,0),
),
// AExp45
appBuilder( // 84
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,83),
),
// AExp46
appBuilder( // 85
comBuilder(1,49),
ptrBuilder(0, true, true),
),
appBuilder( // 86
comBuilder(1,57),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp47
appBuilder( // 87
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp48
appBuilder( // 88
comBuilder(4,41),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 89
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 90
argBuilder(0, true),
argBuilder(2, true),
),
// AExp49
appBuilder( // 91
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 92
comBuilder(4,88),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp50
appBuilder( // 93
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 94
comBuilder(3,91),
argBuilder(0, true),
),
// AExp51
appBuilder( // 95
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 96
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 97
argBuilder(3, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 98
argBuilder(2, true),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp52
appBuilder( // 99
comBuilder(2,117),
ptrBuilder(0, true, true),
),
appBuilder( // 100
comBuilder(2,117),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp53
appBuilder( // 101
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp54
appBuilder( // 102
comBuilder(2,99),
ptrBuilder(0, true, true),
),
appBuilder( // 103
comBuilder(3,101),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp55
appBuilder( // 104
argBuilder(5, true),
argBuilder(0, false),
argBuilder(0, false),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 105
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp56
appBuilder( // 106
argBuilder(3, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 107
comBuilder(1,129),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp57
appBuilder( // 108
comBuilder(6,104),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(4,106),
),
appBuilder( // 109
comBuilder(2,0),
argBuilder(0, false),
),
appBuilder( // 110
comBuilder(3,0),
argBuilder(0, false),
),
// AExp58
appBuilder( // 111
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 112
comBuilder(1,129),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp59
appBuilder( // 113
comBuilder(7,95),
argBuilder(0, true),
ptrBuilder(1, true, true),
comBuilder(2,102),
ptrBuilder(0, true, true),
comBuilder(4,111),
),
appBuilder( // 114
comBuilder(1,108),
argBuilder(1, false),
),
appBuilder( // 115
comBuilder(3,0),
argBuilder(1, false),
),
// AExp60
appBuilder( // 116
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp61
appBuilder( // 117
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 118
comBuilder(2,113),
argBuilder(1, true),
comBuilder(1,116),
),
// AExp62
appBuilder( // 119
comBuilder(4,41),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 120
argBuilder(0, true),
argBuilder(2, true),
),
// AExp63
appBuilder( // 121
comBuilder(4,41),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 122
comBuilder(4,41),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp64
appBuilder( // 123
prmBuilder("<="),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 124
comBuilder(3,121),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 125
comBuilder(3,119),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp65
appBuilder( // 126
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 127
comBuilder(4,123),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 128
comBuilder(4,41),
argBuilder(0, false),
comBuilder(2,0),
),
// AExp66
appBuilder( // 129
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 130
comBuilder(3,126),
argBuilder(0, true),
),
// AExp67
appBuilder( // 131
comBuilder(1,144),
ptrBuilder(0, true, true),
),
appBuilder( // 132
argBuilder(0, true),
argBuilder(1, true),
),
// AExp68
appBuilder( // 133
comBuilder(4,41),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 134
comBuilder(6,41),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp69
appBuilder( // 135
comBuilder(4,41),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 136
comBuilder(5,146),
argBuilder(1, true),
),
// AExp70
appBuilder( // 137
comBuilder(4,41),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 138
comBuilder(5,147),
argBuilder(1, true),
),
// AExp71
appBuilder( // 139
argBuilder(2, true),
ptrBuilder(3, true, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 140
comBuilder(2,137),
argBuilder(0, false),
),
appBuilder( // 141
comBuilder(2,135),
argBuilder(0, false),
),
appBuilder( // 142
comBuilder(3,133),
argBuilder(0, false),
),
appBuilder( // 143
comBuilder(2,131),
argBuilder(1, true),
),
// AExp72
appBuilder( // 144
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 145
comBuilder(3,139),
argBuilder(0, true),
),
// AExp73
appBuilder( // 146
argBuilder(3, true),
argBuilder(0, true),
),
// AExp74
appBuilder( // 147
argBuilder(4, true),
argBuilder(0, true),
),
// AExp75
appBuilder( // 148
comBuilder(6,101),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 149
comBuilder(1,154),
argBuilder(1, true),
),
appBuilder( // 150
comBuilder(1,154),
argBuilder(0, true),
),
// AExp76
appBuilder( // 151
comBuilder(2,164),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 152
comBuilder(1,154),
argBuilder(1, true),
),
appBuilder( // 153
comBuilder(1,154),
argBuilder(0, true),
),
// AExp77
appBuilder( // 154
argBuilder(0, true),
comBuilder(2,148),
comBuilder(2,151),
comBuilder(5,146),
comBuilder(5,147),
),
// AExp78
appBuilder( // 155
comBuilder(6,101),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 156
comBuilder(2,164),
argBuilder(2, true),
argBuilder(0, false),
),
appBuilder( // 157
comBuilder(2,164),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp79
appBuilder( // 158
comBuilder(2,178),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 159
comBuilder(6,41),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp80
appBuilder( // 160
comBuilder(2,178),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 161
comBuilder(5,146),
argBuilder(1, true),
),
// AExp81
appBuilder( // 162
comBuilder(2,178),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 163
comBuilder(5,147),
argBuilder(1, true),
),
// AExp82
appBuilder( // 164
argBuilder(0, true),
ptrBuilder(3, true, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 165
comBuilder(2,162),
argBuilder(1, false),
),
appBuilder( // 166
comBuilder(2,160),
argBuilder(1, false),
),
appBuilder( // 167
comBuilder(3,158),
argBuilder(1, false),
),
appBuilder( // 168
comBuilder(3,155),
argBuilder(1, false),
),
// AExp83
appBuilder( // 169
comBuilder(6,101),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 170
comBuilder(2,164),
argBuilder(0, false),
argBuilder(2, true),
),
appBuilder( // 171
comBuilder(2,164),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp84
appBuilder( // 172
comBuilder(6,41),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 173
comBuilder(6,41),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp85
appBuilder( // 174
comBuilder(6,41),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 175
comBuilder(5,146),
argBuilder(1, true),
),
// AExp86
appBuilder( // 176
comBuilder(6,41),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 177
comBuilder(5,147),
argBuilder(1, true),
),
// AExp87
appBuilder( // 178
argBuilder(1, true),
ptrBuilder(3, true, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 179
comBuilder(2,176),
argBuilder(0, false),
),
appBuilder( // 180
comBuilder(2,174),
argBuilder(0, false),
),
appBuilder( // 181
comBuilder(3,172),
argBuilder(0, false),
),
appBuilder( // 182
comBuilder(3,169),
argBuilder(0, false),
),
// AExp88
appBuilder( // 183
comBuilder(6,101),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 184
comBuilder(1,206),
argBuilder(1, true),
),
appBuilder( // 185
comBuilder(1,206),
argBuilder(0, true),
),
// AExp89
appBuilder( // 186
comBuilder(6,41),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 187
comBuilder(1,206),
argBuilder(1, true),
),
appBuilder( // 188
comBuilder(1,206),
argBuilder(0, true),
),
// AExp90
appBuilder( // 189
comBuilder(1,206),
ptrBuilder(0, true, true),
),
appBuilder( // 190
comBuilder(5,146),
argBuilder(0, true),
),
// AExp91
appBuilder( // 191
comBuilder(1,206),
ptrBuilder(0, true, true),
),
appBuilder( // 192
comBuilder(5,146),
argBuilder(0, true),
),
// AExp92
appBuilder( // 193
comBuilder(6,41),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 194
comBuilder(1,191),
argBuilder(1, true),
),
appBuilder( // 195
comBuilder(1,189),
argBuilder(0, true),
),
// AExp93
appBuilder( // 196
comBuilder(1,206),
ptrBuilder(0, true, true),
),
appBuilder( // 197
comBuilder(5,146),
argBuilder(0, true),
),
// AExp94
appBuilder( // 198
comBuilder(1,206),
ptrBuilder(0, true, true),
),
appBuilder( // 199
comBuilder(5,146),
argBuilder(0, true),
),
// AExp95
appBuilder( // 200
comBuilder(6,101),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 201
comBuilder(1,198),
argBuilder(1, true),
),
appBuilder( // 202
comBuilder(1,196),
argBuilder(0, true),
),
// AExp96
appBuilder( // 203
comBuilder(5,146),
ptrBuilder(0, true, true),
),
appBuilder( // 204
comBuilder(5,147),
argBuilder(0, true),
),
// AExp97
appBuilder( // 205
argBuilder(0, true),
comBuilder(2,193),
comBuilder(2,200),
comBuilder(1,206),
comBuilder(1,203),
),
// AExp98
appBuilder( // 206
argBuilder(0, true),
comBuilder(2,183),
comBuilder(2,186),
comBuilder(1,205),
comBuilder(5,147),
),
// AExp99
appBuilder( // 207
comBuilder(2,211),
ptrBuilder(0, true, true),
),
appBuilder( // 208
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp100
appBuilder( // 209
comBuilder(4,41),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 210
comBuilder(1,207),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp101
appBuilder( // 211
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 212
comBuilder(2,209),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp102
appBuilder( // 213
comBuilder(6,41),
ptrBuilder(0, true, true),
),
appBuilder( // 214
comBuilder(5,146),
argBuilder(0, true),
),
// AExp103
appBuilder( // 215
comBuilder(6,41),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 216
comBuilder(5,146),
argBuilder(1, true),
),
// AExp104
appBuilder( // 217
comBuilder(6,101),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 218
comBuilder(2,215),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 219
comBuilder(1,213),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
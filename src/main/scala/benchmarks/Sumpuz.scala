package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Sumpuz extends Benchmark {
override def toString() = "Sumpuz" 
val combinatorCount = 120
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
comBuilder(1,133),
ptrBuilder(11, false, false),
),
appBuilder( // 11
comBuilder(3,118),
comBuilder(2,139),
),
// AExp2
appBuilder( // 12
comBuilder(1,116),
comBuilder(1,90),
),
// AExp3
appBuilder( // 13
yBuilder(),
comBuilder(3,39),
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
argBuilder(2, true),
argBuilder(0, true),
),
// AExp7
appBuilder( // 9
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(3,7),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp8
appBuilder( // 11
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(0, true),
),
appBuilder( // 12
comBuilder(5,9),
argBuilder(1, true),
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
comBuilder(4,87),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
comBuilder(1,26),
),
// AExp17
appBuilder( // 29
comBuilder(1,36),
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
comBuilder(1,36),
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
comBuilder(2,0),
),
// AExp20
appBuilder( // 36
argBuilder(0, true),
comBuilder(1,35),
comBuilder(1,0),
),
// AExp21
appBuilder( // 37
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 38
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp22
appBuilder( // 39
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,37),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp23
appBuilder( // 40
comBuilder(2,0),
),
// AExp24
appBuilder( // 41
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,40),
),
// AExp25
appBuilder( // 42
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,41),
),
// AExp26
appBuilder( // 43
comBuilder(2,0),
),
// AExp27
appBuilder( // 44
comBuilder(4,3),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 45
comBuilder(1,90),
argBuilder(0, true),
),
// AExp28
appBuilder( // 46
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(0),
comBuilder(1,43),
comBuilder(1,44),
argBuilder(0, false),
),
appBuilder( // 47
comBuilder(1,89),
argBuilder(0, false),
),
// AExp29
appBuilder( // 48
comBuilder(2,0),
),
// AExp30
appBuilder( // 49
comBuilder(3,102),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(1,90),
argBuilder(1, true),
),
appBuilder( // 51
comBuilder(4,3),
intBuilder(1),
comBuilder(2,0),
),
// AExp31
appBuilder( // 52
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(1),
comBuilder(2,48),
comBuilder(2,49),
argBuilder(1, true),
argBuilder(0, false),
),
appBuilder( // 53
comBuilder(1,89),
argBuilder(0, false),
),
// AExp32
appBuilder( // 54
comBuilder(2,0),
),
// AExp33
appBuilder( // 55
argBuilder(1, true),
comBuilder(2,52),
comBuilder(4,54),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp34
appBuilder( // 56
argBuilder(0, true),
comBuilder(1,46),
comBuilder(3,55),
argBuilder(1, true),
),
// AExp35
appBuilder( // 57
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(5, true),
argBuilder(2, true),
argBuilder(6, true),
argBuilder(3, true),
),
// AExp36
appBuilder( // 58
comBuilder(2,0),
),
// AExp37
appBuilder( // 59
comBuilder(1,0),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 60
argBuilder(1, true),
argBuilder(3, false),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 61
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, false),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp38
appBuilder( // 62
comBuilder(1,175),
ptrBuilder(2, true, true),
argBuilder(4, true),
ptrBuilder(1, true, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 63
argBuilder(0, true),
argBuilder(2, true),
argBuilder(5, false),
argBuilder(6, true),
),
appBuilder( // 64
comBuilder(1,189),
argBuilder(5, false),
),
appBuilder( // 65
comBuilder(1,89),
argBuilder(3, true),
),
// AExp39
appBuilder( // 66
comBuilder(1,150),
ptrBuilder(0, true, true),
),
appBuilder( // 67
comBuilder(7,62),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp40
appBuilder( // 68
comBuilder(4,87),
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 69
comBuilder(1,190),
argBuilder(1, true),
),
// AExp41
appBuilder( // 70
comBuilder(3,102),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 71
comBuilder(2,196),
argBuilder(0, true),
intBuilder(9),
),
appBuilder( // 72
comBuilder(1,189),
argBuilder(1, true),
),
// AExp42
appBuilder( // 73
comBuilder(1,198),
ptrBuilder(0, true, true),
intBuilder(1),
intBuilder(0),
),
appBuilder( // 74
comBuilder(1,190),
argBuilder(0, true),
),
// AExp43
appBuilder( // 75
comBuilder(2,70),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 76
comBuilder(1,73),
argBuilder(0, false),
),
// AExp44
appBuilder( // 77
comBuilder(2,196),
ptrBuilder(0, true, true),
intBuilder(9),
),
appBuilder( // 78
comBuilder(1,198),
argBuilder(0, true),
intBuilder(1),
intBuilder(0),
),
// AExp45
appBuilder( // 79
comBuilder(3,102),
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 80
comBuilder(1,90),
argBuilder(0, true),
),
appBuilder( // 81
comBuilder(1,77),
argBuilder(2, true),
),
// AExp46
appBuilder( // 82
comBuilder(1,150),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 83
comBuilder(3,79),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 84
comBuilder(1,75),
argBuilder(2, true),
),
// AExp47
appBuilder( // 85
comBuilder(7,59),
ptrBuilder(0, true, true),
comBuilder(4,82),
),
appBuilder( // 86
comBuilder(7,66),
comBuilder(3,68),
argBuilder(0, true),
),
// AExp48
appBuilder( // 87
argBuilder(0, true),
comBuilder(3,56),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 88
comBuilder(7,57),
comBuilder(4,58),
comBuilder(1,85),
),
// AExp49
appBuilder( // 89
argBuilder(0, true),
comBuilder(2,0),
),
// AExp50
appBuilder( // 90
argBuilder(0, true),
comBuilder(2,1),
),
// AExp51
appBuilder( // 91
ptrBuilder(10, false, false),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 92
ptrBuilder(12, false, false),
argBuilder(0, true),
),
// AExp52
appBuilder( // 93
comBuilder(1,126),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 94
comBuilder(2,91),
argBuilder(0, true),
argBuilder(2, true),
),
appBuilder( // 95
comBuilder(1,127),
argBuilder(1, true),
),
// AExp53
appBuilder( // 96
comBuilder(1,116),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 97
comBuilder(3,93),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 98
comBuilder(3,118),
comBuilder(4,3),
argBuilder(0, false),
),
// AExp54
appBuilder( // 99
comBuilder(2,0),
),
// AExp55
appBuilder( // 100
comBuilder(4,3),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp56
appBuilder( // 101
comBuilder(2,143),
argBuilder(0, true),
argBuilder(3, true),
comBuilder(1,99),
comBuilder(1,100),
argBuilder(1, true),
),
// AExp57
appBuilder( // 102
comBuilder(2,109),
argBuilder(0, false),
argBuilder(2, false),
comBuilder(3,96),
comBuilder(4,101),
argBuilder(2, false),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp58
appBuilder( // 103
comBuilder(2,0),
),
// AExp59
appBuilder( // 104
comBuilder(2,109),
),
// AExp60
appBuilder( // 105
comBuilder(3,110),
argBuilder(0, true),
),
// AExp61
appBuilder( // 106
prmBuilder("=="),
argBuilder(1, false),
argBuilder(2, true),
comBuilder(1,104),
comBuilder(3,105),
argBuilder(3, true),
argBuilder(1, false),
argBuilder(0, true),
),
// AExp62
appBuilder( // 107
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 108
comBuilder(4,106),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp63
appBuilder( // 109
argBuilder(1, true),
comBuilder(1,103),
comBuilder(3,107),
argBuilder(0, true),
),
// AExp64
appBuilder( // 110
argBuilder(2, true),
argBuilder(0, true),
),
// AExp65
appBuilder( // 111
comBuilder(2,0),
),
// AExp66
appBuilder( // 112
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 113
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 114
argBuilder(2, true),
argBuilder(0, true),
),
// AExp67
appBuilder( // 115
argBuilder(2, true),
comBuilder(2,111),
comBuilder(4,112),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp68
appBuilder( // 116
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 117
comBuilder(3,115),
argBuilder(0, true),
),
// AExp69
appBuilder( // 118
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp70
appBuilder( // 119
comBuilder(2,0),
),
// AExp71
appBuilder( // 120
comBuilder(2,0),
),
// AExp72
appBuilder( // 121
argBuilder(2, true),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp73
appBuilder( // 122
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 123
comBuilder(1,126),
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 124
comBuilder(3,121),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp74
appBuilder( // 125
argBuilder(2, true),
comBuilder(2,120),
comBuilder(4,122),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp75
appBuilder( // 126
argBuilder(0, true),
comBuilder(1,119),
comBuilder(3,125),
),
// AExp76
appBuilder( // 127
comBuilder(4,3),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 128
comBuilder(1,127),
argBuilder(0, false),
),
// AExp77
appBuilder( // 129
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 130
argBuilder(4, true),
argBuilder(3, true),
argBuilder(1, true),
),
// AExp78
appBuilder( // 131
argBuilder(3, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(0, true),
),
appBuilder( // 132
comBuilder(5,129),
argBuilder(1, true),
),
// AExp79
appBuilder( // 133
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 134
comBuilder(4,131),
argBuilder(0, true),
),
// AExp80
appBuilder( // 135
comBuilder(2,0),
),
// AExp81
appBuilder( // 136
comBuilder(4,3),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 137
comBuilder(2,139),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp82
appBuilder( // 138
prmBuilder("=="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,136),
comBuilder(3,0),
argBuilder(1, true),
argBuilder(0, false),
argBuilder(2, false),
),
// AExp83
appBuilder( // 139
argBuilder(1, true),
comBuilder(1,135),
comBuilder(3,138),
argBuilder(0, true),
),
// AExp84
appBuilder( // 140
comBuilder(2,0),
),
// AExp85
appBuilder( // 141
comBuilder(2,1),
),
// AExp86
appBuilder( // 142
prmBuilder("=="),
argBuilder(2, false),
argBuilder(0, true),
comBuilder(2,143),
comBuilder(2,141),
argBuilder(2, false),
argBuilder(1, true),
),
// AExp87
appBuilder( // 143
argBuilder(1, true),
comBuilder(1,140),
comBuilder(3,142),
argBuilder(0, true),
),
// AExp88
appBuilder( // 144
comBuilder(2,0),
),
// AExp89
appBuilder( // 145
comBuilder(2,155),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 146
argBuilder(0, true),
argBuilder(2, true),
),
appBuilder( // 147
argBuilder(3, true),
argBuilder(1, true),
),
// AExp90
appBuilder( // 148
argBuilder(2, true),
comBuilder(1,144),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 149
comBuilder(4,145),
argBuilder(1, true),
),
// AExp91
appBuilder( // 150
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 151
comBuilder(3,148),
argBuilder(0, true),
),
// AExp92
appBuilder( // 152
comBuilder(4,3),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 153
argBuilder(3, true),
argBuilder(1, true),
),
// AExp93
appBuilder( // 154
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,152),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp94
appBuilder( // 155
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 156
comBuilder(3,154),
argBuilder(1, true),
),
// AExp95
appBuilder( // 157
argBuilder(0, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
ptrBuilder(0, true, true),
),
appBuilder( // 158
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(6, false),
),
// AExp96
appBuilder( // 159
comBuilder(3,178),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 160
comBuilder(1,89),
argBuilder(1, true),
),
// AExp97
appBuilder( // 161
comBuilder(4,3),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 162
comBuilder(1,90),
argBuilder(0, true),
),
// AExp98
appBuilder( // 163
comBuilder(3,102),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 164
comBuilder(1,161),
argBuilder(2, true),
),
// AExp99
appBuilder( // 165
comBuilder(1,150),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 166
comBuilder(3,163),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 167
comBuilder(2,159),
argBuilder(1, true),
argBuilder(3, false),
),
// AExp100
appBuilder( // 168
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 169
comBuilder(2,186),
argBuilder(2, false),
argBuilder(1, true),
),
appBuilder( // 170
comBuilder(2,186),
argBuilder(2, false),
argBuilder(0, true),
),
// AExp101
appBuilder( // 171
prmBuilder("+"),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 172
comBuilder(3,168),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp102
appBuilder( // 173
comBuilder(1,185),
ptrBuilder(0, true, true),
),
appBuilder( // 174
comBuilder(4,171),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp103
appBuilder( // 175
comBuilder(7,157),
comBuilder(4,165),
ptrBuilder(0, true, true),
),
appBuilder( // 176
comBuilder(4,173),
argBuilder(0, true),
),
// AExp104
appBuilder( // 177
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp105
appBuilder( // 178
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 179
comBuilder(3,177),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp106
appBuilder( // 180
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 181
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp107
appBuilder( // 182
comBuilder(1,185),
ptrBuilder(0, true, true),
comBuilder(3,180),
),
appBuilder( // 183
prmBuilder("-"),
argBuilder(0, true),
intBuilder(10),
),
// AExp108
appBuilder( // 184
argBuilder(1, true),
intBuilder(0),
argBuilder(0, true),
),
// AExp109
appBuilder( // 185
prmBuilder("<="),
argBuilder(0, false),
intBuilder(9),
comBuilder(1,182),
comBuilder(2,184),
argBuilder(0, false),
),
// AExp110
appBuilder( // 186
comBuilder(1,188),
ptrBuilder(0, true, true),
),
appBuilder( // 187
comBuilder(2,109),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp111
appBuilder( // 188
argBuilder(0, true),
errorBuilder(4),
comBuilder(1,0),
),
// AExp112
appBuilder( // 189
argBuilder(0, true),
errorBuilder(3),
comBuilder(2,0),
),
// AExp113
appBuilder( // 190
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,1),
),
// AExp114
appBuilder( // 191
comBuilder(2,0),
),
// AExp115
appBuilder( // 192
comBuilder(2,196),
ptrBuilder(0, true, true),
),
appBuilder( // 193
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp116
appBuilder( // 194
comBuilder(4,3),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 195
comBuilder(1,192),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp117
appBuilder( // 196
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,191),
comBuilder(2,194),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp118
appBuilder( // 197
argBuilder(3, true),
),
// AExp119
appBuilder( // 198
argBuilder(0, true),
comBuilder(2,0),
comBuilder(4,197),
),
)
}
package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Clausify extends Benchmark {
override def toString() = "Clausify" 
val combinatorCount = 112
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,0),
comBuilder(1,5),
ptrBuilder(18, false, false),
),
appBuilder( // 1
comBuilder(5,132),
intBuilder(0),
),
appBuilder( // 2
comBuilder(5,132),
intBuilder(0),
),
appBuilder( // 3
comBuilder(2,195),
ptrBuilder(2, false, false),
ptrBuilder(1, false, false),
),
appBuilder( // 4
comBuilder(5,132),
intBuilder(0),
),
appBuilder( // 5
comBuilder(2,195),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(1,0),
ptrBuilder(5, false, false),
ptrBuilder(3, false, false),
),
appBuilder( // 7
comBuilder(5,132),
intBuilder(0),
),
appBuilder( // 8
comBuilder(5,132),
intBuilder(0),
),
appBuilder( // 9
comBuilder(2,195),
ptrBuilder(8, false, false),
ptrBuilder(7, false, false),
),
appBuilder( // 10
comBuilder(5,132),
intBuilder(0),
),
appBuilder( // 11
comBuilder(2,195),
ptrBuilder(10, false, false),
),
appBuilder( // 12
comBuilder(1,0),
ptrBuilder(11, false, false),
ptrBuilder(9, false, false),
),
appBuilder( // 13
comBuilder(2,195),
ptrBuilder(12, false, false),
ptrBuilder(6, false, false),
),
appBuilder( // 14
comBuilder(2,189),
intBuilder(2),
ptrBuilder(13, false, false),
),
appBuilder( // 15
comBuilder(5,132),
intBuilder(0),
),
appBuilder( // 16
comBuilder(2,13),
comBuilder(6,99),
ptrBuilder(15, false, false),
),
appBuilder( // 17
comBuilder(1,0),
ptrBuilder(16, false, false),
ptrBuilder(14, false, false),
),
appBuilder( // 18
comBuilder(1,0),
comBuilder(1,23),
ptrBuilder(17, false, false),
),
// AExp1
appBuilder( // 19
comBuilder(1,25),
ptrBuilder(21, false, false),
),
appBuilder( // 20
comBuilder(2,32),
comBuilder(2,66),
),
appBuilder( // 21
comBuilder(3,26),
ptrBuilder(20, false, false),
comBuilder(1,82),
),
// AExp2
appBuilder( // 22
comBuilder(1,48),
comBuilder(1,85),
),
// AExp3
appBuilder( // 23
comBuilder(1,96),
ptrBuilder(24, false, false),
),
appBuilder( // 24
comBuilder(2,110),
comBuilder(1,90),
),
// AExp4
appBuilder( // 25
comBuilder(1,129),
comBuilder(2,0),
),
// AExp5
appBuilder( // 26
comBuilder(2,13),
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
argBuilder(3, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 11
argBuilder(4, true),
argBuilder(1, true),
),
// AExp7
appBuilder( // 12
argBuilder(3, true),
comBuilder(3,0),
comBuilder(5,10),
argBuilder(1, true),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp8
appBuilder( // 13
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(4,12),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 15
comBuilder(1,0),
comBuilder(1,139),
ptrBuilder(0, true, true),
),
appBuilder( // 16
comBuilder(1,183),
argBuilder(0, true),
),
// AExp10
appBuilder( // 17
comBuilder(1,0),
ptrBuilder(25, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 18
comBuilder(1,15),
argBuilder(0, true),
),
// AExp11
appBuilder( // 19
comBuilder(1,0),
ptrBuilder(23, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 20
comBuilder(1,17),
argBuilder(0, true),
),
// AExp12
appBuilder( // 21
comBuilder(1,0),
ptrBuilder(22, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 22
comBuilder(1,19),
argBuilder(0, true),
),
// AExp13
appBuilder( // 23
comBuilder(1,0),
ptrBuilder(19, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 24
comBuilder(1,21),
argBuilder(0, true),
),
// AExp14
appBuilder( // 25
comBuilder(2,13),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp15
appBuilder( // 26
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 27
argBuilder(1, true),
argBuilder(2, true),
),
// AExp16
appBuilder( // 28
comBuilder(2,37),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(1,48),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp17
appBuilder( // 30
comBuilder(3,26),
comBuilder(1,50),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(1,57),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp18
appBuilder( // 32
comBuilder(3,28),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 33
comBuilder(2,30),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp19
appBuilder( // 34
comBuilder(4,39),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 35
argBuilder(3, true),
argBuilder(1, true),
),
// AExp20
appBuilder( // 36
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,34),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp21
appBuilder( // 37
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 38
comBuilder(3,36),
argBuilder(1, true),
),
// AExp22
appBuilder( // 39
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp23
appBuilder( // 40
comBuilder(2,0),
),
// AExp24
appBuilder( // 41
argBuilder(3, true),
),
// AExp25
appBuilder( // 42
comBuilder(4,39),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 43
comBuilder(1,48),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp26
appBuilder( // 44
argBuilder(3, false),
argBuilder(1, false),
comBuilder(4,41),
comBuilder(4,42),
argBuilder(1, false),
argBuilder(3, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 45
argBuilder(0, true),
argBuilder(2, false),
),
// AExp27
appBuilder( // 46
argBuilder(2, true),
comBuilder(1,40),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 47
comBuilder(4,44),
argBuilder(1, true),
),
// AExp28
appBuilder( // 48
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 49
comBuilder(3,46),
argBuilder(0, true),
),
// AExp29
appBuilder( // 50
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp30
appBuilder( // 51
comBuilder(2,0),
),
// AExp31
appBuilder( // 52
comBuilder(1,60),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 53
argBuilder(0, true),
argBuilder(2, true),
argBuilder(4, false),
),
appBuilder( // 54
argBuilder(3, true),
argBuilder(1, true),
argBuilder(4, false),
),
// AExp32
appBuilder( // 55
argBuilder(2, true),
comBuilder(2,51),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 56
comBuilder(5,52),
argBuilder(1, true),
),
// AExp33
appBuilder( // 57
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 58
comBuilder(3,55),
argBuilder(0, true),
),
// AExp34
appBuilder( // 59
comBuilder(2,1),
),
// AExp35
appBuilder( // 60
argBuilder(0, true),
comBuilder(1,0),
comBuilder(1,59),
),
// AExp36
appBuilder( // 61
comBuilder(1,69),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 62
comBuilder(1,80),
prmBuilder("=="),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 63
comBuilder(1,80),
prmBuilder("=="),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp37
appBuilder( // 64
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 65
comBuilder(4,61),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp38
appBuilder( // 66
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 67
comBuilder(3,64),
argBuilder(1, true),
),
// AExp39
appBuilder( // 68
comBuilder(2,0),
),
// AExp40
appBuilder( // 69
argBuilder(0, true),
comBuilder(1,68),
comBuilder(1,0),
),
// AExp41
appBuilder( // 70
comBuilder(2,0),
),
// AExp42
appBuilder( // 71
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,70),
),
// AExp43
appBuilder( // 72
comBuilder(2,0),
),
// AExp44
appBuilder( // 73
comBuilder(1,69),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 74
argBuilder(0, true),
argBuilder(5, true),
argBuilder(2, true),
),
appBuilder( // 75
argBuilder(3, true),
argBuilder(4, true),
argBuilder(1, true),
),
// AExp45
appBuilder( // 76
argBuilder(3, true),
comBuilder(3,72),
ptrBuilder(0, true, true),
argBuilder(4, true),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 77
comBuilder(6,73),
argBuilder(0, true),
),
// AExp46
appBuilder( // 78
argBuilder(2, true),
comBuilder(2,71),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(0, true),
),
appBuilder( // 79
comBuilder(5,76),
argBuilder(1, true),
),
// AExp47
appBuilder( // 80
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 81
comBuilder(4,78),
argBuilder(0, true),
),
// AExp48
appBuilder( // 82
comBuilder(4,39),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp49
appBuilder( // 83
comBuilder(1,87),
ptrBuilder(0, true, true),
),
appBuilder( // 84
comBuilder(2,88),
prmBuilder("=="),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp50
appBuilder( // 85
argBuilder(0, true),
comBuilder(2,83),
),
// AExp51
appBuilder( // 86
comBuilder(2,0),
),
// AExp52
appBuilder( // 87
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,86),
),
// AExp53
appBuilder( // 88
comBuilder(1,48),
ptrBuilder(0, true, true),
),
appBuilder( // 89
comBuilder(1,57),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp54
appBuilder( // 90
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp55
appBuilder( // 91
comBuilder(2,0),
),
// AExp56
appBuilder( // 92
comBuilder(4,39),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 93
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 94
argBuilder(2, true),
argBuilder(0, true),
),
// AExp57
appBuilder( // 95
argBuilder(2, true),
comBuilder(2,91),
comBuilder(4,92),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp58
appBuilder( // 96
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 97
comBuilder(3,95),
argBuilder(0, true),
),
// AExp59
appBuilder( // 98
argBuilder(2, true),
),
// AExp60
appBuilder( // 99
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp61
appBuilder( // 100
comBuilder(2,110),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 101
comBuilder(3,99),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp62
appBuilder( // 102
comBuilder(2,110),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 103
comBuilder(3,100),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp63
appBuilder( // 104
argBuilder(4, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 105
comBuilder(2,118),
argBuilder(0, true),
argBuilder(3, true),
),
// AExp64
appBuilder( // 106
argBuilder(0, true),
comBuilder(5,98),
comBuilder(5,98),
comBuilder(4,1),
comBuilder(5,104),
),
// AExp65
appBuilder( // 107
argBuilder(4, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 108
comBuilder(2,118),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp66
appBuilder( // 109
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp67
appBuilder( // 110
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 111
argBuilder(1, true),
comBuilder(5,98),
comBuilder(5,102),
comBuilder(1,106),
comBuilder(5,107),
comBuilder(1,109),
),
// AExp68
appBuilder( // 112
comBuilder(4,39),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp69
appBuilder( // 113
comBuilder(4,39),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 114
comBuilder(2,118),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp70
appBuilder( // 115
comBuilder(4,39),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 116
comBuilder(4,39),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp71
appBuilder( // 117
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,113),
comBuilder(3,115),
argBuilder(2, false),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp72
appBuilder( // 118
argBuilder(1, true),
comBuilder(1,112),
comBuilder(3,117),
argBuilder(0, true),
),
// AExp73
appBuilder( // 119
argBuilder(6, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 120
argBuilder(0, true),
argBuilder(5, true),
),
// AExp74
appBuilder( // 121
comBuilder(1,129),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 122
argBuilder(0, true),
argBuilder(1, true),
),
// AExp75
appBuilder( // 123
comBuilder(4,39),
ptrBuilder(0, true, true),
),
appBuilder( // 124
comBuilder(6,39),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp76
appBuilder( // 125
comBuilder(4,39),
ptrBuilder(0, true, true),
),
appBuilder( // 126
comBuilder(5,131),
argBuilder(0, true),
),
// AExp77
appBuilder( // 127
comBuilder(4,39),
ptrBuilder(0, true, true),
),
appBuilder( // 128
comBuilder(5,132),
argBuilder(0, true),
),
// AExp78
appBuilder( // 129
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 130
comBuilder(7,119),
comBuilder(4,121),
comBuilder(2,123),
comBuilder(1,125),
comBuilder(1,127),
argBuilder(0, true),
),
// AExp79
appBuilder( // 131
argBuilder(3, true),
argBuilder(0, true),
),
// AExp80
appBuilder( // 132
argBuilder(4, true),
argBuilder(0, true),
),
// AExp81
appBuilder( // 133
comBuilder(6,99),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 134
comBuilder(1,139),
argBuilder(1, true),
),
appBuilder( // 135
comBuilder(1,139),
argBuilder(0, true),
),
// AExp82
appBuilder( // 136
comBuilder(1,149),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 137
comBuilder(1,139),
argBuilder(1, true),
),
appBuilder( // 138
comBuilder(1,139),
argBuilder(0, true),
),
// AExp83
appBuilder( // 139
argBuilder(0, true),
comBuilder(2,133),
comBuilder(2,136),
comBuilder(5,131),
comBuilder(5,132),
),
// AExp84
appBuilder( // 140
comBuilder(6,99),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 141
comBuilder(1,149),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 142
comBuilder(1,149),
argBuilder(0, true),
argBuilder(2, false),
),
// AExp85
appBuilder( // 143
comBuilder(2,159),
ptrBuilder(0, true, true),
),
appBuilder( // 144
comBuilder(6,39),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp86
appBuilder( // 145
comBuilder(2,159),
ptrBuilder(0, true, true),
),
appBuilder( // 146
comBuilder(5,131),
argBuilder(0, true),
),
// AExp87
appBuilder( // 147
comBuilder(2,159),
ptrBuilder(0, true, true),
),
appBuilder( // 148
comBuilder(5,132),
argBuilder(0, true),
),
// AExp88
appBuilder( // 149
argBuilder(0, true),
comBuilder(3,140),
comBuilder(2,143),
comBuilder(1,145),
comBuilder(1,147),
),
// AExp89
appBuilder( // 150
comBuilder(6,99),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 151
comBuilder(1,149),
argBuilder(2, false),
argBuilder(1, true),
),
appBuilder( // 152
comBuilder(1,149),
argBuilder(2, false),
argBuilder(0, true),
),
// AExp90
appBuilder( // 153
comBuilder(6,39),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 154
comBuilder(6,39),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp91
appBuilder( // 155
comBuilder(6,39),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 156
comBuilder(5,131),
argBuilder(0, true),
),
// AExp92
appBuilder( // 157
comBuilder(6,39),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 158
comBuilder(5,132),
argBuilder(0, true),
),
// AExp93
appBuilder( // 159
argBuilder(1, true),
comBuilder(3,150),
comBuilder(3,153),
comBuilder(2,155),
comBuilder(2,157),
argBuilder(0, true),
),
// AExp94
appBuilder( // 160
comBuilder(6,99),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 161
comBuilder(1,183),
argBuilder(1, true),
),
appBuilder( // 162
comBuilder(1,183),
argBuilder(0, true),
),
// AExp95
appBuilder( // 163
comBuilder(6,39),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 164
comBuilder(1,183),
argBuilder(1, true),
),
appBuilder( // 165
comBuilder(1,183),
argBuilder(0, true),
),
// AExp96
appBuilder( // 166
comBuilder(1,183),
ptrBuilder(0, true, true),
),
appBuilder( // 167
comBuilder(5,131),
argBuilder(0, true),
),
// AExp97
appBuilder( // 168
comBuilder(1,183),
ptrBuilder(0, true, true),
),
appBuilder( // 169
comBuilder(5,131),
argBuilder(0, true),
),
// AExp98
appBuilder( // 170
comBuilder(6,39),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 171
comBuilder(1,168),
argBuilder(1, true),
),
appBuilder( // 172
comBuilder(1,166),
argBuilder(0, true),
),
// AExp99
appBuilder( // 173
comBuilder(1,183),
ptrBuilder(0, true, true),
),
appBuilder( // 174
comBuilder(5,131),
argBuilder(0, true),
),
// AExp100
appBuilder( // 175
comBuilder(1,183),
ptrBuilder(0, true, true),
),
appBuilder( // 176
comBuilder(5,131),
argBuilder(0, true),
),
// AExp101
appBuilder( // 177
comBuilder(6,99),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 178
comBuilder(1,175),
argBuilder(1, true),
),
appBuilder( // 179
comBuilder(1,173),
argBuilder(0, true),
),
// AExp102
appBuilder( // 180
comBuilder(5,131),
ptrBuilder(0, true, true),
),
appBuilder( // 181
comBuilder(5,132),
argBuilder(0, true),
),
// AExp103
appBuilder( // 182
argBuilder(0, true),
comBuilder(2,170),
comBuilder(2,177),
comBuilder(1,183),
comBuilder(1,180),
),
// AExp104
appBuilder( // 183
argBuilder(0, true),
comBuilder(2,160),
comBuilder(2,163),
comBuilder(1,182),
comBuilder(5,132),
),
// AExp105
appBuilder( // 184
comBuilder(2,0),
),
// AExp106
appBuilder( // 185
comBuilder(2,189),
ptrBuilder(0, true, true),
),
appBuilder( // 186
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp107
appBuilder( // 187
comBuilder(4,39),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 188
comBuilder(1,185),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp108
appBuilder( // 189
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,0),
comBuilder(1,184),
ptrBuilder(0, true, true),
),
appBuilder( // 190
comBuilder(2,187),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp109
appBuilder( // 191
comBuilder(6,39),
ptrBuilder(0, true, true),
),
appBuilder( // 192
comBuilder(5,131),
argBuilder(0, true),
),
// AExp110
appBuilder( // 193
comBuilder(6,39),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 194
comBuilder(5,131),
argBuilder(1, true),
),
// AExp111
appBuilder( // 195
comBuilder(6,99),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 196
comBuilder(2,193),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 197
comBuilder(1,191),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
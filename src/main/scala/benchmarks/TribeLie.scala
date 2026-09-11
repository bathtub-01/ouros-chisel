package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object TribeLie extends Benchmark {
override def toString() = "TribeLie" 
val combinatorCount = 83
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,5),
comBuilder(1,27),
ptrBuilder(1, false, false),
),
// AExp1
appBuilder( // 1
yBuilder(),
ptrBuilder(29, false, false),
ptrBuilder(3, false, false),
),
appBuilder( // 2
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 3
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 5
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 7
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(6, false, false),
),
appBuilder( // 8
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 9
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(8, false, false),
),
appBuilder( // 10
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 11
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(10, false, false),
),
appBuilder( // 12
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 13
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(12, false, false),
),
appBuilder( // 14
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 15
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(14, false, false),
),
appBuilder( // 16
comBuilder(4,19),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 17
comBuilder(4,19),
comBuilder(2,0),
ptrBuilder(16, false, false),
),
appBuilder( // 18
comBuilder(3,125),
ptrBuilder(17, false, false),
),
appBuilder( // 19
comBuilder(2,106),
ptrBuilder(18, false, false),
ptrBuilder(15, false, false),
),
appBuilder( // 20
comBuilder(4,84),
ptrBuilder(19, false, false),
),
appBuilder( // 21
comBuilder(5,77),
ptrBuilder(20, false, false),
ptrBuilder(13, false, false),
),
appBuilder( // 22
comBuilder(4,71),
ptrBuilder(21, false, false),
),
appBuilder( // 23
comBuilder(5,68),
ptrBuilder(22, false, false),
ptrBuilder(11, false, false),
),
appBuilder( // 24
comBuilder(3,64),
ptrBuilder(23, false, false),
),
appBuilder( // 25
comBuilder(4,59),
ptrBuilder(24, false, false),
ptrBuilder(9, false, false),
),
appBuilder( // 26
comBuilder(1,55),
ptrBuilder(25, false, false),
),
appBuilder( // 27
comBuilder(3,49),
ptrBuilder(26, false, false),
ptrBuilder(7, false, false),
),
appBuilder( // 28
comBuilder(5,45),
ptrBuilder(27, false, false),
ptrBuilder(5, false, false),
),
appBuilder( // 29
comBuilder(3,42),
ptrBuilder(28, false, false),
),
// AExp2
appBuilder( // 30
comBuilder(2,10),
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
comBuilder(1,0),
ptrBuilder(30, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,17),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp3
appBuilder( // 4
argBuilder(0, true),
argBuilder(1, true),
intBuilder(0),
intBuilder(1),
),
// AExp4
appBuilder( // 5
comBuilder(2,2),
ptrBuilder(0, true, true),
),
appBuilder( // 6
comBuilder(2,4),
argBuilder(0, true),
),
// AExp5
appBuilder( // 7
argBuilder(3, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 8
argBuilder(4, true),
argBuilder(1, true),
),
// AExp6
appBuilder( // 9
argBuilder(3, true),
comBuilder(3,0),
comBuilder(5,7),
argBuilder(1, true),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp7
appBuilder( // 10
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 11
comBuilder(4,9),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 12
comBuilder(2,0),
),
// AExp9
appBuilder( // 13
comBuilder(4,19),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 14
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 15
argBuilder(2, true),
argBuilder(0, true),
),
// AExp10
appBuilder( // 16
argBuilder(2, true),
comBuilder(2,12),
comBuilder(4,13),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 17
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 18
comBuilder(3,16),
argBuilder(0, true),
),
// AExp12
appBuilder( // 19
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp13
appBuilder( // 20
comBuilder(1,29),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 21
comBuilder(1,32),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp14
appBuilder( // 22
comBuilder(1,29),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 23
comBuilder(1,40),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 24
comBuilder(1,35),
argBuilder(0, true),
argBuilder(3, false),
),
// AExp15
appBuilder( // 25
comBuilder(7,20),
argBuilder(2, false),
ptrBuilder(0, true, true),
argBuilder(3, false),
),
appBuilder( // 26
comBuilder(4,22),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp16
appBuilder( // 27
argBuilder(0, true),
comBuilder(4,25),
),
// AExp17
appBuilder( // 28
comBuilder(2,0),
),
// AExp18
appBuilder( // 29
argBuilder(0, true),
comBuilder(1,28),
comBuilder(1,0),
),
// AExp19
appBuilder( // 30
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp20
appBuilder( // 31
comBuilder(2,1),
),
// AExp21
appBuilder( // 32
argBuilder(0, true),
comBuilder(1,30),
comBuilder(1,31),
),
// AExp22
appBuilder( // 33
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp23
appBuilder( // 34
comBuilder(2,1),
),
// AExp24
appBuilder( // 35
argBuilder(0, true),
comBuilder(1,33),
comBuilder(1,34),
),
// AExp25
appBuilder( // 36
comBuilder(2,0),
),
// AExp26
appBuilder( // 37
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp27
appBuilder( // 38
argBuilder(0, true),
comBuilder(1,36),
comBuilder(1,37),
),
// AExp28
appBuilder( // 39
argBuilder(1, true),
comBuilder(2,0),
comBuilder(2,1),
),
// AExp29
appBuilder( // 40
argBuilder(0, true),
comBuilder(1,38),
comBuilder(2,39),
),
// AExp30
appBuilder( // 41
comBuilder(2,0),
),
// AExp31
appBuilder( // 42
argBuilder(2, true),
comBuilder(1,41),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp32
appBuilder( // 43
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(4, true),
argBuilder(2, true),
argBuilder(5, true),
argBuilder(3, true),
),
// AExp33
appBuilder( // 44
argBuilder(0, true),
argBuilder(1, true),
),
// AExp34
appBuilder( // 45
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 46
comBuilder(7,43),
comBuilder(4,44),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(2, true),
argBuilder(4, true),
),
// AExp35
appBuilder( // 47
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 48
argBuilder(0, true),
argBuilder(2, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp36
appBuilder( // 49
comBuilder(7,47),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 50
argBuilder(0, true),
argBuilder(2, true),
),
// AExp37
appBuilder( // 51
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 52
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp38
appBuilder( // 53
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp39
appBuilder( // 54
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(2, true),
argBuilder(5, true),
argBuilder(4, true),
),
// AExp40
appBuilder( // 55
comBuilder(7,51),
comBuilder(3,53),
ptrBuilder(0, true, true),
),
appBuilder( // 56
comBuilder(7,54),
comBuilder(5,44),
argBuilder(0, true),
),
// AExp41
appBuilder( // 57
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 58
argBuilder(0, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp42
appBuilder( // 59
comBuilder(7,57),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 60
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp43
appBuilder( // 61
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
argBuilder(2, true),
),
appBuilder( // 62
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp44
appBuilder( // 63
argBuilder(0, true),
argBuilder(3, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp45
appBuilder( // 64
comBuilder(7,61),
comBuilder(4,63),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 65
comBuilder(7,54),
comBuilder(6,44),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp46
appBuilder( // 66
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 67
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp47
appBuilder( // 68
comBuilder(7,66),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 69
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp48
appBuilder( // 70
argBuilder(6, true),
comBuilder(7,44),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
argBuilder(5, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp49
appBuilder( // 71
comBuilder(7,61),
comBuilder(4,63),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 72
comBuilder(7,70),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp50
appBuilder( // 73
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 74
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp51
appBuilder( // 75
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 76
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp52
appBuilder( // 77
comBuilder(7,73),
comBuilder(4,75),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 78
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp53
appBuilder( // 79
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(6, true),
argBuilder(3, true),
),
appBuilder( // 80
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp54
appBuilder( // 81
argBuilder(0, true),
argBuilder(4, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp55
appBuilder( // 82
comBuilder(5,81),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(2, true),
),
appBuilder( // 83
argBuilder(0, true),
argBuilder(4, true),
),
// AExp56
appBuilder( // 84
comBuilder(7,79),
comBuilder(5,82),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(1, true),
),
appBuilder( // 85
argBuilder(0, true),
argBuilder(3, true),
),
// AExp57
appBuilder( // 86
argBuilder(0, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(5, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp58
appBuilder( // 87
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 88
argBuilder(1, true),
argBuilder(6, true),
),
// AExp59
appBuilder( // 89
argBuilder(0, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp60
appBuilder( // 90
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(5, true),
argBuilder(4, true),
),
// AExp61
appBuilder( // 91
comBuilder(7,89),
ptrBuilder(0, true, true),
argBuilder(5, true),
),
appBuilder( // 92
comBuilder(7,90),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp62
appBuilder( // 93
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 94
comBuilder(7,91),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(3, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp63
appBuilder( // 95
comBuilder(7,87),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
argBuilder(4, true),
),
appBuilder( // 96
comBuilder(7,93),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(6, true),
),
// AExp64
appBuilder( // 97
argBuilder(6, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 98
comBuilder(7,95),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp65
appBuilder( // 99
comBuilder(7,44),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp66
appBuilder( // 100
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 101
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
argBuilder(6, true),
),
// AExp67
appBuilder( // 102
comBuilder(7,100),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 103
argBuilder(0, true),
argBuilder(3, true),
),
// AExp68
appBuilder( // 104
argBuilder(0, true),
argBuilder(5, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(3, true),
),
// AExp69
appBuilder( // 105
comBuilder(7,44),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp70
appBuilder( // 106
comBuilder(7,86),
ptrBuilder(0, true, true),
),
appBuilder( // 107
comBuilder(7,97),
comBuilder(3,99),
comBuilder(4,102),
comBuilder(6,104),
comBuilder(4,105),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp71
appBuilder( // 108
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 109
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp72
appBuilder( // 110
comBuilder(7,108),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 111
argBuilder(1, true),
argBuilder(6, true),
),
// AExp73
appBuilder( // 112
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(2, true),
argBuilder(6, true),
argBuilder(5, true),
),
// AExp74
appBuilder( // 113
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 114
comBuilder(7,112),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp75
appBuilder( // 115
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp76
appBuilder( // 116
comBuilder(7,44),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp77
appBuilder( // 117
comBuilder(7,108),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 118
comBuilder(6,127),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp78
appBuilder( // 119
comBuilder(4,19),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 120
argBuilder(3, true),
argBuilder(2, true),
),
appBuilder( // 121
argBuilder(0, true),
argBuilder(1, true),
),
// AExp79
appBuilder( // 122
comBuilder(7,117),
comBuilder(4,119),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp80
appBuilder( // 123
comBuilder(7,89),
ptrBuilder(0, true, true),
),
appBuilder( // 124
comBuilder(7,115),
comBuilder(5,116),
comBuilder(4,122),
argBuilder(1, true),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp81
appBuilder( // 125
comBuilder(7,110),
comBuilder(6,113),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(0, true),
),
appBuilder( // 126
comBuilder(4,123),
argBuilder(2, true),
),
// AExp82
appBuilder( // 127
comBuilder(4,63),
ptrBuilder(0, true, true),
),
appBuilder( // 128
comBuilder(7,115),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
)
}
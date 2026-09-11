package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Whilex extends Benchmark {
override def toString() = "Whilex" 
val combinatorCount = 81
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,18),
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
comBuilder(5,44),
intBuilder(1),
),
appBuilder( // 8
comBuilder(5,116),
intBuilder(4),
),
appBuilder( // 9
comBuilder(6,119),
ptrBuilder(8, false, false),
ptrBuilder(7, false, false),
),
appBuilder( // 10
comBuilder(7,75),
intBuilder(4),
ptrBuilder(9, false, false),
),
appBuilder( // 11
comBuilder(5,44),
intBuilder(1),
),
appBuilder( // 12
comBuilder(5,116),
intBuilder(5),
),
appBuilder( // 13
comBuilder(6,75),
ptrBuilder(12, false, false),
ptrBuilder(11, false, false),
),
appBuilder( // 14
comBuilder(7,75),
intBuilder(5),
ptrBuilder(13, false, false),
),
appBuilder( // 15
comBuilder(5,44),
intBuilder(0),
),
appBuilder( // 16
comBuilder(5,116),
intBuilder(0),
),
appBuilder( // 17
comBuilder(3,118),
ptrBuilder(16, false, false),
ptrBuilder(15, false, false),
),
appBuilder( // 18
comBuilder(4,113),
ptrBuilder(17, false, false),
ptrBuilder(14, false, false),
comBuilder(5,114),
),
appBuilder( // 19
comBuilder(5,44),
intBuilder(1),
),
appBuilder( // 20
comBuilder(5,116),
intBuilder(2),
),
appBuilder( // 21
comBuilder(6,75),
ptrBuilder(20, false, false),
ptrBuilder(19, false, false),
),
appBuilder( // 22
comBuilder(7,75),
intBuilder(2),
ptrBuilder(21, false, false),
),
appBuilder( // 23
comBuilder(5,116),
intBuilder(1),
),
appBuilder( // 24
comBuilder(5,116),
intBuilder(0),
),
appBuilder( // 25
comBuilder(6,119),
ptrBuilder(24, false, false),
ptrBuilder(23, false, false),
),
appBuilder( // 26
comBuilder(7,75),
intBuilder(0),
ptrBuilder(25, false, false),
),
appBuilder( // 27
comBuilder(7,2),
ptrBuilder(26, false, false),
ptrBuilder(22, false, false),
),
appBuilder( // 28
comBuilder(5,116),
intBuilder(0),
),
appBuilder( // 29
comBuilder(5,116),
intBuilder(1),
),
appBuilder( // 30
comBuilder(3,120),
ptrBuilder(29, false, false),
ptrBuilder(28, false, false),
),
appBuilder( // 31
comBuilder(7,115),
ptrBuilder(30, false, false),
),
appBuilder( // 32
comBuilder(1,0),
ptrBuilder(31, false, false),
ptrBuilder(27, false, false),
),
appBuilder( // 33
comBuilder(5,116),
intBuilder(4),
),
appBuilder( // 34
comBuilder(7,75),
intBuilder(1),
ptrBuilder(33, false, false),
),
appBuilder( // 35
comBuilder(5,116),
intBuilder(3),
),
appBuilder( // 36
comBuilder(7,75),
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
comBuilder(5,44),
intBuilder(0),
),
appBuilder( // 43
comBuilder(5,116),
intBuilder(4),
),
appBuilder( // 44
comBuilder(3,118),
ptrBuilder(43, false, false),
ptrBuilder(42, false, false),
),
appBuilder( // 45
comBuilder(7,117),
ptrBuilder(44, false, false),
),
appBuilder( // 46
comBuilder(7,115),
ptrBuilder(45, false, false),
),
appBuilder( // 47
comBuilder(1,0),
ptrBuilder(46, false, false),
ptrBuilder(41, false, false),
),
appBuilder( // 48
comBuilder(5,116),
intBuilder(3),
),
appBuilder( // 49
comBuilder(7,75),
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
comBuilder(2,19),
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
errorBuilder(42),
),
// AExp10
appBuilder( // 10
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 11
prmBuilder("=="),
argBuilder(5, true),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(4, true),
argBuilder(6, true),
argBuilder(2, true),
),
// AExp12
appBuilder( // 12
comBuilder(1,18),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(0, true),
),
// AExp13
appBuilder( // 13
argBuilder(0, true),
argBuilder(1, true),
),
// AExp14
appBuilder( // 14
comBuilder(3,10),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 15
comBuilder(7,11),
comBuilder(4,12),
comBuilder(4,13),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp15
appBuilder( // 16
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 17
comBuilder(4,14),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp16
appBuilder( // 18
argBuilder(0, true),
comBuilder(2,9),
comBuilder(4,16),
),
// AExp17
appBuilder( // 19
comBuilder(1,23),
ptrBuilder(0, true, true),
),
appBuilder( // 20
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp18
appBuilder( // 21
comBuilder(1,23),
ptrBuilder(0, true, true),
),
appBuilder( // 22
comBuilder(1,38),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp19
appBuilder( // 23
argBuilder(0, true),
comBuilder(1,0),
comBuilder(2,21),
),
// AExp20
appBuilder( // 24
comBuilder(1,50),
argBuilder(1, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 25
comBuilder(3,72),
argBuilder(2, false),
argBuilder(0, true),
comBuilder(3,39),
),
// AExp21
appBuilder( // 26
comBuilder(4,2),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp22
appBuilder( // 27
comBuilder(4,2),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 28
comBuilder(7,2),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp23
appBuilder( // 29
comBuilder(1,38),
argBuilder(0, true),
argBuilder(2, true),
comBuilder(2,26),
comBuilder(3,27),
argBuilder(1, true),
),
// AExp24
appBuilder( // 30
comBuilder(1,94),
argBuilder(0, true),
argBuilder(3, false),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(4,111),
argBuilder(3, false),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp25
appBuilder( // 32
comBuilder(4,2),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(4,113),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(5,114),
),
// AExp26
appBuilder( // 34
comBuilder(7,2),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 35
comBuilder(7,115),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp27
appBuilder( // 36
comBuilder(2,32),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(2,34),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp28
appBuilder( // 38
argBuilder(0, true),
comBuilder(3,24),
comBuilder(3,29),
comBuilder(4,30),
comBuilder(3,39),
comBuilder(2,36),
),
// AExp29
appBuilder( // 39
argBuilder(1, true),
argBuilder(0, true),
),
// AExp30
appBuilder( // 40
comBuilder(3,51),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 41
comBuilder(3,55),
argBuilder(3, true),
),
appBuilder( // 42
comBuilder(1,50),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 43
comBuilder(1,50),
argBuilder(0, true),
argBuilder(2, false),
),
// AExp31
appBuilder( // 44
argBuilder(2, true),
argBuilder(0, true),
),
// AExp32
appBuilder( // 45
comBuilder(3,51),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 46
comBuilder(3,59),
argBuilder(3, true),
),
appBuilder( // 47
comBuilder(1,50),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 48
comBuilder(1,50),
argBuilder(0, true),
argBuilder(2, false),
),
// AExp33
appBuilder( // 49
comBuilder(1,18),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp34
appBuilder( // 50
argBuilder(0, true),
comBuilder(4,40),
comBuilder(3,44),
comBuilder(4,45),
comBuilder(2,49),
),
// AExp35
appBuilder( // 51
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(3,53),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp36
appBuilder( // 53
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 54
argBuilder(1, true),
argBuilder(2, true),
),
// AExp37
appBuilder( // 55
comBuilder(2,58),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 56
prmBuilder("+"),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp38
appBuilder( // 57
argBuilder(0, true),
intBuilder(0),
),
// AExp39
appBuilder( // 58
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,0),
comBuilder(2,57),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp40
appBuilder( // 59
comBuilder(2,58),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 60
prmBuilder("-"),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp41
appBuilder( // 61
argBuilder(0, true),
comBuilder(2,0),
),
// AExp42
appBuilder( // 62
argBuilder(0, true),
argBuilder(2, false),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp43
appBuilder( // 63
comBuilder(3,72),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 64
comBuilder(3,76),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp44
appBuilder( // 65
comBuilder(3,72),
argBuilder(0, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
argBuilder(3, false),
),
appBuilder( // 66
comBuilder(3,76),
argBuilder(2, true),
argBuilder(1, false),
argBuilder(3, false),
),
// AExp45
appBuilder( // 67
prmBuilder("=="),
argBuilder(3, true),
argBuilder(2, false),
comBuilder(6,63),
comBuilder(6,65),
argBuilder(0, true),
argBuilder(2, false),
argBuilder(1, true),
),
// AExp46
appBuilder( // 68
comBuilder(3,62),
ptrBuilder(0, true, true),
),
appBuilder( // 69
comBuilder(4,67),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp47
appBuilder( // 70
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 71
comBuilder(3,68),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp48
appBuilder( // 72
argBuilder(0, true),
comBuilder(3,61),
comBuilder(5,70),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp49
appBuilder( // 73
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 74
comBuilder(4,2),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp50
appBuilder( // 75
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp51
appBuilder( // 76
comBuilder(3,73),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 77
comBuilder(3,75),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp52
appBuilder( // 78
comBuilder(3,51),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 79
comBuilder(3,95),
argBuilder(3, true),
),
appBuilder( // 80
comBuilder(1,94),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 81
comBuilder(1,94),
argBuilder(0, true),
argBuilder(2, false),
),
// AExp53
appBuilder( // 82
comBuilder(3,51),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 83
comBuilder(3,102),
argBuilder(3, true),
),
appBuilder( // 84
comBuilder(1,50),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 85
comBuilder(1,50),
argBuilder(0, true),
argBuilder(2, false),
),
// AExp54
appBuilder( // 86
argBuilder(1, true),
comBuilder(2,0),
),
// AExp55
appBuilder( // 87
comBuilder(3,51),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 88
comBuilder(3,104),
argBuilder(3, true),
),
appBuilder( // 89
comBuilder(1,50),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 90
comBuilder(1,50),
argBuilder(0, true),
argBuilder(2, false),
),
// AExp56
appBuilder( // 91
comBuilder(1,94),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 92
comBuilder(2,106),
argBuilder(2, true),
),
// AExp57
appBuilder( // 93
argBuilder(1, true),
comBuilder(2,1),
),
// AExp58
appBuilder( // 94
argBuilder(0, true),
comBuilder(4,78),
comBuilder(4,82),
comBuilder(2,86),
comBuilder(4,87),
comBuilder(3,91),
comBuilder(2,93),
),
// AExp59
appBuilder( // 95
comBuilder(1,99),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 96
comBuilder(1,101),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp60
appBuilder( // 97
argBuilder(0, true),
comBuilder(2,0),
),
// AExp61
appBuilder( // 98
argBuilder(0, true),
comBuilder(2,1),
),
// AExp62
appBuilder( // 99
argBuilder(0, true),
comBuilder(1,97),
comBuilder(1,98),
),
// AExp63
appBuilder( // 100
comBuilder(2,0),
),
// AExp64
appBuilder( // 101
argBuilder(0, true),
comBuilder(1,100),
comBuilder(1,0),
),
// AExp65
appBuilder( // 102
comBuilder(1,99),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 103
prmBuilder("=="),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp66
appBuilder( // 104
comBuilder(1,99),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 105
prmBuilder("<="),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp67
appBuilder( // 106
comBuilder(1,99),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 107
comBuilder(1,108),
argBuilder(1, true),
),
// AExp68
appBuilder( // 108
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp69
appBuilder( // 109
comBuilder(4,2),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp70
appBuilder( // 110
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp71
appBuilder( // 111
argBuilder(3, true),
comBuilder(3,109),
comBuilder(3,110),
argBuilder(1, true),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp72
appBuilder( // 112
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp73
appBuilder( // 113
comBuilder(7,112),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp74
appBuilder( // 114
argBuilder(3, true),
),
// AExp75
appBuilder( // 115
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp76
appBuilder( // 116
argBuilder(4, true),
argBuilder(0, true),
),
// AExp77
appBuilder( // 117
argBuilder(5, true),
argBuilder(0, true),
),
// AExp78
appBuilder( // 118
comBuilder(7,75),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp79
appBuilder( // 119
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp80
appBuilder( // 120
comBuilder(7,119),
argBuilder(0, true),
argBuilder(1, true),
),
)
}
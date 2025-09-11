package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
// Functions in this file: 33
// Apps in this file: 127
// Combinators in this file: 196
object Clausify extends Benchmark {
override def toString() = "Clausify" 
val combinatorCount = 196
val prog = Seq(
 // FUN0Clausify.main
appBuilder( // 0
ptrBuilder(16),
ptrBuilder(15),
),
appBuilder( // 1
comBuilder(5,1,List(4, 0)), // XX
intBuilder(0),
),
appBuilder( // 2
comBuilder(5,1,List(4, 0)), // XX
intBuilder(0),
),
appBuilder( // 3
ptrBuilder(125),
ptrBuilder(2),
ptrBuilder(1),
),
appBuilder( // 4
comBuilder(5,1,List(4, 0)), // XX
intBuilder(0),
),
appBuilder( // 5
ptrBuilder(125),
ptrBuilder(4),
ptrBuilder(3),
),
appBuilder( // 6
comBuilder(5,1,List(4, 0)), // XX
intBuilder(0),
),
appBuilder( // 7
comBuilder(5,1,List(4, 0)), // XX
intBuilder(0),
),
appBuilder( // 8
ptrBuilder(125),
ptrBuilder(7),
ptrBuilder(6),
),
appBuilder( // 9
comBuilder(5,1,List(4, 0)), // XX
intBuilder(0),
),
appBuilder( // 10
ptrBuilder(125),
ptrBuilder(9),
ptrBuilder(8),
),
appBuilder( // 11
ptrBuilder(125),
ptrBuilder(10),
ptrBuilder(5),
),
appBuilder( // 12
ptrBuilder(121),
intBuilder(2),
ptrBuilder(11),
),
appBuilder( // 13
comBuilder(5,1,List(4, 0)), // XX
intBuilder(0),
),
appBuilder( // 14
ptrBuilder(21),
comBuilder(6,2,List(2, 0, 1)), // XXX
ptrBuilder(13),
ptrBuilder(12),
),
appBuilder( // 15
ptrBuilder(23),
ptrBuilder(14),
),
 // FUN1Clausify.display
appBuilder( // 16
comBuilder(3,2,List(2, 0, 1)), // XXX
intBuilder(0),
ptrBuilder(17),
),
appBuilder( // 17
comBuilder(5,15,List(0, 1, 3, 2, 4)), // X(XX)(XX)
prmBuilder("+"),
ptrBuilder(18),
ptrBuilder(16),
),
 // FUN2Clausify.emitClause
appBuilder( // 18
comBuilder(2,1,List(1, 0)), // XX
ptrBuilder(19),
),
appBuilder( // 19
comBuilder(4,15,List(0, 1, 2, 1, 3)), // X(XX)(XX)
prmBuilder("+"),
ptrBuilder(20),
),
 // FUN3NanoPrelude.sum
appBuilder( // 20
ptrBuilder(21),
prmBuilder("+"),
intBuilder(0),
),
 // FUN4NanoPrelude.foldr
appBuilder( // 21
comBuilder(4,7,List(0, 1, 2, 3)), // X(XXX)
yBuilder(),
ptrBuilder(22),
),
appBuilder( // 22
comBuilder(5,16,List(4, 2, 0, 1, 3)), // XX(XXX)
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
),
 // FUN5Clausify.clausify
appBuilder( // 23
comBuilder(4,6,List(0, 1, 2, 3)), // XX(XX)
comBuilder(1,0,List(0)), // X
ptrBuilder(26),
ptrBuilder(25),
),
appBuilder( // 24
comBuilder(6,48,List(0, 1, 2, 3, 4, 5)), // XX(XX(XX))
comBuilder(1,0,List(0)), // X
ptrBuilder(85),
comBuilder(1,0,List(0)), // X
ptrBuilder(93),
ptrBuilder(112),
),
appBuilder( // 25
comBuilder(6,48,List(0, 1, 2, 3, 4, 5)), // XX(XX(XX))
comBuilder(1,0,List(0)), // X
ptrBuilder(56),
comBuilder(1,0,List(0)), // X
ptrBuilder(62),
ptrBuilder(24),
),
 // FUN6Clausify.uniq
appBuilder( // 26
ptrBuilder(21),
ptrBuilder(28),
comBuilder(2,0,List(0)), // X
),
appBuilder( // 27
ptrBuilder(29),
ptrBuilder(44),
),
appBuilder( // 28
comBuilder(3,3,List(0, 1, 2)), // X(XX)
ptrBuilder(27),
ptrBuilder(55),
),
 // FUN7Clausify.union
appBuilder( // 29
comBuilder(5,46,List(0, 3, 1, 2, 3, 4)), // XX(XXXX)
ptrBuilder(31),
ptrBuilder(30),
),
appBuilder( // 30
comBuilder(6,58,List(0, 1, 2, 3, 4, 5)), // X(XX(XXX))
ptrBuilder(34),
comBuilder(3,3,List(0, 1, 2)), // X(XX)
ptrBuilder(38),
ptrBuilder(39),
),
 // FUN8Data.List_Type.++
appBuilder( // 31
comBuilder(4,5,List(0, 1, 3, 2)), // X(XX)X
yBuilder(),
ptrBuilder(33),
),
appBuilder( // 32
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 33
comBuilder(4,6,List(3, 1, 0, 2)), // XX(XX)
ptrBuilder(32),
),
 // FUN9NanoPrelude.filter
appBuilder( // 34
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(37),
),
appBuilder( // 35
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 36
comBuilder(4,5,List(0, 1, 3, 2)), // X(XX)X
comBuilder(4,30,List(0, 2, 1, 2, 3, 3)), // XX(XXX)X
comBuilder(5,39,List(0, 3, 1, 4, 2, 4)), // XX(XX)(XX)
ptrBuilder(35),
),
appBuilder( // 37
comBuilder(5,16,List(4, 0, 1, 2, 3)), // XX(XXX)
comBuilder(2,0,List(0)), // X
ptrBuilder(36),
),
 // FUN10Data.Bool.not
appBuilder( // 38
comBuilder(3,2,List(2, 0, 1)), // XXX
comBuilder(2,0,List(1)), // X
comBuilder(2,0,List(0)), // X
),
 // FUN11Clausify.contains
appBuilder( // 39
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(42),
),
appBuilder( // 40
comBuilder(6,40,List(0, 1, 4, 3, 2, 5)), // X(XXX)(XX)
ptrBuilder(43),
),
appBuilder( // 41
comBuilder(5,47,List(3, 0, 1, 2, 4, 4)), // XX(X(XX)X)
comBuilder(2,0,List(0)), // X
),
appBuilder( // 42
comBuilder(5,15,List(0, 1, 3, 2, 4)), // X(XX)(XX)
ptrBuilder(41),
ptrBuilder(40),
comBuilder(3,2,List(0, 2, 1)), // XXX
),
 // FUN12Data.Bool.||
appBuilder( // 43
comBuilder(3,2,List(1, 2, 0)), // XXX
comBuilder(2,0,List(1)), // X
),
 // FUN13Clausify.eqClause
appBuilder( // 44
comBuilder(3,3,List(1, 0, 2)), // X(XX)
ptrBuilder(47),
),
appBuilder( // 45
comBuilder(5,18,List(0, 1, 2, 3, 4)), // X(XXXX)
ptrBuilder(48),
ptrBuilder(49),
prmBuilder("=="),
),
appBuilder( // 46
comBuilder(5,10,List(0, 1, 4, 2, 3)), // X(XX)XX
comBuilder(6,46,List(0, 4, 1, 2, 3, 5)), // XX(XXXX)
ptrBuilder(45),
ptrBuilder(49),
prmBuilder("=="),
),
appBuilder( // 47
comBuilder(4,7,List(1, 0, 2, 3)), // X(XXX)
ptrBuilder(46),
),
 // FUN14Data.Bool.&&
appBuilder( // 48
comBuilder(2,1,List(1, 0)), // XX
comBuilder(2,0,List(0)), // X
),
 // FUN15Clausify.eqList
appBuilder( // 49
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(54),
),
appBuilder( // 50
comBuilder(6,40,List(0, 1, 2, 4, 3, 5)), // X(XXX)(XX)
ptrBuilder(48),
),
appBuilder( // 51
comBuilder(6,48,List(3, 0, 1, 4, 2, 5)), // XX(XX(XX))
comBuilder(2,0,List(0)), // X
),
appBuilder( // 52
comBuilder(3,0,List(0)), // X
comBuilder(2,0,List(0)), // X
),
appBuilder( // 53
comBuilder(5,40,List(3, 4, 0, 1, 2, 4)), // X(XXX)(XX)
comBuilder(2,0,List(1)), // X
ptrBuilder(52),
),
appBuilder( // 54
comBuilder(5,19,List(0, 1, 2, 3, 4)), // X(X(XX)X)
ptrBuilder(53),
ptrBuilder(51),
ptrBuilder(50),
),
 // FUN16Clausify.singleton
appBuilder( // 55
comBuilder(3,2,List(0, 2, 1)), // XXX
comBuilder(4,2,List(3, 0, 1)), // XXX
comBuilder(2,0,List(0)), // X
),
 // FUN17Clausify.nonTaut
appBuilder( // 56
ptrBuilder(34),
ptrBuilder(57),
),
 // FUN18Clausify.notTaut
appBuilder( // 57
comBuilder(2,1,List(1, 0)), // XX
ptrBuilder(58),
),
appBuilder( // 58
comBuilder(5,18,List(0, 1, 2, 3, 4)), // X(XXXX)
ptrBuilder(59),
ptrBuilder(61),
prmBuilder("=="),
),
 // FUN19NanoPrelude.null
appBuilder( // 59
comBuilder(3,2,List(2, 0, 1)), // XXX
comBuilder(2,0,List(1)), // X
ptrBuilder(60),
),
appBuilder( // 60
comBuilder(3,0,List(0)), // X
comBuilder(2,0,List(0)), // X
),
 // FUN20Clausify.inter
appBuilder( // 61
comBuilder(4,7,List(0, 1, 2, 3)), // X(XXX)
ptrBuilder(34),
ptrBuilder(39),
),
 // FUN21Clausify.clauses
appBuilder( // 62
ptrBuilder(65),
ptrBuilder(64),
),
appBuilder( // 63
comBuilder(2,2,List(1, 0, 0)), // XXX
comBuilder(2,0,List(0)), // X
),
appBuilder( // 64
ptrBuilder(68),
ptrBuilder(63),
),
 // FUN22NanoPrelude.map
appBuilder( // 65
comBuilder(3,3,List(0, 1, 2)), // X(XX)
yBuilder(),
ptrBuilder(67),
),
appBuilder( // 66
comBuilder(5,15,List(0, 1, 3, 2, 4)), // X(XX)(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 67
comBuilder(5,16,List(4, 0, 1, 2, 3)), // XX(XXX)
comBuilder(2,0,List(0)), // X
ptrBuilder(66),
),
 // FUN23Clausify.clause
appBuilder( // 68
comBuilder(6,54,List(4, 0, 1, 5, 3, 2)), // X(X(XXX)X)
comBuilder(4,42,List(0, 2, 3, 1, 2, 3)), // XXX(XXX)
ptrBuilder(77),
ptrBuilder(70),
ptrBuilder(69),
),
appBuilder( // 69
comBuilder(2,2,List(1, 0, 0)), // XXX
comBuilder(2,0,List(0)), // X
),
appBuilder( // 70
comBuilder(5,12,List(4, 0, 3, 1, 2)), // X(XXX)X
ptrBuilder(78),
),
appBuilder( // 71
comBuilder(5,16,List(4, 1, 0, 3, 2)), // XX(XXX)
ptrBuilder(78),
),
appBuilder( // 72
comBuilder(4,15,List(0, 1, 3, 2, 3)), // X(XX)(XX)
comBuilder(5,37,List(4, 0, 0, 1, 2, 3)), // XXXX(XX)
comBuilder(3,0,List(0)), // X
comBuilder(2,0,List(0)), // X
),
appBuilder( // 73
comBuilder(5,54,List(0, 0, 1, 2, 3, 4)), // X(X(XXX)X)
ptrBuilder(68),
comBuilder(3,2,List(2, 0, 1)), // XXX
),
appBuilder( // 74
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(5,39,List(0, 1, 2, 4, 3, 4)), // XX(XX)(XX)
comBuilder(3,0,List(0)), // X
),
appBuilder( // 75
comBuilder(5,38,List(0, 1, 4, 2, 3, 4)), // X(XX)X(XX)
comBuilder(5,45,List(0, 1, 4, 2, 3, 4)), // X(XX)(X(XX))
),
appBuilder( // 76
comBuilder(5,10,List(0, 1, 4, 2, 3)), // X(XX)XX
ptrBuilder(75),
ptrBuilder(74),
ptrBuilder(73),
ptrBuilder(72),
),
appBuilder( // 77
comBuilder(4,4,List(0, 2, 3, 1)), // XXXX
ptrBuilder(76),
ptrBuilder(71),
),
 // FUN24Clausify.insert
appBuilder( // 78
comBuilder(4,19,List(0, 1, 2, 3, 3)), // X(X(XX)X)
yBuilder(),
ptrBuilder(84),
ptrBuilder(83),
),
appBuilder( // 79
comBuilder(4,16,List(0, 1, 0, 2, 3)), // XX(XXX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 80
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
),
appBuilder( // 81
comBuilder(5,42,List(0, 1, 3, 2, 3, 4)), // XXX(XXX)
prmBuilder("<="),
),
appBuilder( // 82
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
ptrBuilder(81),
ptrBuilder(80),
),
appBuilder( // 83
comBuilder(5,40,List(0, 1, 3, 4, 2, 3)), // X(XXX)(XX)
comBuilder(4,42,List(0, 2, 3, 1, 2, 3)), // XXX(XXX)
ptrBuilder(82),
ptrBuilder(79),
),
appBuilder( // 84
comBuilder(6,40,List(5, 0, 3, 1, 2, 4)), // X(XXX)(XX)
comBuilder(4,2,List(3, 0, 1)), // XXX
comBuilder(2,0,List(0)), // X
),
 // FUN25Clausify.split
appBuilder( // 85
ptrBuilder(86),
comBuilder(2,0,List(0)), // X
),
 // FUN26Clausify.spl
appBuilder( // 86
comBuilder(4,20,List(0, 1, 3, 2, 3)), // X(XX(XX))
yBuilder(),
ptrBuilder(92),
ptrBuilder(87),
),
appBuilder( // 87
comBuilder(4,5,List(0, 1, 3, 2)), // X(XX)X
comBuilder(4,2,List(3, 0, 1)), // XXX
comBuilder(5,1,List(4, 0)), // XX
),
appBuilder( // 88
comBuilder(4,5,List(0, 1, 3, 2)), // X(XX)X
comBuilder(4,2,List(3, 0, 1)), // XXX
comBuilder(5,1,List(3, 0)), // XX
),
appBuilder( // 89
comBuilder(5,12,List(0, 1, 3, 4, 2)), // X(XXX)X
comBuilder(4,2,List(3, 0, 1)), // XXX
comBuilder(6,2,List(3, 0, 1)), // XXX
),
appBuilder( // 90
comBuilder(3,3,List(0, 1, 2)), // X(XX)
ptrBuilder(86),
),
appBuilder( // 91
comBuilder(6,24,List(5, 0, 4, 1, 2, 3)), // X(XX)XXX
ptrBuilder(90),
),
appBuilder( // 92
comBuilder(4,15,List(0, 1, 3, 2, 3)), // X(XX)(XX)
ptrBuilder(91),
ptrBuilder(89),
ptrBuilder(88),
),
 // FUN27Clausify.disin
appBuilder( // 93
comBuilder(5,9,List(4, 0, 1, 2, 3)), // XXXXX
ptrBuilder(95),
ptrBuilder(94),
comBuilder(5,1,List(3, 0)), // XX
comBuilder(5,1,List(4, 0)), // XX
),
appBuilder( // 94
comBuilder(4,15,List(0, 1, 2, 1, 3)), // X(XX)(XX)
ptrBuilder(96),
ptrBuilder(93),
),
appBuilder( // 95
comBuilder(4,15,List(0, 1, 2, 1, 3)), // X(XX)(XX)
comBuilder(6,2,List(2, 0, 1)), // XXX
ptrBuilder(93),
),
 // FUN28Clausify.din
appBuilder( // 96
comBuilder(4,14,List(0, 2, 3, 1, 3)), // XXX(XX)
ptrBuilder(103),
ptrBuilder(97),
),
appBuilder( // 97
comBuilder(4,5,List(0, 1, 3, 2)), // X(XX)X
ptrBuilder(104),
comBuilder(5,1,List(4, 0)), // XX
),
appBuilder( // 98
comBuilder(4,5,List(0, 1, 3, 2)), // X(XX)X
ptrBuilder(104),
comBuilder(5,1,List(3, 0)), // XX
),
appBuilder( // 99
comBuilder(5,12,List(0, 1, 3, 4, 2)), // X(XXX)X
ptrBuilder(104),
comBuilder(6,2,List(3, 0, 1)), // XXX
),
appBuilder( // 100
comBuilder(3,2,List(0, 2, 1)), // XXX
ptrBuilder(96),
),
appBuilder( // 101
comBuilder(6,40,List(0, 1, 4, 3, 2, 5)), // X(XXX)(XX)
comBuilder(6,2,List(2, 0, 1)), // XXX
ptrBuilder(96),
),
appBuilder( // 102
comBuilder(4,19,List(2, 0, 1, 3, 3)), // X(X(XX)X)
ptrBuilder(101),
ptrBuilder(100),
),
appBuilder( // 103
comBuilder(5,10,List(0, 1, 4, 2, 3)), // X(XX)XX
comBuilder(4,39,List(0, 3, 1, 3, 2, 3)), // XX(XX)(XX)
ptrBuilder(102),
ptrBuilder(99),
ptrBuilder(98),
),
 // FUN29Clausify.din2
appBuilder( // 104
comBuilder(3,6,List(0, 2, 1, 2)), // XX(XX)
ptrBuilder(111),
ptrBuilder(105),
),
appBuilder( // 105
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(6,2,List(3, 0, 1)), // XXX
comBuilder(5,1,List(4, 0)), // XX
),
appBuilder( // 106
comBuilder(4,6,List(0, 2, 1, 3)), // XX(XX)
comBuilder(6,2,List(3, 0, 1)), // XXX
comBuilder(5,1,List(3, 0)), // XX
),
appBuilder( // 107
comBuilder(4,16,List(0, 1, 0, 2, 3)), // XX(XXX)
comBuilder(6,2,List(3, 0, 1)), // XXX
),
appBuilder( // 108
comBuilder(6,40,List(0, 1, 3, 4, 2, 5)), // X(XXX)(XX)
comBuilder(6,2,List(2, 0, 1)), // XXX
ptrBuilder(96),
),
appBuilder( // 109
comBuilder(3,5,List(0, 1, 2, 2)), // X(XX)X
ptrBuilder(108),
ptrBuilder(96),
),
appBuilder( // 110
comBuilder(6,24,List(5, 0, 1, 2, 3, 4)), // X(XX)XXX
ptrBuilder(109),
),
appBuilder( // 111
comBuilder(4,39,List(0, 3, 1, 3, 2, 3)), // XX(XX)(XX)
ptrBuilder(110),
ptrBuilder(107),
ptrBuilder(106),
),
 // FUN30Clausify.negin
appBuilder( // 112
comBuilder(5,9,List(4, 0, 1, 2, 3)), // XXXXX
ptrBuilder(120),
ptrBuilder(119),
ptrBuilder(118),
comBuilder(5,1,List(4, 0)), // XX
),
appBuilder( // 113
comBuilder(3,3,List(0, 1, 2)), // X(XX)
comBuilder(5,1,List(3, 0)), // XX
comBuilder(5,1,List(4, 0)), // XX
),
appBuilder( // 114
comBuilder(3,3,List(0, 1, 2)), // X(XX)
ptrBuilder(112),
comBuilder(5,1,List(3, 0)), // XX
),
appBuilder( // 115
comBuilder(6,41,List(0, 1, 2, 4, 3, 5)), // X(X(XX))(XX)
comBuilder(6,2,List(2, 0, 1)), // XXX
ptrBuilder(112),
comBuilder(5,1,List(3, 0)), // XX
ptrBuilder(114),
),
appBuilder( // 116
comBuilder(3,3,List(0, 1, 2)), // X(XX)
ptrBuilder(112),
comBuilder(5,1,List(3, 0)), // XX
),
appBuilder( // 117
comBuilder(6,41,List(0, 1, 2, 4, 3, 5)), // X(X(XX))(XX)
comBuilder(6,2,List(3, 0, 1)), // XXX
ptrBuilder(112),
comBuilder(5,1,List(3, 0)), // XX
ptrBuilder(116),
),
appBuilder( // 118
comBuilder(5,9,List(4, 0, 1, 2, 3)), // XXXXX
ptrBuilder(117),
ptrBuilder(115),
ptrBuilder(112),
ptrBuilder(113),
),
appBuilder( // 119
comBuilder(4,15,List(0, 1, 2, 1, 3)), // X(XX)(XX)
comBuilder(6,2,List(3, 0, 1)), // XXX
ptrBuilder(112),
),
appBuilder( // 120
comBuilder(4,15,List(0, 1, 2, 1, 3)), // X(XX)(XX)
comBuilder(6,2,List(2, 0, 1)), // XXX
ptrBuilder(112),
),
 // FUN31NanoPrelude.replicate
appBuilder( // 121
comBuilder(4,10,List(0, 1, 3, 2, 3)), // X(XX)XX
ptrBuilder(124),
ptrBuilder(123),
comBuilder(2,0,List(0)), // X
),
appBuilder( // 122
comBuilder(4,7,List(0, 1, 3, 2)), // X(XXX)
ptrBuilder(121),
prmBuilder("-"),
intBuilder(1),
),
appBuilder( // 123
comBuilder(4,16,List(0, 3, 1, 2, 3)), // XX(XXX)
comBuilder(4,2,List(3, 0, 1)), // XXX
ptrBuilder(122),
),
appBuilder( // 124
comBuilder(6,28,List(0, 4, 1, 2, 5, 3)), // XXX(XX)X
prmBuilder("<="),
intBuilder(0),
),
 // FUN32Clausify.eqv
appBuilder( // 125
comBuilder(5,24,List(0, 1, 4, 2, 3, 4)), // X(XX)XXX
comBuilder(5,47,List(0, 4, 1, 2, 4, 3)), // XX(X(XX)X)
ptrBuilder(126),
comBuilder(6,2,List(3, 0, 1)), // XXX
comBuilder(5,1,List(3, 0)), // XX
),
appBuilder( // 126
comBuilder(5,19,List(0, 1, 2, 3, 4)), // X(X(XX)X)
comBuilder(6,2,List(2, 0, 1)), // XXX
comBuilder(6,2,List(3, 0, 1)), // XXX
comBuilder(5,1,List(3, 0)), // XX
),
)
}
package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Uart extends Benchmark {
override def toString() = "Uart"
val combinatorCount = 668
val heap_img: Seq[Vec[Atom]] = Seq.concat(
  heapChunk000,
  heapChunk001,
  heapChunk002,
  heapChunk003,
  heapChunk004,
  heapChunk005,
  heapChunk006,
  heapChunk007,
  heapChunk008,
  heapChunk009
)
val comb_img: Seq[Vec[Atom]] = Seq.concat(
  combChunk000,
  combChunk001,
  combChunk002,
  combChunk003,
  combChunk004,
  combChunk005,
  combChunk006,
  combChunk007,
  combChunk008,
  combChunk009,
  combChunk010,
  combChunk011,
  combChunk012,
  combChunk013,
  combChunk014,
  combChunk015,
  combChunk016,
  combChunk017,
  combChunk018,
  combChunk019,
  combChunk020,
  combChunk021,
  combChunk022,
  combChunk023,
  combChunk024,
  combChunk025,
  combChunk026,
  combChunk027,
  combChunk028,
  combChunk029,
  combChunk030,
  combChunk031,
  combChunk032,
  combChunk033,
  combChunk034,
  combChunk035,
  combChunk036,
  combChunk037,
  combChunk038,
  combChunk039
)

  // Each helper constructs at most 32 Apps.
  private def heapChunk000: Seq[Vec[Atom]] = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(17, false, false),
ptrBuilder(1, false, false),
intBuilder(1993),
),
appBuilder( // 1
ptrBuilder(20, false, false),
comBuilder(2,0),
),
appBuilder( // 2
comBuilder(4,3),
intBuilder(111),
comBuilder(2,0),
),
appBuilder( // 3
comBuilder(4,3),
intBuilder(109),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(4,3),
intBuilder(101),
ptrBuilder(3, false, false),
),
appBuilder( // 5
comBuilder(4,3),
intBuilder(100),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(4,3),
intBuilder(32),
ptrBuilder(5, false, false),
),
appBuilder( // 7
comBuilder(4,3),
intBuilder(84),
ptrBuilder(6, false, false),
),
appBuilder( // 8
comBuilder(4,3),
intBuilder(82),
ptrBuilder(7, false, false),
),
appBuilder( // 9
comBuilder(4,3),
intBuilder(65),
ptrBuilder(8, false, false),
),
appBuilder( // 10
comBuilder(4,3),
intBuilder(85),
ptrBuilder(9, false, false),
),
appBuilder( // 11
comBuilder(4,3),
intBuilder(32),
ptrBuilder(10, false, false),
),
appBuilder( // 12
comBuilder(4,3),
intBuilder(115),
ptrBuilder(11, false, false),
),
appBuilder( // 13
comBuilder(4,3),
intBuilder(111),
ptrBuilder(12, false, false),
),
appBuilder( // 14
comBuilder(4,3),
intBuilder(114),
ptrBuilder(13, false, false),
),
appBuilder( // 15
comBuilder(4,3),
intBuilder(117),
ptrBuilder(14, false, false),
),
appBuilder( // 16
comBuilder(4,3),
intBuilder(79),
ptrBuilder(15, false, false),
),
appBuilder( // 17
comBuilder(1,17),
ptrBuilder(16, false, false),
),
// AExp1
appBuilder( // 18
comBuilder(4,13),
comBuilder(2,9),
ptrBuilder(19, false, false),
comBuilder(1,11),
),
appBuilder( // 19
comBuilder(3,14),
ptrBuilder(18, false, false),
),
// AExp2
appBuilder( // 20
comBuilder(3,26),
ptrBuilder(36, false, false),
ptrBuilder(30, false, false),
),
appBuilder( // 21
comBuilder(4,3),
intBuilder(33),
comBuilder(2,0),
),
appBuilder( // 22
comBuilder(4,3),
intBuilder(119),
ptrBuilder(21, false, false),
),
appBuilder( // 23
comBuilder(1,55),
ptrBuilder(22, false, false),
),
appBuilder( // 24
comBuilder(1,53),
ptrBuilder(23, false, false),
),
appBuilder( // 25
comBuilder(1,51),
ptrBuilder(24, false, false),
),
appBuilder( // 26
comBuilder(1,49),
ptrBuilder(25, false, false),
),
appBuilder( // 27
comBuilder(1,47),
ptrBuilder(26, false, false),
),
appBuilder( // 28
comBuilder(2,45),
ptrBuilder(27, false, false),
),
appBuilder( // 29
comBuilder(2,44),
ptrBuilder(28, false, false),
),
appBuilder( // 30
comBuilder(2,36),
ptrBuilder(29, false, false),
),
appBuilder( // 31
comBuilder(4,3),
intBuilder(32),
comBuilder(2,0),
),
  )
  private def heapChunk001: Seq[Vec[Atom]] = Seq(
appBuilder( // 32
comBuilder(4,3),
intBuilder(62),
ptrBuilder(31, false, false),
),
appBuilder( // 33
comBuilder(1,34),
ptrBuilder(32, false, false),
),
appBuilder( // 34
comBuilder(1,32),
ptrBuilder(33, false, false),
),
appBuilder( // 35
comBuilder(1,30),
ptrBuilder(34, false, false),
),
appBuilder( // 36
comBuilder(2,28),
ptrBuilder(35, false, false),
),
// AExp3
appBuilder( // 37
comBuilder(3,57),
ptrBuilder(47, false, false),
),
appBuilder( // 38
comBuilder(4,3),
intBuilder(8),
comBuilder(2,0),
),
appBuilder( // 39
comBuilder(4,3),
intBuilder(32),
ptrBuilder(38, false, false),
),
appBuilder( // 40
comBuilder(1,105),
ptrBuilder(39, false, false),
),
appBuilder( // 41
comBuilder(3,103),
ptrBuilder(40, false, false),
),
appBuilder( // 42
comBuilder(4,101),
ptrBuilder(41, false, false),
),
appBuilder( // 43
comBuilder(5,98),
ptrBuilder(42, false, false),
),
appBuilder( // 44
comBuilder(5,84),
ptrBuilder(43, false, false),
),
appBuilder( // 45
comBuilder(4,76),
ptrBuilder(44, false, false),
),
appBuilder( // 46
comBuilder(4,63),
ptrBuilder(45, false, false),
),
appBuilder( // 47
comBuilder(3,60),
ptrBuilder(46, false, false),
),
// AExp4
appBuilder( // 48
comBuilder(1,16),
ptrBuilder(18, false, false),
ptrBuilder(49, false, false),
comBuilder(1,107),
),
appBuilder( // 49
ioBuilder(false),
intBuilder(0),
),
// AExp5
appBuilder( // 50
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(54, false, false),
ptrBuilder(52, false, false),
),
appBuilder( // 51
comBuilder(1,0),
intBuilder(10),
),
appBuilder( // 52
ptrBuilder(55, false, false),
ptrBuilder(51, false, false),
),
appBuilder( // 53
comBuilder(1,0),
intBuilder(13),
),
appBuilder( // 54
ptrBuilder(55, false, false),
ptrBuilder(53, false, false),
),
// AExp6
appBuilder( // 55
ioBuilder(true),
intBuilder(4),
),
// AExp7
appBuilder( // 56
comBuilder(2,147),
ptrBuilder(102, false, false),
ptrBuilder(96, false, false),
),
appBuilder( // 57
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(105, false, false),
ptrBuilder(109, false, false),
),
appBuilder( // 58
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(57, false, false),
comBuilder(1,185),
),
appBuilder( // 59
comBuilder(4,3),
intBuilder(114),
comBuilder(2,0),
),
appBuilder( // 60
comBuilder(4,3),
intBuilder(97),
ptrBuilder(59, false, false),
),
appBuilder( // 61
comBuilder(4,3),
intBuilder(115),
ptrBuilder(60, false, false),
),
appBuilder( // 62
comBuilder(4,3),
intBuilder(101),
ptrBuilder(61, false, false),
),
appBuilder( // 63
comBuilder(4,3),
intBuilder(97),
ptrBuilder(62, false, false),
),
  )
  private def heapChunk002: Seq[Vec[Atom]] = Seq(
appBuilder( // 64
comBuilder(4,3),
intBuilder(99),
ptrBuilder(63, false, false),
),
appBuilder( // 65
comBuilder(1,188),
ptrBuilder(64, false, false),
ptrBuilder(58, false, false),
),
appBuilder( // 66
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(105, false, false),
ptrBuilder(109, false, false),
),
appBuilder( // 67
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(66, false, false),
comBuilder(1,178),
),
appBuilder( // 68
comBuilder(4,3),
intBuilder(98),
comBuilder(2,0),
),
appBuilder( // 69
comBuilder(4,3),
intBuilder(105),
ptrBuilder(68, false, false),
),
appBuilder( // 70
comBuilder(4,3),
intBuilder(102),
ptrBuilder(69, false, false),
),
appBuilder( // 71
comBuilder(1,188),
ptrBuilder(70, false, false),
ptrBuilder(67, false, false),
),
appBuilder( // 72
comBuilder(2,147),
ptrBuilder(71, false, false),
ptrBuilder(65, false, false),
),
appBuilder( // 73
comBuilder(4,3),
intBuilder(33),
comBuilder(2,0),
),
appBuilder( // 74
comBuilder(4,3),
intBuilder(111),
ptrBuilder(73, false, false),
),
appBuilder( // 75
comBuilder(4,3),
intBuilder(108),
ptrBuilder(74, false, false),
),
appBuilder( // 76
comBuilder(4,3),
intBuilder(108),
ptrBuilder(75, false, false),
),
appBuilder( // 77
comBuilder(4,3),
intBuilder(101),
ptrBuilder(76, false, false),
),
appBuilder( // 78
comBuilder(4,3),
intBuilder(104),
ptrBuilder(77, false, false),
),
appBuilder( // 79
comBuilder(3,36),
ptrBuilder(78, false, false),
),
appBuilder( // 80
comBuilder(1,25),
ptrBuilder(103, false, false),
ptrBuilder(79, false, false),
),
appBuilder( // 81
comBuilder(4,3),
intBuilder(105),
comBuilder(2,0),
),
appBuilder( // 82
comBuilder(4,3),
intBuilder(104),
ptrBuilder(81, false, false),
),
appBuilder( // 83
comBuilder(1,188),
ptrBuilder(82, false, false),
ptrBuilder(80, false, false),
),
appBuilder( // 84
comBuilder(2,147),
ptrBuilder(83, false, false),
ptrBuilder(72, false, false),
),
appBuilder( // 85
comBuilder(4,3),
intBuilder(33),
comBuilder(2,0),
),
appBuilder( // 86
comBuilder(4,3),
intBuilder(105),
ptrBuilder(85, false, false),
),
appBuilder( // 87
comBuilder(4,3),
intBuilder(104),
ptrBuilder(86, false, false),
),
appBuilder( // 88
comBuilder(3,36),
ptrBuilder(87, false, false),
),
appBuilder( // 89
comBuilder(1,25),
ptrBuilder(103, false, false),
ptrBuilder(88, false, false),
),
appBuilder( // 90
comBuilder(4,3),
intBuilder(111),
comBuilder(2,0),
),
appBuilder( // 91
comBuilder(4,3),
intBuilder(108),
ptrBuilder(90, false, false),
),
appBuilder( // 92
comBuilder(4,3),
intBuilder(108),
ptrBuilder(91, false, false),
),
appBuilder( // 93
comBuilder(4,3),
intBuilder(101),
ptrBuilder(92, false, false),
),
appBuilder( // 94
comBuilder(4,3),
intBuilder(104),
ptrBuilder(93, false, false),
),
appBuilder( // 95
comBuilder(1,188),
ptrBuilder(94, false, false),
ptrBuilder(89, false, false),
),
  )
  private def heapChunk003: Seq[Vec[Atom]] = Seq(
appBuilder( // 96
comBuilder(2,147),
ptrBuilder(95, false, false),
ptrBuilder(84, false, false),
),
appBuilder( // 97
comBuilder(1,25),
ptrBuilder(103, false, false),
comBuilder(2,1),
),
appBuilder( // 98
comBuilder(4,3),
intBuilder(101),
comBuilder(2,0),
),
appBuilder( // 99
comBuilder(4,3),
intBuilder(109),
ptrBuilder(98, false, false),
),
appBuilder( // 100
comBuilder(4,3),
intBuilder(97),
ptrBuilder(99, false, false),
),
appBuilder( // 101
comBuilder(4,3),
intBuilder(103),
ptrBuilder(100, false, false),
),
appBuilder( // 102
comBuilder(1,188),
ptrBuilder(101, false, false),
ptrBuilder(97, false, false),
),
// AExp8
appBuilder( // 103
comBuilder(4,13),
comBuilder(2,132),
ptrBuilder(104, false, false),
comBuilder(1,136),
),
appBuilder( // 104
comBuilder(3,14),
ptrBuilder(103, false, false),
),
// AExp9
appBuilder( // 105
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(108, false, false),
ptrBuilder(106, false, false),
),
appBuilder( // 106
comBuilder(1,25),
ptrBuilder(103, false, false),
comBuilder(1,0),
),
appBuilder( // 107
comBuilder(1,162),
comBuilder(1,164),
),
appBuilder( // 108
comBuilder(1,154),
ptrBuilder(107, false, false),
),
// AExp10
appBuilder( // 109
comBuilder(2,147),
ptrBuilder(119, false, false),
ptrBuilder(115, false, false),
),
appBuilder( // 110
comBuilder(1,205),
comBuilder(2,0),
),
appBuilder( // 111
comBuilder(1,205),
comBuilder(2,0),
),
appBuilder( // 112
comBuilder(1,0),
intBuilder(43),
),
appBuilder( // 113
comBuilder(1,201),
ptrBuilder(112, false, false),
),
appBuilder( // 114
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(113, false, false),
ptrBuilder(111, false, false),
),
appBuilder( // 115
comBuilder(2,147),
ptrBuilder(114, false, false),
ptrBuilder(110, false, false),
),
appBuilder( // 116
comBuilder(1,205),
comBuilder(2,1),
),
appBuilder( // 117
comBuilder(1,0),
intBuilder(45),
),
appBuilder( // 118
comBuilder(1,201),
ptrBuilder(117, false, false),
),
appBuilder( // 119
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(118, false, false),
ptrBuilder(116, false, false),
),
// AExp11
appBuilder( // 120
comBuilder(1,0),
comBuilder(1,250),
),
// AExp12
appBuilder( // 121
comBuilder(1,154),
ptrBuilder(122, false, false),
),
appBuilder( // 122
comBuilder(1,162),
comBuilder(1,291),
),
// AExp13
appBuilder( // 123
comBuilder(4,473),
ptrBuilder(131, false, false),
ptrBuilder(125, false, false),
),
appBuilder( // 124
comBuilder(4,3),
intBuilder(72),
comBuilder(2,0),
),
appBuilder( // 125
comBuilder(1,471),
ptrBuilder(124, false, false),
),
appBuilder( // 126
comBuilder(4,3),
intBuilder(59),
comBuilder(2,0),
),
appBuilder( // 127
comBuilder(1,471),
ptrBuilder(126, false, false),
),
  )
  private def heapChunk004: Seq[Vec[Atom]] = Seq(
appBuilder( // 128
comBuilder(4,3),
intBuilder(91),
comBuilder(2,0),
),
appBuilder( // 129
comBuilder(4,3),
intBuilder(27),
ptrBuilder(128, false, false),
),
appBuilder( // 130
comBuilder(2,484),
ptrBuilder(129, false, false),
),
appBuilder( // 131
comBuilder(3,480),
ptrBuilder(130, false, false),
ptrBuilder(127, false, false),
),
// AExp14
appBuilder( // 132
comBuilder(6,501),
ptrBuilder(143, false, false),
ptrBuilder(136, false, false),
),
appBuilder( // 133
comBuilder(4,3),
intBuilder(109),
comBuilder(2,0),
),
appBuilder( // 134
comBuilder(4,3),
intBuilder(48),
ptrBuilder(133, false, false),
),
appBuilder( // 135
comBuilder(1,522),
ptrBuilder(134, false, false),
),
appBuilder( // 136
comBuilder(2,521),
ptrBuilder(135, false, false),
),
appBuilder( // 137
comBuilder(4,3),
intBuilder(109),
comBuilder(2,0),
),
appBuilder( // 138
comBuilder(4,3),
intBuilder(55),
ptrBuilder(137, false, false),
),
appBuilder( // 139
comBuilder(1,519),
ptrBuilder(138, false, false),
),
appBuilder( // 140
comBuilder(2,518),
ptrBuilder(139, false, false),
),
appBuilder( // 141
comBuilder(4,515),
ptrBuilder(140, false, false),
),
appBuilder( // 142
comBuilder(5,508),
ptrBuilder(141, false, false),
),
appBuilder( // 143
comBuilder(4,506),
ptrBuilder(142, false, false),
),
// AExp15
appBuilder( // 144
comBuilder(4,357),
ptrBuilder(206, false, false),
ptrBuilder(181, false, false),
),
appBuilder( // 145
comBuilder(4,3),
intBuilder(116),
comBuilder(2,0),
),
appBuilder( // 146
comBuilder(4,3),
intBuilder(105),
ptrBuilder(145, false, false),
),
appBuilder( // 147
comBuilder(1,466),
ptrBuilder(146, false, false),
),
appBuilder( // 148
comBuilder(1,464),
ptrBuilder(147, false, false),
),
appBuilder( // 149
comBuilder(1,462),
ptrBuilder(148, false, false),
),
appBuilder( // 150
comBuilder(1,460),
ptrBuilder(149, false, false),
),
appBuilder( // 151
comBuilder(1,458),
ptrBuilder(150, false, false),
),
appBuilder( // 152
comBuilder(1,456),
ptrBuilder(151, false, false),
),
appBuilder( // 153
comBuilder(1,454),
ptrBuilder(152, false, false),
),
appBuilder( // 154
comBuilder(1,452),
ptrBuilder(153, false, false),
),
appBuilder( // 155
comBuilder(1,450),
ptrBuilder(154, false, false),
),
appBuilder( // 156
comBuilder(1,448),
ptrBuilder(155, false, false),
),
appBuilder( // 157
comBuilder(1,446),
ptrBuilder(156, false, false),
),
appBuilder( // 158
comBuilder(1,444),
ptrBuilder(157, false, false),
),
appBuilder( // 159
comBuilder(1,442),
ptrBuilder(158, false, false),
),
  )
  private def heapChunk005: Seq[Vec[Atom]] = Seq(
appBuilder( // 160
comBuilder(1,440),
ptrBuilder(159, false, false),
),
appBuilder( // 161
comBuilder(1,438),
ptrBuilder(160, false, false),
),
appBuilder( // 162
comBuilder(1,436),
ptrBuilder(161, false, false),
),
appBuilder( // 163
comBuilder(1,434),
ptrBuilder(162, false, false),
),
appBuilder( // 164
comBuilder(1,432),
ptrBuilder(163, false, false),
),
appBuilder( // 165
comBuilder(1,430),
ptrBuilder(164, false, false),
),
appBuilder( // 166
comBuilder(1,428),
ptrBuilder(165, false, false),
),
appBuilder( // 167
comBuilder(1,426),
ptrBuilder(166, false, false),
),
appBuilder( // 168
comBuilder(1,424),
ptrBuilder(167, false, false),
),
appBuilder( // 169
comBuilder(1,422),
ptrBuilder(168, false, false),
),
appBuilder( // 170
comBuilder(1,420),
ptrBuilder(169, false, false),
),
appBuilder( // 171
comBuilder(1,418),
ptrBuilder(170, false, false),
),
appBuilder( // 172
comBuilder(1,416),
ptrBuilder(171, false, false),
),
appBuilder( // 173
comBuilder(1,414),
ptrBuilder(172, false, false),
),
appBuilder( // 174
comBuilder(1,412),
ptrBuilder(173, false, false),
),
appBuilder( // 175
comBuilder(1,410),
ptrBuilder(174, false, false),
),
appBuilder( // 176
comBuilder(1,408),
ptrBuilder(175, false, false),
),
appBuilder( // 177
comBuilder(1,406),
ptrBuilder(176, false, false),
),
appBuilder( // 178
comBuilder(1,404),
ptrBuilder(177, false, false),
),
appBuilder( // 179
comBuilder(1,402),
ptrBuilder(178, false, false),
),
appBuilder( // 180
comBuilder(1,400),
ptrBuilder(179, false, false),
),
appBuilder( // 181
comBuilder(1,398),
ptrBuilder(180, false, false),
),
appBuilder( // 182
comBuilder(4,3),
intBuilder(32),
comBuilder(2,0),
),
appBuilder( // 183
comBuilder(4,3),
intBuilder(58),
ptrBuilder(182, false, false),
),
appBuilder( // 184
comBuilder(1,396),
ptrBuilder(183, false, false),
),
appBuilder( // 185
comBuilder(1,394),
ptrBuilder(184, false, false),
),
appBuilder( // 186
comBuilder(1,392),
ptrBuilder(185, false, false),
),
appBuilder( // 187
comBuilder(1,390),
ptrBuilder(186, false, false),
),
appBuilder( // 188
comBuilder(1,388),
ptrBuilder(187, false, false),
),
appBuilder( // 189
comBuilder(1,386),
ptrBuilder(188, false, false),
),
appBuilder( // 190
comBuilder(4,3),
intBuilder(71),
comBuilder(2,0),
),
appBuilder( // 191
comBuilder(4,3),
intBuilder(78),
ptrBuilder(190, false, false),
),
  )
  private def heapChunk006: Seq[Vec[Atom]] = Seq(
appBuilder( // 192
comBuilder(1,384),
ptrBuilder(191, false, false),
),
appBuilder( // 193
comBuilder(1,382),
ptrBuilder(192, false, false),
),
appBuilder( // 194
comBuilder(4,3),
intBuilder(32),
comBuilder(2,0),
),
appBuilder( // 195
comBuilder(4,3),
intBuilder(68),
ptrBuilder(194, false, false),
),
appBuilder( // 196
comBuilder(1,380),
ptrBuilder(195, false, false),
),
appBuilder( // 197
comBuilder(1,378),
ptrBuilder(196, false, false),
),
appBuilder( // 198
comBuilder(3,375),
ptrBuilder(197, false, false),
ptrBuilder(193, false, false),
),
appBuilder( // 199
comBuilder(4,3),
intBuilder(75),
comBuilder(2,0),
),
appBuilder( // 200
comBuilder(4,3),
intBuilder(50),
ptrBuilder(199, false, false),
),
appBuilder( // 201
comBuilder(1,373),
ptrBuilder(200, false, false),
),
appBuilder( // 202
comBuilder(1,370),
ptrBuilder(201, false, false),
),
appBuilder( // 203
comBuilder(2,368),
ptrBuilder(202, false, false),
),
appBuilder( // 204
comBuilder(3,282),
ptrBuilder(203, false, false),
ptrBuilder(198, false, false),
),
appBuilder( // 205
comBuilder(3,365),
ptrBuilder(204, false, false),
ptrBuilder(189, false, false),
),
appBuilder( // 206
comBuilder(3,362),
ptrBuilder(205, false, false),
),
// AExp16
appBuilder( // 207
comBuilder(1,16),
ptrBuilder(18, false, false),
ptrBuilder(208, false, false),
comBuilder(1,697),
),
appBuilder( // 208
ioBuilder(false),
intBuilder(8),
),
// AExp17
appBuilder( // 209
comBuilder(1,699),
comBuilder(3,706),
),
// AExp18
appBuilder( // 210
comBuilder(3,843),
ptrBuilder(212, false, false),
),
appBuilder( // 211
comBuilder(1,1085),
comBuilder(1,0),
comBuilder(1,1132),
),
appBuilder( // 212
comBuilder(3,848),
ptrBuilder(211, false, false),
),
// AExp19
appBuilder( // 213
comBuilder(2,354),
intBuilder(80),
comBuilder(1,356),
),
// AExp20
appBuilder( // 214
comBuilder(1,471),
ptrBuilder(232, false, false),
),
appBuilder( // 215
comBuilder(4,3),
intBuilder(108),
comBuilder(2,0),
),
appBuilder( // 216
comBuilder(4,3),
intBuilder(57),
ptrBuilder(215, false, false),
),
appBuilder( // 217
comBuilder(4,3),
intBuilder(52),
ptrBuilder(216, false, false),
),
appBuilder( // 218
comBuilder(4,3),
intBuilder(48),
ptrBuilder(217, false, false),
),
appBuilder( // 219
comBuilder(4,3),
intBuilder(49),
ptrBuilder(218, false, false),
),
appBuilder( // 220
comBuilder(4,3),
intBuilder(63),
ptrBuilder(219, false, false),
),
appBuilder( // 221
comBuilder(4,3),
intBuilder(91),
ptrBuilder(220, false, false),
),
appBuilder( // 222
comBuilder(4,3),
intBuilder(27),
ptrBuilder(221, false, false),
),
appBuilder( // 223
comBuilder(4,3),
intBuilder(104),
ptrBuilder(222, false, false),
),
  )
  private def heapChunk007: Seq[Vec[Atom]] = Seq(
appBuilder( // 224
comBuilder(4,3),
intBuilder(53),
ptrBuilder(223, false, false),
),
appBuilder( // 225
comBuilder(4,3),
intBuilder(50),
ptrBuilder(224, false, false),
),
appBuilder( // 226
comBuilder(4,3),
intBuilder(63),
ptrBuilder(225, false, false),
),
appBuilder( // 227
comBuilder(4,3),
intBuilder(91),
ptrBuilder(226, false, false),
),
appBuilder( // 228
comBuilder(4,3),
intBuilder(27),
ptrBuilder(227, false, false),
),
appBuilder( // 229
comBuilder(4,3),
intBuilder(109),
ptrBuilder(228, false, false),
),
appBuilder( // 230
comBuilder(4,3),
intBuilder(48),
ptrBuilder(229, false, false),
),
appBuilder( // 231
comBuilder(4,3),
intBuilder(91),
ptrBuilder(230, false, false),
),
appBuilder( // 232
comBuilder(4,3),
intBuilder(27),
ptrBuilder(231, false, false),
),
// AExp21
appBuilder( // 233
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(296, false, false),
ptrBuilder(274, false, false),
),
appBuilder( // 234
comBuilder(4,3),
intBuilder(41),
comBuilder(2,0),
),
appBuilder( // 235
comBuilder(4,3),
intBuilder(48),
ptrBuilder(234, false, false),
),
appBuilder( // 236
comBuilder(4,3),
intBuilder(56),
ptrBuilder(235, false, false),
),
appBuilder( // 237
comBuilder(4,3),
intBuilder(32),
ptrBuilder(236, false, false),
),
appBuilder( // 238
comBuilder(4,3),
intBuilder(120),
ptrBuilder(237, false, false),
),
appBuilder( // 239
comBuilder(4,3),
intBuilder(32),
ptrBuilder(238, false, false),
),
appBuilder( // 240
comBuilder(4,3),
intBuilder(48),
ptrBuilder(239, false, false),
),
appBuilder( // 241
comBuilder(4,3),
intBuilder(48),
ptrBuilder(240, false, false),
),
appBuilder( // 242
comBuilder(4,3),
intBuilder(49),
ptrBuilder(241, false, false),
),
appBuilder( // 243
comBuilder(4,3),
intBuilder(40),
ptrBuilder(242, false, false),
),
appBuilder( // 244
comBuilder(4,3),
intBuilder(32),
ptrBuilder(243, false, false),
),
appBuilder( // 245
comBuilder(4,3),
intBuilder(101),
ptrBuilder(244, false, false),
),
appBuilder( // 246
comBuilder(4,3),
intBuilder(102),
ptrBuilder(245, false, false),
),
appBuilder( // 247
comBuilder(4,3),
intBuilder(105),
ptrBuilder(246, false, false),
),
appBuilder( // 248
comBuilder(4,3),
intBuilder(76),
ptrBuilder(247, false, false),
),
appBuilder( // 249
comBuilder(4,3),
intBuilder(32),
ptrBuilder(248, false, false),
),
appBuilder( // 250
comBuilder(4,3),
intBuilder(102),
ptrBuilder(249, false, false),
),
appBuilder( // 251
comBuilder(4,3),
intBuilder(111),
ptrBuilder(250, false, false),
),
appBuilder( // 252
comBuilder(4,3),
intBuilder(32),
ptrBuilder(251, false, false),
),
appBuilder( // 253
comBuilder(4,3),
intBuilder(101),
ptrBuilder(252, false, false),
),
appBuilder( // 254
comBuilder(4,3),
intBuilder(109),
ptrBuilder(253, false, false),
),
appBuilder( // 255
comBuilder(4,3),
intBuilder(97),
ptrBuilder(254, false, false),
),
  )
  private def heapChunk008: Seq[Vec[Atom]] = Seq(
appBuilder( // 256
comBuilder(4,3),
intBuilder(71),
ptrBuilder(255, false, false),
),
appBuilder( // 257
comBuilder(4,3),
intBuilder(32),
ptrBuilder(256, false, false),
),
appBuilder( // 258
comBuilder(4,3),
intBuilder(115),
ptrBuilder(257, false, false),
),
appBuilder( // 259
comBuilder(4,3),
intBuilder(39),
ptrBuilder(258, false, false),
),
appBuilder( // 260
comBuilder(4,3),
intBuilder(121),
ptrBuilder(259, false, false),
),
appBuilder( // 261
comBuilder(4,3),
intBuilder(97),
ptrBuilder(260, false, false),
),
appBuilder( // 262
comBuilder(4,3),
intBuilder(119),
ptrBuilder(261, false, false),
),
appBuilder( // 263
comBuilder(4,3),
intBuilder(110),
ptrBuilder(262, false, false),
),
appBuilder( // 264
comBuilder(4,3),
intBuilder(111),
ptrBuilder(263, false, false),
),
appBuilder( // 265
comBuilder(4,3),
intBuilder(67),
ptrBuilder(264, false, false),
),
appBuilder( // 266
comBuilder(4,3),
intBuilder(32),
ptrBuilder(265, false, false),
),
appBuilder( // 267
comBuilder(4,3),
intBuilder(47),
ptrBuilder(266, false, false),
),
appBuilder( // 268
comBuilder(4,3),
intBuilder(32),
ptrBuilder(267, false, false),
),
appBuilder( // 269
comBuilder(4,3),
intBuilder(115),
ptrBuilder(268, false, false),
),
appBuilder( // 270
comBuilder(4,3),
intBuilder(111),
ptrBuilder(269, false, false),
),
appBuilder( // 271
comBuilder(4,3),
intBuilder(114),
ptrBuilder(270, false, false),
),
appBuilder( // 272
comBuilder(4,3),
intBuilder(117),
ptrBuilder(271, false, false),
),
appBuilder( // 273
comBuilder(4,3),
intBuilder(79),
ptrBuilder(272, false, false),
),
appBuilder( // 274
comBuilder(3,576),
intBuilder(1),
intBuilder(1),
ptrBuilder(273, false, false),
),
appBuilder( // 275
comBuilder(4,3),
intBuilder(72),
comBuilder(2,0),
),
appBuilder( // 276
comBuilder(4,3),
intBuilder(91),
ptrBuilder(275, false, false),
),
appBuilder( // 277
comBuilder(4,3),
intBuilder(27),
ptrBuilder(276, false, false),
),
appBuilder( // 278
comBuilder(4,3),
intBuilder(74),
ptrBuilder(277, false, false),
),
appBuilder( // 279
comBuilder(4,3),
intBuilder(50),
ptrBuilder(278, false, false),
),
appBuilder( // 280
comBuilder(4,3),
intBuilder(91),
ptrBuilder(279, false, false),
),
appBuilder( // 281
comBuilder(4,3),
intBuilder(27),
ptrBuilder(280, false, false),
),
appBuilder( // 282
comBuilder(4,3),
intBuilder(108),
ptrBuilder(281, false, false),
),
appBuilder( // 283
comBuilder(4,3),
intBuilder(53),
ptrBuilder(282, false, false),
),
appBuilder( // 284
comBuilder(4,3),
intBuilder(50),
ptrBuilder(283, false, false),
),
appBuilder( // 285
comBuilder(4,3),
intBuilder(63),
ptrBuilder(284, false, false),
),
appBuilder( // 286
comBuilder(4,3),
intBuilder(91),
ptrBuilder(285, false, false),
),
appBuilder( // 287
comBuilder(4,3),
intBuilder(27),
ptrBuilder(286, false, false),
),
  )
  private def heapChunk009: Seq[Vec[Atom]] = Seq(
appBuilder( // 288
comBuilder(4,3),
intBuilder(104),
ptrBuilder(287, false, false),
),
appBuilder( // 289
comBuilder(4,3),
intBuilder(57),
ptrBuilder(288, false, false),
),
appBuilder( // 290
comBuilder(4,3),
intBuilder(52),
ptrBuilder(289, false, false),
),
appBuilder( // 291
comBuilder(4,3),
intBuilder(48),
ptrBuilder(290, false, false),
),
appBuilder( // 292
comBuilder(4,3),
intBuilder(49),
ptrBuilder(291, false, false),
),
appBuilder( // 293
comBuilder(4,3),
intBuilder(63),
ptrBuilder(292, false, false),
),
appBuilder( // 294
comBuilder(4,3),
intBuilder(91),
ptrBuilder(293, false, false),
),
appBuilder( // 295
comBuilder(4,3),
intBuilder(27),
ptrBuilder(294, false, false),
),
appBuilder( // 296
comBuilder(1,471),
ptrBuilder(295, false, false),
),
// AExp22
appBuilder( // 297
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(300, false, false),
ptrBuilder(298, false, false),
),
appBuilder( // 298
comBuilder(1,25),
ptrBuilder(103, false, false),
comBuilder(1,0),
),
appBuilder( // 299
comBuilder(1,162),
comBuilder(1,164),
),
appBuilder( // 300
comBuilder(1,139),
ptrBuilder(299, false, false),
),
// AExp23
appBuilder( // 301
comBuilder(1,0),
comBuilder(1,169),
),
// AExp24
appBuilder( // 302
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(303, false, false),
comBuilder(1,211),
),
appBuilder( // 303
comBuilder(1,162),
comBuilder(1,208),
),
// AExp25
appBuilder( // 304
comBuilder(2,213),
ptrBuilder(307, false, false),
),
appBuilder( // 305
comBuilder(1,0),
comBuilder(5,230),
comBuilder(5,235),
comBuilder(1,238),
comBuilder(2,242),
comBuilder(3,247),
comBuilder(4,249),
),
appBuilder( // 306
comBuilder(4,217),
ptrBuilder(305, false, false),
),
appBuilder( // 307
comBuilder(5,216),
ptrBuilder(306, false, false),
),
  )
  private def combChunk000: Seq[Vec[Atom]] = Seq(
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
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp3
appBuilder( // 3
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp4
appBuilder( // 4
argBuilder(0, true),
comBuilder(3,1),
),
// AExp5
appBuilder( // 5
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 6
argBuilder(0, true),
argBuilder(1, true),
),
// AExp6
appBuilder( // 7
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 8
comBuilder(2,5),
argBuilder(1, true),
),
// AExp7
appBuilder( // 9
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(3,7),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 11
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(3,2),
argBuilder(0, true),
),
// AExp9
appBuilder( // 13
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp10
appBuilder( // 14
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 15
comBuilder(2,0),
argBuilder(2, true),
),
// AExp11
appBuilder( // 16
argBuilder(0, true),
comBuilder(3,0),
),
// AExp12
appBuilder( // 17
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
ptrBuilder(50, false, false),
),
appBuilder( // 18
comBuilder(1,22),
argBuilder(0, true),
),
// AExp13
appBuilder( // 19
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 20
comBuilder(1,22),
argBuilder(1, true),
),
appBuilder( // 21
ptrBuilder(55, false, false),
argBuilder(0, true),
),
// AExp14
appBuilder( // 22
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,19),
),
appBuilder( // 23
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp15
appBuilder( // 24
argBuilder(2, true),
),
// AExp16
appBuilder( // 25
argBuilder(0, true),
comBuilder(3,24),
),
// AExp17
appBuilder( // 26
comBuilder(1,16),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 27
argBuilder(0, true),
argBuilder(2, true),
),
// AExp18
appBuilder( // 28
comBuilder(1,4),
ptrBuilder(18, false, false),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 29
ptrBuilder(37, false, false),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp19
appBuilder( // 30
comBuilder(1,22),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(4,3),
intBuilder(111),
argBuilder(0, true),
),
  )
  private def combChunk001: Seq[Vec[Atom]] = Seq(
// AExp20
appBuilder( // 32
comBuilder(4,3),
intBuilder(117),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(4,3),
intBuilder(114),
argBuilder(0, true),
),
// AExp21
appBuilder( // 34
comBuilder(4,3),
intBuilder(111),
ptrBuilder(0, true, true),
),
appBuilder( // 35
comBuilder(4,3),
intBuilder(115),
argBuilder(0, true),
),
// AExp22
appBuilder( // 36
argBuilder(1, true),
argBuilder(0, true),
),
// AExp23
appBuilder( // 37
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 38
ptrBuilder(20, false, false),
argBuilder(1, true),
),
appBuilder( // 39
comBuilder(1,17),
argBuilder(0, true),
),
// AExp24
appBuilder( // 40
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 41
ptrBuilder(20, false, false),
comBuilder(2,0),
),
appBuilder( // 42
comBuilder(1,346),
argBuilder(0, true),
),
// AExp25
appBuilder( // 43
argBuilder(0, true),
comBuilder(2,37),
comBuilder(1,40),
),
// AExp26
appBuilder( // 44
comBuilder(2,124),
ptrBuilder(56, false, false),
argBuilder(1, true),
argBuilder(0, true),
comBuilder(1,43),
),
// AExp27
appBuilder( // 45
comBuilder(1,4),
ptrBuilder(18, false, false),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 46
ptrBuilder(20, false, false),
argBuilder(1, true),
),
// AExp28
appBuilder( // 47
comBuilder(1,17),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(4,3),
intBuilder(100),
argBuilder(0, true),
),
// AExp29
appBuilder( // 49
comBuilder(4,3),
intBuilder(111),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(4,3),
intBuilder(110),
argBuilder(0, true),
),
// AExp30
appBuilder( // 51
comBuilder(4,3),
intBuilder(39),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(4,3),
intBuilder(116),
argBuilder(0, true),
),
// AExp31
appBuilder( // 53
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 54
comBuilder(4,3),
intBuilder(107),
argBuilder(0, true),
),
// AExp32
appBuilder( // 55
comBuilder(4,3),
intBuilder(110),
ptrBuilder(0, true, true),
),
appBuilder( // 56
comBuilder(4,3),
intBuilder(111),
argBuilder(0, true),
),
// AExp33
appBuilder( // 57
comBuilder(1,16),
ptrBuilder(18, false, false),
ptrBuilder(48, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 58
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp34
appBuilder( // 59
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
// AExp35
appBuilder( // 60
comBuilder(3,59),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
),
appBuilder( // 61
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp36
appBuilder( // 62
ptrBuilder(37, false, false),
comBuilder(2,0),
argBuilder(0, true),
),
// AExp37
appBuilder( // 63
comBuilder(1,110),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(0, true),
comBuilder(7,62),
argBuilder(2, true),
argBuilder(3, false),
ptrBuilder(18, false, false),
),
  )
  private def combChunk002: Seq[Vec[Atom]] = Seq(
appBuilder( // 64
prmBuilder("=="),
argBuilder(3, false),
intBuilder(10),
),
// AExp38
appBuilder( // 65
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp39
appBuilder( // 66
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(5, false),
),
appBuilder( // 67
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, true),
),
// AExp40
appBuilder( // 68
prmBuilder("=="),
argBuilder(4, true),
intBuilder(13),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(3, true),
),
appBuilder( // 69
comBuilder(7,66),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp41
appBuilder( // 70
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(50, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 71
comBuilder(1,25),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp42
appBuilder( // 72
argBuilder(1, true),
ptrBuilder(0, true, true),
comBuilder(2,1),
),
appBuilder( // 73
comBuilder(1,116),
argBuilder(0, true),
),
// AExp43
appBuilder( // 74
comBuilder(7,70),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 75
comBuilder(2,72),
argBuilder(2, true),
),
// AExp44
appBuilder( // 76
comBuilder(3,65),
ptrBuilder(0, true, true),
argBuilder(2, false),
),
appBuilder( // 77
comBuilder(7,68),
comBuilder(3,65),
argBuilder(0, true),
comBuilder(3,74),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp45
appBuilder( // 78
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(50, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 79
comBuilder(1,25),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp46
appBuilder( // 80
argBuilder(1, true),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 81
comBuilder(1,116),
argBuilder(0, true),
),
// AExp47
appBuilder( // 82
comBuilder(5,78),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 83
comBuilder(2,80),
argBuilder(2, true),
),
// AExp48
appBuilder( // 84
prmBuilder("=="),
argBuilder(2, true),
intBuilder(10),
argBuilder(0, true),
comBuilder(3,82),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(1, true),
),
// AExp49
appBuilder( // 85
ptrBuilder(37, false, false),
comBuilder(2,0),
),
// AExp50
appBuilder( // 86
ptrBuilder(55, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 87
comBuilder(1,0),
argBuilder(0, true),
),
// AExp51
appBuilder( // 88
comBuilder(4,3),
ptrBuilder(0, true, true),
),
appBuilder( // 89
comBuilder(1,0),
argBuilder(0, true),
),
// AExp52
appBuilder( // 90
ptrBuilder(37, false, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 91
comBuilder(1,88),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp53
appBuilder( // 92
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 93
comBuilder(2,90),
argBuilder(1, false),
argBuilder(2, true),
),
appBuilder( // 94
comBuilder(1,86),
argBuilder(1, false),
),
// AExp54
appBuilder( // 95
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(2,85),
comBuilder(3,92),
argBuilder(2, true),
argBuilder(1, false),
argBuilder(0, true),
),
  )
  private def combChunk003: Seq[Vec[Atom]] = Seq(
appBuilder( // 96
prmBuilder("<="),
argBuilder(1, false),
intBuilder(126),
),
appBuilder( // 97
prmBuilder(">="),
argBuilder(1, false),
intBuilder(32),
),
// AExp55
appBuilder( // 98
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(3,95),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, false),
),
appBuilder( // 99
prmBuilder("=="),
argBuilder(4, false),
intBuilder(127),
),
appBuilder( // 100
prmBuilder("=="),
argBuilder(4, false),
intBuilder(8),
),
// AExp56
appBuilder( // 101
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 102
ptrBuilder(37, false, false),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp57
appBuilder( // 103
comBuilder(1,4),
ptrBuilder(18, false, false),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 104
ptrBuilder(37, false, false),
comBuilder(2,0),
argBuilder(2, true),
),
// AExp58
appBuilder( // 105
comBuilder(1,22),
ptrBuilder(0, true, true),
),
appBuilder( // 106
comBuilder(4,3),
intBuilder(8),
argBuilder(0, true),
),
// AExp59
appBuilder( // 107
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 108
comBuilder(1,0),
argBuilder(0, true),
),
// AExp60
appBuilder( // 109
comBuilder(2,0),
),
// AExp61
appBuilder( // 110
argBuilder(0, true),
comBuilder(1,109),
comBuilder(1,0),
),
// AExp62
appBuilder( // 111
comBuilder(2,1),
),
// AExp63
appBuilder( // 112
argBuilder(0, true),
comBuilder(1,0),
comBuilder(1,111),
),
// AExp64
appBuilder( // 113
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 114
comBuilder(4,3),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp65
appBuilder( // 115
argBuilder(1, true),
comBuilder(2,0),
comBuilder(4,113),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp66
appBuilder( // 116
yBuilder(),
comBuilder(3,115),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp67
appBuilder( // 117
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 118
comBuilder(1,25),
ptrBuilder(103, false, false),
argBuilder(0, true),
),
appBuilder( // 119
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(297, false, false),
ptrBuilder(301, false, false),
),
// AExp68
appBuilder( // 120
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(0, true, true),
comBuilder(1,117),
),
appBuilder( // 121
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(297, false, false),
argBuilder(0, true),
),
// AExp69
appBuilder( // 122
comBuilder(3,138),
argBuilder(0, true),
),
// AExp70
appBuilder( // 123
argBuilder(0, true),
comBuilder(2,122),
),
// AExp71
appBuilder( // 124
comBuilder(1,0),
ptrBuilder(0, true, true),
argBuilder(1, true),
comBuilder(2,0),
comBuilder(1,123),
),
appBuilder( // 125
comBuilder(1,120),
argBuilder(0, true),
),
// AExp72
appBuilder( // 126
comBuilder(2,0),
),
// AExp73
appBuilder( // 127
comBuilder(1,0),
ptrBuilder(0, true, true),
),
  )
  private def combChunk004: Seq[Vec[Atom]] = Seq(
appBuilder( // 128
argBuilder(0, true),
argBuilder(1, true),
),
// AExp74
appBuilder( // 129
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 130
comBuilder(2,127),
argBuilder(1, true),
),
// AExp75
appBuilder( // 131
argBuilder(0, true),
argBuilder(2, true),
comBuilder(1,126),
comBuilder(2,129),
argBuilder(1, true),
),
// AExp76
appBuilder( // 132
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 133
comBuilder(3,131),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp77
appBuilder( // 134
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 135
comBuilder(3,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp78
appBuilder( // 136
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 137
comBuilder(2,134),
argBuilder(0, true),
),
// AExp79
appBuilder( // 138
argBuilder(2, true),
argBuilder(0, true),
),
// AExp80
appBuilder( // 139
comBuilder(2,147),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 140
comBuilder(1,25),
ptrBuilder(103, false, false),
comBuilder(2,0),
),
appBuilder( // 141
comBuilder(1,154),
argBuilder(0, true),
),
// AExp81
appBuilder( // 142
argBuilder(0, true),
argBuilder(1, true),
),
// AExp82
appBuilder( // 143
argBuilder(3, true),
),
// AExp83
appBuilder( // 144
argBuilder(2, false),
comBuilder(3,142),
comBuilder(4,143),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp84
appBuilder( // 145
comBuilder(3,144),
argBuilder(1, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 146
argBuilder(0, true),
argBuilder(2, false),
),
// AExp85
appBuilder( // 147
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 148
comBuilder(3,145),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp86
appBuilder( // 149
comBuilder(1,25),
ptrBuilder(103, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 150
comBuilder(4,3),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp87
appBuilder( // 151
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 152
comBuilder(2,149),
argBuilder(1, true),
),
appBuilder( // 153
comBuilder(1,139),
argBuilder(0, true),
),
// AExp88
appBuilder( // 154
comBuilder(1,16),
ptrBuilder(103, false, false),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 155
comBuilder(2,151),
argBuilder(0, false),
),
// AExp89
appBuilder( // 156
comBuilder(2,0),
),
// AExp90
appBuilder( // 157
comBuilder(2,0),
),
// AExp91
appBuilder( // 158
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 159
comBuilder(3,2),
argBuilder(0, true),
argBuilder(1, true),
),
  )
  private def combChunk005: Seq[Vec[Atom]] = Seq(
// AExp92
appBuilder( // 160
argBuilder(2, true),
argBuilder(0, false),
comBuilder(2,157),
comBuilder(2,158),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp93
appBuilder( // 161
argBuilder(1, true),
comBuilder(1,156),
comBuilder(3,160),
argBuilder(0, true),
),
// AExp94
appBuilder( // 162
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 163
comBuilder(2,161),
argBuilder(0, true),
),
// AExp95
appBuilder( // 164
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 165
prmBuilder("=="),
argBuilder(0, false),
intBuilder(9),
),
appBuilder( // 166
prmBuilder("=="),
argBuilder(0, false),
intBuilder(32),
),
// AExp96
appBuilder( // 167
argBuilder(0, true),
comBuilder(1,0),
comBuilder(2,0),
),
// AExp97
appBuilder( // 168
comBuilder(2,0),
),
// AExp98
appBuilder( // 169
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,168),
),
appBuilder( // 170
comBuilder(3,138),
comBuilder(1,167),
),
// AExp99
appBuilder( // 171
ptrBuilder(120, false, false),
),
// AExp100
appBuilder( // 172
comBuilder(1,266),
ptrBuilder(0, true, true),
),
appBuilder( // 173
comBuilder(1,290),
argBuilder(0, true),
),
// AExp101
appBuilder( // 174
comBuilder(3,36),
ptrBuilder(0, true, true),
),
appBuilder( // 175
comBuilder(1,172),
argBuilder(0, true),
),
// AExp102
appBuilder( // 176
comBuilder(1,25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 177
comBuilder(1,174),
argBuilder(1, true),
),
// AExp103
appBuilder( // 178
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(2,171),
comBuilder(2,176),
ptrBuilder(103, false, false),
argBuilder(0, false),
),
appBuilder( // 179
prmBuilder("<="),
argBuilder(0, false),
intBuilder(40),
),
appBuilder( // 180
prmBuilder(">="),
argBuilder(0, false),
intBuilder(0),
),
// AExp104
appBuilder( // 181
comBuilder(3,36),
ptrBuilder(0, true, true),
),
appBuilder( // 182
comBuilder(1,294),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp105
appBuilder( // 183
comBuilder(1,25),
ptrBuilder(103, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 184
comBuilder(2,181),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp106
appBuilder( // 185
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 186
comBuilder(2,183),
argBuilder(0, true),
),
appBuilder( // 187
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(105, false, false),
ptrBuilder(121, false, false),
),
// AExp107
appBuilder( // 188
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 189
comBuilder(1,198),
argBuilder(0, true),
),
// AExp108
appBuilder( // 190
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 191
comBuilder(1,198),
argBuilder(1, true),
),
  )
  private def combChunk006: Seq[Vec[Atom]] = Seq(
appBuilder( // 192
comBuilder(1,201),
argBuilder(0, true),
),
// AExp109
appBuilder( // 193
comBuilder(1,25),
ptrBuilder(103, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 194
comBuilder(4,3),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp110
appBuilder( // 195
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 196
comBuilder(2,193),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 197
comBuilder(2,190),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp111
appBuilder( // 198
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,195),
),
appBuilder( // 199
comBuilder(1,25),
ptrBuilder(103, false, false),
comBuilder(2,0),
),
// AExp112
appBuilder( // 200
prmBuilder("=="),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp113
appBuilder( // 201
comBuilder(1,162),
ptrBuilder(0, true, true),
),
appBuilder( // 202
comBuilder(2,200),
argBuilder(0, true),
),
// AExp114
appBuilder( // 203
ptrBuilder(304, false, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(120, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 204
comBuilder(1,25),
ptrBuilder(103, false, false),
),
// AExp115
appBuilder( // 205
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 206
comBuilder(2,203),
argBuilder(0, true),
),
appBuilder( // 207
comBuilder(1,154),
ptrBuilder(302, false, false),
),
// AExp116
appBuilder( // 208
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 209
prmBuilder("<="),
argBuilder(0, false),
intBuilder(57),
),
appBuilder( // 210
prmBuilder(">="),
argBuilder(0, false),
intBuilder(48),
),
// AExp117
appBuilder( // 211
comBuilder(1,25),
ptrBuilder(103, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 212
prmBuilder("-"),
argBuilder(0, true),
intBuilder(48),
),
// AExp118
appBuilder( // 213
yBuilder(),
ptrBuilder(0, true, true),
intBuilder(0),
),
appBuilder( // 214
argBuilder(0, true),
argBuilder(1, true),
),
// AExp119
appBuilder( // 215
comBuilder(3,138),
argBuilder(0, true),
),
// AExp120
appBuilder( // 216
argBuilder(4, true),
comBuilder(3,215),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp121
appBuilder( // 217
argBuilder(0, true),
argBuilder(3, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp122
appBuilder( // 218
argBuilder(5, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
),
// AExp123
appBuilder( // 219
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 220
prmBuilder(">"),
argBuilder(1, true),
intBuilder(5),
),
appBuilder( // 221
prmBuilder("=="),
argBuilder(0, true),
intBuilder(26843545),
),
// AExp124
appBuilder( // 222
prmBuilder("+"),
ptrBuilder(0, true, true),
),
appBuilder( // 223
prmBuilder("*"),
argBuilder(0, true),
intBuilder(10),
),
  )
  private def combChunk007: Seq[Vec[Atom]] = Seq(
// AExp125
appBuilder( // 224
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 225
comBuilder(1,222),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp126
appBuilder( // 226
comBuilder(2,0),
),
// AExp127
appBuilder( // 227
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
comBuilder(3,224),
comBuilder(4,226),
argBuilder(2, true),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 228
comBuilder(2,219),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 229
prmBuilder(">"),
argBuilder(0, false),
intBuilder(26843545),
),
// AExp128
appBuilder( // 230
comBuilder(7,218),
comBuilder(3,227),
ptrBuilder(0, true, true),
),
appBuilder( // 231
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp129
appBuilder( // 232
comBuilder(1,112),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp130
appBuilder( // 233
comBuilder(7,232),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
),
appBuilder( // 234
argBuilder(1, true),
argBuilder(5, false),
),
// AExp131
appBuilder( // 235
comBuilder(6,233),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, false),
),
appBuilder( // 236
argBuilder(1, true),
argBuilder(4, false),
),
appBuilder( // 237
argBuilder(0, true),
argBuilder(4, false),
),
// AExp132
appBuilder( // 238
prmBuilder("<"),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 239
prmBuilder("-"),
intBuilder(0),
intBuilder(26843545),
),
// AExp133
appBuilder( // 240
prmBuilder("=="),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 241
prmBuilder("-"),
intBuilder(0),
intBuilder(26843545),
),
// AExp134
appBuilder( // 242
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 243
prmBuilder(">"),
argBuilder(1, true),
intBuilder(6),
),
appBuilder( // 244
comBuilder(1,240),
argBuilder(0, true),
),
// AExp135
appBuilder( // 245
prmBuilder("-"),
ptrBuilder(0, true, true),
),
appBuilder( // 246
prmBuilder("*"),
argBuilder(0, true),
intBuilder(10),
),
// AExp136
appBuilder( // 247
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 248
comBuilder(1,245),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp137
appBuilder( // 249
comBuilder(2,0),
),
// AExp138
appBuilder( // 250
comBuilder(2,0),
),
// AExp139
appBuilder( // 251
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 252
argBuilder(1, true),
argBuilder(2, false),
),
// AExp140
appBuilder( // 253
argBuilder(1, true),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp141
appBuilder( // 254
comBuilder(4,3),
ptrBuilder(0, true, true),
),
appBuilder( // 255
comBuilder(1,0),
argBuilder(0, true),
),
  )
  private def combChunk008: Seq[Vec[Atom]] = Seq(
// AExp142
appBuilder( // 256
prmBuilder("+"),
intBuilder(48),
ptrBuilder(0, true, true),
),
appBuilder( // 257
argBuilder(0, true),
comBuilder(2,1),
),
// AExp143
appBuilder( // 258
comBuilder(1,254),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 259
comBuilder(1,256),
argBuilder(1, true),
),
// AExp144
appBuilder( // 260
prmBuilder("=="),
argBuilder(3, false),
intBuilder(0),
comBuilder(3,253),
comBuilder(3,0),
ptrBuilder(0, true, true),
argBuilder(0, true),
argBuilder(3, false),
),
appBuilder( // 261
comBuilder(2,258),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp145
appBuilder( // 262
argBuilder(0, true),
comBuilder(2,0),
),
// AExp146
appBuilder( // 263
comBuilder(3,251),
ptrBuilder(1, true, true),
comBuilder(1,262),
ptrBuilder(0, true, true),
),
appBuilder( // 264
comBuilder(1,280),
argBuilder(1, true),
intBuilder(10),
),
appBuilder( // 265
comBuilder(4,260),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp147
appBuilder( // 266
yBuilder(),
comBuilder(3,263),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp148
appBuilder( // 267
argBuilder(2, true),
intBuilder(0),
argBuilder(0, true),
),
// AExp149
appBuilder( // 268
argBuilder(2, true),
intBuilder(1),
ptrBuilder(0, true, true),
),
appBuilder( // 269
prmBuilder("-"),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp150
appBuilder( // 270
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,267),
comBuilder(3,268),
argBuilder(0, false),
argBuilder(2, false),
),
// AExp151
appBuilder( // 271
argBuilder(3, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 272
prmBuilder("-"),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 273
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp152
appBuilder( // 274
prmBuilder("<="),
argBuilder(0, false),
argBuilder(2, false),
comBuilder(4,3),
comBuilder(4,271),
ptrBuilder(0, true, true),
argBuilder(2, false),
argBuilder(0, false),
),
appBuilder( // 275
prmBuilder("+"),
argBuilder(1, false),
argBuilder(1, false),
),
// AExp153
appBuilder( // 276
comBuilder(1,280),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 277
comBuilder(3,274),
argBuilder(2, true),
),
// AExp154
appBuilder( // 278
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,270),
comBuilder(3,276),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(1, true),
),
// AExp155
appBuilder( // 279
prmBuilder("+"),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp156
appBuilder( // 280
comBuilder(3,251),
ptrBuilder(0, true, true),
comBuilder(1,279),
),
appBuilder( // 281
comBuilder(3,278),
argBuilder(0, true),
),
// AExp157
appBuilder( // 282
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 283
argBuilder(1, true),
argBuilder(2, true),
),
// AExp158
appBuilder( // 284
argBuilder(1, true),
ptrBuilder(1, true, true),
argBuilder(3, false),
ptrBuilder(0, true, true),
),
appBuilder( // 285
prmBuilder("+"),
argBuilder(0, true),
argBuilder(3, false),
),
appBuilder( // 286
prmBuilder("-"),
argBuilder(2, true),
intBuilder(1),
),
// AExp159
appBuilder( // 287
prmBuilder("=="),
argBuilder(1, false),
intBuilder(0),
comBuilder(4,284),
comBuilder(4,0),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
  )
  private def combChunk009: Seq[Vec[Atom]] = Seq(
// AExp160
appBuilder( // 288
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 289
comBuilder(3,287),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp161
appBuilder( // 290
yBuilder(),
comBuilder(3,288),
argBuilder(0, true),
intBuilder(0),
intBuilder(1),
),
// AExp162
appBuilder( // 291
prmBuilder(">"),
argBuilder(0, true),
intBuilder(32),
),
// AExp163
appBuilder( // 292
comBuilder(2,323),
ptrBuilder(0, true, true),
),
appBuilder( // 293
comBuilder(1,335),
argBuilder(0, true),
),
// AExp164
appBuilder( // 294
comBuilder(1,301),
ptrBuilder(0, true, true),
),
appBuilder( // 295
comBuilder(1,292),
argBuilder(0, true),
),
// AExp165
appBuilder( // 296
comBuilder(2,0),
),
// AExp166
appBuilder( // 297
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 298
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 299
argBuilder(2, true),
argBuilder(0, true),
),
// AExp167
appBuilder( // 300
argBuilder(2, true),
comBuilder(2,296),
comBuilder(4,297),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp168
appBuilder( // 301
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 302
comBuilder(3,300),
argBuilder(0, true),
),
// AExp169
appBuilder( // 303
prmBuilder("+"),
intBuilder(65),
ptrBuilder(0, true, true),
),
appBuilder( // 304
comBuilder(2,327),
argBuilder(0, true),
intBuilder(26),
),
// AExp170
appBuilder( // 305
prmBuilder("+"),
ptrBuilder(0, true, true),
),
appBuilder( // 306
prmBuilder("-"),
argBuilder(0, true),
intBuilder(65),
),
// AExp171
appBuilder( // 307
comBuilder(1,303),
ptrBuilder(0, true, true),
),
appBuilder( // 308
comBuilder(1,305),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp172
appBuilder( // 309
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 310
comBuilder(2,307),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp173
appBuilder( // 311
prmBuilder("+"),
intBuilder(97),
ptrBuilder(0, true, true),
),
appBuilder( // 312
comBuilder(2,327),
argBuilder(0, true),
intBuilder(26),
),
// AExp174
appBuilder( // 313
prmBuilder("+"),
ptrBuilder(0, true, true),
),
appBuilder( // 314
prmBuilder("-"),
argBuilder(0, true),
intBuilder(97),
),
// AExp175
appBuilder( // 315
comBuilder(1,311),
ptrBuilder(0, true, true),
),
appBuilder( // 316
comBuilder(1,313),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp176
appBuilder( // 317
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 318
comBuilder(2,315),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp177
appBuilder( // 319
comBuilder(1,110),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
comBuilder(3,24),
comBuilder(3,317),
argBuilder(1, false),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk010: Seq[Vec[Atom]] = Seq(
appBuilder( // 320
comBuilder(1,0),
argBuilder(1, false),
),
appBuilder( // 321
prmBuilder("<="),
argBuilder(1, false),
intBuilder(122),
),
appBuilder( // 322
prmBuilder(">="),
argBuilder(1, false),
intBuilder(97),
),
// AExp178
appBuilder( // 323
comBuilder(1,110),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
comBuilder(3,24),
comBuilder(3,309),
argBuilder(1, false),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 324
comBuilder(2,319),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 325
prmBuilder("<="),
argBuilder(1, false),
intBuilder(90),
),
appBuilder( // 326
prmBuilder(">="),
argBuilder(1, false),
intBuilder(65),
),
// AExp179
appBuilder( // 327
comBuilder(1,280),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp180
appBuilder( // 328
prmBuilder("-"),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 329
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp181
appBuilder( // 330
comBuilder(2,327),
ptrBuilder(0, true, true),
intBuilder(26),
),
appBuilder( // 331
comBuilder(1,328),
argBuilder(0, true),
),
// AExp182
appBuilder( // 332
prmBuilder("-"),
intBuilder(25),
ptrBuilder(0, true, true),
),
appBuilder( // 333
comBuilder(1,330),
argBuilder(0, true),
),
// AExp183
appBuilder( // 334
comBuilder(2,327),
argBuilder(0, true),
intBuilder(26),
),
// AExp184
appBuilder( // 335
prmBuilder(">="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,332),
comBuilder(1,334),
argBuilder(0, false),
),
// AExp185
appBuilder( // 336
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(233, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 337
comBuilder(2,585),
intBuilder(0),
argBuilder(0, true),
),
// AExp186
appBuilder( // 338
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 339
ptrBuilder(132, false, false),
argBuilder(0, false),
intBuilder(49),
intBuilder(39),
comBuilder(2,1),
),
appBuilder( // 340
comBuilder(1,336),
argBuilder(0, false),
),
// AExp187
appBuilder( // 341
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 342
ptrBuilder(144, false, false),
comBuilder(2,0),
intBuilder(0),
),
appBuilder( // 343
comBuilder(1,338),
argBuilder(0, true),
),
// AExp188
appBuilder( // 344
comBuilder(3,688),
ptrBuilder(0, true, true),
intBuilder(3000),
argBuilder(0, true),
),
appBuilder( // 345
comBuilder(7,842),
argBuilder(1, true),
intBuilder(49),
intBuilder(39),
comBuilder(2,0),
intBuilder(0),
comBuilder(3,0),
),
// AExp189
appBuilder( // 346
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 347
comBuilder(2,344),
argBuilder(0, true),
ptrBuilder(213, false, false),
),
appBuilder( // 348
comBuilder(1,341),
ptrBuilder(213, false, false),
),
// AExp190
appBuilder( // 349
comBuilder(2,0),
),
// AExp191
appBuilder( // 350
comBuilder(2,354),
ptrBuilder(0, true, true),
),
appBuilder( // 351
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
  )
  private def combChunk011: Seq[Vec[Atom]] = Seq(
// AExp192
appBuilder( // 352
comBuilder(4,3),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 353
comBuilder(1,350),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp193
appBuilder( // 354
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,0),
comBuilder(1,349),
ptrBuilder(0, true, true),
),
appBuilder( // 355
comBuilder(2,352),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp194
appBuilder( // 356
argBuilder(0, true),
intBuilder(0),
intBuilder(0),
intBuilder(0),
intBuilder(0),
),
// AExp195
appBuilder( // 357
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 358
comBuilder(1,471),
argBuilder(1, true),
),
appBuilder( // 359
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp196
appBuilder( // 360
comBuilder(1,471),
ptrBuilder(0, true, true),
),
appBuilder( // 361
comBuilder(1,499),
argBuilder(0, true),
),
// AExp197
appBuilder( // 362
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 363
comBuilder(1,360),
argBuilder(2, true),
),
appBuilder( // 364
argBuilder(0, true),
argBuilder(1, true),
),
// AExp198
appBuilder( // 365
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 366
comBuilder(1,471),
argBuilder(1, true),
),
appBuilder( // 367
argBuilder(0, true),
argBuilder(2, true),
),
// AExp199
appBuilder( // 368
comBuilder(1,4),
ptrBuilder(18, false, false),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 369
comBuilder(1,471),
argBuilder(1, true),
),
// AExp200
appBuilder( // 370
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 371
comBuilder(1,471),
argBuilder(0, true),
),
appBuilder( // 372
ptrBuilder(123, false, false),
intBuilder(82),
intBuilder(1),
),
// AExp201
appBuilder( // 373
comBuilder(4,3),
intBuilder(27),
ptrBuilder(0, true, true),
),
appBuilder( // 374
comBuilder(4,3),
intBuilder(91),
argBuilder(0, true),
),
// AExp202
appBuilder( // 375
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 376
comBuilder(4,3),
intBuilder(82),
argBuilder(1, true),
),
appBuilder( // 377
comBuilder(4,3),
intBuilder(80),
argBuilder(0, true),
),
// AExp203
appBuilder( // 378
comBuilder(4,3),
intBuilder(65),
ptrBuilder(0, true, true),
),
appBuilder( // 379
comBuilder(4,3),
intBuilder(85),
argBuilder(0, true),
),
// AExp204
appBuilder( // 380
comBuilder(4,3),
intBuilder(83),
ptrBuilder(0, true, true),
),
appBuilder( // 381
comBuilder(4,3),
intBuilder(69),
argBuilder(0, true),
),
// AExp205
appBuilder( // 382
comBuilder(4,3),
intBuilder(85),
ptrBuilder(0, true, true),
),
appBuilder( // 383
comBuilder(4,3),
intBuilder(78),
argBuilder(0, true),
),
  )
  private def combChunk012: Seq[Vec[Atom]] = Seq(
// AExp206
appBuilder( // 384
comBuilder(4,3),
intBuilder(78),
ptrBuilder(0, true, true),
),
appBuilder( // 385
comBuilder(4,3),
intBuilder(73),
argBuilder(0, true),
),
// AExp207
appBuilder( // 386
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 387
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp208
appBuilder( // 388
comBuilder(4,3),
intBuilder(71),
ptrBuilder(0, true, true),
),
appBuilder( // 389
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp209
appBuilder( // 390
comBuilder(4,3),
intBuilder(110),
ptrBuilder(0, true, true),
),
appBuilder( // 391
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp210
appBuilder( // 392
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 393
comBuilder(4,3),
intBuilder(97),
argBuilder(0, true),
),
// AExp211
appBuilder( // 394
comBuilder(4,3),
intBuilder(116),
ptrBuilder(0, true, true),
),
appBuilder( // 395
comBuilder(4,3),
intBuilder(105),
argBuilder(0, true),
),
// AExp212
appBuilder( // 396
comBuilder(4,3),
intBuilder(111),
ptrBuilder(0, true, true),
),
appBuilder( // 397
comBuilder(4,3),
intBuilder(110),
argBuilder(0, true),
),
// AExp213
appBuilder( // 398
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 399
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp214
appBuilder( // 400
comBuilder(4,3),
intBuilder(97),
ptrBuilder(0, true, true),
),
appBuilder( // 401
comBuilder(4,3),
intBuilder(114),
argBuilder(0, true),
),
// AExp215
appBuilder( // 402
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 403
comBuilder(4,3),
intBuilder(111),
argBuilder(0, true),
),
// AExp216
appBuilder( // 404
comBuilder(4,3),
intBuilder(119),
ptrBuilder(0, true, true),
),
appBuilder( // 405
comBuilder(4,3),
intBuilder(115),
argBuilder(0, true),
),
// AExp217
appBuilder( // 406
comBuilder(4,3),
intBuilder(47),
ptrBuilder(0, true, true),
),
appBuilder( // 407
comBuilder(4,3),
intBuilder(104),
argBuilder(0, true),
),
// AExp218
appBuilder( // 408
comBuilder(4,3),
intBuilder(106),
ptrBuilder(0, true, true),
),
appBuilder( // 409
comBuilder(4,3),
intBuilder(107),
argBuilder(0, true),
),
// AExp219
appBuilder( // 410
comBuilder(4,3),
intBuilder(108),
ptrBuilder(0, true, true),
),
appBuilder( // 411
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp220
appBuilder( // 412
comBuilder(4,3),
intBuilder(109),
ptrBuilder(0, true, true),
),
appBuilder( // 413
comBuilder(4,3),
intBuilder(111),
argBuilder(0, true),
),
// AExp221
appBuilder( // 414
comBuilder(4,3),
intBuilder(118),
ptrBuilder(0, true, true),
),
appBuilder( // 415
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
  )
  private def combChunk013: Seq[Vec[Atom]] = Seq(
// AExp222
appBuilder( // 416
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 417
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp223
appBuilder( // 418
comBuilder(4,3),
intBuilder(111),
ptrBuilder(0, true, true),
),
appBuilder( // 419
comBuilder(4,3),
intBuilder(47),
argBuilder(0, true),
),
// AExp224
appBuilder( // 420
comBuilder(4,3),
intBuilder(45),
ptrBuilder(0, true, true),
),
appBuilder( // 421
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp225
appBuilder( // 422
comBuilder(4,3),
intBuilder(101),
ptrBuilder(0, true, true),
),
appBuilder( // 423
comBuilder(4,3),
intBuilder(100),
argBuilder(0, true),
),
// AExp226
appBuilder( // 424
comBuilder(4,3),
intBuilder(105),
ptrBuilder(0, true, true),
),
appBuilder( // 425
comBuilder(4,3),
intBuilder(116),
argBuilder(0, true),
),
// AExp227
appBuilder( // 426
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 427
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp228
appBuilder( // 428
comBuilder(4,3),
intBuilder(83),
ptrBuilder(0, true, true),
),
appBuilder( // 429
comBuilder(4,3),
intBuilder(80),
argBuilder(0, true),
),
// AExp229
appBuilder( // 430
comBuilder(4,3),
intBuilder(65),
ptrBuilder(0, true, true),
),
appBuilder( // 431
comBuilder(4,3),
intBuilder(67),
argBuilder(0, true),
),
// AExp230
appBuilder( // 432
comBuilder(4,3),
intBuilder(69),
ptrBuilder(0, true, true),
),
appBuilder( // 433
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp231
appBuilder( // 434
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 435
comBuilder(4,3),
intBuilder(117),
argBuilder(0, true),
),
// AExp232
appBuilder( // 436
comBuilder(4,3),
intBuilder(110),
ptrBuilder(0, true, true),
),
appBuilder( // 437
comBuilder(4,3),
intBuilder(47),
argBuilder(0, true),
),
// AExp233
appBuilder( // 438
comBuilder(4,3),
intBuilder(112),
ptrBuilder(0, true, true),
),
appBuilder( // 439
comBuilder(4,3),
intBuilder(97),
argBuilder(0, true),
),
// AExp234
appBuilder( // 440
comBuilder(4,3),
intBuilder(117),
ptrBuilder(0, true, true),
),
appBuilder( // 441
comBuilder(4,3),
intBuilder(115),
argBuilder(0, true),
),
// AExp235
appBuilder( // 442
comBuilder(4,3),
intBuilder(101),
ptrBuilder(0, true, true),
),
appBuilder( // 443
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp236
appBuilder( // 444
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 445
comBuilder(4,3),
intBuilder(103),
argBuilder(0, true),
),
// AExp237
appBuilder( // 446
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 447
comBuilder(4,3),
intBuilder(103),
argBuilder(0, true),
),
  )
  private def combChunk014: Seq[Vec[Atom]] = Seq(
// AExp238
appBuilder( // 448
comBuilder(4,3),
intBuilder(108),
ptrBuilder(0, true, true),
),
appBuilder( // 449
comBuilder(4,3),
intBuilder(105),
argBuilder(0, true),
),
// AExp239
appBuilder( // 450
comBuilder(4,3),
intBuilder(100),
ptrBuilder(0, true, true),
),
appBuilder( // 451
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp240
appBuilder( // 452
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 453
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp241
appBuilder( // 454
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 455
comBuilder(4,3),
intBuilder(99),
argBuilder(0, true),
),
// AExp242
appBuilder( // 456
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 457
comBuilder(4,3),
intBuilder(99),
argBuilder(0, true),
),
// AExp243
appBuilder( // 458
comBuilder(4,3),
intBuilder(108),
ptrBuilder(0, true, true),
),
appBuilder( // 459
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp244
appBuilder( // 460
comBuilder(4,3),
intBuilder(97),
ptrBuilder(0, true, true),
),
appBuilder( // 461
comBuilder(4,3),
intBuilder(114),
argBuilder(0, true),
),
// AExp245
appBuilder( // 462
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 463
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp246
appBuilder( // 464
comBuilder(4,3),
intBuilder(113),
ptrBuilder(0, true, true),
),
appBuilder( // 465
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp247
appBuilder( // 466
comBuilder(4,3),
intBuilder(113),
ptrBuilder(0, true, true),
),
appBuilder( // 467
comBuilder(4,3),
intBuilder(117),
argBuilder(0, true),
),
// AExp248
appBuilder( // 468
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 469
comBuilder(1,471),
argBuilder(1, true),
),
appBuilder( // 470
ptrBuilder(55, false, false),
argBuilder(0, true),
),
// AExp249
appBuilder( // 471
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,468),
),
appBuilder( // 472
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp250
appBuilder( // 473
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 474
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp251
appBuilder( // 475
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 476
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 477
comBuilder(1,4),
ptrBuilder(18, false, false),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp252
appBuilder( // 478
comBuilder(1,471),
ptrBuilder(0, true, true),
),
appBuilder( // 479
comBuilder(1,499),
argBuilder(0, true),
),
  )
  private def combChunk015: Seq[Vec[Atom]] = Seq(
// AExp253
appBuilder( // 480
comBuilder(4,475),
ptrBuilder(0, true, true),
argBuilder(1, true),
comBuilder(1,478),
),
appBuilder( // 481
argBuilder(0, true),
argBuilder(2, true),
),
// AExp254
appBuilder( // 482
comBuilder(1,471),
ptrBuilder(0, true, true),
),
appBuilder( // 483
comBuilder(1,499),
argBuilder(0, true),
),
// AExp255
appBuilder( // 484
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 485
comBuilder(1,482),
argBuilder(1, true),
),
appBuilder( // 486
comBuilder(1,471),
argBuilder(0, true),
),
// AExp256
appBuilder( // 487
comBuilder(4,3),
ptrBuilder(0, true, true),
),
appBuilder( // 488
comBuilder(1,0),
argBuilder(0, true),
),
// AExp257
appBuilder( // 489
prmBuilder("+"),
intBuilder(48),
ptrBuilder(0, true, true),
),
appBuilder( // 490
argBuilder(0, true),
comBuilder(2,1),
),
// AExp258
appBuilder( // 491
comBuilder(1,487),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 492
comBuilder(1,489),
argBuilder(1, true),
),
// AExp259
appBuilder( // 493
prmBuilder("=="),
argBuilder(3, false),
intBuilder(0),
comBuilder(3,253),
comBuilder(3,0),
ptrBuilder(0, true, true),
argBuilder(0, true),
argBuilder(3, false),
),
appBuilder( // 494
comBuilder(2,491),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp260
appBuilder( // 495
argBuilder(0, true),
comBuilder(2,0),
),
// AExp261
appBuilder( // 496
comBuilder(3,251),
ptrBuilder(1, true, true),
comBuilder(1,495),
ptrBuilder(0, true, true),
),
appBuilder( // 497
comBuilder(1,280),
argBuilder(1, true),
intBuilder(10),
),
appBuilder( // 498
comBuilder(4,493),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp262
appBuilder( // 499
yBuilder(),
comBuilder(3,496),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp263
appBuilder( // 500
comBuilder(1,25),
argBuilder(0, true),
comBuilder(1,0),
),
// AExp264
appBuilder( // 501
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 502
argBuilder(5, false),
comBuilder(1,500),
argBuilder(1, true),
ptrBuilder(18, false, false),
),
appBuilder( // 503
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
),
// AExp265
appBuilder( // 504
comBuilder(1,524),
ptrBuilder(0, true, true),
),
appBuilder( // 505
comBuilder(3,542),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp266
appBuilder( // 506
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, false),
ptrBuilder(0, true, true),
),
appBuilder( // 507
comBuilder(3,504),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp267
appBuilder( // 508
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 509
ptrBuilder(55, false, false),
argBuilder(3, true),
),
appBuilder( // 510
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
),
// AExp268
appBuilder( // 511
ptrBuilder(123, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk016: Seq[Vec[Atom]] = Seq(
appBuilder( // 512
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
appBuilder( // 513
prmBuilder("+"),
argBuilder(1, true),
intBuilder(2),
),
// AExp269
appBuilder( // 514
comBuilder(1,25),
argBuilder(0, true),
comBuilder(1,0),
),
// AExp270
appBuilder( // 515
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 516
argBuilder(3, true),
comBuilder(1,514),
argBuilder(0, true),
ptrBuilder(18, false, false),
),
appBuilder( // 517
comBuilder(2,511),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp271
appBuilder( // 518
comBuilder(1,471),
argBuilder(0, true),
),
// AExp272
appBuilder( // 519
comBuilder(4,3),
intBuilder(27),
ptrBuilder(0, true, true),
),
appBuilder( // 520
comBuilder(4,3),
intBuilder(91),
argBuilder(0, true),
),
// AExp273
appBuilder( // 521
comBuilder(1,471),
argBuilder(0, true),
),
// AExp274
appBuilder( // 522
comBuilder(4,3),
intBuilder(27),
ptrBuilder(0, true, true),
),
appBuilder( // 523
comBuilder(4,3),
intBuilder(91),
argBuilder(0, true),
),
// AExp275
appBuilder( // 524
prmBuilder("=="),
argBuilder(0, true),
intBuilder(1),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 525
comBuilder(1,0),
intBuilder(111),
),
appBuilder( // 526
comBuilder(1,0),
intBuilder(45),
),
// AExp276
appBuilder( // 527
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 528
prmBuilder(">="),
argBuilder(0, false),
intBuilder(80),
),
appBuilder( // 529
prmBuilder("<"),
argBuilder(0, false),
intBuilder(0),
),
// AExp277
appBuilder( // 530
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 531
comBuilder(1,527),
argBuilder(1, true),
),
appBuilder( // 532
prmBuilder(">="),
argBuilder(0, true),
intBuilder(100),
),
// AExp278
appBuilder( // 533
intBuilder(0),
),
// AExp279
appBuilder( // 534
intBuilder(0),
),
// AExp280
appBuilder( // 535
prmBuilder("=="),
intBuilder(0),
argBuilder(5, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(6, false),
),
appBuilder( // 536
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp281
appBuilder( // 537
comBuilder(2,562),
),
// AExp282
appBuilder( // 538
comBuilder(3,542),
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 539
prmBuilder("-"),
argBuilder(1, true),
intBuilder(1),
),
// AExp283
appBuilder( // 540
argBuilder(0, true),
comBuilder(2,534),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(1, true),
),
appBuilder( // 541
comBuilder(7,535),
comBuilder(3,0),
comBuilder(1,537),
comBuilder(3,538),
),
// AExp284
appBuilder( // 542
comBuilder(1,112),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
comBuilder(1,0),
comBuilder(1,533),
ptrBuilder(0, true, true),
),
appBuilder( // 543
comBuilder(3,540),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
),
  )
  private def combChunk017: Seq[Vec[Atom]] = Seq(
appBuilder( // 544
comBuilder(2,530),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 545
prmBuilder("<"),
argBuilder(1, false),
intBuilder(0),
),
// AExp285
appBuilder( // 546
intBuilder(0),
),
// AExp286
appBuilder( // 547
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 548
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp287
appBuilder( // 549
comBuilder(2,568),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 550
prmBuilder("-"),
argBuilder(1, true),
intBuilder(75),
),
// AExp288
appBuilder( // 551
comBuilder(2,568),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 552
prmBuilder("-"),
argBuilder(1, true),
intBuilder(50),
),
// AExp289
appBuilder( // 553
prmBuilder("<"),
argBuilder(1, false),
intBuilder(75),
comBuilder(3,549),
comBuilder(3,551),
argBuilder(2, true),
argBuilder(1, false),
),
// AExp290
appBuilder( // 554
comBuilder(2,568),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 555
prmBuilder("-"),
argBuilder(1, true),
intBuilder(25),
),
// AExp291
appBuilder( // 556
prmBuilder("<"),
argBuilder(0, false),
intBuilder(50),
comBuilder(3,553),
comBuilder(4,554),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp292
appBuilder( // 557
comBuilder(2,568),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp293
appBuilder( // 558
prmBuilder("<"),
argBuilder(0, false),
intBuilder(25),
ptrBuilder(0, true, true),
comBuilder(5,557),
argBuilder(1, true),
argBuilder(0, false),
),
appBuilder( // 559
comBuilder(7,547),
comBuilder(3,282),
comBuilder(2,556),
comBuilder(1,0),
),
// AExp294
appBuilder( // 560
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 561
comBuilder(2,558),
argBuilder(1, true),
),
// AExp295
appBuilder( // 562
comBuilder(1,112),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
comBuilder(1,0),
comBuilder(1,546),
ptrBuilder(0, true, true),
),
appBuilder( // 563
comBuilder(2,560),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 564
prmBuilder(">="),
argBuilder(1, false),
intBuilder(100),
),
appBuilder( // 565
prmBuilder("<"),
argBuilder(1, false),
intBuilder(0),
),
// AExp296
appBuilder( // 566
comBuilder(2,570),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 567
comBuilder(1,575),
argBuilder(1, true),
),
// AExp297
appBuilder( // 568
comBuilder(2,327),
ptrBuilder(0, true, true),
intBuilder(2),
),
appBuilder( // 569
comBuilder(2,566),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp298
appBuilder( // 570
comBuilder(1,280),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp299
appBuilder( // 571
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 572
prmBuilder("+"),
argBuilder(0, false),
argBuilder(0, false),
),
appBuilder( // 573
prmBuilder("-"),
argBuilder(2, true),
intBuilder(1),
),
// AExp300
appBuilder( // 574
prmBuilder("=="),
argBuilder(1, false),
intBuilder(0),
comBuilder(3,571),
comBuilder(3,0),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp301
appBuilder( // 575
yBuilder(),
comBuilder(3,574),
argBuilder(0, true),
intBuilder(1),
),
  )
  private def combChunk018: Seq[Vec[Atom]] = Seq(
// AExp302
appBuilder( // 576
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 577
comBuilder(1,471),
argBuilder(2, true),
),
appBuilder( // 578
ptrBuilder(123, false, false),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp303
appBuilder( // 579
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp304
appBuilder( // 580
comBuilder(2,585),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 581
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp305
appBuilder( // 582
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 583
comBuilder(2,580),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 584
comBuilder(2,588),
argBuilder(2, false),
argBuilder(0, true),
),
// AExp306
appBuilder( // 585
argBuilder(1, true),
comBuilder(1,579),
comBuilder(3,582),
argBuilder(0, true),
),
// AExp307
appBuilder( // 586
ptrBuilder(123, false, false),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 587
prmBuilder("+"),
argBuilder(0, true),
intBuilder(2),
),
// AExp308
appBuilder( // 588
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 589
comBuilder(1,600),
argBuilder(1, true),
),
appBuilder( // 590
comBuilder(1,586),
argBuilder(0, true),
),
// AExp309
appBuilder( // 591
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 592
comBuilder(2,612),
intBuilder(25),
argBuilder(1, true),
),
appBuilder( // 593
comBuilder(2,612),
intBuilder(25),
argBuilder(0, true),
),
// AExp310
appBuilder( // 594
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 595
comBuilder(2,612),
intBuilder(25),
argBuilder(2, true),
),
appBuilder( // 596
comBuilder(2,591),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp311
appBuilder( // 597
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 598
comBuilder(2,612),
intBuilder(25),
argBuilder(3, true),
),
appBuilder( // 599
comBuilder(3,594),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp312
appBuilder( // 600
argBuilder(0, true),
comBuilder(4,597),
),
// AExp313
appBuilder( // 601
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp314
appBuilder( // 602
comBuilder(1,524),
ptrBuilder(0, true, true),
),
appBuilder( // 603
comBuilder(2,327),
argBuilder(0, true),
intBuilder(2),
),
// AExp315
appBuilder( // 604
ptrBuilder(55, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 605
comBuilder(1,602),
argBuilder(0, true),
),
// AExp316
appBuilder( // 606
comBuilder(2,612),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 607
comBuilder(2,570),
argBuilder(1, true),
intBuilder(2),
),
  )
  private def combChunk019: Seq[Vec[Atom]] = Seq(
appBuilder( // 608
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp317
appBuilder( // 609
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 610
comBuilder(2,606),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 611
comBuilder(1,604),
argBuilder(1, false),
),
// AExp318
appBuilder( // 612
prmBuilder("=="),
intBuilder(0),
argBuilder(0, false),
comBuilder(1,0),
comBuilder(1,601),
ptrBuilder(0, true, true),
),
appBuilder( // 613
comBuilder(2,609),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp319
appBuilder( // 614
comBuilder(1,16),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 615
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, false),
argBuilder(5, true),
argBuilder(6, true),
),
appBuilder( // 616
argBuilder(4, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
),
// AExp320
appBuilder( // 617
comBuilder(7,614),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 618
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp321
appBuilder( // 619
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 620
comBuilder(3,138),
argBuilder(0, true),
),
// AExp322
appBuilder( // 621
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(48, false, false),
comBuilder(1,619),
),
// AExp323
appBuilder( // 622
ptrBuilder(207, false, false),
),
// AExp324
appBuilder( // 623
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 624
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp325
appBuilder( // 625
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp326
appBuilder( // 626
comBuilder(6,625),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 627
argBuilder(0, true),
argBuilder(3, true),
),
// AExp327
appBuilder( // 628
argBuilder(0, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp328
appBuilder( // 629
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 630
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp329
appBuilder( // 631
comBuilder(7,629),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp330
appBuilder( // 632
comBuilder(7,631),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 633
argBuilder(1, true),
argBuilder(5, true),
),
// AExp331
appBuilder( // 634
argBuilder(6, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 635
comBuilder(7,632),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp332
appBuilder( // 636
comBuilder(7,628),
ptrBuilder(0, true, true),
argBuilder(5, true),
),
appBuilder( // 637
comBuilder(7,634),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
),
// AExp333
appBuilder( // 638
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(1, true),
),
// AExp334
appBuilder( // 639
comBuilder(3,688),
argBuilder(5, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk020: Seq[Vec[Atom]] = Seq(
appBuilder( // 640
prmBuilder("-"),
argBuilder(6, true),
intBuilder(1),
),
// AExp335
appBuilder( // 641
comBuilder(7,639),
),
// AExp336
appBuilder( // 642
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 643
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 644
argBuilder(1, true),
argBuilder(3, false),
),
// AExp337
appBuilder( // 645
comBuilder(7,642),
argBuilder(0, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 646
ptrBuilder(209, false, false),
argBuilder(3, true),
),
appBuilder( // 647
argBuilder(2, true),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, true),
),
appBuilder( // 648
argBuilder(1, true),
argBuilder(4, false),
argBuilder(5, false),
),
// AExp338
appBuilder( // 649
comBuilder(7,645),
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(5, false),
),
appBuilder( // 650
argBuilder(1, true),
argBuilder(6, false),
),
appBuilder( // 651
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp339
appBuilder( // 652
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 653
argBuilder(2, true),
argBuilder(5, true),
),
appBuilder( // 654
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp340
appBuilder( // 655
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 656
ptrBuilder(132, false, false),
argBuilder(4, false),
argBuilder(2, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 657
comBuilder(3,825),
intBuilder(0),
argBuilder(1, true),
argBuilder(4, false),
),
// AExp341
appBuilder( // 658
ptrBuilder(144, false, false),
comBuilder(2,1),
ptrBuilder(0, true, true),
),
appBuilder( // 659
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp342
appBuilder( // 660
comBuilder(7,652),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,658),
),
appBuilder( // 661
comBuilder(5,655),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp343
appBuilder( // 662
comBuilder(3,688),
ptrBuilder(0, true, true),
intBuilder(3000),
comBuilder(2,0),
),
appBuilder( // 663
argBuilder(0, true),
argBuilder(1, true),
),
// AExp344
appBuilder( // 664
comBuilder(7,842),
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 665
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp345
appBuilder( // 666
comBuilder(2,662),
ptrBuilder(0, true, true),
),
appBuilder( // 667
comBuilder(5,664),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp346
appBuilder( // 668
comBuilder(1,110),
argBuilder(0, true),
ptrBuilder(1, true, true),
comBuilder(3,641),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 669
comBuilder(7,649),
comBuilder(3,660),
comBuilder(4,666),
),
appBuilder( // 670
prmBuilder("<="),
argBuilder(1, true),
intBuilder(0),
),
// AExp347
appBuilder( // 671
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
  )
  private def combChunk021: Seq[Vec[Atom]] = Seq(
appBuilder( // 672
comBuilder(2,668),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp348
appBuilder( // 673
comBuilder(7,638),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 674
comBuilder(2,671),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
),
// AExp349
appBuilder( // 675
comBuilder(3,688),
argBuilder(0, true),
intBuilder(3000),
comBuilder(2,0),
),
// AExp350
appBuilder( // 676
argBuilder(0, true),
ptrBuilder(214, false, false),
comBuilder(1,675),
),
// AExp351
appBuilder( // 677
comBuilder(1,16),
argBuilder(2, true),
ptrBuilder(0, true, true),
comBuilder(1,676),
),
appBuilder( // 678
ptrBuilder(210, false, false),
argBuilder(0, true),
argBuilder(3, true),
),
// AExp352
appBuilder( // 679
comBuilder(3,688),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp353
appBuilder( // 680
comBuilder(1,110),
argBuilder(2, true),
ptrBuilder(0, true, true),
comBuilder(4,677),
comBuilder(4,679),
argBuilder(1, true),
argBuilder(0, true),
ptrBuilder(18, false, false),
),
appBuilder( // 681
prmBuilder("=="),
argBuilder(3, true),
intBuilder(10),
),
// AExp354
appBuilder( // 682
comBuilder(4,217),
ptrBuilder(0, true, true),
),
appBuilder( // 683
comBuilder(7,636),
comBuilder(3,673),
comBuilder(3,251),
comBuilder(4,680),
comBuilder(1,0),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp355
appBuilder( // 684
comBuilder(7,623),
comBuilder(4,626),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 685
comBuilder(2,682),
argBuilder(1, true),
),
// AExp356
appBuilder( // 686
comBuilder(7,617),
comBuilder(1,621),
comBuilder(1,622),
ptrBuilder(0, true, true),
),
appBuilder( // 687
comBuilder(2,684),
argBuilder(0, true),
),
// AExp357
appBuilder( // 688
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 689
comBuilder(1,686),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp358
appBuilder( // 690
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 691
comBuilder(1,0),
argBuilder(0, true),
),
// AExp359
appBuilder( // 692
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 693
comBuilder(1,690),
argBuilder(0, true),
),
// AExp360
appBuilder( // 694
comBuilder(1,16),
argBuilder(1, true),
ptrBuilder(0, true, true),
comBuilder(1,692),
),
appBuilder( // 695
ioBuilder(false),
intBuilder(0),
),
// AExp361
appBuilder( // 696
comBuilder(1,25),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp362
appBuilder( // 697
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(0),
comBuilder(2,694),
comBuilder(2,696),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 698
comBuilder(2,327),
argBuilder(0, true),
intBuilder(2),
),
// AExp363
appBuilder( // 699
yBuilder(),
argBuilder(0, true),
comBuilder(1,356),
),
// AExp364
appBuilder( // 700
comBuilder(2,0),
),
// AExp365
appBuilder( // 701
comBuilder(3,711),
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 702
argBuilder(1, true),
comBuilder(1,356),
comBuilder(2,0),
),
// AExp366
appBuilder( // 703
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk022: Seq[Vec[Atom]] = Seq(
appBuilder( // 704
argBuilder(3, true),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 705
comBuilder(3,701),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(2, true),
),
// AExp367
appBuilder( // 706
argBuilder(2, true),
comBuilder(2,700),
comBuilder(4,703),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp368
appBuilder( // 707
comBuilder(2,791),
intBuilder(0),
intBuilder(0),
intBuilder(0),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 708
comBuilder(1,800),
argBuilder(2, true),
),
appBuilder( // 709
comBuilder(1,800),
argBuilder(1, true),
),
appBuilder( // 710
comBuilder(1,800),
argBuilder(0, true),
),
// AExp369
appBuilder( // 711
comBuilder(1,720),
ptrBuilder(0, true, true),
),
appBuilder( // 712
comBuilder(3,707),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp370
appBuilder( // 713
argBuilder(5, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp371
appBuilder( // 714
comBuilder(1,732),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(3, true),
ptrBuilder(0, true, true),
),
appBuilder( // 715
comBuilder(6,713),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp372
appBuilder( // 716
comBuilder(1,732),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 717
comBuilder(4,714),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp373
appBuilder( // 718
comBuilder(1,732),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 719
comBuilder(3,716),
argBuilder(0, true),
),
// AExp374
appBuilder( // 720
comBuilder(1,732),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(0, true),
comBuilder(2,718),
),
// AExp375
appBuilder( // 721
prmBuilder("=="),
intBuilder(0),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 722
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp376
appBuilder( // 723
argBuilder(3, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp377
appBuilder( // 724
argBuilder(3, true),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp378
appBuilder( // 725
prmBuilder("+"),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 726
prmBuilder("*"),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp379
appBuilder( // 727
comBuilder(1,732),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 728
comBuilder(3,725),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(4, false),
),
appBuilder( // 729
prmBuilder("+"),
argBuilder(4, false),
argBuilder(4, false),
),
appBuilder( // 730
prmBuilder("-"),
argBuilder(3, true),
intBuilder(1),
),
// AExp380
appBuilder( // 731
argBuilder(3, true),
comBuilder(4,724),
comBuilder(5,727),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp381
appBuilder( // 732
comBuilder(7,721),
comBuilder(3,0),
comBuilder(4,723),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 733
comBuilder(4,731),
argBuilder(0, false),
),
// AExp382
appBuilder( // 734
argBuilder(4, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 735
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, false),
argBuilder(5, true),
argBuilder(6, true),
),
  )
  private def combChunk023: Seq[Vec[Atom]] = Seq(
// AExp383
appBuilder( // 736
comBuilder(2,0),
),
// AExp384
appBuilder( // 737
argBuilder(5, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 738
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, true),
),
// AExp385
appBuilder( // 739
comBuilder(2,0),
),
// AExp386
appBuilder( // 740
argBuilder(6, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 741
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
argBuilder(3, true),
),
// AExp387
appBuilder( // 742
comBuilder(2,0),
),
// AExp388
appBuilder( // 743
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
errorBuilder(0),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp389
appBuilder( // 744
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(1, true),
),
// AExp390
appBuilder( // 745
comBuilder(7,0),
argBuilder(0, true),
),
// AExp391
appBuilder( // 746
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, false),
ptrBuilder(0, true, true),
),
appBuilder( // 747
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp392
appBuilder( // 748
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 749
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 750
argBuilder(0, true),
argBuilder(2, false),
argBuilder(6, true),
),
// AExp393
appBuilder( // 751
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 752
prmBuilder("=="),
argBuilder(1, true),
intBuilder(2),
),
appBuilder( // 753
prmBuilder("=="),
argBuilder(0, true),
intBuilder(1),
),
// AExp394
appBuilder( // 754
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(0),
intBuilder(1),
),
appBuilder( // 755
comBuilder(2,751),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 756
prmBuilder("=="),
argBuilder(1, false),
intBuilder(3),
),
// AExp395
appBuilder( // 757
comBuilder(7,746),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 758
argBuilder(1, true),
argBuilder(4, false),
),
appBuilder( // 759
comBuilder(7,748),
comBuilder(2,754),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, false),
),
// AExp396
appBuilder( // 760
comBuilder(2,791),
argBuilder(3, true),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
),
// AExp397
appBuilder( // 761
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 762
comBuilder(1,793),
argBuilder(1, true),
),
appBuilder( // 763
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp398
appBuilder( // 764
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 765
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp399
appBuilder( // 766
prmBuilder("+"),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 767
prmBuilder("+"),
argBuilder(0, true),
argBuilder(2, true),
),
  )
  private def combChunk024: Seq[Vec[Atom]] = Seq(
// AExp400
appBuilder( // 768
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 769
comBuilder(1,793),
argBuilder(1, true),
),
appBuilder( // 770
prmBuilder("+"),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp401
appBuilder( // 771
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 772
comBuilder(1,793),
argBuilder(1, true),
),
appBuilder( // 773
prmBuilder("+"),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp402
appBuilder( // 774
comBuilder(3,768),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 775
comBuilder(3,771),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp403
appBuilder( // 776
comBuilder(7,764),
comBuilder(3,766),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 777
comBuilder(4,774),
argBuilder(1, true),
),
// AExp404
appBuilder( // 778
comBuilder(7,761),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 779
comBuilder(2,776),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp405
appBuilder( // 780
comBuilder(5,757),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 781
comBuilder(3,778),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 782
comBuilder(6,760),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp406
appBuilder( // 783
argBuilder(2, true),
comBuilder(2,745),
comBuilder(2,780),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp407
appBuilder( // 784
comBuilder(5,744),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 785
comBuilder(3,783),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp408
appBuilder( // 786
argBuilder(3, true),
comBuilder(7,0),
comBuilder(3,784),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp409
appBuilder( // 787
comBuilder(7,740),
comBuilder(1,742),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 788
comBuilder(7,743),
comBuilder(6,0),
comBuilder(5,786),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp410
appBuilder( // 789
comBuilder(7,737),
comBuilder(1,739),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 790
comBuilder(2,787),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp411
appBuilder( // 791
comBuilder(7,734),
comBuilder(1,736),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 792
comBuilder(2,789),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp412
appBuilder( // 793
argBuilder(0, true),
intBuilder(0),
comBuilder(2,0),
),
// AExp413
appBuilder( // 794
comBuilder(3,807),
intBuilder(25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 795
comBuilder(3,807),
intBuilder(25),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp414
appBuilder( // 796
comBuilder(3,807),
intBuilder(25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 797
comBuilder(2,794),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp415
appBuilder( // 798
comBuilder(3,807),
intBuilder(25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 799
comBuilder(3,796),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
  )
  private def combChunk025: Seq[Vec[Atom]] = Seq(
// AExp416
appBuilder( // 800
argBuilder(0, true),
comBuilder(4,798),
),
// AExp417
appBuilder( // 801
comBuilder(3,807),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 802
comBuilder(2,570),
argBuilder(1, true),
intBuilder(2),
),
appBuilder( // 803
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp418
appBuilder( // 804
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 805
comBuilder(2,801),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
),
appBuilder( // 806
comBuilder(2,327),
argBuilder(1, false),
intBuilder(2),
),
// AExp419
appBuilder( // 807
prmBuilder("=="),
intBuilder(0),
argBuilder(0, false),
comBuilder(2,0),
comBuilder(2,1),
ptrBuilder(0, true, true),
argBuilder(2, false),
),
appBuilder( // 808
comBuilder(3,804),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp420
appBuilder( // 809
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp421
appBuilder( // 810
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp422
appBuilder( // 811
argBuilder(5, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(4, true),
argBuilder(2, true),
argBuilder(6, true),
argBuilder(3, true),
),
// AExp423
appBuilder( // 812
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 813
argBuilder(3, true),
argBuilder(5, false),
argBuilder(6, true),
),
appBuilder( // 814
comBuilder(2,840),
argBuilder(4, true),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(18, false, false),
argBuilder(5, false),
argBuilder(0, false),
),
// AExp424
appBuilder( // 815
comBuilder(2,588),
),
// AExp425
appBuilder( // 816
comBuilder(1,25),
argBuilder(0, true),
comBuilder(1,0),
),
// AExp426
appBuilder( // 817
comBuilder(3,825),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(0, true),
),
appBuilder( // 818
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp427
appBuilder( // 819
comBuilder(7,812),
argBuilder(0, true),
comBuilder(1,815),
comBuilder(3,816),
ptrBuilder(0, true, true),
),
appBuilder( // 820
comBuilder(3,817),
argBuilder(1, true),
),
// AExp428
appBuilder( // 821
argBuilder(1, true),
comBuilder(3,0),
ptrBuilder(0, true, true),
errorBuilder(0),
argBuilder(2, true),
argBuilder(0, true),
),
appBuilder( // 822
comBuilder(7,811),
comBuilder(4,0),
comBuilder(3,819),
),
// AExp429
appBuilder( // 823
argBuilder(2, false),
comBuilder(1,810),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 824
comBuilder(3,821),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp430
appBuilder( // 825
argBuilder(1, false),
comBuilder(1,809),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 826
comBuilder(3,823),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
),
// AExp431
appBuilder( // 827
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 828
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
appBuilder( // 829
prmBuilder("=="),
argBuilder(0, true),
argBuilder(3, true),
),
// AExp432
appBuilder( // 830
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 831
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(5, true),
argBuilder(6, true),
),
  )
  private def combChunk026: Seq[Vec[Atom]] = Seq(
appBuilder( // 832
prmBuilder("=="),
argBuilder(1, true),
argBuilder(4, true),
),
// AExp433
appBuilder( // 833
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 834
prmBuilder("=="),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 835
prmBuilder("=="),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp434
appBuilder( // 836
comBuilder(7,827),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 837
comBuilder(7,830),
comBuilder(4,833),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp435
appBuilder( // 838
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 839
comBuilder(3,836),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp436
appBuilder( // 840
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 841
comBuilder(5,838),
argBuilder(1, true),
),
// AExp437
appBuilder( // 842
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp438
appBuilder( // 843
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 844
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
),
// AExp439
appBuilder( // 845
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(6, true),
argBuilder(2, true),
),
appBuilder( // 846
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp440
appBuilder( // 847
argBuilder(0, true),
argBuilder(4, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(2, true),
),
// AExp441
appBuilder( // 848
comBuilder(7,845),
comBuilder(5,847),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 849
argBuilder(0, true),
argBuilder(2, true),
),
// AExp442
appBuilder( // 850
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 851
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp443
appBuilder( // 852
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 853
prmBuilder("=="),
argBuilder(4, true),
intBuilder(91),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(18, false, false),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp444
appBuilder( // 854
argBuilder(6, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 855
comBuilder(7,852),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 856
comBuilder(7,850),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp445
appBuilder( // 857
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
// AExp446
appBuilder( // 858
comBuilder(3,857),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
argBuilder(2, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 859
argBuilder(0, true),
argBuilder(1, true),
),
// AExp447
appBuilder( // 860
argBuilder(0, true),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 861
argBuilder(1, true),
argBuilder(2, true),
),
// AExp448
appBuilder( // 862
comBuilder(3,860),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 863
argBuilder(0, true),
argBuilder(2, true),
),
  )
  private def combChunk027: Seq[Vec[Atom]] = Seq(
// AExp449
appBuilder( // 864
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
// AExp450
appBuilder( // 865
comBuilder(4,864),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 866
argBuilder(0, true),
argBuilder(2, true),
),
// AExp451
appBuilder( // 867
argBuilder(0, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp452
appBuilder( // 868
comBuilder(7,867),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 869
argBuilder(0, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp453
appBuilder( // 870
comBuilder(7,868),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 871
argBuilder(0, true),
argBuilder(6, true),
),
// AExp454
appBuilder( // 872
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(2, true),
),
appBuilder( // 873
argBuilder(1, true),
argBuilder(3, true),
),
// AExp455
appBuilder( // 874
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
),
// AExp456
appBuilder( // 875
comBuilder(7,764),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
),
appBuilder( // 876
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp457
appBuilder( // 877
argBuilder(0, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp458
appBuilder( // 878
comBuilder(7,877),
ptrBuilder(0, true, true),
),
appBuilder( // 879
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp459
appBuilder( // 880
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 881
comBuilder(7,878),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp460
appBuilder( // 882
comBuilder(7,875),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
),
appBuilder( // 883
comBuilder(7,880),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp461
appBuilder( // 884
comBuilder(7,882),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 885
argBuilder(2, true),
argBuilder(6, true),
),
// AExp462
appBuilder( // 886
comBuilder(7,884),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 887
argBuilder(2, true),
argBuilder(6, true),
),
// AExp463
appBuilder( // 888
comBuilder(7,886),
comBuilder(3,65),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, false),
),
appBuilder( // 889
argBuilder(1, true),
argBuilder(4, false),
),
// AExp464
appBuilder( // 890
argBuilder(0, true),
argBuilder(4, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp465
appBuilder( // 891
comBuilder(5,890),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 892
argBuilder(0, true),
argBuilder(4, true),
),
// AExp466
appBuilder( // 893
prmBuilder("=="),
argBuilder(5, true),
intBuilder(104),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
),
appBuilder( // 894
comBuilder(7,547),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp467
appBuilder( // 895
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(6, false),
),
  )
  private def combChunk028: Seq[Vec[Atom]] = Seq(
appBuilder( // 896
comBuilder(7,893),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
),
// AExp468
appBuilder( // 897
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
),
// AExp469
appBuilder( // 898
comBuilder(7,764),
comBuilder(6,897),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 899
argBuilder(0, true),
argBuilder(2, true),
),
// AExp470
appBuilder( // 900
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 901
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp471
appBuilder( // 902
comBuilder(7,900),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp472
appBuilder( // 903
comBuilder(5,890),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 904
argBuilder(0, true),
argBuilder(4, true),
),
// AExp473
appBuilder( // 905
comBuilder(1,25),
argBuilder(5, true),
ptrBuilder(0, true, true),
),
appBuilder( // 906
comBuilder(3,138),
argBuilder(6, true),
),
// AExp474
appBuilder( // 907
comBuilder(7,905),
),
// AExp475
appBuilder( // 908
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 909
argBuilder(2, true),
argBuilder(3, false),
argBuilder(4, true),
ptrBuilder(213, false, false),
),
appBuilder( // 910
argBuilder(1, true),
argBuilder(3, false),
ptrBuilder(213, false, false),
),
// AExp476
appBuilder( // 911
comBuilder(1,4),
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 912
ptrBuilder(144, false, false),
comBuilder(2,0),
intBuilder(0),
),
appBuilder( // 913
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp477
appBuilder( // 914
comBuilder(7,908),
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 915
argBuilder(1, true),
argBuilder(6, false),
),
appBuilder( // 916
comBuilder(7,911),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
),
// AExp478
appBuilder( // 917
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 918
ptrBuilder(132, false, false),
argBuilder(4, false),
argBuilder(2, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 919
comBuilder(3,825),
intBuilder(0),
argBuilder(1, true),
argBuilder(4, false),
),
// AExp479
appBuilder( // 920
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 921
comBuilder(7,842),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
intBuilder(0),
comBuilder(3,0),
),
// AExp480
appBuilder( // 922
comBuilder(1,25),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 923
comBuilder(3,920),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp481
appBuilder( // 924
prmBuilder("=="),
argBuilder(0, true),
intBuilder(99),
comBuilder(2,907),
ptrBuilder(0, true, true),
),
appBuilder( // 925
comBuilder(7,914),
comBuilder(5,917),
comBuilder(4,922),
),
// AExp482
appBuilder( // 926
comBuilder(7,902),
comBuilder(5,903),
comBuilder(1,924),
),
// AExp483
appBuilder( // 927
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk029: Seq[Vec[Atom]] = Seq(
appBuilder( // 928
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 929
argBuilder(1, true),
argBuilder(3, false),
),
// AExp484
appBuilder( // 930
comBuilder(7,927),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 931
comBuilder(3,1191),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp485
appBuilder( // 932
comBuilder(7,930),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp486
appBuilder( // 933
comBuilder(7,932),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp487
appBuilder( // 934
comBuilder(7,933),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp488
appBuilder( // 935
comBuilder(7,934),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 936
argBuilder(2, true),
argBuilder(6, true),
),
// AExp489
appBuilder( // 937
comBuilder(7,935),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 938
argBuilder(2, true),
argBuilder(6, false),
),
appBuilder( // 939
argBuilder(1, true),
argBuilder(6, false),
),
// AExp490
appBuilder( // 940
comBuilder(7,937),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 941
argBuilder(2, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 942
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp491
appBuilder( // 943
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 944
ptrBuilder(144, false, false),
comBuilder(2,0),
argBuilder(5, true),
),
appBuilder( // 945
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp492
appBuilder( // 946
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 947
ptrBuilder(132, false, false),
argBuilder(4, false),
argBuilder(2, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 948
comBuilder(3,825),
intBuilder(0),
argBuilder(1, true),
argBuilder(4, false),
),
// AExp493
appBuilder( // 949
comBuilder(7,943),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 950
comBuilder(5,946),
argBuilder(1, true),
),
// AExp494
appBuilder( // 951
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 952
comBuilder(7,842),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
argBuilder(2, true),
comBuilder(3,0),
),
// AExp495
appBuilder( // 953
comBuilder(1,25),
argBuilder(3, true),
ptrBuilder(0, true, true),
),
appBuilder( // 954
comBuilder(4,951),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
),
// AExp496
appBuilder( // 955
comBuilder(7,940),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(5,953),
),
appBuilder( // 956
comBuilder(2,949),
argBuilder(1, true),
),
// AExp497
appBuilder( // 957
prmBuilder("=="),
argBuilder(0, true),
intBuilder(103),
comBuilder(3,926),
comBuilder(2,955),
),
// AExp498
appBuilder( // 958
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 959
comBuilder(1,957),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
  )
  private def combChunk030: Seq[Vec[Atom]] = Seq(
// AExp499
appBuilder( // 960
comBuilder(7,638),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 961
comBuilder(4,958),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp500
appBuilder( // 962
comBuilder(7,764),
comBuilder(3,898),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 963
comBuilder(4,960),
argBuilder(2, true),
),
// AExp501
appBuilder( // 964
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 965
comBuilder(3,1160),
argBuilder(1, true),
intBuilder(1),
intBuilder(0),
),
// AExp502
appBuilder( // 966
comBuilder(7,964),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp503
appBuilder( // 967
comBuilder(7,966),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp504
appBuilder( // 968
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 969
comBuilder(3,138),
argBuilder(0, true),
),
// AExp505
appBuilder( // 970
comBuilder(7,967),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,968),
),
// AExp506
appBuilder( // 971
prmBuilder("=="),
argBuilder(1, false),
intBuilder(108),
comBuilder(3,962),
comBuilder(4,970),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp507
appBuilder( // 972
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp508
appBuilder( // 973
comBuilder(7,972),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp509
appBuilder( // 974
comBuilder(7,973),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp510
appBuilder( // 975
comBuilder(7,974),
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 976
argBuilder(0, true),
argBuilder(3, true),
),
// AExp511
appBuilder( // 977
comBuilder(3,1160),
argBuilder(0, true),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 978
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp512
appBuilder( // 979
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 980
comBuilder(3,138),
argBuilder(0, true),
),
// AExp513
appBuilder( // 981
prmBuilder("=="),
argBuilder(0, true),
intBuilder(107),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 982
comBuilder(7,975),
comBuilder(1,977),
comBuilder(1,979),
),
appBuilder( // 983
comBuilder(7,547),
comBuilder(3,282),
comBuilder(3,971),
comBuilder(1,0),
),
// AExp514
appBuilder( // 984
comBuilder(1,981),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp515
appBuilder( // 985
comBuilder(3,984),
),
// AExp516
appBuilder( // 986
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 987
comBuilder(3,1160),
argBuilder(1, true),
intBuilder(0),
intBuilder(1),
),
// AExp517
appBuilder( // 988
comBuilder(7,986),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp518
appBuilder( // 989
comBuilder(7,988),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp519
appBuilder( // 990
comBuilder(7,989),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp520
appBuilder( // 991
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
  )
  private def combChunk031: Seq[Vec[Atom]] = Seq(
appBuilder( // 992
comBuilder(3,138),
argBuilder(0, true),
),
// AExp521
appBuilder( // 993
prmBuilder("=="),
argBuilder(1, false),
intBuilder(106),
comBuilder(1,985),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 994
comBuilder(7,990),
comBuilder(1,991),
),
// AExp522
appBuilder( // 995
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp523
appBuilder( // 996
comBuilder(7,995),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp524
appBuilder( // 997
comBuilder(7,996),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp525
appBuilder( // 998
comBuilder(7,997),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp526
appBuilder( // 999
comBuilder(3,1160),
argBuilder(0, true),
ptrBuilder(0, true, true),
intBuilder(0),
),
appBuilder( // 1000
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp527
appBuilder( // 1001
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1002
comBuilder(3,138),
argBuilder(0, true),
),
// AExp528
appBuilder( // 1003
comBuilder(7,998),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,1001),
),
appBuilder( // 1004
comBuilder(1,999),
argBuilder(1, true),
),
// AExp529
appBuilder( // 1005
comBuilder(7,895),
comBuilder(3,65),
comBuilder(3,282),
comBuilder(3,993),
comBuilder(1,0),
comBuilder(3,1003),
),
// AExp530
appBuilder( // 1006
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1007
comBuilder(2,1253),
argBuilder(1, true),
intBuilder(0),
),
// AExp531
appBuilder( // 1008
comBuilder(7,1006),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp532
appBuilder( // 1009
comBuilder(7,1008),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp533
appBuilder( // 1010
comBuilder(7,1009),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp534
appBuilder( // 1011
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1012
comBuilder(3,138),
argBuilder(0, true),
),
// AExp535
appBuilder( // 1013
comBuilder(7,1010),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,1011),
),
// AExp536
appBuilder( // 1014
prmBuilder("=="),
argBuilder(1, false),
intBuilder(45),
comBuilder(1,1005),
comBuilder(4,1013),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp537
appBuilder( // 1015
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1016
comBuilder(2,1253),
argBuilder(1, true),
intBuilder(1),
),
// AExp538
appBuilder( // 1017
comBuilder(7,1015),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp539
appBuilder( // 1018
comBuilder(7,1017),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp540
appBuilder( // 1019
comBuilder(7,1018),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp541
appBuilder( // 1020
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1021
comBuilder(3,138),
argBuilder(0, true),
),
// AExp542
appBuilder( // 1022
comBuilder(7,1019),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,1020),
),
// AExp543
appBuilder( // 1023
prmBuilder("=="),
argBuilder(0, true),
intBuilder(111),
ptrBuilder(0, true, true),
comBuilder(5,1022),
),
  )
  private def combChunk032: Seq[Vec[Atom]] = Seq(
appBuilder( // 1024
comBuilder(7,547),
comBuilder(3,282),
comBuilder(3,1014),
comBuilder(1,0),
),
// AExp544
appBuilder( // 1025
comBuilder(7,623),
comBuilder(4,217),
ptrBuilder(0, true, true),
),
appBuilder( // 1026
comBuilder(5,888),
comBuilder(5,891),
comBuilder(1,1023),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp545
appBuilder( // 1027
comBuilder(7,874),
comBuilder(2,1025),
),
// AExp546
appBuilder( // 1028
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1029
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 1030
ptrBuilder(144, false, false),
argBuilder(3, false),
argBuilder(1, true),
),
// AExp547
appBuilder( // 1031
comBuilder(7,1028),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1032
comBuilder(1,1255),
argBuilder(3, true),
),
// AExp548
appBuilder( // 1033
comBuilder(7,1031),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp549
appBuilder( // 1034
comBuilder(7,1033),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp550
appBuilder( // 1035
comBuilder(7,1034),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp551
appBuilder( // 1036
comBuilder(7,1035),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
),
appBuilder( // 1037
argBuilder(2, true),
argBuilder(3, true),
),
// AExp552
appBuilder( // 1038
comBuilder(1,25),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1039
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp553
appBuilder( // 1040
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1041
comBuilder(7,842),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(0, true),
comBuilder(3,0),
),
// AExp554
appBuilder( // 1042
comBuilder(7,1036),
argBuilder(0, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1043
comBuilder(7,1038),
comBuilder(5,1040),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp555
appBuilder( // 1044
comBuilder(7,872),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1045
prmBuilder("=="),
argBuilder(0, true),
intBuilder(32),
comBuilder(1,1027),
comBuilder(5,1042),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp556
appBuilder( // 1046
comBuilder(3,65),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 1047
comBuilder(4,1044),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp557
appBuilder( // 1048
comBuilder(1,25),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp558
appBuilder( // 1049
comBuilder(7,1048),
argBuilder(0, true),
),
// AExp559
appBuilder( // 1050
comBuilder(7,1049),
argBuilder(0, true),
),
// AExp560
appBuilder( // 1051
comBuilder(7,1050),
argBuilder(0, true),
),
// AExp561
appBuilder( // 1052
prmBuilder("=="),
argBuilder(0, false),
intBuilder(113),
comBuilder(4,1046),
comBuilder(7,1051),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp562
appBuilder( // 1053
comBuilder(3,65),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 1054
comBuilder(2,1052),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp563
appBuilder( // 1055
comBuilder(1,25),
argBuilder(0, true),
argBuilder(1, true),
),
  )
  private def combChunk033: Seq[Vec[Atom]] = Seq(
// AExp564
appBuilder( // 1056
comBuilder(7,1055),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp565
appBuilder( // 1057
comBuilder(7,1056),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp566
appBuilder( // 1058
comBuilder(7,1057),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp567
appBuilder( // 1059
comBuilder(7,1058),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1060
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp568
appBuilder( // 1061
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1062
comBuilder(7,842),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,1),
),
// AExp569
appBuilder( // 1063
prmBuilder("=="),
argBuilder(0, true),
intBuilder(27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
),
appBuilder( // 1064
comBuilder(7,1059),
comBuilder(5,1061),
),
appBuilder( // 1065
comBuilder(7,870),
comBuilder(3,1053),
),
// AExp570
appBuilder( // 1066
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1067
comBuilder(1,1063),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp571
appBuilder( // 1068
comBuilder(3,865),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 1069
comBuilder(3,1066),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp572
appBuilder( // 1070
comBuilder(7,764),
comBuilder(3,862),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1071
comBuilder(3,1068),
argBuilder(0, true),
),
// AExp573
appBuilder( // 1072
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
ptrBuilder(18, false, false),
),
appBuilder( // 1073
argBuilder(1, true),
argBuilder(2, true),
),
// AExp574
appBuilder( // 1074
comBuilder(1,25),
argBuilder(6, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1075
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp575
appBuilder( // 1076
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1077
comBuilder(7,842),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,0),
),
// AExp576
appBuilder( // 1078
comBuilder(7,1074),
comBuilder(5,1076),
),
// AExp577
appBuilder( // 1079
comBuilder(1,25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1080
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp578
appBuilder( // 1081
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1082
comBuilder(7,842),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,24),
),
// AExp579
appBuilder( // 1083
comBuilder(7,1079),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1084
comBuilder(5,1081),
argBuilder(1, true),
),
// AExp580
appBuilder( // 1085
comBuilder(7,628),
ptrBuilder(0, true, true),
),
appBuilder( // 1086
comBuilder(7,854),
comBuilder(3,858),
comBuilder(1,1070),
comBuilder(6,1072),
comBuilder(1,1078),
comBuilder(2,1083),
argBuilder(0, true),
),
// AExp581
appBuilder( // 1087
argBuilder(0, true),
ptrBuilder(18, false, false),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(6, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
  )
  private def combChunk034: Seq[Vec[Atom]] = Seq(
// AExp582
appBuilder( // 1088
argBuilder(0, true),
argBuilder(4, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp583
appBuilder( // 1089
comBuilder(5,1088),
ptrBuilder(0, true, true),
),
appBuilder( // 1090
argBuilder(0, true),
argBuilder(1, true),
),
// AExp584
appBuilder( // 1091
prmBuilder("=="),
argBuilder(5, true),
intBuilder(66),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
),
appBuilder( // 1092
comBuilder(7,547),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp585
appBuilder( // 1093
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(6, false),
),
appBuilder( // 1094
comBuilder(7,1091),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
),
// AExp586
appBuilder( // 1095
comBuilder(1,25),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1096
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp587
appBuilder( // 1097
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1098
comBuilder(7,842),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,0),
),
// AExp588
appBuilder( // 1099
comBuilder(7,1095),
comBuilder(5,1097),
),
// AExp589
appBuilder( // 1100
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp590
appBuilder( // 1101
comBuilder(3,1160),
argBuilder(0, true),
ptrBuilder(0, true, true),
intBuilder(0),
),
appBuilder( // 1102
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp591
appBuilder( // 1103
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1104
comBuilder(3,138),
argBuilder(0, true),
),
// AExp592
appBuilder( // 1105
comBuilder(7,1100),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,1103),
),
appBuilder( // 1106
comBuilder(1,1101),
argBuilder(1, true),
),
// AExp593
appBuilder( // 1107
prmBuilder("=="),
argBuilder(1, true),
intBuilder(68),
comBuilder(2,1099),
comBuilder(4,1105),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp594
appBuilder( // 1108
comBuilder(7,764),
comBuilder(3,282),
comBuilder(3,1107),
comBuilder(1,0),
),
// AExp595
appBuilder( // 1109
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1110
comBuilder(3,1160),
argBuilder(1, true),
intBuilder(1),
intBuilder(0),
),
// AExp596
appBuilder( // 1111
comBuilder(7,1109),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp597
appBuilder( // 1112
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1113
comBuilder(3,138),
argBuilder(0, true),
),
// AExp598
appBuilder( // 1114
prmBuilder("=="),
argBuilder(1, false),
intBuilder(67),
comBuilder(1,1108),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 1115
comBuilder(7,1111),
comBuilder(1,1112),
),
// AExp599
appBuilder( // 1116
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1117
comBuilder(3,1160),
argBuilder(1, true),
intBuilder(0),
intBuilder(1),
),
// AExp600
appBuilder( // 1118
comBuilder(7,1116),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp601
appBuilder( // 1119
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
  )
  private def combChunk035: Seq[Vec[Atom]] = Seq(
appBuilder( // 1120
comBuilder(3,138),
argBuilder(0, true),
),
// AExp602
appBuilder( // 1121
comBuilder(7,1118),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,1119),
),
// AExp603
appBuilder( // 1122
comBuilder(7,1093),
comBuilder(3,65),
comBuilder(3,282),
comBuilder(3,1114),
comBuilder(1,0),
comBuilder(3,1121),
),
// AExp604
appBuilder( // 1123
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp605
appBuilder( // 1124
comBuilder(7,1123),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp606
appBuilder( // 1125
comBuilder(3,1160),
argBuilder(0, true),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 1126
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp607
appBuilder( // 1127
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1128
comBuilder(3,138),
argBuilder(0, true),
),
// AExp608
appBuilder( // 1129
comBuilder(7,1124),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,1127),
),
appBuilder( // 1130
comBuilder(1,1125),
argBuilder(1, true),
),
// AExp609
appBuilder( // 1131
prmBuilder("=="),
argBuilder(0, false),
intBuilder(65),
comBuilder(1,1122),
comBuilder(4,1129),
ptrBuilder(18, false, false),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp610
appBuilder( // 1132
comBuilder(7,1087),
ptrBuilder(0, true, true),
),
appBuilder( // 1133
comBuilder(2,1089),
comBuilder(2,1131),
argBuilder(0, true),
),
// AExp611
appBuilder( // 1134
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1135
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(3, false),
argBuilder(2, false),
),
appBuilder( // 1136
argBuilder(0, true),
argBuilder(3, false),
argBuilder(2, false),
),
// AExp612
appBuilder( // 1137
comBuilder(7,1134),
ptrBuilder(3, true, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1138
argBuilder(5, true),
argBuilder(6, false),
),
appBuilder( // 1139
comBuilder(2,1162),
intBuilder(0),
argBuilder(4, true),
),
appBuilder( // 1140
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 1141
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, true),
argBuilder(6, false),
),
// AExp613
appBuilder( // 1142
comBuilder(7,1137),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1143
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 1144
argBuilder(2, true),
argBuilder(6, false),
),
// AExp614
appBuilder( // 1145
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1146
ptrBuilder(132, false, false),
argBuilder(0, false),
argBuilder(4, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 1147
ptrBuilder(132, false, false),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
comBuilder(2,0),
),
// AExp615
appBuilder( // 1148
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1149
comBuilder(7,842),
argBuilder(0, true),
argBuilder(4, true),
argBuilder(3, true),
argBuilder(1, true),
argBuilder(2, true),
comBuilder(3,0),
),
// AExp616
appBuilder( // 1150
comBuilder(2,1163),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1151
prmBuilder("+"),
argBuilder(1, true),
argBuilder(0, true),
),
  )
  private def combChunk036: Seq[Vec[Atom]] = Seq(
appBuilder( // 1152
prmBuilder("-"),
intBuilder(100),
intBuilder(1),
),
// AExp617
appBuilder( // 1153
comBuilder(2,1163),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1154
prmBuilder("+"),
argBuilder(1, true),
argBuilder(0, true),
),
appBuilder( // 1155
prmBuilder("-"),
intBuilder(80),
intBuilder(1),
),
// AExp618
appBuilder( // 1156
comBuilder(2,1162),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 1157
comBuilder(2,1153),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp619
appBuilder( // 1158
comBuilder(7,1142),
comBuilder(5,1145),
comBuilder(5,1148),
ptrBuilder(0, true, true),
comBuilder(2,1156),
),
appBuilder( // 1159
comBuilder(2,1150),
argBuilder(0, true),
),
// AExp620
appBuilder( // 1160
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1161
comBuilder(1,1158),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp621
appBuilder( // 1162
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,1),
comBuilder(2,0),
argBuilder(1, false),
argBuilder(0, false),
),
// AExp622
appBuilder( // 1163
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,1),
comBuilder(2,0),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp623
appBuilder( // 1164
comBuilder(3,1204),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1165
prmBuilder("+"),
argBuilder(1, true),
intBuilder(2),
),
appBuilder( // 1166
prmBuilder("+"),
argBuilder(2, false),
intBuilder(1),
),
appBuilder( // 1167
argBuilder(0, true),
argBuilder(2, false),
),
// AExp624
appBuilder( // 1168
comBuilder(3,1204),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1169
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
appBuilder( // 1170
prmBuilder("+"),
argBuilder(2, false),
intBuilder(2),
),
appBuilder( // 1171
argBuilder(0, true),
argBuilder(2, false),
),
// AExp625
appBuilder( // 1172
comBuilder(3,1204),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
intBuilder(1),
),
appBuilder( // 1173
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp626
appBuilder( // 1174
comBuilder(3,1168),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 1175
comBuilder(3,1172),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp627
appBuilder( // 1176
comBuilder(3,1204),
ptrBuilder(1, true, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1177
prmBuilder("+"),
argBuilder(1, false),
intBuilder(2),
),
appBuilder( // 1178
comBuilder(2,1174),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp628
appBuilder( // 1179
comBuilder(3,1164),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 1180
comBuilder(3,1176),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp629
appBuilder( // 1181
comBuilder(3,1204),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1182
prmBuilder("+"),
argBuilder(2, false),
intBuilder(2),
),
appBuilder( // 1183
prmBuilder("+"),
argBuilder(1, false),
intBuilder(2),
),
  )
  private def combChunk037: Seq[Vec[Atom]] = Seq(
appBuilder( // 1184
comBuilder(2,1179),
argBuilder(0, true),
argBuilder(2, false),
argBuilder(1, false),
),
// AExp630
appBuilder( // 1185
prmBuilder("-"),
intBuilder(100),
intBuilder(3),
),
// AExp631
appBuilder( // 1186
prmBuilder(">"),
argBuilder(0, false),
ptrBuilder(0, true, true),
comBuilder(1,0),
comBuilder(1,1185),
argBuilder(0, false),
),
appBuilder( // 1187
prmBuilder("-"),
intBuilder(100),
intBuilder(3),
),
// AExp632
appBuilder( // 1188
prmBuilder("-"),
intBuilder(80),
intBuilder(3),
),
// AExp633
appBuilder( // 1189
prmBuilder(">"),
argBuilder(0, false),
ptrBuilder(0, true, true),
comBuilder(1,0),
comBuilder(1,1188),
argBuilder(0, false),
),
appBuilder( // 1190
prmBuilder("-"),
intBuilder(80),
intBuilder(3),
),
// AExp634
appBuilder( // 1191
comBuilder(3,1181),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1192
comBuilder(1,1189),
argBuilder(2, true),
),
appBuilder( // 1193
comBuilder(1,1186),
argBuilder(1, true),
),
// AExp635
appBuilder( // 1194
comBuilder(2,0),
),
// AExp636
appBuilder( // 1195
comBuilder(3,1204),
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 1196
prmBuilder("-"),
argBuilder(3, true),
intBuilder(1),
),
// AExp637
appBuilder( // 1197
comBuilder(4,3),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1198
comBuilder(4,1195),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp638
appBuilder( // 1199
comBuilder(4,3),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 1200
comBuilder(3,1234),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp639
appBuilder( // 1201
prmBuilder("=="),
argBuilder(1, true),
intBuilder(0),
comBuilder(5,1197),
comBuilder(5,1199),
argBuilder(0, true),
),
// AExp640
appBuilder( // 1202
comBuilder(4,217),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 1203
comBuilder(2,1201),
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp641
appBuilder( // 1204
argBuilder(0, true),
comBuilder(3,1194),
comBuilder(4,1202),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp642
appBuilder( // 1205
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1206
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp643
appBuilder( // 1207
comBuilder(3,1237),
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 1208
prmBuilder("-"),
argBuilder(0, true),
intBuilder(75),
),
// AExp644
appBuilder( // 1209
comBuilder(7,1205),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1210
comBuilder(3,1207),
argBuilder(3, true),
),
// AExp645
appBuilder( // 1211
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
),
appBuilder( // 1212
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp646
appBuilder( // 1213
comBuilder(3,1237),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1214
prmBuilder("-"),
argBuilder(1, true),
intBuilder(50),
),
// AExp647
appBuilder( // 1215
comBuilder(7,1211),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk038: Seq[Vec[Atom]] = Seq(
appBuilder( // 1216
comBuilder(2,1213),
argBuilder(2, true),
),
// AExp648
appBuilder( // 1217
prmBuilder("<"),
argBuilder(2, true),
intBuilder(75),
comBuilder(4,1209),
comBuilder(3,1215),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp649
appBuilder( // 1218
comBuilder(4,217),
ptrBuilder(0, true, true),
argBuilder(2, false),
),
appBuilder( // 1219
comBuilder(3,1217),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp650
appBuilder( // 1220
argBuilder(6, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 1221
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp651
appBuilder( // 1222
comBuilder(3,1237),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1223
prmBuilder("-"),
argBuilder(1, true),
intBuilder(25),
),
// AExp652
appBuilder( // 1224
comBuilder(7,1220),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1225
comBuilder(2,1222),
argBuilder(1, true),
),
// AExp653
appBuilder( // 1226
prmBuilder("<"),
argBuilder(1, false),
intBuilder(50),
comBuilder(3,1218),
comBuilder(2,1224),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, false),
),
// AExp654
appBuilder( // 1227
comBuilder(3,65),
ptrBuilder(0, true, true),
),
appBuilder( // 1228
comBuilder(3,1226),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp655
appBuilder( // 1229
argBuilder(6, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 1230
comBuilder(3,1237),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp656
appBuilder( // 1231
prmBuilder("<"),
argBuilder(0, false),
intBuilder(25),
comBuilder(2,1227),
comBuilder(7,1229),
argBuilder(2, true),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp657
appBuilder( // 1232
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1233
comBuilder(3,1231),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp658
appBuilder( // 1234
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1235
comBuilder(3,1232),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp659
appBuilder( // 1236
prmBuilder("=="),
argBuilder(1, true),
intBuilder(1),
prmBuilder("-"),
prmBuilder("+"),
argBuilder(0, true),
),
// AExp660
appBuilder( // 1237
prmBuilder("=="),
ptrBuilder(1, true, true),
argBuilder(2, false),
comBuilder(2,1236),
comBuilder(3,0),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1238
comBuilder(1,575),
argBuilder(1, false),
),
appBuilder( // 1239
comBuilder(2,568),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp661
appBuilder( // 1240
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1241
argBuilder(1, true),
argBuilder(2, false),
argBuilder(5, false),
argBuilder(3, false),
),
appBuilder( // 1242
argBuilder(0, true),
argBuilder(2, false),
argBuilder(5, false),
argBuilder(3, false),
),
// AExp662
appBuilder( // 1243
comBuilder(7,1240),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
argBuilder(6, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1244
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 1245
argBuilder(1, true),
argBuilder(5, false),
),
appBuilder( // 1246
argBuilder(0, true),
argBuilder(5, false),
),
// AExp663
appBuilder( // 1247
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk039: Seq[Vec[Atom]] = Seq(
appBuilder( // 1248
ptrBuilder(144, false, false),
comBuilder(2,0),
argBuilder(2, true),
),
appBuilder( // 1249
ptrBuilder(132, false, false),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp664
appBuilder( // 1250
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1251
comBuilder(7,842),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
argBuilder(2, true),
comBuilder(3,0),
),
// AExp665
appBuilder( // 1252
comBuilder(3,1204),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(0, true),
),
// AExp666
appBuilder( // 1253
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1254
comBuilder(7,1243),
comBuilder(4,1247),
comBuilder(4,1250),
comBuilder(4,1252),
argBuilder(1, true),
),
// AExp667
appBuilder( // 1255
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
  )
}

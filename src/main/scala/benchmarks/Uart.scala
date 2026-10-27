package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Uart extends Benchmark {
override def toString() = "Uart"
val combinatorCount = 679
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
  heapChunk009,
  heapChunk010
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
comBuilder(2,338),
ptrBuilder(132, false, false),
),
appBuilder( // 124
comBuilder(4,3),
intBuilder(32),
comBuilder(2,0),
),
appBuilder( // 125
comBuilder(4,3),
intBuilder(32),
ptrBuilder(124, false, false),
),
appBuilder( // 126
comBuilder(1,362),
ptrBuilder(125, false, false),
),
appBuilder( // 127
comBuilder(1,360),
ptrBuilder(126, false, false),
),
  )
  private def heapChunk004: Seq[Vec[Atom]] = Seq(
appBuilder( // 128
comBuilder(1,358),
ptrBuilder(127, false, false),
),
appBuilder( // 129
comBuilder(1,356),
ptrBuilder(128, false, false),
),
appBuilder( // 130
comBuilder(1,354),
ptrBuilder(129, false, false),
),
appBuilder( // 131
comBuilder(1,352),
ptrBuilder(130, false, false),
),
appBuilder( // 132
comBuilder(2,349),
ptrBuilder(131, false, false),
),
// AExp14
appBuilder( // 133
comBuilder(2,369),
intBuilder(80),
comBuilder(1,371),
),
// AExp15
appBuilder( // 134
comBuilder(4,629),
ptrBuilder(147, false, false),
),
appBuilder( // 135
comBuilder(4,3),
intBuilder(32),
comBuilder(2,0),
),
appBuilder( // 136
comBuilder(4,3),
intBuilder(32),
ptrBuilder(135, false, false),
),
appBuilder( // 137
comBuilder(1,713),
ptrBuilder(136, false, false),
),
appBuilder( // 138
comBuilder(1,711),
ptrBuilder(137, false, false),
),
appBuilder( // 139
comBuilder(2,709),
ptrBuilder(138, false, false),
),
appBuilder( // 140
comBuilder(4,3),
intBuilder(61),
comBuilder(2,0),
),
appBuilder( // 141
comBuilder(4,3),
intBuilder(88),
ptrBuilder(140, false, false),
),
appBuilder( // 142
comBuilder(1,707),
ptrBuilder(141, false, false),
),
appBuilder( // 143
comBuilder(3,705),
ptrBuilder(142, false, false),
ptrBuilder(139, false, false),
),
appBuilder( // 144
comBuilder(2,703),
ptrBuilder(143, false, false),
),
appBuilder( // 145
comBuilder(3,702),
ptrBuilder(144, false, false),
),
appBuilder( // 146
comBuilder(3,686),
ptrBuilder(145, false, false),
),
appBuilder( // 147
comBuilder(2,640),
ptrBuilder(146, false, false),
),
// AExp16
appBuilder( // 148
comBuilder(1,16),
ptrBuilder(18, false, false),
ptrBuilder(149, false, false),
comBuilder(1,722),
),
appBuilder( // 149
ioBuilder(false),
intBuilder(8),
),
// AExp17
appBuilder( // 150
comBuilder(1,724),
comBuilder(3,731),
),
// AExp18
appBuilder( // 151
comBuilder(6,519),
ptrBuilder(162, false, false),
ptrBuilder(155, false, false),
),
appBuilder( // 152
comBuilder(4,3),
intBuilder(109),
comBuilder(2,0),
),
appBuilder( // 153
comBuilder(4,3),
intBuilder(48),
ptrBuilder(152, false, false),
),
appBuilder( // 154
comBuilder(1,540),
ptrBuilder(153, false, false),
),
appBuilder( // 155
comBuilder(2,539),
ptrBuilder(154, false, false),
),
appBuilder( // 156
comBuilder(4,3),
intBuilder(109),
comBuilder(2,0),
),
appBuilder( // 157
comBuilder(4,3),
intBuilder(55),
ptrBuilder(156, false, false),
),
appBuilder( // 158
comBuilder(1,537),
ptrBuilder(157, false, false),
),
appBuilder( // 159
comBuilder(2,536),
ptrBuilder(158, false, false),
),
  )
  private def heapChunk005: Seq[Vec[Atom]] = Seq(
appBuilder( // 160
comBuilder(4,533),
ptrBuilder(159, false, false),
),
appBuilder( // 161
comBuilder(5,526),
ptrBuilder(160, false, false),
),
appBuilder( // 162
comBuilder(4,524),
ptrBuilder(161, false, false),
),
// AExp19
appBuilder( // 163
comBuilder(4,375),
ptrBuilder(171, false, false),
ptrBuilder(165, false, false),
),
appBuilder( // 164
comBuilder(4,3),
intBuilder(72),
comBuilder(2,0),
),
appBuilder( // 165
comBuilder(1,392),
ptrBuilder(164, false, false),
),
appBuilder( // 166
comBuilder(4,3),
intBuilder(59),
comBuilder(2,0),
),
appBuilder( // 167
comBuilder(1,392),
ptrBuilder(166, false, false),
),
appBuilder( // 168
comBuilder(4,3),
intBuilder(91),
comBuilder(2,0),
),
appBuilder( // 169
comBuilder(4,3),
intBuilder(27),
ptrBuilder(168, false, false),
),
appBuilder( // 170
comBuilder(2,386),
ptrBuilder(169, false, false),
),
appBuilder( // 171
comBuilder(3,382),
ptrBuilder(170, false, false),
ptrBuilder(167, false, false),
),
// AExp20
appBuilder( // 172
comBuilder(4,407),
ptrBuilder(234, false, false),
ptrBuilder(209, false, false),
),
appBuilder( // 173
comBuilder(4,3),
intBuilder(116),
comBuilder(2,0),
),
appBuilder( // 174
comBuilder(4,3),
intBuilder(105),
ptrBuilder(173, false, false),
),
appBuilder( // 175
comBuilder(1,516),
ptrBuilder(174, false, false),
),
appBuilder( // 176
comBuilder(1,514),
ptrBuilder(175, false, false),
),
appBuilder( // 177
comBuilder(1,512),
ptrBuilder(176, false, false),
),
appBuilder( // 178
comBuilder(1,510),
ptrBuilder(177, false, false),
),
appBuilder( // 179
comBuilder(1,508),
ptrBuilder(178, false, false),
),
appBuilder( // 180
comBuilder(1,506),
ptrBuilder(179, false, false),
),
appBuilder( // 181
comBuilder(1,504),
ptrBuilder(180, false, false),
),
appBuilder( // 182
comBuilder(1,502),
ptrBuilder(181, false, false),
),
appBuilder( // 183
comBuilder(1,500),
ptrBuilder(182, false, false),
),
appBuilder( // 184
comBuilder(1,498),
ptrBuilder(183, false, false),
),
appBuilder( // 185
comBuilder(1,496),
ptrBuilder(184, false, false),
),
appBuilder( // 186
comBuilder(1,494),
ptrBuilder(185, false, false),
),
appBuilder( // 187
comBuilder(1,492),
ptrBuilder(186, false, false),
),
appBuilder( // 188
comBuilder(1,490),
ptrBuilder(187, false, false),
),
appBuilder( // 189
comBuilder(1,488),
ptrBuilder(188, false, false),
),
appBuilder( // 190
comBuilder(1,486),
ptrBuilder(189, false, false),
),
appBuilder( // 191
comBuilder(1,484),
ptrBuilder(190, false, false),
),
  )
  private def heapChunk006: Seq[Vec[Atom]] = Seq(
appBuilder( // 192
comBuilder(1,482),
ptrBuilder(191, false, false),
),
appBuilder( // 193
comBuilder(1,480),
ptrBuilder(192, false, false),
),
appBuilder( // 194
comBuilder(1,478),
ptrBuilder(193, false, false),
),
appBuilder( // 195
comBuilder(1,476),
ptrBuilder(194, false, false),
),
appBuilder( // 196
comBuilder(1,474),
ptrBuilder(195, false, false),
),
appBuilder( // 197
comBuilder(1,472),
ptrBuilder(196, false, false),
),
appBuilder( // 198
comBuilder(1,470),
ptrBuilder(197, false, false),
),
appBuilder( // 199
comBuilder(1,468),
ptrBuilder(198, false, false),
),
appBuilder( // 200
comBuilder(1,466),
ptrBuilder(199, false, false),
),
appBuilder( // 201
comBuilder(1,464),
ptrBuilder(200, false, false),
),
appBuilder( // 202
comBuilder(1,462),
ptrBuilder(201, false, false),
),
appBuilder( // 203
comBuilder(1,460),
ptrBuilder(202, false, false),
),
appBuilder( // 204
comBuilder(1,458),
ptrBuilder(203, false, false),
),
appBuilder( // 205
comBuilder(1,456),
ptrBuilder(204, false, false),
),
appBuilder( // 206
comBuilder(1,454),
ptrBuilder(205, false, false),
),
appBuilder( // 207
comBuilder(1,452),
ptrBuilder(206, false, false),
),
appBuilder( // 208
comBuilder(1,450),
ptrBuilder(207, false, false),
),
appBuilder( // 209
comBuilder(1,448),
ptrBuilder(208, false, false),
),
appBuilder( // 210
comBuilder(4,3),
intBuilder(32),
comBuilder(2,0),
),
appBuilder( // 211
comBuilder(4,3),
intBuilder(58),
ptrBuilder(210, false, false),
),
appBuilder( // 212
comBuilder(1,446),
ptrBuilder(211, false, false),
),
appBuilder( // 213
comBuilder(1,444),
ptrBuilder(212, false, false),
),
appBuilder( // 214
comBuilder(1,442),
ptrBuilder(213, false, false),
),
appBuilder( // 215
comBuilder(1,440),
ptrBuilder(214, false, false),
),
appBuilder( // 216
comBuilder(1,438),
ptrBuilder(215, false, false),
),
appBuilder( // 217
comBuilder(1,436),
ptrBuilder(216, false, false),
),
appBuilder( // 218
comBuilder(4,3),
intBuilder(71),
comBuilder(2,0),
),
appBuilder( // 219
comBuilder(4,3),
intBuilder(78),
ptrBuilder(218, false, false),
),
appBuilder( // 220
comBuilder(1,434),
ptrBuilder(219, false, false),
),
appBuilder( // 221
comBuilder(1,432),
ptrBuilder(220, false, false),
),
appBuilder( // 222
comBuilder(4,3),
intBuilder(32),
comBuilder(2,0),
),
appBuilder( // 223
comBuilder(4,3),
intBuilder(68),
ptrBuilder(222, false, false),
),
  )
  private def heapChunk007: Seq[Vec[Atom]] = Seq(
appBuilder( // 224
comBuilder(1,430),
ptrBuilder(223, false, false),
),
appBuilder( // 225
comBuilder(1,428),
ptrBuilder(224, false, false),
),
appBuilder( // 226
comBuilder(3,425),
ptrBuilder(225, false, false),
ptrBuilder(221, false, false),
),
appBuilder( // 227
comBuilder(4,3),
intBuilder(75),
comBuilder(2,0),
),
appBuilder( // 228
comBuilder(4,3),
intBuilder(50),
ptrBuilder(227, false, false),
),
appBuilder( // 229
comBuilder(1,423),
ptrBuilder(228, false, false),
),
appBuilder( // 230
comBuilder(1,420),
ptrBuilder(229, false, false),
),
appBuilder( // 231
comBuilder(2,418),
ptrBuilder(230, false, false),
),
appBuilder( // 232
comBuilder(3,282),
ptrBuilder(231, false, false),
ptrBuilder(226, false, false),
),
appBuilder( // 233
comBuilder(3,415),
ptrBuilder(232, false, false),
ptrBuilder(217, false, false),
),
appBuilder( // 234
comBuilder(3,412),
ptrBuilder(233, false, false),
),
// AExp21
appBuilder( // 235
comBuilder(3,872),
ptrBuilder(236, false, false),
),
appBuilder( // 236
comBuilder(1,1103),
comBuilder(2,1108),
comBuilder(1,0),
comBuilder(1,1155),
),
// AExp22
appBuilder( // 237
comBuilder(1,392),
ptrBuilder(255, false, false),
),
appBuilder( // 238
comBuilder(4,3),
intBuilder(108),
comBuilder(2,0),
),
appBuilder( // 239
comBuilder(4,3),
intBuilder(57),
ptrBuilder(238, false, false),
),
appBuilder( // 240
comBuilder(4,3),
intBuilder(52),
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
intBuilder(63),
ptrBuilder(242, false, false),
),
appBuilder( // 244
comBuilder(4,3),
intBuilder(91),
ptrBuilder(243, false, false),
),
appBuilder( // 245
comBuilder(4,3),
intBuilder(27),
ptrBuilder(244, false, false),
),
appBuilder( // 246
comBuilder(4,3),
intBuilder(104),
ptrBuilder(245, false, false),
),
appBuilder( // 247
comBuilder(4,3),
intBuilder(53),
ptrBuilder(246, false, false),
),
appBuilder( // 248
comBuilder(4,3),
intBuilder(50),
ptrBuilder(247, false, false),
),
appBuilder( // 249
comBuilder(4,3),
intBuilder(63),
ptrBuilder(248, false, false),
),
appBuilder( // 250
comBuilder(4,3),
intBuilder(91),
ptrBuilder(249, false, false),
),
appBuilder( // 251
comBuilder(4,3),
intBuilder(27),
ptrBuilder(250, false, false),
),
appBuilder( // 252
comBuilder(4,3),
intBuilder(109),
ptrBuilder(251, false, false),
),
appBuilder( // 253
comBuilder(4,3),
intBuilder(48),
ptrBuilder(252, false, false),
),
appBuilder( // 254
comBuilder(4,3),
intBuilder(91),
ptrBuilder(253, false, false),
),
appBuilder( // 255
comBuilder(4,3),
intBuilder(27),
ptrBuilder(254, false, false),
),
  )
  private def heapChunk008: Seq[Vec[Atom]] = Seq(
// AExp23
appBuilder( // 256
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(319, false, false),
ptrBuilder(297, false, false),
),
appBuilder( // 257
comBuilder(4,3),
intBuilder(41),
comBuilder(2,0),
),
appBuilder( // 258
comBuilder(4,3),
intBuilder(48),
ptrBuilder(257, false, false),
),
appBuilder( // 259
comBuilder(4,3),
intBuilder(56),
ptrBuilder(258, false, false),
),
appBuilder( // 260
comBuilder(4,3),
intBuilder(32),
ptrBuilder(259, false, false),
),
appBuilder( // 261
comBuilder(4,3),
intBuilder(120),
ptrBuilder(260, false, false),
),
appBuilder( // 262
comBuilder(4,3),
intBuilder(32),
ptrBuilder(261, false, false),
),
appBuilder( // 263
comBuilder(4,3),
intBuilder(48),
ptrBuilder(262, false, false),
),
appBuilder( // 264
comBuilder(4,3),
intBuilder(48),
ptrBuilder(263, false, false),
),
appBuilder( // 265
comBuilder(4,3),
intBuilder(49),
ptrBuilder(264, false, false),
),
appBuilder( // 266
comBuilder(4,3),
intBuilder(40),
ptrBuilder(265, false, false),
),
appBuilder( // 267
comBuilder(4,3),
intBuilder(32),
ptrBuilder(266, false, false),
),
appBuilder( // 268
comBuilder(4,3),
intBuilder(101),
ptrBuilder(267, false, false),
),
appBuilder( // 269
comBuilder(4,3),
intBuilder(102),
ptrBuilder(268, false, false),
),
appBuilder( // 270
comBuilder(4,3),
intBuilder(105),
ptrBuilder(269, false, false),
),
appBuilder( // 271
comBuilder(4,3),
intBuilder(76),
ptrBuilder(270, false, false),
),
appBuilder( // 272
comBuilder(4,3),
intBuilder(32),
ptrBuilder(271, false, false),
),
appBuilder( // 273
comBuilder(4,3),
intBuilder(102),
ptrBuilder(272, false, false),
),
appBuilder( // 274
comBuilder(4,3),
intBuilder(111),
ptrBuilder(273, false, false),
),
appBuilder( // 275
comBuilder(4,3),
intBuilder(32),
ptrBuilder(274, false, false),
),
appBuilder( // 276
comBuilder(4,3),
intBuilder(101),
ptrBuilder(275, false, false),
),
appBuilder( // 277
comBuilder(4,3),
intBuilder(109),
ptrBuilder(276, false, false),
),
appBuilder( // 278
comBuilder(4,3),
intBuilder(97),
ptrBuilder(277, false, false),
),
appBuilder( // 279
comBuilder(4,3),
intBuilder(71),
ptrBuilder(278, false, false),
),
appBuilder( // 280
comBuilder(4,3),
intBuilder(32),
ptrBuilder(279, false, false),
),
appBuilder( // 281
comBuilder(4,3),
intBuilder(115),
ptrBuilder(280, false, false),
),
appBuilder( // 282
comBuilder(4,3),
intBuilder(39),
ptrBuilder(281, false, false),
),
appBuilder( // 283
comBuilder(4,3),
intBuilder(121),
ptrBuilder(282, false, false),
),
appBuilder( // 284
comBuilder(4,3),
intBuilder(97),
ptrBuilder(283, false, false),
),
appBuilder( // 285
comBuilder(4,3),
intBuilder(119),
ptrBuilder(284, false, false),
),
appBuilder( // 286
comBuilder(4,3),
intBuilder(110),
ptrBuilder(285, false, false),
),
appBuilder( // 287
comBuilder(4,3),
intBuilder(111),
ptrBuilder(286, false, false),
),
  )
  private def heapChunk009: Seq[Vec[Atom]] = Seq(
appBuilder( // 288
comBuilder(4,3),
intBuilder(67),
ptrBuilder(287, false, false),
),
appBuilder( // 289
comBuilder(4,3),
intBuilder(32),
ptrBuilder(288, false, false),
),
appBuilder( // 290
comBuilder(4,3),
intBuilder(47),
ptrBuilder(289, false, false),
),
appBuilder( // 291
comBuilder(4,3),
intBuilder(32),
ptrBuilder(290, false, false),
),
appBuilder( // 292
comBuilder(4,3),
intBuilder(115),
ptrBuilder(291, false, false),
),
appBuilder( // 293
comBuilder(4,3),
intBuilder(111),
ptrBuilder(292, false, false),
),
appBuilder( // 294
comBuilder(4,3),
intBuilder(114),
ptrBuilder(293, false, false),
),
appBuilder( // 295
comBuilder(4,3),
intBuilder(117),
ptrBuilder(294, false, false),
),
appBuilder( // 296
comBuilder(4,3),
intBuilder(79),
ptrBuilder(295, false, false),
),
appBuilder( // 297
comBuilder(3,372),
intBuilder(1),
intBuilder(1),
ptrBuilder(296, false, false),
),
appBuilder( // 298
comBuilder(4,3),
intBuilder(72),
comBuilder(2,0),
),
appBuilder( // 299
comBuilder(4,3),
intBuilder(91),
ptrBuilder(298, false, false),
),
appBuilder( // 300
comBuilder(4,3),
intBuilder(27),
ptrBuilder(299, false, false),
),
appBuilder( // 301
comBuilder(4,3),
intBuilder(74),
ptrBuilder(300, false, false),
),
appBuilder( // 302
comBuilder(4,3),
intBuilder(50),
ptrBuilder(301, false, false),
),
appBuilder( // 303
comBuilder(4,3),
intBuilder(91),
ptrBuilder(302, false, false),
),
appBuilder( // 304
comBuilder(4,3),
intBuilder(27),
ptrBuilder(303, false, false),
),
appBuilder( // 305
comBuilder(4,3),
intBuilder(108),
ptrBuilder(304, false, false),
),
appBuilder( // 306
comBuilder(4,3),
intBuilder(53),
ptrBuilder(305, false, false),
),
appBuilder( // 307
comBuilder(4,3),
intBuilder(50),
ptrBuilder(306, false, false),
),
appBuilder( // 308
comBuilder(4,3),
intBuilder(63),
ptrBuilder(307, false, false),
),
appBuilder( // 309
comBuilder(4,3),
intBuilder(91),
ptrBuilder(308, false, false),
),
appBuilder( // 310
comBuilder(4,3),
intBuilder(27),
ptrBuilder(309, false, false),
),
appBuilder( // 311
comBuilder(4,3),
intBuilder(104),
ptrBuilder(310, false, false),
),
appBuilder( // 312
comBuilder(4,3),
intBuilder(57),
ptrBuilder(311, false, false),
),
appBuilder( // 313
comBuilder(4,3),
intBuilder(52),
ptrBuilder(312, false, false),
),
appBuilder( // 314
comBuilder(4,3),
intBuilder(48),
ptrBuilder(313, false, false),
),
appBuilder( // 315
comBuilder(4,3),
intBuilder(49),
ptrBuilder(314, false, false),
),
appBuilder( // 316
comBuilder(4,3),
intBuilder(63),
ptrBuilder(315, false, false),
),
appBuilder( // 317
comBuilder(4,3),
intBuilder(91),
ptrBuilder(316, false, false),
),
appBuilder( // 318
comBuilder(4,3),
intBuilder(27),
ptrBuilder(317, false, false),
),
appBuilder( // 319
comBuilder(1,392),
ptrBuilder(318, false, false),
),
  )
  private def heapChunk010: Seq[Vec[Atom]] = Seq(
// AExp24
appBuilder( // 320
comBuilder(1,4),
ptrBuilder(103, false, false),
ptrBuilder(323, false, false),
ptrBuilder(321, false, false),
),
appBuilder( // 321
comBuilder(1,25),
ptrBuilder(103, false, false),
comBuilder(1,0),
),
appBuilder( // 322
comBuilder(1,162),
comBuilder(1,164),
),
appBuilder( // 323
comBuilder(1,139),
ptrBuilder(322, false, false),
),
// AExp25
appBuilder( // 324
comBuilder(1,0),
comBuilder(1,169),
),
// AExp26
appBuilder( // 325
comBuilder(1,16),
ptrBuilder(103, false, false),
ptrBuilder(326, false, false),
comBuilder(1,211),
),
appBuilder( // 326
comBuilder(1,162),
comBuilder(1,208),
),
// AExp27
appBuilder( // 327
comBuilder(2,213),
ptrBuilder(330, false, false),
),
appBuilder( // 328
comBuilder(1,0),
comBuilder(5,230),
comBuilder(5,235),
comBuilder(1,238),
comBuilder(2,242),
comBuilder(3,247),
comBuilder(4,249),
),
appBuilder( // 329
comBuilder(4,217),
ptrBuilder(328, false, false),
),
appBuilder( // 330
comBuilder(5,216),
ptrBuilder(329, false, false),
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
ptrBuilder(123, false, false),
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
ptrBuilder(320, false, false),
ptrBuilder(324, false, false),
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
ptrBuilder(320, false, false),
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
ptrBuilder(327, false, false),
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
ptrBuilder(325, false, false),
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
ptrBuilder(134, false, false),
ptrBuilder(0, true, true),
intBuilder(3000),
argBuilder(0, true),
),
appBuilder( // 337
comBuilder(7,646),
argBuilder(1, true),
intBuilder(49),
intBuilder(39),
comBuilder(2,0),
intBuilder(0),
comBuilder(3,0),
),
// AExp186
appBuilder( // 338
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 339
comBuilder(2,336),
argBuilder(1, true),
ptrBuilder(133, false, false),
),
appBuilder( // 340
argBuilder(0, true),
ptrBuilder(133, false, false),
),
// AExp187
appBuilder( // 341
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(256, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 342
comBuilder(2,600),
intBuilder(0),
argBuilder(0, true),
),
// AExp188
appBuilder( // 343
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 344
ptrBuilder(151, false, false),
argBuilder(0, false),
intBuilder(49),
intBuilder(39),
comBuilder(2,1),
),
appBuilder( // 345
comBuilder(1,341),
argBuilder(0, false),
),
// AExp189
appBuilder( // 346
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 347
ptrBuilder(172, false, false),
comBuilder(2,0),
intBuilder(0),
),
appBuilder( // 348
comBuilder(1,343),
argBuilder(0, true),
),
// AExp190
appBuilder( // 349
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 350
comBuilder(3,372),
intBuilder(1),
intBuilder(57),
argBuilder(0, true),
),
appBuilder( // 351
comBuilder(1,346),
argBuilder(1, true),
),
  )
  private def combChunk011: Seq[Vec[Atom]] = Seq(
// AExp191
appBuilder( // 352
comBuilder(4,3),
intBuilder(87),
ptrBuilder(0, true, true),
),
appBuilder( // 353
comBuilder(4,3),
intBuilder(65),
argBuilder(0, true),
),
// AExp192
appBuilder( // 354
comBuilder(4,3),
intBuilder(73),
ptrBuilder(0, true, true),
),
appBuilder( // 355
comBuilder(4,3),
intBuilder(84),
argBuilder(0, true),
),
// AExp193
appBuilder( // 356
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 357
comBuilder(4,3),
intBuilder(82),
argBuilder(0, true),
),
// AExp194
appBuilder( // 358
comBuilder(4,3),
intBuilder(88),
ptrBuilder(0, true, true),
),
appBuilder( // 359
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp195
appBuilder( // 360
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 361
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp196
appBuilder( // 362
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 363
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp197
appBuilder( // 364
comBuilder(2,0),
),
// AExp198
appBuilder( // 365
comBuilder(2,369),
ptrBuilder(0, true, true),
),
appBuilder( // 366
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp199
appBuilder( // 367
comBuilder(4,3),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 368
comBuilder(1,365),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp200
appBuilder( // 369
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,0),
comBuilder(1,364),
ptrBuilder(0, true, true),
),
appBuilder( // 370
comBuilder(2,367),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp201
appBuilder( // 371
argBuilder(0, true),
intBuilder(0),
intBuilder(0),
intBuilder(0),
intBuilder(0),
),
// AExp202
appBuilder( // 372
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 373
comBuilder(1,392),
argBuilder(2, true),
),
appBuilder( // 374
ptrBuilder(163, false, false),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp203
appBuilder( // 375
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 376
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp204
appBuilder( // 377
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 378
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 379
comBuilder(1,4),
ptrBuilder(18, false, false),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp205
appBuilder( // 380
comBuilder(1,392),
ptrBuilder(0, true, true),
),
appBuilder( // 381
comBuilder(1,406),
argBuilder(0, true),
),
// AExp206
appBuilder( // 382
comBuilder(4,377),
ptrBuilder(0, true, true),
argBuilder(1, true),
comBuilder(1,380),
),
appBuilder( // 383
argBuilder(0, true),
argBuilder(2, true),
),
  )
  private def combChunk012: Seq[Vec[Atom]] = Seq(
// AExp207
appBuilder( // 384
comBuilder(1,392),
ptrBuilder(0, true, true),
),
appBuilder( // 385
comBuilder(1,406),
argBuilder(0, true),
),
// AExp208
appBuilder( // 386
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 387
comBuilder(1,384),
argBuilder(1, true),
),
appBuilder( // 388
comBuilder(1,392),
argBuilder(0, true),
),
// AExp209
appBuilder( // 389
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 390
comBuilder(1,392),
argBuilder(1, true),
),
appBuilder( // 391
ptrBuilder(55, false, false),
argBuilder(0, true),
),
// AExp210
appBuilder( // 392
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,389),
),
appBuilder( // 393
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp211
appBuilder( // 394
comBuilder(4,3),
ptrBuilder(0, true, true),
),
appBuilder( // 395
comBuilder(1,0),
argBuilder(0, true),
),
// AExp212
appBuilder( // 396
prmBuilder("+"),
intBuilder(48),
ptrBuilder(0, true, true),
),
appBuilder( // 397
argBuilder(0, true),
comBuilder(2,1),
),
// AExp213
appBuilder( // 398
comBuilder(1,394),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 399
comBuilder(1,396),
argBuilder(1, true),
),
// AExp214
appBuilder( // 400
prmBuilder("=="),
argBuilder(3, false),
intBuilder(0),
comBuilder(3,253),
comBuilder(3,0),
ptrBuilder(0, true, true),
argBuilder(0, true),
argBuilder(3, false),
),
appBuilder( // 401
comBuilder(2,398),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp215
appBuilder( // 402
argBuilder(0, true),
comBuilder(2,0),
),
// AExp216
appBuilder( // 403
comBuilder(3,251),
ptrBuilder(1, true, true),
comBuilder(1,402),
ptrBuilder(0, true, true),
),
appBuilder( // 404
comBuilder(1,280),
argBuilder(1, true),
intBuilder(10),
),
appBuilder( // 405
comBuilder(4,400),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp217
appBuilder( // 406
yBuilder(),
comBuilder(3,403),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp218
appBuilder( // 407
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 408
comBuilder(1,392),
argBuilder(1, true),
),
appBuilder( // 409
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp219
appBuilder( // 410
comBuilder(1,392),
ptrBuilder(0, true, true),
),
appBuilder( // 411
comBuilder(1,406),
argBuilder(0, true),
),
// AExp220
appBuilder( // 412
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 413
comBuilder(1,410),
argBuilder(2, true),
),
appBuilder( // 414
argBuilder(0, true),
argBuilder(1, true),
),
// AExp221
appBuilder( // 415
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk013: Seq[Vec[Atom]] = Seq(
appBuilder( // 416
comBuilder(1,392),
argBuilder(1, true),
),
appBuilder( // 417
argBuilder(0, true),
argBuilder(2, true),
),
// AExp222
appBuilder( // 418
comBuilder(1,4),
ptrBuilder(18, false, false),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 419
comBuilder(1,392),
argBuilder(1, true),
),
// AExp223
appBuilder( // 420
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 421
comBuilder(1,392),
argBuilder(0, true),
),
appBuilder( // 422
ptrBuilder(163, false, false),
intBuilder(82),
intBuilder(1),
),
// AExp224
appBuilder( // 423
comBuilder(4,3),
intBuilder(27),
ptrBuilder(0, true, true),
),
appBuilder( // 424
comBuilder(4,3),
intBuilder(91),
argBuilder(0, true),
),
// AExp225
appBuilder( // 425
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 426
comBuilder(4,3),
intBuilder(82),
argBuilder(1, true),
),
appBuilder( // 427
comBuilder(4,3),
intBuilder(80),
argBuilder(0, true),
),
// AExp226
appBuilder( // 428
comBuilder(4,3),
intBuilder(65),
ptrBuilder(0, true, true),
),
appBuilder( // 429
comBuilder(4,3),
intBuilder(85),
argBuilder(0, true),
),
// AExp227
appBuilder( // 430
comBuilder(4,3),
intBuilder(83),
ptrBuilder(0, true, true),
),
appBuilder( // 431
comBuilder(4,3),
intBuilder(69),
argBuilder(0, true),
),
// AExp228
appBuilder( // 432
comBuilder(4,3),
intBuilder(85),
ptrBuilder(0, true, true),
),
appBuilder( // 433
comBuilder(4,3),
intBuilder(78),
argBuilder(0, true),
),
// AExp229
appBuilder( // 434
comBuilder(4,3),
intBuilder(78),
ptrBuilder(0, true, true),
),
appBuilder( // 435
comBuilder(4,3),
intBuilder(73),
argBuilder(0, true),
),
// AExp230
appBuilder( // 436
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 437
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp231
appBuilder( // 438
comBuilder(4,3),
intBuilder(71),
ptrBuilder(0, true, true),
),
appBuilder( // 439
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp232
appBuilder( // 440
comBuilder(4,3),
intBuilder(110),
ptrBuilder(0, true, true),
),
appBuilder( // 441
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp233
appBuilder( // 442
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 443
comBuilder(4,3),
intBuilder(97),
argBuilder(0, true),
),
// AExp234
appBuilder( // 444
comBuilder(4,3),
intBuilder(116),
ptrBuilder(0, true, true),
),
appBuilder( // 445
comBuilder(4,3),
intBuilder(105),
argBuilder(0, true),
),
// AExp235
appBuilder( // 446
comBuilder(4,3),
intBuilder(111),
ptrBuilder(0, true, true),
),
appBuilder( // 447
comBuilder(4,3),
intBuilder(110),
argBuilder(0, true),
),
  )
  private def combChunk014: Seq[Vec[Atom]] = Seq(
// AExp236
appBuilder( // 448
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 449
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp237
appBuilder( // 450
comBuilder(4,3),
intBuilder(97),
ptrBuilder(0, true, true),
),
appBuilder( // 451
comBuilder(4,3),
intBuilder(114),
argBuilder(0, true),
),
// AExp238
appBuilder( // 452
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 453
comBuilder(4,3),
intBuilder(111),
argBuilder(0, true),
),
// AExp239
appBuilder( // 454
comBuilder(4,3),
intBuilder(119),
ptrBuilder(0, true, true),
),
appBuilder( // 455
comBuilder(4,3),
intBuilder(115),
argBuilder(0, true),
),
// AExp240
appBuilder( // 456
comBuilder(4,3),
intBuilder(47),
ptrBuilder(0, true, true),
),
appBuilder( // 457
comBuilder(4,3),
intBuilder(104),
argBuilder(0, true),
),
// AExp241
appBuilder( // 458
comBuilder(4,3),
intBuilder(106),
ptrBuilder(0, true, true),
),
appBuilder( // 459
comBuilder(4,3),
intBuilder(107),
argBuilder(0, true),
),
// AExp242
appBuilder( // 460
comBuilder(4,3),
intBuilder(108),
ptrBuilder(0, true, true),
),
appBuilder( // 461
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp243
appBuilder( // 462
comBuilder(4,3),
intBuilder(109),
ptrBuilder(0, true, true),
),
appBuilder( // 463
comBuilder(4,3),
intBuilder(111),
argBuilder(0, true),
),
// AExp244
appBuilder( // 464
comBuilder(4,3),
intBuilder(118),
ptrBuilder(0, true, true),
),
appBuilder( // 465
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp245
appBuilder( // 466
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 467
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp246
appBuilder( // 468
comBuilder(4,3),
intBuilder(111),
ptrBuilder(0, true, true),
),
appBuilder( // 469
comBuilder(4,3),
intBuilder(47),
argBuilder(0, true),
),
// AExp247
appBuilder( // 470
comBuilder(4,3),
intBuilder(45),
ptrBuilder(0, true, true),
),
appBuilder( // 471
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp248
appBuilder( // 472
comBuilder(4,3),
intBuilder(101),
ptrBuilder(0, true, true),
),
appBuilder( // 473
comBuilder(4,3),
intBuilder(100),
argBuilder(0, true),
),
// AExp249
appBuilder( // 474
comBuilder(4,3),
intBuilder(105),
ptrBuilder(0, true, true),
),
appBuilder( // 475
comBuilder(4,3),
intBuilder(116),
argBuilder(0, true),
),
// AExp250
appBuilder( // 476
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 477
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp251
appBuilder( // 478
comBuilder(4,3),
intBuilder(83),
ptrBuilder(0, true, true),
),
appBuilder( // 479
comBuilder(4,3),
intBuilder(80),
argBuilder(0, true),
),
  )
  private def combChunk015: Seq[Vec[Atom]] = Seq(
// AExp252
appBuilder( // 480
comBuilder(4,3),
intBuilder(65),
ptrBuilder(0, true, true),
),
appBuilder( // 481
comBuilder(4,3),
intBuilder(67),
argBuilder(0, true),
),
// AExp253
appBuilder( // 482
comBuilder(4,3),
intBuilder(69),
ptrBuilder(0, true, true),
),
appBuilder( // 483
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp254
appBuilder( // 484
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 485
comBuilder(4,3),
intBuilder(117),
argBuilder(0, true),
),
// AExp255
appBuilder( // 486
comBuilder(4,3),
intBuilder(110),
ptrBuilder(0, true, true),
),
appBuilder( // 487
comBuilder(4,3),
intBuilder(47),
argBuilder(0, true),
),
// AExp256
appBuilder( // 488
comBuilder(4,3),
intBuilder(112),
ptrBuilder(0, true, true),
),
appBuilder( // 489
comBuilder(4,3),
intBuilder(97),
argBuilder(0, true),
),
// AExp257
appBuilder( // 490
comBuilder(4,3),
intBuilder(117),
ptrBuilder(0, true, true),
),
appBuilder( // 491
comBuilder(4,3),
intBuilder(115),
argBuilder(0, true),
),
// AExp258
appBuilder( // 492
comBuilder(4,3),
intBuilder(101),
ptrBuilder(0, true, true),
),
appBuilder( // 493
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp259
appBuilder( // 494
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 495
comBuilder(4,3),
intBuilder(103),
argBuilder(0, true),
),
// AExp260
appBuilder( // 496
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 497
comBuilder(4,3),
intBuilder(103),
argBuilder(0, true),
),
// AExp261
appBuilder( // 498
comBuilder(4,3),
intBuilder(108),
ptrBuilder(0, true, true),
),
appBuilder( // 499
comBuilder(4,3),
intBuilder(105),
argBuilder(0, true),
),
// AExp262
appBuilder( // 500
comBuilder(4,3),
intBuilder(100),
ptrBuilder(0, true, true),
),
appBuilder( // 501
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp263
appBuilder( // 502
comBuilder(4,3),
intBuilder(114),
ptrBuilder(0, true, true),
),
appBuilder( // 503
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp264
appBuilder( // 504
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 505
comBuilder(4,3),
intBuilder(99),
argBuilder(0, true),
),
// AExp265
appBuilder( // 506
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 507
comBuilder(4,3),
intBuilder(99),
argBuilder(0, true),
),
// AExp266
appBuilder( // 508
comBuilder(4,3),
intBuilder(108),
ptrBuilder(0, true, true),
),
appBuilder( // 509
comBuilder(4,3),
intBuilder(101),
argBuilder(0, true),
),
// AExp267
appBuilder( // 510
comBuilder(4,3),
intBuilder(97),
ptrBuilder(0, true, true),
),
appBuilder( // 511
comBuilder(4,3),
intBuilder(114),
argBuilder(0, true),
),
  )
  private def combChunk016: Seq[Vec[Atom]] = Seq(
// AExp268
appBuilder( // 512
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 513
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp269
appBuilder( // 514
comBuilder(4,3),
intBuilder(113),
ptrBuilder(0, true, true),
),
appBuilder( // 515
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp270
appBuilder( // 516
comBuilder(4,3),
intBuilder(113),
ptrBuilder(0, true, true),
),
appBuilder( // 517
comBuilder(4,3),
intBuilder(117),
argBuilder(0, true),
),
// AExp271
appBuilder( // 518
comBuilder(1,25),
argBuilder(0, true),
comBuilder(1,0),
),
// AExp272
appBuilder( // 519
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 520
argBuilder(5, false),
comBuilder(1,518),
argBuilder(1, true),
ptrBuilder(18, false, false),
),
appBuilder( // 521
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
),
// AExp273
appBuilder( // 522
comBuilder(1,542),
ptrBuilder(0, true, true),
),
appBuilder( // 523
comBuilder(3,560),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp274
appBuilder( // 524
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, false),
ptrBuilder(0, true, true),
),
appBuilder( // 525
comBuilder(3,522),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp275
appBuilder( // 526
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 527
ptrBuilder(55, false, false),
argBuilder(3, true),
),
appBuilder( // 528
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
),
// AExp276
appBuilder( // 529
ptrBuilder(163, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 530
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
appBuilder( // 531
prmBuilder("+"),
argBuilder(1, true),
intBuilder(2),
),
// AExp277
appBuilder( // 532
comBuilder(1,25),
argBuilder(0, true),
comBuilder(1,0),
),
// AExp278
appBuilder( // 533
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 534
argBuilder(3, true),
comBuilder(1,532),
argBuilder(0, true),
ptrBuilder(18, false, false),
),
appBuilder( // 535
comBuilder(2,529),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp279
appBuilder( // 536
comBuilder(1,392),
argBuilder(0, true),
),
// AExp280
appBuilder( // 537
comBuilder(4,3),
intBuilder(27),
ptrBuilder(0, true, true),
),
appBuilder( // 538
comBuilder(4,3),
intBuilder(91),
argBuilder(0, true),
),
// AExp281
appBuilder( // 539
comBuilder(1,392),
argBuilder(0, true),
),
// AExp282
appBuilder( // 540
comBuilder(4,3),
intBuilder(27),
ptrBuilder(0, true, true),
),
appBuilder( // 541
comBuilder(4,3),
intBuilder(91),
argBuilder(0, true),
),
// AExp283
appBuilder( // 542
prmBuilder("=="),
argBuilder(0, true),
intBuilder(1),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 543
comBuilder(1,0),
intBuilder(111),
),
  )
  private def combChunk017: Seq[Vec[Atom]] = Seq(
appBuilder( // 544
comBuilder(1,0),
intBuilder(45),
),
// AExp284
appBuilder( // 545
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 546
prmBuilder(">="),
argBuilder(0, false),
intBuilder(80),
),
appBuilder( // 547
prmBuilder("<"),
argBuilder(0, false),
intBuilder(0),
),
// AExp285
appBuilder( // 548
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 549
comBuilder(1,545),
argBuilder(1, true),
),
appBuilder( // 550
prmBuilder(">="),
argBuilder(0, true),
intBuilder(100),
),
// AExp286
appBuilder( // 551
intBuilder(0),
),
// AExp287
appBuilder( // 552
intBuilder(0),
),
// AExp288
appBuilder( // 553
prmBuilder("=="),
intBuilder(0),
argBuilder(5, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(6, false),
),
appBuilder( // 554
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp289
appBuilder( // 555
comBuilder(2,580),
),
// AExp290
appBuilder( // 556
comBuilder(3,560),
argBuilder(0, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 557
prmBuilder("-"),
argBuilder(1, true),
intBuilder(1),
),
// AExp291
appBuilder( // 558
argBuilder(0, true),
comBuilder(2,552),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(1, true),
),
appBuilder( // 559
comBuilder(7,553),
comBuilder(3,0),
comBuilder(1,555),
comBuilder(3,556),
),
// AExp292
appBuilder( // 560
comBuilder(1,112),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
comBuilder(1,0),
comBuilder(1,551),
ptrBuilder(0, true, true),
),
appBuilder( // 561
comBuilder(3,558),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 562
comBuilder(2,548),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 563
prmBuilder("<"),
argBuilder(1, false),
intBuilder(0),
),
// AExp293
appBuilder( // 564
intBuilder(0),
),
// AExp294
appBuilder( // 565
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 566
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp295
appBuilder( // 567
comBuilder(2,586),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 568
prmBuilder("-"),
argBuilder(1, true),
intBuilder(75),
),
// AExp296
appBuilder( // 569
comBuilder(2,586),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 570
prmBuilder("-"),
argBuilder(1, true),
intBuilder(50),
),
// AExp297
appBuilder( // 571
prmBuilder("<"),
argBuilder(1, false),
intBuilder(75),
comBuilder(3,567),
comBuilder(3,569),
argBuilder(2, true),
argBuilder(1, false),
),
// AExp298
appBuilder( // 572
comBuilder(2,586),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 573
prmBuilder("-"),
argBuilder(1, true),
intBuilder(25),
),
// AExp299
appBuilder( // 574
prmBuilder("<"),
argBuilder(0, false),
intBuilder(50),
comBuilder(3,571),
comBuilder(4,572),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp300
appBuilder( // 575
comBuilder(2,586),
argBuilder(0, true),
argBuilder(1, true),
),
  )
  private def combChunk018: Seq[Vec[Atom]] = Seq(
// AExp301
appBuilder( // 576
prmBuilder("<"),
argBuilder(0, false),
intBuilder(25),
ptrBuilder(0, true, true),
comBuilder(5,575),
argBuilder(1, true),
argBuilder(0, false),
),
appBuilder( // 577
comBuilder(7,565),
comBuilder(3,282),
comBuilder(2,574),
comBuilder(1,0),
),
// AExp302
appBuilder( // 578
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 579
comBuilder(2,576),
argBuilder(1, true),
),
// AExp303
appBuilder( // 580
comBuilder(1,112),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
comBuilder(1,0),
comBuilder(1,564),
ptrBuilder(0, true, true),
),
appBuilder( // 581
comBuilder(2,578),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 582
prmBuilder(">="),
argBuilder(1, false),
intBuilder(100),
),
appBuilder( // 583
prmBuilder("<"),
argBuilder(1, false),
intBuilder(0),
),
// AExp304
appBuilder( // 584
comBuilder(2,588),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 585
comBuilder(1,593),
argBuilder(1, true),
),
// AExp305
appBuilder( // 586
comBuilder(2,327),
ptrBuilder(0, true, true),
intBuilder(2),
),
appBuilder( // 587
comBuilder(2,584),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp306
appBuilder( // 588
comBuilder(1,280),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp307
appBuilder( // 589
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 590
prmBuilder("+"),
argBuilder(0, false),
argBuilder(0, false),
),
appBuilder( // 591
prmBuilder("-"),
argBuilder(2, true),
intBuilder(1),
),
// AExp308
appBuilder( // 592
prmBuilder("=="),
argBuilder(1, false),
intBuilder(0),
comBuilder(3,589),
comBuilder(3,0),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp309
appBuilder( // 593
yBuilder(),
comBuilder(3,592),
argBuilder(0, true),
intBuilder(1),
),
// AExp310
appBuilder( // 594
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp311
appBuilder( // 595
comBuilder(2,600),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 596
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp312
appBuilder( // 597
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 598
comBuilder(2,595),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 599
comBuilder(2,603),
argBuilder(2, false),
argBuilder(0, true),
),
// AExp313
appBuilder( // 600
argBuilder(1, true),
comBuilder(1,594),
comBuilder(3,597),
argBuilder(0, true),
),
// AExp314
appBuilder( // 601
ptrBuilder(163, false, false),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 602
prmBuilder("+"),
argBuilder(0, true),
intBuilder(2),
),
// AExp315
appBuilder( // 603
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 604
comBuilder(1,615),
argBuilder(1, true),
),
appBuilder( // 605
comBuilder(1,601),
argBuilder(0, true),
),
// AExp316
appBuilder( // 606
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 607
comBuilder(2,627),
intBuilder(25),
argBuilder(1, true),
),
  )
  private def combChunk019: Seq[Vec[Atom]] = Seq(
appBuilder( // 608
comBuilder(2,627),
intBuilder(25),
argBuilder(0, true),
),
// AExp317
appBuilder( // 609
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 610
comBuilder(2,627),
intBuilder(25),
argBuilder(2, true),
),
appBuilder( // 611
comBuilder(2,606),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp318
appBuilder( // 612
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 613
comBuilder(2,627),
intBuilder(25),
argBuilder(3, true),
),
appBuilder( // 614
comBuilder(3,609),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp319
appBuilder( // 615
argBuilder(0, true),
comBuilder(4,612),
),
// AExp320
appBuilder( // 616
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp321
appBuilder( // 617
comBuilder(1,542),
ptrBuilder(0, true, true),
),
appBuilder( // 618
comBuilder(2,327),
argBuilder(0, true),
intBuilder(2),
),
// AExp322
appBuilder( // 619
ptrBuilder(55, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 620
comBuilder(1,617),
argBuilder(0, true),
),
// AExp323
appBuilder( // 621
comBuilder(2,627),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 622
comBuilder(2,588),
argBuilder(1, true),
intBuilder(2),
),
appBuilder( // 623
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp324
appBuilder( // 624
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 625
comBuilder(2,621),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 626
comBuilder(1,619),
argBuilder(1, false),
),
// AExp325
appBuilder( // 627
prmBuilder("=="),
intBuilder(0),
argBuilder(0, false),
comBuilder(1,0),
comBuilder(1,616),
ptrBuilder(0, true, true),
),
appBuilder( // 628
comBuilder(2,624),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp326
appBuilder( // 629
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 630
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp327
appBuilder( // 631
comBuilder(1,16),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 632
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, false),
argBuilder(5, true),
argBuilder(6, true),
),
appBuilder( // 633
argBuilder(4, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
),
// AExp328
appBuilder( // 634
comBuilder(7,631),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 635
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp329
appBuilder( // 636
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 637
comBuilder(3,138),
argBuilder(0, true),
),
// AExp330
appBuilder( // 638
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(48, false, false),
comBuilder(1,636),
),
// AExp331
appBuilder( // 639
ptrBuilder(148, false, false),
),
  )
  private def combChunk020: Seq[Vec[Atom]] = Seq(
// AExp332
appBuilder( // 640
comBuilder(7,634),
comBuilder(1,638),
comBuilder(1,639),
ptrBuilder(0, true, true),
),
appBuilder( // 641
argBuilder(0, true),
argBuilder(1, true),
),
// AExp333
appBuilder( // 642
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 643
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp334
appBuilder( // 644
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp335
appBuilder( // 645
argBuilder(0, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(5, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp336
appBuilder( // 646
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp337
appBuilder( // 647
comBuilder(7,645),
ptrBuilder(0, true, true),
argBuilder(5, true),
),
appBuilder( // 648
comBuilder(7,646),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(6, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp338
appBuilder( // 649
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(1, true),
),
// AExp339
appBuilder( // 650
ptrBuilder(134, false, false),
argBuilder(5, true),
ptrBuilder(0, true, true),
),
appBuilder( // 651
prmBuilder("-"),
argBuilder(6, true),
intBuilder(1),
),
// AExp340
appBuilder( // 652
comBuilder(7,650),
),
// AExp341
appBuilder( // 653
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 654
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 655
argBuilder(1, true),
argBuilder(3, false),
),
// AExp342
appBuilder( // 656
comBuilder(7,653),
argBuilder(0, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 657
ptrBuilder(150, false, false),
argBuilder(3, true),
),
appBuilder( // 658
argBuilder(2, true),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, true),
),
appBuilder( // 659
argBuilder(1, true),
argBuilder(4, false),
argBuilder(5, false),
),
// AExp343
appBuilder( // 660
comBuilder(7,656),
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(5, false),
),
appBuilder( // 661
argBuilder(1, true),
argBuilder(6, false),
),
appBuilder( // 662
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp344
appBuilder( // 663
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 664
argBuilder(2, true),
argBuilder(5, true),
),
appBuilder( // 665
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp345
appBuilder( // 666
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 667
ptrBuilder(151, false, false),
argBuilder(4, false),
argBuilder(2, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 668
comBuilder(3,850),
intBuilder(0),
argBuilder(1, true),
argBuilder(4, false),
),
// AExp346
appBuilder( // 669
ptrBuilder(172, false, false),
comBuilder(2,1),
ptrBuilder(0, true, true),
),
appBuilder( // 670
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp347
appBuilder( // 671
comBuilder(7,663),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,669),
),
  )
  private def combChunk021: Seq[Vec[Atom]] = Seq(
appBuilder( // 672
comBuilder(5,666),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp348
appBuilder( // 673
ptrBuilder(134, false, false),
ptrBuilder(0, true, true),
intBuilder(3000),
comBuilder(2,0),
),
appBuilder( // 674
argBuilder(0, true),
argBuilder(1, true),
),
// AExp349
appBuilder( // 675
comBuilder(7,646),
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 676
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp350
appBuilder( // 677
comBuilder(2,673),
ptrBuilder(0, true, true),
),
appBuilder( // 678
comBuilder(5,675),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp351
appBuilder( // 679
comBuilder(1,110),
argBuilder(0, true),
ptrBuilder(1, true, true),
comBuilder(3,652),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 680
comBuilder(7,660),
comBuilder(3,671),
comBuilder(4,677),
),
appBuilder( // 681
prmBuilder("<="),
argBuilder(1, true),
intBuilder(0),
),
// AExp352
appBuilder( // 682
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 683
comBuilder(2,679),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp353
appBuilder( // 684
comBuilder(7,649),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 685
comBuilder(2,682),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
),
// AExp354
appBuilder( // 686
comBuilder(7,642),
comBuilder(5,644),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 687
comBuilder(7,647),
comBuilder(3,684),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp355
appBuilder( // 688
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 689
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(2, false),
),
appBuilder( // 690
argBuilder(0, true),
argBuilder(2, false),
),
// AExp356
appBuilder( // 691
comBuilder(7,688),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 692
argBuilder(1, true),
argBuilder(3, true),
),
// AExp357
appBuilder( // 693
ptrBuilder(134, false, false),
argBuilder(0, true),
intBuilder(3000),
comBuilder(2,0),
),
// AExp358
appBuilder( // 694
argBuilder(0, true),
ptrBuilder(237, false, false),
comBuilder(1,693),
),
// AExp359
appBuilder( // 695
comBuilder(1,16),
argBuilder(2, true),
ptrBuilder(0, true, true),
comBuilder(1,694),
),
appBuilder( // 696
ptrBuilder(235, false, false),
argBuilder(0, true),
argBuilder(3, true),
),
// AExp360
appBuilder( // 697
ptrBuilder(134, false, false),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp361
appBuilder( // 698
comBuilder(1,110),
argBuilder(2, true),
ptrBuilder(0, true, true),
comBuilder(4,695),
comBuilder(4,697),
argBuilder(1, true),
argBuilder(0, true),
ptrBuilder(18, false, false),
),
appBuilder( // 699
prmBuilder("=="),
argBuilder(3, true),
intBuilder(10),
),
// AExp362
appBuilder( // 700
comBuilder(3,251),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 701
comBuilder(4,698),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp363
appBuilder( // 702
comBuilder(7,691),
argBuilder(0, true),
comBuilder(3,700),
argBuilder(1, true),
),
// AExp364
appBuilder( // 703
comBuilder(3,372),
intBuilder(1),
intBuilder(57),
ptrBuilder(0, true, true),
),
  )
  private def combChunk022: Seq[Vec[Atom]] = Seq(
appBuilder( // 704
argBuilder(0, true),
argBuilder(1, true),
),
// AExp365
appBuilder( // 705
comBuilder(2,870),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 706
argBuilder(1, true),
argBuilder(2, true),
),
// AExp366
appBuilder( // 707
comBuilder(1,0),
ptrBuilder(0, true, true),
),
appBuilder( // 708
comBuilder(4,3),
intBuilder(82),
argBuilder(0, true),
),
// AExp367
appBuilder( // 709
comBuilder(2,870),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 710
comBuilder(1,406),
argBuilder(1, true),
),
// AExp368
appBuilder( // 711
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 712
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp369
appBuilder( // 713
comBuilder(4,3),
intBuilder(32),
ptrBuilder(0, true, true),
),
appBuilder( // 714
comBuilder(4,3),
intBuilder(32),
argBuilder(0, true),
),
// AExp370
appBuilder( // 715
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 716
comBuilder(1,0),
argBuilder(0, true),
),
// AExp371
appBuilder( // 717
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 718
comBuilder(1,715),
argBuilder(0, true),
),
// AExp372
appBuilder( // 719
comBuilder(1,16),
argBuilder(1, true),
ptrBuilder(0, true, true),
comBuilder(1,717),
),
appBuilder( // 720
ioBuilder(false),
intBuilder(0),
),
// AExp373
appBuilder( // 721
comBuilder(1,25),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp374
appBuilder( // 722
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(0),
comBuilder(2,719),
comBuilder(2,721),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 723
comBuilder(2,327),
argBuilder(0, true),
intBuilder(2),
),
// AExp375
appBuilder( // 724
yBuilder(),
argBuilder(0, true),
comBuilder(1,371),
),
// AExp376
appBuilder( // 725
comBuilder(2,0),
),
// AExp377
appBuilder( // 726
comBuilder(3,736),
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 727
argBuilder(1, true),
comBuilder(1,371),
comBuilder(2,0),
),
// AExp378
appBuilder( // 728
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 729
argBuilder(3, true),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 730
comBuilder(3,726),
argBuilder(0, false),
argBuilder(1, false),
argBuilder(2, true),
),
// AExp379
appBuilder( // 731
argBuilder(2, true),
comBuilder(2,725),
comBuilder(4,728),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp380
appBuilder( // 732
comBuilder(2,816),
intBuilder(0),
intBuilder(0),
intBuilder(0),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 733
comBuilder(1,825),
argBuilder(2, true),
),
appBuilder( // 734
comBuilder(1,825),
argBuilder(1, true),
),
appBuilder( // 735
comBuilder(1,825),
argBuilder(0, true),
),
  )
  private def combChunk023: Seq[Vec[Atom]] = Seq(
// AExp381
appBuilder( // 736
comBuilder(1,745),
ptrBuilder(0, true, true),
),
appBuilder( // 737
comBuilder(3,732),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp382
appBuilder( // 738
argBuilder(5, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp383
appBuilder( // 739
comBuilder(1,757),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(3, true),
ptrBuilder(0, true, true),
),
appBuilder( // 740
comBuilder(6,738),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp384
appBuilder( // 741
comBuilder(1,757),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 742
comBuilder(4,739),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp385
appBuilder( // 743
comBuilder(1,757),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 744
comBuilder(3,741),
argBuilder(0, true),
),
// AExp386
appBuilder( // 745
comBuilder(1,757),
intBuilder(25),
intBuilder(1),
intBuilder(0),
argBuilder(0, true),
comBuilder(2,743),
),
// AExp387
appBuilder( // 746
prmBuilder("=="),
intBuilder(0),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 747
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp388
appBuilder( // 748
argBuilder(3, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp389
appBuilder( // 749
argBuilder(3, true),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp390
appBuilder( // 750
prmBuilder("+"),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 751
prmBuilder("*"),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp391
appBuilder( // 752
comBuilder(1,757),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 753
comBuilder(3,750),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(4, false),
),
appBuilder( // 754
prmBuilder("+"),
argBuilder(4, false),
argBuilder(4, false),
),
appBuilder( // 755
prmBuilder("-"),
argBuilder(3, true),
intBuilder(1),
),
// AExp392
appBuilder( // 756
argBuilder(3, true),
comBuilder(4,749),
comBuilder(5,752),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp393
appBuilder( // 757
comBuilder(7,746),
comBuilder(3,0),
comBuilder(4,748),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 758
comBuilder(4,756),
argBuilder(0, false),
),
// AExp394
appBuilder( // 759
argBuilder(4, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 760
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, false),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp395
appBuilder( // 761
comBuilder(2,0),
),
// AExp396
appBuilder( // 762
argBuilder(5, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 763
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, true),
),
// AExp397
appBuilder( // 764
comBuilder(2,0),
),
// AExp398
appBuilder( // 765
argBuilder(6, false),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 766
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
argBuilder(3, true),
),
// AExp399
appBuilder( // 767
comBuilder(2,0),
),
  )
  private def combChunk024: Seq[Vec[Atom]] = Seq(
// AExp400
appBuilder( // 768
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
errorBuilder(0),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp401
appBuilder( // 769
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(1, true),
),
// AExp402
appBuilder( // 770
comBuilder(7,0),
argBuilder(0, true),
),
// AExp403
appBuilder( // 771
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, false),
ptrBuilder(0, true, true),
),
appBuilder( // 772
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp404
appBuilder( // 773
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 774
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 775
argBuilder(0, true),
argBuilder(2, false),
argBuilder(6, true),
),
// AExp405
appBuilder( // 776
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 777
prmBuilder("=="),
argBuilder(1, true),
intBuilder(2),
),
appBuilder( // 778
prmBuilder("=="),
argBuilder(0, true),
intBuilder(1),
),
// AExp406
appBuilder( // 779
comBuilder(1,112),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(0),
intBuilder(1),
),
appBuilder( // 780
comBuilder(2,776),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 781
prmBuilder("=="),
argBuilder(1, false),
intBuilder(3),
),
// AExp407
appBuilder( // 782
comBuilder(7,771),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 783
argBuilder(1, true),
argBuilder(4, false),
),
appBuilder( // 784
comBuilder(7,773),
comBuilder(2,779),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, false),
),
// AExp408
appBuilder( // 785
comBuilder(2,816),
argBuilder(3, true),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
),
// AExp409
appBuilder( // 786
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 787
comBuilder(1,818),
argBuilder(1, true),
),
appBuilder( // 788
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp410
appBuilder( // 789
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 790
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp411
appBuilder( // 791
prmBuilder("+"),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 792
prmBuilder("+"),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp412
appBuilder( // 793
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 794
comBuilder(1,818),
argBuilder(1, true),
),
appBuilder( // 795
prmBuilder("+"),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp413
appBuilder( // 796
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 797
comBuilder(1,818),
argBuilder(1, true),
),
appBuilder( // 798
prmBuilder("+"),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp414
appBuilder( // 799
comBuilder(3,793),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
  )
  private def combChunk025: Seq[Vec[Atom]] = Seq(
appBuilder( // 800
comBuilder(3,796),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp415
appBuilder( // 801
comBuilder(7,789),
comBuilder(3,791),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 802
comBuilder(4,799),
argBuilder(1, true),
),
// AExp416
appBuilder( // 803
comBuilder(7,786),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 804
comBuilder(2,801),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp417
appBuilder( // 805
comBuilder(5,782),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 806
comBuilder(3,803),
argBuilder(0, false),
argBuilder(1, false),
),
appBuilder( // 807
comBuilder(6,785),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp418
appBuilder( // 808
argBuilder(2, true),
comBuilder(2,770),
comBuilder(2,805),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp419
appBuilder( // 809
comBuilder(5,769),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 810
comBuilder(3,808),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp420
appBuilder( // 811
argBuilder(3, true),
comBuilder(7,0),
comBuilder(3,809),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp421
appBuilder( // 812
comBuilder(7,765),
comBuilder(1,767),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 813
comBuilder(7,768),
comBuilder(6,0),
comBuilder(5,811),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp422
appBuilder( // 814
comBuilder(7,762),
comBuilder(1,764),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 815
comBuilder(2,812),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp423
appBuilder( // 816
comBuilder(7,759),
comBuilder(1,761),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 817
comBuilder(2,814),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp424
appBuilder( // 818
argBuilder(0, true),
intBuilder(0),
comBuilder(2,0),
),
// AExp425
appBuilder( // 819
comBuilder(3,832),
intBuilder(25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 820
comBuilder(3,832),
intBuilder(25),
argBuilder(1, true),
comBuilder(2,0),
),
// AExp426
appBuilder( // 821
comBuilder(3,832),
intBuilder(25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 822
comBuilder(2,819),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp427
appBuilder( // 823
comBuilder(3,832),
intBuilder(25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 824
comBuilder(3,821),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp428
appBuilder( // 825
argBuilder(0, true),
comBuilder(4,823),
),
// AExp429
appBuilder( // 826
comBuilder(3,832),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 827
comBuilder(2,588),
argBuilder(1, true),
intBuilder(2),
),
appBuilder( // 828
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp430
appBuilder( // 829
comBuilder(4,3),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 830
comBuilder(2,826),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
),
appBuilder( // 831
comBuilder(2,327),
argBuilder(1, false),
intBuilder(2),
),
  )
  private def combChunk026: Seq[Vec[Atom]] = Seq(
// AExp431
appBuilder( // 832
prmBuilder("=="),
intBuilder(0),
argBuilder(0, false),
comBuilder(2,0),
comBuilder(2,1),
ptrBuilder(0, true, true),
argBuilder(2, false),
),
appBuilder( // 833
comBuilder(3,829),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp432
appBuilder( // 834
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp433
appBuilder( // 835
comBuilder(1,25),
ptrBuilder(18, false, false),
comBuilder(1,0),
),
// AExp434
appBuilder( // 836
argBuilder(5, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(4, true),
argBuilder(2, true),
argBuilder(6, true),
argBuilder(3, true),
),
// AExp435
appBuilder( // 837
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 838
argBuilder(3, true),
argBuilder(5, false),
argBuilder(6, true),
),
appBuilder( // 839
comBuilder(2,865),
argBuilder(4, true),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(18, false, false),
argBuilder(5, false),
argBuilder(0, false),
),
// AExp436
appBuilder( // 840
comBuilder(2,603),
),
// AExp437
appBuilder( // 841
comBuilder(1,25),
argBuilder(0, true),
comBuilder(1,0),
),
// AExp438
appBuilder( // 842
comBuilder(3,850),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(0, true),
),
appBuilder( // 843
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
// AExp439
appBuilder( // 844
comBuilder(7,837),
argBuilder(0, true),
comBuilder(1,840),
comBuilder(3,841),
ptrBuilder(0, true, true),
),
appBuilder( // 845
comBuilder(3,842),
argBuilder(1, true),
),
// AExp440
appBuilder( // 846
argBuilder(1, true),
comBuilder(3,0),
ptrBuilder(0, true, true),
errorBuilder(0),
argBuilder(2, true),
argBuilder(0, true),
),
appBuilder( // 847
comBuilder(7,836),
comBuilder(4,0),
comBuilder(3,844),
),
// AExp441
appBuilder( // 848
argBuilder(2, false),
comBuilder(1,835),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 849
comBuilder(3,846),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp442
appBuilder( // 850
argBuilder(1, false),
comBuilder(1,834),
comBuilder(3,24),
ptrBuilder(0, true, true),
),
appBuilder( // 851
comBuilder(3,848),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
),
// AExp443
appBuilder( // 852
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 853
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
appBuilder( // 854
prmBuilder("=="),
argBuilder(0, true),
argBuilder(3, true),
),
// AExp444
appBuilder( // 855
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 856
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(5, true),
argBuilder(6, true),
),
appBuilder( // 857
prmBuilder("=="),
argBuilder(1, true),
argBuilder(4, true),
),
// AExp445
appBuilder( // 858
comBuilder(1,110),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 859
prmBuilder("=="),
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 860
prmBuilder("=="),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp446
appBuilder( // 861
comBuilder(7,852),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 862
comBuilder(7,855),
comBuilder(4,858),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp447
appBuilder( // 863
argBuilder(0, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk027: Seq[Vec[Atom]] = Seq(
appBuilder( // 864
comBuilder(3,861),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp448
appBuilder( // 865
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 866
comBuilder(5,863),
argBuilder(1, true),
),
// AExp449
appBuilder( // 867
comBuilder(4,3),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 868
argBuilder(3, true),
argBuilder(1, true),
),
// AExp450
appBuilder( // 869
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,867),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp451
appBuilder( // 870
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 871
comBuilder(3,869),
argBuilder(1, true),
),
// AExp452
appBuilder( // 872
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 873
argBuilder(0, true),
argBuilder(1, false),
),
// AExp453
appBuilder( // 874
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 875
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp454
appBuilder( // 876
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 877
prmBuilder("=="),
argBuilder(4, true),
intBuilder(91),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(18, false, false),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp455
appBuilder( // 878
argBuilder(14, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 879
comBuilder(7,876),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 880
comBuilder(7,874),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp456
appBuilder( // 881
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
// AExp457
appBuilder( // 882
comBuilder(3,881),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
argBuilder(2, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 883
argBuilder(0, true),
argBuilder(1, true),
),
// AExp458
appBuilder( // 884
argBuilder(0, true),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
appBuilder( // 885
argBuilder(1, true),
argBuilder(2, true),
),
// AExp459
appBuilder( // 886
comBuilder(3,884),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 887
argBuilder(0, true),
argBuilder(2, true),
),
// AExp460
appBuilder( // 888
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
),
// AExp461
appBuilder( // 889
comBuilder(4,888),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 890
argBuilder(0, true),
argBuilder(2, true),
),
// AExp462
appBuilder( // 891
argBuilder(0, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp463
appBuilder( // 892
comBuilder(7,891),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 893
argBuilder(0, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp464
appBuilder( // 894
comBuilder(7,892),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 895
argBuilder(0, true),
argBuilder(6, true),
),
  )
  private def combChunk028: Seq[Vec[Atom]] = Seq(
// AExp465
appBuilder( // 896
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(2, true),
),
appBuilder( // 897
argBuilder(1, true),
argBuilder(3, true),
),
// AExp466
appBuilder( // 898
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
),
// AExp467
appBuilder( // 899
comBuilder(7,789),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
),
appBuilder( // 900
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp468
appBuilder( // 901
argBuilder(0, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp469
appBuilder( // 902
comBuilder(7,901),
ptrBuilder(0, true, true),
),
appBuilder( // 903
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp470
appBuilder( // 904
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 905
comBuilder(7,902),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp471
appBuilder( // 906
comBuilder(7,899),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
),
appBuilder( // 907
comBuilder(7,904),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp472
appBuilder( // 908
comBuilder(7,906),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 909
argBuilder(2, true),
argBuilder(6, true),
),
// AExp473
appBuilder( // 910
comBuilder(7,908),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 911
argBuilder(2, true),
argBuilder(6, true),
),
// AExp474
appBuilder( // 912
comBuilder(7,910),
comBuilder(3,65),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, false),
),
appBuilder( // 913
argBuilder(1, true),
argBuilder(4, false),
),
// AExp475
appBuilder( // 914
argBuilder(0, true),
argBuilder(4, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp476
appBuilder( // 915
comBuilder(5,914),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
appBuilder( // 916
argBuilder(0, true),
argBuilder(4, true),
),
// AExp477
appBuilder( // 917
prmBuilder("=="),
argBuilder(5, true),
intBuilder(104),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
),
appBuilder( // 918
comBuilder(7,565),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp478
appBuilder( // 919
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(6, false),
),
appBuilder( // 920
comBuilder(7,917),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
),
// AExp479
appBuilder( // 921
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(1, true),
),
// AExp480
appBuilder( // 922
comBuilder(7,789),
comBuilder(6,921),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 923
argBuilder(0, true),
argBuilder(2, true),
),
// AExp481
appBuilder( // 924
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 925
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp482
appBuilder( // 926
comBuilder(7,924),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp483
appBuilder( // 927
comBuilder(5,914),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
  )
  private def combChunk029: Seq[Vec[Atom]] = Seq(
appBuilder( // 928
argBuilder(0, true),
argBuilder(4, true),
),
// AExp484
appBuilder( // 929
comBuilder(1,25),
argBuilder(5, true),
ptrBuilder(0, true, true),
),
appBuilder( // 930
comBuilder(3,138),
argBuilder(6, true),
),
// AExp485
appBuilder( // 931
comBuilder(7,929),
),
// AExp486
appBuilder( // 932
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 933
argBuilder(2, true),
argBuilder(3, false),
argBuilder(4, true),
ptrBuilder(133, false, false),
),
appBuilder( // 934
argBuilder(1, true),
argBuilder(3, false),
ptrBuilder(133, false, false),
),
// AExp487
appBuilder( // 935
comBuilder(1,4),
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 936
ptrBuilder(172, false, false),
comBuilder(2,0),
intBuilder(0),
),
appBuilder( // 937
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp488
appBuilder( // 938
comBuilder(7,932),
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 939
argBuilder(1, true),
argBuilder(6, false),
),
appBuilder( // 940
comBuilder(7,935),
argBuilder(0, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
),
// AExp489
appBuilder( // 941
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 942
ptrBuilder(151, false, false),
argBuilder(4, false),
argBuilder(2, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 943
comBuilder(3,850),
intBuilder(0),
argBuilder(1, true),
argBuilder(4, false),
),
// AExp490
appBuilder( // 944
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 945
comBuilder(7,646),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
intBuilder(0),
comBuilder(3,0),
),
// AExp491
appBuilder( // 946
comBuilder(1,25),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 947
comBuilder(3,944),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp492
appBuilder( // 948
prmBuilder("=="),
argBuilder(0, true),
intBuilder(99),
comBuilder(2,931),
ptrBuilder(0, true, true),
),
appBuilder( // 949
comBuilder(7,938),
comBuilder(5,941),
comBuilder(4,946),
),
// AExp493
appBuilder( // 950
comBuilder(7,926),
comBuilder(5,927),
comBuilder(1,948),
),
// AExp494
appBuilder( // 951
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 952
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 953
argBuilder(1, true),
argBuilder(3, false),
),
// AExp495
appBuilder( // 954
comBuilder(7,951),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 955
comBuilder(3,1214),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp496
appBuilder( // 956
comBuilder(7,954),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp497
appBuilder( // 957
comBuilder(7,956),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp498
appBuilder( // 958
comBuilder(7,957),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp499
appBuilder( // 959
comBuilder(7,958),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
  )
  private def combChunk030: Seq[Vec[Atom]] = Seq(
appBuilder( // 960
argBuilder(2, true),
argBuilder(6, true),
),
// AExp500
appBuilder( // 961
comBuilder(7,959),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 962
argBuilder(2, true),
argBuilder(6, false),
),
appBuilder( // 963
argBuilder(1, true),
argBuilder(6, false),
),
// AExp501
appBuilder( // 964
comBuilder(7,961),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 965
argBuilder(2, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 966
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, false),
argBuilder(5, false),
argBuilder(6, false),
),
// AExp502
appBuilder( // 967
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 968
ptrBuilder(172, false, false),
comBuilder(2,0),
argBuilder(5, true),
),
appBuilder( // 969
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(6, true),
),
// AExp503
appBuilder( // 970
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 971
ptrBuilder(151, false, false),
argBuilder(4, false),
argBuilder(2, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 972
comBuilder(3,850),
intBuilder(0),
argBuilder(1, true),
argBuilder(4, false),
),
// AExp504
appBuilder( // 973
comBuilder(7,967),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 974
comBuilder(5,970),
argBuilder(1, true),
),
// AExp505
appBuilder( // 975
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 976
comBuilder(7,646),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
argBuilder(2, true),
comBuilder(3,0),
),
// AExp506
appBuilder( // 977
comBuilder(1,25),
argBuilder(3, true),
ptrBuilder(0, true, true),
),
appBuilder( // 978
comBuilder(4,975),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(4, true),
),
// AExp507
appBuilder( // 979
comBuilder(7,964),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(5,977),
),
appBuilder( // 980
comBuilder(2,973),
argBuilder(1, true),
),
// AExp508
appBuilder( // 981
prmBuilder("=="),
argBuilder(0, true),
intBuilder(103),
comBuilder(3,950),
comBuilder(2,979),
),
// AExp509
appBuilder( // 982
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 983
comBuilder(1,981),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp510
appBuilder( // 984
comBuilder(7,649),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 985
comBuilder(4,982),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp511
appBuilder( // 986
comBuilder(7,789),
comBuilder(3,922),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 987
comBuilder(4,984),
argBuilder(2, true),
),
// AExp512
appBuilder( // 988
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 989
comBuilder(3,1183),
argBuilder(1, true),
intBuilder(1),
intBuilder(0),
),
// AExp513
appBuilder( // 990
comBuilder(7,988),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp514
appBuilder( // 991
comBuilder(7,990),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
  )
  private def combChunk031: Seq[Vec[Atom]] = Seq(
// AExp515
appBuilder( // 992
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 993
comBuilder(3,138),
argBuilder(0, true),
),
// AExp516
appBuilder( // 994
comBuilder(7,991),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,992),
),
// AExp517
appBuilder( // 995
prmBuilder("=="),
argBuilder(1, false),
intBuilder(108),
comBuilder(3,986),
comBuilder(4,994),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp518
appBuilder( // 996
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp519
appBuilder( // 997
comBuilder(7,996),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp520
appBuilder( // 998
comBuilder(7,997),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp521
appBuilder( // 999
comBuilder(7,998),
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 1000
argBuilder(0, true),
argBuilder(3, true),
),
// AExp522
appBuilder( // 1001
comBuilder(3,1183),
argBuilder(0, true),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 1002
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp523
appBuilder( // 1003
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1004
comBuilder(3,138),
argBuilder(0, true),
),
// AExp524
appBuilder( // 1005
prmBuilder("=="),
argBuilder(0, true),
intBuilder(107),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1006
comBuilder(7,999),
comBuilder(1,1001),
comBuilder(1,1003),
),
appBuilder( // 1007
comBuilder(7,565),
comBuilder(3,282),
comBuilder(3,995),
comBuilder(1,0),
),
// AExp525
appBuilder( // 1008
comBuilder(1,1005),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp526
appBuilder( // 1009
comBuilder(3,1008),
),
// AExp527
appBuilder( // 1010
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1011
comBuilder(3,1183),
argBuilder(1, true),
intBuilder(0),
intBuilder(1),
),
// AExp528
appBuilder( // 1012
comBuilder(7,1010),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp529
appBuilder( // 1013
comBuilder(7,1012),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp530
appBuilder( // 1014
comBuilder(7,1013),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp531
appBuilder( // 1015
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1016
comBuilder(3,138),
argBuilder(0, true),
),
// AExp532
appBuilder( // 1017
prmBuilder("=="),
argBuilder(1, false),
intBuilder(106),
comBuilder(1,1009),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 1018
comBuilder(7,1014),
comBuilder(1,1015),
),
// AExp533
appBuilder( // 1019
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp534
appBuilder( // 1020
comBuilder(7,1019),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp535
appBuilder( // 1021
comBuilder(7,1020),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp536
appBuilder( // 1022
comBuilder(7,1021),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp537
appBuilder( // 1023
comBuilder(3,1183),
argBuilder(0, true),
ptrBuilder(0, true, true),
intBuilder(0),
),
  )
  private def combChunk032: Seq[Vec[Atom]] = Seq(
appBuilder( // 1024
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp538
appBuilder( // 1025
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1026
comBuilder(3,138),
argBuilder(0, true),
),
// AExp539
appBuilder( // 1027
comBuilder(7,1022),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,1025),
),
appBuilder( // 1028
comBuilder(1,1023),
argBuilder(1, true),
),
// AExp540
appBuilder( // 1029
comBuilder(7,919),
comBuilder(3,65),
comBuilder(3,282),
comBuilder(3,1017),
comBuilder(1,0),
comBuilder(3,1027),
),
// AExp541
appBuilder( // 1030
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1031
comBuilder(2,1276),
argBuilder(1, true),
intBuilder(0),
),
// AExp542
appBuilder( // 1032
comBuilder(7,1030),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp543
appBuilder( // 1033
comBuilder(7,1032),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp544
appBuilder( // 1034
comBuilder(7,1033),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp545
appBuilder( // 1035
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1036
comBuilder(3,138),
argBuilder(0, true),
),
// AExp546
appBuilder( // 1037
comBuilder(7,1034),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,1035),
),
// AExp547
appBuilder( // 1038
prmBuilder("=="),
argBuilder(1, false),
intBuilder(45),
comBuilder(1,1029),
comBuilder(4,1037),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp548
appBuilder( // 1039
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1040
comBuilder(2,1276),
argBuilder(1, true),
intBuilder(1),
),
// AExp549
appBuilder( // 1041
comBuilder(7,1039),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp550
appBuilder( // 1042
comBuilder(7,1041),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp551
appBuilder( // 1043
comBuilder(7,1042),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp552
appBuilder( // 1044
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1045
comBuilder(3,138),
argBuilder(0, true),
),
// AExp553
appBuilder( // 1046
comBuilder(7,1043),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,1044),
),
// AExp554
appBuilder( // 1047
prmBuilder("=="),
argBuilder(0, true),
intBuilder(111),
ptrBuilder(0, true, true),
comBuilder(5,1046),
),
appBuilder( // 1048
comBuilder(7,565),
comBuilder(3,282),
comBuilder(3,1038),
comBuilder(1,0),
),
// AExp555
appBuilder( // 1049
comBuilder(7,642),
comBuilder(4,217),
ptrBuilder(0, true, true),
),
appBuilder( // 1050
comBuilder(5,912),
comBuilder(5,915),
comBuilder(1,1047),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp556
appBuilder( // 1051
comBuilder(7,898),
comBuilder(2,1049),
),
// AExp557
appBuilder( // 1052
comBuilder(1,4),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1053
argBuilder(2, true),
argBuilder(3, false),
),
appBuilder( // 1054
ptrBuilder(172, false, false),
argBuilder(3, false),
argBuilder(1, true),
),
// AExp558
appBuilder( // 1055
comBuilder(7,1052),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk033: Seq[Vec[Atom]] = Seq(
appBuilder( // 1056
comBuilder(1,1278),
argBuilder(3, true),
),
// AExp559
appBuilder( // 1057
comBuilder(7,1055),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp560
appBuilder( // 1058
comBuilder(7,1057),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp561
appBuilder( // 1059
comBuilder(7,1058),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp562
appBuilder( // 1060
comBuilder(7,1059),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
),
appBuilder( // 1061
argBuilder(2, true),
argBuilder(3, true),
),
// AExp563
appBuilder( // 1062
comBuilder(1,25),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1063
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp564
appBuilder( // 1064
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1065
comBuilder(7,646),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(0, true),
comBuilder(3,0),
),
// AExp565
appBuilder( // 1066
comBuilder(7,1060),
argBuilder(0, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1067
comBuilder(7,1062),
comBuilder(5,1064),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp566
appBuilder( // 1068
comBuilder(7,896),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1069
prmBuilder("=="),
argBuilder(0, true),
intBuilder(32),
comBuilder(1,1051),
comBuilder(5,1066),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp567
appBuilder( // 1070
comBuilder(3,65),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 1071
comBuilder(4,1068),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp568
appBuilder( // 1072
comBuilder(1,25),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp569
appBuilder( // 1073
comBuilder(7,1072),
argBuilder(0, true),
),
// AExp570
appBuilder( // 1074
comBuilder(7,1073),
argBuilder(0, true),
),
// AExp571
appBuilder( // 1075
comBuilder(7,1074),
argBuilder(0, true),
),
// AExp572
appBuilder( // 1076
prmBuilder("=="),
argBuilder(0, false),
intBuilder(113),
comBuilder(4,1070),
comBuilder(7,1075),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp573
appBuilder( // 1077
comBuilder(3,65),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 1078
comBuilder(2,1076),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp574
appBuilder( // 1079
comBuilder(1,25),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp575
appBuilder( // 1080
comBuilder(7,1079),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp576
appBuilder( // 1081
comBuilder(7,1080),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp577
appBuilder( // 1082
comBuilder(7,1081),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp578
appBuilder( // 1083
comBuilder(7,1082),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1084
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
// AExp579
appBuilder( // 1085
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1086
comBuilder(7,646),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,1),
),
// AExp580
appBuilder( // 1087
prmBuilder("=="),
argBuilder(0, true),
intBuilder(27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
ptrBuilder(18, false, false),
),
  )
  private def combChunk034: Seq[Vec[Atom]] = Seq(
appBuilder( // 1088
comBuilder(7,1083),
comBuilder(5,1085),
),
appBuilder( // 1089
comBuilder(7,894),
comBuilder(3,1077),
),
// AExp581
appBuilder( // 1090
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1091
comBuilder(1,1087),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp582
appBuilder( // 1092
comBuilder(3,889),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 1093
comBuilder(3,1090),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp583
appBuilder( // 1094
comBuilder(7,789),
comBuilder(3,886),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1095
comBuilder(3,1092),
argBuilder(0, true),
),
// AExp584
appBuilder( // 1096
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
ptrBuilder(18, false, false),
),
appBuilder( // 1097
argBuilder(1, true),
argBuilder(2, true),
),
// AExp585
appBuilder( // 1098
comBuilder(1,25),
argBuilder(6, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1099
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp586
appBuilder( // 1100
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1101
comBuilder(7,646),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,0),
),
// AExp587
appBuilder( // 1102
comBuilder(7,1098),
comBuilder(5,1100),
),
// AExp588
appBuilder( // 1103
comBuilder(7,878),
comBuilder(3,882),
comBuilder(1,1094),
comBuilder(6,1096),
comBuilder(1,1102),
argBuilder(0, true),
argBuilder(3, true),
),
// AExp589
appBuilder( // 1104
comBuilder(1,25),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1105
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp590
appBuilder( // 1106
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1107
comBuilder(7,646),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,24),
),
// AExp591
appBuilder( // 1108
comBuilder(7,1104),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1109
comBuilder(5,1106),
argBuilder(1, true),
),
// AExp592
appBuilder( // 1110
argBuilder(0, true),
ptrBuilder(18, false, false),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(6, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp593
appBuilder( // 1111
argBuilder(0, true),
argBuilder(4, true),
argBuilder(1, true),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
ptrBuilder(18, false, false),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp594
appBuilder( // 1112
comBuilder(5,1111),
ptrBuilder(0, true, true),
),
appBuilder( // 1113
argBuilder(0, true),
argBuilder(1, true),
),
// AExp595
appBuilder( // 1114
prmBuilder("=="),
argBuilder(5, true),
intBuilder(66),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(6, true),
argBuilder(4, true),
),
appBuilder( // 1115
comBuilder(7,565),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp596
appBuilder( // 1116
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(6, false),
),
appBuilder( // 1117
comBuilder(7,1114),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, false),
),
// AExp597
appBuilder( // 1118
comBuilder(1,25),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1119
argBuilder(0, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(6, true),
),
  )
  private def combChunk035: Seq[Vec[Atom]] = Seq(
// AExp598
appBuilder( // 1120
comBuilder(3,138),
ptrBuilder(0, true, true),
),
appBuilder( // 1121
comBuilder(7,646),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
comBuilder(3,0),
),
// AExp599
appBuilder( // 1122
comBuilder(7,1118),
comBuilder(5,1120),
),
// AExp600
appBuilder( // 1123
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp601
appBuilder( // 1124
comBuilder(3,1183),
argBuilder(0, true),
ptrBuilder(0, true, true),
intBuilder(0),
),
appBuilder( // 1125
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp602
appBuilder( // 1126
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1127
comBuilder(3,138),
argBuilder(0, true),
),
// AExp603
appBuilder( // 1128
comBuilder(7,1123),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,1126),
),
appBuilder( // 1129
comBuilder(1,1124),
argBuilder(1, true),
),
// AExp604
appBuilder( // 1130
prmBuilder("=="),
argBuilder(1, true),
intBuilder(68),
comBuilder(2,1122),
comBuilder(4,1128),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp605
appBuilder( // 1131
comBuilder(7,789),
comBuilder(3,282),
comBuilder(3,1130),
comBuilder(1,0),
),
// AExp606
appBuilder( // 1132
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1133
comBuilder(3,1183),
argBuilder(1, true),
intBuilder(1),
intBuilder(0),
),
// AExp607
appBuilder( // 1134
comBuilder(7,1132),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(0, true),
),
// AExp608
appBuilder( // 1135
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1136
comBuilder(3,138),
argBuilder(0, true),
),
// AExp609
appBuilder( // 1137
prmBuilder("=="),
argBuilder(1, false),
intBuilder(67),
comBuilder(1,1131),
ptrBuilder(0, true, true),
argBuilder(2, true),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 1138
comBuilder(7,1134),
comBuilder(1,1135),
),
// AExp610
appBuilder( // 1139
comBuilder(1,16),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 1140
comBuilder(3,1183),
argBuilder(1, true),
intBuilder(0),
intBuilder(1),
),
// AExp611
appBuilder( // 1141
comBuilder(7,1139),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp612
appBuilder( // 1142
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1143
comBuilder(3,138),
argBuilder(0, true),
),
// AExp613
appBuilder( // 1144
comBuilder(7,1141),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(1,1142),
),
// AExp614
appBuilder( // 1145
comBuilder(7,1116),
comBuilder(3,65),
comBuilder(3,282),
comBuilder(3,1137),
comBuilder(1,0),
comBuilder(3,1144),
),
// AExp615
appBuilder( // 1146
comBuilder(1,16),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp616
appBuilder( // 1147
comBuilder(7,1146),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp617
appBuilder( // 1148
comBuilder(3,1183),
argBuilder(0, true),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 1149
prmBuilder("-"),
intBuilder(0),
intBuilder(1),
),
// AExp618
appBuilder( // 1150
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1151
comBuilder(3,138),
argBuilder(0, true),
),
  )
  private def combChunk036: Seq[Vec[Atom]] = Seq(
// AExp619
appBuilder( // 1152
comBuilder(7,1147),
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(1,1150),
),
appBuilder( // 1153
comBuilder(1,1148),
argBuilder(1, true),
),
// AExp620
appBuilder( // 1154
prmBuilder("=="),
argBuilder(0, false),
intBuilder(65),
comBuilder(1,1145),
comBuilder(4,1152),
ptrBuilder(18, false, false),
argBuilder(1, true),
argBuilder(0, false),
),
// AExp621
appBuilder( // 1155
comBuilder(7,1110),
ptrBuilder(0, true, true),
),
appBuilder( // 1156
comBuilder(2,1112),
comBuilder(2,1154),
argBuilder(0, true),
),
// AExp622
appBuilder( // 1157
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1158
argBuilder(1, true),
argBuilder(4, true),
argBuilder(5, true),
argBuilder(3, false),
argBuilder(2, false),
),
appBuilder( // 1159
argBuilder(0, true),
argBuilder(3, false),
argBuilder(2, false),
),
// AExp623
appBuilder( // 1160
comBuilder(7,1157),
ptrBuilder(3, true, true),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1161
argBuilder(5, true),
argBuilder(6, false),
),
appBuilder( // 1162
comBuilder(2,1185),
intBuilder(0),
argBuilder(4, true),
),
appBuilder( // 1163
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 1164
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, true),
argBuilder(6, false),
),
// AExp624
appBuilder( // 1165
comBuilder(7,1160),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(5, true),
argBuilder(6, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1166
argBuilder(3, true),
argBuilder(4, true),
),
appBuilder( // 1167
argBuilder(2, true),
argBuilder(6, false),
),
// AExp625
appBuilder( // 1168
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1169
ptrBuilder(151, false, false),
argBuilder(0, false),
argBuilder(4, true),
argBuilder(3, true),
comBuilder(2,1),
),
appBuilder( // 1170
ptrBuilder(151, false, false),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, true),
comBuilder(2,0),
),
// AExp626
appBuilder( // 1171
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1172
comBuilder(7,646),
argBuilder(0, true),
argBuilder(4, true),
argBuilder(3, true),
argBuilder(1, true),
argBuilder(2, true),
comBuilder(3,0),
),
// AExp627
appBuilder( // 1173
comBuilder(2,1186),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1174
prmBuilder("+"),
argBuilder(1, true),
argBuilder(0, true),
),
appBuilder( // 1175
prmBuilder("-"),
intBuilder(100),
intBuilder(1),
),
// AExp628
appBuilder( // 1176
comBuilder(2,1186),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1177
prmBuilder("+"),
argBuilder(1, true),
argBuilder(0, true),
),
appBuilder( // 1178
prmBuilder("-"),
intBuilder(80),
intBuilder(1),
),
// AExp629
appBuilder( // 1179
comBuilder(2,1185),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 1180
comBuilder(2,1176),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp630
appBuilder( // 1181
comBuilder(7,1165),
comBuilder(5,1168),
comBuilder(5,1171),
ptrBuilder(0, true, true),
comBuilder(2,1179),
),
appBuilder( // 1182
comBuilder(2,1173),
argBuilder(0, true),
),
// AExp631
appBuilder( // 1183
argBuilder(0, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk037: Seq[Vec[Atom]] = Seq(
appBuilder( // 1184
comBuilder(1,1181),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp632
appBuilder( // 1185
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,1),
comBuilder(2,0),
argBuilder(1, false),
argBuilder(0, false),
),
// AExp633
appBuilder( // 1186
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,1),
comBuilder(2,0),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp634
appBuilder( // 1187
comBuilder(3,1227),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1188
prmBuilder("+"),
argBuilder(1, true),
intBuilder(2),
),
appBuilder( // 1189
prmBuilder("+"),
argBuilder(2, false),
intBuilder(1),
),
appBuilder( // 1190
argBuilder(0, true),
argBuilder(2, false),
),
// AExp635
appBuilder( // 1191
comBuilder(3,1227),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1192
prmBuilder("+"),
argBuilder(1, true),
intBuilder(1),
),
appBuilder( // 1193
prmBuilder("+"),
argBuilder(2, false),
intBuilder(2),
),
appBuilder( // 1194
argBuilder(0, true),
argBuilder(2, false),
),
// AExp636
appBuilder( // 1195
comBuilder(3,1227),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
intBuilder(1),
),
appBuilder( // 1196
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp637
appBuilder( // 1197
comBuilder(3,1191),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 1198
comBuilder(3,1195),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp638
appBuilder( // 1199
comBuilder(3,1227),
ptrBuilder(1, true, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1200
prmBuilder("+"),
argBuilder(1, false),
intBuilder(2),
),
appBuilder( // 1201
comBuilder(2,1197),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp639
appBuilder( // 1202
comBuilder(3,1187),
ptrBuilder(0, true, true),
argBuilder(1, false),
),
appBuilder( // 1203
comBuilder(3,1199),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp640
appBuilder( // 1204
comBuilder(3,1227),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 1205
prmBuilder("+"),
argBuilder(2, false),
intBuilder(2),
),
appBuilder( // 1206
prmBuilder("+"),
argBuilder(1, false),
intBuilder(2),
),
appBuilder( // 1207
comBuilder(2,1202),
argBuilder(0, true),
argBuilder(2, false),
argBuilder(1, false),
),
// AExp641
appBuilder( // 1208
prmBuilder("-"),
intBuilder(100),
intBuilder(3),
),
// AExp642
appBuilder( // 1209
prmBuilder(">"),
argBuilder(0, false),
ptrBuilder(0, true, true),
comBuilder(1,0),
comBuilder(1,1208),
argBuilder(0, false),
),
appBuilder( // 1210
prmBuilder("-"),
intBuilder(100),
intBuilder(3),
),
// AExp643
appBuilder( // 1211
prmBuilder("-"),
intBuilder(80),
intBuilder(3),
),
// AExp644
appBuilder( // 1212
prmBuilder(">"),
argBuilder(0, false),
ptrBuilder(0, true, true),
comBuilder(1,0),
comBuilder(1,1211),
argBuilder(0, false),
),
appBuilder( // 1213
prmBuilder("-"),
intBuilder(80),
intBuilder(3),
),
// AExp645
appBuilder( // 1214
comBuilder(3,1204),
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1215
comBuilder(1,1212),
argBuilder(2, true),
),
  )
  private def combChunk038: Seq[Vec[Atom]] = Seq(
appBuilder( // 1216
comBuilder(1,1209),
argBuilder(1, true),
),
// AExp646
appBuilder( // 1217
comBuilder(2,0),
),
// AExp647
appBuilder( // 1218
comBuilder(3,1227),
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 1219
prmBuilder("-"),
argBuilder(3, true),
intBuilder(1),
),
// AExp648
appBuilder( // 1220
comBuilder(4,3),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1221
comBuilder(4,1218),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp649
appBuilder( // 1222
comBuilder(4,3),
ptrBuilder(0, true, true),
argBuilder(3, true),
),
appBuilder( // 1223
comBuilder(3,1257),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp650
appBuilder( // 1224
prmBuilder("=="),
argBuilder(1, true),
intBuilder(0),
comBuilder(5,1220),
comBuilder(5,1222),
argBuilder(0, true),
),
// AExp651
appBuilder( // 1225
comBuilder(4,217),
ptrBuilder(0, true, true),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 1226
comBuilder(2,1224),
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp652
appBuilder( // 1227
argBuilder(0, true),
comBuilder(3,1217),
comBuilder(4,1225),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp653
appBuilder( // 1228
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1229
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
// AExp654
appBuilder( // 1230
comBuilder(3,1260),
argBuilder(2, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 1231
prmBuilder("-"),
argBuilder(0, true),
intBuilder(75),
),
// AExp655
appBuilder( // 1232
comBuilder(7,1228),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1233
comBuilder(3,1230),
argBuilder(3, true),
),
// AExp656
appBuilder( // 1234
argBuilder(6, true),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
argBuilder(5, true),
),
appBuilder( // 1235
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp657
appBuilder( // 1236
comBuilder(3,1260),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1237
prmBuilder("-"),
argBuilder(1, true),
intBuilder(50),
),
// AExp658
appBuilder( // 1238
comBuilder(7,1234),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1239
comBuilder(2,1236),
argBuilder(2, true),
),
// AExp659
appBuilder( // 1240
prmBuilder("<"),
argBuilder(2, true),
intBuilder(75),
comBuilder(4,1232),
comBuilder(3,1238),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp660
appBuilder( // 1241
comBuilder(4,217),
ptrBuilder(0, true, true),
argBuilder(2, false),
),
appBuilder( // 1242
comBuilder(3,1240),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, false),
),
// AExp661
appBuilder( // 1243
argBuilder(6, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 1244
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp662
appBuilder( // 1245
comBuilder(3,1260),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1246
prmBuilder("-"),
argBuilder(1, true),
intBuilder(25),
),
// AExp663
appBuilder( // 1247
comBuilder(7,1243),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
  )
  private def combChunk039: Seq[Vec[Atom]] = Seq(
appBuilder( // 1248
comBuilder(2,1245),
argBuilder(1, true),
),
// AExp664
appBuilder( // 1249
prmBuilder("<"),
argBuilder(1, false),
intBuilder(50),
comBuilder(3,1241),
comBuilder(2,1247),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(1, false),
),
// AExp665
appBuilder( // 1250
comBuilder(3,65),
ptrBuilder(0, true, true),
),
appBuilder( // 1251
comBuilder(3,1249),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp666
appBuilder( // 1252
argBuilder(6, true),
ptrBuilder(0, true, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, true),
),
appBuilder( // 1253
comBuilder(3,1260),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp667
appBuilder( // 1254
prmBuilder("<"),
argBuilder(0, false),
intBuilder(25),
comBuilder(2,1250),
comBuilder(7,1252),
argBuilder(2, true),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp668
appBuilder( // 1255
comBuilder(3,282),
ptrBuilder(0, true, true),
comBuilder(1,0),
),
appBuilder( // 1256
comBuilder(3,1254),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp669
appBuilder( // 1257
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1258
comBuilder(3,1255),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp670
appBuilder( // 1259
prmBuilder("=="),
argBuilder(1, true),
intBuilder(1),
prmBuilder("-"),
prmBuilder("+"),
argBuilder(0, true),
),
// AExp671
appBuilder( // 1260
prmBuilder("=="),
ptrBuilder(1, true, true),
argBuilder(2, false),
comBuilder(2,1259),
comBuilder(3,0),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1261
comBuilder(1,593),
argBuilder(1, false),
),
appBuilder( // 1262
comBuilder(2,586),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp672
appBuilder( // 1263
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1264
argBuilder(1, true),
argBuilder(2, false),
argBuilder(5, false),
argBuilder(3, false),
),
appBuilder( // 1265
argBuilder(0, true),
argBuilder(2, false),
argBuilder(5, false),
argBuilder(3, false),
),
// AExp673
appBuilder( // 1266
comBuilder(7,1263),
ptrBuilder(2, true, true),
ptrBuilder(1, true, true),
argBuilder(6, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1267
argBuilder(2, true),
argBuilder(3, true),
argBuilder(4, true),
argBuilder(5, false),
argBuilder(6, false),
),
appBuilder( // 1268
argBuilder(1, true),
argBuilder(5, false),
),
appBuilder( // 1269
argBuilder(0, true),
argBuilder(5, false),
),
// AExp674
appBuilder( // 1270
comBuilder(1,4),
ptrBuilder(18, false, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1271
ptrBuilder(172, false, false),
comBuilder(2,0),
argBuilder(2, true),
),
appBuilder( // 1272
ptrBuilder(151, false, false),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp675
appBuilder( // 1273
comBuilder(1,25),
ptrBuilder(18, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 1274
comBuilder(7,646),
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,0),
argBuilder(2, true),
comBuilder(3,0),
),
// AExp676
appBuilder( // 1275
comBuilder(3,1227),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
argBuilder(0, true),
),
// AExp677
appBuilder( // 1276
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 1277
comBuilder(7,1266),
comBuilder(4,1270),
comBuilder(4,1273),
comBuilder(4,1275),
argBuilder(1, true),
),
// AExp678
appBuilder( // 1278
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
  )
}

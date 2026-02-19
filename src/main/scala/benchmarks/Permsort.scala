package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Permsort extends Benchmark {
override def toString() = "Permsort" 
val combinatorCount = 32
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,3),
ptrBuilder(8, false, false),
),
appBuilder( // 1
comBuilder(4,2),
intBuilder(12),
comBuilder(2,0),
),
appBuilder( // 2
comBuilder(4,2),
intBuilder(12),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(4,2),
intBuilder(6),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(4,2),
intBuilder(9),
ptrBuilder(3, false, false),
),
appBuilder( // 5
comBuilder(4,2),
intBuilder(7),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(4,2),
intBuilder(6),
ptrBuilder(5, false, false),
),
appBuilder( // 7
comBuilder(4,2),
intBuilder(10),
ptrBuilder(6, false, false),
),
appBuilder( // 8
comBuilder(1,6),
ptrBuilder(7, false, false),
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
errorBuilder(3),
comBuilder(2,0),
),
// AExp4
appBuilder( // 4
comBuilder(1,15),
comBuilder(1,24),
ptrBuilder(0, true, true),
),
appBuilder( // 5
comBuilder(1,29),
argBuilder(0, true),
),
// AExp5
appBuilder( // 6
comBuilder(1,3),
ptrBuilder(0, true, true),
),
appBuilder( // 7
comBuilder(1,4),
argBuilder(0, true),
),
// AExp6
appBuilder( // 8
comBuilder(4,2),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 9
argBuilder(0, true),
argBuilder(2, true),
),
// AExp7
appBuilder( // 10
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 11
comBuilder(3,8),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 12
argBuilder(1, false),
argBuilder(3, false),
),
// AExp8
appBuilder( // 13
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(4,10),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 15
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 16
comBuilder(3,13),
argBuilder(0, true),
),
// AExp10
appBuilder( // 17
comBuilder(1,24),
ptrBuilder(0, true, true),
),
appBuilder( // 18
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 19
comBuilder(1,25),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 20
comBuilder(2,17),
argBuilder(1, false),
argBuilder(2, true),
),
appBuilder( // 21
prmBuilder("<="),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp12
appBuilder( // 22
argBuilder(1, true),
comBuilder(2,1),
ptrBuilder(0, true, true),
),
appBuilder( // 23
comBuilder(3,19),
argBuilder(0, true),
),
// AExp13
appBuilder( // 24
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,22),
),
// AExp14
appBuilder( // 25
argBuilder(0, true),
comBuilder(2,0),
),
// AExp15
appBuilder( // 26
comBuilder(1,36),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 27
comBuilder(1,29),
argBuilder(1, true),
),
appBuilder( // 28
comBuilder(1,57),
argBuilder(0, true),
),
// AExp16
appBuilder( // 29
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,26),
),
appBuilder( // 30
comBuilder(4,2),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp17
appBuilder( // 31
comBuilder(2,42),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 32
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 33
argBuilder(0, true),
argBuilder(2, true),
),
// AExp18
appBuilder( // 34
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 35
comBuilder(4,31),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp19
appBuilder( // 36
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(3,34),
argBuilder(0, true),
),
// AExp20
appBuilder( // 38
comBuilder(4,2),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 39
argBuilder(0, true),
argBuilder(2, true),
),
// AExp21
appBuilder( // 40
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 41
comBuilder(3,38),
argBuilder(1, true),
),
// AExp22
appBuilder( // 42
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 43
comBuilder(3,40),
argBuilder(1, true),
),
// AExp23
appBuilder( // 44
comBuilder(4,2),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 45
comBuilder(4,2),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp24
appBuilder( // 46
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 47
comBuilder(4,2),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp25
appBuilder( // 48
comBuilder(1,64),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 49
argBuilder(0, true),
argBuilder(2, true),
),
appBuilder( // 50
comBuilder(4,2),
argBuilder(1, true),
),
// AExp26
appBuilder( // 51
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 52
comBuilder(3,48),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 53
comBuilder(3,46),
argBuilder(0, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp27
appBuilder( // 54
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 55
comBuilder(4,51),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 56
comBuilder(1,44),
argBuilder(0, false),
),
// AExp28
appBuilder( // 57
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 58
comBuilder(3,54),
argBuilder(0, true),
),
// AExp29
appBuilder( // 59
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 60
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 61
argBuilder(0, true),
argBuilder(2, true),
),
// AExp30
appBuilder( // 62
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 63
comBuilder(4,59),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp31
appBuilder( // 64
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 65
comBuilder(3,62),
argBuilder(0, true),
),
)
}
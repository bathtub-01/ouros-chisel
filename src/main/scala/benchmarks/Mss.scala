package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Mss extends Benchmark {
override def toString() = "Mss" 
val combinatorCount = 37
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,4),
ptrBuilder(2, false, false),
),
appBuilder( // 1
prmBuilder("-"),
intBuilder(0),
intBuilder(20),
),
appBuilder( // 2
comBuilder(2,58),
ptrBuilder(1, false, false),
intBuilder(20),
),
// AExp1
appBuilder( // 3
comBuilder(2,12),
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
comBuilder(1,19),
ptrBuilder(3, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,22),
argBuilder(0, true),
),
// AExp3
appBuilder( // 4
comBuilder(1,7),
ptrBuilder(0, true, true),
),
appBuilder( // 5
comBuilder(1,2),
argBuilder(0, true),
),
// AExp4
appBuilder( // 6
prmBuilder(">"),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,1),
comBuilder(2,0),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp5
appBuilder( // 7
argBuilder(0, true),
intBuilder(0),
ptrBuilder(0, true, true),
),
appBuilder( // 8
comBuilder(2,12),
comBuilder(2,6),
),
// AExp6
appBuilder( // 9
argBuilder(3, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
argBuilder(4, true),
argBuilder(1, true),
),
// AExp7
appBuilder( // 11
argBuilder(3, true),
comBuilder(3,0),
comBuilder(5,9),
argBuilder(1, true),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp8
appBuilder( // 12
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(4,11),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp9
appBuilder( // 14
comBuilder(2,0),
),
// AExp10
appBuilder( // 15
comBuilder(4,21),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 16
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 17
argBuilder(2, true),
argBuilder(0, true),
),
// AExp11
appBuilder( // 18
argBuilder(2, true),
comBuilder(2,14),
comBuilder(4,15),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp12
appBuilder( // 19
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 20
comBuilder(3,18),
argBuilder(0, true),
),
// AExp13
appBuilder( // 21
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp14
appBuilder( // 22
comBuilder(1,29),
comBuilder(1,39),
ptrBuilder(0, true, true),
),
appBuilder( // 23
comBuilder(1,45),
argBuilder(0, true),
),
// AExp15
appBuilder( // 24
comBuilder(2,0),
),
// AExp16
appBuilder( // 25
comBuilder(2,34),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 26
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 27
argBuilder(2, true),
argBuilder(0, true),
),
// AExp17
appBuilder( // 28
argBuilder(2, true),
comBuilder(2,24),
comBuilder(4,25),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp18
appBuilder( // 29
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 30
comBuilder(3,28),
argBuilder(0, true),
),
// AExp19
appBuilder( // 31
comBuilder(4,21),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 32
argBuilder(3, true),
argBuilder(1, true),
),
// AExp20
appBuilder( // 33
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,31),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp21
appBuilder( // 34
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 35
comBuilder(3,33),
argBuilder(1, true),
),
// AExp22
appBuilder( // 36
comBuilder(4,21),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(1,39),
argBuilder(1, false),
),
appBuilder( // 38
comBuilder(4,21),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp23
appBuilder( // 39
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,36),
),
// AExp24
appBuilder( // 40
comBuilder(4,21),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp25
appBuilder( // 41
comBuilder(1,45),
ptrBuilder(0, true, true),
),
appBuilder( // 42
comBuilder(1,52),
argBuilder(0, true),
),
// AExp26
appBuilder( // 43
comBuilder(4,21),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 44
comBuilder(1,41),
argBuilder(2, false),
),
// AExp27
appBuilder( // 45
argBuilder(0, false),
comBuilder(1,40),
comBuilder(3,43),
argBuilder(0, false),
),
// AExp28
appBuilder( // 46
comBuilder(2,0),
),
// AExp29
appBuilder( // 47
argBuilder(2, true),
),
// AExp30
appBuilder( // 48
comBuilder(4,21),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 49
comBuilder(1,52),
argBuilder(1, true),
),
// AExp31
appBuilder( // 50
argBuilder(1, false),
comBuilder(1,46),
comBuilder(3,47),
ptrBuilder(0, true, true),
),
appBuilder( // 51
comBuilder(2,48),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp32
appBuilder( // 52
argBuilder(0, true),
errorBuilder(1),
comBuilder(2,50),
),
// AExp33
appBuilder( // 53
comBuilder(2,0),
),
// AExp34
appBuilder( // 54
comBuilder(2,58),
ptrBuilder(0, true, true),
),
appBuilder( // 55
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp35
appBuilder( // 56
comBuilder(4,21),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(1,54),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp36
appBuilder( // 58
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,53),
comBuilder(2,56),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
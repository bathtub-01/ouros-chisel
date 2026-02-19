package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Braun extends Benchmark {
override def toString() = "Braun" 
val combinatorCount = 32
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,2),
ptrBuilder(3, false, false),
),
appBuilder( // 1
comBuilder(2,58),
intBuilder(0),
intBuilder(255),
),
appBuilder( // 2
comBuilder(2,52),
intBuilder(2),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(1,8),
comBuilder(1,13),
ptrBuilder(2, false, false),
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
argBuilder(0, true),
intBuilder(0),
intBuilder(1),
),
// AExp3
appBuilder( // 3
comBuilder(1,10),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 4
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 5
argBuilder(0, true),
argBuilder(2, true),
),
// AExp4
appBuilder( // 6
argBuilder(2, true),
comBuilder(2,1),
ptrBuilder(0, true, true),
),
appBuilder( // 7
comBuilder(4,3),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp5
appBuilder( // 8
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 9
comBuilder(3,6),
argBuilder(0, true),
),
// AExp6
appBuilder( // 10
argBuilder(0, true),
comBuilder(2,0),
),
// AExp7
appBuilder( // 11
comBuilder(1,28),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(1,41),
argBuilder(0, true),
),
// AExp8
appBuilder( // 13
comBuilder(2,20),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(1,11),
argBuilder(0, false),
),
// AExp9
appBuilder( // 15
comBuilder(2,0),
),
// AExp10
appBuilder( // 16
prmBuilder("=="),
argBuilder(0, true),
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 17
comBuilder(2,20),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp11
appBuilder( // 18
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 19
comBuilder(4,16),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp12
appBuilder( // 20
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 21
comBuilder(3,18),
argBuilder(1, false),
),
appBuilder( // 22
argBuilder(1, false),
comBuilder(2,1),
comBuilder(2,15),
),
// AExp13
appBuilder( // 23
comBuilder(2,37),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
comBuilder(1,28),
argBuilder(1, true),
),
appBuilder( // 25
comBuilder(1,28),
argBuilder(0, true),
),
// AExp14
appBuilder( // 26
comBuilder(4,29),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 27
comBuilder(2,23),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp15
appBuilder( // 28
argBuilder(0, true),
comBuilder(3,26),
comBuilder(2,0),
),
// AExp16
appBuilder( // 29
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp17
appBuilder( // 30
comBuilder(4,29),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(2,37),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp18
appBuilder( // 32
comBuilder(4,29),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(3,30),
argBuilder(1, true),
argBuilder(2, true),
argBuilder(3, true),
),
// AExp19
appBuilder( // 34
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 35
comBuilder(4,32),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 36
comBuilder(4,29),
argBuilder(1, false),
argBuilder(2, false),
),
// AExp20
appBuilder( // 37
argBuilder(0, true),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 38
comBuilder(3,34),
argBuilder(1, false),
),
// AExp21
appBuilder( // 39
comBuilder(2,44),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 40
comBuilder(1,41),
argBuilder(1, true),
),
// AExp22
appBuilder( // 41
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,39),
),
// AExp23
appBuilder( // 42
comBuilder(5,47),
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(2, true),
),
appBuilder( // 43
comBuilder(2,44),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp24
appBuilder( // 44
argBuilder(1, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 45
comBuilder(5,47),
argBuilder(0, false),
comBuilder(2,1),
comBuilder(2,1),
),
appBuilder( // 46
comBuilder(4,42),
argBuilder(0, false),
),
// AExp25
appBuilder( // 47
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp26
appBuilder( // 48
comBuilder(2,52),
ptrBuilder(0, true, true),
),
appBuilder( // 49
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp27
appBuilder( // 50
comBuilder(4,29),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 51
comBuilder(1,48),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp28
appBuilder( // 52
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 53
comBuilder(2,50),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp29
appBuilder( // 54
comBuilder(2,58),
ptrBuilder(0, true, true),
),
appBuilder( // 55
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp30
appBuilder( // 56
comBuilder(4,29),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(1,54),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp31
appBuilder( // 58
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 59
comBuilder(2,56),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object TreePari extends Benchmark {
override def toString() = "TreePari" 
val combinatorCount = 23
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,2),
ptrBuilder(2, false, false),
),
appBuilder( // 1
comBuilder(1,30),
intBuilder(10),
),
appBuilder( // 2
comBuilder(1,12),
comBuilder(1,22),
ptrBuilder(1, false, false),
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
intBuilder(42),
),
// AExp3
appBuilder( // 3
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp4
appBuilder( // 4
comBuilder(0,17),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 5
argBuilder(0, false),
argBuilder(2, true),
),
appBuilder( // 6
argBuilder(0, false),
argBuilder(1, true),
),
// AExp5
appBuilder( // 7
comBuilder(0,17),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 8
argBuilder(3, true),
argBuilder(4, true),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 9
comBuilder(3,4),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp6
appBuilder( // 10
argBuilder(2, false),
comBuilder(2,3),
ptrBuilder(0, true, true),
argBuilder(0, true),
argBuilder(2, false),
),
appBuilder( // 11
comBuilder(5,7),
argBuilder(1, true),
),
// AExp7
appBuilder( // 12
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(3,10),
argBuilder(0, true),
),
// AExp8
appBuilder( // 14
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp9
appBuilder( // 15
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,1),
),
// AExp10
appBuilder( // 16
argBuilder(0, true),
comBuilder(1,14),
comBuilder(1,15),
),
// AExp11
appBuilder( // 17
comBuilder(1,16),
),
// AExp12
appBuilder( // 18
comBuilder(2,0),
),
// AExp13
appBuilder( // 19
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,18),
),
// AExp14
appBuilder( // 20
comBuilder(2,0),
),
// AExp15
appBuilder( // 21
argBuilder(0, true),
comBuilder(1,19),
comBuilder(3,20),
),
// AExp16
appBuilder( // 22
argBuilder(0, true),
comBuilder(2,0),
comBuilder(1,21),
),
// AExp17
appBuilder( // 23
comBuilder(4,31),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
comBuilder(1,30),
argBuilder(0, false),
),
appBuilder( // 25
comBuilder(1,30),
argBuilder(0, false),
),
// AExp18
appBuilder( // 26
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp19
appBuilder( // 27
comBuilder(1,23),
ptrBuilder(0, true, true),
),
appBuilder( // 28
comBuilder(1,26),
argBuilder(0, true),
),
// AExp20
appBuilder( // 29
comBuilder(2,0),
),
// AExp21
appBuilder( // 30
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,27),
comBuilder(1,29),
argBuilder(0, false),
),
// AExp22
appBuilder( // 31
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
)
}
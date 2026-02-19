package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object TreePari extends Benchmark {
override def toString() = "TreePari" 
val combinatorCount = 17
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,2),
ptrBuilder(2, false, false),
),
appBuilder( // 1
comBuilder(1,28),
intBuilder(10),
),
appBuilder( // 2
comBuilder(1,12),
comBuilder(1,21),
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
comBuilder(2,14),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 4
argBuilder(0, false),
argBuilder(2, true),
),
appBuilder( // 5
argBuilder(0, false),
argBuilder(1, true),
),
// AExp4
appBuilder( // 6
comBuilder(2,14),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 7
argBuilder(0, true),
argBuilder(2, true),
comBuilder(2,1),
comBuilder(2,0),
),
appBuilder( // 8
comBuilder(3,3),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, true),
),
// AExp5
appBuilder( // 9
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(5,6),
argBuilder(0, false),
argBuilder(1, true),
argBuilder(2, false),
),
appBuilder( // 11
argBuilder(0, false),
comBuilder(2,0),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp6
appBuilder( // 12
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(3,9),
argBuilder(0, true),
),
// AExp7
appBuilder( // 14
argBuilder(0, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 15
argBuilder(1, false),
comBuilder(2,0),
comBuilder(2,1),
),
appBuilder( // 16
argBuilder(1, false),
comBuilder(2,1),
comBuilder(2,0),
),
// AExp8
appBuilder( // 17
comBuilder(2,0),
),
// AExp9
appBuilder( // 18
comBuilder(2,0),
),
// AExp10
appBuilder( // 19
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,18),
),
appBuilder( // 20
argBuilder(1, true),
comBuilder(2,1),
comBuilder(2,17),
),
// AExp11
appBuilder( // 21
argBuilder(0, true),
comBuilder(2,0),
comBuilder(2,19),
),
// AExp12
appBuilder( // 22
comBuilder(4,30),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 23
comBuilder(1,28),
argBuilder(0, false),
),
appBuilder( // 24
comBuilder(1,28),
argBuilder(0, false),
),
// AExp13
appBuilder( // 25
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp14
appBuilder( // 26
comBuilder(1,22),
ptrBuilder(0, true, true),
),
appBuilder( // 27
comBuilder(1,25),
argBuilder(0, true),
),
// AExp15
appBuilder( // 28
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 29
comBuilder(1,26),
argBuilder(0, false),
),
// AExp16
appBuilder( // 30
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
)
}
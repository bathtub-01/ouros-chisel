package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object TreeSum extends Benchmark {
override def toString() = "TreeSum" 
val combinatorCount = 11
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,7),
ptrBuilder(1, false, false),
),
appBuilder( // 1
comBuilder(1,15),
intBuilder(13),
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
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,7),
argBuilder(1, true),
),
appBuilder( // 4
comBuilder(1,7),
argBuilder(0, true),
),
// AExp3
appBuilder( // 5
prmBuilder("+"),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 6
comBuilder(2,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp4
appBuilder( // 7
argBuilder(0, true),
intBuilder(1),
comBuilder(2,5),
),
// AExp5
appBuilder( // 8
comBuilder(4,16),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 9
comBuilder(1,15),
argBuilder(0, false),
),
appBuilder( // 10
comBuilder(1,15),
argBuilder(0, false),
),
// AExp6
appBuilder( // 11
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp7
appBuilder( // 12
comBuilder(1,8),
ptrBuilder(0, true, true),
),
appBuilder( // 13
comBuilder(1,11),
argBuilder(0, true),
),
// AExp8
appBuilder( // 14
comBuilder(2,0),
),
// AExp9
appBuilder( // 15
prmBuilder("=="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,12),
comBuilder(1,14),
argBuilder(0, false),
),
// AExp10
appBuilder( // 16
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
)
}
package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Fib extends Benchmark {
override def toString() = "Fib" 
val combinatorCount = 7
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,10),
intBuilder(17),
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
comBuilder(1,10),
ptrBuilder(0, true, true),
),
appBuilder( // 3
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp3
appBuilder( // 4
comBuilder(1,10),
ptrBuilder(0, true, true),
),
appBuilder( // 5
prmBuilder("-"),
argBuilder(0, true),
intBuilder(2),
),
// AExp4
appBuilder( // 6
prmBuilder("+"),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 7
comBuilder(1,4),
argBuilder(0, false),
),
appBuilder( // 8
comBuilder(1,2),
argBuilder(0, false),
),
// AExp5
appBuilder( // 9
intBuilder(1),
),
// AExp6
appBuilder( // 10
prmBuilder("<="),
argBuilder(0, false),
intBuilder(1),
comBuilder(1,6),
comBuilder(1,9),
argBuilder(0, false),
),
)
}
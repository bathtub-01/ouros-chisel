package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Queens extends Benchmark {
override def toString() = "Queens" 
val combinatorCount = 36
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,2),
intBuilder(6),
),
// AExp1
appBuilder( // 1
yBuilder(),
comBuilder(3,6),
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
ptrBuilder(1, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(2,14),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp3
appBuilder( // 4
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 5
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp4
appBuilder( // 6
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,4),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp5
appBuilder( // 7
comBuilder(2,14),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 8
prmBuilder("-"),
argBuilder(1, true),
intBuilder(1),
),
// AExp6
appBuilder( // 9
comBuilder(1,20),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(2,7),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 11
comBuilder(2,27),
argBuilder(0, false),
),
// AExp7
appBuilder( // 12
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 13
comBuilder(4,12),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp9
appBuilder( // 14
prmBuilder("=="),
argBuilder(1, false),
intBuilder(0),
comBuilder(2,9),
comBuilder(2,13),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp10
appBuilder( // 15
comBuilder(2,0),
),
// AExp11
appBuilder( // 16
comBuilder(2,25),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 17
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 18
argBuilder(2, true),
argBuilder(0, true),
),
// AExp12
appBuilder( // 19
argBuilder(2, true),
comBuilder(2,15),
comBuilder(4,16),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp13
appBuilder( // 20
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 21
comBuilder(3,19),
argBuilder(0, true),
),
// AExp14
appBuilder( // 22
comBuilder(4,12),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 23
argBuilder(3, true),
argBuilder(1, true),
),
// AExp15
appBuilder( // 24
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,22),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp16
appBuilder( // 25
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 26
comBuilder(3,24),
argBuilder(1, true),
),
// AExp17
appBuilder( // 27
comBuilder(1,20),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 28
comBuilder(1,61),
argBuilder(0, true),
),
appBuilder( // 29
comBuilder(2,33),
argBuilder(1, true),
),
// AExp18
appBuilder( // 30
comBuilder(2,0),
),
// AExp19
appBuilder( // 31
comBuilder(4,12),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 32
comBuilder(4,12),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp20
appBuilder( // 33
comBuilder(1,52),
argBuilder(1, false),
intBuilder(1),
argBuilder(0, false),
comBuilder(2,30),
comBuilder(2,31),
argBuilder(1, false),
argBuilder(0, false),
),
// AExp21
appBuilder( // 34
comBuilder(2,1),
),
// AExp22
appBuilder( // 35
prmBuilder("/="),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 36
prmBuilder("+"),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp23
appBuilder( // 37
prmBuilder("/="),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 38
prmBuilder("-"),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp24
appBuilder( // 39
argBuilder(0, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 40
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp25
appBuilder( // 41
comBuilder(1,55),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 42
comBuilder(3,39),
argBuilder(0, true),
argBuilder(2, true),
argBuilder(4, false),
),
appBuilder( // 43
comBuilder(3,37),
argBuilder(1, true),
argBuilder(3, true),
argBuilder(4, false),
),
// AExp26
appBuilder( // 44
comBuilder(1,55),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 45
comBuilder(5,41),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, false),
argBuilder(4, false),
),
appBuilder( // 46
comBuilder(3,35),
argBuilder(1, false),
argBuilder(3, false),
argBuilder(4, false),
),
// AExp27
appBuilder( // 47
comBuilder(1,55),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(5,44),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, true),
argBuilder(3, false),
argBuilder(4, true),
),
appBuilder( // 49
prmBuilder("/="),
argBuilder(3, false),
argBuilder(1, false),
),
// AExp28
appBuilder( // 50
argBuilder(3, true),
comBuilder(2,34),
ptrBuilder(0, true, true),
argBuilder(0, true),
argBuilder(2, true),
),
appBuilder( // 51
comBuilder(5,47),
argBuilder(1, true),
),
// AExp29
appBuilder( // 52
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 53
comBuilder(4,50),
argBuilder(0, true),
),
// AExp30
appBuilder( // 54
comBuilder(2,0),
),
// AExp31
appBuilder( // 55
argBuilder(0, true),
comBuilder(1,54),
comBuilder(1,0),
),
// AExp32
appBuilder( // 56
comBuilder(1,61),
ptrBuilder(0, true, true),
),
appBuilder( // 57
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp33
appBuilder( // 58
comBuilder(4,12),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 59
comBuilder(1,56),
argBuilder(0, false),
),
// AExp34
appBuilder( // 60
comBuilder(4,12),
intBuilder(1),
comBuilder(2,0),
),
// AExp35
appBuilder( // 61
prmBuilder("=="),
argBuilder(0, false),
intBuilder(1),
comBuilder(1,58),
comBuilder(1,60),
argBuilder(0, false),
),
)
}
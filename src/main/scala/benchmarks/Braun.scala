package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Braun extends Benchmark {
override def toString() = "Braun" 
val combinatorCount = 40
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,2),
ptrBuilder(3, false, false),
),
appBuilder( // 1
comBuilder(2,57),
intBuilder(0),
intBuilder(255),
),
appBuilder( // 2
comBuilder(2,50),
intBuilder(2),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(1,9),
comBuilder(1,15),
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
comBuilder(2,1),
),
// AExp4
appBuilder( // 4
comBuilder(1,12),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 5
argBuilder(0, true),
argBuilder(2, true),
),
appBuilder( // 6
argBuilder(3, true),
argBuilder(1, true),
),
// AExp5
appBuilder( // 7
argBuilder(2, true),
comBuilder(1,3),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 8
comBuilder(4,4),
argBuilder(1, true),
),
// AExp6
appBuilder( // 9
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(3,7),
argBuilder(0, true),
),
// AExp7
appBuilder( // 11
comBuilder(2,0),
),
// AExp8
appBuilder( // 12
argBuilder(0, true),
comBuilder(1,11),
comBuilder(1,0),
),
// AExp9
appBuilder( // 13
comBuilder(1,29),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(1,39),
argBuilder(0, true),
),
// AExp10
appBuilder( // 15
comBuilder(1,23),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 16
comBuilder(1,13),
argBuilder(0, false),
),
// AExp11
appBuilder( // 17
comBuilder(2,0),
),
// AExp12
appBuilder( // 18
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,17),
),
// AExp13
appBuilder( // 19
comBuilder(2,0),
),
// AExp14
appBuilder( // 20
comBuilder(2,0),
),
// AExp15
appBuilder( // 21
prmBuilder("=="),
argBuilder(2, true),
argBuilder(0, true),
comBuilder(2,20),
comBuilder(1,23),
argBuilder(3, true),
argBuilder(1, true),
),
// AExp16
appBuilder( // 22
argBuilder(2, true),
comBuilder(2,19),
comBuilder(4,21),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp17
appBuilder( // 23
argBuilder(0, true),
comBuilder(1,18),
comBuilder(3,22),
),
// AExp18
appBuilder( // 24
comBuilder(1,36),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 25
comBuilder(1,29),
argBuilder(1, true),
),
appBuilder( // 26
comBuilder(1,29),
argBuilder(0, true),
),
// AExp19
appBuilder( // 27
comBuilder(4,30),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 28
comBuilder(2,24),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp20
appBuilder( // 29
argBuilder(0, true),
comBuilder(3,27),
comBuilder(2,0),
),
// AExp21
appBuilder( // 30
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp22
appBuilder( // 31
comBuilder(4,30),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(1,36),
argBuilder(2, true),
argBuilder(1, true),
),
// AExp23
appBuilder( // 33
comBuilder(4,30),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 34
comBuilder(3,31),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(3, true),
),
// AExp24
appBuilder( // 35
argBuilder(2, true),
comBuilder(4,30),
comBuilder(4,33),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp25
appBuilder( // 36
argBuilder(0, true),
comBuilder(1,0),
comBuilder(3,35),
),
// AExp26
appBuilder( // 37
comBuilder(2,43),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 38
comBuilder(1,39),
argBuilder(1, true),
),
// AExp27
appBuilder( // 39
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,37),
),
// AExp28
appBuilder( // 40
comBuilder(5,44),
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 41
comBuilder(2,43),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp29
appBuilder( // 42
comBuilder(5,44),
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,1),
),
// AExp30
appBuilder( // 43
argBuilder(1, true),
comBuilder(4,40),
comBuilder(1,42),
argBuilder(0, true),
),
// AExp31
appBuilder( // 44
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp32
appBuilder( // 45
comBuilder(2,0),
),
// AExp33
appBuilder( // 46
comBuilder(2,50),
ptrBuilder(0, true, true),
),
appBuilder( // 47
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp34
appBuilder( // 48
comBuilder(4,30),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 49
comBuilder(1,46),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp35
appBuilder( // 50
prmBuilder("<="),
argBuilder(0, false),
intBuilder(0),
comBuilder(1,0),
comBuilder(1,45),
ptrBuilder(0, true, true),
),
appBuilder( // 51
comBuilder(2,48),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp36
appBuilder( // 52
comBuilder(2,0),
),
// AExp37
appBuilder( // 53
comBuilder(2,57),
ptrBuilder(0, true, true),
),
appBuilder( // 54
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp38
appBuilder( // 55
comBuilder(4,30),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 56
comBuilder(1,53),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp39
appBuilder( // 57
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,52),
comBuilder(2,55),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
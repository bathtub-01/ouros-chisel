package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Ordlist extends Benchmark {
override def toString() = "Ordlist" 
val combinatorCount = 39
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,11),
ptrBuilder(4, false, false),
intBuilder(0),
intBuilder(1),
),
appBuilder( // 1
comBuilder(3,67),
comBuilder(2,1),
),
appBuilder( // 2
comBuilder(1,0),
comBuilder(3,67),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(1,0),
comBuilder(3,67),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(1,0),
comBuilder(3,67),
ptrBuilder(3, false, false),
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
comBuilder(1,27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,65),
argBuilder(0, true),
),
appBuilder( // 4
comBuilder(2,31),
comBuilder(2,1),
),
// AExp3
appBuilder( // 5
comBuilder(1,27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 6
comBuilder(1,65),
argBuilder(0, true),
),
appBuilder( // 7
comBuilder(2,31),
comBuilder(2,0),
),
// AExp4
appBuilder( // 8
comBuilder(2,19),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 9
comBuilder(1,5),
argBuilder(0, false),
),
appBuilder( // 10
comBuilder(1,2),
argBuilder(0, false),
),
// AExp5
appBuilder( // 11
comBuilder(1,0),
comBuilder(1,15),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(1,8),
argBuilder(0, true),
),
// AExp6
appBuilder( // 13
comBuilder(2,0),
),
// AExp7
appBuilder( // 14
argBuilder(0, true),
comBuilder(1,13),
comBuilder(1,15),
),
// AExp8
appBuilder( // 15
argBuilder(0, true),
comBuilder(2,1),
comBuilder(1,14),
),
// AExp9
appBuilder( // 16
comBuilder(4,21),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 17
argBuilder(3, true),
argBuilder(1, true),
),
// AExp10
appBuilder( // 18
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,16),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 19
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 20
comBuilder(3,18),
argBuilder(1, true),
),
// AExp12
appBuilder( // 21
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp13
appBuilder( // 22
comBuilder(2,0),
),
// AExp14
appBuilder( // 23
comBuilder(4,21),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 25
argBuilder(2, true),
argBuilder(0, true),
),
// AExp15
appBuilder( // 26
argBuilder(2, true),
comBuilder(2,22),
comBuilder(4,23),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp16
appBuilder( // 27
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 28
comBuilder(3,26),
argBuilder(0, true),
),
// AExp17
appBuilder( // 29
comBuilder(1,43),
ptrBuilder(0, true, true),
),
appBuilder( // 30
comBuilder(2,52),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp18
appBuilder( // 31
comBuilder(1,35),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 32
comBuilder(2,29),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 33
comBuilder(1,43),
argBuilder(1, false),
),
// AExp19
appBuilder( // 34
comBuilder(2,1),
),
// AExp20
appBuilder( // 35
argBuilder(0, true),
comBuilder(1,34),
comBuilder(1,0),
),
// AExp21
appBuilder( // 36
comBuilder(2,1),
),
// AExp22
appBuilder( // 37
comBuilder(1,43),
ptrBuilder(0, true, true),
),
appBuilder( // 38
comBuilder(4,21),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp23
appBuilder( // 39
comBuilder(1,45),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 40
comBuilder(2,37),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 41
comBuilder(1,35),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp24
appBuilder( // 42
argBuilder(1, true),
comBuilder(1,36),
comBuilder(3,39),
argBuilder(0, true),
),
// AExp25
appBuilder( // 43
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,42),
),
// AExp26
appBuilder( // 44
comBuilder(2,0),
),
// AExp27
appBuilder( // 45
argBuilder(0, true),
comBuilder(1,44),
comBuilder(1,0),
),
// AExp28
appBuilder( // 46
comBuilder(4,21),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp29
appBuilder( // 47
comBuilder(4,21),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(2,52),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp30
appBuilder( // 49
comBuilder(4,21),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(4,21),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp31
appBuilder( // 51
comBuilder(1,35),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,47),
comBuilder(3,49),
argBuilder(2, false),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp32
appBuilder( // 52
argBuilder(1, true),
comBuilder(1,46),
comBuilder(3,51),
argBuilder(0, true),
),
// AExp33
appBuilder( // 53
comBuilder(1,27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 54
comBuilder(1,65),
argBuilder(0, true),
),
appBuilder( // 55
comBuilder(4,21),
comBuilder(2,0),
),
// AExp34
appBuilder( // 56
comBuilder(1,27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 57
comBuilder(1,65),
argBuilder(0, true),
),
appBuilder( // 58
comBuilder(4,21),
comBuilder(2,1),
),
// AExp35
appBuilder( // 59
comBuilder(2,19),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 60
comBuilder(1,56),
argBuilder(0, false),
),
appBuilder( // 61
comBuilder(1,53),
argBuilder(0, false),
),
// AExp36
appBuilder( // 62
comBuilder(2,19),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 63
comBuilder(1,59),
argBuilder(0, false),
),
appBuilder( // 64
comBuilder(1,65),
argBuilder(0, false),
),
// AExp37
appBuilder( // 65
argBuilder(0, true),
comBuilder(1,62),
ptrBuilder(0, true, true),
),
appBuilder( // 66
comBuilder(4,21),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp38
appBuilder( // 67
argBuilder(1, true),
argBuilder(0, true),
),
)
}
package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Ordlist extends Benchmark {
override def toString() = "Ordlist" 
val combinatorCount = 34
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,11),
ptrBuilder(4, false, false),
intBuilder(0),
intBuilder(1),
),
appBuilder( // 1
comBuilder(3,71),
comBuilder(2,1),
),
appBuilder( // 2
comBuilder(1,0),
comBuilder(3,71),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(1,0),
comBuilder(3,71),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(1,0),
comBuilder(3,71),
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
comBuilder(1,28),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 3
comBuilder(1,69),
argBuilder(0, true),
),
appBuilder( // 4
comBuilder(2,32),
comBuilder(2,1),
),
// AExp3
appBuilder( // 5
comBuilder(1,28),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 6
comBuilder(1,69),
argBuilder(0, true),
),
appBuilder( // 7
comBuilder(2,32),
comBuilder(2,0),
),
// AExp4
appBuilder( // 8
comBuilder(2,20),
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
argBuilder(0, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 14
comBuilder(1,15),
argBuilder(1, true),
),
// AExp7
appBuilder( // 15
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,13),
),
// AExp8
appBuilder( // 16
comBuilder(4,22),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 17
argBuilder(0, true),
argBuilder(2, true),
),
// AExp9
appBuilder( // 18
argBuilder(2, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 19
comBuilder(3,16),
argBuilder(1, true),
),
// AExp10
appBuilder( // 20
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 21
comBuilder(3,18),
argBuilder(1, true),
),
// AExp11
appBuilder( // 22
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp12
appBuilder( // 23
comBuilder(4,22),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
argBuilder(1, true),
argBuilder(3, true),
),
appBuilder( // 25
argBuilder(0, true),
argBuilder(2, true),
),
// AExp13
appBuilder( // 26
argBuilder(2, true),
comBuilder(2,0),
ptrBuilder(0, true, true),
),
appBuilder( // 27
comBuilder(4,23),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp14
appBuilder( // 28
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(3,26),
argBuilder(0, true),
),
// AExp15
appBuilder( // 30
comBuilder(1,43),
ptrBuilder(0, true, true),
),
appBuilder( // 31
comBuilder(1,55),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp16
appBuilder( // 32
comBuilder(1,35),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 33
comBuilder(2,30),
argBuilder(0, true),
argBuilder(1, false),
),
appBuilder( // 34
comBuilder(1,43),
argBuilder(1, false),
),
// AExp17
appBuilder( // 35
argBuilder(0, true),
comBuilder(2,1),
),
// AExp18
appBuilder( // 36
comBuilder(1,43),
ptrBuilder(0, true, true),
),
appBuilder( // 37
comBuilder(4,22),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp19
appBuilder( // 38
comBuilder(1,44),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 39
comBuilder(2,36),
argBuilder(1, false),
argBuilder(2, true),
),
appBuilder( // 40
comBuilder(1,35),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp20
appBuilder( // 41
argBuilder(1, true),
comBuilder(2,1),
ptrBuilder(0, true, true),
),
appBuilder( // 42
comBuilder(3,38),
argBuilder(0, true),
),
// AExp21
appBuilder( // 43
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,41),
),
// AExp22
appBuilder( // 44
argBuilder(0, true),
comBuilder(2,0),
),
// AExp23
appBuilder( // 45
comBuilder(4,22),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 46
argBuilder(0, true),
argBuilder(2, true),
),
// AExp24
appBuilder( // 47
comBuilder(4,22),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(4,22),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp25
appBuilder( // 49
comBuilder(1,35),
argBuilder(0, false),
argBuilder(2, false),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 50
comBuilder(3,47),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(3, false),
),
appBuilder( // 51
comBuilder(3,45),
argBuilder(1, true),
argBuilder(2, false),
argBuilder(3, false),
),
// AExp26
appBuilder( // 52
argBuilder(2, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 53
comBuilder(4,49),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 54
comBuilder(4,22),
argBuilder(0, false),
comBuilder(2,0),
),
// AExp27
appBuilder( // 55
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 56
comBuilder(3,52),
argBuilder(0, true),
),
// AExp28
appBuilder( // 57
comBuilder(1,28),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 58
comBuilder(1,69),
argBuilder(0, true),
),
appBuilder( // 59
comBuilder(4,22),
comBuilder(2,0),
),
// AExp29
appBuilder( // 60
comBuilder(1,28),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 61
comBuilder(1,69),
argBuilder(0, true),
),
appBuilder( // 62
comBuilder(4,22),
comBuilder(2,1),
),
// AExp30
appBuilder( // 63
comBuilder(2,20),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 64
comBuilder(1,60),
argBuilder(0, false),
),
appBuilder( // 65
comBuilder(1,57),
argBuilder(0, false),
),
// AExp31
appBuilder( // 66
comBuilder(2,20),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 67
comBuilder(1,63),
argBuilder(0, false),
),
appBuilder( // 68
comBuilder(1,69),
argBuilder(0, false),
),
// AExp32
appBuilder( // 69
argBuilder(0, true),
comBuilder(1,66),
ptrBuilder(0, true, true),
),
appBuilder( // 70
comBuilder(4,22),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp33
appBuilder( // 71
argBuilder(1, true),
argBuilder(0, true),
),
)
}
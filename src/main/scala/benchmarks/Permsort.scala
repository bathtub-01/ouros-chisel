package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object Permsort extends Benchmark {
override def toString() = "Permsort" 
val combinatorCount = 38
val heap_img = Seq(
// AExp0
appBuilder( // 0
comBuilder(1,3),
ptrBuilder(8, false, false),
),
appBuilder( // 1
comBuilder(4,2),
intBuilder(12),
comBuilder(2,0),
),
appBuilder( // 2
comBuilder(4,2),
intBuilder(12),
ptrBuilder(1, false, false),
),
appBuilder( // 3
comBuilder(4,2),
intBuilder(6),
ptrBuilder(2, false, false),
),
appBuilder( // 4
comBuilder(4,2),
intBuilder(9),
ptrBuilder(3, false, false),
),
appBuilder( // 5
comBuilder(4,2),
intBuilder(7),
ptrBuilder(4, false, false),
),
appBuilder( // 6
comBuilder(4,2),
intBuilder(6),
ptrBuilder(5, false, false),
),
appBuilder( // 7
comBuilder(4,2),
intBuilder(10),
ptrBuilder(6, false, false),
),
appBuilder( // 8
comBuilder(1,6),
ptrBuilder(7, false, false),
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
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp3
appBuilder( // 3
argBuilder(0, true),
errorBuilder(3),
comBuilder(2,0),
),
// AExp4
appBuilder( // 4
comBuilder(1,16),
comBuilder(1,25),
ptrBuilder(0, true, true),
),
appBuilder( // 5
comBuilder(1,31),
argBuilder(0, true),
),
// AExp5
appBuilder( // 6
comBuilder(1,3),
ptrBuilder(0, true, true),
),
appBuilder( // 7
comBuilder(1,4),
argBuilder(0, true),
),
// AExp6
appBuilder( // 8
comBuilder(2,0),
),
// AExp7
appBuilder( // 9
argBuilder(3, true),
),
// AExp8
appBuilder( // 10
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 11
comBuilder(1,16),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp9
appBuilder( // 12
argBuilder(3, false),
argBuilder(1, false),
comBuilder(4,9),
comBuilder(4,10),
argBuilder(1, false),
argBuilder(3, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 13
argBuilder(0, true),
argBuilder(2, false),
),
// AExp10
appBuilder( // 14
argBuilder(2, true),
comBuilder(1,8),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 15
comBuilder(4,12),
argBuilder(1, true),
),
// AExp11
appBuilder( // 16
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 17
comBuilder(3,14),
argBuilder(0, true),
),
// AExp12
appBuilder( // 18
comBuilder(2,1),
),
// AExp13
appBuilder( // 19
comBuilder(1,25),
ptrBuilder(0, true, true),
),
appBuilder( // 20
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp14
appBuilder( // 21
comBuilder(1,27),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 22
comBuilder(2,19),
argBuilder(0, false),
argBuilder(1, true),
),
appBuilder( // 23
prmBuilder("<="),
argBuilder(2, true),
argBuilder(0, false),
),
// AExp15
appBuilder( // 24
argBuilder(1, true),
comBuilder(1,18),
comBuilder(3,21),
argBuilder(0, true),
),
// AExp16
appBuilder( // 25
argBuilder(0, true),
comBuilder(2,1),
comBuilder(2,24),
),
// AExp17
appBuilder( // 26
comBuilder(2,0),
),
// AExp18
appBuilder( // 27
argBuilder(0, true),
comBuilder(1,26),
comBuilder(1,0),
),
// AExp19
appBuilder( // 28
comBuilder(1,38),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 29
comBuilder(1,31),
argBuilder(1, true),
),
appBuilder( // 30
comBuilder(1,57),
argBuilder(0, true),
),
// AExp20
appBuilder( // 31
argBuilder(0, true),
ptrBuilder(0, true, true),
comBuilder(2,28),
),
appBuilder( // 32
comBuilder(4,2),
comBuilder(2,0),
comBuilder(2,0),
),
// AExp21
appBuilder( // 33
comBuilder(2,0),
),
// AExp22
appBuilder( // 34
comBuilder(2,43),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 35
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 36
argBuilder(2, true),
argBuilder(0, true),
),
// AExp23
appBuilder( // 37
argBuilder(2, true),
comBuilder(2,33),
comBuilder(4,34),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp24
appBuilder( // 38
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 39
comBuilder(3,37),
argBuilder(0, true),
),
// AExp25
appBuilder( // 40
comBuilder(4,2),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 41
argBuilder(3, true),
argBuilder(1, true),
),
// AExp26
appBuilder( // 42
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,40),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp27
appBuilder( // 43
yBuilder(),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 44
comBuilder(3,42),
argBuilder(1, true),
),
// AExp28
appBuilder( // 45
comBuilder(4,2),
ptrBuilder(0, true, true),
comBuilder(2,0),
),
appBuilder( // 46
comBuilder(4,2),
argBuilder(0, true),
comBuilder(2,0),
),
// AExp29
appBuilder( // 47
comBuilder(4,2),
argBuilder(2, true),
ptrBuilder(0, true, true),
),
appBuilder( // 48
comBuilder(4,2),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp30
appBuilder( // 49
comBuilder(1,64),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 50
argBuilder(0, true),
argBuilder(2, true),
),
appBuilder( // 51
comBuilder(4,2),
argBuilder(1, true),
),
// AExp31
appBuilder( // 52
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 53
comBuilder(3,49),
argBuilder(0, true),
argBuilder(1, false),
argBuilder(2, false),
),
appBuilder( // 54
comBuilder(3,47),
argBuilder(1, false),
argBuilder(2, false),
argBuilder(3, true),
),
// AExp32
appBuilder( // 55
argBuilder(2, true),
comBuilder(1,45),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 56
comBuilder(4,52),
argBuilder(1, true),
),
// AExp33
appBuilder( // 57
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 58
comBuilder(3,55),
argBuilder(0, true),
),
// AExp34
appBuilder( // 59
comBuilder(2,0),
),
// AExp35
appBuilder( // 60
comBuilder(4,2),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 61
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 62
argBuilder(2, true),
argBuilder(0, true),
),
// AExp36
appBuilder( // 63
argBuilder(2, true),
comBuilder(2,59),
comBuilder(4,60),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp37
appBuilder( // 64
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 65
comBuilder(3,63),
argBuilder(0, true),
),
)
}
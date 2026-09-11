package benchmarks
import common.Helper._
import common.Atom
import chisel3.Vec
 
object SumEuler extends Benchmark {
override def toString() = "SumEuler" 
val combinatorCount = 42
val heap_img = Seq(
// AExp0
appBuilder( // 0
ptrBuilder(2, false, false),
ptrBuilder(1, false, false),
),
appBuilder( // 1
comBuilder(2,11),
intBuilder(1),
intBuilder(30),
),
// AExp1
appBuilder( // 2
comBuilder(2,5),
prmBuilder("+"),
intBuilder(0),
),
// AExp2
appBuilder( // 3
yBuilder(),
comBuilder(3,30),
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
argBuilder(3, true),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 3
argBuilder(4, true),
argBuilder(1, true),
),
// AExp3
appBuilder( // 4
argBuilder(3, true),
comBuilder(3,0),
comBuilder(5,2),
argBuilder(1, true),
argBuilder(0, true),
argBuilder(2, true),
),
// AExp4
appBuilder( // 5
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 6
comBuilder(4,4),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp5
appBuilder( // 7
comBuilder(2,70),
ptrBuilder(0, true, true),
),
appBuilder( // 8
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp6
appBuilder( // 9
comBuilder(4,20),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 10
comBuilder(1,7),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp7
appBuilder( // 11
comBuilder(1,18),
comBuilder(1,26),
ptrBuilder(0, true, true),
),
appBuilder( // 12
comBuilder(2,9),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp8
appBuilder( // 13
comBuilder(2,0),
),
// AExp9
appBuilder( // 14
comBuilder(4,20),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 15
argBuilder(3, true),
argBuilder(1, true),
),
appBuilder( // 16
argBuilder(2, true),
argBuilder(0, true),
),
// AExp10
appBuilder( // 17
argBuilder(2, true),
comBuilder(2,13),
comBuilder(4,14),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp11
appBuilder( // 18
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 19
comBuilder(3,17),
argBuilder(0, true),
),
// AExp12
appBuilder( // 20
argBuilder(3, true),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp13
appBuilder( // 21
comBuilder(2,70),
intBuilder(1),
ptrBuilder(0, true, true),
),
appBuilder( // 22
prmBuilder("-"),
argBuilder(0, true),
intBuilder(1),
),
// AExp14
appBuilder( // 23
comBuilder(1,39),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 24
comBuilder(1,21),
argBuilder(0, false),
),
appBuilder( // 25
comBuilder(2,41),
argBuilder(0, false),
),
// AExp15
appBuilder( // 26
ptrBuilder(3, false, false),
ptrBuilder(0, true, true),
),
appBuilder( // 27
comBuilder(1,23),
argBuilder(0, true),
),
// AExp16
appBuilder( // 28
argBuilder(3, true),
ptrBuilder(0, true, true),
argBuilder(1, true),
),
appBuilder( // 29
prmBuilder("+"),
argBuilder(2, true),
intBuilder(1),
),
// AExp17
appBuilder( // 30
argBuilder(2, true),
comBuilder(2,0),
comBuilder(4,28),
argBuilder(1, true),
argBuilder(0, true),
),
// AExp18
appBuilder( // 31
comBuilder(2,0),
),
// AExp19
appBuilder( // 32
argBuilder(3, true),
),
// AExp20
appBuilder( // 33
comBuilder(4,20),
argBuilder(0, true),
ptrBuilder(0, true, true),
),
appBuilder( // 34
comBuilder(1,39),
argBuilder(1, true),
argBuilder(2, true),
),
// AExp21
appBuilder( // 35
argBuilder(3, false),
argBuilder(1, false),
comBuilder(4,32),
comBuilder(4,33),
argBuilder(1, false),
argBuilder(3, false),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 36
argBuilder(0, true),
argBuilder(2, false),
),
// AExp22
appBuilder( // 37
argBuilder(2, true),
comBuilder(1,31),
ptrBuilder(0, true, true),
argBuilder(0, true),
),
appBuilder( // 38
comBuilder(4,35),
argBuilder(1, true),
),
// AExp23
appBuilder( // 39
yBuilder(),
ptrBuilder(0, true, true),
),
appBuilder( // 40
comBuilder(3,37),
argBuilder(0, true),
),
// AExp24
appBuilder( // 41
prmBuilder("=="),
ptrBuilder(0, true, true),
intBuilder(1),
),
appBuilder( // 42
comBuilder(2,45),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp25
appBuilder( // 43
comBuilder(2,45),
argBuilder(1, false),
ptrBuilder(0, true, true),
),
appBuilder( // 44
comBuilder(2,47),
argBuilder(0, true),
argBuilder(1, false),
),
// AExp26
appBuilder( // 45
prmBuilder("=="),
intBuilder(0),
argBuilder(1, false),
comBuilder(2,0),
comBuilder(2,1),
ptrBuilder(0, true, true),
argBuilder(0, false),
),
appBuilder( // 46
comBuilder(2,43),
argBuilder(0, false),
argBuilder(1, false),
),
// AExp27
appBuilder( // 47
comBuilder(1,63),
argBuilder(0, true),
argBuilder(1, true),
comBuilder(2,1),
),
// AExp28
appBuilder( // 48
argBuilder(0, true),
argBuilder(2, false),
ptrBuilder(0, true, true),
),
appBuilder( // 49
argBuilder(1, true),
argBuilder(2, false),
),
// AExp29
appBuilder( // 50
argBuilder(2, true),
intBuilder(0),
argBuilder(0, true),
),
// AExp30
appBuilder( // 51
argBuilder(2, true),
intBuilder(1),
ptrBuilder(0, true, true),
),
appBuilder( // 52
prmBuilder("-"),
argBuilder(0, true),
argBuilder(1, true),
),
// AExp31
appBuilder( // 53
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,50),
comBuilder(3,51),
argBuilder(0, false),
argBuilder(2, false),
),
// AExp32
appBuilder( // 54
argBuilder(3, true),
ptrBuilder(1, true, true),
ptrBuilder(0, true, true),
),
appBuilder( // 55
prmBuilder("-"),
argBuilder(1, true),
argBuilder(2, true),
),
appBuilder( // 56
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp33
appBuilder( // 57
prmBuilder("<="),
argBuilder(0, false),
argBuilder(2, false),
comBuilder(4,20),
comBuilder(4,54),
ptrBuilder(0, true, true),
argBuilder(2, false),
argBuilder(0, false),
),
appBuilder( // 58
prmBuilder("+"),
argBuilder(1, false),
argBuilder(1, false),
),
// AExp34
appBuilder( // 59
comBuilder(1,63),
argBuilder(0, true),
argBuilder(1, true),
ptrBuilder(0, true, true),
),
appBuilder( // 60
comBuilder(3,57),
argBuilder(2, true),
),
// AExp35
appBuilder( // 61
prmBuilder("<="),
argBuilder(2, false),
argBuilder(0, false),
comBuilder(3,53),
comBuilder(3,59),
argBuilder(0, false),
argBuilder(2, false),
argBuilder(1, true),
),
// AExp36
appBuilder( // 62
prmBuilder("+"),
argBuilder(0, false),
argBuilder(0, false),
),
// AExp37
appBuilder( // 63
comBuilder(3,48),
ptrBuilder(0, true, true),
comBuilder(1,62),
),
appBuilder( // 64
comBuilder(3,61),
argBuilder(0, true),
),
// AExp38
appBuilder( // 65
comBuilder(2,0),
),
// AExp39
appBuilder( // 66
comBuilder(2,70),
ptrBuilder(0, true, true),
),
appBuilder( // 67
prmBuilder("+"),
argBuilder(0, true),
intBuilder(1),
),
// AExp40
appBuilder( // 68
comBuilder(4,20),
argBuilder(0, false),
ptrBuilder(0, true, true),
),
appBuilder( // 69
comBuilder(1,66),
argBuilder(0, false),
argBuilder(1, true),
),
// AExp41
appBuilder( // 70
prmBuilder("<="),
argBuilder(0, false),
argBuilder(1, false),
comBuilder(2,65),
comBuilder(2,68),
argBuilder(0, false),
argBuilder(1, false),
),
)
}
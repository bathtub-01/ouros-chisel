package benchmarks
import common.Helper._

/** Exact source-image translation of simulator real-world branch uart.rs. */
object Uart extends Benchmark {
  override def toString: String = "Uart"
  val combinatorCount = 15
  val heap_img = Seq(
    appBuilder(ptrBuilder(1, false, false), intBuilder(1993)), // 0
    appBuilder(comBuilder(1, 5), ptrBuilder(2, false, false), ptrBuilder(4, false, false), comBuilder(1, 3)), // 1
    appBuilder(comBuilder(4, 14), comBuilder(2, 10), ptrBuilder(3, false, false), comBuilder(1, 12)), // 2
    appBuilder(comBuilder(3, 15), ptrBuilder(2, false, false)), // 3
    appBuilder(comBuilder(1, 5), ptrBuilder(2, false, false), ptrBuilder(5, false, false), comBuilder(1, 17)), // 4
    appBuilder(ioBuilder(false), intBuilder(0)), // 5
    appBuilder(ioBuilder(true), intBuilder(4)), // 6
  )
  val comb_img = Seq(
    appBuilder(argBuilder(0, true)), // 0
    appBuilder(argBuilder(1, true)), // 1
    appBuilder(argBuilder(2, true), argBuilder(0, true), argBuilder(1, true)), // 2
    appBuilder(comBuilder(1, 21), ptrBuilder(2, false, false), ptrBuilder(0, true, true), ptrBuilder(1, false, false)), // 3
    appBuilder(ptrBuilder(6, false, false), argBuilder(0, true)), // 4
    appBuilder(argBuilder(0, true), comBuilder(3, 0)), // 5
    appBuilder(comBuilder(1, 0), ptrBuilder(0, true, true)), // 6
    appBuilder(argBuilder(0, true), argBuilder(1, true)), // 7
    appBuilder(argBuilder(0, true), argBuilder(2, true), ptrBuilder(0, true, true)), // 8
    appBuilder(comBuilder(2, 6), argBuilder(1, true)), // 9
    appBuilder(comBuilder(1, 0), ptrBuilder(0, true, true)), // 10
    appBuilder(comBuilder(3, 8), argBuilder(0, true), argBuilder(1, true)), // 11
    appBuilder(comBuilder(1, 0), ptrBuilder(0, true, true)), // 12
    appBuilder(comBuilder(3, 2), argBuilder(0, true)), // 13
    appBuilder(argBuilder(3, true), argBuilder(0, true), argBuilder(1, true), argBuilder(2, true)), // 14
    appBuilder(comBuilder(1, 5), argBuilder(0, true), argBuilder(1, true), ptrBuilder(0, true, true)), // 15
    appBuilder(comBuilder(2, 0), argBuilder(2, true)), // 16
    appBuilder(comBuilder(1, 20), ptrBuilder(2, false, false), ptrBuilder(0, true, true)), // 17
    appBuilder(comBuilder(1, 0), argBuilder(0, true)), // 18
    appBuilder(argBuilder(2, true)), // 19
    appBuilder(argBuilder(0, true), comBuilder(3, 19)), // 20
    appBuilder(argBuilder(0, true), comBuilder(3, 1)), // 21
  )
}

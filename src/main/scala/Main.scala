/**
 * Keep `sbt run` useful: it is now the FPGA artifact generator.
 *
 * Prefer the explicit form:
 *   sbt "runMain Generate fib"
 */
object Main {
  def main(args: Array[String]): Unit =
    Generate.main(args)
}

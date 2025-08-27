package common

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._

import common._
import common.SystemConfig._

class BitsWithValid[T <: Data](t: T) extends Bundle {
  val valid = Bool()
  val bits  = t
}

object Helper {

  /**
   * Takes a sequence of Atoms, convert it into a fixed-sized Application.
   *
   * For shorter sequences, extend the length with NOPs
   */
  def extendToApp(atms: Seq[Atom]): Application = {
    require(atms.length <= maxAppLen)
    val res = WireInit(0.U.asTypeOf(new Application))
    res.app.zip(atms).foreach { case (to, from) =>
      to := from
    }
    res
  }

  def padWith[T](l: List[T], expectedLen: Int, default: T): List[T] = {
    if (l.length == expectedLen)
      l
    else
      l ++ List.fill(expectedLen - l.length)(default)
  }

  def nopBuilder: Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.NOP,
      _.payload  -> 0.U
    )

  def errorBuilder(code: Int): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.ERR,
      _.payload  -> code.U
    )

  def ptrBuilder(unique: Boolean, pointer: Int): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.PTR,
      _.payload  -> (new PtrPayload)
        .Lit(
          _.unique  -> unique.B,
          _.pointer -> pointer.U
        )
    )

  def comBuilder(arity: Int, pattern: Int, idxs: List[Int]): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.COM,
      _.payload  -> (new ComPayload)
        .Lit(
          _.arity   -> arity.U,
          _.pattern -> pattern.U,
          _.idxs    -> Vec.Lit(
            padWith(
              idxs.map(_.U(log2Ceil(comArity + 1).W)),
              comIdxs,
              0.U(log2Ceil(comArity + 1).W)
            ): _*
          )
        )
        .asUInt
    )

  def intBuilder(value: Int): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.INT,
      _.payload  -> (new IntPayload)
        .Lit(
          _.value -> value.S
        )
        .asUInt
    )

  def prmBuilder(op: String): Atom = {
    val (opCode, isSub, isCondInv) = op match {
      case "+"  => (AluOpCode.add_sub, false.B, false.B)
      case "-"  => (AluOpCode.add_sub, true.B, false.B)
      case "*"  => (AluOpCode.mult, false.B, false.B)
      case "==" => (AluOpCode.eq, true.B, false.B)
      case "/=" => (AluOpCode.eq, true.B, true.B)
      case "<"  => (AluOpCode.lt, true.B, false.B)
      case "<=" => (AluOpCode.le, true.B, false.B)
      case ">"  => (AluOpCode.le, true.B, true.B)
      case ">=" => (AluOpCode.lt, true.B, true.B)
      case _    => throw new IllegalArgumentException(s"Unknown operation: $op")
    }

    (new Atom).Lit(
      _.atomType -> AtomType.PRM,
      _.payload  -> (new PrmPayload)
        .Lit(
          _.fun -> (new AluFunction).Lit(
            _.opcode      -> opCode,
            _.is_sub      -> isSub,
            _.is_cond_inv -> isCondInv
          )
        )
        .asUInt
    )
  }

  def yBuilder(): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.Y,
      _.payload  -> 0.U
    )

  def appBuilder(atoms: Atom*): Application =
    (new Application).Lit(
      _.app -> Vec.Lit(padWith(atoms.toList, maxAppLen, nopBuilder): _*)
    )

  def emptyApp: Application = appBuilder()
}

/**
 * Some useful combinators
 */
object Combinators {
  import Helper._
  // Combinators used in MicroHS, 19 in total
  val I: Atom   = comBuilder(1, 0, List(0))              // X
  val K: Atom   = comBuilder(2, 0, List(0))              // X
  val B: Atom   = comBuilder(3, 3, List(0, 1, 2))        // X(XX)
  val S: Atom   = comBuilder(3, 6, List(0, 2, 1, 2))     // XX(XX)
  val C: Atom   = comBuilder(3, 2, List(0, 2, 1))        // XXX
  val Sp: Atom  = comBuilder(4, 15, List(0, 1, 3, 2, 3)) // X(XX)(XX)
  val Bp: Atom  = comBuilder(4, 6, List(0, 1, 2, 3))     // XX(XX)
  val Cp: Atom  = comBuilder(4, 5, List(0, 1, 3, 2))     // X(XX)X
  val A: Atom   = comBuilder(2, 0, List(1))              // X
  val U: Atom   = comBuilder(2, 1, List(1, 0))           // XX
  val Z: Atom   = comBuilder(3, 1, List(0, 1))           // XX
  val P: Atom   = comBuilder(3, 2, List(2, 0, 1))        // XXX
  val R: Atom   = comBuilder(3, 2, List(1, 2, 0))        // XXX
  val O: Atom   = comBuilder(4, 2, List(3, 0, 1))        // XXX
  val K2: Atom  = comBuilder(3, 0, List(0))              // X
  val K3: Atom  = comBuilder(4, 0, List(0))              // X
  val K4: Atom  = comBuilder(5, 0, List(0))              // X
  val CpB: Atom = comBuilder(4, 6, List(0, 2, 1, 3))     // XX(XX)
}

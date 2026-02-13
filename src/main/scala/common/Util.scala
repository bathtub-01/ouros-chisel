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
   * Dereference `app`'s PTR at position `arg_id`, with `target`
   *   - when returning `(app, None)`, `app` is the deref result
   *   - when returning `(app1, Some(app2))`, `app1` is the new cell to be
   *     emitted, `app2` need to be written back
   *
   * Optimisation: In reality, when arg_id > 0, the target is always a singleton
   */
  def deref(
      app: Vec[Atom],
      arg_id: UInt,
      target: Vec[Atom],
      free_addr: UInt
  ): (Vec[Atom], Vec[Atom]) = {
    val targetLen = appLen(target)
    val res       = WireInit(0.U.asTypeOf(Vec(2 * maxAppLen - 1, new Atom)))
    when(arg_id === 0.U) {
      for (i <- 0 until res.length) {
        when(i.U < targetLen) {
          res(i) := target(i.U)
        }.elsewhen(i.U - targetLen + 1.U < maxAppLen.U) {
          res(i) := app(i.U - targetLen + 1.U)
        }
      }
    }.otherwise {
      res.zip(app).foreach { case (r, a) => r := a }
      res(arg_id) := target(0)
    }
    val res1 = Wire(Vec(maxAppLen, new Atom))
    val res2 = Wire(Vec(maxAppLen, new Atom))
    res1 := res.slice(0, maxAppLen)
    when(res(maxAppLen).isNop()) {
      res2 := 0.U.asTypeOf(res2)
    }.otherwise {
      res2 := makePtr(true.B, free_addr) +: res.slice(maxAppLen, res.length)
    }
    (res1, res2)
  }

  /**
   * A tree version of "applying a predicate to a Vec". Can be used for .any or
   * .indexWhere. Gives shorter logical depth than a linear chain.
   *
   * For simplicity, only accept Vec with even number length.
   */
  def treePred[T <: Data](v: Vec[T])(p: T => Bool): (Bool, UInt) = {
    require(isPow2(v.length))
    def tri(a: (Bool, UInt), b: (Bool, UInt)): (Bool, UInt) = {
      val res1 = Wire(Bool())
      val res2 = Wire(UInt(log2Ceil(v.length + 1).W))
      when(a._1) {
        res1 := true.B
        res2 := a._2
      }.otherwise {
        res1 := b._1
        res2 := b._2
      }
      (res1, res2)
    }
    def buildTree(s: Seq[(Bool, UInt)]): Seq[(Bool, UInt)] = {
      if (s.length <= 1) { s }
      else {
        buildTree(s.grouped(2).map { case Seq(l, r) => tri(l, r) }.toSeq)
      }
    }

    val tree = buildTree(v.zipWithIndex.map { case (t, i) => (p(t), i.U) }).head
    tri(tree, (false.B, v.length.U))
  }

  def anyThat[T <: Data](v: Vec[T])(p: T => Bool): Bool = treePred(v)(p)._1

  /**
   * Similar to `Vec.indexWhere`, but returns the length of the Vec when the
   * predicate fails for all elements (For `Vec.indexWhere`, it returns the idx
   * of the last element when all failed).
   *
   * Require input size to be pow2.
   */
  def firstWhere[T <: Data](v: Vec[T])(p: T => Bool): UInt = treePred(v)(p)._2

  /**
   * Similar to `firstWhere`, but uses a chain.
   */
  def firstWhereC[T <: Data](v: Vec[T])(p: T => Bool): UInt = {
    val res = Wire(UInt(log2Ceil(v.length + 1).W))
    res := v.length.U
    for (i <- v.length - 1 to 0 by -1) {
      when(p(v(i.U))) {
        res := i.U
      }
    }
    res
  }

  /**
   * Returns the **actual** length of an Application.
   * @example
   *   appLen([+, 1, 2, NOP]) = 3
   */
  def appLen(app: Vec[Atom]): UInt = Helper.firstWhere(app) { _.isNop() }

  /**
   * The arity of an Atom.
   */
  def arityOf(atm: Atom): UInt = {
    val res = Wire(UInt())
    res := 0.U // wild-card case
    switch(atm.atomType) {
      is(AtomType.COM) {
        res := atm.toCom().arity
      }
      is(AtomType.PRM) {
        res := 2.U
      }
      is(AtomType.INT) {
        res := 1.U
      }
      is(AtomType.Y) {
        res := 1.U
      }
    }
    res
  }

  /**
   * Determine whether an Application is in Weak-Head-Normal-Form.
   * arityOf(app(0)) >= appLen(app)
   */
  def isWHNF(app: Vec[Atom]): Bool =
    // this is much simpler in hw
    app(Helper.arityOf(app(0))).isNop()

  /**
   * Takes a sequence of Atoms, convert it into a full-sized Application.
   *
   * For shorter sequences, extend the length with NOPs
   */
  def extendToApp(atms: Seq[Atom], length: Int = maxAppLen): Vec[Atom] = {
    require(atms.length <= maxAppLen)
    val res = WireInit(0.U.asTypeOf(Vec(length, new Atom)))
    res.zip(atms).foreach { case (to, from) =>
      to := from
    }
    res
  }

  /**
   * Take a prefix from `source`, link its elements to `sink`, starting from
   * `start` position of `sink`.
   * @example
   *   takeUInt(Vec(a,b,c), 2, sink, 1) will cause sink(1) := a; sink(2) := b
   * @note
   *   Hardware cost involves here. Avoid using this when `take` and `start` can
   *   be determined at compile time.
   */
  def takeUInt[T <: Data](
      source: IndexedSeq[T],
      take: UInt,
      sink: Vec[T],
      start: UInt
  ): Unit = {
    for (i <- 0 until source.length) {
      when(i.U < take && start + i.U < sink.length.U) {
        sink(start + i.U) := source(i)
      }
    }
  }

  /**
   * Take a sufix from `source`, link its elements to `sink`, starting from
   * `start` position of `sink`.
   * @example
   *   dropUInt(Vec(a,b,c), 1, sink, 1) will cause sink(1) := b; sink(2) := c
   * @note
   *   Hardware cost involves here. Avoid using this when `drop` and `start` can
   *   be determined at compile time.
   */
  def dropUInt[T <: Data](
      source: Vec[T],
      drop: UInt,
      sink: Vec[T],
      start: UInt
  ): Unit = {
    for (i <- 0 until source.length) {
      when(start +& i.U < sink.length.U && i.U +& drop < source.length.U) {
        sink(start +& i.U) := source(drop +& i.U)
      }
    }
  }

  /**
   * Takes a sequence, pad it with default elements, make it into expected
   * length.
   */
  def padWith[T](
      l: Seq[T],
      expectedLen: Int,
      default: T
  ): Seq[T] = {
    if (l.length == expectedLen)
      l
    else
      l ++ Seq.fill(expectedLen - l.length)(default)
  }

  /**
   * Literal NOP builder
   */
  def nopBuilder: Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.NOP,
      _.payload  -> 0.U
    )

  /**
   * Literal ERR builder
   */
  def errorBuilder(code: Int): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.ERR,
      _.payload  -> code.U
    )

  /**
   * Literal PTR builder
   */
  def ptrBuilder(pointer: Int, unique: Boolean = false): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.PTR,
      _.payload  -> (new PtrPayload)
        .Lit(
          _.unique  -> unique.B,
          _.pointer -> pointer.U
        )
        .asUInt
    )

  /**
   * Dynamic PTR maker
   */
  def makePtr(unique: Bool, pointer: UInt): Atom = {
    val payload = Wire(new PtrPayload)
    payload.unique  := unique
    payload.pointer := pointer
    val res = Wire(new Atom)
    res.atomType := AtomType.PTR
    res.payload  := payload.asUInt
    res
  }

  /**
   * Literal COM builder
   */
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

  /**
   * Literal INT builder
   */
  def intBuilder(value: Int): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.INT,
      _.payload  -> (new IntPayload)
        .Lit(
          _.value -> value.S
        )
        .asUInt
    )

  def strToOp(op: String): (AluOpCode.Type, Boolean, Boolean) = {
    op match {
      case "+"  => (AluOpCode.add_sub, false, false)
      case "-"  => (AluOpCode.add_sub, true, false)
      case "*"  => (AluOpCode.mult, false, false)
      case "==" => (AluOpCode.eq, true, false)
      case "/=" => (AluOpCode.eq, true, true)
      case "<"  => (AluOpCode.lt, true, false)
      case "<=" => (AluOpCode.le, true, false)
      case ">"  => (AluOpCode.le, true, true)
      case ">=" => (AluOpCode.lt, true, true)
      case _    => throw new IllegalArgumentException(s"Unknown operation: $op")
    }
  }

  /**
   * Literal PRM builder
   */
  def prmBuilder(op: String): Atom = {
    val (opCode, isSub, isCondInv) = strToOp(op)

    (new Atom).Lit(
      _.atomType -> AtomType.PRM,
      _.payload  -> (new PrmPayload)
        .Lit(
          _.fun -> (new AluFunction).Lit(
            _.opcode      -> opCode,
            _.is_sub      -> isSub.B,
            _.is_cond_inv -> isCondInv.B
          )
        )
        .asUInt
    )
  }

  /**
   * Literal Y builder
   */
  def yBuilder(): Atom =
    (new Atom).Lit(
      _.atomType -> AtomType.Y,
      _.payload  -> 0.U
    )

  def appBuilder(length: Int, atoms: Atom*): Vec[Atom] =
    Vec.Lit(padWith(atoms.toSeq, length, nopBuilder): _*)

  def appBuilder(atoms: Atom*): Vec[Atom] =
    Vec.Lit(padWith(atoms.toSeq, maxAppLen, nopBuilder): _*)

  def boolean2Comb(b: Boolean): Atom = if (b) Combinators.A else Combinators.K

  def Addr = UInt(log2Ceil(heapSize).W)
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

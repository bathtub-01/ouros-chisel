package ouros

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

object ReducerStm extends ChiselEnum {
  val IDLE    = Value
  val SPINE   = Value
  val APP     = Value
  val SPECIAL = Value
}

/**
 * Combinator reduction block
 */
class Reducer extends Module {
  val io = IO(new Bundle {
    val free_addr     = Input(Addr)
    val in            = Flipped(Decoupled(new ActiveApp))
    val out_spine     = Decoupled(new ActiveApp)
    val out_app       = Decoupled(new FrozenApp)
    val addr_consumed = Output(UInt(3.W))
    val need_split    = Input(Bool())
    val search        = Input(Addr)
    val found         = Output(Bool())
    // ============ non-essential ports ===================
    val inject = Flipped(Valid(Vec(maxAppLen, new Atom)))
  })

  val combTable  = Module(new BlockMem(progSize, Vec(maxAppLen, new Atom)))
  val regIn      = RegInit(0.U.asTypeOf(new ActiveApp))
  val regSpine   = RegInit(0.U.asTypeOf(Vec(maxAppLen, new Atom)))
  val regAddr    = RegInit(0.U.asTypeOf(Addr))
  val regArity   = RegInit(0.U(log2Ceil(comArity + 1).W))
  val regStm     = RegInit(ReducerStm.IDLE)
  val regIdx     = RegInit(0.U(3.W))
  val regAppMask = RegInit(false.B)

  def stepNext(): Unit = {
    io.in.ready := true.B
    when(io.in.fire) {
      regIn   := io.in.bits
      regIdx  := 0.U
      regAddr := io.free_addr + io.addr_consumed + io.need_split.asUInt
      switch(io.in.bits.app(0).atomType) {
        is(AtomType.COM) {
          val comb = io.in.bits.app(0).toCom()
          regStm   := ReducerStm.SPINE
          regArity := comb.arity
          combTable.read(comb.pointer)
        }
        is(AtomType.Y) {
          regAppMask := true.B
          regStm     := ReducerStm.SPECIAL
        }
      }
    }.otherwise {
      regStm := ReducerStm.IDLE
    }
  }

  class Pair extends Bundle {
    val atom = new Atom
    val idx  = UInt(3.W)
  }

  def moreApp(app: Vec[Atom]): Bool =
    zipWithIndex(app).exists(p => p.idx > regIdx && isNested(p.bits))

  def findApp(app: Vec[Atom]): UInt =
    zipWithIndex(app).indexWhere(p => p.idx > regIdx && isNested(p.bits))

  def isNested(atom: Atom): Bool = {
    val res = WireInit(false.B)
    switch(atom.atomType) {
      is(AtomType.PTR) {
        val ptr = atom.toPtr()
        res := ptr.ncell
      }
    }
    res
  }

  def inst(app: Vec[Atom]): Vec[Atom] = {
    val res = WireInit(app)
    res.zip(app).foreach { case (r, atom) =>
      switch(atom.atomType) {
        is(AtomType.PTR) {
          val ptr = atom.toPtr()
          when(ptr.ncell) {
            r := makePtr(true.B, regAddr + ptr.pointer)
          }
        }
        is(AtomType.ARG) {
          val arg      = atom.toArg()
          val argument = regIn.app(arg.arg + 1.U)
          when(argument.isPtr()) {
            val ptr = argument.toPtr()
            r := makePtr(arg.unique && ptr.unique, ptr.pointer)
          }.otherwise {
            r := argument
          }
        }
      }
    }
    res
  }

  // give default connection
  combTable.init(0.U)
  io.in.ready        := false.B
  io.out_spine.bits  := DontCare
  io.out_spine.valid := false.B
  io.out_app.bits    := DontCare
  io.out_app.valid   := false.B
  io.addr_consumed   := 0.U
  io.found           := false.B

  // program injection
  when(io.inject.valid) {
    combTable.write(io.inject.bits, regAddr)
    regAddr := regAddr + 1.U
  }

  // main logic
  switch(regStm) {
    is(ReducerStm.IDLE) { stepNext() }
    is(ReducerStm.SPINE) {
      io.out_spine.valid := true.B
      io.out_spine.bits  := {
        val comb     = regIn.app(0).payload.asTypeOf(new ComPayload)
        val resSpine = WireInit(0.U.asTypeOf(new ActiveApp))
        val insted   = inst(combTable.readOut)
        resSpine.stack_idx := regIn.stack_idx
        resSpine.app       := insted
        val redSpineLen = firstWhere(insted) { _.isNop() }
        dropUInt(regIn.app, comb.arity +& 1.U, resSpine.app, redSpineLen)
        resSpine
      }
      val template = combTable.readOut
      io.addr_consumed := template.count { isNested(_) }
      when(moreApp(template)) {
        val founded = findApp(template)
        regSpine := template
        regStm   := ReducerStm.APP
        regIdx   := founded
        combTable.read(
          regIn.app(0).getCombAddr() + template(founded).getPtr() + 1.U
        )
      }.otherwise {
        stepNext()
      }
    }
    is(ReducerStm.APP) {
      io.out_app.valid := true.B
      io.out_app.bits  := mkFrozenApp(
        regAddr + regSpine(regIdx).toPtr().pointer,
        inst(combTable.readOut)
      )
      when(io.out_app.ready) {
        when(moreApp(regSpine)) {
          val founded = findApp(regSpine)
          regIdx := founded
          combTable.read(
            regIn.app(0).getCombAddr() + regSpine(founded).getPtr() + 1.U
          )
        }.otherwise {
          stepNext()
        }
      }.otherwise {
        combTable.read(
          regIn.app(0).getCombAddr() + regSpine(regIdx).getPtr() + 1.U
        )
      }
      io.found := zipWithIndex(regSpine).exists { p =>
        val ptr = p.bits.toPtr()
        p.idx >= regIdx && p.bits.isPtr() &&
        ptr.ncell &&
        io.search === ptr.pointer + regAddr
      }
    }
    is(ReducerStm.SPECIAL) {
      io.out_spine.valid := regAppMask
      io.out_spine.bits  := {
        val resSpine = WireInit(0.U.asTypeOf(new ActiveApp))
        resSpine        := regIn
        resSpine.app(0) := regIn.app(1).dash()
        resSpine.app(1) := makePtr(false.B, regAddr)
        resSpine
      }
      io.out_app.valid := true.B
      io.out_app.bits  := {
        val outApp = WireInit(0.U.asTypeOf(new FrozenApp))
        outApp.heap_addr := regAddr
        outApp.app(0)    := regIn.app(1).dash()
        outApp.app(1)    := makePtr(false.B, regAddr)
        outApp
      }
      regAppMask := false.B
      when(regAppMask) {
        io.addr_consumed := 1.U
      }
      when(io.out_app.ready) {
        stepNext()
      }
      io.found := io.search === regAddr
    }
  }
}

object Reducer extends App {
  ChiselStage.emitSystemVerilogFile(
    new Reducer,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

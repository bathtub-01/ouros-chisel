package ouros

import chisel3._
import chisel3.util._
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
    val free_addrs = Vec(consumers_reducer, Flipped(Decoupled(Addr)))
    val in         = Flipped(Decoupled(new ActiveApp))
    val out_spine  = Decoupled(new ActiveApp)
    val out_app    = Decoupled(new FrozenApp)
    val need_split = Input(Bool())
    val search     = Input(Addr)
    val found      = Output(Bool())
    // ============ non-essential ports ===================
    val inject      = Flipped(Valid(Vec(maxAppLen, new Atom)))
    val inject_addr = Input(Addr)
  })
  val combTable          = Module(new BlockMem(progSize, Vec(maxAppLen, new Atom)))
  val regIn              = RegInit(0.U.asTypeOf(new ActiveApp))
  val regSpine           = RegInit(0.U.asTypeOf(Vec(maxAppLen, new Atom)))
  val regAddrs           = RegInit(0.U.asTypeOf(Vec(consumers_reducer, Addr)))
  val regArity           = RegInit(0.U(log2Ceil(comArity + 1).W))
  val regStm             = RegInit(ReducerStm.IDLE)
  val regIdx             = RegInit(0.U(3.W))
  val regAppMask         = RegInit(false.B)
  val regBigSpinePending = RegInit(false.B)
  val regBigSpineUsed    = RegInit(false.B)
  val addrConsumed       = WireInit(0.U(3.W))

  /**
   * Move on to the next input, if one is available. `allowInput` is used by
   * spine splitting to prevent accepting a new reduction while its freshly
   * allocated split App is still blocked on `out_app`.
   */
  def stepNext(allowInput: Bool): Unit = {
    io.in.ready := io.free_addrs.forall(_.valid) && allowInput
    when(io.in.fire) {
      regIn              := io.in.bits
      regIdx             := 0.U
      regBigSpineUsed    := false.B
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

  /**
   * Whether the current combinator reduction would produce a spine longer
   * than one App. The instantiated template stays in a freshly allocated heap
   * cell and the active spine becomes [PTR-to-that-cell, old-tail...].
   */
  def bigSpineNow(): Bool = {
    val oldTailLen = appLen(regIn.app) - (regArity +& 1.U)
    val resultLen  = appLen(combTable.readOut) +& oldTailLen
    regStm === ReducerStm.SPINE && resultLen > maxAppLen.U
  }

  /** Instantiate an App from a combinator template. */
  def inst(app: Vec[Atom]): Vec[Atom] = {
    val res = WireInit(app)
    res.zip(app).foreach { case (r, atom) =>
      switch(atom.atomType) {
        is(AtomType.PTR) {
          val ptr = atom.toPtr()
          when(ptr.ncell) {
            // Slot zero is reserved for the split spine cell whenever a split
            // is happening now, or happened for this reduction previously.
            val addrOffset = Mux(bigSpineNow() || regBigSpineUsed, 1.U, 0.U)
            val addrIdx    = ptr.pointer +& addrOffset
            val freeAddr = Mux(
              regStm === ReducerStm.SPINE,
              io.free_addrs(addrIdx).bits,
              regAddrs(addrIdx)
            )
            r := makePtr(true.B, freeAddr)
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
  io.found           := false.B
  io.free_addrs.zipWithIndex.foreach { case (p, idx) =>
    p.ready := idx.U < addrConsumed
  }

  // program injection
  when(io.inject.valid) {
    combTable.write(io.inject.bits, io.inject_addr)
  }

  // main logic
  switch(regStm) {
    is(ReducerStm.IDLE) {
      stepNext(!regBigSpinePending)
    }

    is(ReducerStm.SPINE) {
      val template = combTable.readOut

      io.out_spine.valid := true.B
      io.out_spine.bits := {
        val resSpine = WireInit(0.U.asTypeOf(new ActiveApp))
        resSpine.stack_idx := regIn.stack_idx

        when(bigSpineNow()) {
          // The reduced head is moved to a fresh App. Keep applying the old
          // tail to it in the active spine.
          resSpine.app(0) := makePtr(true.B, io.free_addrs(0).bits)
          dropUInt(regIn.app, regArity +& 1.U, resSpine.app, 1.U)
        }.otherwise {
          val insted = inst(template)
          resSpine.app := insted
          val redSpineLen = firstWhere(insted) { _.isNop() }
          dropUInt(regIn.app, regArity +& 1.U, resSpine.app, redSpineLen)
        }
        resSpine
      }

      // Nested Apps use subsequent free-address slots when slot zero is used
      // by the split spine App itself.
      addrConsumed := template.count { isNested(_) } + bigSpineNow().asUInt

      // Keep both the template and the free-address snapshot even when there
      // are no nested Apps: a blocked split App may have to be emitted later.
      regSpine := template
      regAddrs.zip(io.free_addrs).foreach { case (reg, port) =>
        reg := port.bits
      }

      when(bigSpineNow()) {
        regBigSpinePending := true.B
        regBigSpineUsed    := true.B
      }

      when(moreApp(template)) {
        val founded = findApp(template)
        regStm := ReducerStm.APP
        regIdx := founded
        combTable.read(
          regIn.app(0).getCombAddr() + template(founded).getPtr() + 1.U
        )
      }.otherwise {
        // A split whose frozen App is blocked must not consume a new input in
        // this cycle; the pending App will be retried from IDLE.
        stepNext(!bigSpineNow() || io.out_app.ready)
      }
    }

    is(ReducerStm.APP) {
      val addrOffset = Mux(regBigSpineUsed, 1.U, 0.U)
      val addrIdx    = regSpine(regIdx).toPtr().pointer +& addrOffset

      io.out_app.valid := true.B
      io.out_app.bits := mkFrozenApp(
        regAddrs(addrIdx),
        inst(combTable.readOut)
      )

      // If the split parent App is still pending, it has priority on out_app;
      // hold the nested-App state and keep the code-memory read alive.
      when(!regBigSpinePending && io.out_app.ready) {
        when(moreApp(regSpine)) {
          val founded = findApp(regSpine)
          regIdx := founded
          combTable.read(
            regIn.app(0).getCombAddr() + regSpine(founded).getPtr() + 1.U
          )
        }.otherwise {
          stepNext(true.B)
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
        io.search === regAddrs(ptr.pointer +& addrOffset)
      }
    }

    is(ReducerStm.SPECIAL) {
      io.out_spine.valid := regAppMask
      io.out_spine.bits := {
        val resSpine = WireInit(0.U.asTypeOf(new ActiveApp))
        resSpine        := regIn
        resSpine.app(0) := regIn.app(1).dash()
        resSpine.app(1) := makePtr(false.B, io.free_addrs(0).bits)
        resSpine
      }
      io.out_app.valid := true.B
      io.out_app.bits := {
        val outApp = WireInit(0.U.asTypeOf(new FrozenApp))
        outApp.heap_addr := io.free_addrs(0).bits
        outApp.app(0)    := regIn.app(1).dash()
        outApp.app(1)    := makePtr(false.B, io.free_addrs(0).bits)
        outApp
      }
      regAppMask := false.B
      when(io.out_app.ready) {
        addrConsumed := 1.U
        stepNext(true.B)
      }
      io.found := io.search === io.free_addrs(0).bits
    }
  }

  // A split App shares the normal frozen-App output with nested Apps and Y.
  // Give it priority while it is generated or while an earlier attempt is
  // pending because of backpressure.
  when(bigSpineNow() || regBigSpinePending) {
    io.out_app.valid := true.B
    when(regStm === ReducerStm.SPINE) {
      io.out_app.bits := mkFrozenApp(
        io.free_addrs(0).bits,
        inst(combTable.readOut)
      )
    }.otherwise {
      io.out_app.bits := mkFrozenApp(
        regAddrs(0),
        inst(regSpine)
      )
    }
  }

  // The split cell is not yet in the heap while it is pending, so it must
  // participate in the same in-flight-address search as nested Reducer Apps.
  when(regBigSpinePending && io.search === regAddrs(0)) {
    io.found := true.B
  }

  // Last connect intentionally wins over the SPINE assignment above: if the
  // split App fires immediately, it never becomes pending for the next cycle.
  when(io.out_app.fire) {
    regBigSpinePending := false.B
  }
}
object Reducer extends App {
  ChiselStage.emitSystemVerilogFile(
    new Reducer,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

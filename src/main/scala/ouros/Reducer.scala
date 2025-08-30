package ouros

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

class DecodeRecord extends Bundle {
  val valid  = Bool()
  val isPtr  = Bool()
  val ptrVal = UInt(3.W)
}

/**
 * Combinator reduction block
 *
 * @param pipelined
 *   optionally insert a pipeline register for decoding
 */
class Reducer(pipelined: Boolean) extends Module {
  val io = IO(new Bundle {
    val free_addr     = Input(UInt(log2Ceil(heapSize).W))
    val in            = Flipped(Decoupled(new ActiveApp))
    val out_spine     = Decoupled(new ActiveApp)
    val out_app1      = Decoupled(new FrozenApp(comIdxs - 1))
    val out_app2      = Decoupled(new FrozenApp(comIdxs - 2))
    val out_app3      = Decoupled(new FrozenApp(comIdxs - 3))
    val addr_consumed = Output(UInt(2.W))
  })
  import Patterns._
  val allParsed = allPatterns.map(parse(_)._1)
  def recordBuilder(r: (Boolean, Int)): DecodeRecord =
    (new DecodeRecord).Lit(
      _.valid  -> true.B,
      _.isPtr  -> r._1.B,
      _.ptrVal -> r._2.U
    )
  def transToRecords(
      parsed: List[(Boolean, Int)],
      length: Int
  ): Vec[DecodeRecord] = {
    val records = parsed.map { case pRes => recordBuilder(pRes) }
    VecInit(padWith(records, length, 0.U.asTypeOf(new DecodeRecord)))
  }

  val spineTable = VecInit(
    allParsed.map(res => transToRecords(res.spine, comIdxs))
  )
  val app1Table = VecInit(
    allParsed.map(res => transToRecords(res.app1, comIdxs - 1))
  )
  val app2Table = VecInit(
    allParsed.map(res => transToRecords(res.app2, comIdxs - 2))
  )
  val app3Table = VecInit(
    allParsed.map(res => transToRecords(res.app3, comIdxs - 3))
  )

  def trans(r: DecodeRecord): Atom = {
    val wire = Wire(new Atom)
    when(r.valid) {
      when(r.isPtr) {
        wire := makePtr(true.B, r.ptrVal + io.free_addr)
      }.otherwise {
        wire := io.in.bits.app(
          io.in.bits
            .app(0)
            .payload
            .asTypeOf(new ComPayload)
            .idxs(r.ptrVal) + 1.U
        )
      }
    }.otherwise {
      wire := nopBuilder
    }
    wire
  }

  val resSpine = WireInit(0.U.asTypeOf(new ActiveApp))
  val resApp1  = WireInit(0.U.asTypeOf(new FrozenApp(comIdxs - 1)))
  val resApp2  = WireInit(0.U.asTypeOf(new FrozenApp(comIdxs - 2)))
  val resApp3  = WireInit(0.U.asTypeOf(new FrozenApp(comIdxs - 3)))

  switch(io.in.bits.app(0).atomType) {
    is(AtomType.COM) {
      val comb = io.in.bits.app(0).payload.asTypeOf(new ComPayload)
      // pass tags
      resSpine.stack_idx := io.in.bits.stack_idx
      resApp1.heap_addr  := io.free_addr
      resApp2.heap_addr  := io.free_addr + 1.U
      resApp3.heap_addr  := io.free_addr + 2.U
      // perform the reduction
      resSpine.app := padWith(
        spineTable(comb.pattern).map(trans(_)),
        maxAppLen,
        nopBuilder
      )
      resApp1.app := app1Table(comb.pattern).map(trans(_))
      resApp2.app := app2Table(comb.pattern).map(trans(_))
      resApp3.app := app3Table(comb.pattern).map(trans(_))
      // handle over-applied spine
      val redSpineLen = spineTable(comb.pattern).indexWhere(!_.valid)
      dropUInt(io.in.bits.app, comb.arity + 1.U, resSpine.app, redSpineLen)
    }
    is(AtomType.Y) {
      // pass tags
      resSpine.stack_idx := io.in.bits.stack_idx
      resApp1.heap_addr  := io.free_addr
      // perform the reduction
      resSpine.app    := io.in.bits.app
      resSpine.app(0) := io.in.bits.app(1)
      resSpine.app(1) := makePtr(false.B, io.free_addr)
      resApp1.app(0)  := io.in.bits.app(1)
      resApp1.app(1)  := makePtr(false.B, io.free_addr)
    }
  }

  val spineReg = RegInit(0.U.asTypeOf(new BitsWithValid(new ActiveApp)))
  val app1Reg  = RegInit(
    0.U.asTypeOf(new BitsWithValid(new FrozenApp(comIdxs - 1)))
  )
  val app2Reg = RegInit(
    0.U.asTypeOf(new BitsWithValid(new FrozenApp(comIdxs - 2)))
  )
  val app3Reg = RegInit(
    0.U.asTypeOf(new BitsWithValid(new FrozenApp(comIdxs - 3)))
  )

  when(io.in.fire) {
    // set reg contents
    spineReg.bits := resSpine
    app1Reg.bits  := resApp1
    app2Reg.bits  := resApp2
    app3Reg.bits  := resApp3
    // set valid bit
    spineReg.valid := true.B
    app1Reg.valid  := resApp1.app(0).asUInt =/= 0.U
    app2Reg.valid  := resApp2.app(0).asUInt =/= 0.U
    app3Reg.valid  := resApp3.app(0).asUInt =/= 0.U
  }

  // free addr will be consumed immediatedly
  io.addr_consumed := Mux(
    io.in.fire,
    VecInit(
      Seq(resApp1.app(0), resApp2.app(0), resApp3.app(0))
    ).count(_.asUInt =/= 0.U),
    0.U
  )

  if (pipelined) {
    io.in.ready := (!spineReg.valid || io.out_spine.ready) &&
      (!app1Reg.valid || io.out_app1.ready) &&
      (!app2Reg.valid || io.out_app2.ready) &&
      (!app3Reg.valid || io.out_app3.ready)
    io.out_spine.bits  := spineReg.bits
    io.out_app1.bits   := app1Reg.bits
    io.out_app2.bits   := app2Reg.bits
    io.out_app3.bits   := app3Reg.bits
    io.out_spine.valid := spineReg.valid
    io.out_app1.valid  := app1Reg.valid
    io.out_app2.valid  := app2Reg.valid
    io.out_app3.valid  := app3Reg.valid
  } else {
    io.in.ready := io.out_spine.ready && io.out_app1.ready &&
      io.out_app2.ready && io.out_app3.ready
    io.out_spine.bits  := resSpine
    io.out_app1.bits   := resApp1
    io.out_app2.bits   := resApp2
    io.out_app3.bits   := resApp3
    io.out_spine.valid := io.in.valid
    io.out_app1.valid  := resApp1.app(0).asUInt =/= 0.U
    io.out_app2.valid  := resApp2.app(0).asUInt =/= 0.U
    io.out_app3.valid  := resApp3.app(0).asUInt =/= 0.U
  }
}

object Reducer extends App {
  ChiselStage.emitSystemVerilogFile(
    new Reducer(true),
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

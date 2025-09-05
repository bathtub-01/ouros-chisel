package ouros

import chisel3._
import chisel3.util._
import chisel3.experimental.BundleLiterals._
import chisel3.experimental.VecLiterals._
import _root_.circt.stage.ChiselStage

import common._
import common.SystemConfig._
import common.Helper._

object Dest extends ChiselEnum {
  val ToDheap  = Value
  val ToAlu    = Value
  val ToReducr = Value
}
import Dest._

/**
 * An Ouros core.
 */
class Ouros extends Module {
  val io = IO(new Bundle {
    val start  = Input(Bool())
    val inject = Flipped(Valid(Vec(maxAppLen, new Atom)))
    val done   = Output(Bool())
  })

  def getDest(app: Vec[Atom]): Dest.Type = {
    val wire = Wire(Dest())
    when(app(0).isPrm() && app(1).isInt() && app(2).isInt()) {
      wire := ToAlu
    }.elsewhen(!isWHNF(app) && app(0).isCom()) {
      wire := ToReducr
    }.otherwise {
      wire := ToDheap
    }
    wire
  }

  def wireGen = WireInit(0.U.asTypeOf(new DecoupledIO(new ActiveApp)))
  def exFrozen(fa: FrozenApp): FrozenApp = {
    val res = Wire(new FrozenApp(comIdxs - 1))
    res.heap_addr := fa.heap_addr
    res.app       := extendToApp(fa.app, comIdxs - 1)
    res
  }

  val dheap  = Module(new DrfHeap)
  val reducr = Module(new Reducer(pipelined = true))
  val alu    = Module(new Alu(pipelined = true))

  val wireToDheapA0 = wireGen
  val wireToDheapA1 = wireGen
  val wireToDheapA2 = wireGen
  val wireToDheapA3 = wireGen

  val wireToReducr0 = wireGen
  val wireToReducr1 = wireGen
  val wireToReducr2 = wireGen
  val wireToReducr3 = wireGen

  val wireToAlu0 = wireGen
  val wireToAlu1 = wireGen
  val wireToAlu2 = wireGen

  dheap.io.out_main.ready   := false.B
  dheap.io.out_sub.ready    := false.B
  reducr.io.out_spine.ready := false.B
  alu.io.out.ready          := false.B
  // sub-modules -> buffers
  when(dheap.io.out_main.valid) {
    switch(getDest(dheap.io.out_main.bits.app)) {
      is(ToDheap) { wireToDheapA0 :<>= dheap.io.out_main }
      is(ToAlu) { wireToAlu1 :<>= dheap.io.out_main }
      is(ToReducr) { wireToReducr1 :<>= dheap.io.out_main }
    }
  }

  when(dheap.io.out_sub.valid) {
    switch(getDest(dheap.io.out_sub.bits.app)) {
      is(ToDheap) { wireToDheapA3 :<>= dheap.io.out_sub }
      is(ToAlu) { wireToAlu2 :<>= dheap.io.out_sub }
      is(ToReducr) { wireToReducr3 :<>= dheap.io.out_sub }
    }
  }

  when(reducr.io.out_spine.valid) {
    switch(getDest(reducr.io.out_spine.bits.app)) {
      is(ToDheap) { wireToDheapA1 :<>= reducr.io.out_spine }
      is(ToAlu) { wireToAlu0 :<>= reducr.io.out_spine }
      is(ToReducr) { wireToReducr0 :<>= reducr.io.out_spine }
    }
  }

  when(alu.io.out.valid) {
    when(isWHNF(alu.io.out.bits.app)) { wireToDheapA2 :<>= alu.io.out }
      .otherwise { wireToReducr2 :<>= alu.io.out }
  }

  import BufferConfig._
  val bufferDheapA0 = Queue(wireToDheapA0, depth, pipe, flow, syncMem)
  val bufferDheapA1 = Queue(wireToDheapA1, depth, pipe, flow, syncMem)
  val bufferDheapA2 = Queue(wireToDheapA2, depth, pipe, flow, syncMem)
  val bufferDheapA3 = Queue(wireToDheapA3, depth, pipe, flow, syncMem)
  val arbiterDheapA = Module(new RRArbiter(new ActiveApp, 4, true))

  val bufferDheapB0 = Queue(reducr.io.out_app1, depth, pipe, flow, syncMem)
  val bufferDheapB1 = Queue(reducr.io.out_app2, depth, pipe, flow, syncMem)
  val bufferDheapB2 = Queue(reducr.io.out_app3, depth, pipe, flow, syncMem)
  val arbiterDheapB = Module(new RRArbiter(new FrozenApp(comIdxs - 1), 3, true))

  val bufferReducr0 = Queue(wireToReducr0, depth, pipe, flow, syncMem)
  val bufferReducr1 = Queue(wireToReducr1, depth, pipe, flow, syncMem)
  val bufferReducr2 = Queue(wireToReducr2, depth, pipe, flow, syncMem)
  val bufferReducr3 = Queue(wireToReducr3, depth, pipe, flow, syncMem)
  val arbiterReducr = Module(new RRArbiter(new ActiveApp, 4, true))

  val bufferAlu0 = Queue(wireToAlu0, depth, pipe, flow, syncMem)
  val bufferAlu1 = Queue(wireToAlu1, depth, pipe, flow, syncMem)
  val bufferAlu2 = Queue(wireToAlu2, depth, pipe, flow, syncMem)
  val arbiterAlu = Module(new RRArbiter(new ActiveApp, 3, true))

  // buffers -> arbiters
  arbiterDheapA.io.in
    .zip(
      Seq(bufferDheapA0, bufferDheapA1, bufferDheapA2, bufferDheapA3)
    )
    .foreach { case (a, b) => a :<>= b }

  arbiterDheapB.io.in
    .zip(
      Seq(
        bufferDheapB0,
        bufferDheapB1.map(exFrozen(_)),
        bufferDheapB2.map(exFrozen((_)))
      )
    )
    .foreach { case (a, b) => a :<>= b }

  arbiterReducr.io.in
    .zip(
      Seq(bufferReducr0, bufferReducr1, bufferReducr2, bufferReducr3)
    )
    .foreach { case (a, b) => a :<>= b }

  arbiterAlu.io.in
    .zip(Seq(bufferAlu0, bufferAlu1, bufferAlu2))
    .foreach { case (a, b) => a :<>= b }

  // arbiters -> sub-modules
  dheap.io.in_main :<>= arbiterDheapA.io.out
  dheap.io.in_sub  :<>= arbiterDheapB.io.out
  reducr.io.in     :<>= arbiterReducr.io.out
  alu.io.in        :<>= arbiterAlu.io.out

  // gc signals
  reducr.io.free_addr    := dheap.io.free_addr
  dheap.io.addr_consumed := reducr.io.addr_consumed

  // non-essential ports
  dheap.io.inject := io.inject
  dheap.io.start  := io.start
  io.done         := dheap.io.done
}

object Ouros extends App {
  ChiselStage.emitSystemVerilogFile(
    new Ouros,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

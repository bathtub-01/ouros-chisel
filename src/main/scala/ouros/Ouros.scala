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

object InjectTo extends ChiselEnum {
  val Heap = Value
  val Comb = Value
}

/**
 * An Ouros core.
 */
class Ouros extends Module {
  val io = IO(new Bundle {
    val start       = Input(Bool())
    val inject_to   = Input(InjectTo())
    val inject      = Flipped(Valid(Vec(maxAppLen, new Atom)))
    val inject_addr = Input(Addr)
    val done        = Output(Bool())
    val noExist     = Output(Bool())
    val realNon     = Output(Bool())
  })

  def getDest(app: Vec[Atom]): Dest.Type = {
    val wire = Wire(Dest())
    when(app(0).isPrm() && app(1).isInt() && app(2).isInt()) {
      wire := ToAlu
    }.elsewhen(!isWHNF(app) && (app(0).isCom()) || app(0).isY()) {
      wire := ToReducr
    }.otherwise {
      wire := ToDheap
    }
    wire
  }

  def wireGen = {
    val wire = Wire(new DecoupledIO(new ActiveApp))
    wire       := DontCare
    wire.valid := false.B
    wire
  }

  val dheap   = Module(new DrfHeap)
  val reducr  = Module(new Reducer)
  val alu     = Module(new Alu(pipelined = AluPipe))
  val gc      = Module(new GarbageCollector)
  val addrBox = Module(new AddrBox)
  // ============ non-essential regs =============
  val preInject = RegNext(io.inject.valid)
  val injected  = RegInit(false.B)

  when(!io.inject.valid && preInject) { // negative edge
    injected := true.B
  }

  val wireFreeAddr = {
    val wire = Wire(DecoupledIO(Addr))
    wire       := DontCare
    wire.valid := false.B
    wire
  }

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

  io.noExist                := dheap.io.non_exist
  io.realNon                := dheap.io.real_non
  dheap.io.out_main.ready   := false.B
  dheap.io.out_sub.ready    := false.B
  reducr.io.out_spine.ready := false.B
  alu.io.out.ready          := false.B
  // sub-modules -> buffers
  dheap.io.out_main.ready := true.B
  when(dheap.io.out_main.valid) {
    switch(getDest(dheap.io.out_main.bits.app)) {
      is(ToDheap) { wireToDheapA0 :<>= dheap.io.out_main }
      is(ToAlu) { wireToAlu1 :<>= dheap.io.out_main }
      is(ToReducr) { wireToReducr1 :<>= dheap.io.out_main }
    }
  }

  dheap.io.out_sub.ready := true.B
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

  val bufferDealloc  = Queue(dheap.io.dealloc_addr, 2)
  val bufferFreeAddr = Queue(wireFreeAddr, 2)
  val bufferFeedBack = Queue(addrBox.io.feedback_to_gc, 2)

  val bufferDheapA0 = Queue(wireToDheapA0, bufferSize) // from dheap.main
  val bufferDheapA1 = Queue(wireToDheapA1, bufferSize) // from reducer
  val bufferDheapA2 = Queue(wireToDheapA2, bufferSize) // from alu
  val bufferDheapA3 = Queue(wireToDheapA3, bufferSize) // from dheap.sub
  val arbiterDheapA = Module(new Arbiter(new ActiveApp, 4))

  val bufferDheapB0 = Queue(reducr.io.out_app, bufferSize) // from reducer
  val bufferDheapB1 = Queue(dheap.io.out_big_drf, bufferSize)
  val arbiterDheapB = Module(new Arbiter(new FrozenApp, 2))

  val ringDheapB0 = Module(new Ring(bufferSize, Addr))
  val ringDheapB1 = Module(new Ring(bufferSize, Addr))

  val bufferReducr0 = Queue(wireToReducr0, bufferSize) // from reducer
  val bufferReducr1 = Queue(wireToReducr1, bufferSize) // from dheap.main
  val bufferReducr2 = Queue(wireToReducr2, bufferSize) // from alu
  val bufferReducr3 = Queue(wireToReducr3, bufferSize) // from dheap.sub
  val arbiterReducr = Module(new Arbiter(new ActiveApp, 4))

  val bufferAlu0 = Queue(wireToAlu0, bufferSize) // from reducer
  val bufferAlu1 = Queue(wireToAlu1, bufferSize) // from dheap.main
  val bufferAlu2 = Queue(wireToAlu2, bufferSize) // from dheap.sub
  val arbiterAlu = Module(new Arbiter(new ActiveApp, 3))

  // buffers -> arbiters
  arbiterDheapA.io.in
    .zip(
      Seq(bufferDheapA0, bufferDheapA1, bufferDheapA2, bufferDheapA3)
    )
    .foreach { case (a, b) => a :<>= b }

  arbiterDheapB.io.in
    .zip(
      Seq(bufferDheapB0, bufferDheapB1)
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

  // search-found logic
  reducr.io.search        := dheap.io.search
  ringDheapB0.io.search   := dheap.io.search
  ringDheapB0.io.in_fire  := reducr.io.out_app.fire
  ringDheapB0.io.din      := reducr.io.out_app.bits.heap_addr
  ringDheapB0.io.out_fire := bufferDheapB0.fire
  ringDheapB1.io.search   := dheap.io.search
  ringDheapB1.io.in_fire  := dheap.io.out_big_drf.fire
  ringDheapB1.io.din      := dheap.io.out_big_drf.bits.heap_addr
  ringDheapB1.io.out_fire := bufferDheapB1.fire
  dheap.io.found := reducr.io.found || ringDheapB0.io.found || ringDheapB1.io.found

  // gc signals
  gc.io.free_addr.ready := false.B
  when(injected) {
    wireFreeAddr :<>= gc.io.free_addr
  }
  gc.io.feedback                :<>= bufferFeedBack
  addrBox.io.dheap_feedback.valid := dheap.io.out_big_drf.valid
  addrBox.io.dheap_feedback.bits  := dheap.io.free_addr_feedback
  addrBox.io.addr_acquire       :<>= bufferFreeAddr
  dheap.io.free_addr            :<>= addrBox.io.addr_consumers.last
  addrBox.io.addr_consumers.zip(reducr.io.free_addrs).foreach {
    case (box, rdc) => rdc :<>= box
  }
  reducr.io.need_split := dheap.io.out_big_drf.valid
  gc.io.deallocate   :<>= bufferDealloc

  // non-essential ports
  dheap.io.inject.valid  := io.inject_to === InjectTo.Heap && io.inject.valid
  dheap.io.inject.bits   := io.inject.bits
  dheap.io.inject_addr   := io.inject_addr
  dheap.io.start         := io.start
  io.done                := dheap.io.done
  reducr.io.inject.valid := io.inject_to === InjectTo.Comb && io.inject.valid
  reducr.io.inject.bits  := io.inject.bits
  reducr.io.inject_addr  := io.inject_addr
  gc.io.inject           := dheap.io.inject.valid // bridge it
  gc.io.inject_addr      := io.inject_addr
}

object Ouros extends App {
  ChiselStage.emitSystemVerilogFile(
    new Ouros,
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

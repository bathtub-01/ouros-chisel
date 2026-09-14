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
 * An Ouros core with a pre-initialised program.
 *
 * Externally the core only needs start/done (plus Chisel's internal
 * clock/reset).  On the first start request it first replays the statically
 * occupied heap addresses into the GC bookkeeping state, then starts graph
 * reduction.  A second start is intentionally ignored: this is a one-go core.
 */
class Ouros(program: ProgramImage) extends Module {
  val io = IO(new Bundle {
    val start = Input(Bool())
    val done  = Output(Bool())
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

  // Keep the FPGA-specific file selection out of DrfHeap and Reducer.  Their
  // memory constructors are elaborated while this dynamic context is active.
  private val programModules =
    ProgramMemoryContext.withFiles(program.memoryFiles) {
      (Module(new DrfHeap), Module(new Reducer))
    }
  val dheap  = programModules._1
  val reducr = programModules._2

  val alu     = Module(new Alu(pipelined = AluPipe))
  val gc      = Module(new GarbageCollector)
  val addrBox = Module(new AddrBox)

  // ============ power-up / one-go control =============
  val startSeen   = RegInit(false.B)
  val gcBooting   = RegInit(false.B)
  val gcBootDone  = RegInit(false.B)
  val gcBootAddr  = RegInit(0.U.asTypeOf(Addr))
  val runStarted  = RegInit(false.B)
  val doneReg     = RegInit(false.B)
  val launchPulse = WireInit(false.B)

  when(io.start && !startSeen) {
    startSeen  := true.B
    gcBooting  := true.B
    gcBootAddr := 0.U
  }

  // Reproduce the bookkeeping side of the old heap-injection path.  heap.mem
  // has already populated the BRAM, so only GC metadata is touched here.
  gc.io.inject      := false.B
  gc.io.inject_addr := gcBootAddr

  when(gcBooting) {
    gc.io.inject      := true.B
    gc.io.inject_addr := gcBootAddr

    when(gcBootAddr === (program.heapWords - 1).U) {
      gcBooting  := false.B
      gcBootDone := true.B
      launchPulse := true.B
    }.otherwise {
      gcBootAddr := gcBootAddr + 1.U
    }
  }

  when(launchPulse) {
    runStarted := true.B
  }
  when(runStarted && dheap.io.done) {
    doneReg := true.B
  }
  io.done := doneReg

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

  val ringDheapB0 = Module(new Ring(nextPow2(bufferSize), Addr))
  val ringDheapB1 = Module(new Ring(nextPow2(bufferSize), Addr))
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
  dheap.io.found :=
    reducr.io.found || ringDheapB0.io.found || ringDheapB1.io.found

  // gc signals
  gc.io.free_addr.ready := false.B
  when(gcBootDone) {
    wireFreeAddr :<>= gc.io.free_addr
  }
  gc.io.feedback                  :<>= bufferFeedBack
  addrBox.io.dheap_feedback.valid := dheap.io.out_big_drf.valid
  addrBox.io.dheap_feedback.bits  := dheap.io.free_addr_feedback
  addrBox.io.addr_acquire         :<>= bufferFreeAddr
  dheap.io.free_addr              :<>= addrBox.io.addr_consumers.last
  addrBox.io.addr_consumers.zip(reducr.io.free_addrs).foreach {
    case (box, rdc) => rdc :<>= box
  }
  reducr.io.need_split        := dheap.io.out_big_drf.valid
  gc.io.deallocate            :<>= bufferDealloc
  gc.io.heap_read             :<= dheap.io.gc_heap_read
  dheap.io.gc_heap_read_addr  :<= gc.io.heap_read_addr
  gc.io.monitor.valid         := reducr.io.out_spine.valid
  gc.io.monitor.bits          := reducr.io.out_spine.bits
  gc.io.monitor_drf.valid     := dheap.io.out_big_drf.valid
  gc.io.monitor_drf.bits      := dheap.io.out_big_drf.bits.app(0)
  gc.io.monitor_drf_id        := dheap.io.out_main.bits.stack_idx

  // The old top-level program injection ports are gone.  The submodules keep
  // their existing injection ports for local testing, but the FPGA core never
  // uses them because both memories are already initialized.
  dheap.io.inject.valid := false.B
  dheap.io.inject.bits  := 0.U.asTypeOf(Vec(maxAppLen, new Atom))
  dheap.io.inject_addr  := 0.U
  dheap.io.start        := launchPulse

  reducr.io.inject.valid := false.B
  reducr.io.inject.bits  := 0.U.asTypeOf(Vec(maxAppLen, new Atom))
  reducr.io.inject_addr  := 0.U
}

/**
 * Two-cycle FPGA power-on reset generator.
 *
 * This is deliberately internal: OurosFpga has no reset pin.  The register
 * declaration initializer maps to FPGA configuration INIT state in Vivado,
 * producing exactly one reset pulse after configuration.
 */
class PowerOnReset
    extends FixedIOExtModule(
      new Bundle {
        val clock = Input(Clock())
        val reset = Output(Bool())
      }
    ) {
  override def desiredName = "OurosPowerOnReset"

  setInline(
    desiredName + ".sv",
    s"""module ${desiredName}(
       |  input  wire clock,
       |  output wire reset
       |);
       |  reg [1:0] shreg = 2'b11;
       |  always @(posedge clock) begin
       |    shreg <= {shreg[0], 1'b0};
       |  end
       |  assign reset = |shreg;
       |endmodule
       |""".stripMargin
  )
}

/**
 * FPGA-facing top level: clock + one-bit start + one-bit done, with no reset
 * pin.  `start` may simply be tied high for an automatic one-go boot.
 */
class OurosFpga(program: ProgramImage) extends RawModule {
  val clock = IO(Input(Clock()))
  val start = IO(Input(Bool()))
  val done  = IO(Output(Bool()))

  val por = Module(new PowerOnReset)
  por.io.clock := clock

  val core = withClockAndReset(clock, por.io.reset) {
    Module(new Ouros(program))
  }

  core.io.start := start
  done          := core.io.done
}

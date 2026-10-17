package ouros

import axilib._
import chisel3._
import chisel3.util._
import common._
import common.Helper._
import common.SystemConfig._

/**
 * A single-issue graph-reduction I/O unit. DHeap supplies a fully strict,
 * saturated [IO, INT(address), (INT(data)), INT(world), ...] App.
 *
 * The unit holds the whole App and thread identity through independent AXI
 * AW/W handshakes, waits for R/B, then returns the corresponding Pair App.
 * It never reads heap memory, and it never stalls other Ouros threads.
 */
class IoUnit extends Module {
  val io = IO(new Bundle {
    val request  = Flipped(Decoupled(new ActiveApp))
    val response = Decoupled(new ActiveApp)
    val pending  = Valid(new ActiveApp) // GC root while waiting/backpressured
    val axi      = Axi4LiteMaster(Axi4LiteParams(32, 32))
  })

  object State extends ChiselEnum {
    val Idle, SendRead, WaitRead, SendWrite, WaitWrite, Complete = Value
  }
  import State._
  val state = RegInit(Idle)
  val requestReg = RegInit(0.U.asTypeOf(new ActiveApp))
  val resultReg = RegInit(0.U.asTypeOf(new ActiveApp))
  val awSent = RegInit(false.B)
  val wSent = RegInit(false.B)

  io.request.ready := state === Idle
  io.response.valid := state === Complete
  io.response.bits := resultReg
  io.pending.valid := state =/= Idle
  io.pending.bits := requestReg

  val isWrite = requestReg.app(0).ioWrite()
  val pairApp = WireInit(0.U.asTypeOf(new ActiveApp))
  pairApp.stack_idx := requestReg.stack_idx
  pairApp.app(0) := comBuilder(3, 2) // Pair constructor compiled as COM(3,2)
  pairApp.app(1) := comBuilder(1, 0) // () represented by I = COM(1,0)
  pairApp.app(2) := Mux(isWrite, requestReg.app(3), requestReg.app(2))
  // Preserve over-application after contracting the IO redex.
  for (i <- 3 until maxAppLen) {
    pairApp.app(i) := Mux(isWrite,
      if (i + 1 < maxAppLen) requestReg.app(i + 1) else 0.U.asTypeOf(new Atom),
      requestReg.app(i))
  }

  io.axi.AWADDR := requestReg.app(1).payload
  io.axi.AWPROT := 0.U
  io.axi.AWVALID := state === SendWrite && !awSent
  io.axi.WDATA := requestReg.app(2).payload
  io.axi.WSTRB := "hf".U
  io.axi.WVALID := state === SendWrite && !wSent
  io.axi.BREADY := state === WaitWrite
  io.axi.ARADDR := requestReg.app(1).payload
  io.axi.ARPROT := 0.U
  io.axi.ARVALID := state === SendRead
  io.axi.RREADY := state === WaitRead

  switch(state) {
    is(Idle) {
      when(io.request.fire) {
        assert(ioReady(io.request.bits.app), "IoUnit expects DHeap-strict IO operands")
        requestReg := io.request.bits
        awSent := false.B
        wSent := false.B
        state := Mux(io.request.bits.app(0).ioWrite(), SendWrite, SendRead)
      }
    }
    is(SendRead) {
      when(io.axi.arFire) { state := WaitRead }
    }
    is(WaitRead) {
      when(io.axi.rFire) {
        val completed = WireInit(pairApp)
        completed.app(1).atomType := AtomType.INT
        completed.app(1).payload := io.axi.RDATA // 32-bit signed bits unchanged
        resultReg := completed
        state := Complete
      }
    }
    is(SendWrite) {
      when(io.axi.awFire) { awSent := true.B }
      when(io.axi.wFire) { wSent := true.B }
      when((awSent || io.axi.awFire) && (wSent || io.axi.wFire)) {
        state := WaitWrite
      }
    }
    is(WaitWrite) {
      when(io.axi.bFire) {
        resultReg := pairApp
        state := Complete
      }
    }
    is(Complete) {
      when(io.response.fire) { state := Idle }
    }
  }
}

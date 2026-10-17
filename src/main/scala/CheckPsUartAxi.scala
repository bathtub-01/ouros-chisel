import chisel3._
import chisel3.simulator.ChiselSim

import ouros.PsUartAxiController

/**
 * Tests the XUartPs/PS-UART register sequence and AXI channel handshakes.
 *
 * Run: sbt "runMain CheckPsUartAxi"
 * This is an AXI slave model, not a PS UART behavioral simulation.
 */
object CheckPsUartAxi extends App with ChiselSim {
  private val base = BigInt("ff010000", 16)

  simulate(
    new PsUartAxiController(),
    firtoolOpts = Array("-disable-all-randomization"),
    chiselOpts = Array("--warn-conf", "any:s"),
    subdirectory = Some("ps-uart-axi-check"),
  ) { dut =>
    // Quiescent AXI slave model, all channels initially back-pressured.
    dut.io.axi.AWREADY.poke(false.B)
    dut.io.axi.WREADY.poke(false.B)
    dut.io.axi.BRESP.poke(0.U)
    dut.io.axi.BVALID.poke(false.B)
    dut.io.axi.ARREADY.poke(false.B)
    dut.io.axi.RDATA.poke(0.U)
    dut.io.axi.RRESP.poke(0.U)
    dut.io.axi.RVALID.poke(false.B)
    dut.io.tx.valid.poke(false.B)
    dut.io.tx.bits.poke(0.U)
    dut.clock.step(2)

    // The first byte triggers one-time UART initialization (not at boot).
    // No PS UART registers are touched while waiting for an Ouros result.
    dut.io.tx.ready.expect(true.B)
    dut.io.tx.bits.poke('A'.toInt.U)
    dut.io.tx.valid.poke(true.B)
    dut.clock.step()
    dut.io.tx.valid.poke(false.B)
    dut.io.tx.ready.expect(false.B)

    /** Accept one AXI write, AW and W on separate cycles, then return BRESP. */
    def acceptWrite(address: BigInt, data: BigInt, response: Int = 0): Unit = {
      dut.io.tx.ready.expect(false.B)
      dut.io.axi.AWVALID.expect(true.B)
      dut.io.axi.WVALID.expect(true.B)
      dut.io.axi.AWADDR.expect(address.U)
      dut.io.axi.WDATA.expect(data.U)
      dut.io.axi.WSTRB.expect("hf".U)
      dut.io.axi.AWPROT.expect(0.U)
      dut.clock.step(2) // both address and data remain stable under pressure
      dut.io.axi.AWADDR.expect(address.U)
      dut.io.axi.WDATA.expect(data.U)

      // Accept AW first: W must remain asserted.
      dut.io.axi.AWREADY.poke(true.B)
      dut.clock.step()
      dut.io.axi.AWREADY.poke(false.B)
      dut.io.axi.AWVALID.expect(false.B)
      dut.io.axi.WVALID.expect(true.B)
      dut.io.axi.WDATA.expect(data.U)

      // Then accept W; B can be delayed independently.
      dut.io.axi.WREADY.poke(true.B)
      dut.clock.step()
      dut.io.axi.WREADY.poke(false.B)
      dut.io.axi.BREADY.expect(true.B)
      dut.clock.step(2)
      dut.io.axi.BREADY.expect(true.B)
      dut.io.axi.BRESP.poke(response.U)
      dut.io.axi.BVALID.poke(true.B)
      dut.clock.step()
      dut.io.axi.BVALID.poke(false.B)
      dut.io.axi.BRESP.poke(0.U)
    }

    // The controller configures UART1 itself; no Arm UART driver is needed.
    // Test retry of an initialization write after a transient SLVERR.
    acceptWrite(base + 0x00, 0x2b, response = 2)
    acceptWrite(base + 0x00, 0x2b)
    acceptWrite(base + 0x04, 0x20)
    acceptWrite(base + 0x18, 62)
    acceptWrite(base + 0x34, 13)
    acceptWrite(base + 0x00, 0x18)

    // The pending first byte proceeds directly to status polling.
    dut.io.tx.ready.expect(false.B)

    def pollStatus(status: BigInt, response: Int = 0): Unit = {
      dut.io.axi.ARADDR.expect((base + 0x2c).U)
      dut.io.axi.ARVALID.expect(true.B)
      dut.io.axi.ARPROT.expect(0.U)
      dut.clock.step(2)
      dut.io.axi.ARADDR.expect((base + 0x2c).U)
      dut.io.axi.ARREADY.poke(true.B)
      dut.clock.step()
      dut.io.axi.ARREADY.poke(false.B)
      dut.io.axi.RREADY.expect(true.B)
      dut.io.axi.RDATA.poke(status.U)
      dut.io.axi.RRESP.poke(response.U)
      dut.io.axi.RVALID.poke(true.B)
      dut.clock.step()
      dut.io.axi.RVALID.poke(false.B)
      dut.io.axi.RRESP.poke(0.U)
    }

    // An unsuccessful status read and TXFULL=1 both force another poll.
    pollStatus(0, response = 2)
    pollStatus(0x10) // PS UART TXFULL is *bit 4*, not bit 3.
    pollStatus(0)    // FIFO has room; now write the retained byte.

    acceptWrite(base + 0x30, 'A'.toInt)
    dut.io.tx.ready.expect(true.B)

    println("PS UART1 AXI controller test passed")
    println("  initialized 8N1, BRGR=62, BDIV=13 (115200 at 100 MHz)")
    println("  status: 0xFF01002C (TXFULL bit 4)")
    println("  TX FIFO: 0xFF010030, byte: 0x41 ('A')")
  }
}

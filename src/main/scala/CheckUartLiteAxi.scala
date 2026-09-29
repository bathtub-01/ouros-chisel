import chisel3._
import chisel3.simulator.ChiselSim

import ouros.UartLiteAxiController

/**
 * Unit check for the AXI UART Lite byte writer.
 *
 * It checks:
 *   - AR back-pressure while polling STAT_REG;
 *   - polling again while TXFULL is set;
 *   - independent AW/W handshakes;
 *   - correct TX FIFO address/data/strobes;
 *   - completion only after an OKAY write response.
 *
 * Usage:
 *   sbt "runMain CheckUartLiteAxi"
 */
object CheckUartLiteAxi extends App with ChiselSim {
  simulate(
    new UartLiteAxiController(),
    firtoolOpts = Array("-disable-all-randomization"),
    chiselOpts = Array("--warn-conf", "any:s"),
    subdirectory = Some("uart-lite-axi-check"),
  ) { dut =>
    // AXI slave defaults: apply back-pressure until the test explicitly opens
    // a channel.
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

    // Hand one byte to the controller.
    dut.io.tx.ready.expect(true.B)
    dut.io.tx.bits.poke('A'.toInt.U)
    dut.io.tx.valid.poke(true.B)
    dut.clock.step()
    dut.io.tx.valid.poke(false.B)
    dut.io.tx.ready.expect(false.B)

    // First status read: hold ARREADY low and ensure request/address stay put.
    dut.io.axi.ARVALID.expect(true.B)
    dut.io.axi.ARADDR.expect("h00000008".U)
    dut.clock.step(2)
    dut.io.axi.ARVALID.expect(true.B)
    dut.io.axi.ARADDR.expect("h00000008".U)

    dut.io.axi.ARREADY.poke(true.B)
    dut.clock.step()
    dut.io.axi.ARREADY.poke(false.B)

    // Report TXFULL=1. The controller must poll again rather than write.
    dut.io.axi.RREADY.expect(true.B)
    dut.io.axi.RDATA.poke("h00000008".U)
    dut.io.axi.RVALID.poke(true.B)
    dut.clock.step()
    dut.io.axi.RVALID.poke(false.B)

    dut.io.axi.ARVALID.expect(true.B)
    dut.io.axi.ARADDR.expect("h00000008".U)
    dut.io.axi.ARREADY.poke(true.B)
    dut.clock.step()
    dut.io.axi.ARREADY.poke(false.B)

    // TXFULL=0: proceed to the write transaction.
    dut.io.axi.RDATA.poke(0.U)
    dut.io.axi.RVALID.poke(true.B)
    dut.clock.step()
    dut.io.axi.RVALID.poke(false.B)

    dut.io.axi.AWADDR.expect("h00000004".U)
    dut.io.axi.WDATA.expect('A'.toInt.U)
    dut.io.axi.WSTRB.expect("hf".U)
    dut.io.axi.AWVALID.expect(true.B)
    dut.io.axi.WVALID.expect(true.B)

    // Accept AW first but stall W to verify independent channel handling.
    dut.io.axi.AWREADY.poke(true.B)
    dut.clock.step()
    dut.io.axi.AWREADY.poke(false.B)
    dut.io.axi.AWVALID.expect(false.B)
    dut.io.axi.WVALID.expect(true.B)
    dut.io.axi.WDATA.expect('A'.toInt.U)

    dut.io.axi.WREADY.poke(true.B)
    dut.clock.step()
    dut.io.axi.WREADY.poke(false.B)

    // The byte is not complete until BVALID/OKAY arrives.
    dut.io.tx.ready.expect(false.B)
    dut.io.axi.BREADY.expect(true.B)
    dut.io.axi.BRESP.poke(0.U)
    dut.io.axi.BVALID.poke(true.B)
    dut.clock.step()
    dut.io.axi.BVALID.poke(false.B)

    dut.io.tx.ready.expect(true.B)

    println()
    println("==============================================")
    println("AXI UART Lite controller check passed")
    println("  status address   : 0x00000008")
    println("  TX FIFO address  : 0x00000004")
    println("  emitted byte     : 0x41 ('A')")
    println("==============================================")
  }
}

package ouros

import chisel3._
import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.freespec.AnyFreeSpec

/** PS-UART AXI mock: checks initialization, STATUS, RX blocking and TX polling. */
class UartIoControllerSpec extends AnyFreeSpec with ChiselSim {
  "UART bridge initializes RX/TX, polls PS FIFO and responds on its slave port" in {
    simulate(new UartIoController) { dut =>
      val slave = dut.io.S_AXI
      val master = dut.io.M_AXI
      slave.AWVALID.poke(false.B)
      slave.WVALID.poke(false.B)
      slave.ARVALID.poke(false.B)
      slave.BREADY.poke(true.B)
      slave.RREADY.poke(true.B)
      slave.AWADDR.poke(0.U)
      slave.WDATA.poke(0.U)
      slave.WSTRB.poke("hf".U)
      slave.AWPROT.poke(0.U)
      slave.ARADDR.poke(0.U)
      slave.ARPROT.poke(0.U)
      master.AWREADY.poke(false.B)
      master.WREADY.poke(false.B)
      master.BRESP.poke(0.U)
      master.BVALID.poke(false.B)
      master.ARREADY.poke(false.B)
      master.RDATA.poke(0.U)
      master.RRESP.poke(0.U)
      master.RVALID.poke(false.B)
      dut.clock.step(2)

      // Start a core-side STATUS read: this triggers PS-UART initialization.
      slave.ARADDR.poke(8.U)
      slave.ARVALID.poke(true.B)
      slave.ARREADY.expect(true.B)
      dut.clock.step()
      slave.ARVALID.poke(false.B)
      slave.RVALID.expect(false.B)

      // A slave-port handshake only queues the request. The controller needs
      // a decode cycle before its master-port VALID is asserted.
      // Wait on VALID rather than assuming zero-cycle request propagation.
      def awaitMasterRequest(valid: Bool, description: String): Unit = {
        var waited = 0
        while (!valid.peek().litToBoolean && waited < 20) {
          dut.clock.step()
          waited += 1
        }
        assert(valid.peek().litToBoolean, s"Timed out waiting for PS UART $description")
      }

      def psWrite(address: BigInt, value: BigInt): Unit = {
        awaitMasterRequest(master.AWVALID, "write request")
        master.AWADDR.expect(address.U)
        master.WDATA.expect(value.U)
        master.AWVALID.expect(true.B)
        master.WVALID.expect(true.B)
        master.AWREADY.poke(true.B)
        dut.clock.step() // first AW handshake; stall W
        master.AWREADY.poke(false.B)
        master.AWVALID.expect(false.B)
        master.WVALID.expect(true.B)
        master.WREADY.poke(true.B)
        dut.clock.step()
        master.WREADY.poke(false.B)
        master.BREADY.expect(true.B)
        master.BVALID.poke(true.B)
        dut.clock.step()
        master.BVALID.poke(false.B)
      }
      val base = BigInt("ff010000", 16)
      psWrite(base + 0x00, 0x2b)
      psWrite(base + 0x04, 0x20)
      psWrite(base + 0x18, 62)
      psWrite(base + 0x34, 13)
      psWrite(base + 0x00, 0x14) // BOTH RX and TX enabled

      def psRead(addr: BigInt, value: BigInt): Unit = {
        awaitMasterRequest(master.ARVALID, "read request")
        master.ARADDR.expect(addr.U)
        master.ARVALID.expect(true.B)
        master.ARREADY.poke(true.B)
        dut.clock.step()
        master.ARREADY.poke(false.B)
        master.RREADY.expect(true.B)
        master.RDATA.poke(value.U)
        master.RVALID.poke(true.B)
        dut.clock.step()
        master.RVALID.poke(false.B)
      }
      psRead(base + 0x2c, 0x02) // RXEMPTY=1, TXFULL=0
      slave.RVALID.expect(true.B)
      slave.RDATA.expect(2.U) // TX_READY only
      dut.clock.step()
      slave.RVALID.expect(false.B)

      // The slave read of RX_DATA must BLOCK until a character is present.
      slave.ARADDR.poke(0.U)
      slave.ARVALID.poke(true.B)
      dut.clock.step()
      slave.ARVALID.poke(false.B)
      psRead(base + 0x2c, 0x02)
      slave.RVALID.expect(false.B)
      psRead(base + 0x2c, 0x02)
      slave.RVALID.expect(false.B)
      psRead(base + 0x2c, 0x00) // RXEMPTY cleared
      psRead(base + 0x30, 0x41) // 'A'
      slave.RDATA.expect(0x41.U)
      slave.RVALID.expect(true.B)
      dut.clock.step()
      slave.RVALID.expect(false.B)

      // Slave TX_DATA: AW and W may arrive on different cycles.
      slave.AWADDR.poke(4.U)
      slave.AWVALID.poke(true.B)
      dut.clock.step()
      slave.AWVALID.poke(false.B)
      slave.WDATA.poke('A'.toInt.U)
      slave.WVALID.poke(true.B)
      dut.clock.step()
      slave.WVALID.poke(false.B)
      dut.clock.step(2) // collect/decode write
      psRead(base + 0x2c, 0x10) // TXFULL: retry poll
      psRead(base + 0x2c, 0x00) // TX ready
      psWrite(base + 0x30, 0x41)
      slave.BVALID.expect(true.B)
      dut.clock.step()
      slave.BVALID.expect(false.B)
    }
  }
}

package ouros

import axilib._
import chisel3._

/**
 * Separate BD/IP-facing peripheral artifact. Its reset is active high; connect
 * clock/reset to the same bus clock domain as OurosFpga in the initial design.
 * S_AXI is the logical Ouros register bank; M_AXI targets the PS UART1 via
 * SmartConnect / Zynq UltraScale+ S_AXI_LPD.
 */
class UartIoControllerFpga(
    uartBaseAddr: BigInt = BigInt("ff010000", 16),
) extends RawModule {
  private val p = Axi4LiteParams(32, 32)
  val clock = IO(Input(Clock()))
  val reset = IO(Input(Bool()))
  val S_AXI = IO(Axi4LiteSlave(p))
  val M_AXI = IO(Axi4LiteMaster(p))
  val controller = withClockAndReset(clock, reset) {
    Module(new UartIoController(uartBaseAddr))
  }

  controller.io.S_AXI.AWADDR := S_AXI.AWADDR
  controller.io.S_AXI.AWPROT := S_AXI.AWPROT
  controller.io.S_AXI.AWVALID := S_AXI.AWVALID
  S_AXI.AWREADY := controller.io.S_AXI.AWREADY
  controller.io.S_AXI.WDATA := S_AXI.WDATA
  controller.io.S_AXI.WSTRB := S_AXI.WSTRB
  controller.io.S_AXI.WVALID := S_AXI.WVALID
  S_AXI.WREADY := controller.io.S_AXI.WREADY
  S_AXI.BRESP := controller.io.S_AXI.BRESP
  S_AXI.BVALID := controller.io.S_AXI.BVALID
  controller.io.S_AXI.BREADY := S_AXI.BREADY
  controller.io.S_AXI.ARADDR := S_AXI.ARADDR
  controller.io.S_AXI.ARPROT := S_AXI.ARPROT
  controller.io.S_AXI.ARVALID := S_AXI.ARVALID
  S_AXI.ARREADY := controller.io.S_AXI.ARREADY
  S_AXI.RDATA := controller.io.S_AXI.RDATA
  S_AXI.RRESP := controller.io.S_AXI.RRESP
  S_AXI.RVALID := controller.io.S_AXI.RVALID
  controller.io.S_AXI.RREADY := S_AXI.RREADY

  M_AXI.AWADDR := controller.io.M_AXI.AWADDR
  M_AXI.AWPROT := controller.io.M_AXI.AWPROT
  M_AXI.AWVALID := controller.io.M_AXI.AWVALID
  controller.io.M_AXI.AWREADY := M_AXI.AWREADY
  M_AXI.WDATA := controller.io.M_AXI.WDATA
  M_AXI.WSTRB := controller.io.M_AXI.WSTRB
  M_AXI.WVALID := controller.io.M_AXI.WVALID
  controller.io.M_AXI.WREADY := M_AXI.WREADY
  controller.io.M_AXI.BRESP := M_AXI.BRESP
  controller.io.M_AXI.BVALID := M_AXI.BVALID
  M_AXI.BREADY := controller.io.M_AXI.BREADY
  M_AXI.ARADDR := controller.io.M_AXI.ARADDR
  M_AXI.ARPROT := controller.io.M_AXI.ARPROT
  M_AXI.ARVALID := controller.io.M_AXI.ARVALID
  controller.io.M_AXI.ARREADY := M_AXI.ARREADY
  controller.io.M_AXI.RDATA := M_AXI.RDATA
  controller.io.M_AXI.RRESP := M_AXI.RRESP
  controller.io.M_AXI.RVALID := M_AXI.RVALID
  M_AXI.RREADY := controller.io.M_AXI.RREADY
}

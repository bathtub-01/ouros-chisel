# FPGA program image and UART I/O integration

This branch implements the real-world simulator's **UART milestone** through an
AXI4-Lite I/O reduction unit rather than a final-result dump. There are **two
independent Vivado block-design artifacts**:

| Top | Interface | Function |
| --- | --- | --- |
| `OurosFpga` | `clock`, `start`, `done`, `M_AXI` (32-bit AXI4-Lite master) | Fully autonomous graph-reduction core, including `IoUnit` |
| `UartIoControllerFpga` | `clock`, `reset` (active-high), `S_AXI` (32-bit AXI4-Lite slave), `M_AXI` (32-bit AXI4-Lite master) | UART-only I/O-controller bridge |

The core does **not** instantiate the controller; connect the two in Vivado BD.
The separate controller targets **Zynq UltraScale+ PS UART1 / Cadence XUartPs**,
not AXI UART Lite. `OurosFpga` retains its FPGA power-on reset and one-go `start`.
Use the same 32-bit AXI clock domain on the core and controller for this version.

## Generate the two artifacts

From the repository root (after making `axi-lib` available with `publishLocal`):

```bash
sbt "runMain Generate uart"
```

Or select an explicit output directory:

```bash
sbt "runMain Generate fib fpga-gen/fib"
```

Every `Generate` invocation writes both SystemVerilog modules into the selected
directory, alongside `heap.mem` and `comb.mem`. All program images are embedded
into Ouros's memory blocks at elaboration; `heapWords` seeds the GC bookkeeping.

`uart` is a direct translation of
`ouros-simulator/src/hardware/ouros/benchmarks/uart.rs` (7 heap Apps / 22
combinator Apps). Its root applies the compiled `main` to World token `INT 1993`.
It **echoes RX characters** and therefore will not terminate merely because no
UART input is present.

Pure benchmark simulation remains available with `sbt "runMain Run fib"`.
`Run` has **no UART/PS AXI slave test model**, so do not use `Run uart` as an I/O
integration test. Unit checks are under `src/test/scala/ouros/IoUnitSpec.scala`.

## Core-visible UART register map

All registers use **byte addresses**, word-aligned 32-bit accesses, and low
8-bit characters for RX/TX. This matches the Rust simulator:

| Address | Register | Semantics |
| --- | --- | --- |
| `0x00` | `RX_DATA` | Read one received byte; AXI R response waits until a byte is present |
| `0x04` | `TX_DATA` | Write low byte; B response after the PS UART accepts its FIFO write |
| `0x08` | `STATUS` | Bit 0 `RX_READY`; bit 1 `TX_READY` |
| `0x0c` | `CONTROL` | 32-bit stored R/W register for future extension; no UART side effects yet |

The controller accepts independent AW/W handshakes and one transaction at a
time. `STATUS` uses the PS UART status register (offset `0x2c`); FIFO accesses
use offset `0x30`. RX polls `RXEMPTY` (status bit 1) and TX polls `TXFULL`
(status bit 4). On the first UART access, the bridge configures 8N1, RX/TX
enabled, BRGR=62 and BDIV=13: approximately 115200 baud with a **100 MHz UART
reference clock**. FSBL/PS configuration must enable UART1 MIO pins, reference
clock, reset, and the PL-to-PS AXI path before I/O begins.

## Vivado block design

1. Add all generated `.sv` files and the two `.mem` images.
2. Package `OurosFpga` and `UartIoControllerFpga` as independent IP, or
   instantiate both in a block design.
3. Wire `OurosFpga.M_AXI` to `UartIoControllerFpga.S_AXI` (via SmartConnect
   as required by Vivado); wire controller `M_AXI` through SmartConnect to the
   Zynq UltraScale+ PS `S_AXI_LPD` bus. Map PS UART1 at `0xFF010000`.
4. Connect common clock. Drive controller's active-high `reset` from a
   correctly synchronized BD reset. Ouros has an internal FPGA power-on reset.
5. Connect `start` (may be tied high after configuration), observe `done`, and
   connect UART1 MIO/board-level serial as usual.

**Caution:** The controller's `M_AXI` uses **physical PS addresses**, and the
core-visible `S_AXI` uses **offsets** 0x00..0x0c. Address decoding in the
SmartConnect must expose a window allowing those core addresses to reach the
controller unchanged. If Vivado remaps the controller to a nonzero base,
software/compiler-generated register addresses must be adjusted accordingly;
this first implementation does not provide a configurable internal base offset.

## I/O reduction contract

- Atom tag `IO` uses payload bit 0: read = 0, write = 1; all other bits zero.
- Read: `[IO 0, INT addr, World] -> [COM Pair, INT value, World]`.
- Write: `[IO 1, INT addr, INT data, World] -> [COM Pair, COM I, World]`.
- IO arguments are strict and **forced sequentially** by DHeap using ordinary
  suspension and reactivation. The unit only sees ready, saturated requests.
- Partially applied IO Apps are WHNF; extra applications after saturation are
  preserved in the result.
- The unit completes only on AXI R/B handshakes, and the completed Pair returns
  through the **DHeap input** arbitration. Other threads continue operating
  while I/O waits. Buffered/pending IO Apps are tracked as GC roots.
- Interrupts, multiple outstanding requests, AXI error propagation, and a
  timing-accurate UART device model remain out of scope for the UART milestone.

**Validation status:** Source-level review and IO-unit tests are included;
RTL compilation/simulation and Vivado timing have not been run in this
packaging environment (sbt/Verilator and local axi-lib artifacts unavailable).

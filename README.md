# Ouros Chisel

Chisel HDL implementation of **Ouros**, a pipelined graph-reduction processor for Haskell.

This repository aims to remain a faithful hardware translation of the
[Ouros simulator](https://github.com/bathtub-01/ouros-simulator). Its
real-world branch includes an `IO` Atom, ordinary DHeap suspension/strictness,
and a dedicated AXI4-Lite I/O reduction unit. The UART-only I/O controller is
an **independent FPGA artifact** rather than part of the Ouros processor.

## Requirements

- JDK 11 or newer
- sbt, Scala 2.13, Chisel 7, and Verilator (for simulation)
- [axi-lib](https://github.com/bathtub-01/axi-lib) published locally as
  `local.axilib %% axi-lib % 0.1.0-SNAPSHOT`

## Generate FPGA artifacts

```sh
sbt "runMain Generate uart"
```

This emits two independent SystemVerilog tops, `OurosFpga` and
`UartIoControllerFpga`, and initialized program memories for the UART-echo
benchmark. `OurosFpga` exposes `clock`, `start`, `done` and a 32-bit
`M_AXI`; `UartIoControllerFpga` exposes its own `clock`/`reset`, `S_AXI`
(from Ouros), and `M_AXI` (to PS UART1).

See **[FPGA_USAGE.md](FPGA_USAGE.md)** for wiring, register map, UART baud
setup, reset conventions, limitations and artifact-generation instructions.

## Pure benchmark simulation

```sh
sbt "runMain Run fib"
sbt "testOnly ouros.IoUnitSpec"
sbt "testOnly ouros.UartIoControllerSpec"
```

`Run` uses initialized FPGA-style memories. It does not model an external
AXI bus; the UART benchmark is intended for the UART-controller path or a
future integrated PS-UART testbench. Pure benchmarks are unaffected by the
new I/O port.

## Related repositories

- [Ouros simulator](https://github.com/bathtub-01/ouros-simulator)
- [Ouros MicroHs compiler fork](https://github.com/bathtub-01/MicroHs)

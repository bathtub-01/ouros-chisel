# Ouros Chisel

Chisel HDL implementation of **Ouros**, a pipelined graph-reduction processor for Haskell.

This implementation is intended to be a faithful, direct RTL translation of the [Ouros simulator](https://github.com/bathtub-01/ouros-simulator). The simulator is treated as the cycle-level reference model: the Chisel design follows the same component structure, routing behaviour, pipeline timing, thread-management logic, and garbage-collection mechanisms as closely as practical. The goal is to keep the hardware implementation and simulator behaviour directly comparable rather than maintain two independent models of the architecture.

## Requirements

- JDK 11 or newer
- [sbt](https://www.scala-sbt.org/)
- [Verilator](https://verilator.org/) for simulation

The project currently uses Scala 2.13 and Chisel 7.

## Quick start

Clone the repository:

```sh
git clone https://github.com/bathtub-01/ouros-chisel.git
cd ouros-chisel
```

Run the bundled Ouros benchmark suite:

```sh
make run Main
```

The test driver loads the bundled heap and combinator images, runs each benchmark on the Chisel implementation, and reports the consumed cycle count. These results are useful for checking the implementation against the cycle-accurate simulator.

## Generate SystemVerilog

Generate the Ouros RTL with:

```sh
make run ouros.Ouros
```

The generated SystemVerilog is written to:

```text
sv-gen/
```

To remove generated RTL:

```sh
make clean-sv
```

## Related repositories

- Ouros simulator: https://github.com/bathtub-01/ouros-simulator
- Ouros MicroHs compiler fork: https://github.com/bathtub-01/MicroHs

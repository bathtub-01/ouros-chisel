# FPGA program-image flow

This patch changes the top-level Ouros flow from runtime program injection to
FPGA memory initialization.

## Generate one benchmark

From the repository root:

```bash
sbt "runMain Generate fib"
```

or choose the output directory:

```bash
sbt "runMain Generate queens2 fpga-gen/queens2"
```

Available benchmark names are:

`adjoxo`, `braun`, `clausify`, `countdown`, `fib`, `mss`, `queens`,
`queens2`, `sumeuler`, `while`.

The output directory contains:

```text
fpga-gen/fib/
├── OurosFpga.sv
├── ... other generated/inline .sv files ...
├── heap.mem
└── comb.mem
```

`heap.mem` and `comb.mem` are ASCII hexadecimal memory initialization files
(`$readmemh` format), not byte-stream raw binaries.

- `heap.mem`: 4096 rows × 260 bits (65 hex digits/row)
  - upper 4 bits: cached `HeapCell.appLen`
  - lower 256 bits: eight 32-bit Atoms
- `comb.mem`: 1024 rows × 256 bits (64 hex digits/row)
  - eight 32-bit Atoms

Both files are padded to the configured full BRAM depth.  The actual number of
precompiled heap cells is baked into the generated circuit as an elaboration
constant and is used to bootstrap the GC free list.

## Top-level interface

`OurosFpga` exposes:

```text
clock
start   (1 bit)
done    (1 bit)
```

There is deliberately no external reset pin.  An FPGA-only two-cycle
power-on-reset generator initializes the existing `RegInit` state once after
configuration.

`start` is one-go: the first assertion is latched, later assertions are
ignored.  It is safe and convenient to tie `start` high if the design should
automatically run after FPGA configuration.  The core first replays addresses
`0 .. heapWords-1` into the GC bookkeeping state, then starts graph reduction.
`done` latches high after the program terminates.

## Vivado hand-off

For the next step, create a Vivado project and add:

1. every generated `.sv` file;
2. `heap.mem`;
3. `comb.mem`.

Set `OurosFpga` as the top.  The generated SRAM modules use `ram_style =
"block"` and `$readmemh`, so Vivado can infer initialized BRAMs.

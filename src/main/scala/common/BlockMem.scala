package common

import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFileInline
import chisel3.experimental.hierarchy.Instantiate
import chisel3.util.experimental.{CIRCTSRAMParameter, CIRCTSRAMInterface}
import _root_.circt.stage.ChiselStage

/* Implement basic memory as an independant module. This helps Vivado to infer
 * memory as BRAM instead of LUT RAM. */

class MemIOBundle[T <: Data](depth: Int, t: T) extends Bundle {
  val rdAddr = Input(UInt(log2Ceil(depth).W))
  val rdData = Output(t)
  val wrEna  = Input(Bool())
  val wrData = Input(t)
  val wrAddr = Input(UInt(log2Ceil(depth).W))
}

class BlockMem[T <: Data](depth: Int, t: T) extends Module {
  val io = IO(new MemIOBundle(depth, t))

  val mem = SyncReadMem(depth, t)
  io.rdData := mem.read(io.rdAddr)

  when(io.wrEna) {
    mem.write(io.wrAddr, io.wrData)
  }

  def write(data: T, addr: UInt) = {
    io.wrEna  := true.B
    io.wrData := data
    io.wrAddr := addr
  }

  def read(addr: UInt) = {
    io.rdAddr := addr
  }

  def readOut: T = {
    io.rdData
  }

  def init(default_addr: UInt) = {
    io        := DontCare
    io.rdAddr := default_addr
    io.wrEna  := false.B
  }
}

class RomIO[T <: Data](depth: Int, t: T) extends Bundle {
  val rdAddr = Input(UInt(log2Ceil(depth).W))
  val rdData = Output(t)
}

/* We use ROM (Vec) for program memory, this module has the same read/write
 * timing as BlockMem. */
class BlockMemRom[T <: Data](depth: Int, t: T)(bin: Seq[T]) extends Module {
  val io = IO(new RomIO(depth, t))

  val mem = VecInit(bin)
  io.rdData := RegNext(mem(io.rdAddr))
}

// Multiple port memory, check https://www.chisel-lang.org/docs/explanations/memories#sram
class MultiPortBlockMem[T <: Data](n: Int, depth: Int, t: T) extends Module {
  val io = IO(new SRAMInterface(depth, t, 0, 0, n))
  io :<>= SRAM(depth, t, 0, 0, n)
}

class DualPortBlockMem[T <: Data](depth: Int, t: T) extends Module {
  val io = IO(new SRAMInterface(depth, t, 0, 0, 2))
  io :<>= SRAM(depth, t, 0, 0, 2, HexMemoryFile("all_zero.hex"))

  def init() = {
    io.readwritePorts.foreach { p =>
      p        := DontCare
      p.enable := false.B
    }
  }

  def readA(addr: UInt) = {
    io.readwritePorts(0).enable  := true.B
    io.readwritePorts(0).isWrite := false.B
    io.readwritePorts(0).address := addr
  }

  def readOutA = io.readwritePorts(0).readData

  def writeA(data: T, addr: UInt) = {
    io.readwritePorts(0).enable    := true.B
    io.readwritePorts(0).isWrite   := true.B
    io.readwritePorts(0).writeData := data
    io.readwritePorts(0).address   := addr
  }

  def readB(addr: UInt) = {
    io.readwritePorts(1).enable  := true.B
    io.readwritePorts(1).isWrite := false.B
    io.readwritePorts(1).address := addr
  }

  def readOutB = io.readwritePorts(1).readData

  def writeB(data: T, addr: UInt) = {
    io.readwritePorts(1).enable    := true.B
    io.readwritePorts(1).isWrite   := true.B
    io.readwritePorts(1).writeData := data
    io.readwritePorts(1).address   := addr
  }
}

/**
 * This is stolen from chisel3.util
 */
class SRAMBlackbox(parameter: CIRCTSRAMParameter)
    extends FixedIOExtModule(new CIRCTSRAMInterface(parameter))
    with HasExtModuleInline { self =>

  private val verilogInterface: String =
    (Seq.tabulate(parameter.write)(idx =>
      Seq(
        s"// Write Port $idx",
        s"input [${log2Ceil(parameter.depth) - 1}:0] W${idx}_addr",
        s"input W${idx}_en",
        s"input W${idx}_clk",
        s"input [${parameter.width - 1}:0] W${idx}_data"
      ) ++
        Option.when(parameter.masked)(
          s"input [${parameter.width / parameter.maskGranularity - 1}:0] W${idx}_mask"
        )
    ) ++
      Seq.tabulate(parameter.read)(idx =>
        Seq(
          s"// Read Port $idx",
          s"input [${log2Ceil(parameter.depth) - 1}:0] R${idx}_addr",
          s"input R${idx}_en",
          s"input R${idx}_clk",
          s"output [${parameter.width - 1}:0] R${idx}_data"
        )
      ) ++
      Seq.tabulate(parameter.readwrite)(idx =>
        Seq(
          s"// ReadWrite Port $idx",
          s"input [${log2Ceil(parameter.depth) - 1}:0] RW${idx}_addr",
          s"input RW${idx}_en",
          s"input RW${idx}_clk",
          s"input RW${idx}_wmode",
          s"input [${parameter.width - 1}:0] RW${idx}_wdata",
          s"output [${parameter.width - 1}:0] RW${idx}_rdata"
        ) ++ Option
          .when(parameter.masked)(
            s"input [${parameter.width / parameter.maskGranularity - 1}:0] RW${idx}_wmask"
          )
      )).flatten.mkString(",\n")

  private val rLogic = Seq
    .tabulate(parameter.read) { idx =>
      val prefix = s"R${idx}"
      Seq(
        s"reg _${prefix}_en;",
        s"reg [${log2Ceil(parameter.depth) - 1}:0] _${prefix}_addr;"
      ) ++
        Seq(
          s"always @(posedge ${prefix}_clk) begin // ${prefix}",
          s"_${prefix}_en <= ${prefix}_en;",
          s"_${prefix}_addr <= ${prefix}_addr;",
          s"end // ${prefix}"
        ) ++
        Some(
          s"assign ${prefix}_data = _${prefix}_en ? Memory[_${prefix}_addr] : ${parameter.width}'bx;"
        )
    }
    .flatten

  private val wLogic = Seq
    .tabulate(parameter.write) { idx =>
      val prefix = s"W${idx}"
      Seq(s"always @(posedge ${prefix}_clk) begin // ${prefix}") ++
        (if (parameter.masked)
           Seq.tabulate(parameter.width / parameter.maskGranularity)(i =>
             s"if (${prefix}_en & ${prefix}_mask[${i}]) Memory[${prefix}_addr][${i * parameter.maskGranularity} +: ${parameter.maskGranularity}] <= ${prefix}_data[${(i + 1) * parameter.maskGranularity - 1}:${i * parameter.maskGranularity}];"
           )
         else
           Seq(
             s"if (${prefix}_en) Memory[${prefix}_addr] <= ${prefix}_data;"
           )) ++
        Seq(s"end // ${prefix}")
    }
    .flatten

  private val rwLogic = Seq
    .tabulate(parameter.readwrite) { idx =>
      val prefix = s"RW${idx}"
      Seq(
        s"reg [${log2Ceil(parameter.depth) - 1}:0] _${prefix}_raddr;",
        s"reg _${prefix}_ren;",
        s"reg _${prefix}_rmode;"
      ) ++
        Seq(s"always @(posedge ${prefix}_clk) begin // ${prefix}") ++
        Seq(
          s"_${prefix}_raddr <= ${prefix}_addr;",
          s"_${prefix}_ren <= ${prefix}_en;",
          s"_${prefix}_rmode <= ${prefix}_wmode;"
        ) ++
        (if (parameter.masked)
           Seq.tabulate(parameter.width / parameter.maskGranularity)(i =>
             s"if(${prefix}_en & ${prefix}_wmask[${i}] & ${prefix}_wmode) Memory[${prefix}_addr][${i * parameter.maskGranularity} +: ${parameter.maskGranularity}] <= ${prefix}_wdata[${(i + 1) * parameter.maskGranularity - 1}:${i * parameter.maskGranularity}];"
           )
         else
           Seq(
             s"if (${prefix}_en & ${prefix}_wmode) Memory[${prefix}_addr] <= ${prefix}_wdata;"
           )) ++
        Seq(s"end // ${prefix}") ++
        Seq(
          s"assign ${prefix}_rdata = _${prefix}_ren & ~_${prefix}_rmode ? Memory[_${prefix}_raddr] : ${parameter.width}'bx;"
        )
    }
    .flatten

  private val logic =
    (Seq(
      s"reg [${parameter.width - 1}:0] Memory[0:${parameter.depth - 1}];",
      "initial begin",
      """$readmemh("all_zero.hex", Memory);""",
      "end"
    ) ++ wLogic ++ rLogic ++ rwLogic)
      .mkString("\n")

  override def desiredName = parameter.moduleName

  setInline(
    desiredName + ".sv",
    s"""module ${parameter.moduleName}(
       |${verilogInterface}
       |);
       |${logic}
       |endmodule
       |""".stripMargin
  )
}

class BlkBoxMemIO[T <: Data](depth: Int, t: T) extends Bundle {
  val enable = Input(Bool())
  val addr   = Input(UInt(log2Ceil(depth).W))
  val rdData = Output(t)
  val wrEna  = Input(Bool())
  val wrData = Input(t)
}

class DualPortBlkBoxMem[T <: Data](depth: Int, t: T) extends Module {
  val io  = IO(Vec(2, new BlkBoxMemIO(depth, t)))
  val mem = Instantiate(
    new SRAMBlackbox(
      new CIRCTSRAMParameter(
        s"sram_2RW_${depth}x${t.getWidth}",
        0,
        0,
        2,
        depth.intValue,
        t.getWidth,
        0
      )
    )
  )

  for (i <- 0 until 2) {
    mem.io.RW(i).clock       := this.clock
    mem.io.RW(i).address     := io(i).addr
    mem.io.RW(i).enable      := io(i).enable
    io(i).rdData             := mem.io.RW(i).readData
    mem.io.RW(i).writeData   := io(i).wrData
    mem.io.RW(i).writeEnable := io(i).wrEna
  }
}

object DualPortBlkBoxMem extends App {
  ChiselStage.emitSystemVerilogFile(
    new DualPortBlkBoxMem(1024, UInt(8.W)),
    Array("--target-dir", "sv-gen"),
    firtoolOpts = Array("-disable-all-randomization", "-strip-debug-info")
  )
}

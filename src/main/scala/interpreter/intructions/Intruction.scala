package intructions

import interpreter._

/**
 * Created with IntelliJ IDEA.
 * User: cesar
 * Date: 10/28/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
trait Instruction {
  // val NAME: String

  def process

}

trait MemoryInstructions {
  val memory = RAM_Memory.memory

}


trait RegisterInstruction extends Instruction {

}

case class LOADM(var registerName: Char, val value: Int) extends RegisterInstruction {
  def process {
    val register = new Register
    register.binary = RAM_Memory.readMemory(value, 16)
    Registers.registers.put(registerName, register)
  }
}

case class SETM(var registerName: Char, val value: Int) extends RegisterInstruction {
  def process {
    RAM_Memory.setMemory(value, Registers.registers.get(registerName).get.binary)
  }
}

case class LOAD(var registerName: Char, val value: Long) extends RegisterInstruction {
  def process {
    val register = new Register().setBinary(value)
    Registers.registers.put(registerName, register)
  }
}

case class ADD(var registerResult: Char, var register1: Char, val register2: Char) extends RegisterInstruction {
  def process {
    val reg1 = Registers.registers.get(register1).get
    val reg2 = Registers.registers.get(register2).get
    val result = new Register().setBinary(reg1.getDecimal + reg2.getDecimal)
    Registers.registers.put(registerResult, result)

  }
}

case class SUB(var registerResult: Char, var register1: Char, val register2: Char) extends RegisterInstruction {
  def process {
    val reg1 = Registers.registers.get(register1).get
    val reg2 = Registers.registers.get(register2).get
    val as = reg1.binary ^ reg2.binary
    as
    val result = new Register().setBinary(reg1.getDecimal - reg2.getDecimal)
    Registers.registers.put(registerResult, result)

  }
}

trait ExecutionInstruction extends Instruction {

}
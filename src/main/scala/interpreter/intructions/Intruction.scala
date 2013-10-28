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
    Registers.registers.get(registerName).get.binary = RAM_Memory.readMemory(value, 16)
  }
}

case class SETM(var registerName: Char, val value: Int) extends RegisterInstruction {
  def process {
    RAM_Memory.setMemory(value, Registers.registers.get(registerName).get.binary)
  }
}

case class LOAD(var register: Register, val value: Int) extends RegisterInstruction {
  def process {
    register.setBinary(value)
  }
}

case class ADD(var register: Register, val value: Int) extends RegisterInstruction {
  def process {
    RAM_Memory.setMemory(value, register.binary)
  }
}

trait ExecutionInstruction extends Instruction {

}
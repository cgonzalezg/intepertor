package interpreter

import scala.collection.mutable
import scala.collection.JavaConversions._

/**
 * Created with IntelliJ IDEA.
 * User: cesar
 * Date: 10/28/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */
class Register() {
  var binary = Array[Char]()

  def setBinary(value: Long) = {
    binary =
      (1 to 16 - value.toBinaryString.size).map {
        index => '0'
      }.toArray ++ value.toBinaryString.toArray[Char]
    this

  }

  def getDecimal: Long = {
    var index = 0
    binary.reverse.foldLeft(0L)((x, y) => {
      val s: Long = y match {
        case '1' => Math.pow(2,index).toLong
        case '0' => 0
      }
      index += 1
      s + x
    })
  }
}

object Registers {
  var registers = mutable.HashMap(
    'A' -> new Register().setBinary(0),
    'B' -> new Register().setBinary(0),
    'C' -> new Register().setBinary(0)
  )
  val Z: Boolean = false
  var IP: Int = 0

}

object RAM_Memory {
  var memory: Array[Char] = Array[Char]()

  def setMemory(offset: Int, value: Array[Char]) = {
    (0 to value.size) map (index => memory(index) = value(index))
  }

  def readMemory(offset: Int, size: Int): Array[Char] = (offset to offset + size).map(index => memory(index)) toArray
}

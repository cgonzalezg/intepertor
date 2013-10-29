import interpreter.{Register, Registers}

object Hello extends App {
  val register = new Register()
  register.setBinary(8)

  println("binary=>")
  register.binary.map(print)
  println("\ndecimal=> " + register.getDecimal)

  val as = Array[Boolean](false, true, false, false)
  val ass = Array[Boolean](false, true, false, false)
   true ^ false
//  println(as ^ ass)

}

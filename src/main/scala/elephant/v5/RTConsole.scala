package elephant.v5

object RTConsole {
  val getString = IOAction(Console.readLine)
  def putString(s: String) = IOAction(Console.print(s))
  def putLine(s: String) = IOAction(Console.println(s))
}

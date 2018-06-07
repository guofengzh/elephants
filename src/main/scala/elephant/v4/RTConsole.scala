package elephant.v4

object RTConsole_v4 {
  def getString = IOAction_v4(Console.readLine)
  def putString(s: String) = IOAction_v4(Console.print(s))
}

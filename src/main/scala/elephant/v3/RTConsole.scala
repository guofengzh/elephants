package elephant.v3

object RTConsole_v3 {
  def getString = IOAction_v3(Console.readLine)
  def putString(s: String) = IOAction_v3(Console.print(s))
}

package elephant.v1

object RTConsole_v1 {
  def getString(state: WorldState) =
    (state.nextState, Console.readLine)
  def putString(state: WorldState, s: String) =
    (state.nextState, Console.print(s) )
}


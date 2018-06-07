package elephant.v2

/**
  * getString and putString no longer get or put a string - instead they each return a new function
  * that's "waiting" to be executed once a WorldState is provided.
  */
object RTConsole_v2 {
  def getString = {state:WorldState =>
    (state.nextState, Console.readLine)}
  def putString(s: String) = {state: WorldState =>
    (state.nextState, Console.print(s))}
}


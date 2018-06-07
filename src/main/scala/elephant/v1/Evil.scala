package elephant.v1

class Evil_v1 extends IOApplication_v1 {
  import RTConsole_v1._
  def iomain(
              args:Array[String],
              startState:WorldState) = {
    val (stateA, a) = getString(startState)
    val (stateB, b) = getString(startState)
    assert(a == b)
    (startState, b)
  }
}


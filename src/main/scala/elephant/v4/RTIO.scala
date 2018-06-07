package elephant.v4

sealed abstract class IOAction_v4[+A] extends Function1[WorldState, (WorldState, A)] {
  def map[B](f:A => B):IOAction_v4[B] =
    flatMap {x => IOAction_v4(f(x))}
  def flatMap[B](f:A => IOAction_v4[B]):IOAction_v4[B]=
    new ChainedAction(this, f)

  private class ChainedAction[+A, B](
                                      action1: IOAction_v4[B],
                                      f: B => IOAction_v4[A]) extends IOAction_v4[A] {
    def apply(state1:WorldState) = {
      val (state2, intermediateResult) =
        action1(state1);
      val action2 = f(intermediateResult)
      action2(state2)
    }
  }
}

object IOAction_v4 {
  def apply[A](expression: => A):IOAction_v4[A] =
    new SimpleAction(expression)

  private class SimpleAction[+A](expression: => A) extends IOAction_v4[A] {
    def apply(state:WorldState) =
      (state.nextState, expression)
  }
}

// the rest remains the same
sealed trait WorldState{def nextState:WorldState}

abstract class IOApplication_v4 {
  private class WorldStateImpl(id:BigInt) extends WorldState {
    def nextState = new WorldStateImpl(id + 1)
  }
  final def main(args:Array[String]):Unit = {
    val ioAction = iomain(args)
    ioAction(new WorldStateImpl(0));
  }
  def iomain(args:Array[String]):IOAction_v4[_]
}

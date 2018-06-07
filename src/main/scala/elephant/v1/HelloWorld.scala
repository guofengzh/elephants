package elephant.v1;

class HelloWorld_v1 extends IOApplication_v1 {
  import RTConsole_v1._
    def iomain(
            args:Array[String],
            startState:WorldState) =
    putString(startState, "Hello world")
}


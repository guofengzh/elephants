package elephant.v4

object HelloWorld_v4 extends IOApplication_v4 {
  import RTConsole_v4._
  def iomain(args:Array[String]) = {
    for{
      _ <- putString(
        "This is an example of the IO monad.");
      _ <- putString("What's your name?");
      name <- getString;
      _ <- putString("Hello " + name)
    } yield ()
  }
}
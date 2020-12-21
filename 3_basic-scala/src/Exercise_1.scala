/*
    Exercise: Define a def flexibleFizzBuzz method that takes a String => Unit callback function as its argument, and
    allows the caller to decide what they want to do with the output. The caller can choose to ignore the output, println
    the output directly, or store the output in a previously- allocated array they already have handy.
 */


object Exercise_1 extends App {
  def flixibleFizzBuzz(handler: String => Unit): Unit = {
    for (i <- Range.inclusive(1, 100)) {
      handler(
        if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
        else if (i % 3 == 0) "Fizz"
        else if (i % 5 == 0) "Buzz"
        else i.toString
      ) }
  }

  def test(): Unit = {
    flixibleFizzBuzz(s => println(s))
  }

  test()
}

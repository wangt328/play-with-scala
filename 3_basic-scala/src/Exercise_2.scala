/*
    Exercise: Write a recursive method printMessages that can receive an array of Msg class instances, each with an
    optional parent ID, and use it to print out a threaded fashion. That means that child messages are print out
    indented underneath their parents, and the nesting can be arbitrarily deep.
 */

object Exercise_2 extends App {
  class Msg(val id: Int, val parent: Option[Int], val txt: String)

  def printMessages(messages: Array[Msg]): Unit = {
    def printFrag(parent: Option[Int], indent: String): Unit = {
      for (msg <- messages if msg.parent == parent) {
        println(s"$indent#${msg.id} ${msg.txt}")
        printFrag(Some(msg.id), indent + "    ")
      }
    }
    printFrag(None, "")
  }

  def test(): Unit = {
    printMessages(Array(
      new Msg(5, Some(2), "I am Cow"),
      new Msg(0, None, "Hello"),
      new Msg(6, Some(5), "Here me moo, moo"),
      new Msg(1, Some(0), "World"),
      new Msg(2, None, "I am Cow"),
      new Msg(3, Some(2), "Hear me moo"),
      new Msg(4, Some(2), "Here I stand")
    ))
  }

  test()

  /*
      Expected result:

      #0 Hello
          #1 World
      #2 I am Cow
          #3 Hear me moo
          #4 Here I stand
          #5 I am Cow
              #6 Here me moo, moo
   */
}

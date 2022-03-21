import scala.io.StdIn._

object revSentence {
  def main(args : Array[String]): Unit ={
    //input value
    println("enter input value: ")
    val inpSent = readLine()
    val oupSent = inpSent.reverse
    println(oupSent)

    val oupSent2 = inpSent.split(" ").map(x => x.reverse)
    println(oupSent2.mkString(" "))

    val oupSent3 = inpSent.split(" ").reverse
    println(oupSent3.mkString(" "))
  }

}

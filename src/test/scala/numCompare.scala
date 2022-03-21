import scala.io.StdIn._

object numCompare {
  def main(args : Array[String]): Unit ={
    //input total no of integers and integer to be compared
    println("input total no of integers and integer to be compared with two spaces between them: ")
    val numIntComp = readLine().split("  ").map(_.toInt)
    val numInt = numIntComp(0)
    val numComp = numIntComp(1)

    //input integers to be compared
    println("input integers to be compared: ")
    val numArray = readLine().split(" ").map(x => x.toInt)
    val numLength = numArray.length

    //logic
    if (numInt == numLength){
      print(s"number of integers less than $numComp are : ")
      for (i <- numArray) {
        if(i < numComp) print(i+" ")
      }
    }else println("Number of Integers Does not match")
  }

}

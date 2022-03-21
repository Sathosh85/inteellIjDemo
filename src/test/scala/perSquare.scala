import scala.io.StdIn._
import scala.language.postfixOps
object perSquare {
  def main(args : Array[String]): Unit ={
    //Number of Customers
    println("Please Enter Number of Customers: ")
    var numCustomers = readInt()

    //Customers Bills
    println("Please Enter Customers Bills")
    var billsAmount = readLine().split(" ").map(x => x.toInt)

    //logic
    var count = 0
    if (billsAmount.length == numCustomers){
      for (i <- billsAmount){
        val sqrt = math.sqrt(i)
        if(sqrt % 1 == 0) count = count + 1
      }
    }
    else println("Number of Customers is not matching Number of Bills Amount")
    println(s"Number of Customers Eligible for Discount: ${count}")
  }

}

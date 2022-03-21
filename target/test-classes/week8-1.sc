import scala.math._
import scala.io.StdIn._

var noOfCust : Int = 7
var amount = Array(10,20,16,25,30,40,36)
amount(1)
var z = 36
println(sqrt(amount(2)))
var count = 0
for (i <- 0 to ((noOfCust)-1)){
  var x : Double = sqrt(amount(i))
  if ( x % 1 == 0) count = count + 1
  else None
}
println(count)
var p = 3.9
println(p.ceil == p)

amount.length

val a = 3
val b = Array(1,2,3)
for (i <- b){
  if(a == i) println(i)
}
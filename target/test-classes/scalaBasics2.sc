import scala.::

def squareIt(x : Int):Int = x*x   // def squareIt(x:Int) = x*x
println(squareIt(4))

def cubeIt(x:Int) = x*x*x
println(cubeIt(2))

def transformInt(x:Int, f:Int => Int):Int = {
  f(x) //squareIt(2)
} // higher order function
transformInt(2,squareIt)
transformInt(2,cubeIt)

transformInt(2, x=> x*x*x*x) //anonymous function
transformInt(6,y => y/2)

transformInt(3,x => x%2)
transformInt(2,x => {val y = x*2; y*y})

val a = Array(1,2,3,4,5,6)
println(a)
println(a.mkString("|"))
println(a.mkString(","))
for (i <- a) println(i)
a(3) = 9 //mutable
println(a.mkString(","))

//list
val b = List(1,2,3,4,5,6)
println(b)
println(b.head)
println(b.tail)
for(i <- b)println(i)
println(b.mkString("|"))
b.reverse
b.sum
10 :: b

//tuple
val p = (106,"Santhosh",true)
p
p._2
val q =(107,"Anil") //(key,value) pair
val r = 108 -> "Vamshi"

//range
val rng = 1 to 10
for(i <- rng) println(i)
val rng1 = 1 until 10
for(i <- rng1) println(i)

//set
val newSet =  Set(1,2,3,1,3,6,7,6,8,8,9,2)
newSet.min
newSet.max
newSet.sum

//map
val newMap = Map(1 -> "santhosh",2 -> "anil")
newMap.get(2)
newMap.get(3)
val newMap1 = Map(1 -> "santhosh", 2 -> "anil", 1-> "vamshi")
newMap1.get(1)

def func(i:Int):Int = {println("hello");return i*2}
func(3)
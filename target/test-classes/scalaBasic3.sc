import jdk.internal.util.xml.impl.Input

def tripler(i:Int):Int = {i * 3}
def func(i:Int, f:Int => Int)={f(i)}
func(6,tripler)

def func1 ={x:Int => x*x}
func1(9)

var a =  1 to 10
def doubler(i:Int) = {i * 2}
a.map(doubler)

//loop
def factorial(input : Int): Int ={
  var result : Int = 1
  for (i <- 1 to input){
    result = result * i
  }
  result
}
factorial(5)

//recurrsion // takes lot of memory
def fact(Input : Int) : Int ={
  if (Input == 1) 1
  else Input * fact(Input - 1)
}
fact(5)

//tail recurssion
 def fact_tail(input : Int, result : Int): Int ={
   if (input == 1) result
   else fact_tail((input - 1),result * input )
 }
fact_tail(6,1)

val a = 4
val b = 6
a+b
a.+(b)
a.compare(9)
a.compareTo(b)

val d = 1 to 100
d.map((x : Int) => x * 2)
d.map(x => {x * 2; 3 * x})

d.map(_ * 2) //place holder
d.reduce((x:Int,y:Int) => x+y)

//partially applied function
def divFunc(x:Double,y:Double) = {x/y}
divFunc(10,5)
val inverse = divFunc(1,_:Double)
inverse(10)

def sumFunc(x:Int,y:Int) = {x+y}
sumFunc(1,2)
val increment = sumFunc(1,_:Int)
increment(6)

def genericSum(x:Int,y:Int,f:Int => Int)={f(x)+f(y)}
genericSum(2,3,x => x)
genericSum(2,3,x => x*x)
genericSum(2,3,x => x*x*x)
val sumOfSquares = genericSum(_:Int,_:Int,x => x*x)
sumOfSquares(3,4)
val sumOfCubes = genericSum(_:Int,_:Int, x => x*x*x)
sumOfCubes(12,13)

//function currying
def genSum(f:Int => Int)(x:Int,y:Int) = {f(x)+f(y)}
genSum(x => x*x)(5,6)
val squaresSum = genSum(x => x*x)_
squaresSum(2,3)
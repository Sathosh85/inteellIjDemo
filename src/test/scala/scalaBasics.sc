val a: Int = 6

val b : String = ("hello")


println(b)

var c :String = ("there")

println(c)

c = "sap"

println(c)

val oneInt : Int = 1231233456 //4 bytes
val longInt : Long = 23546712354l //8 bytes
val newString : String = "hiw, how are you"
val newBoolean : Boolean = true //
val pi : Double = 3.1415 //8 bytes
val newFloat : Float = 3.1415f //4 bytes
val newByte : Byte = 'n'// 1byte

println("concatenated vale:"+oneInt+longInt+newString+newBoolean)

val name : String ="Sumit"
println(s"hello $name how are you")

println(f"value of pi is  $pi%.2f")

println("hello \n hi")
println(raw"hello \n hi")

val abc = 1>2
println(abc)

val x: String ="sumit"
val y: String = "sumit"
val z = x == y

if (1 > 3){println("hello")}
else {println("there")}

val num = 6
num match {
  case 1 => println("one")
  case 2 => println("two")
  case 3 => println("three")
  case _ => println("something else")

}

for (x <- 1 to 10){
  val squared = x*x
  println(squared)
}

var i =0
while (i <= 10){
  println(i)
  i = i+1
}

var p = 12
do{
  println(p)
  p = p+1
}while(p <= 10)

{val x =10;x+10 }

val abcd = {val  x=20;x+50;10}
println(abcd)

println({val x=30;x+6})
object myFirst extends App {
  println("hello world")
  def add(num : Int = 6, incrementBy : Int = 1): Unit ={ //num , incrementBy are default arguments
    println(num + incrementBy)
  }
  add(5)
  add(6,5)
  add(incrementBy = 6) //named argument

  def prntFn(name : String*): Unit ={ //name is variable argument
    for (i <- name){
      println(i)
    }
  }
  prntFn("hello","hi","how","are","you")

  //null
  def tryIt(name: String):Unit = println("hii")
  tryIt(null)

  //Nil
  val c = Nil
  println(c)

  //Noting
  //def fun= {throw new Exception}
  //fun

  //Nothing
  def getAStringMayBe(num : Int):Option[String]={
    if(num >= 0) Some("A Positive Number")
    else None
  }
  def printResult(num: Int)={  //wrapper class
    getAStringMayBe(num) match {
      case Some(str) => println(str)
      case None => println("No String")
    }

  }
  printResult(6)

}

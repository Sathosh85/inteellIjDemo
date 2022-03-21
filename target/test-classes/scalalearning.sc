  class person(val name : String, id : Int) {
    val p = new person("santhosh", 1)
    println(p.name) // name is field of class
    //println(p.id) it gives error because id is parameter
  }

  class Person(name : String, age : Int){
    val x = 60
    def ageDoubler = age * 2
    def  salaryDoubler(salary : Int) = salary * 2
  }

  val p1 = new Person("sumit",40)
  println(p1.x) //x is field in class
  p1.ageDoubler
  p1.salaryDoubler(45000)

  //class level functionality
  object people{ //people instance already created
    // same like static in java
    // same for every one
    val N_eye = 2
    def canFly: Boolean = false
  }
  class people(val name:String,val age:Int){
    //instance-level functionality
    //diff for every one
    def salDoubler(salary:Int) = salary * 2
  }
  val peop1 = new people("sam",25)
  val peop2 = new people("sushant", 31)
  println(peop1 == peop2)
  //companion
  peop1.name
  people.N_eye
  println(people.N_eye)
  println(people.canFly)
  val marry = people //
  val john = people
  println(marry == john)

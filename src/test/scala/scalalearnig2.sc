class Animal{ //parent class
  def eat = println("Animals eat different types of food")
  private  def animalType("Mammal")
}
class Cat extends Animal{  //child class
  def prefferedMeal = println("Fruits")
}

val cat = new Cat
cat.eat
cat.prefferedMeal

//cat.animalType  //this statement will give error, because animalType is private

//abstract class
abstract class Animal1{

}
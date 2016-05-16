package domainSpecificLanguage

import scala.collection.mutable.ListBuffer

class Pizza {
  var hasSauce = false
  var hasCheese = false
  var toppings = new ListBuffer[String]()

  def spread(input : String): Pizza = {
    if (input == "sauce") hasSauce = true else hasCheese = true
    this
   }

  def add(topping: String): Pizza = {
    toppings += topping
    this
  }

  def Pizza(and : String) : Pizza = {
    this
  }

  def then(bake: String): Pizza = {
    this
  }

}

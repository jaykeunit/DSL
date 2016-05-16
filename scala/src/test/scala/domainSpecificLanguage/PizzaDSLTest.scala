package domainSpecificLanguage

import org.scalatest.FunSuite

class PizzaDSLTest extends FunSuite with PizzaMaker{

  test("Canary"){
    assert(true)
  }

  test("test Create returns new pizza") {
    val result = (create)

    assert(List(result.hasCheese,result.hasSauce, result.toppings.toList) == List(false,false,List()))
  }

  test("test (Create Pizza and) returns new pizza") {
    val result = (create Pizza and)

    assert((result.hasCheese,result.hasSauce, result.toppings.toList) == (false,false,List()))
  }

  test("test spread cheese") {
    val result = (create Pizza and
                  spread cheese)

    assert(result.hasCheese)
  }

  test("test spread sauce") {
    val result = (create Pizza and
                  spread sauce)

    assert(result.hasSauce)
  }

  test("test add pepperoni") {
    val result = (create Pizza and
                  add pepperoni)

    assert(result.toppings.toList == List("pepperoni"))
  }

  test("test add ham") {
    val result = (create Pizza and
                  add ham)

    assert(result.toppings.toList == List("ham"))
  }

  test("test add sausage") {
    val result = (create Pizza and
                  add sausage)

    assert(result.toppings.toList == List("sausage"))
  }

  test("test the bake returns new pizza") {
    val result = (create Pizza and
                  then bake)

    assert(List(result.hasCheese,result.hasSauce, result.toppings.toList) == List(false,false,List()))
  }

  test("test complete pizza") {
    val result = (create Pizza and
                  spread sauce
                  spread cheese
                  add pepperoni
                  add ham
                  add sausage
                  then bake)

    assert(List(result.hasCheese,result.hasSauce, result.toppings.toList) == List(true,true,List("pepperoni", "ham", "sausage")))
  }
}

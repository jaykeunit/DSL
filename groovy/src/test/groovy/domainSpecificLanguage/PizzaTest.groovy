package domainSpecificLanguage

import org.junit.Test

class PizzaTest extends GroovyTestCase {
    @Delegate Pizza delegatePizza = new Pizza()

    @Test
    public void testCanary () {
        assertTrue(true)
    }

    @Test
    public void testCreateReturnsNewPizza() {
        def resultPizza = create pizza
        assertTrue(resultPizza.dump().contains("hasSauce=false hasCheese=false toppings=[]"))
    }


    @Test
    public void testAndWithNoCommands() {
        def resultPizza = create pizza and {}
        assertEquals(null, resultPizza)
    }

    @Test
    public void testSpreadSauce() {
        def hasSauce = create pizza and {
            spread sauce
        }
        assertTrue(hasSauce)
    }

    @Test
    public void testSpreadCheese() {
        def hasCheese = create pizza and {
            spread cheese
        }
        assertTrue(hasCheese)
    }

    @Test
    public void testAddToppings() {
        def pizzaToppings = create pizza and {
            toppings pepperoni, sausage, garlic
        }
        assertEquals([pepperoni, sausage, garlic], pizzaToppings)
    }

    @Test
    public void testBakeReturnsNewPizza() {
        def resultPizza = create pizza and {
            bake
        }
        assertTrue(resultPizza.dump().contains("hasSauce=false hasCheese=false toppings=[]"))
    }

    @Test
    public void testCompletePizza() {
        def resultPizza = create pizza and {
            spread sauce
            spread cheese
            toppings pepperoni, sausage, garlic
            bake
       }
       assertTrue(resultPizza.dump().contains("hasSauce=true hasCheese=true toppings=[pepperoni, sausage, garlic]"))
    }
}
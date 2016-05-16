package domainSpecificLanguage

class Pizza {

    def hasSauce = false
    def hasCheese = false
    def toppings = []

    def create (name) {
        new Pizza()
    }

    def and (pizzaActions) {
        pizzaActions()
    }

    def getBake() {
        this
    }

    def spread (sauceOrCheese) {
        if (sauceOrCheese == 'sauce') {
            hasSauce = true
        }
        else
            hasCheese = true

    }

    def toppings (...listOfToppings) {
        toppings = listOfToppings.collect()
    }

    def propertyMissing(name) {
        name
    }
}
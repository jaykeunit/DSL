package domainSpecificLanguage

trait PizzaMaker {

  def create(): Pizza = {
    new Pizza()
  }
}

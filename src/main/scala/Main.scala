import Item._

object Main extends App {

  val checkout = new Checkout
  val items = Seq(Apple, Apple, Orange, Apple)
  val total = checkout.getTotalCost(items)

  println(s"Items: $items")
  println(s"Total: £$total")

}

import discount.BuyNGetOneFree
import item.Item._

/**
 * @author Yuriy Tumakha
 */
object Main extends App {

  val checkout = new Checkout(Seq(BuyNGetOneFree(Apple, 2), BuyNGetOneFree(Orange, 3)))
  val items = Seq(Apple, Apple, Orange, Apple)
  val total = checkout.getTotalCost(items)

  println(s"Items: $items")
  println(s"Total: £$total")

}

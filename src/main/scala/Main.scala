import checkout.Checkout
import discount.BuyNGetOneFree
import item.Item._

/**
 * @author Yuriy Tumakha
 */
object Main extends App {

  val checkout = new Checkout()
  val items = Seq(Apple, Apple, Orange, Apple, Orange, Banana, Banana)
  val receipt = checkout.buildReceipt(items)

  println(s"Items: $items")
  println(receipt.items2Print)
  println(s"Total: £${receipt.total}")

}

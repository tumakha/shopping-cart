package checkout

import checkout.Checkout
import item.Item._
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

/**
 * @author Yuriy Tumakha
 */
class CheckoutSpec extends AnyFlatSpec with should.Matchers {

  "checkout.Checkout" should "calculate total cost" in {
    val checkout = new Checkout
    val items = Seq(Apple, Apple, Orange, Apple, Orange, Orange)

    val receipt = checkout.buildReceipt(items)
    println(receipt.items2Print)
    receipt.itemsMap shouldBe Map(Apple -> (3, 1.20), Orange -> (3, 0.50))
    receipt.total shouldBe 1.70
  }

  it should "calculate total cost without discounts" in {
    val checkout = new Checkout(Seq.empty)
    val items = Seq(Apple, Apple, Orange, Apple, Orange, Orange)

    val receipt = checkout.buildReceipt(items)
    receipt.itemsMap shouldBe Map(Apple -> (3, 1.80), Orange -> (3, 0.75))
    receipt.total shouldBe 2.55
  }

  it should "apply CheapestFree discount" in {
    val checkout = new Checkout()
    val items = Seq(Apple, Apple, Apple, Orange,
      Banana, Banana, Banana, Banana, Banana, Banana, Banana, Banana, Banana, Banana)

    val receipt = checkout.buildReceipt(items)
    println(receipt.items2Print)
    receipt.itemsMap shouldBe Map(Apple -> (3, 1.20), Orange -> (1, 0.25), Banana -> (10, 0.0))
    receipt.total shouldBe 1.45
  }

  it should "handle empty items list" in {
    val receipt = new Checkout().buildReceipt(Seq())
    receipt.itemsMap shouldBe Map()
    receipt.total shouldBe 0.0
  }

}

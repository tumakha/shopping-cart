import item.Item._
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

/**
 * @author Yuriy Tumakha
 */
class CheckoutSpec extends AnyFlatSpec with should.Matchers {

  "Checkout" should "calculate total cost" in {
    val checkout = new Checkout
    checkout.getTotalCost(Seq(Apple, Apple, Orange, Apple)) shouldBe 1.45
    checkout.getTotalCost(Seq(Apple, Apple, Orange, Apple, Orange, Orange, Apple)) shouldBe 1.70
  }

  it should "calculate total cost without discounts" in {
    val checkout = new Checkout(Seq.empty)
    val items = Seq(Apple, Apple, Orange, Apple)
    checkout.getTotalCost(items) shouldBe 2.05
  }

  it should "handle empty items list" in {
    new Checkout().getTotalCost(Seq()) shouldBe 0.0
  }

}

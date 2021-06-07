import discount.{BuyNGetOneFree, Discount}
import item.Item
import item.Item._

/**
 * @author Yuriy Tumakha
 */
class Checkout(discounts: Seq[Discount] = Seq(BuyNGetOneFree(Apple, 2), BuyNGetOneFree(Orange, 3))) {

  def getTotalCost(items: Seq[Item]): BigDecimal = {
    val total = items.map(_.price).sum
    discounts.foldLeft(total) {
      _ - _.getDiscount(items)
    }
  }

}

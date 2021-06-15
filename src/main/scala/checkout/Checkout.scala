package checkout

import checkout.Checkout.{ItemsMap, defaultDiscounts}
import discount.{BuyNGetOneFree, CheapestFree, Discount}
import item.Item
import item.Item._

/**
 * @author Yuriy Tumakha
 */
object Checkout {

  type ItemsMap = Map[Item, (Int, BigDecimal)]

  val defaultDiscounts = Seq(
    BuyNGetOneFree(2 -> Seq(Apple, Banana), 3 -> Seq(Orange)),
    CheapestFree(Apple, Banana)
  )

}

class Checkout(discounts: Seq[Discount] = defaultDiscounts) {

  def buildReceipt(items: Seq[Item]): Receipt = {
    val itemsMap: ItemsMap = items.groupMapReduce(identity)(_ => 1)(_ + _)
      .map { (item, count) => (item, (count, count * item.price)) }

    val itemsWithDiscount = discounts.foldLeft(itemsMap) {
      (items, discount) => discount.applyDiscount(items)
    }
    Receipt(itemsWithDiscount, itemsWithDiscount.values.map(_._2).sum)
  }

}

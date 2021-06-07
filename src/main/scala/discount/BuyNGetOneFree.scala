package discount

import item.Item

/**
 * @author Yuriy Tumakha
 */
case class BuyNGetOneFree(item: Item, n: Int) extends Discount {

  def getDiscount(items: Seq[Item]): BigDecimal =
    (items.count(_ == item) / n).toInt * item.price

}

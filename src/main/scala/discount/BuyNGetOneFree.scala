package discount

import checkout.Checkout.ItemsMap
import item.Item

/**
 * @author Yuriy Tumakha
 */
case class BuyNGetOneFree(discountItems: (Int, Seq[Item])*) extends Discount {

  def applyDiscount(itemsMap: ItemsMap): ItemsMap =
    discountItems.flatMap((n, dItemSeq) => dItemSeq.map((_, n)))
      .foldLeft(itemsMap) {
        case (itemMap, (dItem, n)) => itemMap.updatedWith(dItem)(_.map {
          (count, total) => (count, total - (count / n).toInt * dItem.price)
        })
      }

}

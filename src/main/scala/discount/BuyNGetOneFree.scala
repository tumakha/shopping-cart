package discount

import checkout.Checkout.ItemsMap
import item.Item

/**
 * @author Yuriy Tumakha
 */
case class BuyNGetOneFree(item: Item, n: Int) extends Discount {

  def applyDiscount(itemsMap: ItemsMap): ItemsMap =
    itemsMap.updatedWith(item)(_.map {
      (count, total) => (count, total - (count / n).toInt * item.price)
    })

}

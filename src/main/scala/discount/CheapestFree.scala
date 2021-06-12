package discount

import checkout.Checkout.ItemsMap
import item.Item

/**
 * @author Yuriy Tumakha
 */
case class CheapestFree(item1: Item, item2: Item, otherItems: Item*) extends Discount {

  val itemSet = Set(item1, item2) ++ Set(otherItems)
  val minCount = 2

  def applyDiscount(itemsMap: ItemsMap): ItemsMap = {
    val matchedItems = itemsMap.view.filterKeys(itemSet(_)).toMap
    if (matchedItems.size >= minCount) {
      val cheapest = matchedItems.minBy(_._2._2)._1
      itemsMap.updatedWith(cheapest)(_.map {
        (count, total) => (count, BigDecimal(0.0))
      })
    } else itemsMap
  }

}

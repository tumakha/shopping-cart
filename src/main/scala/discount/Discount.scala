package discount

import checkout.Checkout.ItemsMap

/**
 * @author Yuriy Tumakha
 */
trait Discount {

  def applyDiscount(itemsMap: ItemsMap): ItemsMap

}

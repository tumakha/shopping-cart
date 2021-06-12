package checkout

import checkout.Checkout.ItemsMap

/**
 * @author Yuriy Tumakha
 */
case class Receipt(itemsMap: ItemsMap, total: BigDecimal) {

  def items2Print: String =
    itemsMap.map {
      case (item, (count, subtotal)) => s"$count x $item = £${subtotal.setScale(2)}"
    }.mkString("\n")

}

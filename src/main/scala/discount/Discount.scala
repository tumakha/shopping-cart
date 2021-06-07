package discount

import item.Item

/**
 * @author Yuriy Tumakha
 */
trait Discount {

  def getDiscount(items: Seq[Item]): BigDecimal

}

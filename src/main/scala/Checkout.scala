/**
 * @author Yuriy Tumakha
 */
class Checkout {

  def getTotalCost(items: Seq[Item]): Double =
    items.map(_.price).sum

}

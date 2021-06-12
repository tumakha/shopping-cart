package item

/**
 * @author Yuriy Tumakha
 */
enum Item(val price: BigDecimal):
  case Apple extends Item(0.60)
  case Orange extends Item(0.25)
  case Banana extends Item(0.20)

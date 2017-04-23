package com.xcafe

class Cafe(menu: Menu, serviceChargeCalculator: ServiceChargeCalculator) {


  def getBill(purchasedItems: String*): BigDecimal = {
    val items: Seq[Item] = purchasedItems.flatMap(menu.getItem)
    val baseBill: BigDecimal = items.map(_.price).sum

    baseBill + serviceChargeCalculator.getServiceCharge(items.map(_.itemType), baseBill)
  }

}

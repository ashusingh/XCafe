package com.xcafe

class Cafe {

  val menu = Map(
    "Cola" -> BigDecimal(.50),
    "Coffee" -> BigDecimal(1.00),
    "Cheese Sandwich" -> BigDecimal(2.00),
    "Steak Sandwich" -> BigDecimal(4.50)
  )

  def getBill(purchasedItem : String*) : BigDecimal = purchasedItem.flatMap(menu.get).sum

}

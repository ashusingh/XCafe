package com.xcafe

class Cafe(menu: Menu) {


  def getBill(purchasedItem : String*) : BigDecimal = purchasedItem.flatMap(menu.getItem).map(_.price).sum

}

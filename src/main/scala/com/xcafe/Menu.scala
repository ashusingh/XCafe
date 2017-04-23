package com.xcafe

case class Item(name: String, price: BigDecimal)

trait Menu {

  def getItem(name: String): Option[Item]

}

object CafeMenu extends Menu {
  val menu = List(
    Item("Cola" , BigDecimal(.50)),
    Item("Coffee" , BigDecimal(1.00)),
    Item("Cheese Sandwich" , BigDecimal(2.00)),
    Item("Steak Sandwich" , BigDecimal(4.50))
  )

  override def getItem(name: String): Option[Item] = menu.find(_.name == name)
}
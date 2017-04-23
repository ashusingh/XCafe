package com.xcafe

import com.xcafe.ItemType.{Drink, Food, HotFood}

sealed trait ItemType

object ItemType {

  object Drink extends ItemType

  object Food extends ItemType

  object HotFood extends ItemType

}

case class Item(name: String, price: BigDecimal, itemType: ItemType)

trait Menu {
  def getItem(name: String): Option[Item]
}

object InMemoryMenu extends Menu {
  val menu = List(
    Item("Cola", BigDecimal(.50), Drink),
    Item("Coffee", BigDecimal(1.00), Drink),
    Item("Cheese Sandwich", BigDecimal(2.00), Food),
    Item("Steak Sandwich", BigDecimal(4.50), HotFood)
  )

  override def getItem(name: String): Option[Item] = menu.find(_.name == name)
}
package com.xcafe

import com.xcafe.ItemType.{Drink, Food, HotFood}
import org.scalatest.{Matchers, WordSpec}

class CafeSpec extends WordSpec with Matchers{

  val stubServiceChargeCalculator = new ServiceChargeCalculator {
    override def getServiceCharge(purchasedItemTypes: Seq[ItemType], baseAmount: BigDecimal): BigDecimal =
      if(purchasedItemTypes.contains(Food) || purchasedItemTypes.contains(HotFood)) BigDecimal(1.50)
      else BigDecimal(0)
  }

  val stubMenu = new Menu {
    override def getItem(name: String): Option[Item] = Map(
      "Cola" -> Item("Cola", BigDecimal(.50), Drink),
      "Coffee" -> Item("Coffee", BigDecimal(1.00), Drink),
      "Steak Sandwich" -> Item("Steak Sandwich", BigDecimal(4.50), HotFood)

    ).get(name)
  }

  val cafe = new Cafe(stubMenu, stubServiceChargeCalculator)

  "getBill" should {
    "return the total amount of the purchased items" in {
      cafe.getBill("Cola", "Coffee") shouldBe BigDecimal(1.5)
    }

    "ignores item not found in menu" in {
      cafe.getBill("Cola", "item4") shouldBe BigDecimal(0.5)
    }

    "add service charge to the total bill" in {
      cafe.getBill("Cola", "Steak Sandwich") should be(5.00 + 1.50)
    }

  }


}

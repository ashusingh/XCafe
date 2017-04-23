package com.xcafe

import org.scalatest.{Matchers, WordSpec}

class CafeSpec extends WordSpec with Matchers{

  val cafe = new Cafe(CafeMenu)

  "getBill" should {
    "return the total amount of the purchased items" in {
      cafe.getBill("Cola", "Coffee", "Cheese Sandwich") shouldBe BigDecimal(3.5)
    }

    "ignores item not found in menu" in {
      cafe.getBill("Cola", "item4") shouldBe BigDecimal(0.5)
    }
  }


}

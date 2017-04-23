package com.xcafe

import com.xcafe.ItemType.{Drink, Food, HotFood}
import org.scalatest.{Matchers, WordSpec}

class ServiceChargeCalculatorSpec extends WordSpec with Matchers {


  "Service charge calculator" should {

    "0 service charge if any hot food purchased" in {
      ServiceChargeCalculator.getServiceCharge(Seq(Drink, Drink), 20) shouldBe BigDecimal(0)
    }

    "10% service charge if any food is purchased" in {
      ServiceChargeCalculator.getServiceCharge(Seq(Drink, Food), 20) shouldBe BigDecimal(2.00)
    }


    "20% service charge if any hot food purchased" in {
      ServiceChargeCalculator.getServiceCharge(Seq(Drink, HotFood), 20) shouldBe BigDecimal(4.00)
    }


    "cap the service charge to max £20" in {
      ServiceChargeCalculator.getServiceCharge(Seq(Drink, HotFood), 150) shouldBe BigDecimal(20.00)
    }

    "round to 2 decimal places" in {
      ServiceChargeCalculator.getServiceCharge(Seq(Drink, HotFood), 10.555) shouldBe BigDecimal(2.11)
      ServiceChargeCalculator.getServiceCharge(Seq(Drink, HotFood), 10.888) shouldBe BigDecimal(2.17)
    }


  }
}

package com.xcafe

import com.xcafe.ItemType.{Food, HotFood}

import scala.math.BigDecimal.RoundingMode

trait ServiceChargeCalculator {
  val MAX_SERVICE_CHARGE: BigDecimal = BigDecimal(20.00)

  def getServiceCharge(purchasedItemTypes: Seq[ItemType], baseAmount: BigDecimal): BigDecimal

}

object ServiceChargeCalculator extends ServiceChargeCalculator {


  override def getServiceCharge(purchasedItemTypes: Seq[ItemType], baseAmount: BigDecimal): BigDecimal = {
    def serviceCharge(rate: BigDecimal, amount: BigDecimal) ={
      val charge = (amount * rate).setScale(2, RoundingMode.FLOOR)
      if(charge > MAX_SERVICE_CHARGE) MAX_SERVICE_CHARGE else charge
    }

    if (purchasedItemTypes.contains(HotFood)) serviceCharge(0.2, baseAmount)
    else if (purchasedItemTypes.contains(Food)) serviceCharge(0.1, baseAmount)
    else BigDecimal(0)

  }


}
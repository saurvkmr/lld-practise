package org.wolt.com.secondTry.impl

import org.wolt.com.dto.DeliveryDetailsDto
import org.wolt.com.firstTry.IFeeCalculator
import org.wolt.com.pojo.DeliveryDetails
import org.wolt.com.secondTry.IFeeCalculatorSecondTry

class SurchargeCalculatorSecondTry: IFeeCalculatorSecondTry<DeliveryDetailsDto> {
  override fun calculate(details: DeliveryDetailsDto): DeliveryDetailsDto {
    if (details.itemCount <= 4) return details
    details.feeInCents += (bulkItemFee(details.itemCount) + extraItemFee(details.itemCount)).toDouble()
    return details
  }

  private fun extraItemFee(itemCount: Int): Int = (itemCount - 4) * 50
  private fun bulkItemFee(itemCount: Int): Int = if (itemCount > 12) 120 else 0
}
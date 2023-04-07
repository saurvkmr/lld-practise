package org.wolt.com.secondTry.impl

import java.time.DayOfWeek
import java.time.ZonedDateTime
import org.wolt.com.dto.DeliveryDetailsDto
import org.wolt.com.secondTry.IFeeCalculatorSecondTry

class RushHourChargeCalculatorSecondTry: IFeeCalculatorSecondTry<DeliveryDetailsDto> {
  override fun calculate(details: DeliveryDetailsDto): DeliveryDetailsDto {
    details.feeInCents *= rushHourSurchargeMultiplier(details.orderTimeInUtc)
    return details
  }

  private fun rushHourSurchargeMultiplier(orderTimeInUtc: ZonedDateTime): Double {
    if (orderTimeInUtc.dayOfWeek == DayOfWeek.FRIDAY && orderTimeInUtc.hour in 15..18) return 1.5
    return 1.0
  }
}
package org.wolt.com.firstTry.impl

import java.time.DayOfWeek
import java.time.ZonedDateTime
import org.wolt.com.firstTry.IFeeCalculator
import org.wolt.com.pojo.DeliveryDetails

class RushHourChargeCalculator: IFeeCalculator<DeliveryDetails> {
  override fun calculate(details: DeliveryDetails): Double =
    rushHourSurchargeMultiplier(details.orderTimeInUtc)

  private fun rushHourSurchargeMultiplier(orderTimeInUtc: ZonedDateTime): Double {
    if (orderTimeInUtc.dayOfWeek == DayOfWeek.FRIDAY && orderTimeInUtc.hour in 15..18) return 1.5
    return 1.0
  }
}
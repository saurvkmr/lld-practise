package org.wolt.com.secondTry.impl

import org.springframework.stereotype.Service
import org.wolt.com.dto.DeliveryDetailsDto
import org.wolt.com.firstTry.IFeeCalculator
import org.wolt.com.pojo.DeliveryDetails
import org.wolt.com.secondTry.IFeeCalculatorSecondTry

@Service
class SimpleDeliveryFeeCalculatorSecondTry : IFeeCalculatorSecondTry<DeliveryDetailsDto> {
  override fun calculate(details: DeliveryDetailsDto): DeliveryDetailsDto {
    details.feeInCents =
      (getFeeForFirstKilometer() + calculateFeeForAdditionalDistance(details.distanceInMeters)).toDouble()
    return details
  }

  private fun calculateFeeForAdditionalDistance(distance: Int): Int {
    if (distance <= 1000) return 0
    val extraDistance = distance - 1000
    return calculateFeeForEachHalfKm(extraDistance) + calculateFeeForLastExtraMeters(extraDistance)
  }

  private fun getFeeForFirstKilometer(): Int = 200
  private fun calculateFeeForEachHalfKm(distance: Int): Int = (distance / 499) * 100
  private fun calculateFeeForLastExtraMeters(distance: Int): Int = (distance % 499) * 100

}
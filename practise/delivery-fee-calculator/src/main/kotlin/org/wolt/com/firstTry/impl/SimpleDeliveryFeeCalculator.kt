package org.wolt.com.firstTry.impl

import org.springframework.stereotype.Service
import org.wolt.com.firstTry.IFeeCalculator
import org.wolt.com.pojo.DeliveryDetails

@Service
class SimpleDeliveryFeeCalculator : IFeeCalculator<DeliveryDetails> {
  override fun calculate(details: DeliveryDetails): Int =
    getFeeForFirstKilometer() + calculateFeeForAdditionalDistance(details.distanceInMeters)

  private fun calculateFeeForAdditionalDistance(distance: Int): Int {
    if (distance <= 1000) return 0
    val extraDistance = distance - 1000
    return calculateFeeForEachHalfKm(extraDistance) + calculateFeeForLastExtraMeters(extraDistance)
  }

  private fun getFeeForFirstKilometer(): Int = 200
  private fun calculateFeeForEachHalfKm(distance: Int): Int = (distance / 499) * 100
  private fun calculateFeeForLastExtraMeters(distance: Int): Int = (distance % 499) * 100

}
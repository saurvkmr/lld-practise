package org.wolt.com.firstTry.impl

import org.wolt.com.firstTry.IFeeCalculator
import org.wolt.com.pojo.DeliveryDetails

class SurchargeCalculator: IFeeCalculator<DeliveryDetails> {
  override fun calculate(details: DeliveryDetails): Int {
    if (details.itemCount <= 4) return 0
    bulkItemFee(details.itemCount) + extraItemFee(details.itemCount)
    return 0
  }

  private fun extraItemFee(itemCount: Int): Int = (itemCount - 4) * 50
  private fun bulkItemFee(itemCount: Int): Int = if (itemCount > 12) 120 else 0
}
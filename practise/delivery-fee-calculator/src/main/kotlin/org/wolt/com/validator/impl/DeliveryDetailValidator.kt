package org.wolt.com.validator.impl

import org.wolt.com.pojo.DeliveryDetails
import org.wolt.com.validator.IValidator

class DeliveryDetailValidator : IValidator<DeliveryDetails> {
  override fun isValid(data: DeliveryDetails): Boolean =
    data.cartValueInCents > 0 && data.distanceInMeters > 0 && data.itemCount > 0
}
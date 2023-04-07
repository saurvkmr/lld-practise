package org.wolt.com.service

import org.springframework.stereotype.Service
import org.wolt.com.firstTry.impl.RushHourChargeCalculator
import org.wolt.com.firstTry.impl.SimpleDeliveryFeeCalculator
import org.wolt.com.firstTry.impl.SurchargeCalculator
import org.wolt.com.pojo.DeliveryDetails
import org.wolt.com.pojo.DeliveryFee
import org.wolt.com.secondTry.impl.RushHourChargeCalculatorSecondTry
import org.wolt.com.secondTry.impl.SimpleDeliveryFeeCalculatorSecondTry
import org.wolt.com.secondTry.impl.SurchargeCalculatorSecondTry
import org.wolt.com.validator.IValidator

@Service
class DeliveryFeeService(
  private val validator: IValidator<DeliveryDetails>,
  private val surchargeCalculator: SurchargeCalculator,
  private val rushHourChargeCalculator: RushHourChargeCalculator,
  private val simpleDeliveryFeeCalculator: SimpleDeliveryFeeCalculator,
  private val surchargeCalculatorSecondTry: SurchargeCalculatorSecondTry,
  private val rushHourChargeCalculatorSecondTry: RushHourChargeCalculatorSecondTry,
  private val simpleDeliveryFeeCalculatorSecondTry: SimpleDeliveryFeeCalculatorSecondTry,
) {

  private val MAX_DELIVERY_FEE: Double = 1500.0

  fun calculateDeliveryFee(deliveryDetail: DeliveryDetails): DeliveryFee {
    if (!validator.isValid(deliveryDetail)) throw IllegalArgumentException("Please check the details")
    if (deliveryDetail.itemCount >= 100) return DeliveryFee(0.0)

    val fee = with(deliveryDetail) {
      simpleDeliveryFeeCalculator.calculate(this)
        .plus(surchargeCalculator.calculate(this))
        .times(rushHourChargeCalculator.calculate(this))
    }.coerceAtMost(MAX_DELIVERY_FEE)
    return DeliveryFee(fee)
  }

  fun calculateDeliveryFeeSecondTry(deliveryDetail: DeliveryDetails): DeliveryFee {
    if (!validator.isValid(deliveryDetail)) throw IllegalArgumentException("Please check the details")
    if (deliveryDetail.itemCount >= 100) return DeliveryFee(0.0)

    val deliveryDetailsDto = deliveryDetail.toDto()
    val fee = with(deliveryDetailsDto) {
      simpleDeliveryFeeCalculatorSecondTry.calculate(this)
      surchargeCalculatorSecondTry.calculate(this)
      rushHourChargeCalculatorSecondTry.calculate(this)
    }.feeInCents.coerceAtMost(MAX_DELIVERY_FEE)

    return DeliveryFee(fee)
  }
}
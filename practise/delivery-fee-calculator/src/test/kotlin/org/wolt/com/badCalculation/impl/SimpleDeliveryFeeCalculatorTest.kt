package org.wolt.com.badCalculation.impl

import java.time.ZonedDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.wolt.com.firstTry.IFeeCalculator
import org.wolt.com.firstTry.impl.SimpleDeliveryFeeCalculator
import org.wolt.com.pojo.DeliveryDetails

internal class SimpleDeliveryFeeCalculatorTest {
  private val classUnderTest: IFeeCalculator<DeliveryDetails> = SimpleDeliveryFeeCalculator()
  @Test
  fun `delivery cost should be 200 cents`() {

    var fee = classUnderTest.calculate(DeliveryDetails(2000, 500, 4, ZonedDateTime.now()))
    assertThat(fee).isEqualTo(200)

    fee = classUnderTest.calculate(DeliveryDetails(2000, 999, 4, ZonedDateTime.now()))
    assertThat(fee).isEqualTo(200)

    fee = classUnderTest.calculate(DeliveryDetails(2000, 1000, 4, ZonedDateTime.now()))
    assertThat(fee).isEqualTo(200)
  }

  @Test
  fun `delivery cost should be 300 cents`() {
    var fee = classUnderTest.calculate(DeliveryDetails(2000, 1001, 4, ZonedDateTime.now()))
    assertThat(fee).isEqualTo(300)

    fee = classUnderTest.calculate(DeliveryDetails(2000, 1499, 4, ZonedDateTime.now()))
    assertThat(fee).isEqualTo(300)
  }

  @Test
  fun `delivery cost should be 400 cents`() {
    val fee = classUnderTest.calculate(DeliveryDetails(2000, 1500, 4, ZonedDateTime.now()))
    assertThat(fee).isEqualTo(400)
  }
}
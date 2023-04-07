package org.wolt.com.pojo

import com.fasterxml.jackson.annotation.JsonProperty

class DeliveryFee(
  @JsonProperty("delivery_fee")
  val feeInCents: Double
)
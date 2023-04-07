package org.wolt.com.dto

import java.time.ZonedDateTime

class DeliveryDetailsDto(
  val cartValueInCents: Int,
  val distanceInMeters: Int,
  val itemCount: Int,
  val orderTimeInUtc: ZonedDateTime,
  var feeInCents: Double = 0.0
)
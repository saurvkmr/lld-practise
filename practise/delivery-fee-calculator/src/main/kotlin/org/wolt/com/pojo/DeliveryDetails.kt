package org.wolt.com.pojo

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.ZonedDateTime
import org.wolt.com.dto.DeliveryDetailsDto

class DeliveryDetails(
  @JsonProperty("cart_value")
  val cartValueInCents: Int,
  @JsonProperty("delivery_distance")
  val distanceInMeters: Int,
  @JsonProperty("number_of_items")
  val itemCount: Int,
  @JsonProperty("time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
  val orderTimeInUtc: ZonedDateTime
) {
  fun toDto() = DeliveryDetailsDto(this.cartValueInCents, this.distanceInMeters, this.itemCount, this.orderTimeInUtc)
}

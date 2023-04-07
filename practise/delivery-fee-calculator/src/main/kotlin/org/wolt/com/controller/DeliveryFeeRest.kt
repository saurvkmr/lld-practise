package org.wolt.com.controller

import org.springframework.http.RequestEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.wolt.com.pojo.DeliveryDetails
import org.wolt.com.pojo.DeliveryFee

@RestController
@RequestMapping("/api")
class DeliveryFeeRest(

) {

  @PostMapping("/delivery-fee")
  fun calculateDeliveryFee(
    @RequestBody details: DeliveryDetails
  ): RequestEntity<DeliveryFee> {
    TODO()
  }
}
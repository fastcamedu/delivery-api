package com.fastcampus.deliveryapi.controller.checkout.dto

data class CheckoutRequest(
    val customerId: Long,
    val discountId: Long,
)
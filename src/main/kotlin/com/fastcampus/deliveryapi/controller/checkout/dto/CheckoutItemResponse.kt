package com.fastcampus.deliveryapi.controller.checkout.dto

import java.math.BigDecimal

data class CheckoutItemResponse(
    val customerId: Long,
    val checkoutId: Long,
    val totalAmount: BigDecimal,
    val checkoutItems: List<CheckoutItemDTO>
)
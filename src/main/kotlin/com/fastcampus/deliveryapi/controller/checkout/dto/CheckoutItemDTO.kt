package com.fastcampus.deliveryapi.controller.checkout.dto

import java.math.BigDecimal

data class CheckoutItemDTO(
    val checkoutId: Long,
    val checkoutItemId: Long,
    val menuId: Long,
    val menuPrice: BigDecimal,
    val menuQuantity: Int,
)
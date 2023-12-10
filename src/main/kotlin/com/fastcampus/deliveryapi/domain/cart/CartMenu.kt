package com.fastcampus.deliveryapi.domain.cart

import java.math.BigDecimal

data class CartMenu(
    val cartId: Long,
    val cartItemId: Long,
    val menuId: Long,
    val menuName: String,
    val menuImageUrl: String,
    val price: BigDecimal,
    val quantity: Int,
)
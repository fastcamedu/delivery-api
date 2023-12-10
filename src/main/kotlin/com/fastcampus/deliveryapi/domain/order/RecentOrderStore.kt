package com.fastcampus.deliveryapi.domain.order

import java.math.BigDecimal

data class RecentOrderStore(
    val orderId: Long,
    val orderStatus: OrderStatus,
    val storeId: Long,
    val storeName: String,
    val reviewGrade: Int,
    val deliveryTime: String,
    val deliveryFee: BigDecimal,
    val mainImageUrl: String,
)
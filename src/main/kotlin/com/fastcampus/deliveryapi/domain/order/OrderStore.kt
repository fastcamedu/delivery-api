package com.fastcampus.deliveryapi.domain.order

import java.math.BigDecimal

data class OrderStore(
    val orderId: Long,
    val orderStatus: OrderStatus,
    val orderTotalAmount: BigDecimal,
    val orderDiscountAmount: BigDecimal,
    val storeId: Long,
    val storeName: String
)

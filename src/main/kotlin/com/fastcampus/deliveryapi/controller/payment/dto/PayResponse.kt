package com.fastcampus.deliveryapi.controller.payment.dto

import java.math.BigDecimal

data class PayResponse(
    val orderId: Long,
    val pgId: Long,
    val pgPaymentId: String,
    val payAmount: BigDecimal,
    val customerId: Long,
)

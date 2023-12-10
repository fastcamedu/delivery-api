package com.fastcampus.deliveryapi.external.pg.dto

import java.math.BigDecimal

data class PgPayResponse(
    val pgPaymentId: String,
    val payAmount: BigDecimal,
    val customerId: Long,
)

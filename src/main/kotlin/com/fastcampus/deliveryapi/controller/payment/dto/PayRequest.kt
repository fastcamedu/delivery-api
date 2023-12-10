package com.fastcampus.deliveryapi.controller.payment.dto

import com.fastcampus.deliveryapi.domain.payment.PaymentMethod

data class PayRequest(
    val checkoutId: Long,
    val customerId: Long,
    val paymentMethod: PaymentMethod,
)
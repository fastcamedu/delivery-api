package com.fastcampus.deliveryapi.controller.order.dto

data class OrderRequest(
    val checkoutId: Long,
    val customerId: Long,
)
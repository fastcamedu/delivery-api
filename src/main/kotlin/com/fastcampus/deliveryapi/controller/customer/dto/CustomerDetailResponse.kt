package com.fastcampus.deliveryapi.controller.customer.dto

data class CustomerDetailResponse(
    val customerId: Long,
    val email: String,
    val customerName: String,
    val phone: String,
    val address: String,
)

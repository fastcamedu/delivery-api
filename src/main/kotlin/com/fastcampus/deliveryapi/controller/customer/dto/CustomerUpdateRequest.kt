package com.fastcampus.deliveryapi.controller.customer.dto

data class CustomerUpdateRequest(
    val customerId: Long,
    val customerName: String,
    val phone: String,
    val address: String,
)

package com.fastcampus.deliveryapi.domain.customer

data class CustomerDetails(
    val customerId: Long,
    val email: String,
    val password: String,
    val role: CustomerRole,
)
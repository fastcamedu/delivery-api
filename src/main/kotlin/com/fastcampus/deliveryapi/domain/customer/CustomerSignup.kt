package com.fastcampus.deliveryapi.domain.customer

data class CustomerSignup(
    val email: String,
    val phone: String,
    val password: String,
    val name: String,
    val address: String,
)

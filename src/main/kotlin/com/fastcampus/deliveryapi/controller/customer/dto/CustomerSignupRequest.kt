package com.fastcampus.deliveryapi.controller.customer.dto

import io.swagger.v3.oas.annotations.Parameter

data class CustomerSignupRequest(
    @Parameter(name = "name", description = "고객 이름")
    val name: String,
    @Parameter(name = "email", description = "고객 이메일")
    val email: String,
    @Parameter(name = "email", description = "고객 휴대폰 번호")
    val phone: String,
    @Parameter(name = "email", description = "고객 가입 비밀번호")
    val password: String,
    @Parameter(name = "email", description = "고객 배달지 주소")
    val address: String,
)
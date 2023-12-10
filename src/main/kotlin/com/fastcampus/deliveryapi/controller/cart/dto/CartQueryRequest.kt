package com.fastcampus.deliveryapi.controller.cart.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니 조회 요청")
data class CartQueryRequest(
    @Schema(name = "customerId", description = "고객 ID", example = "1", required = true)
    val customerId: Long = 1,
)

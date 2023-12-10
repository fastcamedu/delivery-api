package com.fastcampus.deliveryapi.controller.cart.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니의 아이템 목록 응답")
data class CartQueryResponse(
    val customerId: Long,
    @Schema(name = "cartItems", description = "장바구니 아이템 목록", required = true)
    val cartItems: List<CartMenuDTO>
)

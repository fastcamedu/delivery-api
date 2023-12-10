package com.fastcampus.deliveryapi.controller.cart.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니의 아이템 삭제 응답")
data class CartItemRemoveResponse(
    @Schema(name = "cartItemId", description = "장바구니 아이템 ID", example = "123", required = true)
    val cartItemId: Long,
    @Schema(name = "customerId", description = "고객 ID", example = "1234", required = true)
    val customerId: Long,
)
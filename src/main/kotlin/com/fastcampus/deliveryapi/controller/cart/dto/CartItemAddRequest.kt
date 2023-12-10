package com.fastcampus.deliveryapi.controller.cart.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니의 아이템 추가 요청")
data class CartItemAddRequest(
    @Schema(name = "storeId", example = "1234", description = "상점 ID", required = true)
    val storeId: Long,
    @Schema(name = "menuId", example = "1234", description = "메뉴 ID", required = true)
    val menuId: Long,
    @Schema(name = "quantity", example = "10", description = "수량", required = true)
    val quantity: Int,
    @Schema(name = "customerId", example = "123456", description = "고객 ID", required = true)
    val customerId: Long,
)
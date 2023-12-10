package com.fastcampus.deliveryapi.controller.cart.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니의 아이템 추가 응답")
data class CartItemAddResponse(
    @Schema(name = "storeId", example = "1234", description = "상점 ID")
    val storeId: Long,
    @Schema(name = "menuId", example = "1234", description = "메뉴 ID")
    val menuId: Long,
    @Schema(name = "quantity", example = "10", description = "음식 메뉴 수량")
    val quantity: Int,
)
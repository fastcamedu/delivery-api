package com.fastcampus.deliveryapi.controller.cart.dto

import com.fastcampus.deliveryapi.domain.cart.CartMenu
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

@Schema(description = "장바구니 아이템")
data class CartMenuDTO(
    @Schema(name = "cartItemId", description = "장바구니 아이템 ID", required = true)
    val cartItemId: Long,
    @Schema(name = "menuId", description = "음식 메뉴 ID", required = true)
    val menuId: Long,
    @Schema(name = "menuName", description = "음식 메뉴명", required = true)
    val menuName: String,
    @Schema(name = "menuImageUrl", description = "음식 메뉴 이미지", required = true)
    val menuImageUrl: String,
    @Schema(name = "quantity", description = "음식 메뉴 수량", required = true)
    val quantity: Int,
    @Schema(name = "totalPrice", description = "총 가격", required = true)
    val totalPrice: BigDecimal,
) {
    companion object {
        fun from(cartMenu: CartMenu): CartMenuDTO {
            return CartMenuDTO(
                cartItemId = cartMenu.cartItemId,
                menuId = cartMenu.menuId,
                menuName = cartMenu.menuName,
                menuImageUrl = cartMenu.menuImageUrl,
                quantity = cartMenu.quantity,
                totalPrice = cartMenu.price.multiply(BigDecimal(cartMenu.quantity))
            )
        }
    }
}
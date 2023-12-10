package com.fastcampus.deliveryapi.controller.order.dto

import com.fastcampus.deliveryapi.domain.orderitem.OrderItemMenu
import java.math.BigDecimal

data class OrderItemDTO(
    val orderItemId: Long,
    val menuId: Long,
    val menuName: String,
    val menuPrice: BigDecimal,
) {
    companion object {
        fun from(orderItemMenu: OrderItemMenu): OrderItemDTO {
            return OrderItemDTO(
                orderItemId = orderItemMenu.orderItemId,
                menuId = orderItemMenu.menuId,
                menuPrice = orderItemMenu.menuPrice,
                menuName = orderItemMenu.menuName,
            )
        }
    }
}

package com.fastcampus.deliveryapi.domain.orderdiscount

import com.fastcampus.deliveryapi.repository.orderdiscount.OrderDiscountItem
import java.math.BigDecimal

data class OrderDiscountItemDTO(
    val orderId: Long,
    val discountId: Long,
    val discountAmount: BigDecimal
) {
    companion object {
        fun from(orderDiscountItem: OrderDiscountItem?): OrderDiscountItemDTO? {
            if (orderDiscountItem == null) {
                return null
            }
            return OrderDiscountItemDTO(
                orderId = orderDiscountItem.orderId,
                discountId = orderDiscountItem.discountId,
                discountAmount = orderDiscountItem.discountAmount,
            )
        }
    }
}

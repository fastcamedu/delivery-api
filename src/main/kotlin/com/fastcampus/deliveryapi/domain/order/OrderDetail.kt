package com.fastcampus.deliveryapi.domain.order

import com.fastcampus.deliveryapi.domain.orderitem.OrderItemMenu
import com.fastcampus.deliveryapi.repository.orderdiscount.OrderDiscountItem

data class OrderDetail(
    val orderId: Long,
    val customerId: Long,
    val storeId: Long,
    val orderItems: List<OrderItemMenu>,
    val orderDiscountItem: OrderDiscountItem?,
)

package com.fastcampus.deliveryapi.controller.orderhistories.dto

import com.fastcampus.deliveryapi.domain.order.OrderStatus


data class OrderHistoryRequest(
    val customerId: Long,
    val orderStatus: OrderStatus,
)
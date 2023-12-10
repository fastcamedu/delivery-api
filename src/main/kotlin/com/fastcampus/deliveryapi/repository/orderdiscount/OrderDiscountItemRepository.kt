package com.fastcampus.deliveryapi.repository.orderdiscount

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderDiscountItemRepository: JpaRepository<OrderDiscountItem, Long> {
    fun findAllByOrderId(orderId: Long): List<OrderDiscountItem>
}
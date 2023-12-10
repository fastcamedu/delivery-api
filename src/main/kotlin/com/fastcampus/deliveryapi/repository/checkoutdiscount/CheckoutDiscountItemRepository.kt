package com.fastcampus.deliveryapi.repository.checkoutdiscount

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckoutDiscountItemRepository: JpaRepository<CheckoutDiscountItem, Long> {
    fun findAllByCheckoutId(checkoutId: Long): List<CheckoutDiscountItem>
}
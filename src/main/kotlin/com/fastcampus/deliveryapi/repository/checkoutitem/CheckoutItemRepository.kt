package com.fastcampus.deliveryapi.repository.checkoutitem

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CheckoutItemRepository: JpaRepository<CheckoutItem, Long> {
    fun findAllByCheckoutId(checkoutId: Long): List<CheckoutItem>
}
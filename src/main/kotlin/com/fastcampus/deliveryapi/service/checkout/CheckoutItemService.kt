package com.fastcampus.deliveryapi.service.checkout

import com.fastcampus.deliveryapi.exception.NotFoundCheckoutException
import com.fastcampus.deliveryapi.repository.checkout.CheckoutRepository
import com.fastcampus.deliveryapi.repository.checkoutitem.CheckoutItem
import com.fastcampus.deliveryapi.repository.checkoutitem.CheckoutItemRepository
import org.springframework.stereotype.Service

@Service
class CheckoutItemService(
    val checkoutRepository: CheckoutRepository,
    val checkoutItemRepository: CheckoutItemRepository,
) {
    fun findByCheckoutId(checkoutId: Long): List<CheckoutItem> {
        return checkoutItemRepository.findAllByCheckoutId(checkoutId)
    }

    fun findByCustomerId(customerId: Long): List<CheckoutItem> {
        val checkoutOptional = checkoutRepository.findByCustomerIdAndIsDeletedIsFalse(customerId)
        if (checkoutOptional.isEmpty) {
            throw NotFoundCheckoutException("Not found checkout, customerId = $customerId")
        }
        val checkout = checkoutOptional.get()
        return checkoutItemRepository.findAllByCheckoutId(checkout.checkoutId)
    }
}
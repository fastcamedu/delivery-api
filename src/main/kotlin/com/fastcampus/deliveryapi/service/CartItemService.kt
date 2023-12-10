package com.fastcampus.deliveryapi.service

import com.fastcampus.deliveryapi.domain.cart.CartMenu
import com.fastcampus.deliveryapi.repository.cartitem.CartItemRepository
import org.springframework.stereotype.Service

@Service
class CartItemService(
    private val cartItemRepository: CartItemRepository
) {
    fun findAllByCartId(cartId: Long): List<CartMenu> {
        return cartItemRepository.findAllByCartId(cartId)
    }

    fun remove(cartId: Long, orderedMenuIds: List<Long>) {
        val cartItems = cartItemRepository.findAllByCartIdAndMenuIdIn(cartId = cartId, menuIds = orderedMenuIds)
        cartItems.forEach {
            it.isDeleted = true
            it.quantity = 0
        }
        cartItemRepository.saveAll(cartItems)
    }
}
package com.fastcampus.deliveryapi.service.cart

import com.fastcampus.deliveryapi.exception.NotFoundException
import com.fastcampus.deliveryapi.repository.cart.Cart
import com.fastcampus.deliveryapi.repository.cart.CartRepository
import com.fastcampus.deliveryapi.repository.cartitem.CartItem
import com.fastcampus.deliveryapi.repository.cartitem.CartItemRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CartService(
    private val cartRepository: CartRepository,
    private val cartItemRepository: CartItemRepository,
) {

    @Value("\$server.role-name")
    private lateinit var serverRoleName: String

    companion object {
        private const val INIT_QUANTITY = 1
    }

    fun upsert(addCartItem: AddCartItem) {
        val cartOptional =
            cartRepository.findAllByCustomerIdAndIsDeleted(addCartItem.customerId, false)
        if (cartOptional.isEmpty) {
            val cart = Cart(
                customerId = addCartItem.customerId,
            )
            cart.createdBy = serverRoleName
            cart.updatedBy = serverRoleName
            val createdCart = cartRepository.save(cart)
            addMenuToCart(createdCart, addCartItem)
        }

        val findAgainCartOptional = cartRepository.findAllByCustomerIdAndIsDeleted(addCartItem.customerId, false)
        val cart = findAgainCartOptional.get()
        addMenuToCart(cart, addCartItem)
    }

    private fun addMenuToCart(cart: Cart, addCartItem: AddCartItem) {
        val cartItemOptional =
            cartItemRepository.findCartItemByCartIdAndMenuIdAndStoreIdAndIsDeletedIsFalse(
                cartId = cart.cartId,
                menuId = addCartItem.menuId,
                storeId = addCartItem.storeId,
            )
        if (cartItemOptional.isEmpty) {
            val cartItem = CartItem(
                cartId = cart.cartId,
                storeId = addCartItem.storeId,
                menuId = addCartItem.menuId,
                quantity = addCartItem.quantity,
            )
            cartItem.createdBy = serverRoleName
            cartItem.updatedBy = serverRoleName
            cartItemRepository.save(cartItem)
        } else {
            val cartItem = cartItemOptional.get()
            cartItem.quantity = addCartItem.quantity
            cartItemRepository.save(cartItem)
        }
    }

    fun findByCustomerId(customerId: Long): Cart {
        val cartOptional = cartRepository.findAllByCustomerIdAndIsDeleted(customerId, false)
        if (cartOptional.isEmpty) {
            throw NotFoundException("고객님의 장바구니 정보를 찾을 수 없습니다.")
        }
        return cartOptional.get()
    }

    fun remove(customerId: Long, cartItemId: Long): CartItem {
        val cartOptional = cartRepository.findAllByCustomerIdAndIsDeleted(customerId, false)
        if (cartOptional.isEmpty) {
            throw IllegalArgumentException("고객님의 장바구니 정보가 없습니다.")
        }

        val cartItemOptional =
            cartItemRepository.findById(cartItemId)

        if (cartItemOptional.isEmpty) {
            throw IllegalArgumentException("삭제한 장바구니 아이템이 없습니다.")
        }
        val cartItem = cartItemOptional.get()
        cartItem.isDeleted = true
        cartItem.quantity = 0

        return cartItemRepository.save(cartItem)
    }
}
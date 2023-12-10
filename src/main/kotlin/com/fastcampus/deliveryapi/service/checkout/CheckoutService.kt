package com.fastcampus.deliveryapi.service.checkout

import com.fastcampus.deliveryapi.domain.cart.CartMenu
import com.fastcampus.deliveryapi.repository.checkout.Checkout
import com.fastcampus.deliveryapi.repository.checkout.CheckoutRepository
import com.fastcampus.deliveryapi.repository.checkoutdiscount.CheckoutDiscountItem
import com.fastcampus.deliveryapi.repository.checkoutdiscount.CheckoutDiscountItemRepository
import com.fastcampus.deliveryapi.repository.checkoutitem.CheckoutItem
import com.fastcampus.deliveryapi.repository.checkoutitem.CheckoutItemRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class CheckoutService(
    private val checkoutRepository: CheckoutRepository,
    private val checkoutItemRepository: CheckoutItemRepository,
    private val checkoutDiscountItemRepository: CheckoutDiscountItemRepository,
) {
    @Value("\${server.role-name}")
    lateinit var roleName: String

    fun create(customerId: Long, discountId: Long, cartMenus: List<CartMenu>): Checkout {
        val savedCheckout = createCheckout(customerId, discountId)
        removeCheckoutExcept(customerId, savedCheckout.checkoutId)

        createCheckoutItems(cartMenus, savedCheckout)
        createCheckoutDiscount(savedCheckout.checkoutId, discountId)

        return savedCheckout
    }

    private fun removeCheckoutExcept(customerId: Long, checkoutId: Long) {
        val checkouts = checkoutRepository.findAllByCheckoutIdIsNotAndCustomerIdIs(
            checkoutId = checkoutId, customerId = customerId
        )
        checkouts.forEach { it.isDeleted = true }
        checkoutRepository.saveAll(checkouts)
    }

    private fun createCheckoutDiscount(checkoutId: Long, discountId: Long): CheckoutDiscountItem {
        val checkoutDiscountItem = CheckoutDiscountItem(
            discountId = discountId,
            checkoutId = checkoutId,
        )
        checkoutDiscountItem.createdBy = roleName
        checkoutDiscountItem.updatedBy = roleName
        return checkoutDiscountItemRepository.save(checkoutDiscountItem)
    }

    private fun createCheckout(customerId: Long, storeId: Long): Checkout {
        val checkout = Checkout(
            customerId = customerId,
            storeId = storeId,
        )
        checkout.createdBy = roleName
        checkout.updatedBy = roleName

        return checkoutRepository.save(checkout)
    }

    private fun createCheckoutItems(
        cartMenus: List<CartMenu>,
        savedCheckout: Checkout
    ) {
        val checkoutItems = cartMenus.map {
            val checkoutItem = CheckoutItem(
                checkoutId = savedCheckout.checkoutId,
                menuId = it.menuId,
                menuPrice = it.price,
                menuQuantity = it.quantity,
            )
            checkoutItem.createdBy = roleName
            checkoutItem.updatedBy = roleName
            checkoutItem
        }
        checkoutItemRepository.saveAll(checkoutItems)
    }

    fun findByCustomerId(customerId: Long): Optional<Checkout> {
        return checkoutRepository.findByCustomerIdAndIsDeletedIsFalse(customerId)
    }
}
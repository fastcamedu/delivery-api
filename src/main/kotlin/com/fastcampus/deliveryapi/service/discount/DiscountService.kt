package com.fastcampus.deliveryapi.service.discount

import com.fastcampus.deliveryapi.domain.discount.DiscountMethod
import com.fastcampus.deliveryapi.repository.checkoutdiscount.CheckoutDiscountItemRepository
import com.fastcampus.deliveryapi.repository.discount.Discount
import com.fastcampus.deliveryapi.repository.discount.DiscountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
@Transactional
class DiscountService(
    private val discountRepository: DiscountRepository,
    private val checkoutDiscountItemRepository: CheckoutDiscountItemRepository,
) {
    fun findAvailableDiscount(currentDateTime: OffsetDateTime): List<Discount> {
        return this.discountRepository.findAllAvailableDiscount(currentDateTime)
    }

    fun find(discountIds: List<Long>): List<Discount> {
        return this.discountRepository.findAllByDiscountIdIn(discountIds)
    }

    fun findDiscountBy(checkoutId: Long): Discount? {
        val checkoutDiscountItems = checkoutDiscountItemRepository.findAllByCheckoutId(checkoutId)
        val discountIds = checkoutDiscountItems.map { it.discountId }
        val discounts = find(discountIds)
        return discounts.filter { it.discountMethod == DiscountMethod.FIXED_AMOUNT }.maxByOrNull { it.discountValue }
    }
}
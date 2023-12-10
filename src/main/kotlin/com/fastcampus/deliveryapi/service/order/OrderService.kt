package com.fastcampus.deliveryapi.service.order

import com.fastcampus.deliveryapi.controller.order.dto.OrderRequest
import com.fastcampus.deliveryapi.domain.order.OrderDetail
import com.fastcampus.deliveryapi.domain.order.OrderUUIDGenerator
import com.fastcampus.deliveryapi.exception.DuplicateOrderException
import com.fastcampus.deliveryapi.exception.NotFoundCheckoutException
import com.fastcampus.deliveryapi.exception.NotFoundOrderException
import com.fastcampus.deliveryapi.repository.checkout.Checkout
import com.fastcampus.deliveryapi.repository.checkout.CheckoutRepository
import com.fastcampus.deliveryapi.repository.checkoutitem.CheckoutItem
import com.fastcampus.deliveryapi.repository.checkoutitem.CheckoutItemRepository
import com.fastcampus.deliveryapi.repository.order.Order
import com.fastcampus.deliveryapi.repository.order.OrderRepository
import com.fastcampus.deliveryapi.repository.orderdiscount.OrderDiscountItem
import com.fastcampus.deliveryapi.repository.orderdiscount.OrderDiscountItemRepository
import com.fastcampus.deliveryapi.repository.orderitem.OrderItem
import com.fastcampus.deliveryapi.repository.orderitem.OrderItemRepository
import com.fastcampus.deliveryapi.service.CartItemService
import com.fastcampus.deliveryapi.service.cart.CartService
import com.fastcampus.deliveryapi.service.discount.DiscountService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
@Transactional
class OrderService(
    private val checkoutRepository: CheckoutRepository,
    private val checkoutItemRepository: CheckoutItemRepository,
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val discountService: DiscountService,
    private val orderDiscountItemRepository: OrderDiscountItemRepository,
    private val cartService: CartService,
    private val cartItemService: CartItemService,
) {
    @Value("\${server.role-name}")
    lateinit var roleName: String

    fun order(orderRequest: OrderRequest): Order {
        val checkoutOptional = checkoutRepository.findById(orderRequest.checkoutId)
        if (checkoutOptional.isEmpty) {
            throw NotFoundCheckoutException("체크아웃 정보를 찾을 수 없습니다. ${orderRequest.checkoutId}")
        }
        val checkout = checkoutOptional.get()
        validateDuplicatedOrder(orderRequest.checkoutId)
        val checkoutItems = checkoutItemRepository.findAllByCheckoutId(checkout.checkoutId)
        val menuPrices = checkoutItems.map { it.menuPrice.multiply(BigDecimal(it.menuQuantity)) }
        val orderAmount = menuPrices.sumOf { it }
        val maxDiscount = discountService.findDiscountBy(checkoutId = checkout.checkoutId)
        val discountValue = maxDiscount?.discountValue?.let { BigDecimal(it) } ?: BigDecimal(0)
        val totalAmount = orderAmount.minus(discountValue)

        // 주문 생성
        val createdOrder = createOrder(checkout, orderAmount, discountValue, totalAmount)

        // 주문 아이템 생성
        val orderItems = createOrderItems(checkoutItems, createdOrder)

        // 장바구니 아이템 삭제
        removeCartItems(orderRequest, orderItems)

        return createdOrder
    }

    private fun createOrder(
        checkout: Checkout,
        orderAmount: BigDecimal,
        discountValue: BigDecimal,
        totalAmount: BigDecimal
    ): Order {
        val orderUUID = OrderUUIDGenerator.gen()
        val order = Order(
            orderUUID = orderUUID.id,
            orderShortenId = orderUUID.shortenId,
            checkoutId = checkout.checkoutId,
            orderAmount = orderAmount,
            discountAmount = discountValue,
            deliveryFee = BigDecimal.ZERO,
            totalAmount = totalAmount,
            storeId = checkout.storeId,
            customerId = checkout.customerId,
        )
        order.createdBy = roleName
        order.updatedBy = roleName
        val createdOrder = orderRepository.save(order)
        return createdOrder
    }

    private fun createOrderItems(
        checkoutItems: List<CheckoutItem>,
        createdOrder: Order
    ): List<OrderItem> {
        val orderItems = checkoutItems.map {
            val orderItem = OrderItem(
                orderId = createdOrder.orderId,
                menuId = it.menuId,
                menuPrice = it.menuPrice,
                menuQuantity = it.menuQuantity,
            )
            orderItem.createdBy = roleName
            orderItem.updatedBy = roleName
            orderItem
        }
        orderItemRepository.saveAll(orderItems)
        return orderItems
    }

    private fun removeCartItems(
        orderRequest: OrderRequest,
        orderItems: List<OrderItem>
    ) {
        val cart = cartService.findByCustomerId(customerId = orderRequest.customerId)
        val orderedMenuIds = orderItems.map { it.menuId }.toList()
        cartItemService.remove(cartId = cart.cartId, orderedMenuIds = orderedMenuIds)
    }

    private fun validateDuplicatedOrder(checkoutId: Long) {
        val existsByCheckoutId = orderRepository.existsByCheckoutId(checkoutId)
        if (existsByCheckoutId) {
            throw DuplicateOrderException("이미 처리된 주문입니다. checkoutId: $checkoutId")
        }
    }

    fun detail(orderId: Long): OrderDetail {
        val orderOptional = orderRepository.findById(orderId)
        if (orderOptional.isEmpty) {
            throw NotFoundOrderException("요청한 주문서($orderId) 정보를 찾을 수 없습니다.")
        }

        val order = orderOptional.get()
        val orderItemMenus = orderItemRepository.findAllByOrderId(orderId = orderId)
        val orderDiscountItems = orderDiscountItemRepository.findAllByOrderId(orderId = orderId)
        val orderDiscountItem: OrderDiscountItem? = if (orderDiscountItems.isNotEmpty()) orderDiscountItems.first() else null

        return OrderDetail(
            orderId = orderId,
            customerId = order.customerId,
            storeId = order.storeId,
            orderItems = orderItemMenus,
            orderDiscountItem = orderDiscountItem
        )
    }
}
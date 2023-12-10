package com.fastcampus.deliveryapi.service.orderhistory

import com.fastcampus.deliveryapi.domain.order.OrderHistory
import com.fastcampus.deliveryapi.domain.order.OrderStatus
import com.fastcampus.deliveryapi.exception.NotFoundOrderException
import com.fastcampus.deliveryapi.repository.order.OrderRepository
import com.fastcampus.deliveryapi.repository.orderitem.OrderItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderHistoryService(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
) {
    fun findAll(customerId: Long, orderStatus: OrderStatus): List<OrderHistory> {
        val orders = orderRepository.findAllByCustomerId(customerId, orderStatus)
        return orders.map { orderStore ->
            val orderItemMenus = orderItemRepository.findAllByOrderId(orderId = orderStore.orderId)
            val menuRepresentativeImageUrl = orderItemMenus.first().menuMainImageUrl
            val menuNames = orderItemMenus.map { it.menuName }
            OrderHistory(
                orderId = orderStore.orderId,
                orderStatus = orderStore.orderStatus,
                storeId = orderStore.storeId,
                storeName = orderStore.storeName,
                menuCount = orderItemMenus.size,
                menuNames = menuNames,
                menuRepresentativeImageUrl = menuRepresentativeImageUrl,
                totalOrderAmount = orderStore.orderTotalAmount,
            )
        }
    }

    fun findById(orderId: Long): OrderHistory {
        val orderStoreOptional = orderRepository.findByOrderId(orderId)
        if (orderStoreOptional.isEmpty) {
            throw NotFoundOrderException("주문 정보를 찾을 수 없습니다. orderId: $orderId")
        }
        val orderStore = orderStoreOptional.get()
        val orderItemMenus = orderItemRepository.findAllByOrderId(orderId = orderId)
        val menuRepresentativeImageUrl = orderItemMenus.first().menuMainImageUrl
        val menuNames = orderItemMenus.map { it.menuName }
        return OrderHistory(
            orderId = orderStore.orderId,
            orderStatus = orderStore.orderStatus,
            storeId = orderStore.storeId,
            storeName = orderStore.storeName,
            menuCount = orderItemMenus.size,
            menuNames = menuNames,
            menuRepresentativeImageUrl = menuRepresentativeImageUrl,
            totalOrderAmount = orderStore.orderTotalAmount,
        )
    }
}
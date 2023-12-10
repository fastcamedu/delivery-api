package com.fastcampus.deliveryapi.service.menu

import com.fastcampus.deliveryapi.domain.order.RecentOrderStore
import com.fastcampus.deliveryapi.repository.order.OrderRepository
import org.springframework.stereotype.Service

@Service
class FavoriteStoreService(
    private val orderRepository: OrderRepository,
) {
    fun list(customerId: Long?): List<RecentOrderStore> {
        return if (customerId == null) {
            this.orderRepository.findRecentOrderStore()
        } else {
            this.orderRepository.findRecentOrderStoreByCustomerId(customerId = customerId)
        }
    }
}
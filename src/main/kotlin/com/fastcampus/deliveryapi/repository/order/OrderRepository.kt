package com.fastcampus.deliveryapi.repository.order

import com.fastcampus.deliveryapi.domain.order.OrderStatus
import com.fastcampus.deliveryapi.domain.order.OrderStore
import com.fastcampus.deliveryapi.domain.order.RecentOrderStore
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderRepository: JpaRepository<Order, Long> {
    @Query(
        value = """
            SELECT new com.fastcampus.deliveryapi.domain.order.OrderStore(o.orderId, o.orderStatus, o.totalAmount, o.discountAmount, s.storeId, s.storeName)
            FROM Order as o
            JOIN Store as s ON o.storeId = s.storeId
            WHERE o.customerId = :customerId and o.orderStatus = :orderStatus AND o.isDeleted = false
        """
    )
    fun findAllByCustomerId(@Param("customerId") customerId: Long, @Param("orderStatus") orderStatus: OrderStatus): List<OrderStore>

    @Query(
        value = """
            SELECT new com.fastcampus.deliveryapi.domain.order.OrderStore(o.orderId, o.orderStatus, o.totalAmount, o.discountAmount, s.storeId, s.storeName)
            FROM Order as o
            JOIN Store as s ON o.storeId = s.storeId
            WHERE o.orderId = :orderId
        """
    )
    fun findByOrderId(@Param("orderId") orderId: Long): Optional<OrderStore>

    fun existsByCheckoutId(checkoutId: Long): Boolean

    @Query(
        value = """
            SELECT new com.fastcampus.deliveryapi.domain.order.RecentOrderStore(o.orderId, o.orderStatus, s.storeId, s.storeName, s.reviewGrade, s.deliveryTime, s.deliveryFee, s.storeMainImageUrl)
            FROM Order as o
            JOIN Store as s ON o.storeId = s.storeId
            WHERE o.orderStatus = 'COMPLETE' AND o.isDeleted = false
            ORDER BY o.orderId DESC
        """
    )
    fun findRecentOrderStore(): List<RecentOrderStore>

    @Query(
        value = """
            SELECT new com.fastcampus.deliveryapi.domain.order.RecentOrderStore(o.orderId, o.orderStatus, s.storeId, s.storeName, s.reviewGrade, s.deliveryTime, s.deliveryFee, s.storeMainImageUrl)
            FROM Order as o
            JOIN Store as s ON o.storeId = s.storeId
            WHERE o.customerId = :customerId and o.orderStatus = 'COMPLETE' AND o.isDeleted = false
            ORDER BY o.orderId DESC
        """
    )
    fun findRecentOrderStoreByCustomerId(@Param("customerId") customerId: Long): List<RecentOrderStore>
}
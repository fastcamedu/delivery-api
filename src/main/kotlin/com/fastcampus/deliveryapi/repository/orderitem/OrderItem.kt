package com.fastcampus.deliveryapi.repository.orderitem

import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "order_items")
class OrderItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    val orderItemId: Long = 0L,

    @Column(name = "order_id", nullable = false)
    val orderId: Long,

    @Column(name = "menu_id", nullable = false)
    val menuId: Long,

    @Column(name = "menu_price", nullable = false)
    val menuPrice: BigDecimal,

    @Column(name = "menu_quantity")
    var menuQuantity: Int,
): BaseEntity()
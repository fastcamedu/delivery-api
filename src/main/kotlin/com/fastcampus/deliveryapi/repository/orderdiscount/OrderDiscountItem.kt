package com.fastcampus.deliveryapi.repository.orderdiscount

import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "order_discount_items")
class OrderDiscountItem(
    @Id
    @GeneratedValue
    @Column(name = "order_discount_item_id")
    val checkoutDiscountItemId: Long = 0L,

    @Column(name = "order_id")
    val orderId: Long,

    @Column(name = "discount_id")
    val discountId: Long,

    @Column(name = "discount_amount")
    val discountAmount: BigDecimal

    ): BaseEntity()
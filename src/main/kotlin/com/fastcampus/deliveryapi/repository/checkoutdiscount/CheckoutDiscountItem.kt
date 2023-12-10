package com.fastcampus.deliveryapi.repository.checkoutdiscount

import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "checkout_discount_items")
class CheckoutDiscountItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkout_discount_item_id")
    val checkoutDiscountItemId: Long = 0L,

    @Column(name = "checkout_id")
    val checkoutId: Long,

    @Column(name = "discount_id")
    val discountId: Long,

): BaseEntity()
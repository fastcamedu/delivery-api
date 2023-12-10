package com.fastcampus.deliveryapi.repository.checkoutitem

import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "checkout_items", schema = "food_delivery")
class CheckoutItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkout_item_id")
    val checkoutItemId: Long = 0,

    @Column(name = "checkout_id")
    val checkoutId: Long,

    @Column(name = "menu_id")
    val menuId: Long,

    @Column(name = "menu_price")
    val menuPrice: BigDecimal,

    @Column(name = "menu_quantity")
    val menuQuantity: Int,
): BaseEntity()
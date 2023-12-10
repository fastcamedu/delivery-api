package com.fastcampus.deliveryapi.repository.cartitem

import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "cart_items")
class CartItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    val cartItemId: Long = -1,

    @Column(name = "cart_id")
    val cartId: Long,

    @Column(name = "store_id")
    val storeId: Long,

    @Column(name = "menu_id")
    val menuId: Long,

    @Column(name = "quantity")
    var quantity: Int,

): BaseEntity()
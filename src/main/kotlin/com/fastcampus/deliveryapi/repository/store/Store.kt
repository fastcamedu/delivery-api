package com.fastcampus.deliveryapi.repository.store

import com.fastcampus.deliveryapi.domain.store.StoreStatus
import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "stores", catalog = "food_delivery")
class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val storeId: Long,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "business_number", nullable = false)
    val businessNumber: String,

    @Column(name = "name", nullable = false)
    val storeName: String,

    @Column(name = "main_image_url", nullable = false)
    val storeMainImageUrl: String,

    @Column(name = "phone", nullable = false)
    val storePhone: String,

    @Column(name = "address", nullable = false)
    val address: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "bank_account", nullable = false)
    val bankAccount: String,

    @Column(name = "bank_name", nullable = false)
    val bankName: String,

    @Column(name = "description", nullable = false)
    val description: String,

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    val storeStatus: StoreStatus,

    @Column(name = "delivery_fee", nullable = false)
    val deliveryFee: BigDecimal,

    @Column(name = "delivery_time", nullable = false)
    val deliveryTime: String,

    @Column(name = "review_grade", nullable = false)
    val reviewGrade: Int,

    @Column(name = "minimum_order_price", nullable = false)
    val minimumOrderPrice: BigDecimal,
): BaseEntity()
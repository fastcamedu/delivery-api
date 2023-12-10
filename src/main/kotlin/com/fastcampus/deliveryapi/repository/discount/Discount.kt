package com.fastcampus.deliveryapi.repository.discount

import com.fastcampus.deliveryapi.domain.discount.DiscountMethod
import com.fastcampus.deliveryapi.domain.discount.DiscountType
import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime

@Entity
@Table(name = "discounts")
data class Discount(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    val discountId: Long,

    @Column(name = "discount_type")
    @Enumerated(value = EnumType.STRING)
    val discountType: DiscountType,

    @Column(name = "discount_method")
    val discountMethod: DiscountMethod,

    @Column(name = "discount_value")
    val discountValue: Int,

    @Column(name = "discount_start_date")
    val discountStartDate: OffsetDateTime,

    @Column(name = "discount_expiration_date")
    val discountExpirationDate: OffsetDateTime,

    @Column(name = "is_available")
    val isAvailable: Boolean,

): BaseEntity()

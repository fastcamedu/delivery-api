package com.fastcampus.deliveryapi.repository.category

import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "categories", schema = "food_delivery")
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    val categoryId: Long,

    @Column(name = "category_name")
    val categoryName: String,

    @Column(name = "category_main_image")
    val categoryMainImage: String,

    @Column(name = "rank")
    val rank: Int,
): BaseEntity()

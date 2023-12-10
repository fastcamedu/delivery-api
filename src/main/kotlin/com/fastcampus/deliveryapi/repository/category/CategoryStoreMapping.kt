package com.fastcampus.deliveryapi.repository.category

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "category_store_mappings", schema = "food_delivery")
class CategoryStoreMapping(
    @Id
    @Column(name = "category_store_mapping_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoryStoreMappingId: Long,

    @Column(name = "category_id", nullable = false)
    val categoryId: Long,

    @Column(name = "store_id", nullable = false)
    val storeId: Long,
)
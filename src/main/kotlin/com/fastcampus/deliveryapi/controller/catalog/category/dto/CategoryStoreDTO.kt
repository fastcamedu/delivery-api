package com.fastcampus.deliveryapi.controller.catalog.category.dto

import com.fastcampus.deliveryapi.domain.store.CategoryStore
import java.math.BigDecimal

data class CategoryStoreDTO(
    val categoryId: Long,
    val storeId: Long,
    val storeName: String,
    val mainImageUrl: String,
    val deliveryTime: String,
    val deliveryFee: BigDecimal,
    val reviewGrade: Int,
) {
    companion object {
        fun of(it: CategoryStore): CategoryStoreDTO {
            return CategoryStoreDTO(
                categoryId = it.categoryId,
                storeId = it.storeId,
                storeName = it.storeName,
                mainImageUrl = it.mainImageUrl,
                deliveryTime = it.deliveryTime,
                deliveryFee = it.deliveryFee,
                reviewGrade = it.reviewGrade,
            )
        }
    }
}
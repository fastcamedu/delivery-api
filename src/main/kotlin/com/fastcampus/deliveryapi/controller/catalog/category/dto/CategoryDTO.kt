package com.fastcampus.deliveryapi.controller.catalog.category.dto

import com.fastcampus.deliveryapi.repository.category.Category

data class CategoryDTO(
    val categoryId: Long,
    val categoryName: String,
    val rank: Int,
    val categoryMainImage: String,
) {
    companion object {
        fun of(it: Category): CategoryDTO {
            return CategoryDTO(
                categoryId = it.categoryId,
                categoryName = it.categoryName,
                categoryMainImage = it.categoryMainImage,
                rank = it.rank,
            )
        }
    }
}
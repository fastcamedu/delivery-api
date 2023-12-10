package com.fastcampus.deliveryapi.domain.store

import java.math.BigDecimal

data class CategoryStore(
    val categoryId: Long,
    val storeId: Long,
    val storeName: String,
    val mainImageUrl: String,
    val deliveryTime: String,
    val deliveryFee: BigDecimal,
    val reviewGrade: Int,
)

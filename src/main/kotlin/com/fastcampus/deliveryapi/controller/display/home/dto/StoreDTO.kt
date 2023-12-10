package com.fastcampus.deliveryapi.controller.display.home.dto

import com.fastcampus.deliveryapi.repository.store.Store
import java.math.BigDecimal

class StoreDTO(
    val storeId: Long,
    val storeName: String,
    val reviewGrade: Int,
    val deliveryTime: String,
    val deliveryFee: BigDecimal,
    val mainImageUrl: String,
) {
    companion object {
        fun of(store: Store): StoreDTO {
            return StoreDTO(
                storeId = store.storeId,
                storeName = store.storeName,
                reviewGrade = store.reviewGrade,
                deliveryTime = store.deliveryTime,
                deliveryFee = store.deliveryFee,
                mainImageUrl = store.storeMainImageUrl,
            )
        }
    }
}
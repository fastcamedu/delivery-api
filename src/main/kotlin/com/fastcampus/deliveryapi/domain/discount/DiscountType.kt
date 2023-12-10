package com.fastcampus.deliveryapi.domain.discount

enum class DiscountType(description: String) {
    COUPON("할인쿠폰"),
    DELIVERY_PROMOTION("배달비 쿠폰"),
    STORE_PROMOTION("상점 프로모션"),
}
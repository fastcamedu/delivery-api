package com.fastcampus.deliveryapi.domain.order

enum class OrderStatus(val description: String) {
    READY("대기중"),
    CANCEL("취소"),
    COMPLETE("완료")
}
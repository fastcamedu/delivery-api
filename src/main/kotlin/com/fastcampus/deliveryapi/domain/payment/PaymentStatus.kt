package com.fastcampus.deliveryapi.domain.payment

enum class PaymentStatus(description: String) {
    READY("결제 대기중"),
    COMPLETE("결제 완료"),
    CANCEL("결제 취소"),
}
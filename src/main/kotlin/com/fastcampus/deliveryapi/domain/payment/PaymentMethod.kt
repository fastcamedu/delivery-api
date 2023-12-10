package com.fastcampus.deliveryapi.domain.payment

enum class PaymentMethod(
    description: String
) {
    CREDIT_CART("신용카드"),
    DEBIT_CART("현금카드"),
    VIRTUAL_ACCOUNT("가상계좌")
}
package com.fastcampus.deliveryapi.service.cart

data class AddCartItem(
    val menuId: Long,
    val customerId: Long,
    val storeId: Long,
    val quantity: Int,
) {
}
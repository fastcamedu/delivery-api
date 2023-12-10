package com.fastcampus.deliveryapi.apibase

import org.springframework.http.HttpStatus

data class DeliveryApiExceptionResponse(
    val code: Int,
    var message: String,
    var httpStatus: HttpStatus,
)
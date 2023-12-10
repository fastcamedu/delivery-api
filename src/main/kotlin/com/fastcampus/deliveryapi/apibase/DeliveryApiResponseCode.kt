package com.fastcampus.deliveryapi.apibase

import org.springframework.http.HttpStatus

enum class DeliveryApiResponseCode(val code: Int, val httpStatus: HttpStatus) {
    OK(HttpStatus.OK.value(), HttpStatus.OK),
    TOKEN_EXPIRED(1401, HttpStatus.UNAUTHORIZED),
    NOT_UNAUTHORIZED(1402, HttpStatus.UNAUTHORIZED),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND)
}
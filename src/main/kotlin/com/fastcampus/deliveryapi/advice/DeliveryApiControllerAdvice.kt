package com.fastcampus.deliveryapi.advice

import com.fastcampus.deliveryapi.apibase.DeliveryApiExceptionResponse
import com.fastcampus.deliveryapi.apibase.DeliveryApiResponseCode
import com.fastcampus.deliveryapi.exception.DuplicateOrderException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class DeliveryApiControllerAdvice {

    @ExceptionHandler(value = [
        NullPointerException::class,
        IllegalArgumentException::class,
        DuplicateOrderException::class
    ])
    fun handleApiRequestException(ex: Exception): ResponseEntity<Any?>? {
        val apiException = ex.message?.let {
            DeliveryApiExceptionResponse(
                code = DeliveryApiResponseCode.INTERNAL_SERVER_ERROR.code,
                message = it,
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
            )
        }

        return ResponseEntity<Any?>(apiException, HttpStatus.BAD_REQUEST)
    }
}
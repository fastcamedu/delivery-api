package com.fastcampus.deliveryapi.security

import com.fastcampus.deliveryapi.apibase.DeliveryApiExceptionResponse
import com.fastcampus.deliveryapi.apibase.DeliveryApiResponseCode
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class CustomAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
): AuthenticationEntryPoint {

    companion object {
        private val logger = KotlinLogging.logger(this::class.java.name)
    }

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        logger.info { ">>> commence, ${authException?.message}" }
        val apiExceptionResponse = DeliveryApiExceptionResponse(
            code = DeliveryApiResponseCode.NOT_UNAUTHORIZED.code,
            message = "인증 오류입니다.",
            httpStatus = DeliveryApiResponseCode.NOT_UNAUTHORIZED.httpStatus
        )
        response?.writer?.write(objectMapper.writeValueAsString(apiExceptionResponse))
    }
}
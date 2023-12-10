package com.fastcampus.deliveryapi.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition(
    info = Info(
        title = "배달 서비스 API",
        description = "배달 서비스를 위한 API 목록",
        version = "0.1"
    )
)
@Configuration
class SwaggerConfig
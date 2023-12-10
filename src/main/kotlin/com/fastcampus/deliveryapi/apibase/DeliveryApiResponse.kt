package com.fastcampus.deliveryapi.apibase

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "API 응답")
abstract class DeliveryApiResponse(
    @Schema(description = "응답 코드", required = true, example = "200")
    val responseCode: Int,

    @Schema(description = "응답 메세지", required = true, example = "응답 성공")
    val responseMessage: String,
)

package com.fastcampus.deliveryapi

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "HelloController", description = "인사를 위한 Controller")
@RestController
class HelloController {

    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200",
                description = "인사 API 응답",
                content = [
                    Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ])
        ]
    )
    @Operation(method = "GET", summary = "hello API", description = "인사 API")
    @GetMapping("/hello")
    fun hello(
        @Parameter(name = "name", required = true, example = "김철수") name: String
    ): String {
        return "Hello $name !!!"
    }
}
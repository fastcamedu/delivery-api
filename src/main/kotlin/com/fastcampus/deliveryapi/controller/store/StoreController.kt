package com.fastcampus.deliveryapi.controller.store

import com.fastcampus.deliveryapi.controller.store.dto.StoreResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "StoreController", description = "음식 상점 조회 컨트롤러")
@RestController
class StoreController {

    @GetMapping("/apis/stores/{storeId}")
    fun detail(@PathVariable storeId: Long): StoreResponse {
        return StoreResponse(
            storeId = 1L,
            storeName = "",
        )
    }
}

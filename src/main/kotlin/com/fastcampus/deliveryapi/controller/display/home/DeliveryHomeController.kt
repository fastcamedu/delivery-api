package com.fastcampus.deliveryapi.controller.display.home

import com.fastcampus.deliveryapi.controller.display.home.dto.DeliveryHomeResponse
import com.fastcampus.deliveryapi.controller.display.home.dto.StoreDTO
import com.fastcampus.deliveryapi.service.menu.FavoriteStoreService
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "DeliveryHomeController", description = "배달서비스 홈 컨트롤러")
@RestController
class DeliveryHomeController(
    private val favoriteStoreService: FavoriteStoreService,
) {

    companion object {
        private val logger = KotlinLogging.logger(this::class.java.name)
    }

    @GetMapping("/apis/home/favorite-stores")
    fun index(@RequestParam customerId: Long?): DeliveryHomeResponse {
        logger.info { ">>> Home 요청" }

        val favoriteStores = favoriteStoreService.list(customerId = customerId)
        val favoriteStoreDTOS = favoriteStores.map {
            StoreDTO(
                storeId = it.storeId,
                storeName = it.storeName,
                reviewGrade = it.reviewGrade,
                deliveryTime = it.deliveryTime,
                deliveryFee = it.deliveryFee,
                mainImageUrl = it.mainImageUrl,
            )
        }

        return DeliveryHomeResponse(
            catalogs = emptyList(),
            stores = favoriteStoreDTOS,
        )
    }
}
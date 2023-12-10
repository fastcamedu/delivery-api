package com.fastcampus.deliveryapi.controller.catalog.menu

import com.fastcampus.deliveryapi.controller.catalog.menu.dto.MenuListResponse
import com.fastcampus.deliveryapi.exception.NotFoundStoreException
import com.fastcampus.deliveryapi.service.menu.MenuService
import com.fastcampus.deliveryapi.service.store.StoreService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "MenuController", description = "메뉴 컨트롤러")
@RestController
class MenuController(
    val storeService: StoreService,
    val menuService: MenuService
) {
    @GetMapping("/menus")
    fun list(@RequestParam storeId: Long): MenuListResponse {

        val storeOptional = storeService.findByStoreId(storeId)
        if (storeOptional.isEmpty) {
            throw NotFoundStoreException("상점 ${storeId}를 찾을 수 없습니다.")
        }

        return MenuListResponse(
            storeId = storeId,
            menus = emptyList()
        )
    }
}
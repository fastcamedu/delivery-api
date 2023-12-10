package com.fastcampus.deliveryapi.controller.display.mdp

import com.fastcampus.deliveryapi.controller.display.mdp.dto.MenuDetailPageResponse
import com.fastcampus.deliveryapi.domain.catalog.menu.MenuStatus
import com.fastcampus.deliveryapi.exception.MenuNotFoundException
import com.fastcampus.deliveryapi.service.menu.MenuService
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "MenuDetailPageController", description = "메뉴 상세 페이지 컨트롤러")
@RestController
class MenuDetailPageController(
    private val menuService: MenuService,
) {
    private val logger = KotlinLogging.logger {}

    @GetMapping("/apis/display/menus/{menuId}")
    fun detail(@PathVariable menuId: Long, @RequestParam storeId: Long): MenuDetailPageResponse {

        val menuOptional = menuService.findByMenuId(menuId)
        if (menuOptional.isEmpty) {
            val exceptionMessage = "요청하신 메뉴 정보를 찾을 수 없습니다. (${menuId}"
            logger.error { exceptionMessage }
            throw MenuNotFoundException(exceptionMessage)
        }

        val menu = menuOptional.get()
        return MenuDetailPageResponse(
            menuId = menuId,
            menuName = menu.menuName,
            storeId = menu.storeId,
            description = menu.description,
            menuMainImageUrl = menu.menuMainImageUrl,
            price = menu.price,
            menuStatue = MenuStatus.SALE,
        )
    }
}

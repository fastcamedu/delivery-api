package com.fastcampus.deliveryapi.controller.catalog.menu.dto

data class MenuListResponse(
    val storeId: Long,
    val menus: List<MenuDTO>
)

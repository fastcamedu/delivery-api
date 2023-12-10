package com.fastcampus.deliveryapi.controller.display.home.dto

import com.fastcampus.deliveryapi.controller.catalog.category.dto.CategoryDTO

data class DeliveryHomeResponse(
    val catalogs: List<CategoryDTO>,
    val stores: List<StoreDTO>,
)
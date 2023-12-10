package com.fastcampus.deliveryapi.controller.catalog.category

import com.fastcampus.deliveryapi.controller.catalog.category.dto.CategoryDTO
import com.fastcampus.deliveryapi.service.category.CategoryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "CategoryController", description = "메뉴 카테고리 컨트롤러")
@RestController
class CategoryController(
    private val categoryService: CategoryService,
) {
    @GetMapping("/apis/categories")
    fun list(): List<CategoryDTO> {
        val categories = categoryService.list()
        return categories.map { CategoryDTO.of(it) }
    }
}
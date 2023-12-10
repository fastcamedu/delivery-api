package com.fastcampus.deliveryapi.service.category

import com.fastcampus.deliveryapi.repository.category.Category
import com.fastcampus.deliveryapi.repository.category.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository,
) {
    fun list(): List<Category> {
        return categoryRepository.findAllAvailableCategory()
    }
}
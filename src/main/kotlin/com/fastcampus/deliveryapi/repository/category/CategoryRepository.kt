package com.fastcampus.deliveryapi.repository.category

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<Category, Long> {

    @Query(
        value = """
            SELECT c
            FROM Category c
            WHERE c.isDeleted = false 
            ORDER BY c.rank DESC
        """
    )
    fun findAllAvailableCategory(): List<Category>
}
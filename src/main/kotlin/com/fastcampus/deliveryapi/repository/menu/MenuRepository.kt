package com.fastcampus.deliveryapi.repository.menu

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MenuRepository : JpaRepository<Menu, Long> {
    @Query(
        value = """
            SELECT m
            FROM Menu as m 
            WHERE m.storeId = :storeId AND m.isDeleted = false
        """
    )
    fun findAllByStoreId(@Param("storeId") storeId: Long): List<Menu>
}
package com.fastcampus.deliveryapi.repository.discount

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
interface DiscountRepository: JpaRepository<Discount, Long> {

    @Query(
        value = """
            SELECT d
            FROM Discount d 
            WHERE d.discountStartDate < :currentDateTime AND
                    d.discountExpirationDate > :currentDateTime AND
                    d.isDeleted = false AND
                    d.isAvailable = true
        """
    )
    fun findAllAvailableDiscount(currentDateTime: OffsetDateTime): List<Discount>
    fun findAllByDiscountIdIn(discountIds: List<Long>): List<Discount>
}
package com.fastcampus.deliveryapi.repository.customer

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository: JpaRepository<Customer, Long> {
    fun findByEmail(email: String): Optional<Customer>
}
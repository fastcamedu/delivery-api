package com.fastcampus.deliveryapi.service.customer

import com.fastcampus.deliveryapi.domain.customer.CustomerDetails
import com.fastcampus.deliveryapi.repository.customer.CustomerRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomerDetailsService(
    private val customerRepository: CustomerRepository
) {
    fun loadUserByUsername(email: String): CustomerDetails {
        val customerOptional = customerRepository.findByEmail(email)
        if (customerOptional.isEmpty) {
            throw UsernameNotFoundException("Not found $email")
        }
        val customer = customerOptional.get()
        return CustomerDetails(
            customerId = customer.customerId,
            email = customer.email,
            password = customer.password,
            role = customer.customerRole,
        )
    }
}
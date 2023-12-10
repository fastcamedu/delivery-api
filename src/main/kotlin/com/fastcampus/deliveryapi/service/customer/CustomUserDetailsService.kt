package com.fastcampus.deliveryapi.service.customer

import com.fastcampus.deliveryapi.repository.customer.CustomerRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val customerRepository: CustomerRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val customerOptional = customerRepository.findByEmail(email)
        if (customerOptional.isEmpty) {
            throw UsernameNotFoundException("고객 정보를 찾을 수 없습니다.")
        }
        val customer = customerOptional.get()
        return User.builder()
            .username(customer.email)
            .password(customer.password)
            .roles(customer.customerRole.name)
            .build()
    }
}
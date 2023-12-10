package com.fastcampus.deliveryapi.service.customer.signup

import com.fastcampus.deliveryapi.domain.customer.CustomerSignup
import com.fastcampus.deliveryapi.exception.AlreadySignupCustomerException
import com.fastcampus.deliveryapi.repository.customer.Customer
import com.fastcampus.deliveryapi.repository.customer.CustomerRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class CustomerSignupService(
    val customerRepository: CustomerRepository
) {
    @Value("\${server.role-name}")
    private lateinit var roleName: String

    fun signup(customerSignup: CustomerSignup): Customer {
        val customerOptional = customerRepository.findByEmail(customerSignup.email)
        if (customerOptional.isPresent) {
            throw AlreadySignupCustomerException("이미 가입된 회원입니다. ${customerSignup.email}")
        }

        val customer = Customer(
            name = customerSignup.name,
            email = customerSignup.email,
            password = customerSignup.password,
            address = customerSignup.address,
            phone = customerSignup.phone,
        )
        customer.createdBy = roleName
        customer.updatedBy = roleName
        return customerRepository.save(customer)
    }
}
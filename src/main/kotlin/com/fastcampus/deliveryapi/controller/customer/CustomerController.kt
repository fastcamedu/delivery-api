package com.fastcampus.deliveryapi.controller.customer

import com.fastcampus.deliveryapi.controller.customer.dto.CustomerDetailResponse
import com.fastcampus.deliveryapi.controller.customer.dto.CustomerUpdateRequest
import com.fastcampus.deliveryapi.controller.customer.dto.CustomerUpdateResponse
import com.fastcampus.deliveryapi.exception.NotFoundCustomerException
import com.fastcampus.deliveryapi.service.customer.CustomerService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "CustomerController", description = "고객 정보 컨트롤러")
@RestController
class CustomerController(
    private val customerService: CustomerService,
) {

    @GetMapping("/apis/customers/{customerId}")
    fun detail(@PathVariable customerId: Long): CustomerDetailResponse {
        val customerOptional = customerService.findByCustomerId(customerId)
        if (customerOptional.isEmpty) {
            throw NotFoundCustomerException("Not found customer, $customerId")
        }
        val customer = customerOptional.get()
        return CustomerDetailResponse(
            customerId = customer.customerId,
            customerName = customer.name,
            phone = customer.phone,
            address = customer.address,
            email = customer.email,
        )
    }

    @PostMapping("/customers/{customerId}")
    fun update(
        @PathVariable customerId: Long,
        customerUpdateRequest: CustomerUpdateRequest
    ): CustomerUpdateResponse {
        return CustomerUpdateResponse(
            customerId = 1L,
            customerName = "",
            phone = "",
            address = "",
        )
    }
}
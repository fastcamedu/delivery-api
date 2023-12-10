package com.fastcampus.deliveryapi.controller.customer

import com.fastcampus.deliveryapi.controller.customer.dto.CustomerSignupRequest
import com.fastcampus.deliveryapi.controller.customer.dto.CustomerSignupResponse
import com.fastcampus.deliveryapi.domain.customer.CustomerSignup
import com.fastcampus.deliveryapi.service.customer.signup.CustomerSignupService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Tag(name = "CustomerSignupController", description = "음식 배달 서비스 가입 컨트롤러")
@RestController
class CustomerSignupController(
    val customerSignupService: CustomerSignupService,
    val passwordEncoder: PasswordEncoder,
) {

    @PostMapping(value = ["/apis/customer/signup"])
    @Operation(
        summary = "회원 가입", description = "회원가입 API"
    )
    fun signup(@RequestBody customerSignupRequest: CustomerSignupRequest): CustomerSignupResponse {
        val customerSignup = CustomerSignup(
            email = customerSignupRequest.email,
            phone = customerSignupRequest.phone,
            password = passwordEncoder.encode(customerSignupRequest.password),
            name = customerSignupRequest.name,
            address = customerSignupRequest.address,
        )
        val customer = customerSignupService.signup(customerSignup = customerSignup)
        return CustomerSignupResponse(customerId = customer.customerId)
    }
}
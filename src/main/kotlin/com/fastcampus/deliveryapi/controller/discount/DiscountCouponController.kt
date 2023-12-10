package com.fastcampus.deliveryapi.controller.discount

import com.fastcampus.deliveryapi.repository.discount.Discount
import com.fastcampus.deliveryapi.service.discount.DiscountService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@Tag(name = "할인 정보를 조회하는 API", description = "다양한 할인 쿠폰 종료를 조회하는 API")
@RestController
class DiscountCouponController(
    val discountService: DiscountService,
) {
    @GetMapping("/discounts/customer-id/{customerId}")
    fun list(@PathVariable customerId: Long): List<Discount> {
        val now = OffsetDateTime.now()
        return this.discountService.findAvailableDiscount(now)
    }
}
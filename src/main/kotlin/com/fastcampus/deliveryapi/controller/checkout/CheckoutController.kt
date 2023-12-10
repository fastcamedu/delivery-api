package com.fastcampus.deliveryapi.controller.checkout

import com.fastcampus.deliveryapi.controller.checkout.dto.CheckoutItemDTO
import com.fastcampus.deliveryapi.controller.checkout.dto.CheckoutItemResponse
import com.fastcampus.deliveryapi.controller.checkout.dto.CheckoutRequest
import com.fastcampus.deliveryapi.controller.checkout.dto.CheckoutResponse
import com.fastcampus.deliveryapi.exception.NotFoundCheckoutException
import com.fastcampus.deliveryapi.service.CartItemService
import com.fastcampus.deliveryapi.service.cart.CartService
import com.fastcampus.deliveryapi.service.checkout.CheckoutItemService
import com.fastcampus.deliveryapi.service.checkout.CheckoutService
import com.fastcampus.deliveryapi.service.discount.DiscountService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@Tag(name = "주문을 위한 체크아웃 API", description = "결제를 위한 체크아웃 API")
@RestController
class CheckoutController(
    private val cartService: CartService,
    private val cartItemService: CartItemService,
    private val checkoutService: CheckoutService,
    private val checkoutItemService: CheckoutItemService,
    private val discountService: DiscountService,
) {
    @Operation(
        summary = "체크아웃 생성 API", description = "고객이 결제할 메뉴와 각종 할인 정보를 처리하는 체크아웃 API"
    )
    @PostMapping("/apis/checkouts")
    fun createCheckout(
        @RequestBody checkoutRequest: CheckoutRequest
    ): ResponseEntity<CheckoutResponse> {
        val cart = cartService.findByCustomerId(checkoutRequest.customerId)
        val cartMenus = cartItemService.findAllByCartId(cart.cartId)
        val checkout = checkoutService.create(checkoutRequest.customerId, checkoutRequest.discountId, cartMenus)
        return ResponseEntity.ok(
            CheckoutResponse(
                customerId = checkoutRequest.customerId,
                checkoutId = checkout.checkoutId,
            )
        )
    }

    @Operation(
        summary = "체크아웃 조회 API", description = "고객이 결제할 최종 정보 확인"
    )
    @GetMapping("/apis/checkouts")
    fun checkout(
        @RequestParam customerId: Long
    ): CheckoutItemResponse {
        val checkoutOptional = checkoutService.findByCustomerId(customerId)
        if (checkoutOptional.isEmpty) {
            throw NotFoundCheckoutException("Not found checkout, customerId = $customerId")
        }
        val checkout = checkoutOptional.get()
        val checkoutItems = checkoutItemService.findByCheckoutId(checkout.checkoutId)
        val checkoutItemDTOS = checkoutItems.map {
            CheckoutItemDTO(
                checkoutId = it.checkoutId,
                checkoutItemId = it.checkoutItemId,
                menuId = it.menuId,
                menuPrice = it.menuPrice,
                menuQuantity = it.menuQuantity,
            )
        }

        // 메뉴가격
        val menuPrices = checkoutItemDTOS.map { it.menuPrice.multiply(BigDecimal(it.menuQuantity)) }
        val menuPriceSum = menuPrices.sumOf { it }

        // 할인정보
        val discount = discountService.findDiscountBy(checkout.checkoutId)
        val discountValue = discount?.discountValue?.let { BigDecimal(it) } ?: BigDecimal(0)

        // 총결제금액
        val totalAmountForPayment = menuPriceSum.minus(discountValue)

        return CheckoutItemResponse(
            customerId = customerId,
            checkoutId = checkout.checkoutId,
            checkoutItems = checkoutItemDTOS,
            totalAmount = totalAmountForPayment,
        )
    }
}
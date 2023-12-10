package com.fastcampus.deliveryapi.controller.cart

import com.fastcampus.deliveryapi.controller.cart.dto.CartItemAddRequest
import com.fastcampus.deliveryapi.controller.cart.dto.CartItemAddResponse
import com.fastcampus.deliveryapi.controller.cart.dto.CartItemRemoveRequest
import com.fastcampus.deliveryapi.controller.cart.dto.CartItemRemoveResponse
import com.fastcampus.deliveryapi.controller.cart.dto.CartMenuDTO
import com.fastcampus.deliveryapi.controller.cart.dto.CartQueryRequest
import com.fastcampus.deliveryapi.controller.cart.dto.CartQueryResponse
import com.fastcampus.deliveryapi.service.CartItemService
import com.fastcampus.deliveryapi.service.cart.AddCartItem
import com.fastcampus.deliveryapi.service.cart.CartService
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["http://localhost:8080"], maxAge = 3600)
@Tag(name = "CartController", description = "장바구니 컨트롤러")
@RestController
class CartController(
    private val cartService: CartService,
    private val cartItemService: CartItemService,
) {
    companion object {
        private val logger = KotlinLogging.logger(this::class.java.name)
    }

    @GetMapping("/apis/carts/items")
    @Operation(
        summary = "장바구니 목록 요청",
        description = "현재 장바구니에 담긴 음식 메뉴 목록을 조회한다.",
        responses = [ApiResponse(
            responseCode = "200",
            description = "장바구니 요청에 대한 응답",
            useReturnTypeSchema = true,
        )]
    )
    fun list(
        @Parameter(
            schema = Schema(implementation = CartQueryRequest::class),
            name = "cartQueryRequest", description = "장바구니 조회 요청", required = true, `in` = ParameterIn.QUERY)
        cartQueryRequest: CartQueryRequest,
    ): ResponseEntity<CartQueryResponse> {

        logger.info { ">>> 장바구니 조회 요청" }
        val cart = cartService.findByCustomerId(cartQueryRequest.customerId)
        val cartMenus = cartItemService.findAllByCartId(cart.cartId)
        val cartMenuDTOs = cartMenus.map { CartMenuDTO.from(it) }

        return ResponseEntity.ok(
            CartQueryResponse(
                customerId = cartQueryRequest.customerId,
                cartItems = cartMenuDTOs,
            )
        )
    }

    @PostMapping("/apis/carts/items")
    @Operation(
        summary = "장바구니에 메뉴 추가",
        description = "현재 장바구니에 음식 메뉴 등록한다.",
        responses = [ApiResponse(
            responseCode = "200",
            description = "장바구니 추가 결과에 대한 응답",
            useReturnTypeSchema = true,
        )]
    )
    fun add(
        @Parameter(
            schema = Schema(implementation = CartItemAddRequest::class),
            name = "cartItemAddRequest", description = "장바구니 등록 요청", required = true)
        @RequestBody cartItemAddRequest: CartItemAddRequest): ResponseEntity<CartItemAddResponse> {

        val addCartItem = AddCartItem(
            menuId = cartItemAddRequest.menuId,
            customerId = cartItemAddRequest.customerId,
            storeId = cartItemAddRequest.storeId,
            quantity = cartItemAddRequest.quantity,
        )
        cartService.upsert(addCartItem)

        return ResponseEntity.ok(
            CartItemAddResponse(
                storeId = cartItemAddRequest.storeId,
                menuId = cartItemAddRequest.menuId,
                quantity = cartItemAddRequest.quantity,
            )
        )
    }


    @Operation(
        summary = "장바구니의 아이템 제거",
        description = "현재 장바구니에 담긴 음식 메뉴 아이템을 제거한다.",
        responses = [ApiResponse(
            content = [Content(
                mediaType = MediaType.APPLICATION_JSON_VALUE,
            )],
            useReturnTypeSchema = true,
        )]
    )
    @PutMapping("/apis/carts/cart-items")
    fun remove(
        @Parameter(
            schema = Schema(implementation = CartItemRemoveRequest::class),
            name = "cartItemRemoveRequest", description = "장바구니에서 아이템 제거", required = true)
        @RequestBody request: CartItemRemoveRequest): ResponseEntity<CartItemRemoveResponse> {

        cartService.remove(customerId = request.customerId, cartItemId = request.cartItemId)

        return ResponseEntity.ok(
            CartItemRemoveResponse(
                cartItemId = request.cartItemId,
                customerId = request.customerId,
            )
        )
    }
}
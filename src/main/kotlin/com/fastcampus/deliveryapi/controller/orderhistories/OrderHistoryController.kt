package com.fastcampus.deliveryapi.controller.orderhistories

import com.fastcampus.deliveryapi.controller.orderhistories.dto.OrderHistoryDTO
import com.fastcampus.deliveryapi.controller.orderhistories.dto.OrderHistoryRequest
import com.fastcampus.deliveryapi.controller.orderhistories.dto.OrderHistoryResponse
import com.fastcampus.deliveryapi.service.orderhistory.OrderHistoryService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderHistoryController(
    private val orderHistoryService: OrderHistoryService,
) {
    companion object {
        private val logger = KotlinLogging.logger(this::class.java.name)
    }

    @GetMapping("/apis/order-histories")
    fun list(@ModelAttribute orderHistoryRequest: OrderHistoryRequest): ResponseEntity<OrderHistoryResponse> {
        logger.info { ">>> 주문 이력 조회, $orderHistoryRequest" }
        val orderDetails = orderHistoryService.findAll(orderHistoryRequest.customerId, orderHistoryRequest.orderStatus)
        val orderHistoryDTOs = orderDetails.map { OrderHistoryDTO.from(it) }
        val orderHistoryResponse = OrderHistoryResponse(
            orderHistories = orderHistoryDTOs
        )
        return ResponseEntity.ok(orderHistoryResponse)
    }

    @GetMapping("/apis/order-histories/{orderId}")
    fun detail(
        @PathVariable orderId: Long,
    ): ResponseEntity<OrderHistoryDTO> {
        val orderHistory = orderHistoryService.findById(orderId = orderId)
        val orderHistoryDTO = OrderHistoryDTO.from(orderHistory = orderHistory)
        return ResponseEntity.ok(orderHistoryDTO)
    }
}
package com.fastcampus.deliveryapi.external.pg

import com.fastcampus.deliveryapi.external.pg.dto.PgPayRequest
import com.fastcampus.deliveryapi.external.pg.dto.PgPayResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class PgAdapter {
    fun pay(pgPayRequest: PgPayRequest): PgPayResponse {
        return PgPayResponse(
            payAmount = pgPayRequest.payAmount,
            pgPaymentId = UUID.randomUUID().toString(),
            customerId = pgPayRequest.customerId,
        )
    }
}
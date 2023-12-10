package com.fastcampus.deliveryapi.controller.wallet.deliverypartner.dto

import java.math.BigDecimal

data class DeliveryPartnerDepositRequest(
    val deliveryPartnerId: Long,
    val deliveryPartnerWalletId: Long,
    val amount: BigDecimal,
)

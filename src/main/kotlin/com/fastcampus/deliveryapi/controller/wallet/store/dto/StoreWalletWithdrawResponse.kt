package com.fastcampus.deliveryapi.controller.wallet.store.dto

import java.math.BigDecimal

data class StoreWalletWithdrawResponse(
    val storeId: Long,
    val storeWalletId: Long,
    val amount: BigDecimal,
)
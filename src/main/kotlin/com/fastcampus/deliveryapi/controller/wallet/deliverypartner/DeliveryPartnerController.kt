package com.fastcampus.deliveryapi.controller.wallet.deliverypartner

import com.fastcampus.deliveryapi.controller.wallet.deliverypartner.dto.DeliveryPartnerDepositRequest
import com.fastcampus.deliveryapi.controller.wallet.deliverypartner.dto.DeliveryPartnerDepositResponse
import com.fastcampus.deliveryapi.controller.wallet.deliverypartner.dto.DeliveryPartnerWithdrawRequest
import com.fastcampus.deliveryapi.controller.wallet.deliverypartner.dto.DeliveryPartnerWithdrawResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@Tag(name = "DeliveryPartnerController", description = "배달파트너 지갑 컨트롤러")
@RestController
class DeliveryPartnerController {

    @PostMapping("/wallets/deliverypartners/{deliveryPartner}/deposit")
    fun deposit(
        @PathVariable deliveryPartner: Long,
        depositRequest: DeliveryPartnerDepositRequest
    ): DeliveryPartnerDepositResponse {
        return DeliveryPartnerDepositResponse(
            deliveryPartnerId = depositRequest.deliveryPartnerId,
            deliveryPartnerWalletId = depositRequest.deliveryPartnerWalletId,
            amount = depositRequest.amount,
        )
    }

    @PostMapping("/wallets/deliverypartners/{deliveryPartner}/withdraw")
    fun withdraw(
        @PathVariable deliveryPartnerId: Long,
        withdrawRequest: DeliveryPartnerWithdrawRequest,
    ): DeliveryPartnerWithdrawResponse {
        return DeliveryPartnerWithdrawResponse(
            withdrawRequest.deliveryPartnerId,
            withdrawRequest.deliveryPartnerWalletId,
            withdrawRequest.amount,
        )
    }
}
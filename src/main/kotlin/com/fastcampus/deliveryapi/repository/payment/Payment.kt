package com.fastcampus.deliveryapi.repository.payment

import com.fastcampus.deliveryapi.domain.payment.PaymentMethod
import com.fastcampus.deliveryapi.domain.payment.PaymentStatus
import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Entity
@Table(name = "payments")
class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    val paymentId: Long = 0L,

    @Column(name = "payment_method")
    @Enumerated(value = EnumType.STRING)
    val paymentMethod: PaymentMethod,

    @Column(name = "pg_id")
    val pgId: Long,

    @Column(name = "pg_payment_id")
    val pgPaymentId: String,

    @Column(name = "pay_amount")
    val payAmount: BigDecimal,

    @Column(name = "payment_status")
    @Enumerated(value = EnumType.STRING)
    val paymentStatus: PaymentStatus,

    @Column(name = "order_id")
    val orderId: Long,

    @Column(name = "customer_id")
    val customerId: Long,

    @Column(name = "store_id")
    val storeId: Long,
): BaseEntity()
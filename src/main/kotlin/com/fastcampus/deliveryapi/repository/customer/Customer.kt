package com.fastcampus.deliveryapi.repository.customer

import com.fastcampus.deliveryapi.domain.customer.CustomerRole
import com.fastcampus.deliveryapi.domain.customer.CustomerStatus
import com.fastcampus.deliveryapi.repository.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "customers", schema = "food_delivery")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    val customerId: Long = 0L,

    @Column(name = "name")
    val name: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "phone")
    val phone: String,

    @Column(name = "address")
    val address: String,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    val customerStatus: CustomerStatus = CustomerStatus.ACTIVE,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    val customerRole: CustomerRole = CustomerRole.CUSTOMER

): BaseEntity()

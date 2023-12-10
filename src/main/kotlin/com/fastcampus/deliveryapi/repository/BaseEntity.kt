package com.fastcampus.deliveryapi.repository

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.time.OffsetDateTime

@MappedSuperclass
abstract class BaseEntity {
    @Column(name = "is_deleted", nullable = false)
    var isDeleted: Boolean = false

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    var createdAt: OffsetDateTime = OffsetDateTime.now()

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    var updatedAt: OffsetDateTime = OffsetDateTime.now()

    @Column(name = "created_by", nullable = false)
    var createdBy: String? = null

    @Column(name = "updated_by", nullable = false)
    var updatedBy: String? = null
}
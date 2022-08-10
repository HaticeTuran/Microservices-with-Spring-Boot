package com.example.banner.bannerManagement

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID

@Table("banner")
data class Banner(@Id @Column("banner_id") val bannerId: UUID?,
                  @Column("banner_url") val bannerUrl: String,
                  @Column("created_date") @CreatedDate val createdDate: LocalDateTime)


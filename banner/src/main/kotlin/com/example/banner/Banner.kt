package com.example.banner

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalTime
import java.util.UUID

@Table("banners")
data class Banner(@Id @Column("banner_id") val bannerId: UUID?,
                  @Column("banner_url") val bannerUrl: String,
                  @Column("created_date") @CreatedDate val createdDate: LocalTime?)


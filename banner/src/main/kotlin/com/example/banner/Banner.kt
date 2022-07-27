package com.example.banner

import org.springframework.data.relational.core.mapping.Table
import java.time.LocalTime
import java.util.UUID

@Table("banners")
data class Banner(val bannerId: UUID,
                  val bannerUrl: String,
                  val createdDate: LocalTime)


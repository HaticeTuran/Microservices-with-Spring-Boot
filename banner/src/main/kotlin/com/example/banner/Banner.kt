package com.example.banner

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalTime
import java.util.UUID

@Table("banners")
data class Banner(@Id val bannerId: UUID,
                  @Column("bannerUrl")val bannerUrl: String,
                  @Column("createdDate") @CreatedDate val createdDate: LocalTime)




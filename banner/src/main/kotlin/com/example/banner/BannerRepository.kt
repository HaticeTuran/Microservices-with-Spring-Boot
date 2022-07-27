package com.example.banner

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

interface BannerRepository: ReactiveCrudRepository<Banner,UUID>{
    @Query("SELECT * FROM banners")
    fun findBanners(): Flux<Banner>

    @Query("SELECT FROM BANNERS b WHERE  b.bannerId = bannerId")
    fun findBannerByBannerId(bannerId: UUID): Mono<Banner>

}
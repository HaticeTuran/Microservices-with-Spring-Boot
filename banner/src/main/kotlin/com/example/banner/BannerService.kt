package com.example.banner

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@Service
class BannerService(val repository: BannerRepository) {
    fun findsBanners():Flux<Banner>{
        return repository.findBanners();
    }

    fun findBannerById(id: UUID): Mono<Banner> {
        return repository.findBannerByBannerId(id)
    }

    fun saveBanner(banner: Banner){
        repository.save(banner)
    }
}
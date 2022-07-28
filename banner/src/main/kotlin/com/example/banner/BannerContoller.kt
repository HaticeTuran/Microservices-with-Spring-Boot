package com.example.banner

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@RestController
@RequestMapping("/banner")
class BannerContoller (val service: BannerService){
    @GetMapping
    fun findBanners(): Flux<Banner> {
        return service.findsBanners()
    }

    @GetMapping
    fun findBannerByBannerId(id: UUID): Mono<Banner>{
        return service.findBannerById(id)
    }

    @PostMapping
    fun saveBanner(banner: Banner){
        service.saveBanner(banner)
    }
}
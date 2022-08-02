package com.example.banner

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/banner")
class BannerController (val service: BannerService){

    // Get Methods
    @GetMapping()
    suspend fun findBanners(): Flow<Banner> {
        return service.findsBanners()
    }

    @GetMapping("/{id}")
    suspend fun findBannerByBannerId(@PathVariable("id") id: UUID): Banner?{
        return service.findBannerById(id)
    }

    //Post Methods
    @PostMapping()
    suspend fun saveBanner(@RequestBody() banner: Banner){
        service.saveBanner(banner)
    }

    // Delete Methods
    @DeleteMapping("/{id}")
    suspend fun deleteBannerById(@PathVariable("id") id: UUID){
        service.deleteBannerById(id)
    }

}
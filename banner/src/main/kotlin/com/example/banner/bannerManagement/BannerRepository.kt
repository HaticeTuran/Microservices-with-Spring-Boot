package com.example.banner.bannerManagement

import com.example.banner.bannerManagement.Banner
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID


interface BannerRepository: CoroutineCrudRepository<Banner,UUID>{
    //TODO
}
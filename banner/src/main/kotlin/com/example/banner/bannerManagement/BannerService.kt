package com.example.banner.bannerManagement

import com.example.banner.bannerManagement.Banner
import com.example.banner.bannerManagement.BannerRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BannerService(val repository: BannerRepository) {

    suspend fun findsBanners():Flow<Banner>{
        return repository.findAll();
    }

    suspend fun findBannerById(id: UUID): Banner? {
        return repository.findById(id)
    }

    suspend fun saveBanner(banner: Banner){
        repository.save(banner)
    }

    suspend fun deleteBannerById(id: UUID){
        repository.deleteById(id)
    }
}
package com.example.banner

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
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
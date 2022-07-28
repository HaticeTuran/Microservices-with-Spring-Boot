package com.example.banner

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID


interface BannerRepository: CoroutineCrudRepository<Banner,UUID>{

    @Query("SELECT * FROM banners")
    suspend fun findBanners(): Flow<Banner>

    //suspend fun findBannerByBannerId(bannerId: UUID)

    //@Query("SELECT FROM BANNERS b WHERE  b.bannerId = bannerId")
    suspend fun findBannerByBannerId(bannerId: UUID): Banner?

}
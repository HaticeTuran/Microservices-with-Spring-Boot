package com.example.banner.service

import com.example.banner.bannerManagement.Banner
import com.example.banner.bannerManagement.BannerRepository
import com.example.banner.bannerManagement.BannerService
import io.mockk.coEvery
import org.junit.jupiter.api.Test
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.UUID

class BannerServiceTest {

    val bannerRepository = mockk<BannerRepository>()
    val bannerService = BannerService(bannerRepository)

    @Test
    fun `when BannerService findBannerById called it should return Banner`(){
        //TODO
        //Given
        val bannerId =UUID.randomUUID()
        val expected = Banner(bannerId,bannerUrl = "hello",createdDate = null)

        //When
        val actual: Banner? = bannerService.findBannerById(bannerId)
        coEvery { bannerRepository.findById(bannerId)} returns expected

        //Then
        assertEquals(expected,actual)
    }

}
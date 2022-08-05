package com.example.banner.service

import com.example.banner.bannerManagement.Banner
import com.example.banner.bannerManagement.BannerRepository
import com.example.banner.bannerManagement.BannerService
import io.mockk.coEvery
import org.junit.jupiter.api.Test
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import java.util.UUID

class BannerServiceTest {

    private val bannerRepository = mockk<BannerRepository>()
    private val bannerService = BannerService(bannerRepository)

    @Test
    fun `when BannerService findBannerById called it should return Banner`()= runBlocking{
        //Given
        val bannerId =UUID.randomUUID()
        val expected = Banner(bannerId,bannerUrl = "hello",createdDate = null)
        coEvery { bannerRepository.findById(bannerId)} returns expected

        //When
        val actual: Banner? = bannerService.findBannerById(bannerId)

        //Then
        assertEquals(expected,actual)
    }

}
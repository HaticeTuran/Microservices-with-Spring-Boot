package com.example.banner.bannerServiceTest

import com.example.banner.bannerManagement.Banner
import com.example.banner.bannerManagement.BannerRepository
import com.example.banner.bannerManagement.BannerService
import com.example.banner.exception.NotFoundException
import io.mockk.coEvery
import org.junit.jupiter.api.Test
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime
import java.util.UUID

class BannerServiceTest {

    private val bannerRepository = mockk<BannerRepository>()
    private val bannerService = BannerService(bannerRepository)

    @Test
    fun `when BannerService findBannerById called it should return Banner`()= runBlocking{
        //Given
        val bannerId =UUID.randomUUID()
        val expected = Banner(bannerId,bannerUrl = "hello",createdDate = LocalDateTime.now())
        coEvery { bannerRepository.findById(bannerId)} returns expected

        //When
        val actual: Banner? = bannerService.findBannerById(bannerId)

        //Then
        assertEquals(expected,actual)
    }

    @Test
    fun `when BannerService findBannerById called with unknown id it should throw Exception`(): Unit = runBlocking{
        //Given
        val bannerId = UUID.randomUUID()
        coEvery { bannerService.findBannerById(bannerId) } returns null

        //When-Then
        assertThrows<NotFoundException> {
            bannerService.findBannerById(bannerId)
        }
    }

}
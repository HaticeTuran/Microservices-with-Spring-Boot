package com.example.banner

import com.example.banner.bannerManagement.Banner
import com.example.banner.bannerManagement.BannerRepository
import io.r2dbc.spi.ConnectionFactory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.platform.commons.logging.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator
import org.testcontainers.containers.JdbcDatabaseContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.*

fun postgres(imageName: String, opts: JdbcDatabaseContainer<Nothing>.() -> Unit ) =
        PostgreSQLContainer<Nothing>(DockerImageName.parse(imageName)).apply(opts)

@DataR2dbcTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Testcontainers
class BannerIntegrationTests {

    //private val logger = LoggerFactory.getLogger(this::javaClass)
    private lateinit var banner : Banner

    @Container
    val container = postgres("postgres:13-alpine") {
        withDatabaseName("db")
        withUsername("postgres")
        withPassword("123admin")
    }

    @Autowired
    private lateinit var bannerRepository: BannerRepository


    @TestConfiguration
    internal class TestConfig {
        @Bean
        fun initializer(connectionFactory: ConnectionFactory): ConnectionFactoryInitializer {
            val initializer = ConnectionFactoryInitializer()
            initializer.setConnectionFactory(connectionFactory)
            val populator = CompositeDatabasePopulator()
            populator.addPopulators(ResourceDatabasePopulator(ClassPathResource("sql/init.sql")))
            initializer.setDatabasePopulator(populator)
            return initializer
        }
    }

    @AfterEach
    fun deleteAll() = runBlocking {
        bannerRepository.deleteAll()
    }
    @BeforeEach
    fun initVal()= runBlocking {
        val date = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS)
        banner = bannerRepository.save(Banner(null,"url",date))
    }


    @Test
    fun isDatabaseRunning() = runBlocking{
        Assertions.assertTrue(container.isRunning)
    }

    @Test
    fun `when a banner was inserted in db, db should return exactly this banner`() = runBlocking{

        val actual = bannerRepository.save(Banner(null,"skfhjs", LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS)))
        val expected = bannerRepository.findById(actual.bannerId!!)
        Assertions.assertEquals(expected,actual)
    }

    @Test
    fun `is size of db one`(){
        val banners = bannerRepository.findAll()
        //TODO
    }
}
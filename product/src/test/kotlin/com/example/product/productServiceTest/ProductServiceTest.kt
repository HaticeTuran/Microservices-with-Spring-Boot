package com.example.product.productServiceTest

import com.example.product.productManagement.Product
import com.example.product.productManagement.ProductRepository
import com.example.product.productManagement.ProductService
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class ProductServiceTest {

    private val productRepository = mockk<ProductRepository>()
    private val productService = ProductService(productRepository)

    @Test
    fun `when ProductService findById called it should return a product`() = runBlocking{
        //Given
        val productId = UUID.randomUUID()
        val expected = Product(productId,"mobile_phone",10000,1230,"Iphone 13 pro MAX",null )
        coEvery { productService.findProductById(productId) } returns expected
        //When
        val actual = productService.findProductById(productId)
        //Then
        assertEquals(expected, actual)
    }
}
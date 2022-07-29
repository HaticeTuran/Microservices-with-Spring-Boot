package com.example.product

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository: CoroutineCrudRepository<Product, UUID> {


    @Query("SELECT FROM products P WHERE P.productId = productId")
    suspend fun findProductByProductId(productId: UUID): Product?

    @Query("select * from products")
    suspend fun findProducts(): Flow<Product>


}
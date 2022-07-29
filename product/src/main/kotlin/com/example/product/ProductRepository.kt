package com.example.product

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.UUID

@Repository
interface ProductRepository: ReactiveCrudRepository<Product,Int> {


    @Query("SELECT * FROM product P WHERE P.productId = productId")
    suspend fun findByProductById(productId: UUID): Product

    @Query("select * from product")
    suspend fun findProducts(): Flow<Product>


}
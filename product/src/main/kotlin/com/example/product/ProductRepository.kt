package com.example.product

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ProductRepository: ReactiveCrudRepository<Product,Int> {

    @Query("SELECT * FROM product P WHERE P.productId = productId")
    fun findByProductId(productId: Int): Product

    @Query("select * from product")
    fun findProducts(): Flux<Product>

}
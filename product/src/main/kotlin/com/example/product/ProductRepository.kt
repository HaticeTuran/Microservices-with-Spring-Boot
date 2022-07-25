package com.example.product

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: CrudRepository<Product,Int> {

    @Query("SELECT * FROM product P WHERE P.productId = productId")
    fun findByProductId(productId: Int): Product

    @Query("select * from product")
    fun findProducts(): List<Product>

}
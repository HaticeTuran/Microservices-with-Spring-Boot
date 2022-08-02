package com.example.product.productManagement

import com.example.product.productManagement.Product
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository: CoroutineCrudRepository<Product, UUID> {
    //TO DO
}
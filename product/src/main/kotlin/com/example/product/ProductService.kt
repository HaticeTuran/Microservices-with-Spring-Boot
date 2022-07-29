package com.example.product

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Flux
import java.util.UUID

@Service
class ProductService(val repository: ProductRepository) {

    // find all products
    suspend fun findProducts(): Flow<Product> {
        return repository.findProducts()
    }

    // find a specific product
    suspend fun findProductById(id: UUID):Product?{
        return repository.findProductByProductId(id)
    }

    // save product
    suspend fun saveProduct( @RequestBody product: Product){
        repository.save(product)
    }

}
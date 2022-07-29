package com.example.product

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Flux
import java.util.UUID

@Service
class ProductService(val repository: ProductRepository) {

    suspend fun findProducts(): Flow<Product> {
        return repository.findProducts()
    }

    suspend fun findProductById(id: UUID):Product?{
        return repository.findByProductById(id)
    }

    suspend fun save( @RequestBody product: Product){
        repository.save(product)
    }

}
package com.example.product

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Flux

@Service
class ProductService(val repository: ProductRepository) {

    fun findProducts(): Flux<Product> {
        return repository.findProducts()
    }

    fun save( @RequestBody product: Product){
        repository.save(product)
    }

}
package com.example.product

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@Service
@RestController
@RequestMapping("/product")
class ProductController (val repository: ProductRepository){

    @GetMapping
    fun findProducts(): Flux<Product> {
        return repository.findProducts()
    }

    @PostMapping
    fun save(product: Product){
        repository.save(product)
    }
}
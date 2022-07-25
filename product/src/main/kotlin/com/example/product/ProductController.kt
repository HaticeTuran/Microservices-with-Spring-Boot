package com.example.product

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController (val repository: ProductRepository){
    @GetMapping
    fun findProducts(): List<Product>{
        return repository.findProducts()
    }

    @PostMapping("/product")
    fun save(product: Product){
        repository.save(product)
    }
}
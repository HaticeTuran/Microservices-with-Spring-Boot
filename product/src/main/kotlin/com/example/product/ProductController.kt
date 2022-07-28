package com.example.product

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux


@RestController
@RequestMapping("/product")
class ProductController (val service: ProductService){

    @GetMapping
    fun findProducts(): Flux<Product> {
        return service.findProducts()
    }

    @PostMapping
    fun save( @RequestBody product: Product){
        service.save(product)
    }
}
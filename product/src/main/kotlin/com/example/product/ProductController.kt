package com.example.product

import kotlinx.coroutines.flow.Flow
import org.springframework.boot.Banner
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.util.UUID


@RestController
@RequestMapping("/product")
class ProductController (val service: ProductService){

    @GetMapping
    suspend fun findProducts(): Flow<Product> {
        return service.findProducts()
    }

    @GetMapping
    suspend fun findProductByProductId(id: UUID): Product?{
        return service.findProductById(id);
    }

    @PostMapping
    suspend fun save( @RequestBody product: Product){
        service.save(product)
    }
}
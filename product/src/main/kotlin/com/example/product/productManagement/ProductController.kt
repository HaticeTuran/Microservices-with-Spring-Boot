package com.example.product.productManagement

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/product")
class ProductController (val service: ProductService){
     //Get Methods
    @GetMapping()
    suspend fun findProducts(): Flow<Product> {
        return service.findProducts()
    }

    @GetMapping("/{id}")
    suspend fun findProductByProductId(@PathVariable("id") id: UUID): Product?{
        return service.findProductById(id);
    }

    //Post methods
    @PostMapping()
    suspend fun saveProduct( @RequestBody product: Product){
        service.saveProduct(product)
    }

    //Delete Methods
    @DeleteMapping("/{id}")
    suspend fun deleteProductById(@PathVariable("id") id: UUID){
        service.deleteProductById(id)
    }
}
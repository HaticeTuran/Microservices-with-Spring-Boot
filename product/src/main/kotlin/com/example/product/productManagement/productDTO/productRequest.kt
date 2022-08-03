package com.example.product.productManagement.productDTO

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalTime
import java.util.*

data class productRequest (val productId: UUID?,
                           val productName: String,
                           val list_price: Int,
                           val quantityInStock:Int,
                           val productDescription: String?,
                           val createdDate: LocalTime?)

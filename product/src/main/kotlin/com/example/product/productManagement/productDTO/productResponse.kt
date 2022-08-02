package com.example.product.productManagement.productDTO

import java.time.LocalTime
import java.util.*

data class productResponse (val productId: UUID,
                            val productName: String,
                            val list_price: Int,
                            val quantityInStock:Int,
                            val productDescription: String,
                            val createdDate: LocalTime)

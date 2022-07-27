package com.example.product

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Table("product")
data class Product(@Id private val productId: Int,
                   private val productName: String,
                   private val list_price: Int,
                   private val createdDate: CreatedDate) {

}
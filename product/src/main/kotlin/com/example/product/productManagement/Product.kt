package com.example.product.productManagement

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID


@Table("products")
data class Product(@Id @Column("product_id") val productId: UUID?,
                   @Column("product_name")  val productName: String,
                   @Column("list_price")  val listPrice: Int?,
                   @Column("quantity_in_stock")  val quantityInStock:Int?,
                   @Column("product_description")  val productDescription: String,
                   @Column("created_date") @CreatedDate val createdDate: LocalTime?) {

}
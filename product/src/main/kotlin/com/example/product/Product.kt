package com.example.product

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID


@Table("products")
data class Product(@Id @Column("product_id") val productId: UUID,
                   @Column("product_name")  val productName: String,
                   @Column("list_price")  val list_price: Int,
                   @Column("quantity_in_stock")  val quantityInStock:Int,
                   @Column("product_description")  val productDescription: String,
                   @Column("created_date")  val createdDate: CreatedDate) {

}
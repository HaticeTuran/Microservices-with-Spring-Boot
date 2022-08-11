package com.example.comment.commentManagement

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

@Table("comment")
data class Comment(@Id @Column("comment_id") val commentId: UUID?,
                   @Column("comment_text") val commentText:String?,
                   @Column("created_date") @CreatedDate val createdDate: LocalDateTime?,
                   @Column("product_id") val productId: UUID)

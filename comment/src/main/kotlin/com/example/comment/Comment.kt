package com.example.comment

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.util.*

@Table("comments")
data class Comment(@Id @Column("comment_id") val commentId: UUID,
                   @Column("comment_text") val CommentText:String,
                   @Column("created_date") val createdDate: LocalDate,
                   @Column("product_id") val ProductId: UUID)

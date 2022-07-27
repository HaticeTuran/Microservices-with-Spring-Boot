package com.example.comment

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("comment")
data class Comment(@Id val comentId:Int, val CommentText:String, val createdDate: LocalDate, val ProductId: Int)

package com.example.comment.commentManagement.commentDTO

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalTime
import java.util.*

data class CommentRequest(val commentId: UUID?,
                          val CommentText:String?,
                          val createdDate: LocalTime?,
                          val ProductId: UUID?)

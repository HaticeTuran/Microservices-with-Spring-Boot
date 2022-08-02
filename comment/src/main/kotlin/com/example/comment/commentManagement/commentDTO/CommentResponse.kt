package com.example.comment.commentManagement.commentDTO

import java.time.LocalTime
import java.util.*

data class CommentResponse (val commentId: UUID,
                            val CommentText:String,
                            val createdDate: LocalTime,
                            val ProductId: UUID)
package com.example.comment.commentManagement

import com.example.comment.commentManagement.Comment
import com.example.comment.commentManagement.CommentRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CommentService(val repository: CommentRepository) {

    suspend fun findComments():Flow<Comment>{
        return repository.findAll()
    }

    suspend fun findCommentById(id:UUID): Comment?{
        return repository.findById(id)
    }

    suspend fun saveComment(comment: Comment){
        repository.save(comment)
    }

    suspend fun deleteCommentById(id: UUID){
        repository.deleteById(id)
    }

}
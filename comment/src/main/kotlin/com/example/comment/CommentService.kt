package com.example.comment

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CommentService(val repository: CommentRepository) {

    suspend fun findComments():Flow<Comment>{
        return repository.findComments()
    }

    suspend fun findCommentById(id:UUID): Comment?{
        return repository.findCommentById(id)
    }

    suspend fun saveComment(comment: Comment){
        repository.save(comment)
    }

    suspend fun deleteCommentById(id: UUID){
        repository.deleteById(id)
    }

}
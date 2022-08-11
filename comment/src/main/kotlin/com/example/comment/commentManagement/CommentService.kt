package com.example.comment.commentManagement

import com.example.comment.commentManagement.Comment
import com.example.comment.commentManagement.CommentRepository
import com.example.comment.exception.NotFoundException
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.util.UUID

@Service
class CommentService(val repository: CommentRepository) {

    suspend fun findComments():Flow<Comment>{
        return repository.findAll()
    }

    suspend fun findCommentById(id:UUID): Comment?{
        return repository.findById(id) ?: throw NotFoundException()
    }

    suspend fun saveComment(comment: Comment){
        repository.save(comment)
    }

    suspend fun deleteCommentById(id: UUID){
        repository.deleteById(id)
    }

    /*suspend fun updateComment(id: UUID, comment: Comment){
        repository.updateComment(id,comment)
    }*/

}
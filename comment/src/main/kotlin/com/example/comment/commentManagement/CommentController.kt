package com.example.comment.commentManagement
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.UUID

@Service
@RestController
@RequestMapping("/comment")
class CommentController(val service: CommentService){

    // Get Methods
    @GetMapping()
    suspend fun findComments():Flow<Comment>{
        return service.findComments()
    }

    @GetMapping("/{id}")
    suspend fun findCommentById(@PathVariable("id") id: UUID): Comment? {
        return service.findCommentById(id)
    }

    // Post Methods
    @PostMapping()
    suspend fun saveComment(@RequestBody comment: Comment){
        service.saveComment(comment)
    }

    // Delete Methods
    @DeleteMapping("/{id}")
    suspend fun deleteComment(@PathVariable("id") id: UUID){
        service.deleteCommentById(id)
    }

}
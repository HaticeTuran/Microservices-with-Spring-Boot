package com.example.comment
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@Service
@RestController
@RequestMapping("/comment")
class CommentController(val service: CommentService ){

    @GetMapping()
    suspend fun findComments():Flow<Comment>{
        return service.findComments()
    }
    @GetMapping("{/id}")
    suspend fun findCommentById(@PathVariable("id") id: UUID): Comment = service.findCommentById(id)

    @PostMapping()
    suspend fun saveComment(@RequestBody comment: Comment){
        service.saveComment(comment)
    }

    @PutMapping()
    suspend fun updateCommentText(comment: Comment){
        //TODO
    }

    @DeleteMapping("{/id}")
    suspend fun deleteComment(@PathVariable("id") id: UUID){
        service.deleteCommentById(id)
    }

}
package com.example.comment
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@Service
@RestController
@RequestMapping("/comment")
class CommentController(val service: CommentService ){

    @GetMapping
    suspend fun findComments():Flow<Comment>{
        return service.findComments()
    }
    @GetMapping
    suspend fun findCommentById(Id: UUID): Comment = service.findCommentById(Id)

    @PostMapping
    suspend fun saveComment(comment: Comment){
        service.saveComment(comment)
    }

    @PutMapping
    suspend fun updateCommentText(comment: Comment){
        //TODO
    }

    @DeleteMapping
    suspend fun deleteComment(id: Int){
        service.deleteCommentById(id)
    }

}
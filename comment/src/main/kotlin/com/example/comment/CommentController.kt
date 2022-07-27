package com.example.comment
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
@RestController
@RequestMapping("/comment")
class CommentController(val repository: CommentRepository){

    @GetMapping
    fun findComments():Flux<Comment>{
        return repository.findComments()
    }
    @GetMapping
    fun findCommentById(Id: Int): Mono<Comment> = repository.findById(Id)

    @PostMapping
    fun saveComment(comment: Comment){
        repository.save(comment)
    }

    @PutMapping
    fun updateCommentText(comment: Comment){
        //TODO
    }

    @DeleteMapping
    fun deleteComment(id: Int){
        repository.deleteById(id)
    }

}
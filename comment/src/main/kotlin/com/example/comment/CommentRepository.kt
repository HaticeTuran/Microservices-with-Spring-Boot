package com.example.comment

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CommentRepository : ReactiveCrudRepository<Comment, Int> {

    @Query("SELECT * FROM comment")
    fun findComments():Flux<Comment>

    @Query("SELECT * from comment c where c.commentId = id ")
    fun findCommentById(id:Int): Comment



}
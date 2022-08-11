package com.example.comment.commentManagement

import com.example.comment.commentManagement.Comment
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommentRepository : CoroutineCrudRepository<Comment, UUID> {

    //TO DO
    //@Query("UPDATE comments SET comment_text="+ comment.CommentText +"product_id=? WHERE comment_id=id;")
    /*suspend fun updateComment(id: UUID, comment: Comment){
        //TODO
    }*/

}
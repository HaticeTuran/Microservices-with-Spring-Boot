package com.example.comment.commentServiceTest

import com.example.comment.commentManagement.Comment
import com.example.comment.commentManagement.CommentRepository
import com.example.comment.commentManagement.CommentService
import com.example.comment.exception.NotFoundException
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.UUID

class CommentServiceTest {

    private val mockCommentRepository = mockk <CommentRepository>()
    private val CommentService = CommentService(mockCommentRepository)

    @Test
    fun `when CommentService findById called it should return a comment`() = runBlocking{
        //Given
        val commentId = UUID.randomUUID()
        val pId = UUID.randomUUID()
        val expected = Comment(commentId,"begendim",null,pId)
        coEvery { CommentService.findCommentById(commentId)} returns expected

        //When
        val actual = CommentService.findCommentById(commentId)

        //Then
        assertEquals(expected, actual)

    }

    @Test
    fun `when CommentService findById called with unknown id it should return exception`(): Unit = runBlocking {
        //Given
        val commentId = UUID.randomUUID()
         coEvery { CommentService.findCommentById(commentId) } returns null

        //When-Then
        assertThrows<NotFoundException> {
            CommentService.findCommentById(commentId)
        }
    }
}
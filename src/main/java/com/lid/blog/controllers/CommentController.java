package com.lid.blog.controllers;


import com.lid.blog.entities.Comment;
import com.lid.blog.payloads.ApiResponse;
import com.lid.blog.payloads.CommentDto;
import com.lid.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping("/post/{postId}/comments/{userId}")
    public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto comment, @PathVariable Integer postId,@PathVariable Integer userId){
        CommentDto createComment=this.commentService.createComment(comment,postId,userId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
     this.commentService.deleteComment(commentId);
     return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully",true, LocalDateTime.now()),HttpStatus.OK);
    }
}

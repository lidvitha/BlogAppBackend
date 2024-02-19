package com.lid.blog.services;

import com.lid.blog.payloads.CommentDto;
import com.lid.blog.repositories.CommentRepo;

public interface CommentService  {

    CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId);
    void deleteComment(Integer commentId);
}

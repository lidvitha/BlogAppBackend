package com.lid.blog.services.impl;

import com.lid.blog.entities.Comment;
import com.lid.blog.entities.Post;
import com.lid.blog.entities.User;
import com.lid.blog.exceptions.ResourceNotFoundException;
import com.lid.blog.payloads.CommentDto;
import com.lid.blog.repositories.CommentRepo;
import com.lid.blog.repositories.PostRepo;
import com.lid.blog.repositories.UserRepo;
import com.lid.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId,Integer userId) {

        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","UserId",userId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        comment.setUser(user);
        Comment save=this.commentRepo.save(comment);
        return this.modelMapper.map(save, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
        this.commentRepo.delete(comment);
    }
}

package com.lid.blog.services;

import com.lid.blog.entities.Post;
import com.lid.blog.payloads.PostDto;
import com.lid.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto,Integer postId);

    //delete
    void deletePost(Integer postId);

    //getAll

    PostResponse getAllpost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    //getsinglepost
    PostDto getPostById(Integer postId);

    //getpostbycategory
    List<PostDto>getPostsByCategory(Integer categoryId);


    //getpostbyuser
    PostResponse getPostsByUser(Integer userId,Integer pageNumber,Integer pageSize);


    //searchPosts
    List<PostDto>searchPosts(String keyword);
}

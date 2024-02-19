package com.lid.blog.payloads;

import com.lid.blog.entities.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private int id;

    private String content;

    private int userId;
}

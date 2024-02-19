package com.lid.blog.repositories;

import com.lid.blog.entities.Category;
import com.lid.blog.entities.Post;
import com.lid.blog.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {

    Page<Post> findByUser(User user, Pageable pageable);
    List<Post> findByCategory(Category category);

    @Query("select p from Post p where p.title like :key")
    List<Post> findByTitleContaining(@Param("key") String title);

   // Page<Post> findByUser(Integer userId, org.springframework.data.domain.Pageable p);
}

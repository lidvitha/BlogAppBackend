package com.lid.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lid.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}

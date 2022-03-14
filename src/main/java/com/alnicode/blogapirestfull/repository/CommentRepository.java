package com.alnicode.blogapirestfull.repository;

import com.alnicode.blogapirestfull.entity.Comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    
}

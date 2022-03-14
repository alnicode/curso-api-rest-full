package com.alnicode.blogapirestfull.repository;

import java.util.List;

import com.alnicode.blogapirestfull.entity.Comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByPostIdPost(long idPost);
}

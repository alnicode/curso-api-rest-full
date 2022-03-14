package com.alnicode.blogapirestfull.service;

import com.alnicode.blogapirestfull.dto.CommentDTO;
import com.alnicode.blogapirestfull.repository.CommentRepository;
import com.alnicode.blogapirestfull.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentDTO createComment(long idPost, CommentDTO commentDTO) {
        return null;
    }
    
}

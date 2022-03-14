package com.alnicode.blogapirestfull.service;

import com.alnicode.blogapirestfull.dto.CommentDTO;

public interface CommentService {

    CommentDTO createComment(long idPost, CommentDTO commentDTO);
}

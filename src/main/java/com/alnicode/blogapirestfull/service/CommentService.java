package com.alnicode.blogapirestfull.service;

import java.util.List;

import com.alnicode.blogapirestfull.dto.CommentDTO;

public interface CommentService {

    CommentDTO createComment(long idPost, CommentDTO commentDTO);

    List<CommentDTO> getByIdPost(long idPost);

    CommentDTO getById(long idPost, long idComment);

    CommentDTO updateComment(long idPost, long idComment, CommentDTO commentRequest);
}

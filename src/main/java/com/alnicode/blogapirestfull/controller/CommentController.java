package com.alnicode.blogapirestfull.controller;

import java.util.List;

import com.alnicode.blogapirestfull.dto.CommentDTO;
import com.alnicode.blogapirestfull.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public List<CommentDTO> getCommentsByPostId(@PathVariable(value = "postId") long idPost) {
        return this.commentService.getByIdPost(idPost);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable(value = "postId") long idPost,
                                                     @PathVariable(value = "commentId") long idComment) {
        return new ResponseEntity<>(this.commentService.getById(idPost, idComment), HttpStatus.OK);
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDTO> postComment(@PathVariable(value = "postId") long idPost, @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(this.commentService.createComment(idPost, commentDTO), HttpStatus.CREATED);
    }
}

package com.alnicode.blogapirestfull.service;

import com.alnicode.blogapirestfull.dto.CommentDTO;
import com.alnicode.blogapirestfull.entity.Comment;
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

    @Autowired
    private PostService postService;

    private CommentDTO toDTO(Comment comment) {
        return new CommentDTO(comment.getIdComment(), comment.getBody(), comment.getName(), comment.getEmail());
    }

    private Comment toEntity(CommentDTO commentDTO) {
        var comment = new Comment();
        comment.setIdComment(commentDTO.getIdComment());
        comment.setBody(commentDTO.getBody());
        comment.setEmail(commentDTO.getEmail());
        comment.setName(commentDTO.getName());

        return comment;
    }

    @Override
    public CommentDTO createComment(long idPost, CommentDTO commentDTO) {
        var comment = this.toEntity(commentDTO);
        var post = this.postService.getPost(idPost);
        comment.setPost(post);
        var newComment = this.commentRepository.save(comment);

        return this.toDTO(newComment);
    }

}

package com.alnicode.blogapirestfull.service;

import java.util.List;
import java.util.stream.Collectors;

import com.alnicode.blogapirestfull.dto.CommentDTO;
import com.alnicode.blogapirestfull.entity.Comment;
import com.alnicode.blogapirestfull.exception.BlogAppException;
import com.alnicode.blogapirestfull.exception.ResourceNotFoundException;
import com.alnicode.blogapirestfull.repository.CommentRepository;
import com.alnicode.blogapirestfull.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    private Comment getCommentById(long idPost, long idComment) {
        var post = this.postService.getPost(idPost);
        var comment = this.commentRepository.findById(idComment)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", idComment));
        
        if (!comment.getPost().getIdPost().equals(post.getIdPost())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece a la publicación");
        }

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

    @Override
    public List<CommentDTO> getByIdPost(long idPost) {
        List<Comment> comments = this.commentRepository.findByPostIdPost(idPost);
        return comments.stream().map(comment -> this.toDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getById(long idPost, long idComment) {
        var comment = this.getCommentById(idPost, idComment);
        return this.toDTO(comment);
    }

    @Override
    public CommentDTO updateComment(long idPost, long idComment, CommentDTO commentRequest) {
        var comment = this.getCommentById(idPost, idComment);
        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setBody(commentRequest.getBody());

        var updatedComment = this.commentRepository.save(comment);
        return this.toDTO(updatedComment);
    }

    @Override
    public void deleteComment(long idPost, long idComment) {
        var comment = this.getCommentById(idPost, idComment);
        this.commentRepository.delete(comment);
    }

}

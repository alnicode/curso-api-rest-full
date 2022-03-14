package com.alnicode.blogapirestfull.controller;

import com.alnicode.blogapirestfull.dto.PostDTO;
import com.alnicode.blogapirestfull.dto.PostResponseDTO;
import com.alnicode.blogapirestfull.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping()
    public PostResponseDTO getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return this.postService.getAllPosts(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable(name = "id") long idPost) {
        return ResponseEntity.ok(this.postService.getPostById(idPost));
    }

    @PostMapping()
    public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(this.postService.createPost(postDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable(name = "id") long idPost) {
        var post = this.postService.updatePost(postDTO, idPost);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosting(@PathVariable(name = "id") long idPost) {
        this.postService.deletePost(idPost);
        return new ResponseEntity<>("Publicación eliminada con éxito", HttpStatus.OK);
    }
}

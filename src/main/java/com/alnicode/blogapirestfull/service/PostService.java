package com.alnicode.blogapirestfull.service;

import java.util.List;

import com.alnicode.blogapirestfull.dto.PostDTO;

public interface PostService {
    
    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPosts(int pageNumber, int pageSize);

    PostDTO getPostById(long idPost);

    PostDTO updatePost(PostDTO postDTO, long idPost);

    void deletePost(long idPost);
}

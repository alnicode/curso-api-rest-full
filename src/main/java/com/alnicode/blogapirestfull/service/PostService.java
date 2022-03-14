package com.alnicode.blogapirestfull.service;

import com.alnicode.blogapirestfull.dto.PostDTO;
import com.alnicode.blogapirestfull.dto.PostResponseDTO;

public interface PostService {
    
    PostDTO createPost(PostDTO postDTO);

    PostResponseDTO getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir);

    PostDTO getPostById(long idPost);

    PostDTO updatePost(PostDTO postDTO, long idPost);

    void deletePost(long idPost);
}

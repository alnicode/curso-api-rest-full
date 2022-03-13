package com.alnicode.blogapirestfull.service;

import java.util.List;

import com.alnicode.blogapirestfull.dto.PostDTO;
import com.alnicode.blogapirestfull.entity.Post;
import com.alnicode.blogapirestfull.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        //DTO to Entity
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());

        Post newPost = this.postRepository.save(post);

        return new PostDTO(
            newPost.getIdPost(),
            newPost.getTitle(),
            newPost.getDescription(),
            newPost.getContent()
        );
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return null;
    }
    
    //DTO to Entity
    private Post toPost(PostDTO postDTO) {
        var post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        
        return this.postRepository.save(post);
    }

    //Entity to DTO
    private PostDTO toPostDTO(PostDTO postDTO) {
        var post = this.toPost(postDTO);
        return new PostDTO(
            post.getIdPost(),
            post.getTitle(),
            post.getDescription(),
            post.getContent()
        );
    }
}

package com.alnicode.blogapirestfull.service;

import java.util.List;
import java.util.stream.Collectors;

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
        return this.toPostDTO(this.toPost(postDTO));
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = this.postRepository.findAll();
        return posts.stream().map(post -> this.toPostDTO(post))
                    .collect(Collectors.toList());
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
    private PostDTO toPostDTO(Post post) {
        return new PostDTO(
            post.getIdPost(),
            post.getTitle(),
            post.getDescription(),
            post.getContent()
        );
    }
}

package com.alnicode.blogapirestfull.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
    private Long idPost;
    private String title;
    private String description;
    private String content;
}

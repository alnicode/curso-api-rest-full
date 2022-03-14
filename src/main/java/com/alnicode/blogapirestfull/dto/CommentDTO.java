package com.alnicode.blogapirestfull.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentDTO {
    private long idComment;
    private String body;
    private String name;
    private String email;
}

package com.alnicode.blogapirestfull.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    private List<PostDTO> contents;
    private int pageNumber;
    private int pageSize;
    private long totalItems;
    private int totalPages;
    private boolean last;
}

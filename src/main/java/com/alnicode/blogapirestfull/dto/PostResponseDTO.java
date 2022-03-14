package com.alnicode.blogapirestfull.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostResponseDTO {
    private List<PostDTO> content;
    private int pageNumber;
    private int pageSize;
    private long totalItems;
    private int totalPages;
    private boolean last;
}

package com.alnicode.blogapirestfull.exception;

import org.springframework.http.HttpStatus;

public class BlogAppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BlogAppException(HttpStatus httpStatus, String message) {
        super();
    }

    public BlogAppException(HttpStatus httpStatus, String message1, String message2) {
        super();
    }
}

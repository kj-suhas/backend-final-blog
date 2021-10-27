package com.blogs.finalBlogs.models.exceptions;
import com.blogs.finalBlogs.models.Blog;

public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String message) {
        super(message);
    }
}


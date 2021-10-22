package com.blogs.finalBlogs.models.service;

import java.util.List;

import javax.transaction.Transactional;

import com.blogs.finalBlogs.models.Blog;
import com.blogs.finalBlogs.models.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BlogService {
    private final BlogRepo blogRepo;

    @Autowired
    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    public Blog addBlog(Blog blog) {
        return blogRepo.save(blog);
    }

    public List<Blog> getBlogs() {
        return blogRepo.findAll();
    }

    public Blog updateBlogs(Blog blog) {
        return blogRepo.save(blog);
    }

    @Transactional
    public void deleteBlog(Long id) {
        blogRepo.deleteBlogById(id);
    }

}
    

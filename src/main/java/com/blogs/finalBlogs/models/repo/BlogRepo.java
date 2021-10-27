package com.blogs.finalBlogs.models.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.blogs.finalBlogs.models.Blog;

public interface BlogRepo extends JpaRepository<Blog, Long> {

    void deleteBlogById(Long id);
    Optional<Blog> findBlogById(Long id);
    
}

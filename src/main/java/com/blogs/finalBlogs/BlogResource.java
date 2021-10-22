package com.blogs.finalBlogs;

import java.util.List;

import com.blogs.finalBlogs.models.Blog;
import com.blogs.finalBlogs.models.service.BlogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/blog")
// http://localhost:8080/blog
public class BlogResource {
    private final BlogService blogService;

    public BlogResource(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Blog>> getAllAnimeList() {
        List<Blog> blogs = blogService.getBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        Blog newBlog = blogService.addBlog(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        Blog newBlog = blogService.updateBlogs(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable("id") Long id) {
        blogService.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


package com.blogs.finalBlogs;

import java.util.List;

import com.blogs.finalBlogs.exceptions.BadRequest;
import com.blogs.finalBlogs.exceptions.ResourceNotFoundException;
import com.blogs.finalBlogs.models.Blog;
import com.blogs.finalBlogs.models.service.BlogService;

import org.hibernate.annotations.Any;
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


    // @api:           "blog/all"
    // @desc:         "Api to get all blogs"
    // @access_type:  "Public"
    @GetMapping("/all")
    public ResponseEntity<List<Blog>> getAllAnimeList() {
        List<Blog> blogs = blogService.getBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // @api:           "blog/add"
    // @desc:         "Api add single blog"
    // @access_type:  "Public"
    @PostMapping("/add")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        Blog newBlog = blogService.addBlog(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.CREATED);

    }

    // @api:           "blog/update"
    // @desc:         "Api to update/edit blogs"
    // @access_type:  "Public"
    @PutMapping("/update")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog) {
        Blog newBlog = blogService.updateBlogs(blog);
        return new ResponseEntity<>(newBlog, HttpStatus.OK);
    }


    // @api:           "blog/delete/:id"
    // @desc:         "Api to delete a blog with the ID Provided"
    // @access_type:  "Public"
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable("id") Long id) {
        // blogService.findBlogById(id);
         blogService.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


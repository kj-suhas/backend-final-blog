package com.blogs.finalBlogs;

import java.util.List;

<<<<<<< HEAD
import com.blogs.finalBlogs.models.Blog;
import com.blogs.finalBlogs.models.service.BlogService;

=======
import com.blogs.finalBlogs.exceptions.ResourceNotFoundException;
import com.blogs.finalBlogs.models.Blog;
import com.blogs.finalBlogs.models.service.BlogService;

import org.hibernate.annotations.Any;
>>>>>>> 6252d971c736b85b918169a169aed985b9460c35
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
<<<<<<< HEAD
=======
// http://localhost:8080/blog
>>>>>>> 6252d971c736b85b918169a169aed985b9460c35
public class BlogResource {
    private final BlogService blogService;

    public BlogResource(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Blog>> getAllAnimeList() {
        List<Blog> blogs = blogService.getBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
<<<<<<< HEAD
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id) {
        Blog blog = blogService.findBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
=======
        // throw new ResourceNotFoundException("This is a test to see if i can see a response entity in browser");
>>>>>>> 6252d971c736b85b918169a169aed985b9460c35
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
<<<<<<< HEAD
        blogService.deleteBlog(id);
=======
        // blogService.findBlogById(id);
        Void deletedResult = blogService.deleteBlog(id);
>>>>>>> 6252d971c736b85b918169a169aed985b9460c35
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


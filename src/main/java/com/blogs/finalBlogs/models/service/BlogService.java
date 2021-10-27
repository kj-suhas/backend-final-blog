package com.blogs.finalBlogs.models.service;

import java.util.List;

import javax.transaction.Transactional;

<<<<<<< HEAD
import com.blogs.finalBlogs.models.Blog;
import com.blogs.finalBlogs.models.exceptions.BlogNotFoundException;
=======
import com.blogs.finalBlogs.exceptions.BadRequest;
import com.blogs.finalBlogs.exceptions.ResourceNotFoundException;
import com.blogs.finalBlogs.models.Blog;
>>>>>>> 6252d971c736b85b918169a169aed985b9460c35
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

<<<<<<< HEAD
    public Blog addBlog(Blog blog) {
        return blogRepo.save(blog);
    }

=======


// title: null,
// title: ""
    public Blog addBlog(Blog blog) {
        if((blog.getTitle() == null || blog.getTitle().length() == 0) && (blog.getDescription() == null || blog.getDescription().length() == 0)) {
            throw new BadRequest("title and description both cannot be null!");
        }
        else if(blog.getTitle() == null || blog.getTitle().length() == 0) {
            throw new BadRequest("title cannot be of type null or empty string!");
        } else if(blog.getDescription() == null || blog.getDescription().length() == 0) {
            throw new BadRequest("description cannot be of type null or empty string!");
        } else if (blog.getImg_url() == null) {
            throw new BadRequest("img_url cannot be null!");
        } 
        return blogRepo.save(blog);
    }




>>>>>>> 6252d971c736b85b918169a169aed985b9460c35
    public List<Blog> getBlogs() {
        return blogRepo.findAll();
    }

    public Blog updateBlogs(Blog blog) {
<<<<<<< HEAD
        return blogRepo.save(blog);
    }

    public Blog findBlogById(Long id) {
        return blogRepo.findBlogById(id).orElseThrow(() -> new BlogNotFoundException("Blog with id "+ id + "not found"));

    }
    // orElseThrow(() -> new BlogNotFoundException("User with the id "+ id +" not found")

    @Transactional
    public void deleteBlog(Long id) {
        blogRepo.deleteBlogById(id);
    }


=======
        if(blog.getId() == null) {
            throw new ResourceNotFoundException("Id Cannot be null!");
        }   else if(blog.getTitle() == null || blog.getTitle().length() == 0) {
            throw new BadRequest("title cannot be of type null or empty string!");
        } else if(blog.getDescription() == null || blog.getDescription().length() == 0) {
            throw new BadRequest("description cannot be of type null or empty string!");
        } else if (blog.getImg_url() == null) {
            throw new BadRequest("img_url cannot be null!");
        } 
        else {
            blogRepo.findBlogById(blog.getId()).orElseThrow(() -> new ResourceNotFoundException("Blog with id "+ blog.getId() +" does not exist!"));
        }
        return blogRepo.save(blog);
    }
    
        public Blog findBlogById(Long id) {
            return blogRepo.findBlogById(id).orElseThrow(() -> new ResourceNotFoundException("Blog with id"+ id +" does not exist!"));
    
        }

    @Transactional
    public void deleteBlog(Long id) {
        blogRepo.findBlogById(id).orElseThrow(() -> new ResourceNotFoundException("Blog with id "+ id +" does not exist!"));
        blogRepo.deleteBlogById(id);
    }
>>>>>>> 6252d971c736b85b918169a169aed985b9460c35
}
    

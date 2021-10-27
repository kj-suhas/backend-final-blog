package com.blogs.finalBlogs.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String description;
    private String img_url;

    public Blog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Blog(String title, String description, String img_url) {
        this.title = title;
        this.description = description;
        this.img_url = img_url;
    }

    public Blog(Long id, String title, String description, String img_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.img_url = img_url;
    }

  

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
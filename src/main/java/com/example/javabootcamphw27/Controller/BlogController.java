package com.example.javabootcamphw27.Controller;

import com.example.javabootcamphw27.Model.Blog;
import com.example.javabootcamphw27.Model.MyUser;
import com.example.javabootcamphw27.Service.BlogServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {

    private final BlogServices blogServices;

    // CRUD
    // Get
    @GetMapping("/get")
    public ResponseEntity getBlogs(@AuthenticationPrincipal MyUser myUser){
        List<Blog> blogs = blogServices.getBlogs(myUser.getId());
        return ResponseEntity.status(200).body(blogs);
    }

    // Add
    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser,@Valid @RequestBody Blog blog){
        // user id
        blogServices.addBlog(myUser.getId(),blog);
        return ResponseEntity.status(200).body("Blog have been added");
    }

    // Update
    @PutMapping("/update/{blog_id}")
    public ResponseEntity addBlog(@AuthenticationPrincipal MyUser myUser,@Valid @RequestBody Blog blog,@PathVariable Integer blog_id){
        // user id
        blogServices.updateBlog(blog_id,blog, myUser.getId());
        return ResponseEntity.status(200).body("Blog have been updated");
    }
    // Delete
    @DeleteMapping("/delete/{blog_id}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blog_id){
        blogServices.deleteBlog(blog_id, myUser.getId());
        return ResponseEntity.status(200).body("Blog have been deleted");

    }
    // get blog by id
    @GetMapping("/getBlogById/{blog_id}")
    public ResponseEntity getBlogByID(@AuthenticationPrincipal MyUser myUser,@PathVariable Integer blog_id){
        Blog blog = blogServices.getBlogById(blog_id, myUser.getId());
        return ResponseEntity.status(200).body(blog);
    }

    // get blog by title

    @GetMapping("/getBlogByTitle/{title}")
    public ResponseEntity getBlogByID(@AuthenticationPrincipal MyUser myUser,@PathVariable String title){
        Blog blog = blogServices.getBlogByTitle(title, myUser.getId());
        return ResponseEntity.status(200).body(blog);
    }


}

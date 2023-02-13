package com.example.javabootcamphw27.Service;

import com.example.javabootcamphw27.Exception.ApiException;
import com.example.javabootcamphw27.Model.Blog;
import com.example.javabootcamphw27.Model.MyUser;
import com.example.javabootcamphw27.Repoistory.BlogRepoistory;
import com.example.javabootcamphw27.Repoistory.MyUserRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServices {

    private final BlogRepoistory blogRepoistory;

    private final MyUserRepoistory myUserRepoistory;

    // CRUD

    //get
    public List<Blog> getBlogs(Integer user_Id){

        return blogRepoistory.findAllByUserID(user_Id);
    }

    //add
    public void addBlog(Integer id, Blog blog){
        blog.setUserID(id);
        blogRepoistory.save(blog);
    }

    // update
    public void updateBlog(Integer blogId, Blog blog, Integer userId){
        MyUser myUser = myUserRepoistory.findMyUserById(userId);
        Blog currentBlog = blogRepoistory.findBlogById(blogId);
        if(currentBlog==null){
            throw new ApiException("Blog could not be founded");
        }else if(currentBlog.getUserID()!=userId){
            throw new ApiException("Your not allowed to Delete this Blog!!!");
        }
        currentBlog.setBody(blog.getBody());
        currentBlog.setTitle(blog.getTitle());
        currentBlog.setId(blogId);
        currentBlog.setMyUser(myUser);
        blogRepoistory.save(currentBlog);
    }

    // delete

    public void deleteBlog(Integer blogId, Integer userId){

        Blog currentBlog = blogRepoistory.findBlogById(blogId);
        if(currentBlog==null){
            throw new ApiException("Blog could not be founded");
        }else if(currentBlog.getUserID()!=userId){
            throw new ApiException("Your not allowed to Delete this Blog!!!");
        }
        blogRepoistory.delete(currentBlog);
    }

    // Endpoints


    // Get blogs by id
    public Blog getBlogById(Integer blogID,Integer userID){
        MyUser myUser = myUserRepoistory.findMyUserById(userID);
        Blog blog = blogRepoistory.findBlogById(blogID);
        if(blog==null) {
            throw new ApiException("Blog could not found");
        }else if(blog.getUserID()!=userID){
            throw new ApiException("Your not allowed to view this Blog!!!");
        }

        return blog;
    }

    // Get blogs by title
    public Blog getBlogByTitle(String title,Integer userID){
        MyUser myUser = myUserRepoistory.findMyUserById(userID);
        Blog blog = blogRepoistory.findBlogByTitle(title);
        if(blog==null) {
            throw new ApiException("Blog could not found");
        }else if(blog.getUserID()!=userID){
            throw new ApiException("Your not allowed to view this Blog!!!");
        }
        return blog;
    }


}

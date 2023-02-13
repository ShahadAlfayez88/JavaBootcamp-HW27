package com.example.javabootcamphw27.Repoistory;

import com.example.javabootcamphw27.Model.Blog;
import com.example.javabootcamphw27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepoistory extends JpaRepository<Blog, Integer> {
    Blog findBlogById(Integer id);

    List<Blog> findAllByMyUser(MyUser myUser);

    List<Blog> findAllByUserID(Integer id);

    Blog findBlogByTitle(String title);

}

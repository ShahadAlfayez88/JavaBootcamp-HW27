package com.example.javabootcamphw27.Repoistory;

import com.example.javabootcamphw27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepoistory extends JpaRepository<MyUser, Integer> {
    MyUser findMyUserById(Integer id);
}

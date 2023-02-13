package com.example.javabootcamphw27.Repoistory;

import com.example.javabootcamphw27.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepoistory extends JpaRepository<MyUser, Integer> {
    MyUser findMyUserByUsername(String username);

}

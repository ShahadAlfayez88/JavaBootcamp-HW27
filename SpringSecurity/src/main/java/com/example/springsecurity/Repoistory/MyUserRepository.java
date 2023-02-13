package com.example.springsecurity.Repoistory;

import com.example.springsecurity.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findMyUserById(Integer id);
}

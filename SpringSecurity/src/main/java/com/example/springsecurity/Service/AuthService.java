package com.example.springsecurity.Service;

import com.example.springsecurity.Model.MyUser;
import com.example.springsecurity.Repoistory.AuthRepoitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepoitory authRepository;


    public void register(MyUser myUser) {
        myUser.setRole("USER");
        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        authRepository.save(myUser);
    }
}
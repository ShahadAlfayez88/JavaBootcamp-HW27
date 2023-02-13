package com.example.javabootcamphw27.Service;

import com.example.javabootcamphw27.Model.MyUser;
import com.example.javabootcamphw27.Repoistory.AuthRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepoistory authRepoistory;

    public void register(MyUser myUser){
        myUser.setRole("USER");
        String hashedPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        authRepoistory.save(myUser);
    }
}

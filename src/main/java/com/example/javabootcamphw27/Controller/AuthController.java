package com.example.javabootcamphw27.Controller;


import com.example.javabootcamphw27.Exception.ApiException;
import com.example.javabootcamphw27.Model.MyUser;
import com.example.javabootcamphw27.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(200).body("User have been registered!");
    }

    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("Welcome");
    }
}
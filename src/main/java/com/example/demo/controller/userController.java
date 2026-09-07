package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @GetMapping("/login")
    ResponseEntity<User> login(@RequestBody User user){
        return ResponseEntity.ok(user);
    }

    @GetMapping("/health")
    String health(){
        return "OK";
    }

}

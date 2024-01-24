package com.tweteroo.apiTweteroo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.apiTweteroo.domain.user.User;
import com.tweteroo.apiTweteroo.domain.user.UserDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/user")
public class UserController {
    
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {

        User response = new User();
        
        return ResponseEntity.ok().body(response);
    }
    
}

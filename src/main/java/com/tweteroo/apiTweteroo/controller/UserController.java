package com.tweteroo.apiTweteroo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.apiTweteroo.domain.user.User;
import com.tweteroo.apiTweteroo.domain.user.UserDTO;
import com.tweteroo.apiTweteroo.repositories.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {

        User newUser = new User(userDTO);

        User response = repository.save(newUser);

        return ResponseEntity.ok().body(response);
    }
       
}

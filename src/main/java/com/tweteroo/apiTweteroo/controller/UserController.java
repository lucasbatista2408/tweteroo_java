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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/user")
public class UserController {

    final UserRepository repository;

    UserController(UserRepository repository){
        this.repository = repository;
    }
    
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {

        User newUser = new User(userDTO);

        User response = repository.save(newUser);

        return ResponseEntity.ok().body(response);
    }
       
    @GetMapping("/getUser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable UUID id) {
        
        Optional<User> response = repository.findById(id);

        if(!response.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok().body(response);
    }
    
}

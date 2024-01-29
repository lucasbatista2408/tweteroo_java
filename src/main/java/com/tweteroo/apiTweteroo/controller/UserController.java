package com.tweteroo.apiTweteroo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.apiTweteroo.domain.user.User;
import com.tweteroo.apiTweteroo.domain.user.UserDTO;
import com.tweteroo.apiTweteroo.repositories.UserRepository;
import com.tweteroo.apiTweteroo.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {

        User newUser = new User(userDTO);

        User response = userService.createUser(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
       
    @GetMapping("/getUser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable UUID id) {
        
        Optional<User> response = userService.findUser(id);

        if(!response.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getUser/all")
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        userService.deleteById(id);
    }
    
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody UserDTO data) {

        Optional<User> user = userService.findUser(id);

        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        User response = userService.updateUser(data, id);
        
        return ResponseEntity.ok().body(response);
    }
    
}

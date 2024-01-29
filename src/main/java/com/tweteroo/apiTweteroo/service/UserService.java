package com.tweteroo.apiTweteroo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tweteroo.apiTweteroo.domain.user.User;
import com.tweteroo.apiTweteroo.domain.user.UserDTO;
import com.tweteroo.apiTweteroo.repositories.UserRepository;

@Service
public class UserService {
    
    final UserRepository repository;

    UserService(UserRepository repository){
        this.repository = repository;
    }

    public User createUser(User data){

        User response = repository.save(data);

        return response;
    }

    public Optional<User> findUser(UUID id){

        return repository.findById(id);
    }

    public List<User> getAllUsers(){

        return repository.findAll();
    }

    public User getUser(UUID id){

        return repository.getUserById(id);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public User updateUser(UserDTO data, UUID id){
        User updated = new User();

        updated.setId(id);
        updated.setAvatar(data.avatar());
        updated.setUsername(data.username());

        User response = repository.save(updated);
        
        return response;
    }
}

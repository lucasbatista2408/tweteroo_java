package com.tweteroo.apiTweteroo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.apiTweteroo.domain.tweet.Tweet;
import com.tweteroo.apiTweteroo.domain.tweet.TweetDTO;
import com.tweteroo.apiTweteroo.domain.user.User;
import com.tweteroo.apiTweteroo.repositories.TweetRepository;
import com.tweteroo.apiTweteroo.repositories.UserRepository;
import com.tweteroo.apiTweteroo.service.TweetService;
import com.tweteroo.apiTweteroo.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/tweet")
public class TweetController {

    private TweetService service;

    public TweetController(TweetService service){
        this.service = service;
    }
    
}

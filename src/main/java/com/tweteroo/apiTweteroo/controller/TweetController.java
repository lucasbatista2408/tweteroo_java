package com.tweteroo.apiTweteroo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.apiTweteroo.domain.tweet.Tweet;
import com.tweteroo.apiTweteroo.domain.tweet.TweetDTO;
import com.tweteroo.apiTweteroo.domain.user.User;
import com.tweteroo.apiTweteroo.service.TweetService;
import com.tweteroo.apiTweteroo.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/tweet")
public class TweetController {

    @Autowired
    private TweetService service;

    @Autowired
    private UserService userService;
    
    @PostMapping("/create-tweet")
    public Tweet createTweet(@RequestBody TweetDTO data) {
        
        User user = userService.getUser(data.userId());

        System.out.println(data.text());
        System.out.println(user);
        
        Tweet newTweet = new Tweet(data.text(), user);

        Tweet response = service.insertTweet(newTweet);

        return newTweet;
    } 
    
}

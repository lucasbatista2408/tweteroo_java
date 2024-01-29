package com.tweteroo.apiTweteroo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.apiTweteroo.domain.tweet.Tweet;
import com.tweteroo.apiTweteroo.domain.tweet.TweetDTO;
import com.tweteroo.apiTweteroo.domain.user.User;
import com.tweteroo.apiTweteroo.service.TweetService;
import com.tweteroo.apiTweteroo.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/tweet")
public class TweetController {

    private TweetService tweetService;

    private UserService userService;

    public TweetController(TweetService tweetService, UserService userService){
        this.tweetService = tweetService;
        this.userService = userService;
    }
    
    @PostMapping("/create-tweet")
    public ResponseEntity<Tweet> createTweet(@RequestBody TweetDTO data) {
        
        User user = userService.getUser(data.userId());
        
        Tweet newTweet = new Tweet(data.text(), user);

        return ResponseEntity.status(HttpStatus.CREATED).body(tweetService.insertTweet(newTweet));
    }

    @GetMapping("/get-all-tweets")
    public ResponseEntity<List<Tweet>> getAllTweets() {
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getAllTweets());
    }

    @GetMapping("/user/{id}")
    public void getMethodName(@PathVariable("id") UUID id) {

        userService.getUser(id);


    }
    
    
    
}

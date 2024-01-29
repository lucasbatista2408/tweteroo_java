package com.tweteroo.apiTweteroo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tweteroo.apiTweteroo.domain.tweet.Tweet;
import com.tweteroo.apiTweteroo.repositories.TweetRepository;

@Service
public class TweetService {
    
    final TweetRepository repository;

    TweetService(TweetRepository repository){
        this.repository = repository;
    }

    public Tweet insertTweet(Tweet data){
        return repository.save(data);
    }
    
    public List<Tweet> getAllTweets(){
        return repository.findAll();
    }

    public List<Tweet> findByUserId(UUID id){
        return repository.findByUserId(id);
    }
}

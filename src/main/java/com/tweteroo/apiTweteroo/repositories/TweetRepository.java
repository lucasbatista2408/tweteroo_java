package com.tweteroo.apiTweteroo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.apiTweteroo.domain.tweet.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    
}

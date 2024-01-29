package com.tweteroo.apiTweteroo.repositories;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.tweteroo.apiTweteroo.domain.tweet.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query(value="SELECT t.id, text, t.user_id FROM tweet t \n" + //
    "JOIN users u ON t.user_id = u.id \n" +
    "WHERE u.id = :id", nativeQuery = true)
    List<Tweet> findByUserId(@PathVariable("id") UUID id);
    
}

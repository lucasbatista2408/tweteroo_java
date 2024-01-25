package com.tweteroo.apiTweteroo.domain.tweet;

import com.tweteroo.apiTweteroo.domain.user.User;

public record TweetDTO(String text, User user) {}

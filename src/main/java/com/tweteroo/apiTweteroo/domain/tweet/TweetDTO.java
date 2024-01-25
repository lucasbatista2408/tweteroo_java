package com.tweteroo.apiTweteroo.domain.tweet;

import java.util.UUID;

public record TweetDTO(String text, UUID user) {}

package com.tweteroo.apiTweteroo.domain.tweet;

import java.util.UUID;


import com.tweteroo.apiTweteroo.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 280, nullable = false)
    private String text;
    
    @Column(nullable = false)
    private User userName;

    public Tweet(String text, User user){
        this.text = text;
        this.userName = user;
    }
}

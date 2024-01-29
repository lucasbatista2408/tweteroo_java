package com.tweteroo.apiTweteroo.domain.tweet;


import com.tweteroo.apiTweteroo.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Tweet(String text, User user){
        this.text = text;
        this.user = user;
    }
}

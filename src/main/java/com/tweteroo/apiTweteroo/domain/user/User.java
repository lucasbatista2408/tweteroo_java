package com.tweteroo.apiTweteroo.domain.user;

import java.util.List;
import java.util.UUID;

import com.tweteroo.apiTweteroo.domain.tweet.Tweet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String profileUrl;

    @Column(length = 100, nullable = false)
    private String username;

    @OneToMany
    private List<Tweet> tweet;

    public User(UserDTO user){
        this.profileUrl = user.profileUrl();
        this.username = user.username();
    }
}

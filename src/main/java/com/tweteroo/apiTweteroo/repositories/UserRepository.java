package com.tweteroo.apiTweteroo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.apiTweteroo.domain.user.User;

public interface UserRepository extends JpaRepository<User, UUID>{

}

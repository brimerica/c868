package com.example.c868.repositories;

import com.example.c868.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User findUserByName(String name);

    User findUserById(Long userId);



}

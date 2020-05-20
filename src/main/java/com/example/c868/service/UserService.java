package com.example.c868.service;

import com.example.c868.model.User;
import com.example.c868.repositories.UserRepository;
import com.example.c868.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user, Authority authority){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);


        switch(authority.getAuthority()){
            case "ROLE_USER":
                authority.setAuthority("ROLE_USER");
                authority.setId(1L);
                break;
            case "ROLE_ADMIN":
                authority.setAuthority("ROLE_ADMIN");
                authority.setId(6L);
                break;
            default:
                authority.setAuthority("ROLE_VIEWER");
                authority.setId(7L);
                break;
        }

        //authority.setUser(userCollection);
        user.getAuthorities().add(authority);

        return userRepository.save(user);
    }

    public User getUserById(Long userId){
        return userRepository.findUserById(userId);
    }

    @Transactional
    public User getUserByName(String name){
        return userRepository.findUserByName(name);
    }

}

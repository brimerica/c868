package com.example.c868.service;

import com.example.c868.model.User;
import com.example.c868.repositories.UserRepository;
import com.example.c868.security.CustomSecurityUser;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);


        if(user == null) {
            throw new UsernameNotFoundException("Invalid Username and password combination");
        }
        return user.map(CustomSecurityUser::new).get();
        //return new CustomSecurityUser(user);
    }
}

package com.example.c868.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsServiceTest {

    @Test
    public void generated_encrypted_password(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "test";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(encodedPassword);

        assertThat(rawPassword, not(encodedPassword));
    }

}
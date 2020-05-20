package com.example.c868.security;

import com.example.c868.model.User;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CustomSecurityUser extends User implements UserDetails {

    private static final long serialVersionUID = -6682947101908493082L;

    public CustomSecurityUser() {
    }

    public CustomSecurityUser(User user) {
        this.setAuthorities(user.getAuthorities());
        this.setId(user.getId());
        this.setName(user.getName());
        this.setPassword(user.getPassword());
        this.setUsername(user.getUsername());
    }

    @Override
    public Collection<Authority> getAuthorities() {
        return super.getAuthorities();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

//    public CustomSecurityUser(User user) {
//        this.id = user.getId();
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.name = user.getName();
//        this.authorities = user.getAuthorities();
//    }
//
//    @Override
//    public Collection<Authority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

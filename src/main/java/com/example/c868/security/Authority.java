package com.example.c868.security;

import com.example.c868.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority implements GrantedAuthority {

    private static final long serialVersionUID = -8973305114740755555L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private Collection<User> user = new HashSet<>();

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }
}

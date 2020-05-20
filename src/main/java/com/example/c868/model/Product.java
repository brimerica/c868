package com.example.c868.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductIssue prodIssue;

    @Enumerated(EnumType.STRING)
    private ProductFamily prodFamily;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductIssue getProdIssue() {
        return prodIssue;
    }

    public void setProdIssue(ProductIssue prodIssue) {
        this.prodIssue = prodIssue;
    }

    public ProductFamily getProdFamily() {
        return prodFamily;
    }

    public void setProdFamily(ProductFamily prodFamily) {
        this.prodFamily = prodFamily;
    }
}

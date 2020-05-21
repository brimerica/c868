package com.example.c868.repositories;

import com.example.c868.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT DISTINCT p.name FROM Product p")
    List<String> findDistinctName();

    Product findProductByName(String name);

}

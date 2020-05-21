package com.example.c868.service;

import com.example.c868.model.Product;
import com.example.c868.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){

        return productRepository.save(product);

    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<String> getDistinctProductName(){
        return productRepository.findDistinctName();
    }

    public Product getProductByName(String name){
        return productRepository.findProductByName(name);
    }

}

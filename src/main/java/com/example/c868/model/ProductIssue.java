package com.example.c868.model;

import java.util.ArrayList;
import java.util.List;

public enum ProductIssue {

     BROKE_WHEN_ARRIVED("Broke when it arrived"),
     WRONG_PRODUCT_RECEIVED("Was not what I ordered"),
     NOT_WORKING_AS_INTENDED("No longer working as intended"),
     ORDERED_WRONG("Ordered the wrong product"),
     WARRANTY_CLAIM("Warranty Claim");

     private final String name;
     private List<ProductIssue> productIssues = new ArrayList<ProductIssue>();

    ProductIssue(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductIssue{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<ProductIssue> getAllProductIssues(){
        productIssues.add(BROKE_WHEN_ARRIVED);
        productIssues.add(WRONG_PRODUCT_RECEIVED);
        productIssues.add(NOT_WORKING_AS_INTENDED);
        productIssues.add(ORDERED_WRONG);
        productIssues.add(WARRANTY_CLAIM);
        return productIssues;
    }
}

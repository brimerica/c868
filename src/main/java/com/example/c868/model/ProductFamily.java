package com.example.c868.model;

import java.util.ArrayList;
import java.util.List;

public enum ProductFamily {

    WHOSIT("WhosIt Family"),
    WHATSIT("WhatsIt Family"),
    HOWSIT("HowsIt Family"),
    WHYSIT("WhysIt Family");

    private final String name;
    List<ProductFamily> productFamilies = new ArrayList<ProductFamily>();

    ProductFamily(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductFamily{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<ProductFamily> getAllProductFamily(){
        productFamilies.add(WHOSIT);
        productFamilies.add(WHYSIT);
        productFamilies.add(WHATSIT);
        productFamilies.add(HOWSIT);

        return productFamilies;
    }

}

package com.example.firstspringbootdemo.service;

import com.example.firstspringbootdemo.model.Product;

import java.util.List;

public class DbStoreProductService implements ProductService{
    //this is one more implementation for our ProductService interface directly to interact with DB
    @Override
    public Product createProduct(Product createProduct) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }
}

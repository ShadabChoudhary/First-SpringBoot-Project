package com.example.firstspringbootdemo.service;

import com.example.firstspringbootdemo.model.Category;
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

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return List.of();
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        //delete product
        return null;
    }

}

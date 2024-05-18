package com.example.firstspringbootdemo.service;

import com.example.firstspringbootdemo.model.Product;

import java.util.List;
//now creating an interface for ProductController so that we can access all the methods from it
public interface ProductService {
    //so right now we gave three methods in our Product controller

    //1st is creating a product
    Product createProduct(Product createProduct);

    //2nd is getALlProducts
    List<Product> getAllProducts();

    // 3rd is getProduct
    Product getSingleProduct(Long productId);

    //now we want to implement all these methods so lets creating one more class fakeStore
    //which is going to access all our methods from this interface
}

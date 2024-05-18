package com.example.firstspringbootdemo.controller;

import com.example.firstspringbootdemo.model.Product;
import com.example.firstspringbootdemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

//Our all API related things will happen in controller
@RestController
public class ProductController {

    private ProductService productService;

     public ProductController(ProductService productService) {
         this.productService = productService;
     }

    //Creating a product
    @PostMapping ("/products")
    public void createProduct(@RequestBody Product product) {
        //whenever we do a Post request on /products
        //this function is going to execute, and it will create a new product
    }

    //Get all the products
    @GetMapping("/products")
    public void getAllProduct() {
         productService.getAllProducts();
        //whenever we do a Get request on /products
        //this function is going to execute, and it will get all the products
    }

    //Get one product
    @GetMapping("/products/{id}")
    public void getProduct(@PathVariable("id") Long productDetails) {
        //whenever we do a Get request on /products/{id}
        //this function is going to execute, and it will get the product of that particular id
    }
}

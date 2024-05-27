package com.example.firstspringbootdemo.controller;

import com.example.firstspringbootdemo.model.Category;
import com.example.firstspringbootdemo.model.Product;
import com.example.firstspringbootdemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Our all API related things will happen in controller
@RestController
public class ProductController {
    //accessing productService
    private final ProductService productService;

     public ProductController(ProductService productService) {
         this.productService = productService;
     }

    //Creating a product
    @PostMapping ("/products")
    public Product createProduct(@RequestBody Product product) {
        //whenever we do a Post request on /products
        //this function is going to execute, and it will create a new product
        Product postProduct = productService.createProduct(product);
        return postProduct;
    }

    //Get all the products
    @GetMapping("/products")
    public List<Product> getAllProduct() {
        //whenever we do a Get request on /products
        //this function is going to execute, and it will get all the product
         List<Product> allProducts = productService.getAllProducts();
         return allProducts;
    }

    //Get one product
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long productId) {
        //whenever we do a Get request on /products/{id}
        //this function is going to execute, and it will get the product of that particular id
        Product  currProduct = productService.getSingleProduct(productId);
        return currProduct;//and now here the data is parsed, and we are sending our product model data to user
    }

    //Update Product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
         Product update = productService.updateProduct(productId, product);
         return update;
    }

    //Get Product by category
    @GetMapping("https://fakestoreapi.com/products/category/{categoryTitle}")
    public List<Product> getProductByCategory(@PathVariable("categoryTitle") String category) {
         //here we are returning a list of product by their category name
        return productService.getProductByCategory(category);
    }

    //get all the category name
    @GetMapping("https://fakestoreapi.com/products/categories")
    public List<Category> getAllCategories() {
        //return products category name
        return productService.getAllCategories();
    }

    //delete a product giving error
    @DeleteMapping("https://fakestoreapi.com/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
    }
}

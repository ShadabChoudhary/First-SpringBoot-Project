package com.example.firstspringbootdemo.controller;

import com.example.firstspringbootdemo.dto.ExceptionDto;
import com.example.firstspringbootdemo.exceptions.ProductNotFoundException;
import com.example.firstspringbootdemo.model.Category;
import com.example.firstspringbootdemo.model.Product;
import com.example.firstspringbootdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Our all API related things will happen in controller
@RestController
public class ProductController {
    //accessing productService
    private final ProductService productService;
    //when implementing our interface "ProductService" we use Service annotation were ever we implement it
    //But we are implementing our productService interface more then, one times so, we have to name each implementation
    //so that wherever we use our interface implementation springboot don't get confused
    //so here Qualifier make sure which implementation we are using
     public ProductController(@Qualifier("SelfProductService") ProductService productService) {
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
    public Page<Product> getAllProduct(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
        //whenever we do a Get request on /products
        //this function is going to execute, and it will get all the product
         return productService.getAllProducts(pageSize, pageNumber);
//         return allProducts();
    }

    //Get one product
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        //whenever we do a Get request on /products/{id}
        //this function is going to execute, and it will get the product of that particular id
        Product  currProduct = productService.getSingleProduct(productId);
        return currProduct;//and now here the data is parsed, and we are sending our product model data to user
    }

    //Update Product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId, @RequestBody Product product)
        throws ProductNotFoundException {
         Product update = productService.updateProduct(productId, product);
         return update;
    }

//    Get Product by category
    @GetMapping("/products/category/{categoryTitle}")
    public List<Product> getProductByCategory(@PathVariable("categoryTitle") String category) {
         //here we are returning a list of product by their category name
        return productService.getProductByCategory(category);
    }

    //Both, above and this api somehow springboot taking them as same so only on is working at a time
//    @GetMapping("/products/category/{categoryId}")
//    public List<Product> getProductsByCategoryId(@PathVariable("categoryId") Long categoryId) throws ProductNotFoundException{
//        return productService.getProductsByCategoryId(categoryId);
//    }

    //get all the category name
    @GetMapping("/products/categories")
    public List<String> getAllCategories() {
        //return products category name
        return productService.getAllCategories();
    }

    //delete a product giving error
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        return productService.deleteProduct(productId);
    }


    //this annotation make sure if we get any error in ProductNotFoundException this will execute and return the
    //error message we have mentioned in the FakeStoreProductService
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(Exception e) {
         ExceptionDto exceptionDto = new ExceptionDto();
         exceptionDto.setMessage(e.getMessage());

         return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}

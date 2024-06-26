package com.example.firstspringbootdemo.service;

import com.example.firstspringbootdemo.exceptions.ProductNotFoundException;
import com.example.firstspringbootdemo.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
//now creating an interface for ProductController so that we can access all the methods from it
public interface ProductService {
    //so right now we gave three methods in our Product controller
    Product createProduct(Product createProduct);
//    List<Product> getAllProducts();
    //Pagination get all products
    Page<Product> getAllProducts(int pageSize, int pageNumber);
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    Product updateProduct(Long productId, Product updateProduct) throws ProductNotFoundException;
    List<Product> getProductByCategory(String category);
    List<Product> getProductsByCategoryId(Long categoryId) throws ProductNotFoundException;
    List<String> getAllCategories();
    String deleteProduct(Long productId);

    //now we want to implement all these methods so let's create one more service class fakeStoreProductService
    //which is going to access all our methods from this interface
}

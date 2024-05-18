package com.example.firstspringbootdemo.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.firstspringbootdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{
    //now we want to implement all the methods from ProductService which is our interface
    //ide provides a shortcut to create all this methods in one click
    @Override
    public Product createProduct(Product createProduct) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("getting all Products");
        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }
}

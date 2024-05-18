package com.example.firstspringbootdemo;

import com.example.firstspringbootdemo.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectMainClass {
    public static void main(String[] args) {
        //accessing product from Product file
        Product p = new Product();
        SpringApplication.run(FirstSpringbootDemoApplication.class, args);
    }
}

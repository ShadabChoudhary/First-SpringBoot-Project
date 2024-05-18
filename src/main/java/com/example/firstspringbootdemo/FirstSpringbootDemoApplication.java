package com.example.firstspringbootdemo;

import com.example.firstspringbootdemo.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringbootDemoApplication {
    public static void main(String[] args) {
//        Product p = new Product();
        SpringApplication.run(FirstSpringbootDemoApplication.class, args);
    }
}

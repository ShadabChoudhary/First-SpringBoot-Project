package com.example.firstspringbootdemo.dto;

import com.example.firstspringbootdemo.model.Category;
import com.example.firstspringbootdemo.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    //these are all the parameters we are getting form our fake store
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    //now map the data we are getting from fake store for each product to our defined product model
    //Mapper function
    public Product toProduct(){
        Product p = new Product();
        p.setId(id);
        p.setTitle(title);
        p.setPrice(price);
        p.setDescription(description);
        p.setImageUrl(image);

        //for category, we have to create on more object because fake store is returning category as a String
        //And for us category is an object as per our model
        Category cat = new Category();
        cat.setId(id);
        cat.setTitle(category);
        p.setCategory(cat);
        return p;
    }
}

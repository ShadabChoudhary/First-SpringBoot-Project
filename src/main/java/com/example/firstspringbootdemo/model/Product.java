package com.example.firstspringbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//Constructors
@AllArgsConstructor // this will create the constructor for each argument in Product class
@NoArgsConstructor // this is how we can create no arg constructor using lombok
public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private String url;
    private Category  category;

    //getter and setter
    //now we have to create getter and setters for them to access them in different files using getters and setters
    //there are many ways to create getters and setters by just creating the functions
    //but here I am using lombok dependency which automatically create getter and setter for us by using annotations

    //Constructor
    //if we want to create object of a class we use constructor, there are many ways to create constructor
    //First we can right-click > Generate > Constructor > and then select the fields of which we have to create a constructor
    //Or we can use lombok here also, lombok can also create a constructor by using annotations
    //this type of constructor also known as no arg constructor, where we are not passing any arg in a constructor
    //we can also create no arg without using lombok by just creating a constructor with empty arg
}

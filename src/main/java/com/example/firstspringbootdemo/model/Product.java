package com.example.firstspringbootdemo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//Constructors
@AllArgsConstructor // this will create the constructor for each argument in Product class
@NoArgsConstructor // this is how we can create no arg constructor using lombok
@Entity //Hybernate checks where ever it find @Entity it will create a table for that
public class Product extends BaseModel{
    //Removing common parameters after adding it in BaseModel
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    // FK using cardinality, multiple products can have same category
    @ManyToOne(cascade = {CascadeType.PERSIST})//cascade make sure while creating a product if category doesn't exist it will create first
    //and to tell hibernate where we are using this cardinality hibernate has an annotation called mappedBy used in Category
//    @JoinColumn(name = "category_id")// joining category table to get all the product of specific category id
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

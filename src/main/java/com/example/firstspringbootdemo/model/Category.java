package com.example.firstspringbootdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseModel{
    //Removing common parameters after adding it in BaseModel
    //And extend this model to BaseModel
    private String title;
    @OneToMany(mappedBy = "category")
    //this will ignore when we try to get only one product from database, otherwise it will return a list of products
    @JsonIgnore
    private List<Product> products;
}

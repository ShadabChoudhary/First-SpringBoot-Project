package com.example.firstspringbootdemo.model;

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
    private List<Product> products;
}

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
    //We use JsonIgnore when we have to ignore any field as part of our response
    @JsonIgnore
    private List<Product> products;
}

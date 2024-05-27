package com.example.firstspringbootdemo.repository;

import com.example.firstspringbootdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//repository helps to fill the gap between our actual model and database so they both interact to each other
//And JpaRepository is going to take the object we are working and the datatype of our PK
//it helps to get something from DB as we are doing a function call we don't have to write (select * from products)
public interface ProductRepository extends JpaRepository<Product, Long> {
    //this will save all the values in our DB, we don't have to write insert into product value()
    Product save(Product product);
    // and if we want to get something from our table just use findBy and the name of the attribute it will get the details
    Product findByTitle(String title);
}

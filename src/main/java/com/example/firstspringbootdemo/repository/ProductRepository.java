package com.example.firstspringbootdemo.repository;

import com.example.firstspringbootdemo.model.Category;
import com.example.firstspringbootdemo.model.Product;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//repository helps to fill the gap between our actual model and database so they both interact to each other
//And JpaRepository is going to take the object we are working and the datatype of our PK
//it helps to get something from DB as we are doing a function call we don't have to write (select * from products)
public interface ProductRepository extends JpaRepository<Product, Long> {
    //this will save all the values in our DB, we don't have to write insert into product value()
    Product save(Product product);
    // and if we want to get something from our table just use findBy and the name of the attribute it will get the details
    Product findById(long id);
    List<Product> findByCategoryId(long categoryId);

    //How to implement HQL (Hibernate Query Language)
    //here we are getting all the products from the table using categoryId
    //Hql also have OOPs concept in it, we can include classes in the HQL query's
    //------------------->here Product is our class product, not DB
    //-------------------------->here inside Product p we have Category class and inside we have category id
    @Query("select p from Product p where p.category.id = :categoryId")
    //since we are fetching all the data using categoryId, passing the same in Param
    List<Product> getProductsByCategoryId(@Param("categoryId") long categoryId);

    //How to implement Native Query (SQL Query)
    @Query(value = "select * from product p where p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryIdWithNativeQueries(@Param("categoryId") Long categoryId);
}

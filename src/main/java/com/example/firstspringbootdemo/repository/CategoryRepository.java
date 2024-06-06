package com.example.firstspringbootdemo.repository;

import com.example.firstspringbootdemo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category save(Category category);
    Category findByTitle(String title);

    @Query(value="SELECT c.title FROM Category c", nativeQuery=true)
    List<String> findAllCategories();
}

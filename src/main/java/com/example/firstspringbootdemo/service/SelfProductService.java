package com.example.firstspringbootdemo.service;

import com.example.firstspringbootdemo.exceptions.ProductNotFoundException;
import com.example.firstspringbootdemo.model.Category;
import com.example.firstspringbootdemo.model.Product;
import com.example.firstspringbootdemo.repository.CategoryRepository;
import com.example.firstspringbootdemo.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    //so far we have created all the layers Controller>service>repository but, we have not linked service and repository
    //we can link them by using dependency injection, so that we can use all the function present in the
    //category and product repository here.
//    private static final Logger log = LoggerFactory.getLogger(SelfProductService.class);
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product createProduct) {
        //now before creating a product first check the product is present or not
        Category cat = categoryRepository.findByTitle(createProduct.getCategory().getTitle());
        if(cat == null) {//means category doesn't exist so create one
            Category newCat = new Category();
            newCat.setTitle(createProduct.getCategory().getTitle());
            Category newRow = categoryRepository.save(newCat);
            createProduct.setCategory(newRow);
        }else{
            //if category already present simply set the product to that title
            createProduct.setCategory(cat);
        }
        return productRepository.save(createProduct);
    }

    @Override
    public List<Product> getAllProducts() {

        return List.of();
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //optional is kind of null check, if we get any response it stores in it or else it gives null
        Optional<Product> p = productRepository.findById(productId);
        //isPresent is an in build method in Optional which checks if the above var is null or not
        if(p.isPresent()) {
            return p.get();
        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public Product updateProduct(Long productId, Product updateProduct) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(productId);
        if(p.isPresent()){
            Product product = p.get();
            Optional<Category> cat = categoryRepository.findById(product.getCategory().getId());
            //not able to update id for product may be coz of annotation I have used to create id
//            product.setId(updateProduct.getId());
            product.setTitle(updateProduct.getTitle());
            product.setDescription(updateProduct.getDescription());
            product.setPrice(updateProduct.getPrice());
            product.setImageUrl(updateProduct.getImageUrl());
            //can also implement if condition here
            if(cat.isPresent()){
                product.setCategory(cat.get());
            }else{
                throw new ProductNotFoundException("Category not found");
            }
            //again insert all the changes in the DB
            return productRepository.save(product);
        }
        throw new ProductNotFoundException("not found");
    }

    @Override
    public List<Product> getProductByCategory(String category) {

        return List.of();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return List.of();
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public String deleteProduct(Long productId) {
        return null;
    }
}

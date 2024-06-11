package com.example.firstspringbootdemo.service;

import com.example.firstspringbootdemo.dto.FakeStoreProductDto;
import com.example.firstspringbootdemo.exceptions.ProductNotFoundException;
import com.example.firstspringbootdemo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    //constructor
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //now we want to implement all the methods from ProductService which is our interface
    //ide provides a shortcut to create all this methods in one click
    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fs = new FakeStoreProductDto();
        fs.setId(product.getId());
        fs.setTitle(product.getTitle());
        fs.setCategory(product.getCategory().getTitle());
        fs.setDescription(product.getDescription());
        fs.setPrice(product.getPrice());
        fs.setImage(product.getImageUrl());

        FakeStoreProductDto response = restTemplate.postForObject(
            "https://fakestoreapi.com/products",
                fs,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNumber) {
        //Here I want all the products so Create a List of FakeStoreProductDto to store all the products
        //getting all the products from fake store converting it to object storing it in the array

        //using Page to get data from DB in selfProductService
//        FakeStoreProductDto[] fs = restTemplate.getForObject(
//                "https://fakestoreapi.com/products",
//                FakeStoreProductDto[].class
//        );
//        //now storing all the products from FakeStoreProductDto[] in to list
//        List<Product> list = new ArrayList<>();
//        for(FakeStoreProductDto fsProductDto : fs){
//            list.add(fsProductDto.toProduct());
//        }
        return null;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        //now this method parse the data from fake store to our product model format which we have define
        FakeStoreProductDto getProduct = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        //whenever we call getSingleProduct if the product id does not exist it will return null
        //means product with productId is not present
        if(getProduct == null){
            throw new ProductNotFoundException("Product not found with id "+productId);
        }
        return getProduct.toProduct();
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        FakeStoreProductDto fs = new FakeStoreProductDto();
        fs.setId(product.getId());
        fs.setTitle(product.getTitle());
        fs.setCategory(product.getCategory().getTitle());
        fs.setDescription(product.getDescription());
        fs.setPrice(product.getPrice());
        fs.setImage(product.getImageUrl());

        restTemplate.put(
                "https://fakestoreapi.com/products/"+productId,
//                fs
                FakeStoreProductDto.class
        );
        return fs.toProduct();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        FakeStoreProductDto[] fs = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/"+category,
                FakeStoreProductDto[].class
        );
        List<Product> list = new ArrayList<>();
        for(FakeStoreProductDto fsProductDto : fs){
//            System.out.print(fsProductDto.toString());
            list.add(fsProductDto.toProduct());
        }
        return list;
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return List.of();
    }

    @Override

    public List<String> getAllCategories() {
//    change the datatype in ProductService and productController before uncommenting
//        String[] fs = restTemplate.getForObject(
//                "https://fakestoreapi.com/products/categories",
//                String[].class
//        );
//        List<Category> list = new ArrayList<>();
//        for(String cat : fs){
//            Category c = new Category();
//            c.setTitle(cat);
//            list.add(c);
//        }
//        return list;
        return List.of();
    }

    //giving error
    @Override
    public String deleteProduct(Long productId) {
        restTemplate.delete(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDto.class
        );
        return "Deleted product with id "+productId;
    }
}

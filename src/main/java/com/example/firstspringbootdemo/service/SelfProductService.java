package com.example.firstspringbootdemo.service;

import com.example.firstspringbootdemo.exceptions.ProductNotFoundException;
import com.example.firstspringbootdemo.model.Category;
import com.example.firstspringbootdemo.model.Product;
import com.example.firstspringbootdemo.repository.CategoryRepository;
import com.example.firstspringbootdemo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<Product> getAllProducts(int pageSize, int pageNumber) {
        //Now here instead of using normal List of products we will be using Page because it comes with a bunch of features in it
        //one can set how many products we want in a page so that the loading period is less when we are dealing with millions of products
        //---------------------we can also sort the product during pagination at the same time, and we can use multiple sorting also
        Page<Product> getAll = productRepository.findAll(PageRequest.of(pageNumber, pageSize,
                                Sort.by("price").and(Sort.by("title"))));
        return getAll;
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
            //insert all the changes in the DB
            return productRepository.save(product);
        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public List<Product> getProductByCategory(String category){
        Category cat = categoryRepository.findByTitle(category);
        return cat.getProducts();
    }

    //not working
    //uncomment the method from ProductController before using it
    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) throws ProductNotFoundException {
        Optional<Category> cat = categoryRepository.findById(categoryId);
        if(cat.isPresent()) {
            return productRepository.getProductsByCategoryId(categoryId);
        }
        throw new ProductNotFoundException("Category not found");
    }

    @Override
    public List<String> getAllCategories() {
        return categoryRepository.findAllCategories();
    }

    @Override
    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "Product with id :"+productId+" deleted successfully";
    }
}

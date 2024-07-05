package com.superMarket.superMarket.service;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import com.superMarket.superMarket.exception.ProductCategoryNotFoundException;
import com.superMarket.superMarket.exception.ProductNotFoundException;
import com.superMarket.superMarket.repo.ProductCategoryRepository;
import com.superMarket.superMarket.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductService(ProductRepository productRepository,ProductCategoryRepository productCategoryRepository)
    {
        this.productRepository=productRepository;
        this.productCategoryRepository=productCategoryRepository;
    }

    public Product createProduct(String name,String description,double price,String productCategory,int quantity,String image)
    {
        ProductCategory pc=productCategoryRepository.findById(productCategory).
                orElseThrow(()->new ProductCategoryNotFoundException("Product Category Not Found"));
        return productRepository.findByName(name).
                orElse(productRepository.save(new Product(name,description,price,pc,quantity,image)));
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public Product create(Product product) {
        ProductCategory pc=productCategoryRepository.findById(product.getProductCategory().getCatId()).
                orElseThrow(()->new ProductCategoryNotFoundException("Product Category Not Found"));
        return productRepository.save(new
                Product(product.getName(),product.getDescription(),product.getPrice(),product.getProductCategory(),product.getQuantity(),product.getImage()));
    }

    public Product modifyProduct(int id,Product product)
    {
        Product p=productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product ID not found!!"));
        p.setQuantity(product.getQuantity());
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setProductCategory(product.getProductCategory());
        productRepository.save(p);
        return p;
    }

    public List<Product> getProductByCategory(@PathVariable String productCategory) {
        ProductCategory pc=productCategoryRepository.findById(productCategory).
                orElseThrow(()->new ProductCategoryNotFoundException("Product Category not found"));
        return productRepository.findByProductCategory(pc);
    }
}

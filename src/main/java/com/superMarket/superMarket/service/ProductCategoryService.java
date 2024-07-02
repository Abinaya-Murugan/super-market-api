package com.superMarket.superMarket.service;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import com.superMarket.superMarket.repo.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    ProductCategoryService(ProductCategoryRepository productCategoryRepository)
    {
        this.productCategoryRepository=productCategoryRepository;
    }

    public ProductCategory create(String catId,String name,String description)
    {
        return productCategoryRepository.findById(catId).
                orElse(productCategoryRepository.save(new ProductCategory(catId,name,description)));
    }

    public List<ProductCategory> getAllOrders() {
        return (List<ProductCategory>) productCategoryRepository.findAll();
    }

    public ProductCategory create(ProductCategory productCategory)
    {
        return productCategoryRepository.findById(productCategory.getCatId()).
                orElse(productCategoryRepository.
                        save(new ProductCategory(productCategory.getCatId(),productCategory.getName(),productCategory.getDescription())));
    }
}

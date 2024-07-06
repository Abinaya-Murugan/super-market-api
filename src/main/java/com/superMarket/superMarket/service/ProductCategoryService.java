package com.superMarket.superMarket.service;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import com.superMarket.superMarket.exception.ProductNotFoundException;
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

    public ProductCategory create(String catId,String name,String description,String image)
    {
        return productCategoryRepository.findById(catId).
                orElse(productCategoryRepository.save(new ProductCategory(catId,name,description,image)));
    }

    public List<ProductCategory> getAllOrders() {
        return (List<ProductCategory>) productCategoryRepository.findAll();
    }

    public ProductCategory create(ProductCategory productCategory)
    {
        return productCategoryRepository.findById(productCategory.getCatId()).
                orElse(productCategoryRepository.
                        save(new ProductCategory(productCategory.getCatId(),productCategory.getName(),productCategory.getDescription(),productCategory.getImage())));
    }

    public ProductCategory modifyProductCategory(String id, ProductCategory prod) {
        ProductCategory pc=productCategoryRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Product Category Not Found"));
        pc.setDescription(prod.getDescription());
        pc.setName(prod.getName());
        productCategoryRepository.save(pc);
        return pc;
    }

}

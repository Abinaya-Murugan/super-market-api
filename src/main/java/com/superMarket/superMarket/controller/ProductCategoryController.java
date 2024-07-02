package com.superMarket.superMarket.controller;

import com.superMarket.superMarket.domain.ProductCategory;
import com.superMarket.superMarket.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    ProductCategoryService productCategoryService;

    ProductCategoryController(ProductCategoryService productCategoryService)
    {
        this.productCategoryService=productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllOrders() {
        List<ProductCategory> orders = productCategoryService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory)
    {
        return ResponseEntity.ok(productCategoryService.create(productCategory));
    }

}

package com.superMarket.superMarket.controller;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import com.superMarket.superMarket.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://192.168.1.3:3000"})
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

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> modifyProductCategory(@PathVariable String id,@RequestBody ProductCategory prod) {
        return ResponseEntity.ok(productCategoryService.modifyProductCategory(id,prod));
    }

}

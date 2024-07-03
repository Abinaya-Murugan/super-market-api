package com.superMarket.superMarket.controller;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import com.superMarket.superMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    ProductController(ProductService productService)
    {
        this.productService=productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllOrders() {
        List<Product> orders = productService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<Product> createProductCategory(@RequestBody Product product)
    {
        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> modifyProduct(@PathVariable int id, @RequestBody Product prod) {
        return ResponseEntity.ok(productService.modifyProduct(id,prod));
    }

}

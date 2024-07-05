package com.superMarket.superMarket.controller;

import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.domain.ProductCategory;
import com.superMarket.superMarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://192.168.1.3:3000"})
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
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{productCategory}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String productCategory)
    {
        List<Product> products = productService.getProductByCategory(productCategory);
        return ResponseEntity.ok(products);
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

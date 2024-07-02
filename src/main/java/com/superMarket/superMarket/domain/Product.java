package com.superMarket.superMarket.domain;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    int productId;

    @Column(length = 1000)
    String name;

    @Column(length = 2000)
    String description;

    @Column
    double price;

    @ManyToOne
    ProductCategory productCategory;

    @Column
    int quantity;

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(String name, String description, double price, ProductCategory productCategory, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productCategory = productCategory;
        this.quantity=quantity;
    }

    protected Product() {
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}

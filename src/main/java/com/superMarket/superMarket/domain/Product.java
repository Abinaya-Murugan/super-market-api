package com.superMarket.superMarket.domain;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "id")
    int id;

    @Column(length = 1000)
    String name;

    @Column(length = 2000)
    String description;

    @Column
    double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    ProductCategory categoryId;

    @Column
    int quantity;

    @Column
    String image;

    @Column
    boolean isOnDiscount;

    @Column
    double newPrice;

    public int getProductId() {
        return id;
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
        this.id = productId;
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

    public Product(String name, String description, double price, ProductCategory productCategory, int quantity,String image,boolean onDiscount,double newPrice) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = productCategory;
        this.quantity=quantity;
        this.image=image;
        this.isOnDiscount=onDiscount;
        this.newPrice=newPrice;
    }

    protected Product() {
    }

    public ProductCategory getProductCategory() {
        return categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.categoryId = productCategory;
    }

    public boolean isOnDiscount() {
        return isOnDiscount;
    }

    public void setOnDiscount(boolean onDiscount) {
        this.isOnDiscount = onDiscount;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
}

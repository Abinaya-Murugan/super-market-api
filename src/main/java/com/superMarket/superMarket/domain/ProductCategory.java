package com.superMarket.superMarket.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ProductCategory {

    @Id
    private String catId;

    @Column(length = 1000)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCatId() {
        return catId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory(String catId, String name, String description,String image) {
        this.catId = catId;
        this.name = name;
        this.description = description;
        this.image=image;
    }

    protected ProductCategory() {
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

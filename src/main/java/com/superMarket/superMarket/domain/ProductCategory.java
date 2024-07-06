package com.superMarket.superMarket.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ProductCategory {

    @Id
    @Column(name = "id")
    private String id;

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
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setCatId(String catId) {
        this.id = catId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory(String catId, String name, String description,String image) {
        this.id = catId;
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

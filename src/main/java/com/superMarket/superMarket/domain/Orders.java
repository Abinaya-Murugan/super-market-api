package com.superMarket.superMarket.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    int id;

    @Column
    List<String> products;

    @Column
    double total;


    public void setTotal(double total) {
        this.total = total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public Orders(List<String> products) {
        this.products = products;
    }

    public Orders(List<String> products,double price) {
        this.products = products;
        this.total=price;
    }


    protected Orders() {
    }
}

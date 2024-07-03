package com.superMarket.superMarket.service;

import com.superMarket.superMarket.domain.Orders;
import com.superMarket.superMarket.domain.Product;
import com.superMarket.superMarket.exception.ProductNotAvailableException;
import com.superMarket.superMarket.exception.ProductNotFoundException;
import com.superMarket.superMarket.repo.OrdersRepository;
import com.superMarket.superMarket.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class OrdersService {

    OrdersRepository ordersRepository;

    ProductRepository productRepository;

    @Autowired
    OrdersService(OrdersRepository ordersRepository,ProductRepository productRepository)
    {
        this.ordersRepository=ordersRepository;
        this.productRepository=productRepository;
    }

    public Orders create(Orders orders)
    {
        double total=0;
        for(String pr:orders.getProducts())
        {
            Product p=productRepository.findByName(pr).
                    orElseThrow(()->new ProductNotFoundException("Product "+pr+" Not Found in our Market!!"));
            if(p.getQuantity()==0)
                throw new ProductNotAvailableException("Product "+pr+" is not in stock now!!");
            p.setQuantity(p.getQuantity()-1);
            total+=p.getPrice();
        }
        return ordersRepository.save(new Orders(orders.getProducts(),total));
    }

    public List<Orders> getOrders()
    {
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders modifyProduct(int id, Orders orders) {
        Orders o=ordersRepository.findById(id).
                orElseThrow(()->new RuntimeException("Order "+id+" Not Found in our Market!!"));
        o.setProducts(orders.getProducts());
        double total=0.0;
        for(String pr:orders.getProducts())
        {
            Product p=productRepository.findByName(pr).
                    orElseThrow(()->new ProductNotFoundException("Product "+pr+" Not Found in our Market!!"));
            if(p.getQuantity()==0)
                throw new ProductNotAvailableException("Product "+pr+" is not in stock now!!");
            p.setQuantity(p.getQuantity()-1);
            total+=p.getPrice();
        }
        o.setTotal(total);
        ordersRepository.save(o);
        return o;
    }
}

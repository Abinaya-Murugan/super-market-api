package com.superMarket.superMarket.controller;

import com.superMarket.superMarket.domain.Orders;
import com.superMarket.superMarket.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","https://192.168.1.3:3000"})
@RequestMapping("/orders")
public class OrderController {
    private final OrdersService ordersService;

    @Autowired
    public OrderController(OrdersService orderService) {
        this.ordersService = orderService;
    }

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        return ResponseEntity.ok(ordersService.create(order));
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getOrders()
    {
        return ResponseEntity.ok(ordersService.getOrders());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> modifyOrders(@PathVariable int id, @RequestBody Orders orders)
    {
        return ResponseEntity.ok(ordersService.modifyProduct(id,orders));
    }
}

package com.samuel.webservices.services;

import com.samuel.webservices.entities.Order;
import com.samuel.webservices.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        List<Order> list = repository.findAll();
        return list;
    }

    public Order findById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return order;
    }
}

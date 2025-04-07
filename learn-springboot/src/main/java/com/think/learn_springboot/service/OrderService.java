package com.think.learn_springboot.service;

import com.think.learn_springboot.entity.Order;
import com.think.learn_springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public Order createOrder(Order order) {
       return orderRepository.save(order);
    }

}

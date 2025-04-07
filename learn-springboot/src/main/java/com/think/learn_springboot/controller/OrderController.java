package com.think.learn_springboot.controller;

import com.think.learn_springboot.dto.OrderRequestDTO;
import com.think.learn_springboot.dto.OrderResponseDTO;
import com.think.learn_springboot.entity.Order;
import com.think.learn_springboot.mapper.OrderMapper;
import com.think.learn_springboot.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    // Create Order
    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO requestDTO) {
        Order order = orderMapper.toEntity(requestDTO); // Convert DTO to entity
        Order savedOrder = orderService.createOrder(order); // Save to DB
        OrderResponseDTO responseDTO = orderMapper.toResponseDTO(savedOrder); // Convert to response DTO

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}

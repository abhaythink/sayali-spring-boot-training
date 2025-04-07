package com.think.learn_springboot.mapper;

import com.think.learn_springboot.dto.OrderRequestDTO;
import com.think.learn_springboot.dto.OrderResponseDTO;
import com.think.learn_springboot.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequestDTO dto) {
        Order order = new Order();
        order.setProductId(dto.getProductId());
        order.setProductName(dto.getProductName());
        order.setDescription(dto.getDescription());
        order.setPrice(dto.getPrice());
        return order;
    }

    public OrderResponseDTO toResponseDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setOrderId(order.getOrderId());
        dto.setProductId(order.getProductId());
        dto.setProductName(order.getProductName());
        dto.setDescription(order.getDescription());
        dto.setPrice(order.getPrice());
        return dto;
    }
}

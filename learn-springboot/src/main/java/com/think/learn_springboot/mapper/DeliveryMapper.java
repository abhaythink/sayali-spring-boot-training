package com.think.learn_springboot.mapper;

import com.think.learn_springboot.dto.DeliveryRequestDTO;
import com.think.learn_springboot.dto.DeliveryResponseDTO;
import com.think.learn_springboot.entity.Delivery;
import com.think.learn_springboot.entity.DeliveryStatus;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {

    public Delivery toEntity(DeliveryRequestDTO dto) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(dto.getOrderId());
        delivery.setProductId(dto.getProductId());
        delivery.setDeliveryDate(dto.getDeliveryDate());
        delivery.setDeliveryStatus(DeliveryStatus.SCHEDULED); // default status
        return delivery;
    }

    public DeliveryResponseDTO toResponseDTO(Delivery delivery) {
        DeliveryResponseDTO dto = new DeliveryResponseDTO();
        dto.setOrderId(delivery.getOrderId());
        dto.setProductId(delivery.getProductId());
        dto.setDeliveryDate(delivery.getDeliveryDate());
        dto.setDeliveryStatus(delivery.getDeliveryStatus());
        return dto;
    }
}


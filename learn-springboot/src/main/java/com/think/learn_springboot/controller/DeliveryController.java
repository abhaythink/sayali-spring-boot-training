package com.think.learn_springboot.controller;

import com.think.learn_springboot.dto.DeliveryRequestDTO;
import com.think.learn_springboot.dto.DeliveryResponseDTO;
import com.think.learn_springboot.entity.Delivery;
import com.think.learn_springboot.error.ResourceNotFoundException;
import com.think.learn_springboot.mapper.DeliveryMapper;
import com.think.learn_springboot.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class DeliveryController {

    private final DeliveryService deliveryService;
    private final DeliveryMapper deliveryMapper;

    @Autowired
    public DeliveryController(DeliveryService deliveryService, DeliveryMapper deliveryMapper) {
        this.deliveryService = deliveryService;
        this.deliveryMapper = deliveryMapper;
    }

    @PatchMapping
    public ResponseEntity<DeliveryResponseDTO> scheduleDelivery(@Valid @RequestBody DeliveryRequestDTO requestDTO) throws ResourceNotFoundException {
        Delivery delivery = deliveryMapper.toEntity(requestDTO);
        Delivery savedDelivery = deliveryService.scheduleDelivery(delivery);
        DeliveryResponseDTO responseDTO = deliveryMapper.toResponseDTO(savedDelivery);
        return ResponseEntity.ok(responseDTO);
    }
}

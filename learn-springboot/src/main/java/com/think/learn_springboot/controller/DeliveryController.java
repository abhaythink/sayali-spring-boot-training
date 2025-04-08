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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService, DeliveryMapper deliveryMapper) {
        this.deliveryService = deliveryService;
    }

}

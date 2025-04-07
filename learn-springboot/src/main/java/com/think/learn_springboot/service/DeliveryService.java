package com.think.learn_springboot.service;

import com.think.learn_springboot.entity.Delivery;
import com.think.learn_springboot.error.ResourceNotFoundException;
import com.think.learn_springboot.repository.DeliveryRepository;
import com.think.learn_springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;
    public Delivery scheduleDelivery(Delivery delivery) throws ResourceNotFoundException {
        if (!orderRepository.existsById(delivery.getOrderId())) {
            throw new ResourceNotFoundException("Order not found");
        }

        if (delivery.getDeliveryDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Delivery date must be in the future");
        }


        return deliveryRepository.save(delivery);
    }

    public Optional<Delivery> getDeliveryByOrderId(Long orderId){
        return deliveryRepository.findByOrderId(orderId);
    }

}

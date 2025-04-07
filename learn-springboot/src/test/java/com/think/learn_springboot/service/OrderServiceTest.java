package com.think.learn_springboot.service;

import com.think.learn_springboot.entity.Order;
import com.think.learn_springboot.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testCreateOrder() {

        Order inputOrder = new Order();
        inputOrder.setOrderId(1L);
        inputOrder.setProductId("P123");
        inputOrder.setProductName("Phone");
        inputOrder.setDescription("Smartphone");
        inputOrder.setPrice(699.99);

        when(orderRepository.save(any(Order.class))).thenReturn(inputOrder);

        Order savedOrder = orderService.createOrder(inputOrder);

        // Assert
        assertNotNull(savedOrder);
        assertEquals(1L, savedOrder.getOrderId());
        assertEquals("P123", savedOrder.getProductId());
        assertEquals("Phone", savedOrder.getProductName());
        assertEquals("Smartphone", savedOrder.getDescription());
        assertEquals(699.99, savedOrder.getPrice());
        verify(orderRepository, times(1)).save(inputOrder);

    }

}
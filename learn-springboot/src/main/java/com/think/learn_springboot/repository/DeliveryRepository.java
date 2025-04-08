package com.think.learn_springboot.repository;

import com.think.learn_springboot.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    Optional<Delivery> findByOrderId(Long orderId);

}

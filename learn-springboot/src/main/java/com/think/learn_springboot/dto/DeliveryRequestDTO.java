package com.think.learn_springboot.dto;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryRequestDTO {
    private Long orderId;
    private String productId;
    @Future
    private LocalDate deliveryDate;

}

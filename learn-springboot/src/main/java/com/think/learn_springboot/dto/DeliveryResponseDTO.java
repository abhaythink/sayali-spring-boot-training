package com.think.learn_springboot.dto;

import com.think.learn_springboot.entity.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryResponseDTO {
    private Long orderId;
    private String productId;
    private LocalDate deliveryDate;
    private DeliveryStatus deliveryStatus;

}

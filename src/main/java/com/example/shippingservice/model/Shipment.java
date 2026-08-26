package com.example.shippingservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    private Long id;
    private Long orderId;
    private String shippingAddress;
    private String status;
    private LocalDateTime createdAt;
}

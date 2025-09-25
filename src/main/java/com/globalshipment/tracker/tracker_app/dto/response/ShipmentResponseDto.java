package com.globalshipment.tracker.tracker_app.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShipmentResponseDto {

    private String trackingNumber;
    private String origin;
    private String destination;
    private BigDecimal cost;
    private String status;
    private LocalDateTime createdAt;
    private Long userId;


}

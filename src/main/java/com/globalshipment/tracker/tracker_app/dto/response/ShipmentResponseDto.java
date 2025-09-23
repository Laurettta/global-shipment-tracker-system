package com.globalshipment.tracker.tracker_app.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShipmentResponseDto {

    private String trackingNumber;
    private String origin;
    private String destination;
    private BigDecimal cost;
    private String status;


}

package com.globalshipment.tracker.tracker_app.dto.request;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class ShipmentRequestDto {

    private String trackingNumber;
    private String origin;
    private String destination;
    private BigDecimal cost;
    private Long userId;
}

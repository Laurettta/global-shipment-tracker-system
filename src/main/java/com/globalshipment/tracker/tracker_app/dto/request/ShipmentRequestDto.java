package com.globalshipment.tracker.tracker_app.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class ShipmentRequestDto {

    @NotBlank
    private String trackingNumber;

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    @NotNull
    private BigDecimal cost;

    @NotNull
    private Long userId;
}

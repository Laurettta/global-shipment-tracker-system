package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.ShipmentRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.ShipmentResponseDto;

import java.util.List;


public interface ShipmentService {
    ShipmentResponseDto createShipment(ShipmentRequestDto request);

    ShipmentResponseDto getShipmentByTrackingNumber(String trackingNumber);

    List<ShipmentResponseDto> getAllShipments();
}

package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.ShipmentRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.ShipmentResponseDto;
import com.globalshipment.tracker.tracker_app.model.Shipment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public interface ShipmentService {
    ShipmentResponseDto createShipment(ShipmentRequestDto request);

    ShipmentResponseDto getShipmentByTrackingNumber(String trackingNumber);


}

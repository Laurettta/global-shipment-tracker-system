package com.globalshipment.tracker.tracker_app.controller;

import com.globalshipment.tracker.tracker_app.dto.request.ShipmentRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.ShipmentResponseDto;
import com.globalshipment.tracker.tracker_app.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;


    @PostMapping
    public ShipmentResponseDto createShipment(@RequestBody ShipmentRequestDto request) {
        return shipmentService.createShipment(request);
    }

    @GetMapping("/{trackingNumber}")
    public ShipmentResponseDto getShipment(@PathVariable String trackingNumber) {
        return shipmentService.getShipmentByTrackingNumber(trackingNumber);
    }
}

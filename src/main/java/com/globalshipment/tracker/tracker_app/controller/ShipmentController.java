package com.globalshipment.tracker.tracker_app.controller;

import com.globalshipment.tracker.tracker_app.dto.request.ShipmentRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.ShipmentResponseDto;
import com.globalshipment.tracker.tracker_app.service.ShipmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@RequiredArgsConstructor
public class ShipmentController {

    private final ShipmentService shipmentService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShipmentResponseDto createShipment(@RequestBody @Valid ShipmentRequestDto request) {
        return shipmentService.createShipment(request);
    }

    @GetMapping
    public List<ShipmentResponseDto> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/{trackingNumber}")
    public ShipmentResponseDto getShipment(@PathVariable String trackingNumber) {
        return shipmentService.getShipmentByTrackingNumber(trackingNumber);
    }
}

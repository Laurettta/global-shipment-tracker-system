package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.ShipmentRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.ShipmentResponseDto;
import com.globalshipment.tracker.tracker_app.mapper.ShipmentMapper;
import com.globalshipment.tracker.tracker_app.model.Shipment;
import com.globalshipment.tracker.tracker_app.model.User;
import com.globalshipment.tracker.tracker_app.repository.ShipmentRepository;
import com.globalshipment.tracker.tracker_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService{

    private final ShipmentRepository shipmentRepository;
    private final UserRepository userRepository;


    @Override
    public ShipmentResponseDto createShipment(ShipmentRequestDto request) {
        // 1. Fetch the user from DB
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        // 2. Convert DTO → Entity (without user)
        Shipment shipment = ShipmentMapper.toEntity(request);

        // 3. Set the user on the shipment entity
        shipment.setUser(user);
        shipment.setCreatedAt(LocalDateTime.now());

        // 4. Save to DB
        Shipment savedShipment = shipmentRepository.save(shipment);

        // 5. Convert entity → response DTO
        return ShipmentMapper.toResponseDto(savedShipment);
    }

    @Override
    public List<ShipmentResponseDto> getAllShipments() {
        return shipmentRepository.findAll()
                .stream()
                .map(ShipmentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShipmentResponseDto getShipmentByTrackingNumber(String trackingNumber) {
        // 1. Find the shipment entity by tracking number
        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(()-> new RuntimeException("Shipment not found"));

        // 2. Convert entity to DTO
        return ShipmentMapper.toResponseDto(shipment);

    }
}

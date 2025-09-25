package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.TrackingEventRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.TrackingEventResponseDto;
import com.globalshipment.tracker.tracker_app.mapper.TrackingEventMapper;
import com.globalshipment.tracker.tracker_app.model.Shipment;
import com.globalshipment.tracker.tracker_app.model.TrackingEvent;
import com.globalshipment.tracker.tracker_app.repository.ShipmentRepository;
import com.globalshipment.tracker.tracker_app.repository.TrackingEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrackingEventServiceImpl implements TrackingEventService{

    private final TrackingEventRepository trackingEventRepository;
    private final ShipmentRepository shipmentRepository;


    @Override
    public TrackingEventResponseDto addEvent(String trackingNumber, TrackingEventRequestDto requestDto){
        // 1. Fetch shipment by tracking number
        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        // 2. Convert DTO to entity
        TrackingEvent event = TrackingEventMapper.toEntity(requestDto);

        // 3. Assign shipment and timestamp
        event.setShipment(shipment);
        event.setTimestamp(LocalDateTime.now());

        // 4. Save event
        TrackingEvent saved = trackingEventRepository.save(event);

        // 5. Convert entity to response DTO
        return TrackingEventMapper.toResponseDto(saved);
    }

    @Override
    public List<TrackingEventResponseDto> getAllEvents(String trackingNumber){
        // 1. Fetch shipment by tracking number instead of ID
        Shipment shipment = shipmentRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        // 2. Get all events for that shipment and convert to DTO
        return shipment.getEvents()
                .stream()
                .map(TrackingEventMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}

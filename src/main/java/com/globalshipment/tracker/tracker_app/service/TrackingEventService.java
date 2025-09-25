package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.TrackingEventRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.TrackingEventResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface TrackingEventService {
    TrackingEventResponseDto addEvent(@Valid String trackingNumber, TrackingEventRequestDto requestDto);

    List<TrackingEventResponseDto> getAllEvents(String trackingNumber);
}

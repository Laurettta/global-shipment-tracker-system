package com.globalshipment.tracker.tracker_app.controller;


import com.globalshipment.tracker.tracker_app.dto.request.TrackingEventRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.TrackingEventResponseDto;
import com.globalshipment.tracker.tracker_app.service.TrackingEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments/{trackingNumber}/events")
@RequiredArgsConstructor
public class TrackingEventController {

    private final TrackingEventService trackingEventService;


    @PostMapping
    public TrackingEventResponseDto addEvent(
            @PathVariable String trackingNumber,
            @RequestParam @Valid TrackingEventRequestDto requestDto){

        return trackingEventService.addEvent(trackingNumber, requestDto);
    }

    @GetMapping
    public List<TrackingEventResponseDto> getAllEvents(
            @PathVariable String trackingNumber){
        return trackingEventService.getAllEvents(trackingNumber);
    }

}

package com.globalshipment.tracker.tracker_app.mapper;

import com.globalshipment.tracker.tracker_app.dto.request.TrackingEventRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.TrackingEventResponseDto;
import com.globalshipment.tracker.tracker_app.model.TrackingEvent;

public class TrackingEventMapper {

    public static TrackingEvent toEntity(TrackingEventRequestDto requestDto){
        TrackingEvent event = new TrackingEvent();
        event.setStatus(requestDto.getStatus());
        return event;
    }

    public static TrackingEventResponseDto toResponseDto(TrackingEvent event){
        TrackingEventResponseDto responseDto = new TrackingEventResponseDto();
        responseDto.setId(event.getId());
        responseDto.setStatus(event.getStatus());
        responseDto.setTimestamp(event.getTimestamp());
        return responseDto;
    }
}

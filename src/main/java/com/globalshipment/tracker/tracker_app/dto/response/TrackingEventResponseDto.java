package com.globalshipment.tracker.tracker_app.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrackingEventResponseDto {

    private Long id;
    private String status;
    private LocalDateTime timestamp;
}

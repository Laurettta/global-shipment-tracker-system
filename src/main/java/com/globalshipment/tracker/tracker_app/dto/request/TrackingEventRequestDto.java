package com.globalshipment.tracker.tracker_app.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TrackingEventRequestDto {

    @NotBlank
    private String status;
}

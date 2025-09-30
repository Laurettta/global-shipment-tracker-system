package com.globalshipment.tracker.tracker_app.dto.response;

import lombok.Data;

@Data
public class AuthResponseDto {

    private String token;
    private String email;
    private String role;
}

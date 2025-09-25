package com.globalshipment.tracker.tracker_app.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDto {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;
}

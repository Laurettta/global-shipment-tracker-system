package com.globalshipment.tracker.tracker_app.controller;

import com.globalshipment.tracker.tracker_app.dto.request.LoginRequestDto;
import com.globalshipment.tracker.tracker_app.dto.request.SignupRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.AuthResponseDto;
import com.globalshipment.tracker.tracker_app.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponseDto signup(@RequestBody @Valid SignupRequestDto signupRequest) {
        return authService.signup(signupRequest);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody @Valid LoginRequestDto loginRequest) {
        return authService.login(loginRequest);
    }
}

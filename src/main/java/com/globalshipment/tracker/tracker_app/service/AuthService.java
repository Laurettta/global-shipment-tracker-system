package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.LoginRequestDto;
import com.globalshipment.tracker.tracker_app.dto.request.SignupRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.AuthResponseDto;

public interface AuthService {

    AuthResponseDto signup(SignupRequestDto signupRequest);
    AuthResponseDto login(LoginRequestDto loginRequest);
}

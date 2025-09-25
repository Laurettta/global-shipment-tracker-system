package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.UserRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.UserResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(@Valid UserRequestDto requestDto);

    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(Long id);
}

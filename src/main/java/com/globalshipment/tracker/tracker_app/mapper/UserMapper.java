package com.globalshipment.tracker.tracker_app.mapper;

import com.globalshipment.tracker.tracker_app.dto.request.SignupRequestDto;
import com.globalshipment.tracker.tracker_app.dto.request.UserRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.AuthResponseDto;
import com.globalshipment.tracker.tracker_app.dto.response.UserResponseDto;
import com.globalshipment.tracker.tracker_app.enums.Role;
import com.globalshipment.tracker.tracker_app.model.User;

public class UserMapper {

    // 2️⃣ For signup/login (authentication)
    public static User toEntity(SignupRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // password exists in SignupRequestDto
        user.setRole(Role.USER); // default role
        return user;
    }

    public static User toEntity(UserRequestDto requestDto){
        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        return user;
    }

    public static UserResponseDto toResponseDto(User user){
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setEmail(user.getEmail());
        responseDto.setRole(user.getRole() != null ? user.getRole().name() : null);
        return responseDto;
    }

    public static AuthResponseDto toAuthResponseDto(User user, String token) {
        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        return response;
    }
}

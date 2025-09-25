package com.globalshipment.tracker.tracker_app.mapper;

import com.globalshipment.tracker.tracker_app.dto.request.UserRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.UserResponseDto;
import com.globalshipment.tracker.tracker_app.model.User;

public class UserMapper {

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
        return responseDto;
    }
}

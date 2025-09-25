package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.UserRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.UserResponseDto;
import com.globalshipment.tracker.tracker_app.mapper.UserMapper;
import com.globalshipment.tracker.tracker_app.model.User;
import com.globalshipment.tracker.tracker_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public UserResponseDto createUser(UserRequestDto requestDto){
        User user = UserMapper.toEntity(requestDto);
        User saved = userRepository.save(user);
        return UserMapper.toResponseDto(saved);
    }

    @Override
    public List<UserResponseDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper ::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toResponseDto(user);
    }
}

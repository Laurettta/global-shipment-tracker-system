package com.globalshipment.tracker.tracker_app.controller;

import com.globalshipment.tracker.tracker_app.dto.request.UserRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.UserResponseDto;
import com.globalshipment.tracker.tracker_app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private  final UserService userService;


    @PostMapping
    public UserResponseDto create(@RequestBody @Valid UserRequestDto requestDto){
         return userService.createUser(requestDto);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

}

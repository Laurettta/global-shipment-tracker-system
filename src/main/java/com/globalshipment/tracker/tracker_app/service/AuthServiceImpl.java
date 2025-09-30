package com.globalshipment.tracker.tracker_app.service;

import com.globalshipment.tracker.tracker_app.dto.request.LoginRequestDto;
import com.globalshipment.tracker.tracker_app.dto.request.SignupRequestDto;
import com.globalshipment.tracker.tracker_app.dto.response.AuthResponseDto;
import com.globalshipment.tracker.tracker_app.mapper.UserMapper;
import com.globalshipment.tracker.tracker_app.model.User;
import com.globalshipment.tracker.tracker_app.repository.UserRepository;
import com.globalshipment.tracker.tracker_app.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthResponseDto signup(SignupRequestDto signupRequest) {
        if(userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user = UserMapper.toEntity(signupRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // hash password
        userRepository.save(user);

        String token = jwtTokenProvider.generateToken(user.getEmail());
        return UserMapper.toAuthResponseDto(user, token);
    }

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail());
        return UserMapper.toAuthResponseDto(user, token);
    }


}

package com.miu.ansuman.assignment.first.lab.service;

import com.miu.ansuman.assignment.first.lab.dto.input.LoginRequest;
import com.miu.ansuman.assignment.first.lab.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
//    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

package com.miu.ansuman.assignment.first.lab.controller;

import com.miu.ansuman.assignment.first.lab.dto.input.LoginRequest;
import com.miu.ansuman.assignment.first.lab.dto.response.LoginResponse;
import com.miu.ansuman.assignment.first.lab.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
    }
}

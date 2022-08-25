package com.example.helpstudent.controller;


import com.example.helpstudent.dto.ApiResponse;
import com.example.helpstudent.dto.RegisterForm;
import com.example.helpstudent.service.authService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class authController {

    private final authService authservice;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm) {
        authservice.register(registerForm);
        return ResponseEntity.status(201).body(new ApiResponse("New user register !", 201));

    }



}
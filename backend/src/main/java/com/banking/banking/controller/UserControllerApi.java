package com.banking.banking.controller;

import com.banking.banking.request.LoginRequest;
import com.banking.banking.request.RegisterRequest;
import com.banking.banking.response.LoginResponse;
import com.banking.banking.response.SuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserControllerApi {

    @PostMapping("/register")
    ResponseEntity<SuccessResponse<Void>> registerUser(@Valid @RequestBody RegisterRequest registerRequest);

    @PostMapping("/login")
    ResponseEntity<SuccessResponse<LoginResponse>> loginUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse httpServletResponse);

    @GetMapping("/me")
    ResponseEntity<SuccessResponse<LoginResponse>> me();

    @GetMapping("/logout")
    ResponseEntity<SuccessResponse<Void>> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);
}

package com.banking.banking.controller;

import com.banking.banking.request.LoginRequest;
import com.banking.banking.request.RegisterRequest;
import com.banking.banking.response.LoginResponse;
import com.banking.banking.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "User", description = "User authentication and registration operations")
public interface UserControllerApi {
    @Operation(summary = "Register a new user", description = "Registers a new user with the provided details")
    @PostMapping("/register")
    ResponseEntity<SuccessResponse<Void>> registerUser(
            @Parameter(description = "User registration data", required = true)
            @Valid @RequestBody RegisterRequest registerRequest
    );

    @Operation(summary = "Login user", description = "Authenticates the user and returns a login response with tokens or session info")
    @PostMapping("/login")
    ResponseEntity<SuccessResponse<LoginResponse>> loginUser(
            @Parameter(description = "User login credentials", required = true)
            @Valid @RequestBody LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    );

    @Operation(summary = "Get current logged-in user info", description = "Returns information about the currently authenticated user")
    @GetMapping("/me")
    ResponseEntity<SuccessResponse<LoginResponse>> me();

    @Operation(summary = "Logout current user", description = "Logs out the current user and invalidates the session or token")
    @GetMapping("/logout")
    ResponseEntity<SuccessResponse<Void>> logout(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    );
}
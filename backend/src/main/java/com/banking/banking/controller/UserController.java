package com.banking.banking.controller;


import com.banking.banking.mapper.UserMapper;
import com.banking.banking.model.User;
import com.banking.banking.request.LoginRequest;
import com.banking.banking.request.RegisterRequest;
import com.banking.banking.response.LoginResponse;
import com.banking.banking.response.SuccessResponse;
import com.banking.banking.service.AuthenticationService;
import com.banking.banking.service.UserDetailsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController implements UserControllerApi{
    private final UserDetailsService userDetailsService;
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public UserController(UserDetailsService userDetailsService, AuthenticationService authenticationService, UserMapper userMapper) {
        this.userDetailsService = userDetailsService;
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> registerUser(RegisterRequest registerRequest) {
        User user = userMapper.toUserFromRegisterRequest(registerRequest);
        userDetailsService.createUser(user);
        return ResponseEntity.ok(new SuccessResponse<>(null,"Registration successful", HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SuccessResponse<LoginResponse>> loginUser(LoginRequest loginRequest, HttpServletResponse httpServletResponse) {
        LoginResponse loginResponse = authenticationService.login(loginRequest, httpServletResponse);

        return ResponseEntity.ok(new SuccessResponse<>(loginResponse, "Login successful", HttpStatus.OK.value()));
    }
}

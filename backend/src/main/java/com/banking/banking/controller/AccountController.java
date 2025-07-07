package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.AccountRequest;
import com.banking.banking.response.SuccessResponse;
import com.banking.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController implements AccountControllerApi{
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<SuccessResponse<AccountDto>> createAccount(AccountRequest accountRequest) {
        return ResponseEntity.ok().body(new SuccessResponse<>(accountService.create(accountRequest),"Account created successfully", HttpStatus.OK.value()));
    }
}

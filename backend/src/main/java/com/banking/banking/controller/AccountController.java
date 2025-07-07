package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.AccountRequest;
import com.banking.banking.response.SuccessResponse;
import com.banking.banking.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountControllerApi{
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<SuccessResponse<AccountDto>> createAccount(AccountRequest accountRequest) {
        AccountDto accountDto = accountService.create(accountRequest);
        return null;
    }
}

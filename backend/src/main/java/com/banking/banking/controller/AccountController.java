package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.AccountCreateRequest;
import com.banking.banking.request.AccountSearchRequest;
import com.banking.banking.response.SuccessResponse;
import com.banking.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountController implements AccountControllerApi{
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<SuccessResponse<AccountDto>> createAccount(AccountCreateRequest accountRequest) {
        return ResponseEntity.ok().body(new SuccessResponse<>(accountService.create(accountRequest),"Account created successfully", HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SuccessResponse<List<AccountDto>>> searchAccounts(AccountSearchRequest searchRequest) {
        return ResponseEntity.ok(new SuccessResponse<>(accountService.searchAccounts(searchRequest),null, HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> deleteAccount(UUID id) {
        accountService.delete(id);
        return ResponseEntity.ok(new SuccessResponse<>(null,"Deleted account successfully", HttpStatus.OK.value()));
    }
}

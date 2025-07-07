package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.AccountRequest;
import com.banking.banking.response.SuccessResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

public interface AccountControllerApi {

    @PostMapping
    ResponseEntity<SuccessResponse<AccountDto>> createAccount(@Valid @RequestBody AccountRequest accountRequest);

    /*@PostMapping(value = "/api/accounts")
    ResponseEntity<List<AccountResponse>> searchAccounts(@RequestBody AccountSearchRequest searchRequest);

    @PutMapping("/api/accounts/{id}")
    ResponseEntity<?> updateAccount(@PathVariable("id") Long id, @RequestBody AccountRequest accountRequest);

    // 4. Delete Account
    @DeleteMapping("/api/accounts/{id}")
    ResponseEntity<?> deleteAccount(@PathVariable("id") Long id);

    // 5. View Account Details
    @GetMapping("/api/accounts/{id}")
    ResponseEntity<AccountDetailResponse> getAccountDetails(@PathVariable("id") Long id);*/
}


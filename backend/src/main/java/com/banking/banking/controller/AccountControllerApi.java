package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.AccountCreateRequest;
import com.banking.banking.request.AccountSearchRequest;
import com.banking.banking.response.SuccessResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

public interface AccountControllerApi {

    @PostMapping
    ResponseEntity<SuccessResponse<AccountDto>> createAccount(@Valid @RequestBody AccountCreateRequest accountRequest);

    @GetMapping
    ResponseEntity<SuccessResponse<List<AccountDto>>> searchAccounts(@Valid @ModelAttribute AccountSearchRequest searchRequest);

    @DeleteMapping("/{id}")
    ResponseEntity<SuccessResponse<Void>> deleteAccount(@NotNull @PathVariable("id") UUID id);

    /*
    @PutMapping("/api/accounts/{id}")
    ResponseEntity<?> updateAccount(@PathVariable("id") Long id, @RequestBody AccountRequest accountRequest);



    // 5. View Account Details
    @GetMapping("/api/accounts/{id}")
    ResponseEntity<AccountDetailResponse> getAccountDetails(@PathVariable("id") Long id);*/
}


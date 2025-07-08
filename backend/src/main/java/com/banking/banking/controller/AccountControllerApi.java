package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.AccountCreateRequest;
import com.banking.banking.request.AccountSearchRequest;
import com.banking.banking.request.AccountUpdateRequest;
import com.banking.banking.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Account", description = "Operations related to accounts")
public interface AccountControllerApi {
    @Operation(summary = "Create a new account", description = "Creates an account with the given details")
    @PostMapping
    ResponseEntity<SuccessResponse<AccountDto>> createAccount(
            @Parameter(description = "Account creation request body", required = true)
            @Valid @RequestBody AccountCreateRequest accountRequest
    );

    @Operation(summary = "Search accounts", description = "Search for accounts matching the given criteria")
    @GetMapping
    ResponseEntity<SuccessResponse<List<AccountDto>>> searchAccounts(
            @Parameter(description = "Account search parameters")
            @Valid @ModelAttribute AccountSearchRequest searchRequest
    );

    @Operation(summary = "Delete an account by ID", description = "Deletes the account identified by the given UUID")
    @DeleteMapping("/{id}")
    ResponseEntity<SuccessResponse<Void>> deleteAccount(
            @Parameter(description = "UUID of the account to delete", required = true)
            @NotNull @PathVariable("id") UUID id
    );

    @Operation(summary = "Update an account by ID", description = "Updates the account information identified by the given UUID")
    @PutMapping("/{id}")
    ResponseEntity<SuccessResponse<Void>> updateAccount(
            @Parameter(description = "UUID of the account to update", required = true)
            @NotNull @PathVariable("id") UUID id,
            @Parameter(description = "Account update request body", required = true)
            @Valid @RequestBody AccountUpdateRequest accountUpdateRequest
    );
}


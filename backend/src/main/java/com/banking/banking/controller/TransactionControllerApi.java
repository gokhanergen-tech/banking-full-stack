package com.banking.banking.controller;

import com.banking.banking.dto.TransactionDto;
import com.banking.banking.request.TransactionRequest;
import com.banking.banking.response.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Transaction", description = "API for transaction operations")
public interface TransactionControllerApi {

    @Operation(summary = "Perform a transfer between accounts", description = "Transfers the specified amount from one account to another")
    @PostMapping("/transfer")
    ResponseEntity<SuccessResponse<Void>> transfer(
            @Parameter(description = "Details of the transaction to perform", required = true)
            @Valid @RequestBody TransactionRequest transactionRequest
    );

    @Operation(summary = "Get transactions for an account", description = "Retrieves all transactions related to the specified account ID")
    @GetMapping("/account/{accountId}")
    ResponseEntity<SuccessResponse<List<TransactionDto>>> transactions(
            @Parameter(description = "Account ID to retrieve transactions for", required = true)
            @NotBlank @PathVariable String accountId
    );
}
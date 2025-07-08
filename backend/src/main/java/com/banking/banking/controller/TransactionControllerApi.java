package com.banking.banking.controller;

import com.banking.banking.dto.TransactionDto;
import com.banking.banking.request.TransactionRequest;
import com.banking.banking.response.SuccessResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TransactionControllerApi {
    @PostMapping("/transfer")
    ResponseEntity<SuccessResponse<Void>> transfer(@Valid @RequestBody TransactionRequest transactionRequest);

    @GetMapping("/account/{accountId}")
    ResponseEntity<SuccessResponse<List<TransactionDto>>> transactions(@NotBlank @PathVariable String accountId);
}

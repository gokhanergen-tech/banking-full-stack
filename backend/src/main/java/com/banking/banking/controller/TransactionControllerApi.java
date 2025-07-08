package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.AccountCreateRequest;
import com.banking.banking.request.TransactionRequest;
import com.banking.banking.response.SuccessResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransactionControllerApi {
    @PostMapping("/transfer")
    ResponseEntity<SuccessResponse<Void>> transfer(@Valid @RequestBody TransactionRequest transactionRequest);
}

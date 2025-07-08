package com.banking.banking.controller;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.request.TransactionRequest;
import com.banking.banking.response.SuccessResponse;
import com.banking.banking.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController implements TransactionControllerApi{
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> transfer(TransactionRequest transactionRequest) {
        transactionService.transfer(transactionRequest);
        return null;
    }
}

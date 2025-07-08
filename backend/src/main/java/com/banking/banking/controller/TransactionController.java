package com.banking.banking.controller;

import com.banking.banking.dto.TransactionDto;
import com.banking.banking.request.TransactionRequest;
import com.banking.banking.response.SuccessResponse;
import com.banking.banking.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@Validated
public class TransactionController implements TransactionControllerApi {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<SuccessResponse<Void>> transfer(TransactionRequest transactionRequest) {
        transactionService.transfer(transactionRequest);
        return ResponseEntity.ok(new SuccessResponse<>(null, "Transferred successfully", HttpStatus.OK.value()));
    }

    @Override
    public ResponseEntity<SuccessResponse<List<TransactionDto>>> transactions(String accountId) {
        List<TransactionDto> transactions = transactionService.transactionsByAccountId(accountId);

        SuccessResponse<List<TransactionDto>> successResponse = new SuccessResponse<>(transactions, null, HttpStatus.OK.value());
        return ResponseEntity.ok(successResponse);
    }


}

package com.banking.banking.service;

import com.banking.banking.exceptions.custom.AccountNotFoundException;
import com.banking.banking.exceptions.custom.InsufficientBalanceException;
import com.banking.banking.model.Account;
import com.banking.banking.repositories.AccountRepository;
import com.banking.banking.request.TransactionRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void transfer(TransactionRequest transactionRequest) {
        Account sourceAccount = accountRepository.findByNumber(transactionRequest.getFrom())
                .orElseThrow(() -> new AccountNotFoundException("Source account not found"));
        Account targetAccount = accountRepository.findByNumber(transactionRequest.getTo())
                .orElseThrow(() -> new AccountNotFoundException("Target account not found"));

        if(sourceAccount==null)

        if (sourceAccount.getBalance().compareTo(transactionRequest.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(transactionRequest.getAmount()));
        targetAccount.setBalance(targetAccount.getBalance().add(transactionRequest.getAmount()));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }
}

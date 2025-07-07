package com.banking.banking.service;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.model.Account;
import com.banking.banking.repositories.AccountRepository;
import com.banking.banking.request.AccountRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = {Exception.class})
    public AccountDto create(AccountRequest accountRequest) {
        Account account = new Account();
        account.setName(accountRequest.getName());
        return null;

    }
}

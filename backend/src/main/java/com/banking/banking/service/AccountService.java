package com.banking.banking.service;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.exceptions.custom.AccountAlreadyExistException;
import com.banking.banking.exceptions.custom.UserAlreadyExistException;
import com.banking.banking.mapper.AccountMapper;
import com.banking.banking.model.Account;
import com.banking.banking.model.User;
import com.banking.banking.repositories.AccountRepository;
import com.banking.banking.request.AccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.banking.banking.utils.SecurityUtil.getCurrentUserAs;


@Service
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Transactional(rollbackFor = {Exception.class})
    public AccountDto create(AccountRequest accountRequest) {
        String accountName = accountRequest.getName();
        User authenticatedUser = getCurrentUserAs(User.class);
        if(accountRepository.existsByNameAndUserId(accountName, authenticatedUser.getId())){
            log.warn("Account creation failed: username '{}' is already taken.", accountName);
            throw new AccountAlreadyExistException("An account with the given details already exists.");
        }

        Account account = new Account();

        account.setName(accountName);
        account.setNumber(UUID.randomUUID().toString());
        account.setUser(authenticatedUser);

        accountRepository.save(account);
        return accountMapper.accountToDto(account);
    }
}

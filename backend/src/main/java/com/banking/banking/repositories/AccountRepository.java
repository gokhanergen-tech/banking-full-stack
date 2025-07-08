package com.banking.banking.repositories;

import com.banking.banking.dto.AccountDto;
import com.banking.banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    boolean existsByNameAndUserId(String accountName, UUID id);
    List<Account> findByUserIdAndNumberContainingAndNameContaining(UUID id, String number, String name);
    void deleteByIdAndUserId(UUID id, UUID userId);

    Optional<Account> findByNumber(String from);
}

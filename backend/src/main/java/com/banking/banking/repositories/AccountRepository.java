package com.banking.banking.repositories;

import com.banking.banking.model.Account;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    boolean existsByNameAndUserId(String accountName, UUID id);

    List<Account> findByUserIdAndNumberContainingAndNameContaining(UUID id, String number, String name);

    void deleteByIdAndUserId(UUID id, UUID userId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Account> findByNumber(String from);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Account> findByNumberAndUserId(String from, UUID id);

    boolean existsByIdAndUserId(UUID accountId, UUID userID);

    Account findByIdAndUserId(UUID id, UUID userId);
}

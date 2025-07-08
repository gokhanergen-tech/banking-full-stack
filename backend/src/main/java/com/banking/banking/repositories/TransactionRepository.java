package com.banking.banking.repositories;

import com.banking.banking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "select * from transactions where from_account_id=?1 or to_account_id=?1", nativeQuery = true)
    List<Transaction> findByAccountId(UUID accountId);
}

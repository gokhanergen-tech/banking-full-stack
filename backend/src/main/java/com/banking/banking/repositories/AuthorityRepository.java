package com.banking.banking.repositories;

import com.banking.banking.enums.RoleType;
import com.banking.banking.model.Authority;
import com.banking.banking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    boolean existsByAuthority(RoleType role);

    Authority findByAuthority(RoleType userRole);
}

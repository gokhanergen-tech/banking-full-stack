package com.banking.banking.repositories;

import com.banking.banking.enums.RoleType;
import com.banking.banking.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    boolean existsByAuthority(RoleType role);

    Authority findByAuthority(RoleType userRole);
}

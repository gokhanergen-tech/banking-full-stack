package com.banking.banking.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto {
    private String name;
    private String number;
    private BigDecimal balance;
    private LocalDateTime createdAt;
}

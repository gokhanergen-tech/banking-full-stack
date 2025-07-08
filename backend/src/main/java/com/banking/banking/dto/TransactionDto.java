package com.banking.banking.dto;

import com.banking.banking.enums.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDto {
    private Long id;
    private String fromNumber;
    private String toNumber;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private TransactionStatus status;
}
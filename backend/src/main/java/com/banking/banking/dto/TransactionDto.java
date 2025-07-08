package com.banking.banking.dto;

import com.banking.banking.enums.TransactionStatus;
import com.banking.banking.model.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

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
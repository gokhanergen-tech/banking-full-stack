package com.banking.banking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AccountDto {
    @JsonProperty("id")
    private UUID id;
    private String name;
    private String number;
    private BigDecimal balance;
    private LocalDateTime createdAt;
}

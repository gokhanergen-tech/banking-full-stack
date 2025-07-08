package com.banking.banking.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountSearchRequest {
    private String name;
    private String number;
}

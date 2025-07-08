package com.banking.banking.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequest {
    @NotBlank(message = "Account name cannot be blank")
    private String name;
}

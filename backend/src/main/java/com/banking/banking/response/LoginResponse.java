package com.banking.banking.response;

import com.banking.banking.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    @JsonProperty("user")
    private UserDto userDto;
}

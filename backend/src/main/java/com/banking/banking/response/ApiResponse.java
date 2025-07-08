package com.banking.banking.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private int status;
    private String message;

    public ApiResponse() {
    }

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}

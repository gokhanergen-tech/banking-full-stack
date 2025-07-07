package com.banking.banking.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse<T> extends ApiResponse {
    private String errorCode;
    private T details;

    public ErrorResponse(String errorCode, T details, String message, int status) {
        super(status,message);
        this.errorCode = errorCode;
        this.details = details;
    }
}

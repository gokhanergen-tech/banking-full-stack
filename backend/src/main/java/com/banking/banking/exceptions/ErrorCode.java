package com.banking.banking.exceptions;

public enum ErrorCode {
    VALIDATION_ERROR,
    AUTHENTICATION_FAILED,
    USER_ALREADY_EXISTS,
    RESOURCE_NOT_FOUND,
    INTERNAL_ERROR,
    ACCESS_DENIED,
    CONFLICT;

    public String getCode() {
        return this.name();
    }
}

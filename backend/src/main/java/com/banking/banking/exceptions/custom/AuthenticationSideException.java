package com.banking.banking.exceptions.custom;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationSideException extends AuthenticationException {
    public AuthenticationSideException(String msg) {
        super(msg);
    }
}

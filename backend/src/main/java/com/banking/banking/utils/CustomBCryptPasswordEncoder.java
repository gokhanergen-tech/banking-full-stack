package com.banking.banking.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomBCryptPasswordEncoder extends BCryptPasswordEncoder {
    @Value("${jwt.security.password_pepper}")
    private String pepper;

    public CustomBCryptPasswordEncoder(int strength) {
        super(strength);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return super.matches(pepper + rawPassword, encodedPassword);
    }

}

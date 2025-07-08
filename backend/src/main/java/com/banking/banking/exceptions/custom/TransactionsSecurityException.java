package com.banking.banking.exceptions.custom;

public class TransactionsSecurityException extends RuntimeException{
    public TransactionsSecurityException(String message){
        super(message);
    }
}

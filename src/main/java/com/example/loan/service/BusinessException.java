package com.example.loan.service;

public class BusinessException extends RuntimeException {
    public BusinessException(String message, Throwable exception) {
        super(message, exception);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable exception) {
        super(exception);
    }
}

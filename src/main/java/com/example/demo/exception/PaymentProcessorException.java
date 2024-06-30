package com.example.demo.exception;

public class PaymentProcessorException extends RuntimeException {
    public PaymentProcessorException(String message) {
        super(message);
    }
}

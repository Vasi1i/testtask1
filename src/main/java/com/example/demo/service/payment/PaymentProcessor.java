package com.example.demo.service.payment;

import java.math.BigDecimal;

public interface PaymentProcessor {
    boolean isPaymentSuccessful(BigDecimal amount) throws Exception;
}
package com.example.demo.service.payment;

import java.math.BigDecimal;

public interface PaymentProcessor {
    boolean isPaymentSuccess(BigDecimal amount) throws Exception;
}

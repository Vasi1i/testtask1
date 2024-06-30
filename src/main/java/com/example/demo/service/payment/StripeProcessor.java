package com.example.demo.service.payment;

import lombok.ToString;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@ToString
@Service("stripe")
public class StripeProcessor implements PaymentProcessor {
    @Override
    public boolean isPaymentSuccessful(BigDecimal amount) {
        return pay(bigDecimalToFloat(amount));
    }

    private boolean pay(Float amount) {
        int STRIPE_MIN_AMOUNT = 100;
        return amount >= STRIPE_MIN_AMOUNT;
    }

    private Float bigDecimalToFloat(BigDecimal amount) {
        return amount.floatValue();
    }
}
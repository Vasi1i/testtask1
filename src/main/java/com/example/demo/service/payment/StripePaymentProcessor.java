package com.example.demo.service.payment;

import java.math.BigDecimal;

import static com.example.demo.service.payment.Constants.*;

public class StripePaymentProcessor implements PaymentProcessor {
    @Override
    public boolean isPaymentSuccess(BigDecimal amount) {
        return pay(bigDecimalToFloat(amount));
    }

    private boolean pay(float amount) {
        return amount >= STRIPE_MIN_AMOUNT;
    }

    private float bigDecimalToFloat(BigDecimal amount) {
        return amount.floatValue();
    }
}

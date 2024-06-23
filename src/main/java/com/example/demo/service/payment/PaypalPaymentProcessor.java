package com.example.demo.service.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.example.demo.service.payment.Constants.*;

public class PaypalPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean isPaymentSuccess(BigDecimal amount) throws Exception {
        if (amount == null) {
            return false;
        }
        makePayment(bigDecimalToInt(amount));
        return true;
    }

    private void makePayment(int amount) throws Exception {
        if (amount > PAYPAL_MAX_AMOUNT) {
            throw new Exception("Amount exceeds the limit for Paypal");
        }
    }

    private int bigDecimalToInt(BigDecimal amount) {
        return amount.setScale(0, RoundingMode.CEILING).intValue();
    }
}
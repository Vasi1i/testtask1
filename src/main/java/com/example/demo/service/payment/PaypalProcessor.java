package com.example.demo.service.payment;

import com.example.demo.exception.PaymentProcessorException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service("paypal")
public class PaypalProcessor implements PaymentProcessor {
    @Override
    public boolean isPaymentSuccessful(BigDecimal amount) throws PaymentProcessorException {
        makePayment(bigDecimalToInt(amount));
        return true;
    }

    private void makePayment(Integer amount) throws PaymentProcessorException {
        int PAYPAL_LIMIT_AMOUNT = 100_000;
        if (amount > PAYPAL_LIMIT_AMOUNT) {
            throw new PaymentProcessorException("Amount exceeds the limit (" + PAYPAL_LIMIT_AMOUNT + ") for Paypal");
        }
    }

    private Integer bigDecimalToInt(BigDecimal amount) {
        return amount.setScale(0, RoundingMode.CEILING).intValue();
    }
}
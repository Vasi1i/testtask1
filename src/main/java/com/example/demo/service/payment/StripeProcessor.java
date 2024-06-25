package com.example.demo.service.payment;

import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@ToString
@Service("stripe")
public class StripeProcessor implements PaymentProcessor {
    private final int STRIPE_MIN_AMOUNT = 100;

    @Override
    public boolean isPaymentSuccessful(BigDecimal amount) {
        return pay(bigDecimalToFloat(amount));
    }

    private boolean pay(float amount) {
        return amount >= STRIPE_MIN_AMOUNT;
    }

    private float bigDecimalToFloat(BigDecimal amount) {
        return amount.floatValue();
    }
}

//    @Override
//    public String getProcessorName() {
//        return name;
//    }
//    private final String name;

//    public StripePaymentProcessor(@Value("${STRIPE.PAYMENT.NAME}") String name) {
//        this.name = name;
//    }
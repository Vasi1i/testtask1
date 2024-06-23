package com.example.demo.service.payment;

import static com.example.demo.service.payment.Constants.*;

public class PaymentProcessorFactory {
    public static PaymentProcessor getPaymentProcessor(String processorName) {
        return switch (processorName.toLowerCase()) {
            case PAYPAL_PROCESSOR -> new PaypalPaymentProcessor();
            case STRIPE_PROCESSOR -> new StripePaymentProcessor();
            default -> throw new IllegalArgumentException("Unknown payment processor: " + processorName);
        };
    }
}

package com.example.demo.validator;

import com.example.demo.annotation.KnownProcessor;
import com.example.demo.service.payment.PaymentProcessor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
public class PaymentProcessorValidator implements ConstraintValidator<KnownProcessor, String> {
    private final Map<String, PaymentProcessor> payments;
    @Override
    public boolean isValid(String paymentProcessor, ConstraintValidatorContext context) {
        return payments.containsKey(paymentProcessor);
    }

}
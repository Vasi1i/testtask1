package com.example.demo.controller.request;

import com.example.demo.service.payment.PaymentProcessor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class PaymentProcessorValidator implements ConstraintValidator<KnownProcessor, String> {
    private Map<String, PaymentProcessor> payments;
    @Override
    public boolean isValid(String paymentProcessor, ConstraintValidatorContext context) {
        if (paymentProcessor == null) {
            return false;
        }
        return payments.containsKey(paymentProcessor);
    }
}
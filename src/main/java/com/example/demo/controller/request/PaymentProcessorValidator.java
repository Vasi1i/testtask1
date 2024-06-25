package com.example.demo.controller.request;

import com.example.demo.service.payment.PaymentProcessor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class PaymentProcessorValidator implements ConstraintValidator<KnownProcessor, String> {

//    @Autowired
    private Map<String, PaymentProcessor> payments;

//    @Autowired
//    public PaymentProcessorValidator(Map<String, PaymentProcessor> payments) {
//        this.payments = payments;
//    }

//    @Override
//    public void initialize(KnownProcessor constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }

    @Override
    public boolean isValid(String paymentProcessor, ConstraintValidatorContext context) {
        System.out.println("payments PaymentProcessorValidator = " + payments);
        if (paymentProcessor == null) {
            return false;
        }
        return payments.containsKey(paymentProcessor);
    }

//    @Override
//    public boolean isValid(String paymentProcessor, ConstraintValidatorContext constraintValidatorContext) {
//        System.out.println("payments PaymentProcessorValidator = " + payments);
//       if (paymentProcessor == null) {
//           return false;
//       }
//       return true;
//    }
}

//    private Class<? extends PaymentProcessor> payments;

package com.example.demo.controller.request;

import com.example.demo.service.payment.PaymentProcessor;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {PaymentProcessorValidator.class})
@Target(FIELD)
@Retention(RUNTIME)
public @interface KnownProcessor {
    String message() default "Unknown payment processor";
//    Class<? extends PaymentProcessor> processorClass();
    //    PaymentProcessor paymentProcessor();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

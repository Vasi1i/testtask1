package com.example.demo.service.payment;

import java.math.BigDecimal;

public interface PaymentProcessor {
    boolean isPaymentSuccessful(BigDecimal amount) throws Exception;
}


//    private String name;

//    public PaymentProcessor() {
//        this.name = this.getClass().getSimpleName();
//    }

//    public String getProcessorName() {
//        return this.name;
//    }
    //public interface PaymentProcessor {


//    boolean isPaymentSuccess(BigDecimal amount) throws Exception;
//    String getProcessorName();


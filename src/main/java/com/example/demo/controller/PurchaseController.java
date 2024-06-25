package com.example.demo.controller;

import com.example.demo.controller.request.PurchaseRequest;
import com.example.demo.controller.response.PurchaseResponse;
import com.example.demo.service.payment.PaymentProcessor;
//import com.example.demo.service.payment.PaymentProcessorFactory;
import com.example.demo.service.pricing.PricingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@AllArgsConstructor
public class PurchaseController {
    private final PricingService pricingService;
    private final Map<String, PaymentProcessor> payments;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> makePurchase(@Valid @RequestBody PurchaseRequest purchaseRequest) throws Exception {
        System.out.println("payments makePurchase = " + payments);
        BigDecimal price = pricingService.calculatePrice(purchaseRequest);
        PaymentProcessor paymentProcessor = payments.get(purchaseRequest.getPaymentProcessor());
        System.out.println();
        return ResponseEntity.ok(new PurchaseResponse(paymentProcessor.isPaymentSuccessful(price)));
    }
}

//PurchaseResponse response = new PurchaseResponse(paymentProcessor.isPaymentSuccessful(price));
//PriceRequest priceRequest = PriceRequest.builder()
//        .product(purchaseRequest.getProduct())
//        .taxNumber(purchaseRequest.getTaxNumber())
//        .couponCode(purchaseRequest.getCouponCode()).build();
//    public PurchaseController(PricingService pricingService,
////                              @Qualifier("initPayments")
//                              Map<String, PaymentProcessor> payments) {
//        this.pricingService = pricingService;
//        this.payments = payments;
//    }
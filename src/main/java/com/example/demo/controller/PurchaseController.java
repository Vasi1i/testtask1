package com.example.demo.controller;

import com.example.demo.controller.request.PriceRequest;
import com.example.demo.controller.request.PurchaseRequest;
import com.example.demo.controller.response.PurchaseResponse;
import com.example.demo.service.payment.PaymentProcessor;
import com.example.demo.service.payment.PaymentProcessorFactory;
import com.example.demo.service.pricing.PricingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class PurchaseController {
    private final PricingService pricingService;

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(@Valid @RequestBody PurchaseRequest purchaseRequest) throws Exception {
            PriceRequest priceRequest = PriceRequest.builder()
                    .product(purchaseRequest.getProduct())
                    .taxNumber(purchaseRequest.getTaxNumber())
                    .couponCode(purchaseRequest.getCouponCode()).build();
            BigDecimal price = pricingService.calculatePrice(priceRequest);
            PaymentProcessor paymentProcessor = PaymentProcessorFactory.getPaymentProcessor(purchaseRequest.getPaymentProcessor());
            PurchaseResponse response = new PurchaseResponse(paymentProcessor.isPaymentSuccess(price));
            return ResponseEntity.ok(response);
    }
}
package com.example.demo.controller;

import com.example.demo.controller.dto.request.PurchaseRequest;
import com.example.demo.controller.dto.response.PriceResponse;
import com.example.demo.controller.dto.response.PurchaseResponse;
import com.example.demo.service.payment.PaymentProcessor;
import com.example.demo.service.pricing.PricingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
public class PurchaseController {
    private final PricingService pricingService;
    private final Map<String, PaymentProcessor> payments;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> makePurchase(@Valid @RequestBody PurchaseRequest request) throws Exception {
        PriceResponse priceResponse = pricingService.calculatePrice(request);
        boolean paymentSuccessful = payments.get(request.getPaymentProcessor()).isPaymentSuccessful(priceResponse.getFinalPrice());
        return ResponseEntity.ok(new PurchaseResponse(priceResponse, paymentSuccessful));
    }
}
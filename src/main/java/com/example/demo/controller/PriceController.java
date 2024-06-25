package com.example.demo.controller;

import com.example.demo.controller.request.PriceRequest;
import com.example.demo.controller.response.PriceResponse;
import com.example.demo.service.pricing.PricingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PriceController {
    private final PricingService pricingService;

    @PostMapping("/calculate-price")
    public ResponseEntity<PriceResponse> calculatePrice(@Valid @RequestBody PriceRequest request) {
        System.out.println("request = " + request);
            PriceResponse response = new PriceResponse(pricingService.calculatePrice(request));
            return ResponseEntity.ok(response);
    }
}
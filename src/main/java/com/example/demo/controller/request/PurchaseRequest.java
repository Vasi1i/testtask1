package com.example.demo.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class PurchaseRequest extends PriceRequest {
    @KnownProcessor
    private String paymentProcessor;
}
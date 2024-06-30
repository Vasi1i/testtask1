package com.example.demo.controller.dto.request;

import com.example.demo.annotation.KnownProcessor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class PurchaseRequest extends PriceRequest {
    @KnownProcessor
    private String paymentProcessor;
}
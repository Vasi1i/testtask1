package com.example.demo.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
public class PriceResponse {
    private Long productId;
    private String productName;
    private BigDecimal basePrice;
    private BigDecimal discountValue;
    private BigDecimal tax;
    private BigDecimal finalPrice;
    private String currency;
    private String countryCode;
    private String taxNumber;
    private String discountCode;
}
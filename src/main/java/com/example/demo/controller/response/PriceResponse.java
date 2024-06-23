package com.example.demo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class PriceResponse {
    private BigDecimal price;
}
